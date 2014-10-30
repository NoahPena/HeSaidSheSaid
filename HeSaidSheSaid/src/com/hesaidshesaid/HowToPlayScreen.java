package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class HowToPlayScreen extends Activity implements OnClickListener {
	
	Button okHowToPlay;
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.how_to_play_screen);
		
		okHowToPlay = (Button)findViewById(R.id.buttonOkHowToPlay);
		
		okHowToPlay.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOkHowToPlay)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}

}
