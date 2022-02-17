package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {
   EditText ed1,ed2,ed3;
   AppCompatButton b1,b2;
   String getpcode,getpname,getprice;
   DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.pcode);
        ed2=(EditText) findViewById(R.id.pname);
        ed3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.sub);
        b2=(AppCompatButton) findViewById(R.id.btm);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpcode=ed1.getText().toString();
                getpname=ed2.getText().toString();
                getprice=ed3.getText().toString();

       boolean result=dbhelper.insertData(getpcode,getpname,getprice);

       if (result==true)
       {
           ed1.setText("");
           ed2.setText("");
           ed3.setText("");


           Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_SHORT).show();

       }
       else
       {
           Toast.makeText(getApplicationContext(),"failed to insert",Toast.LENGTH_SHORT).show();

       }


            }
        });

      b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),MainActivity.class);
              startActivity(i);
          }
      });

    }
}