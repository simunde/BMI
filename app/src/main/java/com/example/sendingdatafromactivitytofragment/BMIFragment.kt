package com.example.sendingdatafromactivitytofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BMIFragment : Fragment() {
    // TODO: Rename and change types of parameters


    lateinit var result: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_b_m_i, container, false)

        result=view.findViewById(R.id.textViewResult)

        val weight= arguments?.getInt("weight")!!.toInt()
        val height= arguments?.getInt("height")!!.toInt()

        val bmi : Double = ((weight*10000)/(height*height)).toDouble()
        result.text = "Your BMI is $bmi"
        return view
    }


}