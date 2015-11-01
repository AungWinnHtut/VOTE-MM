package com.gogoal.votemm;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter extends BaseAdapter {
	
	Context con;
	ArrayList<get> list;

	public Myadapter(Context applicationContext, ArrayList<get> list) {
		// TODO Auto-generated constructor stub
		this.con=applicationContext;
		this.list=list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater in=(LayoutInflater) con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
		View v=in.inflate(R.layout.row, null);
		
		ImageView iv=(ImageView) v.findViewById(R.id.partylogo);
		TextView tv=(TextView) v.findViewById(R.id.party_vote);
		iv.setImageResource(list.get(arg0).getDrawable());
		tv.setText(list.get(arg0).getVote()+" Vote");
		
		return v;
	}

}
