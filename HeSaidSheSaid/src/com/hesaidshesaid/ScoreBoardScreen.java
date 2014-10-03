package com.hesaidshesaid;

import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ScoreBoardScreen extends Activity implements OnClickListener {
	
	Button buttonOKScoreBoard;
	
	ListView listViewScoreBoard;
	
	public void onCreate(Bundle bundleInstance)
	{
		super.onCreate(bundleInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.score_board_screen);
		
		listViewScoreBoard = (ListView)findViewById(R.id.listViewScoreBoard);
		
		buttonOKScoreBoard = (Button)findViewById(R.id.buttonOKScoreBoard);
		
		System.out.println("We got here");
	
		
		Collections.sort(GlobalVariables.players, new Comparator<Player>() {
			@Override public int compare(Player p1, Player p2) {
	            return p1.getPlayerScore() - p2.getPlayerScore(); // Ascending
			}
		});
		
		System.out.println("We Got farther!");
	
		String[] array = new String[GlobalVariables.players.size()];
		
		for(int i = 0; i < GlobalVariables.players.size(); i++)
		{
			array[i] = GlobalVariables.players.get(i).getPlayerName() + " has a score of " + GlobalVariables.players.get(i).getPlayerScore();
		}
		
		System.out.println("Even farther!");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.scores, R.id.listViewScoreBoard, array);
		
		System.out.println("WE got this far!!");
		
		listViewScoreBoard.setAdapter(adapter);
		
		buttonOKScoreBoard.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKScoreBoard)
		{
			Intent intent = new Intent(this, AskAnswerScreen.class);
			startActivity(intent);
		}
	}
	
}
