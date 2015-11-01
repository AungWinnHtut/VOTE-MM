package com.gogoal.votemm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button checkvote, vote;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		checkvote = (Button) findViewById(R.id.checkvote);
		vote = (Button) findViewById(R.id.vote);

		checkvote.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Checkconnetion(true);
			}
		});

		vote.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Checkconnetion(false);
			}
		});

	}

	protected void Checkconnetion(boolean b) {
		// TODO Auto-generated method stub
		ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nf = cn.getActiveNetworkInfo();
		if (nf != null && nf.isConnected() == true) {

			if (b) {
				Intent it=new Intent(getApplicationContext(),Checkvote.class);
				startActivity(it);
			}else {
				Intent it=new Intent(getApplicationContext(),Vote.class);
				startActivity(it);
			}
			
		} else {
			Toast.makeText(getApplicationContext(),
					"Please check your network", 10).show();
		}
	}

}
