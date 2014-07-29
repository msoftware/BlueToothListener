package com.jackie.bluetooth;

import java.util.ArrayList;

import com.example.bluetooth.R;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
	/**
	 * 打印LOG的标签
	 */
	private static final String TAG = MainActivity.class.getSimpleName();
	private static final int ENABLE_BLUETOOTH = 1;

	/**
	 * 蓝牙适配器
	 */
	private BluetoothAdapter bluetooth;

	/**
	 * 已经连接的蓝牙设备
	 */
	private TextView mTvBluetoothName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		initUI();
		
		// 获取蓝牙适配器
		bluetooth = BluetoothAdapter.getDefaultAdapter();
		if (bluetooth.isEnabled()) { // 蓝牙已经打开
			Log.i(TAG, "onCreate& bluetooth is connected");
			setData();
		} else {
			// 蓝牙没有打开
			Log.i(TAG, "onCreate& bluetooth not connect");
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent, 0);//
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "onActivityResult& requestCode:" + requestCode
				+ "; resultCode: " + resultCode);
		if (ENABLE_BLUETOOTH == requestCode) {
			if (RESULT_OK == resultCode) {
				setData();
			}
		}
	}

	/**
	 * 初始化UI
	 */
	private void initUI() {
		mTvBluetoothName = (TextView) findViewById(R.id.connected_device_name_tv);
	}
	
	/**
	 * 设置数据
	 */
	private void setData(){
		mTvBluetoothName.setText(bluetooth.getName());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
