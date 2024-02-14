package com.example.sendingdatafromactivitytofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var etWeight:EditText
    lateinit var etHeight:EditText
    lateinit var calculate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etWeight= findViewById(R.id.editTextWeight)
        etHeight= findViewById(R.id.editTextHeight)
        calculate= findViewById(R.id.buttonCalculate)


        val fragmentManager: FragmentManager=supportFragmentManager
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
//        val bmiFragment = BMIFragment()
//        calculate.setOnClickListener {
//
//            val height= etHeight.text.toString().toInt()
//            val weight= etWeight.text.toString().toInt()
//
//            val bundle=Bundle()
//            bundle.putInt("weight",weight)
//            bundle.putInt("height",height)
//            bmiFragment.arguments = bundle
//
//
//            fragmentTransaction.replace(R.id.frame,bmiFragment)
//                .commit()
//
//        }

        calculate.setOnClickListener {
            val height = etHeight.text.toString().toInt()
            val weight = etWeight.text.toString().toInt()

            val bundle = Bundle().apply {
                putInt("weight", weight)
                putInt("height", height)
            }

            val bmiFragment = BMIFragment().apply {
                arguments = bundle
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.frame, bmiFragment)
                .commit()
        }
    }
}