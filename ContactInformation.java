package com.developer.smadanala.easyemi;


import android.content.Intent;

import android.net.Uri;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;

import android.view.Menu;

import android.view.MenuItem;




public class ContactInformation extends ActionBarActivity
 {

   
 @Override
  
  protected void onCreate(Bundle savedInstanceState)
 {
      
  super.onCreate(savedInstanceState);
   
     setContentView(R.layout.activity_contact_information);
  
      getSupportActionBar().setHomeButtonEnabled(true);
     
   getSupportActionBar().setDisplayShowHomeEnabled(true);
     
   getSupportActionBar().setDisplayUseLogoEnabled(true);
      
  getSupportActionBar().setDisplayShowTitleEnabled(true);
     
   getSupportActionBar().setIcon(R.drawable.easy_emi_launcher);

    }

   
 @Override
 
   public boolean onCreateOptionsMenu(Menu menu)
 {
    
    // Inflate the menu; this adds items to the action bar if it is present.
     
   getMenuInflater().inflate(R.menu.menu_contact_information, menu);
    
    return true;
   
 }

  
  @Override
   
 public boolean onOptionsItemSelected(MenuItem item)
 {
       
 // Handle action bar item clicks here. The action bar will
 
       // automatically handle clicks on the Home/Up button, so long
    
    // as you specify a parent activity in AndroidManifest.xml.
     
   int id = item.getItemId();

 
       switch (id)
 {
        
    case R.id.action_contact:
                Intent contactIntent = new Intent(this, ContactInformation.class);
            
    startActivity(contactIntent);
             
   break;
     
       case R.id.action_share:
     
           Intent sendIntent = new Intent();
      
          sendIntent.setAction(Intent.ACTION_SEND);
  

              sendIntent.putExtra(Intent.EXTRA_TEXT, Constants.SHARE_INFORMATION);
   
             sendIntent.setType("text/plain");
             
   startActivity(sendIntent);
             
   break;
          
  case R.id.action_rate:
    
            Intent rateIntent = new Intent();
  
              rateIntent.setData(Uri.parse(Constants.MOBILE_APP_LINK));
 
               startActivity(rateIntent);
               
 break;
      
      default:
                return super.onOptionsItemSelected(item);
     
   }

     
   return super.onOptionsItemSelected(item);
  
  }

}

