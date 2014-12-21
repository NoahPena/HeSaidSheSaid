package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TitleScreen extends Activity implements OnClickListener
{

	ImageButton playButton;
	ImageButton settingsButton;
	ImageButton quitButton;
	
	ImageView imageView;
	
	RelativeLayout relativeLayout;
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.title_screen);
		
		//SharedPreferences settings = getSharedPreferences("UserInfo", 0);
		//SharedPreferences.Editor editor = settings.edit();
		
		//editor.putString("GAMETYPE", "ROUNDS");
		//editor.commit();
		
		playButton = (ImageButton)findViewById(R.id.playButton);
		settingsButton = (ImageButton)findViewById(R.id.settingsButton);
		quitButton = (ImageButton)findViewById(R.id.quitButton);
		
		imageView = (ImageView)findViewById(R.id.imageView1);
		
		relativeLayout = (RelativeLayout)findViewById(R.id.titleScreenRelativeLayout);
		
		GlobalVariables.gameOver = false;
		
		playButton.setOnClickListener(this);
		settingsButton.setOnClickListener(this);
		quitButton.setOnClickListener(this);
		
		//Scale.scaleContents(playButton, relativeLayout);
		//Scale.scaleContents(settingsButton, relativeLayout);
		//Scale.scaleContents(quitButton, relativeLayout);
		//Scale.scaleContents(imageView, relativeLayout);
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
			Intent intent = new Intent(this, HowToPlayScreen.class);
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
