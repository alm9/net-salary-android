package com.example.netsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button btnBackToHome = (Button)findViewById(R.id.btnBackToHome);

        //Receive values from Home Screen
        Intent intent = getIntent();
        double grossSalary = intent.getDoubleExtra(MainActivity.GROSS_SALARY,0);
        int dependents = intent.getIntExtra(MainActivity.DEPENDENTS,0);
        double discounts = intent.getDoubleExtra(MainActivity.DISCOUNTS,0);

        //implement calculus logic
        buildLayout(grossSalary, dependents, discounts);

        btnBackToHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            //click button to go back to first screen (home)
            //ResultsActivity.this = current activity //(first parameter could be getApplicationContext())
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);

            startActivity(intent);

            }
        });

    }

    private void buildLayout(double grossSalary, int dependents, double othersDiscounts) {
        TextView textViewGrossSalary = (TextView)findViewById(R.id.textViewGrossSalary);
        TextView textViewINSS  = (TextView)findViewById(R.id.textViewINSS);
        TextView textViewIRPF = (TextView)findViewById(R.id.textViewIRPF);
        TextView textViewOthers = (TextView)findViewById(R.id.textViewOthers);
        TextView textViewNetSalary = (TextView)findViewById(R.id.textViewNetSalary);
        TextView textViewDiscounts = (TextView)findViewById(R.id.textViewDiscounts);

        double valueOfINSS = calculateINSS(grossSalary);

        double calculationBasisIRPF = grossSalary - valueOfINSS - (189.59*dependents);
        double valueOfIRPF = calculateIRPF(calculationBasisIRPF);

        double netSalary = grossSalary - valueOfINSS - valueOfIRPF - othersDiscounts;

        double discountsPercentage = (1-netSalary/grossSalary)*100;

        textViewGrossSalary.setText(String.valueOf(formatDouble(grossSalary)));
        textViewINSS.setText(String.valueOf(formatDouble(valueOfINSS)));
        textViewIRPF.setText(String.valueOf(formatDouble(valueOfIRPF)));
        textViewOthers.setText(String.valueOf(formatDouble(othersDiscounts)));
        textViewNetSalary.setText(String.valueOf(formatDouble(netSalary)));
        textViewDiscounts.setText(String.valueOf(formatDouble(discountsPercentage))+'%');

    }

    //format
    private double formatDouble(double number){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.valueOf(decimalFormat.format(number));
    }

    private double calculateIRPF(double calculationBasisIRPF) {
        if (calculationBasisIRPF<=1903.98) return 0;
        if (calculationBasisIRPF<=2826.65) return calculationBasisIRPF * 0.075 - 142.80;
        if (calculationBasisIRPF<=3751.05) return calculationBasisIRPF * 0.15 - 354.80;
        if (calculationBasisIRPF<=4664.68) return calculationBasisIRPF * 0.225 - 636.13;
        return calculationBasisIRPF*0.275 - 869.36;
    }

    private double calculateINSS(double grossSalary) {
        if (grossSalary<=1045) return grossSalary * 0.075;
        if (grossSalary<=2089.60) return grossSalary * 0.09 - 15.67;
        if (grossSalary<=3134.40) return grossSalary * 0.12 - 78.36;
        if (grossSalary<=6101.06) return grossSalary * 0.14 - 141.05;
        return 713.10;
    }
}