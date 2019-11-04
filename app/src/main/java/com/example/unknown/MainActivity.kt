package com.example.unknown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener{
            calculateRepayment()
    }
}

    private fun calculateRepayment(){
        //get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }

        val Local = Locale.getDefault()
        val curr = NumberFormat.getCurrencyInstance(Local)
        val currency_symbol = curr.currency.symbol
        val carPrice = editTextCarPrice.text.toString().toInt()
        val downPayment : Int = editTextDownPayment.text.toString().toInt()
        val loan = carPrice - downPayment

        textViewLoan.setText(getString(R.string.loan) + "$(curr)" + "${loan}")

        val interest_rate: Double = editTextInterestRate.text.toString().toDouble()
        val year:Int = editTextLoanPeriod.text.toString().toInt()
        val interest: Double= interest_rate*year*loan
        textViewInterest.setText(getString(R.string.interest) + "$(curr)" + "${interest}")

        val monthly_repayment:Double = (loan + interest) /year/12
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "$(curr)" + "${monthly_repayment}")
        fun reset(view: View){

        }
    }
}