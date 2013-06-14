
package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	BookOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new BookOpenHelper(this);
        findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {
        // TODO:ここにinsert処理を実装してください
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues v = new ContentValues();
    	v.put(Book.COLUMN_NAME_BOOK_TITLE, "hoge");
    	v.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "foo");
    	v.put(Book.COLUMN_NAME_BOOK_PRICE, "1,000");
    	db.insert(Book.BOOK_TABLE_NAME, null, v);
    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
    	 SQLiteDatabase db = helper.getWritableDatabase();

         // 条件を指定
         String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
         String[] selectionArgs = {
                 "PRICE1"
         };
         int deletedCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);
         Log.v("Delete", Integer.toString(deletedCount));
    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
    	SQLiteDatabase db = helper.getWritableDatabase();

        // update情報を設定する
        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW_TITLE");

        // 条件を指定
        String where = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
        String[] whereArgs = {
                "TITLE%"
        };

        int updatedCount = db.update(Book.BOOK_TABLE_NAME, values, where, whereArgs);
        Log.v("Update", Integer.toString(updatedCount));
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
    	SQLiteDatabase db = helper.getReadableDatabase();
    	
    	String[] targetData = {
    			Book._ID,
    			Book.COLUMN_NAME_BOOK_TITLE,
    			Book.COLUMN_NAME_BOOK_PUBLISHER,
    			Book.COLUMN_NAME_BOOK_PRICE
    	};
    	
    	String where = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
    	String[] whereArgs = {
    			"1,000"
    	};
    	Cursor cursor = db.query(Book.BOOK_TABLE_NAME, targetData, where, whereArgs, null, null, null);
        boolean moveToFirst = cursor.moveToFirst();
        long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
        Log.v("Query", Long.toString(itemId));
        cursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
