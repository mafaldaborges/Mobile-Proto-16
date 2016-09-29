package mafalda.lesson3hw;

import android.graphics.Color;
import android.graphics.Interpolator;
import android.util.Log;
import android.view.View;

/**
 * Created by mafaldaborges on 9/19/16.
 */
public class ColorListener implements View.OnClickListener {
    /**Creates a class for changing the background color of the activity when a button is pressed*/

    private String hexvaluecolor;
    private MainActivity mainActivity;

    public ColorListener(String hcolor, MainActivity mainActivity) {
        hexvaluecolor = hcolor;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {

        mainActivity.findViewById(R.id.actmain).setBackgroundColor(Color.parseColor(hexvaluecolor));
        mainActivity.setMyColor(Color.parseColor(hexvaluecolor));


    }
}
