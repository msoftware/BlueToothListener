package com.jackie.bluaram;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BlueToothReceiver extends BroadcastReceiver {

	private String btMessage = "";

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		BluetoothDevice device = intent
				.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
		if (BluetoothDevice.ACTION_FOUND.equals(action)) {
		} else if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
		}

		else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) {
		} else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {
		}

		intent.putExtra("Bluetooth", btMessage);
		intent.setClass(context, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);

	}

}
