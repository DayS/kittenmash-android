package fr.lyonjug.kittenmash;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class BestKittenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.kitten_0);

		setContentView(imageView);
	}

}
