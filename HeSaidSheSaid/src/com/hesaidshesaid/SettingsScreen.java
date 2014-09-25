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
	
	RadioGroup  victoryRadioGroup = (RadioGroup)findViewById(R.id.radioVictory);
	RadioButton maxRoundsRadio = (RadioButton)findViewById(R.id.maxRounds);
	RadioButton maxPointsRadio = (RadioButton)findViewById(R.id.maxPoints);
	RadioButton endlessRadio = (RadioButton)findViewById(R.id.endless);
	
	RadioGroup  cardsRadioGroup = (RadioGroup)findViewById(R.id.radioCards);
	RadioButton useDefaultRadio = (RadioButton)findViewById(R.id.useDefault);
	RadioButton onlyCustomRadio = (RadioButton)findViewById(R.id.onlyCustom);
	RadioButton playerInLeadRadio = (RadioButton)findViewById(R.id.playerInLead);
	
	Button okSettingsButton = (Button)findViewById(R.id.okSettingsButton);
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		setContentView(R.layout.settings_screen);
		
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
