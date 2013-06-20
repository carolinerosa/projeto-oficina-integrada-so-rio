package com.example.projetointegrado;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Loading extends Activity {

	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    
        setContentView(R.layout.layout_loading);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	// Servidor/Cliente
	public void campanhas(View sender)
	{
		Log.i("loading", "entrei no intent Campanhas ");
		Intent i = new Intent();
		i.setClass(this,Campanhas.class);
		startActivity(i);		
	}
	
}
