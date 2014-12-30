package com.example.tut;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener {

	Button GoButton, btn2;
	TextView html;

	String htmlcode = "nothing yet",src,dst;
	
	
	Spinner spinner1, spinner2, spinner3;
	ArrayAdapter<String> dataAdapter1, dataAdapter2, dataAdapter3,
			dataAdapter4, dataAdapter5, dataAdapter6;

	static final int DATE_DIALOG_ID = 999;
	static final int DATE_DIALOG_ID2 = 998;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinner1 = (Spinner) findViewById(R.id.sSrc);
		GoButton = (Button) findViewById(R.id.bGo);
		btn2 = (Button) findViewById(R.id.button10);
		spinner2 = (Spinner) findViewById(R.id.sDst);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		

		final TabHost th = (TabHost) findViewById(R.id.tabhost);
		Resources res = getResources();
		th.setup();
		TabSpec spec = th.newTabSpec("tag 1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", res.getDrawable(R.drawable.fight_icon));
		th.addTab(spec);
		spec = th.newTabSpec("tag 2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", res.getDrawable(R.drawable.visit_icon));
		th.addTab(spec);

	
		th.setOnTabChangedListener(new OnTabChangeListener() {
			TextView tv = (TextView) findViewById(R.id.textView1);
			TextView tv2 = (TextView) findViewById(R.id.textView2);

			@Override
			public void onTabChanged(String arg0) {
				// TODO Auto-generated method stub
				int i = th.getCurrentTab();
				if (i == 0) {
					tv.setVisibility(TextView.VISIBLE);
					tv2.setVisibility(TextView.INVISIBLE);
				}

				if (i == 1) {
					tv.setVisibility(TextView.INVISIBLE);
					tv2.setVisibility(TextView.VISIBLE);

				}
			}

		});
		addItemsOnSpinners();

		GoButton.setOnClickListener(this);

		SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
		spinner1.setSelection(settings.getInt("sv1", 0), true);
		spinner2.setSelection(settings.getInt("sv2", 0), true);
		spinner3.setSelection(settings.getInt("sv3", 0), true);
	
	
		

	}

	

	public void addItemsOnSpinners() {

	
		List<String> list1 = new ArrayList<String>();
		
		list1.add("Agartala");
		list1.add("Agatti");
		list1.add("Agra");
		list1.add("Ahmedabad");
		list1.add("Aizawl");
		list1.add("Allahabad");
		list1.add("Amritsar");
		list1.add("Aurangabad");
		list1.add("Bagdogra");
		list1.add("Bangalore");
		list1.add("Belgaum");
		list1.add("Bhavnagar");
		list1.add("Bhopal");
		list1.add("Bhubaneshwar");
		list1.add("Bhuj");
		list1.add("Chandigarh");
		list1.add("Chennai");
		list1.add("Coimbatore");
		list1.add("Dehradun");
		list1.add("Delhi");
		list1.add("Dharmshala");
		list1.add("Dibrugarh");
		list1.add("Dibrugarth");
		list1.add("Dimapur");
		list1.add("Diu");
		list1.add("Gaya");
		list1.add("Goa");
		list1.add("Gorakhpur");
		list1.add("Guwahati");
		list1.add("Gwalior");
		list1.add("Hubli");
		list1.add("Hyderabad");
		list1.add("Imphal");
		list1.add("Indore");
		list1.add("Jabalpur");
		list1.add("Jaipur");
		list1.add("Jammu");
		list1.add("Jamnagar");
		list1.add("Jodhpur");
		list1.add("Kanpur");
		list1.add("Khajuraho");
		list1.add("Kochi");
		list1.add("Kolkata");
		list1.add("Kozhikode");
		list1.add("Leh");
		list1.add("Lucknow");
		list1.add("Ludhiana");
		list1.add("Madurai");
		list1.add("Mangalore");
		list1.add("Mumbai");
		list1.add("Mysore");
		list1.add("Nagpur");
		list1.add("Patna");
		list1.add("Porbandar");
		list1.add("Port-Blair");
		list1.add("Pune");
		list1.add("Raipur");
		list1.add("Rajahmundry");
		list1.add("Rajkot");
		list1.add("Ranchi");
		list1.add("Shillong");
		list1.add("Silchar");
		list1.add("Srinagar");
		list1.add("Surat");
		list1.add("Tiruchirapalli");
		list1.add("Tirupati");
		list1.add("Trivandrum");
		list1.add("Tuticorin");
		list1.add("Udaipur");
		list1.add("Vadodara");
		list1.add("Varanasi");
		list1.add("Vijayawada");
		list1.add("Visakhapatnam");
		
			ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, list1);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

	
		List<String> list2 = new ArrayList<String>();
				list2.add("Agartala");
		list2.add("Agatti");
		list2.add("Agra");
		list2.add("Ahmedabad");
		list2.add("Aizawl");
		list2.add("Allahabad");
		list2.add("Amritsar");
		list2.add("Aurangabad");
		list2.add("Bagdogra");
		list2.add("Bangalore");
		list2.add("Belgaum");
		list2.add("Bhavnagar");
		list2.add("Bhopal");
		list2.add("Bhubaneshwar");
		list2.add("Bhuj");
		list2.add("Chandigarh");
		list2.add("Chennai");
		list2.add("Coimbatore");
		list2.add("Dehradun");
		list2.add("Delhi");
		list2.add("Dharmshala");
		list2.add("Dibrugarh");
		list2.add("Dibrugarth");
		list2.add("Dimapur");
		list2.add("Diu");
		list2.add("Gaya");
		list2.add("Goa");
		list2.add("Gorakhpur");
		list2.add("Guwahati");
		list2.add("Gwalior");
		list2.add("Hubli");
		list2.add("Hyderabad");
		list2.add("Imphal");
		list2.add("Indore");
		list2.add("Jabalpur");
		list2.add("Jaipur");
		list2.add("Jammu");
		list2.add("Jamnagar");
		list2.add("Jodhpur");
		list2.add("Kanpur");
		list2.add("Khajuraho");
		list2.add("Kochi");
		list2.add("Kolkata");
		list2.add("Kozhikode");
		list2.add("Leh");
		list2.add("Lucknow");
		list2.add("Ludhiana");
		list2.add("Madurai");
		list2.add("Mangalore");
		list2.add("Mumbai");
		list2.add("Mysore");
		list2.add("Nagpur");
		list2.add("Patna");
		list2.add("Porbandar");
		list2.add("Port-Blair");
		list2.add("Pune");
		list2.add("Raipur");
		list2.add("Rajahmundry");
		list2.add("Rajkot");
		list2.add("Ranchi");
		list2.add("Shillong");
		list2.add("Silchar");
		list2.add("Srinagar");
		list2.add("Surat");
		list2.add("Tiruchirapalli");
		list2.add("Tirupati");
		list2.add("Trivandrum");
		list2.add("Tuticorin");
		list2.add("Udaipur");
		list2.add("Vadodara");
		list2.add("Varanasi");
		list2.add("Vijayawada");
		list2.add("Visakhapatnam");

		dataAdapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item,
				list2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter2);

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

		
	

	protected void onStop() {
		super.onStop();
		SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("sv1", spinner1.getSelectedItemPosition());
		editor.putInt("sv2", spinner2.getSelectedItemPosition());
		editor.putInt("sv3", spinner3.getSelectedItemPosition());
		editor.commit();

	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		src = spinner1.getSelectedItem().toString();
		dst = spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();

		
		 
			 new LongOperation().execute("");
		
		
	};
	private class LongOperation extends AsyncTask<String, Void, String> {

	      @Override
	      protected String doInBackground(String... params) {
	        GetMethodEx test = new GetMethodEx();
	        boolean returned = false;
	        try {
	            returned = test.isNet();

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	            return ""+returned;
	      }      

	      @Override
	      protected void onPostExecute(String result) {    
	        // Update Ui here  
	    	  if(result.equals("false"))
	    		 Toast.makeText(getApplicationContext(), "No Internet connection", Toast.LENGTH_SHORT).show();
	    	  else{
	    	  Intent intent = new Intent("com.example.tut.htmlParser");   
//	    	  intent.putExtra("tag", result);
	    	  intent.putExtra("source", src);
	    	  intent.putExtra("destination", dst);
	    	  startActivity(intent);      }
	      }

	}
}
