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
			//�õ���������Ӧ
			String result = HttpUtil.getRequest(sUrl);
			
			Message msg = new Message();
			Bundle data = new Bundle();
			data.putString("result", result);
			data.putString("type", type);
			msg.setData(data);
			
			//������Ϣ
			handler.sendMessage(msg);
			Log.i("loginResult", result);//��ӡ��־���ؽ��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(type.equals("regedit"))
		{
			//����¼��
			String sUrl = HttpUtil.BASE_URL+"/reg.action?user.username="+username+"&user.password="+userpwd;
			
			try {
				String result = HttpUtil.getRequest(sUrl);
				
				Message msg = new Message();
				Bundle data = new Bundle();
				data.putString("result", result);
				data.putString("type", type);
				msg.setData(data);
				
				//������Ϣ
				handler.sendMessage(msg);
				Log.i("RegeditResult", result);//��ӡ��־���ؽ��
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
