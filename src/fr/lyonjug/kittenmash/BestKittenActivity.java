package fr.lyonjug.kittenmash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class BestKittenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_best_kitten);

		findViewById(R.id.fightButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fight();
			}
		});

	}

	protected void fight() {
		Intent intent = new Intent(this, KittenFightActivity.class);

		intent.putExtra(KittenFightActivity.KITTEN1_EXTRA, R.drawable.kitten_0);
		intent.putExtra(KittenFightActivity.KITTEN2_EXTRA, R.drawable.kitten_1);

		startActivity(intent);
	}
}
