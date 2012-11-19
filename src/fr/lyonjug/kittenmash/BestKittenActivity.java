package fr.lyonjug.kittenmash;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class BestKittenActivity extends Activity {

	private int[] kittenResIds;

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

		kittenResIds = new int[] { R.drawable.kitten_0, //
				R.drawable.kitten_1, //
				R.drawable.kitten_2, //
				R.drawable.kitten_3, //
				R.drawable.kitten_4,//
				R.drawable.kitten_5, //
				R.drawable.kitten_6, //
				R.drawable.kitten_7, //
				R.drawable.kitten_8, //
				R.drawable.kitten_9 //
		};

	}

	protected void fight() {
		Intent intent = new Intent(this, KittenFightActivity.class);

		Random random = new Random();
		int kitten1 = kittenResIds[random.nextInt(kittenResIds.length)];
		int kitten2 = kittenResIds[random.nextInt(kittenResIds.length)];

		intent.putExtra(KittenFightActivity.KITTEN1_EXTRA, kitten1);
		intent.putExtra(KittenFightActivity.KITTEN2_EXTRA, kitten2);

		startActivity(intent);
	}
}
