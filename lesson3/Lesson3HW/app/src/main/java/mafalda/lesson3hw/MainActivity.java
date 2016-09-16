package mafalda.lesson3hw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static int PAGE = 1;

    /**Runs both fragments, main activity*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Set main fragment as the default when the app is opened
        changeFragment(new MainActivityFragment2(), new MainActivityFragment());



        Button buttonSwitch = (Button) this.findViewById(R.id.change_task);
        buttonSwitch.setOnClickListener(new View.OnClickListener(){
            /**Uses switch button to go between fragments by using a static int, a ninja helped with this*/
            @Override
            public void onClick(View view) {

                if (PAGE == 2) {
                    changeFragment(new MainActivityFragment2(), new MainActivityFragment());
                    PAGE = 1;
                } else {
                    changeFragment(new MainActivityFragment(), new MainActivityFragment2());
                    PAGE = 2;
                }
            }
        });

    }

    public void changeFragment(Fragment oldFragment, Fragment newFragment) {
        /**Function to switch between fragments, my previous work was turned into a function by a ninja
         * who showed me how to make my code cleaner*/
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.remove(oldFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            case R.id.action_add_task:
                Log.d(TAG, "Add a new task");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
