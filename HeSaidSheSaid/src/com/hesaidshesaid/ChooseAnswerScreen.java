package com.hesaidshesaid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChooseAnswerScreen extends Activity implements OnItemClickListener {
	
	ListView listViewChooseAnswer;

	public void onCreate(Bundle instanceBundle)
	{
		super.onCreate(instanceBundle);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_answer_screen);
		
		listViewChooseAnswer = (ListView)findViewById(R.id.listViewChooseAnswers);
		
		for(int i = 0; i < GlobalVariables.players.size(); i++)
		{
			if(!GlobalVariables.players.get(i).isPlayerHost())
			{
				GlobalVariables.playersAnswering.add(GlobalVariables.players.get(i));
			}
		}
		
		String[] array = new String[GlobalVariables.playersAnswering.size()];
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = GlobalVariables.playersAnswering.get(i).getAnswer();
		}
		
		 final ArrayList<String> list = new ArrayList<String>();
		    for (int i = 0; i < array.length; ++i) {
		      list.add(array[i]);
		    }
		    final StableArrayAdapter adapter = new StableArrayAdapter(this,
		        R.layout.scores, list);
		    listViewChooseAnswer.setAdapter(adapter);

		    listViewChooseAnswer.setOnItemClickListener(this);
		
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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		 final String item = (String) parent.getItemAtPosition(position);
	        GlobalVariables.bestAnswer = item;
	        
	        for(int i = 0; i < GlobalVariables.playersAnswering.size(); i++)
	        {
	        	if(GlobalVariables.playersAnswering.get(i).getAnswer().equalsIgnoreCase(item))
	        	{
	        		GlobalVariables.currentWinner = GlobalVariables.playersAnswering.get(i);
	        		break;
	        	}
	        }
	        
	        Intent intent = new Intent(this, DisplayRoundWinnerScreen.class);
	        startActivity(intent);
	}
}
