package com.hesaidshesaid;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
		
		for(int i = 0; i < GlobalVariables.players.size(); i++)
		{
			if(!GlobalVariables.players.get(i).isPlayerHost())
			{
				GlobalVariables.playersAnswering.add(GlobalVariables.players.get(i));
			}
		}
		
		okPickHostButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKPickHost)
		{
			if(GlobalVariables.cardType != 0)
			{
				Intent intent = new Intent(this, AskQuestionScreen.class);
				startActivity(intent);
			} else {
				//choose question
				chooseQuestion();
				
				Intent intent = new Intent(this, DisplayQuestionScreen.class);
				startActivity(intent);
			}
		}
	}
	
	public void chooseQuestion()
	{
		Random random = new Random();
		
		GlobalVariables.currentQuestion = GlobalVariables.questionBank.get(random.nextInt(GlobalVariables.questionBank.size()));
	}

}
