package com.gogoal.votemm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class keygenerade extends Activity{
	EditText ed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keygeneader);
		Button b=(Button) findViewById(R.id.gene);
		ed=(EditText) findViewById(R.id.editText2);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String a=ed.getText().toString();
				long value=Long.parseLong(a);
				long result=value/2;
				ed.setText("Acitviion code is"+result);
			}
		});
		
	}

}
