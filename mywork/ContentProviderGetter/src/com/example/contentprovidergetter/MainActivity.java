package com.example.contentprovidergetter;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	final static String ExternalUri ="jp.mixi.sample.contentprovider.Book/book";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	      Uri uri = Uri.parse("content://" + ExternalUri);
	      Cursor cursor = getContentResolver().query(uri, null, null, null, null);
	      Log.d("mySystem", "start");
	      while (cursor.moveToNext()) {
	          Log.d("ExternalContentProvider", "call:" + cursor.getString(cursor.getColumnIndexOrThrow("title")));
	      }
	      Log.d("mySystem", "end");
	      // ˆ—‚ªŠ®—¹‚µ‚½‚çCursor‚ğ•Â‚¶‚Ü‚·
	      cursor.close();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
