package com.example.projetointegrado;

import Creditos.CreditosPeloMundo;
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

public class PeloMundo extends View implements Runnable
{
	private Bitmap background;
	
	private Rect  areaCampanhas;
	private Rect  areaTop5;
	private Rect  areaCreditos;
	private Rect  areaMapa;
	private Rect  areaMapa2;
	private Rect  areaBarra;	
	private Rect  areaLogo;		
	
	ImageManager picture;
	Paint paint;
	Activity activity;
	public static final String TAG = "PorMim";
	View CampanhaTeste;
	View creditosPeloMundo;
	View menu;
	View peloMundoTop5;

	public PeloMundo(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;

		background = picture.ImageManager("TelaPrincipal_Pelomundo.png", context);

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(background, 0, -20, paint);
		
		// Desenhando os Rects.
		areaCampanhas = new Rect(17, 130, 115, 165);	
		areaTop5 = new Rect(130, 20, 230, 45);				
		areaCreditos = new Rect(10, 235, 55, 275);
		areaMapa = new Rect(65, 170, 225, 270);
		areaMapa2 = new Rect(20, 170, 60, 230);
		areaBarra = new Rect(10, 285, 230,300);
		areaLogo = new Rect(20, 20,120,120);
				
/*		canvas.drawRect(areaCreditos, paint);
		canvas.drawRect(areaCampanhas, paint);
		canvas.drawRect(areaTop5, paint);
		canvas.drawRect(areaMapa, paint);
		canvas.drawRect(areaMapa2, paint);
		canvas.drawRect(areaBarra, paint);*/
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
			int a = (int)event.getX();
			int b = (int)event.getY();

			// Campanhas
			if(areaCampanhas.contains(a,b))
			{
				Log.i(TAG, "Escolhi todas as campanhas por mim");
				// Manoela chamará a listView de Campanhas de PorMim aqui.
				Intent intent = new Intent(activity, CampanhasPeloMundo.class);
				activity.startActivity(intent);
				activity.finish();
			}
			
			// Mapas
			if(areaMapa.contains(a,b))
			{
				// Vitória chamará o mapa geral aqui.
				
			}
			
			// Top 5
			if(areaTop5.contains(a,b))
			{
				peloMundoTop5 = new PeloMundoTop5(activity);
				activity.setContentView(peloMundoTop5);				
			}
			
			// Créditos
			if(areaCreditos.contains(a,b))
			{
				creditosPeloMundo = new CreditosPeloMundo(activity);
				activity.setContentView(creditosPeloMundo);				
			}
			
			if (areaLogo.contains(a,b))
			{
				menu = new MenuInicial(activity);
				activity.setContentView(menu);
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
				Log.e("Deu erro", "Exceção do método run.");
			}
			
			postInvalidate();
		}
		// TODO Auto-generated method stub
	}
	
}
