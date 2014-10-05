package com.hesaidshesaid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
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
	
		
		Collections.sort(GlobalVariables.players, new Comparator<Player>() {
			@Override public int compare(Player p1, Player p2) {
	            return p2.getPlayerScore() - p1.getPlayerScore(); // Ascending
			}
		});
		
	
		String[] array = new String[GlobalVariables.players.size()];
		
		for(int i = 0; i < GlobalVariables.players.size(); i++)
		{
			array[i] = GlobalVariables.players.get(i).getPlayerName() + " has a score of " + GlobalVariables.players.get(i).getPlayerScore();
		}
		
		final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < array.length; ++i) {
	      list.add(array[i]);
	    }
		
		
		final StableArrayAdapter adapter = new StableArrayAdapter(this,
		        R.layout.scores, list);
		
		listViewScoreBoard.setAdapter(adapter);
		
		buttonOKScoreBoard.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.buttonOKScoreBoard)
		{
			if(GlobalVariables.gameOver == true)
			{
				finish();
			} else {
				Intent intent = new Intent(this, AskAnswerScreen.class);
				startActivity(intent);
				finish();
			}
			
		}
	}
	
	 private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
		      super(context, textViewResourceId, objects);
		      for (int i = 0; i < objects.size(); ++i) {
		        mIdMap.put(objects.get(i), i);
		      }
		    }

		    @Override
		    public long getItemId(int position) {
		      String item = getItem(position);
		      return mIdMap.get(item);
		    }

		    @Override
		    public boolean hasStableIds() {
		      return true;
		    }

		  }
	
}
