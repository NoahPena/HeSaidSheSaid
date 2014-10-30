package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsScreen extends Activity implements OnClickListener {
	
	RadioGroup  victoryRadioGroup;
	RadioButton maxRoundsRadio;
	RadioButton maxPointsRadio;
	RadioButton endlessRadio;
	
	RadioGroup  cardsRadioGroup;
	RadioButton useDefaultRadio;
	RadioButton onlyCustomRadio;
	RadioButton playerInLeadRadio;
	
	EditText maxRoundsEdit;
	EditText maxPointsEdit;
	
	Button okSettingsButton;
	Button buttonBackSettings;
	
	int numbers[];
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.settings_screen);
		
		SharedPreferences settings = getSharedPreferences("UserInfo", 0);
		
		victoryRadioGroup = (RadioGroup)findViewById(R.id.victoryRadioGroup);
		maxRoundsRadio = (RadioButton)findViewById(R.id.radioMaxRounds);
		maxPointsRadio = (RadioButton)findViewById(R.id.radioMaxPoints);
		endlessRadio = (RadioButton)findViewById(R.id.radioEndless);
		
		cardsRadioGroup = (RadioGroup)findViewById(R.id.cardsRadioGroup);
		useDefaultRadio = (RadioButton)findViewById(R.id.radioUseDefault);
		onlyCustomRadio = (RadioButton)findViewById(R.id.radioOnlyCustom);
		playerInLeadRadio = (RadioButton)findViewById(R.id.radioPlayerInLead);
		
		maxRoundsEdit = (EditText)findViewById(R.id.editTextMaxRounds);
		maxPointsEdit = (EditText)findViewById(R.id.editTextMaxPoints);
		
		okSettingsButton = (Button)findViewById(R.id.buttonOKSettings);		
		buttonBackSettings = (Button)findViewById(R.id.buttonBackSettingsScreen);
		
		if(settings.contains("GAMETYPE"))
		{
			if(settings.getString("GAMETYPE", null).toString().equalsIgnoreCase("ZERO"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("GAMETYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.gameType = 0;
				GlobalVariables.maxRounds = settings.getInt("ROUNDS", 20);
				
				maxRoundsEdit.setText(String.valueOf(GlobalVariables.maxRounds));
				maxPointsEdit.setHint("Default is 15");
				
				maxPointsEdit.setFocusable(false);
	            maxPointsEdit.setFocusableInTouchMode(false);
	            maxPointsEdit.setClickable(false);
	     
	            maxRoundsEdit.setFocusable(true);
	            maxRoundsEdit.setFocusableInTouchMode(true);
	            maxRoundsEdit.setClickable(true);
	            
	            victoryRadioGroup.check(R.id.radioMaxRounds);
	            
			} else if(settings.getString("GAMETYPE", null).toString().equalsIgnoreCase("ONE"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("GAMETYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.gameType = 1;
				GlobalVariables.maxPoints = settings.getInt("ROUNDS", 15);
				
				maxPointsEdit.setText(String.valueOf(GlobalVariables.maxPoints));
				maxRoundsEdit.setHint("Default is 20");
				
				maxPointsEdit.setFocusable(true);
	            maxPointsEdit.setFocusableInTouchMode(true);
	            maxPointsEdit.setClickable(true);
	     
	            maxRoundsEdit.setFocusable(false);
	            maxRoundsEdit.setFocusableInTouchMode(false);
	            maxRoundsEdit.setClickable(false);
	            
	            victoryRadioGroup.check(R.id.radioMaxPoints);
	            
			} else if(settings.getString("GAMETYPE", null).toString().equalsIgnoreCase("TWO"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("GAMETYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.gameType = 2;
				
				maxPointsEdit.setHint("Default is 15");
				maxRoundsEdit.setHint("Default is 20");
				
				maxPointsEdit.setFocusable(false);
	            maxPointsEdit.setFocusableInTouchMode(false);
	            maxPointsEdit.setClickable(false);
	     
	            maxRoundsEdit.setFocusable(false);
	            maxRoundsEdit.setFocusableInTouchMode(false);
	            maxRoundsEdit.setClickable(false);
	            
	            victoryRadioGroup.check(R.id.radioEndless);
	            
			} else {
				maxPointsEdit.setHint("Default is 15");
				maxRoundsEdit.setHint("Default is 20");
				
				maxPointsEdit.setFocusable(false);
	            maxPointsEdit.setFocusableInTouchMode(false);
	            maxPointsEdit.setClickable(false);
	     
	            maxRoundsEdit.setFocusable(true);
	            maxRoundsEdit.setFocusableInTouchMode(true);
	            maxRoundsEdit.setClickable(true);
	            
	            victoryRadioGroup.check(R.id.radioMaxRounds);
			}
		}
		
		if(settings.contains("CARDTYPE"))
		{
			if(settings.getString("CARDTYPE", null).toString().equalsIgnoreCase("ZERO"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("CARDTYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.cardType = 0;
				
				cardsRadioGroup.check(R.id.radioUseDefault);
			} else if(settings.getString("CARDTYPE", null).toString().equalsIgnoreCase("ONE"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("CARDTYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.cardType = 1;
				
				cardsRadioGroup.check(R.id.radioOnlyCustom);
			} else if(settings.getString("CARDTYPE", null).toString().equalsIgnoreCase("TWO"))
			{
				//Toast.makeText(getApplicationContext(), settings.getString("CARDTYPE", null), Toast.LENGTH_LONG).show();
				GlobalVariables.cardType = 2;
				
				cardsRadioGroup.check(R.id.radioPlayerInLead);
			} else {
				cardsRadioGroup.check(R.id.radioUseDefault);
			}
		}
		
			
		
            
            
		maxRoundsRadio.setOnClickListener(this);
		maxPointsRadio.setOnClickListener(this);
		endlessRadio.setOnClickListener(this);
		victoryRadioGroup.setOnClickListener(this);
		okSettingsButton.setOnClickListener(this);
		buttonBackSettings.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.radioMaxRounds)
		{
			maxRoundsEdit.setFocusable(true);
            maxRoundsEdit.setFocusableInTouchMode(true);
            maxRoundsEdit.setClickable(true);
            
            maxPointsEdit.setFocusable(false);
            maxPointsEdit.setFocusableInTouchMode(false);
            maxPointsEdit.setClickable(false);
		}
		
		if(v.getId() == R.id.radioMaxPoints)
		{
			maxPointsEdit.setFocusable(true);
            maxPointsEdit.setFocusableInTouchMode(true);
            maxPointsEdit.setClickable(true);
            
            maxRoundsEdit.setFocusable(false);
            maxRoundsEdit.setFocusableInTouchMode(false);
            maxRoundsEdit.setClickable(false);
		}
		
		if(v.getId() == R.id.radioEndless)
		{
			maxRoundsEdit.setFocusable(false);
            maxRoundsEdit.setFocusableInTouchMode(false);
            maxRoundsEdit.setClickable(false);
            
            maxPointsEdit.setFocusable(false);
            maxPointsEdit.setFocusableInTouchMode(false);
            maxPointsEdit.setClickable(false);
		}
		
		if(v.getId() == R.id.buttonBackSettingsScreen)
		{
			Intent intent = new Intent(this, EnterPlayerNamesScreen.class);
			startActivity(intent);
			finish();
		}
	
		if(v.getId() == R.id.buttonOKSettings)
		{
			//Update Global Variables
			SharedPreferences settings = getSharedPreferences("UserInfo", 0);
			SharedPreferences.Editor editor = settings.edit();
			
			switch(victoryRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioMaxRounds:
				GlobalVariables.gameType = 0;
				editor.putString("GAMETYPE", "ZERO");
				
				
				try
				{
				GlobalVariables.maxRounds = Integer.parseInt(maxRoundsEdit.getText().toString());
				} catch(Exception e)
				{
					GlobalVariables.maxRounds = 20;
				}
				editor.putInt("ROUNDS", GlobalVariables.maxRounds);
				break;
				
			case R.id.radioMaxPoints:
				GlobalVariables.gameType = 1;
				editor.putString("GAMETYPE", "ONE");
				
				try
				{
				GlobalVariables.maxPoints = Integer.parseInt(maxPointsEdit.getText().toString());
				} catch(Exception e)
				{
					GlobalVariables.maxPoints = 15;
				}
				editor.putInt("ROUNDS", GlobalVariables.maxPoints);
				break;
				
			case R.id.radioEndless:
				GlobalVariables.gameType = 2;
				editor.putString("GAMETYPE", "TWO");
				break;
			}
			
			switch(cardsRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioUseDefault:
				GlobalVariables.cardType = 0;
				editor.putString("CARDTYPE", "ZERO");
				break;
				
			case R.id.radioOnlyCustom:
				GlobalVariables.cardType = 1;
				editor.putString("CARDTYPE", "ONE");
				break;
				
			case R.id.radioPlayerInLead:
				GlobalVariables.cardType = 2;
				editor.putString("CARDTYPE", "TWO");
				break;
			}
			
			editor.commit();
			
			if(GlobalVariables.cardType > 1)
			{
				Intent intent = new Intent(this, AskQuestionScreen.class);
				startActivity(intent);
				finish();
			} else {		
				Intent intent = new Intent(this, PickHostScreen.class);
				startActivity(intent);
				finish();
			}
		}
	}

}
