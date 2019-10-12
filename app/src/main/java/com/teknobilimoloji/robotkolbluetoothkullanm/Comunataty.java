package com.teknobilimoloji.robotkolbluetoothkullanm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class Comunataty
        extends AppCompatActivity {
    static final UUID myUUID = UUID.fromString((String)"00001101-0000-1000-8000-00805F9B34FB");
    String address = null;
    Switch agiz_kapat;
    Button bas_asagi;
    Button bas_saga;
    Button bas_sola;
    Button bas_yukari;
    BluetoothDevice bluetoothDevice;
    BluetoothServerSocket bluetoothServerSocket;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    Button kol_asagi;
    Button kol_yukari;
    BluetoothAdapter myBluetooth = null;
    private ProgressDialog progress;

    private void Disconnect() {
        BluetoothSocket bluetoothSocket = this.btSocket;
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this.finish();
    }

    private void durdur() {
        try {
            this.btSocket.getOutputStream().write("0".toString().getBytes());
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.Disconnect();
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_comunataty);
        new BTbaglan((Comunataty)this, null).execute();
        this.address = this.getIntent().getStringExtra(MainActivity.EXTRA_ADRESS);
        this.bas_yukari = (Button)this.findViewById(R.id.bas_yukari);
        this.bas_asagi = (Button)this.findViewById(R.id.bas_asagi);
        this.bas_saga = (Button)this.findViewById(R.id.bas_saga);
        this.bas_sola = (Button)this.findViewById(R.id.bas_sola);
        this.kol_asagi = (Button)this.findViewById(R.id.kol_asagi);
        this.kol_yukari = (Button)this.findViewById(R.id.kol_yukari);
        this.agiz_kapat = (Switch)this.findViewById(R.id.agiz_kapat);

        this.agiz_kapat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                if (Comunataty.this.agiz_kapat.isChecked()) {
                    if (Comunataty.this.btSocket != null) {
                        try {
                            Comunataty.this.btSocket.getOutputStream().write("7".toString().getBytes());
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                        return;
                    }
                    return;
                }
                try {
                    Comunataty.this.btSocket.getOutputStream().write("8".toString().getBytes());
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    return;
                }
            }
        });
        this.kol_yukari.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                                try {
                                    Comunataty.this.btSocket.getOutputStream().write("1".toString().getBytes());
                                }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
        this.kol_asagi.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                            try {
                                Comunataty.this.btSocket.getOutputStream().write("2".toString().getBytes());
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
        this.bas_yukari.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                            try {
                                Comunataty.this.btSocket.getOutputStream().write("3".toString().getBytes());
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
        this.bas_asagi.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                            try {
                                Comunataty.this.btSocket.getOutputStream().write("4".toString().getBytes());
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
        this.bas_saga.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                            try {
                                Comunataty.this.btSocket.getOutputStream().write("5".toString().getBytes());
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
        this.bas_sola.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (Comunataty.this.btSocket != null) {
                    switch (motionEvent.getAction()) {
                        default: {
                            break;
                        }
                        case 1: {
                            Comunataty.this.durdur();
                            break;
                        }
                        case 0: {
                            try {
                                Comunataty.this.btSocket.getOutputStream().write("6".toString().getBytes());
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                return false;
            }
        });
    }

    private class BTbaglan
            extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess;
        /* synthetic */ Comunataty comunataty ;

        private BTbaglan(Comunataty comunataty, Object o) {
            this.comunataty = comunataty;
            this.ConnectSuccess = true;
        }



        protected /* varargs */ Void doInBackground(Void ... arrvoid) {
            try {
                if (this.comunataty.btSocket == null || !this.comunataty.isBtConnected) {
                    this.comunataty.myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice bluetoothDevice = this.comunataty.myBluetooth.getRemoteDevice(this.comunataty.address);
                    this.comunataty.btSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(Comunataty.myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    this.comunataty.btSocket.connect();
                }
            }
            catch (IOException iOException) {
                this.ConnectSuccess = false;
            }
            return null;
        }

        protected void onPostExecute(Void void_) {
            super.onPostExecute((Void) void_);
            if (!this.ConnectSuccess) {
                Toast.makeText((Context)this.comunataty.getApplicationContext(), (CharSequence)"Baglantı Hatasi Tekrar Deneyin", Toast.LENGTH_LONG).show();
                this.comunataty.finish();
            } else {
                Toast.makeText((Context)this.comunataty.getApplicationContext(), (CharSequence)"Baglantı başarılı", Toast.LENGTH_LONG).show();
                this.comunataty.isBtConnected = true;
            }
            this.comunataty.progress.dismiss();
        }

        protected void onPreExecute() {
            Comunataty comunataty = this.comunataty;
            comunataty.progress = ProgressDialog.show((Context)comunataty, (CharSequence)"Baglaniyor...", (CharSequence)"Lütfen Bekleyin");
        }
    }

}