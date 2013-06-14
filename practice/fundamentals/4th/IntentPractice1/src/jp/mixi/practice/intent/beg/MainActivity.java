
package jp.mixi.practice.intent.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button1 = findViewById(R.id.CallActivity1);
        View button2 = findViewById(R.id.CallActivity2);
        View button3 = findViewById(R.id.CallActivity3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、NewActivity1 を呼び出す処理を書く
                System.out.println("hello, NewActivity1");

                // メッセージのオブジェクトとして Intent を作る
                // どの Context から、どのクラスに対してメッセージを送るかを指定する
                Intent intent = new Intent(MainActivity.this, HogeActivity.class);
                // Intent を Context に渡して、メッセージを送る
                // この場合、NextActivity クラスにメッセージが送られ、NextActivity が立ち上がる
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、NewActivity2 を呼び出す処理を書く
                // TODO NewActivity2 は、toast_message をキーとした Extra のデータを必要としているので、適宜 Intent に含めること

            	// メッセージのオブジェクトとして Intent を作る
                // どの Context から、どのクラスに対してメッセージを送るかを指定する
                Intent intent = new Intent(MainActivity.this, NewActivity2.class);
                intent.putExtra("toast_message", "hello, NewActivity2!");
                // Intent を Context に渡して、メッセージを送る
                // この場合、NextActivity クラスにメッセージが送られ、NextActivity が立ち上がる
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、NewActivity3 を呼び出す処理を書く
                // TODO Intent に、Intent.FLAG_ACTIVITY_NO_HISTORY という flag をセットするとどうなるかレポートすること

            	// メッセージのオブジェクトとして Intent を作る
                // どの Context から、どのクラスに対してメッセージを送るかを指定する
                Intent intent = new Intent(MainActivity.this, NewActivity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                // Intent を Context に渡して、メッセージを送る
                // この場合、NextActivity クラスにメッセージが送られ、NextActivity が立ち上がる
                startActivity(intent);
            }
        });
    }
}