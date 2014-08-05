package com.jackie.bluaram;

import java.util.ArrayList;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 蓝牙列表适配器类
 * 
 * @author jackie
 * 
 */
public class DeviceAdapter extends BaseAdapter {

	/**
	 * 上下文引用
	 */
	private Context mContext;

	/**
	 * 设备列表
	 */
	private ArrayList<BluetoothDevice> mBluetoothDevices;

	/**
	 * 用于显示设备名称
	 */
	private TextView tvName;

	public DeviceAdapter(Context context,
			ArrayList<BluetoothDevice> bluetoothDevices) {
		super();
		mContext = context;
		mBluetoothDevices = bluetoothDevices;
	}

	public void setDevices(ArrayList<BluetoothDevice> bluetoothDevices) {
		this.mBluetoothDevices = bluetoothDevices;
	}

	@Override
	public int getCount() {
		return mBluetoothDevices.size();
	}

	@Override
	public Object getItem(int position) {
		return mBluetoothDevices.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (null == convertView) {
			tvName = new TextView(mContext);
			tvName.setTextColor(Color.WHITE);
			tvName.setTextSize(24);
			convertView = tvName;
		} else {
			tvName = (TextView) convertView;
		}
		BluetoothDevice device = mBluetoothDevices.get(position);
		tvName.setText(device.getName());
		return convertView;
	}

}
