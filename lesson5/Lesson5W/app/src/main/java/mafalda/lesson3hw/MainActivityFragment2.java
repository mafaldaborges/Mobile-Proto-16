package mafalda.lesson3hw;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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

    public MainActivityFragment2(){
    }
    /**Fragment changes background color of activity*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);

        Button blueButton = (Button) view.findViewById(R.id.blueone);
        Button redButton = (Button) view.findViewById(R.id.redone);
        Button greenButton = (Button) view.findViewById(R.id.greenone);
        Button whiteButton = (Button) view.findViewById(R.id.whiteone);




        blueButton.setOnClickListener(new ColorListener("#000066", (MainActivity) getActivity()));
        redButton.setOnClickListener(new ColorListener("#cd2626", (MainActivity) getActivity()));
        greenButton.setOnClickListener(new ColorListener("#228b22", (MainActivity) getActivity()));
        whiteButton.setOnClickListener(new ColorListener("#fffaf0", (MainActivity) getActivity()));




        return view;
    }




}
