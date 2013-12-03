package com.example.projetointegrado;

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

public class PorMimTop5 extends View implements Runnable
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
	
	public PorMimTop5(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;
		
		imgBackground = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		imgLogo = picture.ImageManager("Logo_Pormim.png", context);
		imgmapa = picture.ImageManager("Mapa_PorMim.png", context);
		imgTop5 = picture.ImageManager("Top5AbertoPorMim.png", context);
		imgCampanhas = picture.ImageManager("TelaPrincipal_Cor1_CampanhasListView.png", context);
		imgCreditos = picture.ImageManager("Credito_Pormim.png", context);
		//imgTexto = picture.ImageManager("texto.png", context);
		
//		imgTexto = picture.ImageManager("TelaPrincipal_Pormim.png", context);
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		areaBackground = new Rect(0,0,getWidth(),getHeight());

		areaLogo = new Rect((int)(getWidth()/20),(int)(5*getHeight()/40),(int)(9.5f*getWidth()/20),(int)(5*getHeight()/40+(imgLogo.getHeight() * 8.5f*getWidth()/20)/imgLogo.getWidth()));

		areaCampanhas = new Rect((int)(getWidth()/20),areaLogo.bottom + 2*getHeight()/40,(int)(9.5f*getWidth()/20),(int)((areaLogo.bottom + 2*getHeight()/40)+ (imgCampanhas.getHeight() * 8.5f*getWidth()/20)/imgCampanhas.getWidth()));


	
		areaTop5 = new Rect((int)(10.5f*getWidth()/20),(int)(5*getHeight()/40),(int)(18.5f*getWidth()/20),(int)(5*getHeight()/40+(imgTop5.getHeight() * 8*getWidth()/20)/imgTop5.getWidth()));
		
		areaMapa = new Rect((int)(getWidth()/20),(int)areaCampanhas.bottom + (2*getHeight()/40),(int)(18.5f*getWidth()/20),(int)((areaCampanhas.bottom + 2*getHeight()/40)+(imgmapa.getHeight() * 17.5f*getWidth()/20)/imgmapa.getWidth()));
		
		//areaTexto = new Rect((int)(10.5f*getWidth()/20),areaTop5.bottom + 2*getHeight()/40,(int)(18.5f*getWidth()/20),(int)((areaTop5.bottom + 2*getHeight()/40)+ (imgTexto.getHeight() * 8*getWidth()/20)/imgTexto.getWidth()));
		areaCreditos = new Rect((int)(getWidth()/20),(int)(areaMapa.bottom-(imgCreditos.getHeight() * 3*getWidth()/20)/imgCreditos.getWidth()),(int)(4*getWidth()/20),areaMapa.bottom);
//		areaMapa2 = new Rect((int)(getWidth()/14),(int)(getHeight()/1.75),(int)(getWidth()/4f),(int)(getHeight()/1.32f));

//		canvas.drawBitmap(imgBackground, null, areaBackground, paint);
		canvas.drawBitmap(imgLogo, null, areaLogo, paint);
		canvas.drawBitmap(imgCampanhas, null, areaCampanhas, paint);

		canvas.drawBitmap(imgmapa, null, areaMapa, paint);
		canvas.drawBitmap(imgCreditos, null, areaCreditos, paint);
		canvas.drawBitmap(imgTop5, null, areaTop5, paint);
		//canvas.drawBitmap(imgTexto, null, areaTexto, paint);
		
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
				porMimTop5 = new PorMim(activity);
				activity.setContentView(porMimTop5);				
			}
			
			// Créditos
			if(areaCreditos.contains(a,b))
			{
				Log.i(TAG, "Escolhi créditos");
				creditosPorMim = new CreditosPorMim(activity);
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
