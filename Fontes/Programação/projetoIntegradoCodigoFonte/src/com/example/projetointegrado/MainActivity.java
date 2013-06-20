package com.example.projetointegrado;

import java.util.ArrayList;
import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;

// Classe equivalente a tela inicial, onde todas as opções são mostradas ao usuário.
public class MainActivity extends Activity 
{
	
	public final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    MenuInicial menu = new MenuInicial(this);
		setContentView(menu);	
//	    Intent intent = new Intent(this, Campanhas.class);
//				this.startActivity(intent);
//				((Activity)this).finish();	
	    
//	   Campanhas menu = new Campanhas(this);
//		setContentView(menu);
//		
	}
}
