package com.chenlaoshi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.add:
            case R.id.sub:
            case R.id.mul:
            case R.id.div:
            case R.id.dot:{
                Button btn = (Button) view;
                String zero =  btn.getText().toString();
                TextView textView = (TextView) findViewById(R.id.fomula_area);
                String fomulaText = textView.getText().toString();
                textView.setText(fomulaText+zero);
                break;
            }
            case R.id.C:{
                TextView fomula_area = (TextView) findViewById(R.id.fomula_area);
                TextView result_area = (TextView) findViewById(R.id.result_area);
                fomula_area.setText("");
                result_area.setText("");
                break;

            }
            case R.id.DEL:{
                TextView fomula_area = (TextView) findViewById(R.id.fomula_area);
                String fomula = fomula_area.getText().toString();
                if(fomula.length()>0){
                    fomula_area.setText(fomula.substring(0, fomula.length()-1));
                }
                break;
            }
            case R.id.equal:{
                TextView fomula_area = (TextView) findViewById(R.id.fomula_area);
                TextView result_area = (TextView) findViewById(R.id.result_area);
                Symbols symbols = new Symbols();
                try {
                    String fomulaText = fomula_area.getText().toString();
                    if(fomulaText.length()>0){
                        double eval = symbols.eval(fomulaText);
                        result_area.setText(String.valueOf(eval));
                        fomula_area.setText("");
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "请输入正确的表达式", Toast.LENGTH_SHORT).show();
                }
                break;

            }


        }

    }
}
