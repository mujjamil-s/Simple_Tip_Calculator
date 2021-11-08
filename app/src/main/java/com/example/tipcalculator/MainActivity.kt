package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        
        // Start 
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               textViewTipPercent.text = progress.toString() + "%"  }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
         // display the result
        buttonCalculate.setOnClickListener {
            // get the bill amount
            var billAmount = editTextBillAmount.text.toString().toInt()


            // get tip percent
            var tipPercent = seekBar.progress

            //calculate tip amount
            var tipAmount = (billAmount * tipPercent) / 100


            // calculate total payment

            var totalPayment = billAmount + tipAmount

            textViewTotalPayment.setText("Toatal ${totalPayment} (tip ${tipAmount})")
            //"Total $" + totalPayment.toString() +" (Tip $" + tipAmount.toString() + ")" )
        }
    }
}
