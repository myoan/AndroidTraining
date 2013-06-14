package jp.mixi.practice.test.target.test;

import jp.mixi.practice.test.target.SubActivity;
import jp.mixi.practice.test.target.TestTarget1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

public class TestTarget1TestCase extends AndroidTestCase {
	private TestTarget1 target;
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		target = new TestTarget1();
	}
	@Override
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	public void testStartSubActivity() throws Exception {
		target.startSubActivity(new TestTarget1Context(getContext()), "hoge");
	}
	public void testIsValidIntentHasNoExtra() throws Exception {
        Intent intent = new Intent(getContext(), SubActivity.class);
        intent.setData(Uri.parse("http://mixi.jp"));
        assertFalse(intent.hasExtra("title"));
        assertFalse(target.isValidIntent(intent));
	}
	private static class TestTarget1Context extends MockContext {
		private Context mContext;
		
		public TestTarget1Context(Context baseContext) {
			mContext = baseContext;
		}
		@Override
		public String getPackageName() {
			return mContext.getPackageName();
		}
		@Override
		public void startActivity(Intent intent) {
			ComponentName component = intent.getComponent();
			assertEquals(SubActivity.class.getCanonicalName(), component.getClassName());
			
			assertTrue(intent.hasExtra(intent.EXTRA_SUBJECT));
			assertEquals("hoge", intent.getStringExtra(intent.EXTRA_SUBJECT));
		}
	}
}
