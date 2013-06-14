package com.example.stringresource1;
import android.widget.TextView;
import android.view.View;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("enter onCreate()!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("hello, test");
		String fmt = getString(R.string.str6);
		String result = String.format(fmt, "‰Î");
		TextView view = (TextView)findViewById(R.id.ja_label6);
		view.setText(result);
		System.out.println(String.format(fmt, "‰Î"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
