package com.teknobilimoloji.robotkolbluetoothkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_ADRESS = "device_adress";
    ArrayAdapter<String> adapter;
    BluetoothAdapter bluetoothAdapter;
    Button pair_button;
    ListView pair_list;
    private Set<BluetoothDevice> paireddiveces;
    public AdapterView.OnItemClickListener selectDevice = new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
            String string2 = ((TextView)view).getText().toString();
            String string3 = string2.substring(-17 + string2.length());
            Intent intent = new Intent((Context)MainActivity.this, Comunataty.class);
            intent.putExtra(MainActivity.EXTRA_ADRESS, string3);
            MainActivity.this.startActivity(intent);
        }
    };
    Button toogle_button;

    private void listdivece() {
        this.paireddiveces = this.bluetoothAdapter.getBondedDevices();
        ArrayList<Object> arrayList = new ArrayList<>();
        if (this.paireddiveces.size() > 0) {
            for (BluetoothDevice bluetoothDevice : this.paireddiveces) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bluetoothDevice.getName());
                stringBuilder.append("\n");
                stringBuilder.append(bluetoothDevice.getAddress());
                arrayList.add((Object)stringBuilder.toString());
            }
        } else {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"bluetooth cihaz yok", Toast.LENGTH_LONG).show();
        }
        @SuppressLint("ResourceType") ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<Object>((Context)this, 17367043, arrayList);
        this.pair_list.setAdapter(arrayAdapter);
        this.pair_list.setOnItemClickListener(this.selectDevice);
    }

    private void toogleBluetooth() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter == null) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)"Blooth cihaz yok", Toast.LENGTH_LONG).show();
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            this.startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
        } else if (this.bluetoothAdapter.isEnabled()) {
            this.bluetoothAdapter.disable();
            return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main);
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.toogle_button = (Button)this.findViewById(R.id.btac);
        this.pair_button = (Button)this.findViewById(R.id.listac);
        this.pair_list = (ListView)this.findViewById(R.id.list);
        this.toogle_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MainActivity.this.toogleBluetooth();
            }
        });
        this.pair_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                MainActivity.this.listdivece();
            }
        });
    }

}