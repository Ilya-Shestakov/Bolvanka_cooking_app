//package com.example.bolvanka;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "items.db";
//    private static final int DATABASE_VERSION = 1;
//    public static final String TABLE_ITEMS = "items";
//    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_COUNTER = "counter";
//    public static final String COLUMN_IMAGE_ID = "image_id";
//
//    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE " + TABLE_ITEMS + "(" +
//            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//            COLUMN_NAME + " TEXT," +
//            COLUMN_COUNTER + " INTEGER," +
//            COLUMN_IMAGE_ID + " INTEGER" + ")";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_ITEMS);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
//        onCreate(db);
//    }
//
//    public long insertItem(ItemModel item) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, item.getName());
//        values.put(COLUMN_COUNTER, item.getCounter());
//        values.put(COLUMN_IMAGE_ID, item.getImageResId());
//
//        long id = db.insert(TABLE_ITEMS, null, values);
//        db.close();
//        return id;
//    }
//
//    public List<ItemModel> getAllItems() {
//        List<ItemModel> items = new ArrayList<>();
//        String selectQuery = "SELECT * FROM " + TABLE_ITEMS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
//                String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
//                int counter = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_COUNTER));
//                int imageId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_ID));
//
//                ItemModel item = new ItemModel(id, name, counter, imageId);
//                items.add(item);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return items;
//    }
//
//    public int updateItem(ItemModel item) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, item.getName());
//        values.put(COLUMN_COUNTER, item.getCounter());
//        values.put(COLUMN_IMAGE_ID, item.getImageResId());
//
//        int rowsAffected = db.update(TABLE_ITEMS, values, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(item.getId())});
//        db.close();
//        return rowsAffected;
//    }
//}