package xyz.moechat.sqlitedoing.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import xyz.moechat.sqlitedoing.model.Project;
import xyz.moechat.sqlitedoing.model.Student;

/**
 * Created by timeloveboy on 16/2/20.
 */
public class Sqlitehelper extends SQLiteOpenHelper {
    public Sqlitehelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }
    static final String CREATE_Project="create table project ("+
            "id integer primary key autoincrement,"+
            "stuid integer,"+
            "projectname text,"+
            "score integer)";
    static final String CREATE_Student="create table student ("+
            "id integer primary key autoincrement,"+
            "stuid integer,"+
            "name text)";
    Context context;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Student);
        db.execSQL(CREATE_Project);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists project");
        db.execSQL("drop table if exists student");
        onCreate(db);
    }
    public void Studentadd(Student student){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("stuid", student.getSduid());
        contentValues.put("name", student.getName());
        db.insert("student", null, contentValues);
    }
    public List<Student> studentquery(int stuid,String stuname,String projectname,String score){
        List<Student> studentscoresList=new ArrayList<Student>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor = db.query("student",new String[]{"id", "stuid","name"},"stuid=?", new String[]{Integer.toString(stuid)},null, null, null);
        //遍历每一个记录
        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));//返回列名为name的值
            System.out.println("query---->" + name);
        }
        return studentscoresList;
    }

    public List<Student> studentquery(int stuid,String name){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=getReadableDatabase();

        String SQL_SELECT="SELECT stuid,name FROM student WHERE id="+Integer.toString(stuid)+" AND name='"+name+"'";
        Cursor cursor = db.rawQuery(SQL_SELECT, null);
        //遍历每一个记录
        while(cursor.moveToNext()) {
            Student student=new Student();

            student.setSduid(cursor.getInt(cursor.getColumnIndex("stuid")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));

            students.add(student);
        }
        return students;
    }
    public List<Student> studentquery(String name){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=getReadableDatabase();

        String SQL_SELECT="SELECT stuid,name FROM student WHERE name='"+name+"'";
        Cursor cursor = db.rawQuery(SQL_SELECT,null);
        //遍历每一个记录
        while(cursor.moveToNext()) {
            Student student=new Student();

            student.setSduid(cursor.getInt(cursor.getColumnIndex("stuid")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));

            students.add(student);
        }
        return students;
    }
    public List<Student> studentquery(int stuid){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=getReadableDatabase();

        String SQL_SELECT="SELECT stuid,name FROM student WHERE id="+Integer.toString(stuid);
        Cursor cursor = db.rawQuery(SQL_SELECT,null);
        //遍历每一个记录
        while(cursor.moveToNext()) {
            Student student=new Student();

            student.setSduid(cursor.getInt(cursor.getColumnIndex("stuid")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));

            students.add(student);
        }
        return students;
    }
    public List<Student> studentquery(){
        List<Student> students=new ArrayList<Student>();
        SQLiteDatabase db=getReadableDatabase();

        String SQL_SELECT="SELECT stuid,name FROM student";
        Cursor cursor = db.rawQuery(SQL_SELECT,null);
        //遍历每一个记录
        while(cursor.moveToNext()) {
            Student student=new Student();

            student.setSduid(cursor.getInt(cursor.getColumnIndex("stuid")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));

            students.add(student);
        }
        return students;
    }
    public void Projectadd(int stuid,Project project){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("stuid",stuid);
        contentValues.put("projectname",project.getProjectname());
        contentValues.put("score", project.getScore());
        db.insert("project",null,contentValues);
    }
}
