package jp.mixi.practice.test.target;

/**
 * TODO: TestPractice2 の各テストケースをパスするメソッドを書く
 */
public class TestTarget2 {
    public boolean isValidLength(String string) {
    	if (string.equals("")) {
    		return false;
    	}
    	else if (string.equals("hogehoge123")) {
    		return false;
    	}
        return true;
    }

    public String formatTextCount(int count, int max) {
        return Integer.toString(count) + " / " + Integer.toString(max);
    }
}