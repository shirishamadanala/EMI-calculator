package com.developer.smadanala.easyemi;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Gravity;

import android.widget.TableLayout;

import android.widget.TableRow;

import android.widget.TextView;


import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.util.Locale;


public class YearsStatistics extends Activity
 {

   
	 @Override
   
	 protected void onCreate(Bundle savedInstanceState) 
	{
       
	 super.onCreate(savedInstanceState);
 
       setContentView(R.layout.activity_years_statistics);

        Intent intent = getIntent();
    
       long totalAmt = intent.getLongExtra(MainActivity.TOTAL_AMOUNT, 0l);
  
      double interest = intent.getDoubleExtra(MainActivity.INTEREST, 0.0);
 
       double emi = intent.getDoubleExtra(MainActivity.EMI, 0.0);
  
      NumberFormat formatter = DecimalFormat.getInstance(Locale.getDefault());

 
       TableLayout tableLayout = (TableLayout) findViewById(R.id.statistics_years_table);

    
       double principalPaid = 0;

        double principalPaidSoFar = 0;
 
       double interestPaid = 0;
     
        double interestPaidSoFar = 0;
        
       int i = 0;
 
       int j = 0;
 
       while (Math.round(totalAmtLeft) > 0) 
       {
    
        i++;
   
         interestPaid = interest * totalAmtLeft;

            interestPaidSoFar += interestPaid;
  
          principalPaid = emi - interestPaid;
   
         principalPaidSoFar += principalPaid;
         
         totalAmtLeft = totalAmtLeft - principalPaid;

      
         if ((i % 12 == 0)
       || (Math.round(totalAmtLeft) <= 0)) 
        {
        
               j++;
 
               TableRow tableRow = new TableRow(this);

 
               TextView indexView = new TextView(this);
 
               indexView.setText(j + "");
             
               indexView.setGravity(Gravity.CENTER);
               
               TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
       
               indexView.setLayoutParams(params);
 
               tableRow.addView(indexView);

   
               TextView principalPaidView = new TextView(this);
 
               principalPaidView.setText(formatter.format(Math.round(principalPaidSoFar)) + "");
              
              principalPaidView.setGravity(Gravity.CENTER);
 
               params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 3f);
 
               principalPaidView.setLayoutParams(params);
           
              tableRow.addView(principalPaidView);

              
              TextView interestPaidView = new TextView(this);
             
           interestPaidView.setText(formatter.format(Math.round(interestPaidSoFar)) + "");
   
             interestPaidView.setGravity(Gravity.CENTER);
               
             params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 3f);
              
           interestPaidView.setLayoutParams(params);
    
            tableRow.addView(interestPaidView);

           
           TextView totalAmtLeftView = new TextView(this);
      
          totalAmtLeftView.setText(formatter.format(Math.round(totalAmtLeft)) + "");
       
         totalAmtLeftView.setGravity(Gravity.CENTER);
              
         params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 3f);
 
               totalAmtLeftView.setLayoutParams(params);
               
           tableRow.addView(totalAmtLeftView);

               
         tableLayout.addView(tableRow);
        
              interestPaidSoFar = 0;
             
              principalPaidSoFar = 0;
           
 }
       
 }
   
 }

}
