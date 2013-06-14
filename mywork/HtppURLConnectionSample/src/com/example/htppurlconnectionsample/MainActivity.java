package com.example.htppurlconnectionsample;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements LoaderCallbacks<String> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		System.out.println("hogehoge");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        // ローダの管理をするオブジェクト
        LoaderManager manager = getSupportLoaderManager();
        Bundle argsForLoader = new Bundle();
        // ローダを初期化して非同期処理を開始する
        manager.initLoader(0, argsForLoader, MainActivity.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


    // id に対応した Loader のインスタンスを作って返す
    // args は Loader に渡したい引数を Bundle に詰めたもの
    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case 0:
                return new TaskLoader(this);
            default:
                return null;
        }
    }

    // 結果を受け取るコールバック
    // メインスレッドで動作する
    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
    	TextView label = (TextView)findViewById(R.id.Label);
    	label.setText(result);
    }

    // ローダがリセットされる時のコールバック
    @Override
    public void onLoaderReset(Loader<String> loader) {}
}
