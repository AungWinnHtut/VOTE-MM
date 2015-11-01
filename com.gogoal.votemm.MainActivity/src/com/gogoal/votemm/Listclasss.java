package com.gogoal.votemm;

import java.util.ArrayList;

import android.util.Log;

public class Listclasss {

	public static ArrayList<get> reallist(long[] vote, int[] dra, String result) {
		// TODO Auto-generated method stub
		ArrayList<get> list = new ArrayList<get>();
		String[] parts = result.split(",");

		for (int i = 0; i < vote.length; i++) {
			get eg = new get();
			eg.setDrawable(dra[i]);
			eg.setVote(Long.parseLong(parts[i]));
			list.add(eg);
		}

		return list;
	}

}
