package com.gogoal.votemm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class Checkvote extends Activity {

	ListView lv;

	ArrayList<get> list, a, b, c, d, e;

	long[] vote = new long[] { 0, 0, 0, 0, 01 };
	int[] dra = new int[] { R.drawable.nnn, R.drawable.kyannn,
			R.drawable.otheeerrr, R.drawable.onee, R.drawable.dddd };
	ProgressDialog pd;
	String ID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkvote);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setDividerHeight(5);
		
		pd=new ProgressDialog(this);
		
		TelephonyManager tm = (TelephonyManager) getBaseContext()
				.getSystemService(getApplicationContext().TELEPHONY_SERVICE);
		ID = "" + tm.getDeviceId();


		AdView adView = new AdView(this, AdSize.BANNER,
				"ca-app-pub-1321777607277980/3192387955");

		LinearLayout layout = (LinearLayout) findViewById(R.id.image1);
		layout.addView(adView);

		AdRequest adRequest = new AdRequest();
		adRequest.addTestDevice(ID);
		adView.loadAd(adRequest);
		
		new Check().execute();
		
		
		
	

	}

	public class Check extends AsyncTask<String, String, String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd.setTitle("Loading ...... ");
			pd.setMessage("Please wait while refresh vote");
			pd.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String data = "No Data";
			data = regetistariondata("h");

			return data;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			pd.dismiss();
		 
			Show(result);
		}
		
	}

	public void Show(String result) {
		// TODO Auto-generated method stub
		
		list = Listclasss.reallist(vote, dra,result);
		
		Collections.sort(list, new Comparator<get>() {

			public int compare(get v1, get v2) {
				return (int) (v2.getVote() - (v1.getVote()));
			}
		});
		Myadapter adapter = new Myadapter(getApplicationContext(), list);
		lv.setAdapter(adapter);
	}

	public String regetistariondata(String string) {
		// TODO Auto-generated method stub

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"http://www.mmstarpioneer.com/Vote/check.php");

		String json = "No";
		BufferedReader in = null;

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("id", string));
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