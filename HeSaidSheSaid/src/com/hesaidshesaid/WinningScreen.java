package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class WinningScreen extends Activity implements OnClickListener {
	
	Button buttonScoreBoardWinning;
	Button buttonMainMenuWinning;
	
	TextView textViewWinning;
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.winning_screen);
		
		textViewWinning = (TextView)findViewById(R.id.textViewTheWinner);
		
		buttonScoreBoardWinning = (Button)findViewById(R.id.buttonScoreBoardWinningScreen);
		buttonMainMenuWinning = (Button)findViewById(R.id.buttonMainMenuWinningScreen);
		
		String winners = "";
		
		for(int i = 0; i < GlobalVariables.winningPlayers.size(); i++)
		{
			winners = winners.concat(GlobalVariables.winningPlayers.get(i).getPlayerName() + ", ");
		}
		
		textViewWinning.setText(winners);
		
		buttonScoreBoardWinning.setOnClickListener(this);
		buttonMainMenuWinning.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonScoreBoardWinningScreen)
		{
			Intent intent = new Intent(this, ScoreBoardScreen.class);
			startActivity(intent);
			
		}
		
		if(v.getId() == R.id.buttonMainMenuWinningScreen)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}

}
