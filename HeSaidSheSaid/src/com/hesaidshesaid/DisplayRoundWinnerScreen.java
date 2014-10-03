package com.hesaidshesaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class DisplayRoundWinnerScreen extends Activity implements OnClickListener {
	
	public void onCreate(Bundle instanceBundle)
	{
		super.onCreate(instanceBundle);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.display_round_winner_screen);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
