package xyz.moechat.choosephoto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }
    ImageView imageView_photo;
    Button button_select;

    public static final int RequestCode_CHOOSEPHOTO=1;

    void initViews(){
        imageView_photo =(ImageView)findViewById(R.id.imageView_photo);
        button_select=(Button)findViewById(R.id.button_select);

        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(intent, RequestCode_CHOOSEPHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case RequestCode_CHOOSEPHOTO:{
                if(resultCode==RESULT_OK){
                    if(Build.VERSION.SDK_INT>=19){
                        //android 4.4 及以上系统，使用这个方法
                        handleImage_SDK19(data);
                    }
                    else {
                        //android 4.4 及以上系统，使用这个方法
                        handleImage_SDKbefore19(data);
                    }
                }
            }

        }
    }

    private void handleImage_SDK19(Intent data) {
        Log.v("moe",data.toString());
        String imagepath=null;
        Uri uri=data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)){
            String docId=DocumentsContract.getDocumentId(uri);
            if(uri.getAuthority().equals("com.android.providers.media.documents")){
                String id=docId.split(":")[1];
                String selection=MediaStore.Images.Media._ID+"="+id;
                imagepath=getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }
        }
        else if(uri.getScheme().equals("file")) {
            Log.v("moe", Environment.getExternalStorageDirectory().toString());
            imagepath=(uri.toString()).substring(7);
        }
        displayImage(imagepath);
    }

    private void displayImage(String imagepath) {
        if(imagepath!=null){
            Bitmap bitmap=BitmapFactory.decodeFile(imagepath);
            imageView_photo.setImageBitmap(bitmap);
        }
    }

    private String getImagePath(Uri uri,String selection) {
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,selection,null,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void handleImage_SDKbefore19(Intent data){
        Log.v("moe",data.toString());
    }
}
