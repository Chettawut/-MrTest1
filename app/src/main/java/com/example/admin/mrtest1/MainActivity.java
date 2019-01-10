package com.example.admin.mrtest1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private TextView mTextMessage;

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] animalNameList;
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        animalNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey","Monkey"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
        editsearch.setQueryHint("Search Here");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        list.setVisibility(View.VISIBLE);
        String text = newText;
        if(text.equals(""))
            list.setVisibility(View.INVISIBLE);
        else
            adapter.filter(text);

//        Toast.makeText(this, "This is my Toast message!",
//                Toast.LENGTH_LONG).show();
        return false;
    }

    public void OnclickSearch(View v){
        list.setVisibility(View.VISIBLE);
        Toast.makeText(this, "This is my Toast message!",
                Toast.LENGTH_LONG).show();
    }

    public void OnClickTest(View v){
        list.setVisibility(View.VISIBLE);
        Toast.makeText(this, "This is my Toast message!",
                Toast.LENGTH_LONG).show();
    }

}
