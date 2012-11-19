package fr.lyonjug.kittenmash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class KittenFightActivity extends Activity {

	public static final String KITTEN2_EXTRA = "kitten2";
	public static final String KITTEN1_EXTRA = "kitten1";
	private int kitten1;
	private int kitten2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();

		kitten1 = intent.getIntExtra(KITTEN1_EXTRA, R.drawable.kitten_0);
		kitten2 = intent.getIntExtra(KITTEN2_EXTRA, R.drawable.kitten_0);

		setContentView(R.layout.activity_kitten_fight);

		ImageView cat1ImageView = (ImageView) findViewById(R.id.cat1ImageView);
		ImageView cat2ImageView = (ImageView) findViewById(R.id.cat2ImageView);

		cat1ImageView.setImageResource(kitten1);
		cat2ImageView.setImageResource(kitten2);
	}

}
