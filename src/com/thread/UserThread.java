package com.thread;

import com.util.HttpUtil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class UserThread implements Runnable{
	private String username;
	private String userpwd;
	private String type;
	private Handler handler;
	
	public UserThread(String username, String userpwd ,String type,Handler handler){
		this.username = username;
		this.userpwd = userpwd;
		this.type = type;
		this.handler=handler;	
	}
	
	public void run(){
		
		if(type.equals("login")){
		
		String sUrl = HttpUtil.BASE_URL+"/login.action?user.username="+username+"&user.password="+userpwd;
		
		try {
			//得到服务器相应
			String result = HttpUtil.getRequest(sUrl);
			
			Message msg = new Message();
			Bundle data = new Bundle();
			data.putString("result", result);
			data.putString("type", type);
			msg.setData(data);
			
			//发送消息
			handler.sendMessage(msg);
			Log.i("loginResult", result);//打印日志返回结果
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(type.equals("regedit"))
		{
			//方登录的
			String sUrl = HttpUtil.BASE_URL+"/reg.action?user.username="+username+"&user.password="+userpwd;
			
			try {
				String result = HttpUtil.getRequest(sUrl);
				
				Message msg = new Message();
				Bundle data = new Bundle();
				data.putString("result", result);
				data.putString("type", type);
				msg.setData(data);
				
				//发送消息
				handler.sendMessage(msg);
				Log.i("RegeditResult", result);//打印日志返回结果
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
