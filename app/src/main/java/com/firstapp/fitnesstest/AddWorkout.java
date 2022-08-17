package com.firstapp.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import org.w3c.dom.Text;

public class AddWorkout extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<String>();
    @Override
    //creates list on screen and on click, calls addItem method
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        ListView listv = (ListView) findViewById(R.id.listView);

        //adapter for list view that holds everything
        listv.setAdapter(new MyListAdapter(this, R.layout.exerfunct, data));
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AddWorkout.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
        //button to add item with textview editd
        Button add = findViewById(R.id.addExer);
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                addItem(listv);

            }
        });
        Button addWorkout = findViewById(R.id.addWork);
        addWorkout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(AddWorkout.this,RoutineActivity.class);
                intent.putExtra("keyname", listv)
            }
        });
        }

    /*removes item from list on long click
    private void setUpListViewListener(){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context =  getApplicationContext();
                Toast.makeText(context, "Exercise Removed", Toast.LENGTH_LONG).show();

                exercises.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    */

    //adds item to the listview
    private void addItem(View view){


        data.add("");

    }


    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;

        private MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        public View getView(final int position, View getView, ViewGroup parent) {
            ViewHolder mainViewHolder = null;

            if (getView == null) {
                //this code makes a new list view if its empty with all the variables from exerfunc
                LayoutInflater inflater = LayoutInflater.from(getContext());
                getView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                EditText tx = findViewById(R.id.textInput);
                String txTit = tx.getText().toString();

                viewHolder.exercise = (TextView) getView.findViewById(R.id.exerciseTitle);
                viewHolder.exercise.setText(txTit);
                tx.setText("");
                viewHolder.weight = (EditText) getView.findViewById(R.id.weightCounter);
                viewHolder.reps = (EditText) getView.findViewById(R.id.repCounter);
                viewHolder.sets = (EditText) getView.findViewById(R.id.sets);
                getView.setTag(viewHolder);
            }



            return getView;
        }


    }

    //view holder for everything
    public class ViewHolder{

        TextView exercise;
        EditText reps;
        EditText weight;
        EditText  sets;

    }


}