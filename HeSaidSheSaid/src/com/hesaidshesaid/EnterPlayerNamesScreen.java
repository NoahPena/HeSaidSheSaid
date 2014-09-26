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
        playerNameAdapter = new MyAdapter();
        playerNamesListView.setAdapter(playerNameAdapter);
        
        okEnterPlayerNamesButton = (Button)findViewById(R.id.buttonOkEnterPlayerNames);
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
		}
		
		if(v.getId() == R.id.buttonOkEnterPlayerNames)
		{
			
		}
		
	}
	//
	
	 public class MyAdapter extends BaseAdapter {
	        private LayoutInflater mInflater;
	        public ArrayList<ListItem> myItems = new ArrayList<ListItem>();
	 
	        public MyAdapter() {
	            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            for (int i = 0; i < GlobalVariables.amountOfPlayers; i++) {
	                ListItem listItem = new ListItem();
	                listItem.caption = "Player " + (i + 1);
	                myItems.add(listItem);
	            }
	            notifyDataSetChanged();
	        }
	 
	        public int getCount() {
	            return myItems.size();
	        }
	 
	        public Object getItem(int position) {
	            return position;
	        }
	 
	        public long getItemId(int position) {
	            return position;
	        }
	 
	        public View getView(int position, View convertView, ViewGroup parent) {
	            ViewHolder holder;
	            if (convertView == null) {
	                holder = new ViewHolder();
	                convertView = mInflater.inflate(R.layout.item, null);
	                holder.caption = (EditText) convertView
	                        .findViewById(R.id.ItemCaption);
	                convertView.setTag(holder);
	            } else {
	                holder = (ViewHolder) convertView.getTag();
	            }
	            //Fill EditText with the value you have in data source
	            holder.caption.setText(myItems.get(position).caption);
	            holder.caption.setId(position);
	 
	            //we need to update adapter once we finish with editing
	            holder.caption.setOnFocusChangeListener(new OnFocusChangeListener() {
	                public void onFocusChange(View v, boolean hasFocus) {
	                    if (!hasFocus){
	                        final int position = v.getId();
	                        final EditText Caption = (EditText) v;
	                        myItems.get(position).caption = Caption.getText().toString();
	                    }
	                }
	            });
	 
	            return convertView;
	        }
	    }
	 
	 class ViewHolder {
	        EditText caption;
	    }
	 
	    class ListItem {
	        String caption;
	    }

}
