package mafalda.lesson3hw;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

    /**Connects the textview of the to do items with the listview of the fragment*/

    public ToDoAdapter(Context context, ArrayList<ToDoItem> toDoItem){
        super(context, 0, toDoItem);
        this.todoList = toDoItem;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        ToDoItem toDoItem = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent,false);
        }

        final TextView task_title = (TextView) convertView.findViewById(R.id.task_title);
        Button deleteButton = (Button) convertView.findViewById(R.id.task_delete);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_box);
        task_title.setText(toDoItem.name);



        //Creates on Click Listner so text can be edited

        task_title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /**When text on fragment is clicked an alert dialog box pops up and allows text to be edited
                 * there is also a cancel functionality*/
                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Change the text!");
                final EditText input = new EditText(view.getContext());
                alertDialog.setView(input);

                alertDialog.setButton(-1, "Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        task_title.setText(input.getText().toString());

                    }
                });
                alertDialog.setButton(-2, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

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
                notifyDataSetChanged();

            }
        });

        if (checkBox.isChecked()){
            /**Adds functionality to the checkbox*/
            checkBox.setChecked(false);
        }

        return convertView;
    }
}
