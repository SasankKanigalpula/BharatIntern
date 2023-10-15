package com.bharat_intern.temperature_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner temp1,temp2;
    EditText originalTemp;
    TextView convertedTemp;
    Button convertButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp1=findViewById(R.id.tempFrom);
        temp2=findViewById(R.id.tempTo);
        convertedTemp=findViewById(R.id.FinalTemp);
        originalTemp=findViewById(R.id.intialTemp);
        convertButton=findViewById(R.id.convert);

        String[] TempFrom={"Celsius","Farenheit","Kelvin"};
        ArrayAdapter spinner1= new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,TempFrom);
        temp1.setAdapter(spinner1);

        String[] TempTo={"Celsius","Farenheit","Kelvin"};
        ArrayAdapter spinner2= new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,TempTo);
        temp2.setAdapter(spinner2);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double FinalTemp;
                Double Temp = Double.parseDouble(originalTemp.getText().toString());
                if (temp1.getSelectedItem().toString().equals("Celsius") && temp2.getSelectedItem().toString().equals("Farenheit")) {
                    FinalTemp=((Temp*1.8)+32);
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if (temp1.getSelectedItem().toString().equals("Celsius")  && temp2.getSelectedItem().toString().equals("Kelvin")) {
                    FinalTemp=Temp+273.15;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }


                else if (temp1.getSelectedItem().toString().equals("Farenheit") && temp2.getSelectedItem().toString().equals("Farenheit")) {
                    FinalTemp=Temp;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if (temp1.getSelectedItem().toString().equals("Farenheit") && temp2.getSelectedItem().toString().equals("Kelvin")){
                    FinalTemp=((Temp-32)*5.0/9.0)+273.15;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if (temp1.getSelectedItem().toString().equals("Farenheit") && temp2.getSelectedItem().toString().equals( "Celsius")) {
                    FinalTemp=(5.0/9.0)*(Temp-32);
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }


                else if (temp1.getSelectedItem().toString().equals("Kelvin") && temp2.getSelectedItem().toString().equals("Kelvin")) {
                    FinalTemp=Temp;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if (temp1.getSelectedItem().toString().equals("Kelvin") && temp2.getSelectedItem().toString().equals("Farenheit")){
                    FinalTemp=((Temp-273.15)*5.0/9.0)+273.15;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if (temp1.getSelectedItem().toString().equals("Kelvin") && temp2.getSelectedItem().toString().equals("Celsius")) {
                    FinalTemp=Temp-273.15;
                    String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                    convertedTemp.setText(FinalTemperature);
                }
                else if(temp1.getSelectedItem().toString().equals("Celsius") && temp2.getSelectedItem().toString().equals("Celsius")) {

                        FinalTemp=Temp;
                        String FinalTemperature=FinalTemp+" degrees "+temp2.getSelectedItem().toString();
                        convertedTemp.setText(FinalTemperature);
                    }
            }
        });



    }
}