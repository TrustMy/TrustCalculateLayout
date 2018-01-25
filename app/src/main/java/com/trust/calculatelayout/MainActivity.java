package com.trust.calculatelayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.trust.calculatelayout.view.TrustUITool;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TrustUITool.initTrustUITool(this);
        TrustUITool.setBenchmark(720,1280);
    }
}
