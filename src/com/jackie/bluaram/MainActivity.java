package com.jackie.bluaram;

import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private BluetoothBroadcastReceiver mReceiver = null;

	/**
	 * 显示本机蓝牙设备名称
	 */
	private TextView tvDeviceName;
	/**
	 * 可见的蓝牙列表
	 */
	private ListView listDevices;

	/**
	 * 可见的蓝牙设备列表
	 */
	private ArrayList<BluetoothDevice> mBluetoothDevices;

	/**
	 * 蓝牙列表的适配器
	 */
	private DeviceAdapter mAdapter;

	/**
	 * 蓝牙适配器
	 */
	private BluetoothAdapter mBluetoothAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		tvDeviceName = (TextView) findViewById(R.id.device_name_tv);
		listDevices = (ListView) findViewById(R.id.devices_list);

		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		mBluetoothDevices = new ArrayList<BluetoothDevice>();
		mAdapter = new DeviceAdapter(this, mBluetoothDevices);
		listDevices.setAdapter(mAdapter);
		initData();

		mReceiver = new BluetoothBroadcastReceiver();
		IntentFilter filter = new IntentFilter();
		filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
		filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
		filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
		filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
		filter.addAction(BluetoothDevice.ACTION_CLASS_CHANGED);
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
		registerReceiver(mReceiver, filter);

		startActivityForResult(new Intent(
				BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.i(TAG, "onActivityResult& requestCode:" + requestCode
				+ "; resultCode: " + resultCode);
		initData();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mReceiver);
	}

	private void initData() {
		String deviceName = mBluetoothAdapter.getName();
		tvDeviceName.setText(deviceName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class BluetoothBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			Log.i(TAG, "onReceive& action:" + action);

			BluetoothDevice device = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			Log.i(TAG, "onReceive& name: " + device.getName());

			if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {

			} else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED
					.equals(action)) {

			} else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action)) {

			} else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {

			} else if (BluetoothDevice.ACTION_CLASS_CHANGED.equals(action)) {
				mBluetoothDevices.add(device);
				mAdapter.notifyDataSetChanged();
			} else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				
			} else if (BluetoothDevice.ACTION_NAME_CHANGED.equals(action)) {

			}

		}

	}

}
