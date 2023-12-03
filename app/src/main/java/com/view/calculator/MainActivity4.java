package com.view.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    ArrayList<Student> allStudents;
    Context context;
    Db db;
    Context thisContext;
    ListView viewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        allStudents = new ArrayList<Student>();
        context = getApplicationContext();
        thisContext =this;
        db = new Db(context);
        viewStudent = findViewById(R.id.studentList);
        allStudents = db.getAllStudent();
        viewStudent.setAdapter((ListAdapter) new studentListAdapter(allStudents));
        viewStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Student tempStudent =  allStudents.get(position);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(thisContext);
                dialogBuilder.setTitle("Delete Student");
                dialogBuilder.setMessage("Name: "+tempStudent.name+"\nId: "+tempStudent.id);
                dialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteStudent(tempStudent.dbId);
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = dialogBuilder.create();
                dialog.show();

                return false;
            }
        });
    }
    class studentListAdapter extends BaseAdapter {
        ArrayList<Student> allItems;
        studentListAdapter(ArrayList<Student>  items){
            allItems = items;
        }
        @Override
        public int getCount() {
            return allItems.size();
        }

        @Override
        public Object getItem(int position) {
            return allItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            final View row = inflater.inflate(R.layout.student_row,null,true);
            Student tempStudent = (Student) getItem(position);
            TextView viewName,viewId,viewDetails,viewContact;
            viewContact = row.findViewById(R.id.contact);
            viewDetails = row.findViewById(R.id.details);
            viewId = row.findViewById(R.id.id);
            viewName = row.findViewById(R.id.name);
            viewId.setText(tempStudent.getId());
            viewDetails.setText(tempStudent.getDetails());
            viewContact.setText(tempStudent.getContact());
            viewName.setText(tempStudent.getName());
            return row;
        }
    }
}