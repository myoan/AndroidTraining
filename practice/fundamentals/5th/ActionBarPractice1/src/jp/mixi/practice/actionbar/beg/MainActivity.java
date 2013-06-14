
package jp.mixi.practice.actionbar.beg;

import jp.mixi.practice.actionbar.sherlock.R;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity implements TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // �^�u�i�r�Q�[�V�������[�h�ɐݒ�
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // �^�u���쐬���Ēǉ��B�^�u�̑I���E�����E�đI�����n���h�����O����R�[���o�b�N�� TabListener ���Z�b�g���Ȃ��Ǝ��s����O�ŃN���b�V������
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab1").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab2").setTabListener(this));
        getSupportActionBar().addTab(getSupportActionBar().newTab().setText("Tab3").setTabListener(this));
        

    }

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
}
