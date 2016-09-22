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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mafaldaborges on 9/14/16.
 */
public class MainActivityFragment2 extends Fragment{
    // Try to follow better naming conventions
    @BindView(R.id.actmain) TextView textView;
    public MainActivityFragment2(){
    }
    /**Fragment changes background color of activity*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);
        ButterKnife.bind(this, view);
        Button blueButton = (Button) view.findViewById(R.id.blueone);
        Button redButton = (Button) view.findViewById(R.id.redone);
        Button greenButton = (Button) view.findViewById(R.id.greenone);
        Button whiteButton = (Button) view.findViewById(R.id.whiteone);

        /*
        This section could be rewritten in a cleaner way if you encapsulated the color changing functionality
        into a separate function. Additionally, you should store colors in the colors.xml resource file instead
        of typing out the RGB code by hand - this will make the code much more maintainable
         */
        blueButton.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view){
            /**When blueButton is clicked background color of activity changes to blue*/
            View actView = getActivity().findViewById(R.id.actmain);
            actView.setBackgroundColor(Color.parseColor("#000066"));
        }

        });

        redButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When redButton is clicked background color of activity changes to red*/
                View actView2 = getActivity().findViewById(R.id.actmain);
                actView2.setBackgroundColor(Color.parseColor("#cd2626"));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When greenButton is clicked background color of activity changes to green*/
                View actView3 = getActivity().findViewById(R.id.actmain);
                actView3.setBackgroundColor(Color.parseColor("#228b22"));
            }
        });

        whiteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /**When whiteButton is clicked background color of activity changes to white*/
                View actView4 = getActivity().findViewById(R.id.actmain);
                actView4.setBackgroundColor(Color.parseColor("#fffaf0"));
            }
        });

        return view;
    }




}
