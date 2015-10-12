package com.util;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class HttpUtil {
	public static HttpClient httpClient = new DefaultHttpClient();
	public static final String BASE_URL = "http://192.168.12.1:8080/GoBuy";
	//∑¢ÀÕget«Î«Û
	public static String getRequest(String url) throws Exception{
		HttpGet get = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(get);
		if(httpResponse.getStatusLine().getStatusCode()==200){
			String result = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			return result; 
		}
		return null;
	}
	
}
