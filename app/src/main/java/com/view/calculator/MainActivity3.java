package com.view.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private Button btnAllStd,btnSaveStd;
    Context context;
    EditText viewName,viewId,viewContact,vDetails;
    Db db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        context = getApplicationContext();
        db = new Db(context);
        btnAllStd = (Button) findViewById(R.id.btnAllStd);
        btnSaveStd = findViewById(R.id.btnSaveStd);

        viewName = findViewById(R.id.name);
        viewId = findViewById(R.id.id);
        viewContact = findViewById(R.id.contact);
        vDetails = findViewById(R.id.details);

        btnSaveStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,id,details,contact;
                name = viewName.getText().toString();
                id= viewId.getText().toString();
                details = vDetails.getText().toString();
                contact = viewContact.getText().toString();
                if(name.isEmpty() || id.isEmpty() || contact.isEmpty()){
                    Toast.makeText(context,"Name, USN and Contact Field are Required.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Student student = new Student(name,id,details,"",contact);
                db.addStudent(student);
                Toast.makeText(context,"Student Save Successfully",Toast.LENGTH_SHORT).show();
                clearInputBox();
            }
        });

        btnAllStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity4.class);
                startActivity(intent);
            }
        });

    }
    public void clearInputBox()
    {
        viewName.setText("");
        viewId.setText("");
        viewContact.setText("");
        vDetails.setText("");
    }
}