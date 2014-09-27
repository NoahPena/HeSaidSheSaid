package com.hesaidshesaid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.widget.BaseAdapter;
import android.widget.EditText;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    public ArrayList<ListItem> myItems = new ArrayList<ListItem>();

    public MyAdapter(Activity activity) {
        mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    
    public String getItem(int position) {
        return myItems.get(position).caption;
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