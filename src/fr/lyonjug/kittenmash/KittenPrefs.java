package fr.lyonjug.kittenmash;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultInt;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface KittenPrefs {

	@DefaultInt(R.drawable.kitten_0)
	int winningCat();

}
