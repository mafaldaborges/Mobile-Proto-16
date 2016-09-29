package mafalda.lesson3hw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.StringBuilderPrinter;

import java.util.ArrayList;

/**
 * Created by mafaldaborges on 9/21/16.
 */
public class TaskDbHelper extends SQLiteOpenHelper{

    /**Creates methods for data to be saved to the TaskTable*/




    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDoTable.db";

    public TaskDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(TaskTable.FeedEntry.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(TaskTable.FeedEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addToDb(ToDoItem task){
        /**Adds items to the TaskTable*/
        SQLiteDatabase dbw = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskTable.FeedEntry.COLUMN_NAME_TASK, task.name);
        values.put(TaskTable.FeedEntry.COLUMN_NAME_COMPLETE,task.complete);
        long newRowId = dbw.insert(TaskTable.FeedEntry.TABLE_NAME, null, values);

    }

    public void deleteRow(ToDoItem task){
        /**Deletes items in the TaskTable*/
        SQLiteDatabase dbw = this.getWritableDatabase();
        String selection = TaskTable.FeedEntry._ID + " =?";
        String[] selectionArgs = {String.valueOf(task.getId())};
        Log.d("Checking delete", "Can you see me?");
        dbw.delete(TaskTable.FeedEntry.TABLE_NAME, selection, selectionArgs);
        Log.d("Check delete 2", "After deletion");
        dbw.close();
    }



    public ArrayList<ToDoItem> getAll(){
        /**Gets all items in the TaskTable and returns and array*/
        SQLiteDatabase dbr = this.getReadableDatabase();
        ArrayList<ToDoItem> taskArray = new ArrayList<>();
        Cursor c = dbr.rawQuery("select * from " + TaskTable.FeedEntry.TABLE_NAME, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            long readID = c.getLong(0);
            String readName = c.getString(1);
            int readStatus = c.getInt(2);
            ToDoItem task = new ToDoItem(readName, readStatus);
            task.setId(readID);
            taskArray.add(task);

            c.moveToNext();


        }

        dbr.close();
        return taskArray;
    }

    public void updateArray(long id, ToDoItem task){
        /**Updates an array when data is edited*/
        SQLiteDatabase dbw = this.getReadableDatabase();


        ContentValues values = new ContentValues();
        values.put(TaskTable.FeedEntry.COLUMN_NAME_TASK, task.name);
        values.put(TaskTable.FeedEntry.COLUMN_NAME_COMPLETE,task.complete);

        String selection = TaskTable.FeedEntry._ID + " Like ?";
        String[] selectionArgs = {Long.toString(id)};

        dbw.update(TaskTable.FeedEntry.TABLE_NAME, values, selection, selectionArgs);

    }




}
