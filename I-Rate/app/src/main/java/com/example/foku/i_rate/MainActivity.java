package com.example.foku.i_rate;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker dp = this.findViewById(R.id.DateandTime);
        dp.init(2018, 12, 1, null); // set to 1st December 2018
        Spinner sp = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.Restaurant_Types_array, android.R.layout.simple_spinner_item); //get the items for the drop down menu of the restaurant types
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line); //set the display for the drop down menu
        sp.setAdapter(adapter);
        Button btnSubmit = findViewById(R.id.SubmitBtn);

       btnSubmit.setOnClickListener( new OnClickListener() {
           @Override
           public void onClick(View v) {
            displaySubmitAlert();
           }

           private void displaySubmitAlert() {
               EditText nameInput = (EditText) findViewById(R.id.NameRestaurant); //get input of the field restaurant name
               Spinner sp = (Spinner) findViewById(R.id.spinner);
               DatePicker dateInput = (DatePicker) findViewById(R.id.DateandTime);
               EditText numberInput = (EditText) findViewById(R.id.price);
               EditText nameInput2 = (EditText) findViewById(R.id.reporter);

               String strName = nameInput.getText().toString();
               String strDate = dateInput.getDayOfMonth() + "/" + (dateInput.getMonth() + 1) + "/" + (dateInput.getYear());
               int strSp = sp.getSelectedItemPosition();
               String strPrice = numberInput.getText().toString();
               String strName2 = nameInput2.getText().toString();
               //validation fot user input of required fields
               if (nameInput.getText().length() == 0 || numberInput.getText().length() == 0 || nameInput2.getText().length() == 0) {
                   Builder alertDialog;
                   alertDialog = new Builder(MainActivity.this);
                   setTitle( R.string.Error);
                   alertDialog.setMessage("Fields cannot be empty");
                           alertDialog.show();
               } else{
                   AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(MainActivity.this);
                   setTitle( R.string.Success);
                   alertDialog1.setMessage("Details entered: \n" + strName + "\n" + strDate + "\n" + strSp + "\n" + strPrice + "\n" + strName2);
                       alertDialog1.show(); //show the user what they have inputted
               }


           }
       } );
    }


}


