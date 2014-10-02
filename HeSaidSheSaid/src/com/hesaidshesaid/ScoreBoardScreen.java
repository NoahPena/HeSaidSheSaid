package com.hesaidshesaid;

import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		
		Collections.sort(GlobalVariables.players, new Comparator<Player>() {
			@Override public int compare(Player p1, Player p2) {
	            return p1.getPlayerScore() - p2.getPlayerScore(); // Ascending
			}
		});
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
