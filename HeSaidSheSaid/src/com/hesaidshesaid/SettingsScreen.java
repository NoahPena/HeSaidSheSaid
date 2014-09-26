package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
	
	Button okSettingsButton;
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.settings_screen);
		
		victoryRadioGroup = (RadioGroup)findViewById(R.id.victoryRadioGroup);
		maxRoundsRadio = (RadioButton)findViewById(R.id.radioMaxRounds);
		maxPointsRadio = (RadioButton)findViewById(R.id.radioMaxPoints);
		endlessRadio = (RadioButton)findViewById(R.id.radioEndless);
		
		cardsRadioGroup = (RadioGroup)findViewById(R.id.cardsRadioGroup);
		useDefaultRadio = (RadioButton)findViewById(R.id.radioUseDefault);
		onlyCustomRadio = (RadioButton)findViewById(R.id.radioOnlyCustom);
		playerInLeadRadio = (RadioButton)findViewById(R.id.radioPlayerInLead);
		
		okSettingsButton = (Button)findViewById(R.id.buttonOKSettings);
		
		victoryRadioGroup.setOnClickListener(this);
		okSettingsButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.victoryRadioGroup)
		{
			
		}
		
		if(v.getId() == R.id.buttonOKSettings)
		{
			//Update Global Variables
			
			switch(victoryRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioMaxRounds:
				
				break;
				
			case R.id.radioMaxPoints:
				
				break;
				
			case R.id.radioEndless:
				
				break;
			}
			
			switch(cardsRadioGroup.getCheckedRadioButtonId())
			{
			case R.id.radioUseDefault:
				
				break;
				
			case R.id.radioOnlyCustom:
				
				break;
				
			case R.id.radioPlayerInLead:
				
				break;
			}
			
			
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
		}
	}

}
