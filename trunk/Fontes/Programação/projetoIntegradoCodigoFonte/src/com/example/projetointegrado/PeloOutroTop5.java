package com.example.projetointegrado;

import Creditos.CreditosPeloOutro;
import Creditos.CreditosPorMim;
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

public class PeloOutroTop5 extends View implements Runnable
{
	private Bitmap imgBackground;
	private Bitmap imgLogo;
	private Bitmap imgmapa;
	private Bitmap imgTop5;
	private Bitmap imgCreditos;
	private Bitmap imgCampanhas;
	private Bitmap imgTexto;	
	
	private Rect  areaCampanhas;
	private Rect  areaTop5;
	private Rect  areaCreditos;
	private Rect  areaMapa;
	private Rect  areaMapa2;
	private Rect  areaBarra;	
	private Rect  areaLogo;	
	private Rect  areaBackground;
	private Rect  areaTexto;
	
	
	ImageManager picture;
	Paint paint;
	Activity activity;
	public static final String TAG = "PorMim";
	View CampanhaTeste;
	View creditosPorMim;
	View menu;
	View porMimTop5;
	
	boolean top5;
	
	public PeloOutroTop5(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;
		
		imgBackground = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgLogo = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgmapa = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgTop5 = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgCampanhas = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgCreditos = picture.ImageManager("TelaPrincipal_Pormim.png", context);
//		imgTexto = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		areaBackground = new Rect(0,0,getWidth(),getHeight());

		areaLogo = new Rect((int)(getWidth()/12),(int)(getHeight()/13.5),(int)(getWidth()/2.15f),(int)(getHeight()/2.65f));

		areaCampanhas = new Rect((int)(getWidth()/12),(int)(getHeight()/2.3),(int)(getWidth()/2.15f),(int)(getHeight()/1.9f));

		areaCreditos = new Rect((int)(getWidth()/14),(int)(getHeight()/1.28),(int)(getWidth()/5f),(int)(getHeight()/1.12f));
	
		areaTop5 = new Rect((int)(getWidth()/1.85f),(int)(getHeight()/14),(int)(getWidth()/1.08f),(int)(getHeight()/2f));
		
		areaMapa = new Rect((int)(getWidth()/4),(int)(getHeight()/1.75f),(int)(getWidth()/1.07f),(int)(getHeight()/1.1f));
		
//		areaTexto = new Rect((int)(getWidth()/1.85f),(int)(getHeight()/6),(int)(getWidth()/1.08f),(int)(getHeight()/2f));
		
//		areaMapa2 = new Rect((int)(getWidth()/14),(int)(getHeight()/1.75),(int)(getWidth()/4f),(int)(getHeight()/1.32f));

//		canvas.drawBitmap(imgBackground, null, areaBackground, paint);
		canvas.drawBitmap(imgLogo, null, areaLogo, paint);
		canvas.drawBitmap(imgCampanhas, null, areaCampanhas, paint);
		canvas.drawBitmap(imgCreditos, null, areaCreditos, paint);
		canvas.drawBitmap(imgTop5, null, areaTop5, paint);
		canvas.drawBitmap(imgmapa, null, areaMapa, paint);
//		canvas.drawBitmap(imgTexto, null, areaTexto, paint);
		

/*		canvas.drawRect(areaLogo, paint);
		canvas.drawRect(areaCampanhas, paint);
		canvas.drawRect(areaCreditos, paint);
		canvas.drawRect(areaTop5, paint);
//		canvas.drawRect(areaMapa2, paint);
		canvas.drawRect(areaMapa, paint);
		canvas.drawRect(areaTexto, paint);
*/
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
				Intent intent = new Intent(activity, CampanhasPorMim.class);
				activity.startActivity(intent);
				activity.finish();
			}
			
			// Mapas
			if(areaMapa.contains(a,b))
			{
				// Carol chamará o mapa geral aqui.
			}
			
			// Top 5
			if(areaTop5.contains(a,b))
			{
				porMimTop5 = new PeloOutro(activity);
				activity.setContentView(porMimTop5);				
			}
			
			// Créditos
			if(areaCreditos.contains(a,b))
			{
				Log.i(TAG, "Escolhi créditos");
				creditosPorMim = new CreditosPeloOutro(activity);
				activity.setContentView(creditosPorMim);
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
