package com.hesaidshesaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AskQuestionScreen extends Activity implements OnClickListener {
	
	Button buttonOKWhatQuestion;
	Button buttonQuitWhatQuestion;
	
	EditText editTextQuestion;
	
	RelativeLayout relativeLayoutAskQuestion;
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.ask_question_screen);
		
		buttonOKWhatQuestion = (Button)findViewById(R.id.buttonOKWhatQuestion);
		buttonQuitWhatQuestion = (Button)findViewById(R.id.buttonQuitWhatQuestion);
		
		editTextQuestion = (EditText)findViewById(R.id.editTextQuestion);
		
		relativeLayoutAskQuestion = (RelativeLayout)findViewById(R.id.relativeLayoutAskQuestion);
		
		buttonOKWhatQuestion.setOnClickListener(this);
		buttonQuitWhatQuestion.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.relativeLayoutAskQuestion)
		{
			editTextQuestion.clearFocus();
		}
		
		if(v.getId() == R.id.buttonOKWhatQuestion)
		{
			GlobalVariables.currentQuestion = editTextQuestion.getText().toString();
			
			Intent intent = new Intent(this, DisplayQuestionScreen.class);
			startActivity(intent);
			finish();
		}
		
		if(v.getId() == R.id.buttonQuitWhatQuestion)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
			finish();
		}
	}

}
