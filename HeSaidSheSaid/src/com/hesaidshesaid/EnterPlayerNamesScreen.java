package com.hesaidshesaid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class EnterPlayerNamesScreen extends Activity implements OnClickListener {
	
	ListView playerNamesListView;
	
	Button okEnterPlayerNamesButton;
	Button backEnterPlayerNamesButton;
	
	MyAdapter playerNameAdapter;
	
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.enter_player_names_screen);
		
		playerNamesListView = (ListView) findViewById(R.id.listViewPlayerNames);
        playerNamesListView.setItemsCanFocus(true);
        playerNameAdapter = new MyAdapter(this);
        playerNamesListView.setAdapter(playerNameAdapter);
        
        okEnterPlayerNamesButton = (Button)findViewById(R.id.buttonOkEnterPlayerNames);
        	okEnterPlayerNamesButton.setFocusable(true);
        	okEnterPlayerNamesButton.setFocusableInTouchMode(true);///add this line
        backEnterPlayerNamesButton = (Button)findViewById(R.id.buttonBackEnterPlayerNames);
        
        okEnterPlayerNamesButton.setOnClickListener(this);
        backEnterPlayerNamesButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.buttonBackEnterPlayerNames)
		{
			Intent intent = new Intent(this, HowManyPlayersScreen.class);
			startActivity(intent);
			finish();
		}
		
		if(v.getId() == R.id.buttonOkEnterPlayerNames)
		{
			okEnterPlayerNamesButton.requestFocus();
			
			for(int i = 0; i < GlobalVariables.amountOfPlayers; i++)
			{
				GlobalVariables.players.add(new Player(playerNameAdapter.getItem(i)));
				
			}
			
			
			
			Intent intent = new Intent(this, SettingsScreen.class);
			startActivity(intent);
			finish();
			
		}
		
	}
	//
	
	

}
