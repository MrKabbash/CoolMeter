package com.erinkabbash.coolmeter;

import java.util.Random;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView scanButton = (ImageView) findViewById(R.id.scanButton);
        
        
        scanButton.setOnTouchListener(new OnTouchListener() {
			
        	//User touches the meter 
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				TextView resultView = (TextView) findViewById(R.id.resultView);
				resultView.setText("Testing.. Keep your finger down!");
				coolTest();
				
				return false;
			}

			private void coolTest() {
				//Delay to scan
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
				  @Override
				  public void run() {
					  //Results of scan are displayed
					  Random generator = new Random();
					  TextView resultView = (TextView) findViewById(R.id.resultView);					  
					  resultView.setText("You are " + generator.nextInt(100) +"% cool");
				  }
				}, 3000);
			}
		});

        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
