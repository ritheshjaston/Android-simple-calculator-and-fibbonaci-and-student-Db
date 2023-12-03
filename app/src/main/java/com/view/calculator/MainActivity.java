package com.view.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
public class MainActivity extends AppCompatActivity {
    TextView result_tv;
    Button button_ac,button_c,button_divide,button_multiply,button_plus,button_minus,button_equals;
    Button button_7,button_8,button_9,button_6,button_5,button_4,button_3,button_2,button_1,button_0,button_dot,button_open_bracket,button_close_bracket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        result_tv=(TextView) findViewById(R.id.result_tv);
        result_tv.setText("");
        button_close_bracket=(Button) findViewById(R.id.button_close_bracket);
        button_close_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+")");
            }
        });
        button_open_bracket=(Button) findViewById(R.id.button_open_bracket);
        button_open_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"(");
            }
        });

        button_0=(Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"0");
            }
        });
        button_1=(Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"1");
            }
        });
        button_2=(Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"2");
            }
        });
        button_3=(Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"3");
            }
        });
        button_4=(Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"4");
            }
        });
        button_5=(Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"5");
            }
        });
        button_6=(Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"6");
            }
        });
        button_7=(Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"7");
            }
        });
        button_8=(Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"8");
            }
        });
        button_9=(Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"9");
            }
        });
        button_dot=(Button) findViewById(R.id.button_dot);
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+".");
            }
        });

        button_c=(Button) findViewById(R.id.button_c);
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText("");
            }
        });
        button_divide=(Button) findViewById(R.id.button_divide);
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"/");
            }
        });
        button_multiply=(Button) findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"*");
            }
        });
        button_plus=(Button) findViewById(R.id.button_plus);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"+");
            }
        });
        button_minus=(Button) findViewById(R.id.button_minus);
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_tv.setText(result_tv.getText()+"-");
            }
        });
        button_equals=(Button) findViewById(R.id.button_equals);
        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //actual operation
                String expression = result_tv.getText().toString();
                try {
                    double result = new ExpressionBuilder(expression)
                            .build()
                            .evaluate();

                    // Assuming you want to display the result as a string in the TextView
                    result_tv.setText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    // Handle arithmetic exceptions if the expression is invalid
                    result_tv.setText("Error");
                }
            }
        });

        button_ac=(Button) findViewById(R.id.button_ac);
        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}