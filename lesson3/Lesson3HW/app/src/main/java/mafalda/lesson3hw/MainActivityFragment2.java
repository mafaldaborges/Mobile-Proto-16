package mafalda.lesson3hw;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mafaldaborges on 9/14/16.
 */
public class MainActivityFragment2 extends Fragment{
    public MainActivityFragment2(){
    }
    // There are two ways of making comments in Java:
    // like this
    /** and like this **/
    // The /** is better for long block comments since you can do
    /**
     * something like this
     * which is long
     *  to comment
     * **/
    // `//` is better for inline comments

    /**Fragment changes background color of activity*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);
        Button blueButton = (Button) view.findViewById(R.id.blueone);
        Button redButton = (Button) view.findViewById(R.id.redone);
        Button greenButton = (Button) view.findViewById(R.id.greenone);
        Button whiteButton = (Button) view.findViewById(R.id.whiteone);
        // can declare actView once to avoid redundancy
        final View actView = getActivity().findViewById(R.id.actmain);
        blueButton.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view){
            /**When blueButton is clicked background color of activity changes to blue*/
            actView.setBackgroundColor(Color.parseColor("#000066"));
        }

        });

        redButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When redButton is clicked background color of activity changes to red*/
                actView.setBackgroundColor(Color.parseColor("#cd2626"));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When greenButton is clicked background color of activity changes to green*/
                actView.setBackgroundColor(Color.parseColor("#228b22"));
            }
        });

        whiteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When whiteButton is clicked background color of activity changes to white*/
                actView.setBackgroundColor(Color.parseColor("#fffaf0"));
            }
        });

        return view;
    }




}
