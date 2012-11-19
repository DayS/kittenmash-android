package fr.lyonjug.kittenmash;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BestKittenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Button button = new Button(this);
		button.setText("Fight!");

		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.kitten_0);

		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.addView(button);
		linearLayout.addView(imageView);

		setContentView(linearLayout);
	}
}
