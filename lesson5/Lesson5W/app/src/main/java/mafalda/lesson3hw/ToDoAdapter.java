package mafalda.lesson3hw;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mafaldaborges on 9/16/16.
 */
public class ToDoAdapter extends ArrayAdapter<ToDoItem> {
    @BindView(R.id.task_title) TextView textView;
    private Context context;
    private ArrayList<ToDoItem> todoList;
    private TaskDbHelper dbHelper;



    /**Connects the textview of the to do items with the listview of the fragment*/

    public ToDoAdapter(Context context, ArrayList<ToDoItem> toDoItem, TaskDbHelper taskDbHelper){
        super(context, 0, toDoItem);
        this.todoList = toDoItem;
        this.context = context;
        this.dbHelper = taskDbHelper;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ToDoItem toDoItem = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent,false);
        }

        final TextView task_title = (TextView) convertView.findViewById(R.id.task_title);
        Button deleteButton = (Button) convertView.findViewById(R.id.task_delete);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);
        task_title.setText(toDoItem.name);
        checkBox.setChecked(toDoItem.complete == 1);




        //Creates on Click Listener so text can be edited

        task_title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /**When text on fragment is clicked an alert dialog box pops up and allows text to be edited
                 * there is also a cancel functionality
                 * The data is saved if a user changes the text*/
                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Change the text!");
                final EditText input = new EditText(view.getContext());
                alertDialog.setView(input);

                alertDialog.setButton(-1, "Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userString = input.getText().toString();
                        ToDoItem taskThing = new ToDoItem(userString,0);
                        task_title.setText(userString);
                        updateData(position,taskThing);

                    }
                });
                alertDialog.setButton(-2, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alertDialog.show();

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            /**Allows to do item to be deleted*/
            @Override
            public void onClick(View view){
                todoList.remove(position);
                dbHelper.deleteRow(toDoItem);
                notifyDataSetChanged();


            }
        });

        checkBox.setOnClickListener(new View.OnClickListener(){
            /**Allows checkbox to be checked/unchecked and saves the state of the checkbox*/
            public void onClick (View view){
                Boolean completed = checkBox.isChecked();
                toDoItem.complete = completed ? 1 : 0;
                updateData(position,toDoItem);

            }
        });



        return convertView;
    }

    public void refreshData(){
        /**Clears and repopulates the array list and notifies the adapter of a change in data*/
        todoList.clear();
        todoList.addAll(dbHelper.getAll());
        notifyDataSetChanged();
    }

    public void updateData(int pos,ToDoItem toDoItem){
        /** Updates the array of list items as well as updates the SQL table*/
        ArrayList<ToDoItem> temp = dbHelper.getAll();
        dbHelper.updateArray(temp.get(pos).getId(),toDoItem);
        refreshData();

    }
}

