package com.halohoop.speedupgradlebuild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        获取Android手机CPU/ABI型号
        String CPU_ABI = android.os.Build.CPU_ABI;//过时了
        String CPU_ABIs[] = android.os.Build.SUPPORTED_ABIS;

        Log.i(TAG, "onCreate: "+CPU_ABI);
        for (int i = 0; i < CPU_ABIs.length; i++) {
            Log.i(TAG, "onCreate: "+CPU_ABIs[i]);
        }

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    private static final String TAG = "MainActivity";

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
