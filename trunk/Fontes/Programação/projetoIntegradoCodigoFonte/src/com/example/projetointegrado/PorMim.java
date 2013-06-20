package com.example.projetointegrado;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class PorMim extends View implements Runnable
{
	private Bitmap logo;
	private Bitmap campanhas;
	private Bitmap top5;
	private Bitmap creditos;
	private Bitmap gps;
	private Bitmap barra;
	
	private Rect  areaCampanhas;
	private Rect  areaTop5;
	private Rect  areaCreditos;
	private Rect  areaMapa;
	ImageManager picture;
	Paint paint;
	Activity activity;
	public static final String TAG = "PorMim";
//	View campanhas;
	View loadCampanhas;
	private Context mContext;
	public static boolean clickedListView = false;
	MainActivity mainActivity;
	
	public PorMim(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		this.mContext = (Activity )context;
		
		activity = (Activity) context;

		logo = picture.ImageManager("TelaPrincipal_Cor1_EspacoLogo.png", context);
		campanhas = picture.ImageManager("TelaPrincipal_Cor1_Campanhas.png", context);
		gps = picture.ImageManager("TelaPrincipal_Cor1_Mapa.png", context);
		top5 = picture.ImageManager("TelaPrincipal_Cor1_Top5_Fechado.png", context);
		creditos = picture.ImageManager("TelaPrincipal_Cor1_Creditos.png", context);

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(logo, getWidth()/24, getHeight()/20, paint);
		canvas.drawBitmap(campanhas, getWidth()/24, getHeight()/2.4f, paint);
		canvas.drawBitmap(gps, getWidth()/24,getHeight()/1.8f, paint);
		canvas.drawBitmap(top5, getWidth()/2, getHeight()/20, paint);
		canvas.drawBitmap(creditos, getWidth()/24, getHeight()/1.3f, paint);
		
		// Desenhando os Rects.
		areaCampanhas = new Rect(getWidth()/24,getHeight()/2 - 26, getWidth()/24 + (int)campanhas.getWidth(),
				getHeight()/2 + (int)campanhas.getHeight() - 26);
		
		areaTop5 = new Rect(getWidth()/2, getHeight()/20, getWidth()/2 + (int)top5.getWidth(),
				getHeight()/20 + (int)top5.getHeight());
		
		areaCreditos = new Rect(getWidth()/24,getHeight() - 68, getWidth()/24 + (int)creditos.getWidth(),
				getHeight() - 60 + (int)creditos.getHeight());
		
		areaMapa = new Rect(getWidth()/4,getHeight()/2 + 20,getWidth()/4 + (int)gps.getWidth() - 40, getHeight()/2 + (int)gps.getHeight() + 15);
		
/*		
		canvas.drawRect(areaTop5, paint);
		canvas.drawRect(areaCreditos, paint);
		canvas.drawRect(areaMapa, paint);*/
		canvas.drawRect(areaCampanhas, paint);
}
	
	public boolean onTouchEvent(MotionEvent event) 
	{	
		if (event.getAction() == MotionEvent.ACTION_DOWN) 
		{
			Log.i(TAG, "Entrou no action down");
		}
		
		if (event.getAction() == MotionEvent.ACTION_MOVE) 
		{
			Log.i(TAG, "Entrou no action move");
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			Log.i(TAG, "Entrou no action up");
			int a = (int)event.getRawX();
			int b = (int)event.getRawY();

			// Campanhas
			if(areaCampanhas.contains(a,b))
			{
				// Manoela chamará a listView de Campanhas de PorMim aqui.
				Intent intent = new Intent(activity, Campanhas.class);
				activity.startActivity(intent);
				activity.finish();
				//loadCampanhas = new Campanhas(activity);
				//activity.setContentView(loadCampanhas);	
			}
		}
		
		return super.onTouchEvent(event);
	}
	
	public void run() 
	{
		while(true)
		{
			try
			{	
				Thread.sleep(1);
			}
			
			catch(Exception e)
			{
				Log.e("Deu erro", "Quem sabe mete o pe");
			}
			
			postInvalidate();
		}
		// TODO Auto-generated method stub
	}
	
}
