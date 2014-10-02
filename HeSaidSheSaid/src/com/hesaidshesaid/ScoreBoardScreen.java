package com.hesaidshesaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class ScoreBoardScreen extends Activity implements OnClickListener {
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.score_board_screen);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
