package com.example.dell_pc.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void generateTable (int timesTable) {
        ListView myListView = (ListView) findViewById(R.id.myListView);

        ArrayList<String> myArrayList = new ArrayList<String>();

        for (int i = 1; i<15; i++) {

            myArrayList.add(Integer.toString(i*timesTable));

        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.test_list_item, myArrayList);

        myListView.setAdapter(myArrayAdapter);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTableSeekBar.setMax(20);

        timesTableSeekBar.setProgress(10);

       timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               int min = 1;
               int timesTable;

               if (progress < min) {

                   timesTable = min;
                   timesTableSeekBar.setProgress(min);
               }
               else {

                   timesTable = progress;
               }
                generateTable(timesTable);
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

        generateTable (10);


    }
}
