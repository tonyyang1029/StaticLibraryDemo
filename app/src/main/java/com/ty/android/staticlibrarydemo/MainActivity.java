/**
 * https://blog.csdn.net/qq_34759481/article/details/83957938
 */

package com.ty.android.staticlibrarydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView = null;
    private Button   mBtn1     = null;
    private Button   mBtn2     = null;
    private Button   mBtn3     = null;
    private Button   mBtn4     = null;
    private Button   mBtn5     = null;

    private SharedLib mSharedLib = new SharedLib();

    static {
        System.loadLibrary("sharedlib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.ID_MAIN_TV);
        mTextView.setText("Press button to read data...");

        mBtn1 = findViewById(R.id.ID_MAIN_BTN_1);
        mBtn1.setText("Read Data");
        mBtn1.setOnClickListener(this);

        mBtn2 = findViewById(R.id.ID_MAIN_BTN_2);
        mBtn2.setText("Clear Data");
        mBtn2.setOnClickListener(this);

        mBtn3 = findViewById(R.id.ID_MAIN_BTN_3);
        mBtn3.setText("Update Data");
        mBtn3.setOnClickListener(this);

        mBtn4 = findViewById(R.id.ID_MAIN_BTN_4);
        mBtn4.setText("Update Number");
        mBtn4.setOnClickListener(this);

        mBtn5 = findViewById(R.id.ID_MAIN_BTN_5);
        mBtn5.setText("Read Local Data");
        mBtn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ID_MAIN_BTN_1:
                mTextView.setText("No." + SharedLib.number + " " + SharedLib.getData());
                break;
            case R.id.ID_MAIN_BTN_2:
                mTextView.setText("Press button to read data...");
                break;
            case R.id.ID_MAIN_BTN_3:
                mTextView.setText("No." + SharedLib.number + " " + SharedLib.updateData("Updated"));
                break;
            case R.id.ID_MAIN_BTN_4:
                SharedLib.updateNumber();
                mTextView.setText("No." + SharedLib.number + " " + SharedLib.updateData("Updated"));
                break;
            case R.id.ID_MAIN_BTN_5:
                String data = mSharedLib.getLocalData("China");
                mTextView.setText("No." + mSharedLib.localnumber + " " + data);
                break;
            default:
                Log.i("StaticLibraryDemo", "No views found");
        }
    }
}

class SharedLib {
    public static int number = 0;

    public static native String getData();
    public static native String updateData(String data);
    public static native void   updateNumber();

    public int localnumber = 0;
    public native String getLocalData(String updates);
}