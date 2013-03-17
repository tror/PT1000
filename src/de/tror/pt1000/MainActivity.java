package de.tror.pt1000;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	Double ohm;
    EditText getohm;
	TextView settemp;
	TextView setohm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        settemp = (TextView) findViewById(R.id.settemp);
        setohm = (TextView) findViewById(R.id.setohm);
        getohm =  (EditText) findViewById(R.id.getohm);
          
   		getohm.setOnKeyListener(new OnKeyListener() {           
            
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                	String sohm = getohm.getText().toString();
                	if(sohm.length() > 0)
                	{	
                	ohm =  Double.valueOf(sohm);
                	
                    Log.e("ohm ist ",Double.toString(ohm));
                    
                    Double r = (ohm/1000)-1;
                    
                    Log.e("r ist ",Double.toString(r));
                    
                    Double temp = (r * (255.8723 + r*(9.6+r*0.878)));
               		String stemp=Double.toString(Math.rint(temp*100.0)/100.0);                    
               		getohm.setText("");
               		setohm.setText(sohm);
               		settemp.setText(stemp);

               		return true;
                	}
                	else {
                		settemp.setText("---.--");
					}
                }
                return false;
            }
        });
        
        }
    




/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}
