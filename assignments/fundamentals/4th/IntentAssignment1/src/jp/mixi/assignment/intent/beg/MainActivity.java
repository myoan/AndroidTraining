
package jp.mixi.assignment.intent.beg;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.ViewMixi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO http://mixi.jp をブラウザで開くための Intent を作って、ブラウザを立ち上げる
            	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mixi.jp"));
            	startActivity(intent);
            }
        });
    }
}