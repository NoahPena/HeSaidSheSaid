package com.hesaidshesaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TitleScreen extends Activity implements OnClickListener
{

	Button playButton = (Button)findViewById(R.id.playButton);
	Button settingsButton = (Button)findViewById(R.id.settingsButton);
	Button quitButton = (Button)findViewById(R.id.quitButton);
	
	TextView heSaidText = (TextView)findViewById(R.id.heSaidText);
	TextView sheSaidText = (TextView)findViewById(R.id.sheSaidText);
	
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.title_screen);
		
		
		
		
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
			
		}
		
		if(v.getId() == R.id.quitButton)
		{
			
		}
	}
}
