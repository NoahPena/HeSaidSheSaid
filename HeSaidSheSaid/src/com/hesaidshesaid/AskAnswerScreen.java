package com.hesaidshesaid;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AskAnswerScreen extends Activity implements OnClickListener {
	
	TextView textViewPlayerNameAskAnswer;
	
	EditText editTextAskAnswer;
	
	Button buttonOKAskAnswer;
	Button buttonQuitAskAnswer;
	Button buttonScoreBoardAskAnswer;
	Button buttonReadQuestionAskAnswer;
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.ask_answer_screen);
		
		textViewPlayerNameAskAnswer = (TextView)findViewById(R.id.textViewPlayerNameAskAnswer);
		
		editTextAskAnswer = (EditText)findViewById(R.id.editTextAskAnswer);
		
		buttonOKAskAnswer = (Button)findViewById(R.id.buttonOKAskAnswer);
		buttonQuitAskAnswer = (Button)findViewById(R.id.buttonQuitAskAnswer);
		buttonScoreBoardAskAnswer = (Button)findViewById(R.id.buttonScoreBoardAskAnswer);
		buttonReadQuestionAskAnswer = (Button)findViewById(R.id.buttonReadQuestionAskAnswer);
		
		if(GlobalVariables.currentCounter == -1)
		{
			Random random = new Random();
			GlobalVariables.currentCounter = random.nextInt(GlobalVariables.playersAnswering.size());
		}		
		
		textViewPlayerNameAskAnswer.setText(GlobalVariables.playersAnswering.get(GlobalVariables.currentCounter).getPlayerName());
		
		buttonOKAskAnswer.setOnClickListener(this);
		buttonQuitAskAnswer.setOnClickListener(this);
		buttonScoreBoardAskAnswer.setOnClickListener(this);
		buttonReadQuestionAskAnswer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKAskAnswer)
		{
			if(GlobalVariables.playersAnswering.size() != 0)
			{
				GlobalVariables.playersAnswering.get(GlobalVariables.currentCounter).addAnswer(editTextAskAnswer.getText().toString());
				GlobalVariables.playersAnswering.remove(GlobalVariables.currentCounter);
			
				if(GlobalVariables.playersAnswering.size() == 0)
				{
					//		End of Round
				} else {
			
				Random random = new Random();
				GlobalVariables.currentCounter = random.nextInt(GlobalVariables.playersAnswering.size());
			
				textViewPlayerNameAskAnswer.setText(GlobalVariables.playersAnswering.get(GlobalVariables.currentCounter).getPlayerName());
			
				editTextAskAnswer.setText("");
				//do something
				}
			}
		}
		
		if(v.getId() == R.id.buttonQuitAskAnswer)
		{
			Intent intent = new Intent(this, TitleScreen.class);
			startActivity(intent);
		}
		
		if(v.getId() == R.id.buttonScoreBoardAskAnswer)
		{
			//do something
			Intent intent = new Intent(this, ScoreBoardScreen.class);
			startActivity(intent);
		}
		
		if(v.getId() == R.id.buttonReadQuestionAskAnswer)
		{
			Intent intent = new Intent(this, DisplayQuestionScreen.class);
			startActivity(intent);
		}
	}

}
