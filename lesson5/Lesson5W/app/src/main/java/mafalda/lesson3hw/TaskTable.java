package mafalda.lesson3hw;

import android.provider.BaseColumns;

/**
 * Created by mafaldaborges on 9/21/16.
 * Creates a table for data to be saved to using SQLite
 */
public class TaskTable {
    private TaskTable(){}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "task_table";
        public static final String COLUMN_NAME_TASK = "task";
        public static final String COLUMN_NAME_COMPLETE = "completed";

        public static final String TEXT_TYPE = " TEXT";
        public static final String INT_TYPE = " INTEGER";
        public static final String COMMA_SEP = ",";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_TASK + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_COMPLETE + INT_TYPE + " )";
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}