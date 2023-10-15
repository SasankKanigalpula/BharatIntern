package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTV,solutionTV;
    MaterialButton buttonC,buttonOpen,buttonClose;
    MaterialButton buttondivide,buttonMultiply,buttonMinus,buttonPlus,buttonEquals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;
    String finalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV=findViewById(R.id.result_textview);
        solutionTV=findViewById(R.id.question_textview);

        assignId(buttonC,R.id.button_C);
        assignId(buttonOpen,R.id.button_open_bracket);
        assignId(buttonClose,R.id.button_close_bracket);
        assignId(buttondivide,R.id.button_divide);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonMinus,R.id.button_subtract);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonEquals,R.id.button_equal_to);
        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(button0,R.id.button_0);
        assignId(buttonDot,R.id.button_dot);
        assignId(buttonAC,R.id.button_ac);

    }
    void assignId(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
        String dataToCal=solutionTV.getText().toString();

        if(buttonText.equals("AC")){
            resultTV.setText("0");
            solutionTV.setText("");
            return;
        }
        if(buttonText.equals("=")){
            solutionTV.setText(resultTV.getText());
            return;
        }
        if(buttonText.equals("C")){
            dataToCal=dataToCal.substring(0,dataToCal.length()-1);

        }

        else{
            dataToCal=dataToCal+buttonText;
        }
        solutionTV.setText(dataToCal);
        finalResult = getResult(dataToCal);


        if(finalResult.endsWith(".0")){
            finalResult=finalResult.replace(".0","");
        }
        if(!finalResult.equals("Err")){
            resultTV.setText(finalResult);
        }
    }
    String getResult(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalString = context.evaluateString(scriptable,data,"Javascript",1,null).toString();

            return finalString;
        }
        catch(Exception e) {
            return "Err";
        }
    }
}