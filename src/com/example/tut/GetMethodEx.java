package com.example.tut;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.net.ConnectivityManager;

public class GetMethodEx {

	
	public String getInternetData(String src,String dst) throws Exception{
		BufferedReader in = null;
		String data = null;
		
	//method to
		// CHECK INTERNET CONNECTIVITY -  both wifi or network
		
		
		 
		try{
			HttpClient client = new DefaultHttpClient();
			URI website = new URI("http://www.mapsofindia.com/flight-schedule/"+src+"-"+dst+".html");
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while ((l = in.readLine()) !=null){
				sb.append(l + nl);
			}
			in.close();
			data = sb.toString();
			return data;
		}finally{
			if (in != null){
				try{
					in.close();
					return data;
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean isNet(){
		boolean connectivity;
		 try {
		        URLConnection urlConnection = new URL("http://www.google.com").openConnection();
		        urlConnection.setConnectTimeout(850);
		        urlConnection.connect();
		       connectivity = true;
		    } catch (Exception e) {
		    	 connectivity = false;
		    }
		 return connectivity;
		
	}
		
	
}
