package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DisplayQuestionScreen extends Activity implements OnClickListener {

	Button buttonOKDisplayQuestion;
	Button buttonQuitDisplayQuestion;
	
	TextView textViewPlayerName;
	TextView textViewQuestion;
	
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.display_question_screen);
		
		buttonOKDisplayQuestion = (Button)findViewById(R.id.buttonOkDisplayQuestion);
		buttonQuitDisplayQuestion = (Button)findViewById(R.id.buttonQuitDisplayQuestion);
		
		textViewPlayerName = (TextView)findViewById(R.id.textViewPlayerName);
		textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
		
		textViewPlayerName.setText(GlobalVariables.host.getPlayerName());
		textViewQuestion.setText(GlobalVariables.currentQuestion);
		
		buttonOKDisplayQuestion.setOnClickListener(this);
		buttonQuitDisplayQuestion.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOkDisplayQuestion)
		{
			Intent intent = new Intent(this, AskAnswerScreen.class);
			startActivity(intent);
		}
		
		if(v.getId() == R.id.buttonQuitDisplayQuestion)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
		}
	}

}
