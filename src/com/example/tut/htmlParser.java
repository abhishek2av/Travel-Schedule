package com.example.tut;

import java.util.Formatter;
import java.util.Locale;

//import com.example.tut.MainActivity.LongOperation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class htmlParser extends Activity{
	TextView tv,header;
	String src,dst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
	 tv = (TextView) findViewById(R.id.tvschedule);
	 header = (TextView) findViewById(R.id.tvheader);
	 // String data = getIntent().getStringExtra("tag");
	  src = getIntent().getStringExtra("source");
	  dst = getIntent().getStringExtra("destination");
	 new LongOperation().execute("");
	  String data = null;
	

	}
	public void Parse(String data){
		String done="",pull;
		int start,end;
	      
	      

	      while(data.indexOf("<td class='text'>")!=-1){
	    	   
		//Airline
		start = data.indexOf("<td class='text'>")+17;
		data = data.substring(start);
		pull = data.substring(0,data.indexOf("</td>"));
		done = done + pull +" > ";
		
		//Flight no.		
		start = data.indexOf("<td class='text'>")+17;
		data = data.substring(start);
		pull = data.substring(0,data.indexOf("</td>"));
		done = done + pull +" > ";
		
		//Departure		
		start = data.indexOf("<td class='text'>")+17;
		data = data.substring(start);
		pull = data.substring(0,data.indexOf("</td>"));
		done = done + pull +" > ";
		
		//Arrival		
		start = data.indexOf("<td class='text'>")+17;
		data = data.substring(start);
		pull = data.substring(0,data.indexOf("</td>"));
		done = done + pull +" > ";
		
		//Days		
		start = data.indexOf("<td class='text'>")+17;
		data = data.substring(start);
		pull = data.substring(0,data.indexOf("</td>"));
		done = done + pull ;
		//---------------------------------------	
		done = done + "\n";

		
		
	
	
	}
	      if((done.equals("")))
	  	tv.setText("No direct Flight");
	      else tv.setText(done);
}
	
	private class LongOperation extends AsyncTask<String, Void, String> {

	      @Override
	      protected String doInBackground(String... params) {
	        GetMethodEx test = new GetMethodEx();
	        String data = null;
	        try {
	        	data = (new GetMethodEx()).getInternetData(src, dst);

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	            return data;
	      }      

	      @Override
	      protected void onPostExecute(String result) {    
	        // Update Ui here  
	    	 
	    	  Parse(result);
	    	  header.setText("Airlines > Flight # > Departure > Arrival > Days");
	      }

	}
}
