package fr.lyonjug.kittenmash;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.Extra;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_kitten_fight)
public class KittenFightActivity extends Activity {

	public static final String WIN_EXTRA = "win";
	public static final String KITTEN2_EXTRA = "kitten2";
	public static final String KITTEN1_EXTRA = "kitten1";

	@Extra(KITTEN1_EXTRA)
	int kitten1;

	@Extra(KITTEN2_EXTRA)
	int kitten2;

	@ViewById
	ImageView cat1ImageView;

	@ViewById
	ImageView cat2ImageView;

	@AfterViews
	void afterViews() {
		cat1ImageView.setImageResource(kitten1);
		cat2ImageView.setImageResource(kitten2);
	}

	@Click
	protected void cat1ImageViewClicked() {
		Intent data = new Intent();
		data.putExtra(WIN_EXTRA, kitten1);
		setResult(RESULT_OK, data);
		finish();
	}

	@Click
	protected void cat2ImageViewClicked() {
		Intent data = new Intent();
		data.putExtra(WIN_EXTRA, kitten2);
		setResult(RESULT_OK, data);
		finish();
	}

}
