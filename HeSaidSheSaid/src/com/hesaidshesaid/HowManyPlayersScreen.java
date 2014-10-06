package com.hesaidshesaid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
		
		GlobalVariables.currentQuestionBank.clear();
		
		//populate questionBank
		if(GlobalVariables.cardType != 1)
		{
			try {
				populateQuestionBank();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKHowManyPlayers)
		{
			GlobalVariables.amountOfPlayers = 0;
			GlobalVariables.players.clear();
			GlobalVariables.playersAnswering.clear();
			GlobalVariables.host = null;
			
			GlobalVariables.amountOfPlayers = 2 + howManyPlayersSpinner.getSelectedItemPosition();
			
			Intent intent = new Intent(this, EnterPlayerNamesScreen.class);
			startActivity(intent);
			finish();
		}
		
		if(v.getId() == R.id.buttonBackHowManyPlayers)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}
	
	public void populateQuestionBank() throws FileNotFoundException, IOException
	{
		//InputStream inputStream = HowManyPlayersScreen.class.getResourceAsStream("Questions.txt");
		InputStream is = getAssets().open("Questions.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = reader.readLine()) != null) 
		{
			GlobalVariables.questionBank.add(line);
			GlobalVariables.currentQuestionBank.add(line);
		}
		
		reader.close();
		
		//Toast.makeText(HowManyPlayersScreen.this, "Size: " + GlobalVariables.questionBank.size(), Toast.LENGTH_LONG).show();
	}

}
