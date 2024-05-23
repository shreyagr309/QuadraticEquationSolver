package com.example.quadraticequationsolver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    //Creating variable of type ActvitiyMainBinding
    ActivityMainBinding activityMainBinding;
    MyEquationSolver myEquationSolver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflating the activity main layout

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        //Creating the instance of myEquationSolver

       myEquationSolver=new MyEquationSolver();

       //Linking myEquationSolver with ActivityMainBinding

        activityMainBinding.setMyequationsolver(myEquationSolver);

    }
}