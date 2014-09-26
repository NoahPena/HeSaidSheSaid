package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;

public class HowManyPlayersScreen extends Activity implements OnClickListener {
	
	Button okHowManyPlayersButton;
	Button backHowManyPlayersButton;
	
	Spinner howManyPlayersSpinner;
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.how_many_players_screen);
		
		okHowManyPlayersButton = (Button)findViewById(R.id.buttonOKHowManyPlayers);
		backHowManyPlayersButton = (Button)findViewById(R.id.buttonBackHowManyPlayers);
		howManyPlayersSpinner = (Spinner)findViewById(R.id.spinnerPlayerNumber);
		
		okHowManyPlayersButton.setOnClickListener(this);
		backHowManyPlayersButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKHowManyPlayers)
		{
			GlobalVariables.amountOfPlayers = 2 + howManyPlayersSpinner.getSelectedItemPosition();
			
			Intent intent = new Intent(this, EnterPlayerNamesScreen.class);
			startActivity(intent);
		}
		
		if(v.getId() == R.id.buttonBackHowManyPlayers)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
		}
	}

}
