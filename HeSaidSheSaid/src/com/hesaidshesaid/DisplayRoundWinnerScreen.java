package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DisplayRoundWinnerScreen extends Activity implements OnClickListener {
	
	Button buttonQuitRoundWinner;
	Button buttonNextRound;
	
	TextView textViewRoundWinner;
	
	public void onCreate(Bundle instanceBundle)
	{
		super.onCreate(instanceBundle);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.display_round_winner_screen);
		
		buttonQuitRoundWinner = (Button)findViewById(R.id.buttonQuitRoundWinner);
		buttonNextRound = (Button)findViewById(R.id.buttonNextRound);
		
		textViewRoundWinner = (TextView)findViewById(R.id.textViewRoundWinner);
		
		textViewRoundWinner.setText(GlobalVariables.currentWinner.getPlayerName());
		GlobalVariables.currentWinner.addPoint();
		
		buttonQuitRoundWinner.setOnClickListener(this);
		buttonNextRound.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonNextRound)
		{
			for(int i = 0; i < GlobalVariables.players.size(); i++)
			{
				GlobalVariables.players.get(i).resetPlayer();
			}
			
			GlobalVariables.playersAnswering.clear();
			
			GlobalVariables.bestAnswer = "";
			GlobalVariables.currentRound++;
			GlobalVariables.currentCounter = -1;
			
			
			
			if(GlobalVariables.gameType == 0 && (GlobalVariables.currentRound == GlobalVariables.maxRounds))
			{
				//End game
				int maxPoints = 0;
				
				for(int i = 0; i < GlobalVariables.players.size(); i++)
				{
					if(GlobalVariables.players.get(i).getPlayerScore() > maxPoints)
					{
						maxPoints = GlobalVariables.players.get(i).getPlayerScore();
					}
				}
				
				for(int i = 0; i < GlobalVariables.players.size(); i++)
				{
					if(GlobalVariables.players.get(i).getPlayerScore() == maxPoints)
					{
						GlobalVariables.winningPlayers.add(GlobalVariables.players.get(i));
					}
				}
				
				Intent intent = new Intent(this, WinningScreen.class);
				startActivity(intent);
				finish();
			} else if(GlobalVariables.gameType == 1 && (GlobalVariables.currentWinner.getPlayerScore() == GlobalVariables.maxPoints))
			{
				//End game
				for(int i = 0; i < GlobalVariables.players.size(); i++)
				{
					if(GlobalVariables.players.get(i).getPlayerScore() == GlobalVariables.maxPoints)
					{
						GlobalVariables.winningPlayers.add(GlobalVariables.players.get(i));
					}
				}
				
				Intent intent = new Intent(this, WinningScreen.class);
				startActivity(intent);
				finish();
			} else {
			
			Intent intent = new Intent(this, PickHostScreen.class);
			startActivity(intent);
			finish();
			}
		} 
		
		if(v.getId() == R.id.buttonQuitRoundWinner)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}

}
