package com.example.mrtayyab.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private Spinner mSpinnerValue , mSpinnerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mBtn = findViewById(R.id.mBtn);
         mSpinnerValue = findViewById(R.id.mySpinner);
         mSpinnerItem = findViewById(R.id.mySpinnerItem);

       mBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,
                       "OnClickListener : " +
                               "\nSpinner 1 : " + valueOf(mSpinnerValue.getSelectedItem()) +
                               "\nSpinner 2 : " + valueOf(mSpinnerItem.getSelectedItem()),
                       Toast.LENGTH_SHORT).show();

           }
       });


        addItemsOnSpinner2();
        addListenerOnSpinnerItemSelection();
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {



        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }

        });
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner2() {

        mSpinnerItem = (Spinner) findViewById(R.id.mySpinnerItem);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerItem.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        mSpinnerValue = (Spinner) findViewById(R.id.mySpinner);
        mSpinnerValue.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

}
