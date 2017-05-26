package com.danav.nutrifit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Arrays;


public class foods extends AppCompatActivity {
    private String[] foods = {"Apple 10 20 30", "Orange 20 40 60", "Pear 15 25 30", "Apple 10 20 30", "Orange 20 40 60", "Apple 10 20 30", "Orange 20 40 60", "Apple 10 20 30", "Orange 20 40 60", "Apple 10 20 30", "Orange 20 40 60"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        final ListView lv = (ListView) findViewById(R.id.FoodsListView);
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, foods);
        lv.setAdapter(items);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String[] itemvalue =  (String[]) lv.getItemAtPosition(position);
                String itemactualvalue = Arrays.toString(itemvalue);
            }
        });

        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                try {


                    System.out.println("GotQuery" + query);
                    TextView tv = ((TextView) mainfindViewById(R.id.Sugar));
                    int total;
                    System.out.println("String tv=" + tv.getText());
                    if (tv.getText() == "") {
                        total = 0;
                    } else {
                        total = Integer.parseInt(tv.getText().toString());
                    }
                    System.out.println("total =" + total);

                    if (query == "apple")

                    {
                        total = total + 10;
                    }
                    tv.setText(total);
                }catch(Exception ex ){
                    System.out.println(ex.toString());
                }
                    return true;
            }

            public boolean onQueryTextChange(String newText) {
                return true;
            }

        };
        System.out.println("3");
        SearchView sv = (SearchView) findViewById(R.id.foodSearch);

        sv.setOnQueryTextListener(queryTextListener);

        }
    }


