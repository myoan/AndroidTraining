
package jp.mixi.assignment.sqlite.beg;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    MySQLiteOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        helper = new MySQLiteOpenHelper(this);
        insert();
        query();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO:独自SQLiteOpenHelperの作成、それに使用するカラム名などの定義
        // TODO:insert処理、query処理の実装
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void insert() {
    	Log.v("Insert", "Enter");
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues cv = new ContentValues();
    	cv.put("_id", "1");
    	cv.put("name", "hoge");
    	cv.put("version", "1.0");
    	db.insert("practice", null, cv);
    }
    public void query() {
    	Log.v("Query", "Enter");
    	SQLiteDatabase db = helper.getReadableDatabase();
    	String[] targets = {
    		"_id", "name", "version"
    	};
    	String where = "name = ?";
    	String[] whereArgs = {
    		"hoge"
    	};
    	db.query("practice", targets, where, whereArgs, null, null, null);
    }
}
