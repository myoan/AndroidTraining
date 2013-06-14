package com.example.htppurlconnectionsample;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class TaskLoader extends AsyncTaskLoader<String> {
    public static final String TAG = TaskLoader.class.getSimpleName();
    private String mCachedData;

    public TaskLoader(Context context) {
        super(context);
    }

    private String httpClientMethod() {
		HttpClient client = new DefaultHttpClient();
		String result = "";
		try {
			System.out.println("in LoadInBackGround");
			result = client.execute(new HttpGet("http://mixi.jp"), 
					new ResponseHandler<String>() {
					public String handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
							return EntityUtils.toString(response.getEntity());
						}
			});
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
    }

    private String httpURLConnectionMethod() throws IOException {
        URL url = new URL("http://mixi.jp");
        HttpURLConnection connection = null;
        StringBuilder src;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();

            src = new StringBuilder();
            while (true) {
                byte[] line = new byte[1024];
                int size = is.read(line);
                if (size <= 0)
                    break;
                src.append(new String(line, "euc-jp"));
            }
            return src.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            connection.disconnect();
        }
        return "";
    }

    // 非同期処理の中身
    @Override
    public String loadInBackground() {
    	String result = "";
    	try {
    		result = httpURLConnectionMethod();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return result;
    	//return httpClientMethod();

    }

    @Override
    public void deliverResult(String data) {
        // ローダがリセットされ、そのローダのライフサイクルが終了となる場合
        if (isReset()) {
            // キャッシュデータがある場合は、キャッシュを削除して、メモリから破棄可能にする
            if (mCachedData != null) {
                mCachedData = null;
            }
            return;
        }

        // 得られたデータをキャッシュする
        mCachedData = data;

        // ローダが開始されている場合、親にデータが得られたことを通知する
        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        // キャッシュがある場合はそちらを返す
        if (mCachedData != null) {
            deliverResult(mCachedData);
            return;
        }

        // データソースに変更があったり、キャッシュデータがない場合は loadInBackground() に行くようにする
        if (takeContentChanged() || mCachedData == null) {
            forceLoad();
        }
    }

    // ローダの非同期処理がストップする時のコールバック
    @Override
    protected void onStopLoading() {
        cancelLoad();
        super.onStopLoading();
    }

    // ローダがリセットされる時のコールバック
    @Override
    protected void onReset() {
        onStopLoading();
        super.onReset();
    }
}
