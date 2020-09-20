package com.example.gpa_dongalad1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Region;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    TextView Total, GPA;
    EditText Course1, Course2, Course3, Course4, Course5;
    Button ComputeGPA;
    float Total_val;
    int c1, c2, c3, c4, c5;
    int value = 500;
    float r1;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.ComputeGPA);
        GPA = (TextView) findViewById(R.id.GPA);
        Total = (TextView) findViewById(R.id.Total);
        Course1 = (EditText) findViewById(R.id.Course1);
        Course2 = (EditText) findViewById(R.id.Course2);
        Course3 = (EditText) findViewById(R.id.Course3);
        Course4 = (EditText) findViewById(R.id.Course4);
        Course5 = (EditText) findViewById(R.id.Course5);
        ComputeGPA = (Button) findViewById(R.id.ComputeGPA);
        view = this.getWindow().getDecorView();

        ComputeGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(Course1.getText().toString()) || TextUtils.isEmpty(Course2.getText().toString()) ||
                        TextUtils.isEmpty(Course3.getText().toString()) || TextUtils.isEmpty(Course4.getText().toString())
                        || TextUtils.isEmpty(Course5.getText().toString()) )
                {
                    Toast.makeText(MainActivity.this, "Empty Field Not Allowed", Toast.LENGTH_SHORT).show();
                }
                else{

                    c1 = Integer.parseInt(Course1.getText().toString());
                    c2 = Integer.parseInt(Course2.getText().toString());
                    c3 =Integer.parseInt(Course3.getText().toString());
                    c4 = Integer.parseInt(Course4.getText().toString());
                    c5 = Integer.parseInt(Course5.getText().toString());

                    Total_val = c1 + c2 + c3 + c4 + c5;
                    r1 = (Total_val / value) * 100;
                    GPA.setText(String.valueOf(r1));
                    Total.setText(String.valueOf(Total_val));
                    if (r1 >= 80) {
                        GoGreen();
                    } else if (r1 > 60 & r1 < 80) {
                        GoYellow();
                    } else {
                        GoRed();
                    }
                }


            }});}

   private void GoYellow()
         {
        view.setBackgroundResource(R.color.Yellow);
        }
          private void GoRed()
    {
        view.setBackgroundResource(R.color.Red);
    }
    private void GoGreen()
    {
        view.setBackgroundResource(R.color.Green);
    }
}







