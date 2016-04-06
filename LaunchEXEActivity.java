package kn.remotus;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LaunchEXEActivity extends ClientActivity 
{
	private RelativeLayout layout;
	private Button firefoxButton;
	private Button wordButton;
	private Button lolButton;
	private Button photoshopButton;
	private Button steamButton;
	private Button macros;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		layout = new RelativeLayout(this);
		
		firefoxButton = new Button(this);
		firefoxButton.setId(1);
		RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p1.height = 120;
		p1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		firefoxButton.setBackgroundResource(R.drawable.firefoxlaunchbutton);
		firefoxButton.setLayoutParams(p1);
		firefoxButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				launchExe(0);
			}
		});
		
		wordButton = new Button(this);
		wordButton.setId(2);
		RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p2.height = 120;
		p2.addRule(RelativeLayout.BELOW, firefoxButton.getId());
		wordButton.setBackgroundResource(R.drawable.wordlaunchbutton);
		wordButton.setLayoutParams(p2);
		wordButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				launchExe(1);
			}
		});
		
		lolButton = new Button(this);
		lolButton.setId(3);
		RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p3.height = 120;
		p3.addRule(RelativeLayout.BELOW, wordButton.getId());
		lolButton.setBackgroundResource(R.drawable.lollaunchbutton);
		lolButton.setLayoutParams(p3);
		lolButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				launchExe(4);
			}
		});
		
		photoshopButton = new Button(this);
		photoshopButton.setId(4);
		RelativeLayout.LayoutParams p4 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p4.height = 120;
		p4.addRule(RelativeLayout.BELOW, lolButton.getId());
		photoshopButton.setBackgroundResource(R.drawable.photoshoplaunchbutton);
		photoshopButton.setLayoutParams(p4);
		photoshopButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				launchExe(2);
			}
		});
		
		steamButton = new Button(this);
		steamButton.setId(5);	
		RelativeLayout.LayoutParams p5 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p5.height = 120;
		p5.addRule(RelativeLayout.BELOW, photoshopButton.getId());
		steamButton.setBackgroundResource(R.drawable.steamlaunchbutton);
		steamButton.setLayoutParams(p5);
		steamButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				launchExe(3);
			}
		});
		
		macros = new Button(this);
		macros.setId(6);
		RelativeLayout.LayoutParams p6 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		p6.height = 120;
		p6.addRule(RelativeLayout.BELOW, steamButton.getId());
		macros.setText("Macros");
		macros.setLayoutParams(p6);
		macros.setOnClickListener(new OnClickListener() {
			public void onClick(View view)
			{
				Intent launchIntent = new Intent(LaunchEXEActivity.this, MacroActivity.class);
	    		launchIntent.putExtra(ClientActivity.INTENT_SERVERIP_KEY, SpeechRecognitionActivity.serverIP);
	    		startActivity(launchIntent);
			}
		});
		
		layout.addView(firefoxButton);
		layout.addView(steamButton);
		layout.addView(photoshopButton);
		layout.addView(lolButton);
		layout.addView(wordButton);
		layout.addView(macros);
		setContentView(layout);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
        	Intent launchIntent = new Intent(this, MouseAndKeyboardActivity.class);
    		launchIntent.putExtra(ClientActivity.INTENT_SERVERIP_KEY, SpeechRecognitionActivity.serverIP);
    		startActivity(launchIntent);
        }
        else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
        	Intent launchIntent = new Intent(this, SpeechRecognitionActivity.class);
    		launchIntent.putExtra(ClientActivity.INTENT_SERVERIP_KEY, SpeechRecognitionActivity.serverIP);
    		startActivity(launchIntent);
        }
        else if(keyCode == KeyEvent.KEYCODE_BACK)
        {
        	Intent launchIntent = new Intent(this, ConnectActivity.class);
    		startActivity(launchIntent);
        }
        return true;
    }
	
	public void launchExe(int i)
	{
		sendInteger(RemotusProtocol.LAUNCH_EXE, i);
	}
}
