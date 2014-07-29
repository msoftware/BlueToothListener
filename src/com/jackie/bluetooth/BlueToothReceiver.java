

package com.jackie.bluetooth;

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
	//��������״̬

	@Override
	public void onReceive(Context context, Intent intent)
	{
        String action = intent.getAction();
        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        //Toast.makeText(context, "����״̬�ı�㲥 !", Toast.LENGTH_LONG).show();

        
        Log.i("TAG---BlueTooth","���յ�����״̬�ı�㲥����");
        if(BluetoothDevice.ACTION_FOUND.equals(action)) 
        {
            Toast.makeText(context, device.getName() + " �豸�ѷ��֣���", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"�豸�ѷ��֣���";
        }
        else if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "������", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"�豸�����ӣ���";
        }
        
        else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "���ڶϿ��������ӡ�����", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"���ڶϿ��������ӡ�����";
        }
        else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) 
        {
            Toast.makeText(context, device.getName() + "���������ѶϿ�������", Toast.LENGTH_LONG).show();
            btMessage=device.getName()+"���������ѶϿ�����";
        }     
		
        
        intent.putExtra("Bluetooth", btMessage);
        intent.setClass(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

	}

}
