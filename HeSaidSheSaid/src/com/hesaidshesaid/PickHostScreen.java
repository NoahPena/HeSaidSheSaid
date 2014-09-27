package com.hesaidshesaid;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PickHostScreen extends Activity implements OnClickListener {
	
	TextView playerTextView;
	
	Button okPickHostButton;
	
	public void onCreate(Bundle bundledInstance)
	{
		super.onCreate(bundledInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pick_host_screen);
		
		playerTextView = (TextView)findViewById(R.id.textViewPlayer);
		
		okPickHostButton = (Button)findViewById(R.id.buttonOKPickHost);
		
		Random randomGenerator = new Random();
		
		int randomInt = randomGenerator.nextInt(GlobalVariables.amountOfPlayers);
		
		GlobalVariables.host = GlobalVariables.players.get(randomInt);
		
		playerTextView.setText(GlobalVariables.host.getPlayerName());
		
		okPickHostButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
