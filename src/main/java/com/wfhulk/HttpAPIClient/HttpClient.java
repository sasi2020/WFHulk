/**
 * 
 */
package com.wfhulk.HttpAPIClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wfhulk.common.JSONRequest;

/**
 * @author simalla
 *
 */
public class HttpClient {
	
	/**
	 * 1 check for the string in session
	 * 2 create a new string by appending previous string and new string
	 * @return
	 */
	private String constructQuery(String inputText){
		String HTTP_URL="'https://api.api.ai/api/query2b72744c235a4a179a66b8d42dd50843?v=20150910&query=";
		StringBuffer sb = new StringBuffer(HTTP_URL);
		//TODO: check for appending the query based on previous vaalue
		sb.append(inputText);
		return sb.toString();
	}
	
	/**
	 * This method purpose is to invoke the API Ai to convert the input of the customer and receive it as JSON text.
	 * 
	 * @return
	 */
	public JSONRequest invokeAPIAI(String inputText){
		URL url;
		JSONRequest jsonRequest =null;
		String query = constructQuery(inputText);
		try{
			url = new URL(query);
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			jsonRequest = constructJSONRequest(con);
		}catch(IOException ie){
			
		}
		return jsonRequest;
	}
	
	private JSONRequest constructJSONRequest(HttpsURLConnection con){
		JSONRequest jsonRequest = new JSONRequest();
		String JSONdata="";
		BufferedReader br=null;
		if(con!=null){
			try {
				 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String input;
				while((input=br.readLine())!=null){
					JSONdata+=input+"\n";	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try{
					if(br!=null){
						br.close();
					}
				}catch(IOException ie){
					
				}
			}
			JSONObject obj = new JSONObject(JSONdata);
			jsonRequest.setActionName(obj.getString("action"));
			Map<String, Object> parameterMap = new Gson().fromJson(obj.getJSONObject("parameters").toString(), new TypeToken<HashMap<String, Object>>() {}.getType());
			//Map<String,String> parameterMap = convertJSON2Map(obj.getJSONObject("parameters"));
			jsonRequest.setParameterMap(parameterMap);
		}
		return jsonRequest;
		
	}

	
	private Map<String,String> convertJSON2Map(JSONObject jsonObject){
		Map<String,String> parameterMap=null;
		if(jsonObject!=null){
			Iterator<String> parameterKeysIterator = jsonObject.keys();
			
			while(parameterKeysIterator!=null && parameterKeysIterator.hasNext()){/*
				String key =  (String) keyset.next();
	            Object value = jsonObject.get(key);
	            System.out.print("\n Key : "+key);
	            if ( value instanceof org.json.JSONObject ) {
	                System.out.println("Incomin value is of JSONObject : ");
	                parameterMap.put( key, jsonString2Map( value.toString() ));
	            }else if ( value instanceof org.json.JSONArray) {
	                org.json.JSONArray jsonArray = jsonObject.getJSONArray(key);
	                //JSONArray jsonArray = new JSONArray(value.toString());
	                parameterMap.put( key, jsonArray2List( jsonArray ));
	            } else {
	                keyNode( value);
	                keys.put( key, value );
	            }
			*/}
		}
		return parameterMap;
	}
}
