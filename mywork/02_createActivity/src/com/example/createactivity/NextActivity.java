package com.example.createactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;

public class NextActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		FragmentManager mng = getSupportFragmentManager();
		FragmentTransaction transaction = mng.beginTransaction();
		Fragment frag = MyFragment.newInstance();
		transaction.add(R.id.MyFragment, frag).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
		return true;
	}

}
