package com.gogoal.votemm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Vote extends Activity implements OnClickListener {

	ImageView iv1, iv2, iv3, iv4, iv5;
	Button vote_btn;
	String ID;
	int vote = 0;
	ProgressDialog pd;
	AlertDialog.Builder ab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote);

		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		iv3 = (ImageView) findViewById(R.id.imageView3);
		iv4 = (ImageView) findViewById(R.id.imageView4);
		iv5 = (ImageView) findViewById(R.id.imageView5);
		vote_btn = (Button) findViewById(R.id.vote_click_button);

		pd = new ProgressDialog(this);
		ab = new AlertDialog.Builder(this);

		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv4.setOnClickListener(this);
		iv5.setOnClickListener(this);
		vote_btn.setOnClickListener(this);

		TelephonyManager tm = (TelephonyManager) getBaseContext()
				.getSystemService(getApplicationContext().TELEPHONY_SERVICE);
		ID = "" + tm.getDeviceId();


		AdView adView = new AdView(this, AdSize.BANNER,
				"ca-app-pub-1321777607277980/3192387955");

		LinearLayout layout = (LinearLayout) findViewById(R.id.image);
		layout.addView(adView);

		AdRequest adRequest = new AdRequest();
		adRequest.addTestDevice(ID);
	//	adRequest.addTestDevice("test");
		// adRequest.setTesting(true);
		// Start loading the ad in the background.
		adView.loadAd(adRequest);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == iv1) {
			iv1.setImageResource(R.drawable.nld1);
			iv2.setImageResource(R.drawable.kyan);
			iv3.setImageResource(R.drawable.other);
			iv4.setImageResource(R.drawable.one);
			iv5.setImageResource(R.drawable.dontcare);
			vote = 1;
		}
		if (v == iv2) {
			iv1.setImageResource(R.drawable.nld);
			iv2.setImageResource(R.drawable.kyan1);
			iv3.setImageResource(R.drawable.other);
			iv4.setImageResource(R.drawable.one);
			iv5.setImageResource(R.drawable.dontcare);
			vote = 2;
		}
		if (v == iv3) {
			iv1.setImageResource(R.drawable.nld);
			iv2.setImageResource(R.drawable.kyan);
			iv3.setImageResource(R.drawable.other1);
			iv4.setImageResource(R.drawable.one);
			iv5.setImageResource(R.drawable.dontcare);
			vote = 3;
		}
		if (v == iv4) {
			iv1.setImageResource(R.drawable.nld);
			iv2.setImageResource(R.drawable.kyan);
			iv3.setImageResource(R.drawable.other);
			iv4.setImageResource(R.drawable.one1);
			iv5.setImageResource(R.drawable.dontcare);
			vote = 4;
		}
		if (v == iv5) {
			iv1.setImageResource(R.drawable.nld);
			iv2.setImageResource(R.drawable.kyan);
			iv3.setImageResource(R.drawable.other);
			iv4.setImageResource(R.drawable.one);
			iv5.setImageResource(R.drawable.dontcare1);
			vote = 5;
		}
		if (v == vote_btn) {

			if (vote == 0) {
				Toast.makeText(getApplicationContext(),
						"Please Choose Your Party", 10).show();
			} else {

				ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo nf = cn.getActiveNetworkInfo();
				if (nf != null && nf.isConnected() == true) {

					ab.setTitle("Warning");
					ab.setMessage("Are you sure want to vote this party ? You can vote  only one time with this phone \n\n သင္ ဒီ ပါတီကို မဲ ထည့္မည္မွာ ေသခ်ာပါသလား ? ဤ ဖုန္းျဖင့္ သင္မဲတစ္ၾကိမ္ သာ ေပးခြင့္ရွိပါသည္။");
					ab.setPositiveButton("Vote",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									new PhosJson().execute();
								}
							}).setNegativeButton("Cancel", null).show();

				} else {
					Toast.makeText(getApplicationContext(),
							"Please check your network", 10).show();
				}

			}
		}

	}

	public class PhosJson extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd.setIcon(R.drawable.vote_logo);
			pd.setMessage("Please Wait ...... ");
			pd.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String data = "No Data";
			data = regetistariondata(ID, vote);

			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG)
					.show();
		}

	}

	public String regetistariondata(String iD2, int vote2) {
		// TODO Auto-generated method stub

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"http://www.mmstarpioneer.com/Vote/vote.php");

		String json = "No";
		BufferedReader in = null;

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("id", iD2));
			nameValuePairs.add(new BasicNameValuePair("vote", vote2 + ""));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost);

			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			json = in.readLine();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		return json;
	}

}
