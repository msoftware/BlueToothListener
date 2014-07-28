

package com.example.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BlueToothReceiver extends BroadcastReceiver
{
	
	//private String BLUETOOTH="android.bluetooth.BluetoothAdapter.ACTION_STATE_CHANGED";
	//private BluetoothAdapter mBluetoothAdapter;
	//private BluetoothDevice btDevice;
	private String btMessage="";
	//监听蓝牙状态

	@Override
	public void onReceive(Context context, Intent intent)
	{
        String action = intent.getAction();
        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        //Toast.makeText(context, "蓝牙状态改变广播 !", Toast.LENGTH_LONG).show();

        
        Log.i("TAG---BlueTooth","接收到蓝牙状态改变广播！！");
        if(BluetoothDevice.ACTION_FOUND.equals(action)) 
        {
            Toast.makeText(context, device.getName() + " 设备已发现！！", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"设备已发现！！";
        }
        else if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "已连接", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"设备已连接！！";
        }
        
        else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "正在断开蓝牙连接。。。", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"正在断开蓝牙连接。。。";
        }
        else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "蓝牙连接已断开！！！", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"蓝牙连接已断开！！";
        }     
		
        
        intent.putExtra("Bluetooth", btMessage);
        intent.setClass(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

	}

}
