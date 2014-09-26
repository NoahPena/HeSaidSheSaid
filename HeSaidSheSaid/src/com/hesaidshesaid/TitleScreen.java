package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		setContentView(R.layout.title_screen);
		
		playButton = (Button)findViewById(R.id.playButton);
		settingsButton = (Button)findViewById(R.id.settingsButton);
		quitButton = (Button)findViewById(R.id.quitButton);
		
		
		playButton.setOnClickListener(this);
		settingsButton.setOnClickListener(this);
		quitButton.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.playButton)
		{
			
		}
		
		if(v.getId() == R.id.settingsButton)
		{
			Intent intent = new Intent(this, SettingsScreen.class);
			startActivity(intent);
		}
		
		if(v.getId() == R.id.quitButton)
		{
			Intent intent = new Intent(getApplicationContext(), TitleScreen.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			startActivity(intent);
			
			if (getIntent().getBooleanExtra("EXIT", false)) {
			    finish();
			}
		}
		
	}
}
