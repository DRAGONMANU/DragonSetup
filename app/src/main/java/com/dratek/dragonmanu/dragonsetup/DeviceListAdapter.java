/*
Class which implements showing the list of devices on UI
*/

package com.dratek.dragonmanu.dragonsetup;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class DeviceListAdapter extends ArrayAdapter<Appliance> {

private Context context;

public DeviceListAdapter(Context context, List items) {
    super(context, android.R.layout.simple_list_item_1, items);
    this.context = context;
}

private class ViewHolder{
    TextView titleText;
}

public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;
    View line = null;
    Appliance item = (Appliance) getItem(position);
    //final String name = item.getDeviceName();
    TextView macAddress = null;
    TextView rssi = null;
    TextView message = null;
    View viewToUse = null;

    // This block exists to inflate the settings list item conditionally based on whether
    // we want to support a grid or list view.
    LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

    viewToUse = mInflater.inflate(R.layout.device_item, null);
    holder = new ViewHolder();
    holder.titleText = (TextView)viewToUse.findViewById(R.id.device_name);
    viewToUse.setTag(holder);

    //Setting up the values to be displayed
    holder.titleText.setText(item.getName());


    //If no devices found, we make UI invisible
    if(item.getName()!=null){
        if ( item.getName().toString() == "No Devices") {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            params.addRule(RelativeLayout.CENTER_HORIZONTAL);
            holder.titleText.setLayoutParams(params);
        }
    }
    return viewToUse;
}
}
