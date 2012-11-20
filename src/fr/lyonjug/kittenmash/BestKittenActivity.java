package fr.lyonjug.kittenmash;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OnActivityResult;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_best_kitten)
public class BestKittenActivity extends Activity {

	private static final int FIGHT_REQUEST_CODE = 1;
	private int[] kittenResIds;

	@ViewById
	ImageView catImageView;

	@Pref
	KittenPrefs_ kittenPrefs;

	@AfterViews
	void afterViews() {
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

		loadWinningCat();
	}

	@Click(R.id.fightButton)
	protected void fight() {
		Random random = new Random();
		int kitten1 = kittenResIds[random.nextInt(kittenResIds.length)];
		int kitten2 = kittenResIds[random.nextInt(kittenResIds.length)];

		KittenFightActivity_.intent(this) //
				.kitten1(kitten1) //
				.kitten2(kitten2) //
				.startForResult(FIGHT_REQUEST_CODE);
	}

	@OnActivityResult(FIGHT_REQUEST_CODE)
	protected void onActivityResult(int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			int winExtra = data.getIntExtra(KittenFightActivity.WIN_EXTRA,
					R.drawable.kitten_0);
			saveWinningCat(winExtra);
			catImageView.setImageResource(winExtra);
		}
	}

	@Background
	void saveWinningCat(final int winningCat) {
		kittenPrefs.edit().winningCat().put(winningCat).apply();
	}

	@Background
	void loadWinningCat() {
		int winningCat = kittenPrefs.winningCat().get();
		updateWinningCat(winningCat);
	}

	@UiThread
	void updateWinningCat(final int winningCat) {
		catImageView.setImageResource(winningCat);
	}
}
