
package jp.mixi.assignment.intent.med;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.CallActivityForResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(MainActivity.this, EditActivity.class);
            	//startActivity(intent);
            	startActivityForResult(intent, EditActivity.REQUEST_CODE_HOGE);
                // TODO EditText と ボタンを 1 つずつ持つ新しい Activity を呼び出し、ボタンを押した時に結果を返すように実装する
                // TODO 返ってきた結果を Toast で表示するところも実装すること
            	
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(int, int, Intent) の呼び出しは、条件に関係なくすること
        // Fragment から startActivityForResult(Intent, int) した場合の戻りの判定ができなくなってしまう
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode には、startActivityForResult(Intent, int) の第 2 引数で指定したものが来る
        // resultCode には、呼び出し先で　setResult(int, Intent) をコールした時の第 1 引数が来る
        // data には、呼び出し先で　setResult(int, Intent) をコールした時の第 2 引数が来る 
        if (requestCode == EditActivity.REQUEST_CODE_HOGE) {
        	System.out.println(data.getData().toString());
        }
    }
}