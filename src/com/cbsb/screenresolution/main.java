package com.cbsb.screenresolution;

import com.cbsb.screenresolution.R.string;
import com.cbsb.screenresolution.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class main extends Activity {

	
	private static final int IDM_About = 101;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        
        findViewById(R.id.frame).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                View frame = findViewById(R.id.frame);
                int height = frame.getMeasuredHeight();
                int width = frame.getWidth();
                
                TextView twidth = (TextView) findViewById(R.id.width);
                twidth.setText(width+"px");
                
                VerticalLabelView theight = (VerticalLabelView) findViewById(R.id.height);
                theight.setText(height+"px");
                
            }
        });
    }
    
    

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(Menu.NONE, IDM_About, Menu.NONE, string.about).setIcon(R.drawable.ic_menu_info_details);
		return super.onCreateOptionsMenu(menu);
	}



	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proalab.com/?page_id=517"));
		startActivity(browserIntent);
		return super.onMenuItemSelected(featureId, item);
	}



	@Override
    protected void onResume() {
        super.onPostResume();
        
        View frame = findViewById(R.id.frame);
        int height = frame.getMeasuredHeight();
        int width = frame.getWidth();
        
        TextView twidth = (TextView) findViewById(R.id.width);
        twidth.setText(width+"px");
        
        VerticalLabelView theight = (VerticalLabelView) findViewById(R.id.height);
        theight.setText(height+"px");
        
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        View frame = findViewById(R.id.frame);
        int height = frame.getMeasuredHeight();
        int width = frame.getWidth();
        
        TextView twidth = (TextView) findViewById(R.id.width);
        twidth.setText(width+"px");
        
        VerticalLabelView theight = (VerticalLabelView) findViewById(R.id.height);
        theight.setText(height+"px");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View frame = findViewById(R.id.frame);
        int height = frame.getMeasuredHeight();
        int width = frame.getWidth();


        float scale = getResources().getDisplayMetrics().density;

        TextView twidth = (TextView) findViewById(R.id.width);
        twidth.setText(width+"px = " + (int)(width/scale) + "dip");
        
        VerticalLabelView theight = (VerticalLabelView) findViewById(R.id.height);
        theight.setText(height+"px = " + (int)(height/scale) + "dip");
        
    }
    
    
    
    
    
}