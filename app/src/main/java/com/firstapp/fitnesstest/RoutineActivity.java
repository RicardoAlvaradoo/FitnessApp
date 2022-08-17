package com.firstapp.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RoutineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
    }
    public void JumpWorkout(View addWk) {
        Intent newP = new Intent(this,AddWorkout.class);
        startActivity(newP);
    }

}