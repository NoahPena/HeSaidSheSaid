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
		
		victoryRadioGroup = (RadioGroup)findViewById(R.id.radioVictory);
		maxRoundsRadio = (RadioButton)findViewById(R.id.maxRounds);
		maxPointsRadio = (RadioButton)findViewById(R.id.maxPoints);
		endlessRadio = (RadioButton)findViewById(R.id.endless);
		
		cardsRadioGroup = (RadioGroup)findViewById(R.id.radioCards);
		useDefaultRadio = (RadioButton)findViewById(R.id.useDefault);
		onlyCustomRadio = (RadioButton)findViewById(R.id.onlyCustom);
		playerInLeadRadio = (RadioButton)findViewById(R.id.playerInLead);
		
		okSettingsButton = (Button)findViewById(R.id.okSettingsButton);
		
		okSettingsButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.okSettingsButton)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
		}
	}

}
