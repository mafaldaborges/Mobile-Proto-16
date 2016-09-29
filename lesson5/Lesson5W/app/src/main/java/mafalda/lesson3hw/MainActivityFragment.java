package mafalda.lesson3hw;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment {
    @BindView(R.id.listview_todo) ListView listView;
    TaskDbHelper mDbHelper;

    public MainActivityFragment() {
    }
    /**Allows text to generated and added to the fragment*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDbHelper = new TaskDbHelper(getContext());

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        final ArrayList<ToDoItem> arrayOfItems = new ArrayList <ToDoItem>();
        final ToDoAdapter adapter = new ToDoAdapter(getContext(),arrayOfItems,mDbHelper);

        listView.setAdapter(adapter);
        mDbHelper = new TaskDbHelper(getContext());

        TaskDbHelper taskHelper = new TaskDbHelper(getContext());

        ArrayList<ToDoItem> temp = taskHelper.getAll();
        arrayOfItems.clear();
        arrayOfItems.addAll(temp);
        adapter.notifyDataSetChanged();



        final EditText editText = (EditText) view.findViewById(R.id.text_box);
        String inputText = editText.getText().toString();

        Button addButton = (Button) view.findViewById(R.id.add_item);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**Adds the text the user inputs in the Edit Text to the fragment and saves the information*/
                TaskDbHelper taskHelper = new TaskDbHelper(getContext());
                ToDoItem newItem = new ToDoItem(editText.getText().toString(),0);

                taskHelper.addToDb(newItem);

                ArrayList<ToDoItem> temp = taskHelper.getAll();
                arrayOfItems.clear();
                arrayOfItems.addAll(temp);
                adapter.notifyDataSetChanged();

                editText.setText("");


            }
        });
        ;


            return view;


        }


}

