package com.ui;

import com.thread.UserThread;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	private Handler handler;
	String username;
	String userpwd;
	public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

      //�������ļ�ʵ���Զ���¼��ת����¼��Ľ���
        SharedPreferences sp = LoginActivity.this.getSharedPreferences("loginusername", Activity.MODE_PRIVATE);
        String loginName = sp.getString("username", "");
        String loginPwd = sp.getString("userpwd", "");
        if(!loginName.equals("")&&!loginPwd.equals(""))
        {
        	//�л�����¼��Ľ���
        	Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
		    startActivity(intent);
        }
        
        final EditText name = (EditText)this.findViewById(R.id.usrname);
		final EditText pwd = (EditText)this.findViewById(R.id.usrpwd);
		
		
		Button loginBtn = (Button)this.findViewById(R.id.loginBtn);
		Button regeditBtn = (Button)this.findViewById(R.id.regeditBtn);
		//��¼��ť��Click�¼�����
		loginBtn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					username = name.getText().toString();
					userpwd = pwd.getText().toString();
					//Toast.makeText(LoginActivity.this, "username="+username+"   userpwd="+userpwd, 3000).show();
					String type="login";
					//���������߳�
					new Thread(new UserThread(username,userpwd,type,handler)).start();

				}
			});
		regeditBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				username = name.getText().toString();
				userpwd = pwd.getText().toString();
				//Toast.makeText(LoginActivity.this, "username="+username+"   userpwd="+userpwd, 3000).show();
				String type="regedit";
				//���������߳�
				new Thread(new UserThread(username,userpwd,type,handler)).start();
				
			}
		});
		
		
		//��UI�߳��д���handle
		handler = new Handler(){
			  public void handleMessage(Message msg) {   
	               String type = msg.getData().getString("type");
	               String result = msg.getData().getString("result");
	               if(type.equals("login"))
	               {
		               if(result.equals("success"))
		               {
		            	   Toast.makeText(LoginActivity.this,"��¼�ɹ���", Toast.LENGTH_SHORT).show();
		            	   //�����û��������������Զ���¼
		            	   SharedPreferences sp = LoginActivity.this.getSharedPreferences("loginusername", Activity.MODE_PRIVATE);
		            	   
		            	   Editor editor = sp.edit();
		            	   editor.putString("username", username);
		            	   editor.putString("userpwd", userpwd);
		            	   editor.commit();//�ύ
		            	 //�л�����¼��Ľ���
		               		Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
		               		startActivity(intent);
		               }
		               else
		            	   Toast.makeText(LoginActivity.this,"��¼ʧ�ܣ�", Toast.LENGTH_SHORT).show();
	               }
	               else if(type.equals("regedit"))
	               {
	            	   if(result.equals("success"))
		               {
		            	   Toast.makeText(LoginActivity.this,"ע��ɹ���", Toast.LENGTH_SHORT).show();
		               }
		               else
		            	   Toast.makeText(LoginActivity.this,"ע��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
	               }
	          }   
		};
		
	}
}
