package com.example.leaningandroidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To make the windows full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //To remove the activity bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Setting up the view using the GamePanel class that we build
        setContentView(new GamePanel(this));

    }
}