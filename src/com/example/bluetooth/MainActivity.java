package com.example.bluetooth;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//private static BroadcastReceiver mReceiver1 = null;
	private TextView tvTextView;
	private String blueString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvTextView=(TextView)findViewById(R.id.tv);
		
		//BlueToothReceiver btReceiver=new BlueToothReceiver();
	
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		if(bundle!=null)
		{
			blueString=bundle.getString("Bluetooth");
			tvTextView.setText(blueString);
			Toast.makeText(this, blueString, Toast.LENGTH_LONG).show();
		}
	
		
	/*	  mReceiver1 = new BroadcastReceiver() {
			    @Override
			    public void onReceive(Context context, Intent intent) {
			        String action = intent.getAction();
			        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			        Toast.makeText(MainActivity.this, "蓝牙状态改变广播 !", Toast.LENGTH_LONG).show();

			        
			        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
			            Toast.makeText(MainActivity.this, device.getName() + " 设备已发现！！", Toast.LENGTH_LONG).show();
			            tvTextView.setText("设备已发现");
			        }
			        else if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
			        	tvTextView.setText("蓝牙已连接");
			            Toast.makeText(MainActivity.this, device.getName() + "已连接", Toast.LENGTH_LONG).show();
			        }
			        else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) {
			            Toast.makeText(MainActivity.this, device.getName() + "正在断开蓝牙连接。。。", Toast.LENGTH_LONG).show();
			        }
			        else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
			            Toast.makeText(MainActivity.this, device.getName() + "蓝牙连接已断开！！！", Toast.LENGTH_LONG).show();
			            tvTextView.setText("蓝牙连接已断开");
			        } 
			        
			        else if(action.equals(BluetoothAdapter.STATE_OFF))
			        {
			        	 Toast.makeText(MainActivity.this, "蓝牙已关闭", Toast.LENGTH_LONG).show();
				            tvTextView.setText("蓝牙已关闭！！");
					}
			        else if(action.equals(BluetoothAdapter.STATE_ON))
			        {
			        	Toast.makeText(MainActivity.this, "蓝牙打开", Toast.LENGTH_LONG).show();
			            tvTextView.setText("蓝牙已打开！！");
			        }
			    }
			};*/
	/*	 IntentFilter filter1, filter2, filter3, filter4,filter5,filter6;
		    filter1 = new IntentFilter("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
		    filter2 = new IntentFilter(android.bluetooth.BluetoothDevice.ACTION_ACL_DISCONNECTED);
		    filter3 = new IntentFilter(android.bluetooth.BluetoothDevice.ACTION_ACL_CONNECTED);
		    filter4 = new IntentFilter(android.bluetooth.BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
		    filter5 = new IntentFilter("android.bluetooth.BluetoothAdapter.STATE_OFF");
		    filter6 =new IntentFilter("android.bluetooth.BluetoothAdapter.STATE_ON");
		   // BroadcastReceiver mReceiver;
			this.registerReceiver(btReceiver, filter1);
		    this.registerReceiver(btReceiver, filter2);
		    this.registerReceiver(btReceiver, filter3);
		    this.registerReceiver(btReceiver, filter4);
		
		    this.registerReceiver(btReceiver, filter5);
		    this.registerReceiver(btReceiver, filter6);*/
		
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
