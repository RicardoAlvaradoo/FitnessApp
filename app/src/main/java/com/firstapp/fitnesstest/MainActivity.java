package com.firstapp.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //launches the routine activity
    public void routineLaunch(View routineButton) {
        Intent newP = new Intent(this, RoutineActivity.class);
        startActivity(newP);
    }
}