package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculation();
        }
        buttonReset.setOnClickListener(){
            reset();
        }
    }



    private fun calculation(){
        //TODO get all inputs and calculate outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.input_error))
            return
        }
         if (editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.input_error))
            return
        }
         if (editTextInterestRate.text.isEmpty()){
             editTextInterestRate.setError(getString(R.string.input_error))
            return
        }
         if (editTextLoanPeriod.text.isEmpty()){
             editTextLoanPeriod.setError(getString(R.string.input_error))
            return
        }
        val carPrice: Int = editTextCarPrice.text.toString().toInt();
        val downPayment : Int = editTextDownPayment.text.toString().toInt();
        val loanPeriod : Int = editTextLoanPeriod.text.toString().toInt();
        val interestRate : Float = editTextInterestRate.text.toString().toFloat();


        val currency : Currency =  Currency.getInstance(Locale.getDefault())


        val carLOAN : Int = carPrice - downPayment;
        val interest : Float = carLOAN * interestRate * loanPeriod;
        val monthlyRepayment = (carLOAN + interest)/ loanPeriod / 12

        textViewLoan.text = String.format("%s %s %d ","Loan :",currency, carLOAN)
        textViewInterest.text = String.format("%s %s %2f","Interest :",currency, interest)
        textViewMonthlyInterest.text = String.format("%s %s %2f","Monthly Repayment :",currency, monthlyRepayment)
    }


        private fun reset(){
            editTextDownPayment.text.clear();
            editTextInterestRate.text.clear();
            editTextLoanPeriod.text.clear();
            editTextCarPrice.text.clear();
            textViewLoan.text="";



        }
}
