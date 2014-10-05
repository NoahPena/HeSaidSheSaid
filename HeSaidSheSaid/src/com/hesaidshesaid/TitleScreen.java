package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class TitleScreen extends Activity implements OnClickListener
{

	Button playButton;
	Button settingsButton;
	Button quitButton;
	
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.title_screen);
		
		GlobalVariables.settings = getSharedPreferences("UserInfo", 0);
		
		playButton = (Button)findViewById(R.id.playButton);
		settingsButton = (Button)findViewById(R.id.settingsButton);
		quitButton = (Button)findViewById(R.id.quitButton);
		
		GlobalVariables.gameOver = false;
		
		playButton.setOnClickListener(this);
		settingsButton.setOnClickListener(this);
		quitButton.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.playButton)
		{
			Intent intent = new Intent(this, HowManyPlayersScreen.class);
			startActivity(intent);
			finish();
		}
		
		if(v.getId() == R.id.settingsButton)
		{
			Intent intent = new Intent(this, SettingsScreen.class);
			startActivity(intent);
			finish();
		}
		
		if(v.getId() == R.id.quitButton)
		{
			//Intent intent = new Intent(getApplicationContext(), TitleScreen.class);
			//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			//intent.putExtra("EXIT", true);
			//startActivity(intent);
			
			finish();
		}
		
	}
}
