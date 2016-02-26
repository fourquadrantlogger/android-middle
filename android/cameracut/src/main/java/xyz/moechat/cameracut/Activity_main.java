package xyz.moechat.cameracut;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class Activity_main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }
    ImageView imageView_photo;
    Button button_select;
    Uri uri_photo;
    public static final int RequestCode_TAKEPHOTO=1;
    public static final int RequestCode_CROPPHOTO=2;
    void initViews(){
        imageView_photo =(ImageView)findViewById(R.id.imageView_photo);
        button_select=(Button)findViewById(R.id.button_select);

        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file_photo=new File(Environment.getExternalStorageDirectory(),"photo.jpg");
                try{
                    if(file_photo.exists()){
                        file_photo.delete();
                    }
                    file_photo.createNewFile();
                }catch (Exception e){
                    e.printStackTrace();
                }
                uri_photo=Uri.fromFile(file_photo);

                Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri_photo);
                startActivityForResult(intent,RequestCode_TAKEPHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case RequestCode_TAKEPHOTO:{
                if(resultCode==RESULT_OK){
                    Intent intent=new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(uri_photo,"image/*");
                    intent.putExtra("scale",true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,uri_photo);
                    startActivityForResult(intent,RequestCode_CROPPHOTO);
                }
            }
            case RequestCode_CROPPHOTO:{
                if(resultCode==RESULT_OK){
                    try{
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(uri_photo));
                        imageView_photo.setImageBitmap(bitmap);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
