package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.settings_screen);
		
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
		
			maxPointsEdit.setHint("Default is 15");
			maxRoundsEdit.setHint("Default is 20");
		
            maxPointsEdit.setFocusable(false);
            maxPointsEdit.setFocusableInTouchMode(false);
            maxPointsEdit.setClickable(false);
     
            maxRoundsEdit.setFocusable(true);
            maxRoundsEdit.setFocusableInTouchMode(true);
            maxRoundsEdit.setClickable(true);
            
		maxRoundsRadio.setOnClickListener(this);
		maxPointsRadio.setOnClickListener(this);
		endlessRadio.setOnClickListener(this);
		victoryRadioGroup.setOnClickListener(this);
		okSettingsButton.setOnClickListener(this);
		
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
	
		if(v.getId() == R.id.buttonOKSettings)
		{
			//Update Global Variables
			
			switch(victoryRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioMaxRounds:
				GlobalVariables.gameType = 0;
				
				try
				{
				GlobalVariables.maxRounds = Integer.parseInt(maxRoundsEdit.getText().toString());
				} catch(Exception e)
				{
					GlobalVariables.maxRounds = 20;
				}
				break;
				
			case R.id.radioMaxPoints:
				GlobalVariables.gameType = 1;
				
				try
				{
				GlobalVariables.maxPoints = Integer.parseInt(maxPointsEdit.getText().toString());
				} catch(Exception e)
				{
					GlobalVariables.maxPoints = 15;
				}
				break;
				
			case R.id.radioEndless:
				GlobalVariables.gameType = 2;
				break;
			}
			
			switch(cardsRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioUseDefault:
				GlobalVariables.cardType = 0;
				break;
				
			case R.id.radioOnlyCustom:
				GlobalVariables.cardType = 1;
				break;
				
			case R.id.radioPlayerInLead:
				GlobalVariables.cardType = 2;
				break;
			}
			
			
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}

}
