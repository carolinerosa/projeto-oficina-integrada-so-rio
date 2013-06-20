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

public class JovensEmbaixadores extends View implements Runnable
{
	private Bitmap icone;
	private Bitmap nomeCampanha;
	private Bitmap mapa;
	private Bitmap barra;
	private Bitmap informacaoCampanha;
	
	private Rect  areaCampanhas;
	private Rect  areaTop5;
	private Rect  areaCreditos;
	private Rect  areacampanhas;
	
	private ImageManager picture;
	Paint paint;
	Activity activity;
	public static final String TAG = "JovensEmbaixadores";
	
	public JovensEmbaixadores(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;

		icone = picture.ImageManager("IconeHome_PorMim.png", context);
		nomeCampanha = picture.ImageManager("NomeCampanha_Titulo.png", context);
		informacaoCampanha = picture.ImageManager("BordaImagem_1.png", context);
		//mapa = picture.ImageManager("TelaPrincipal_Cor1_Top5_Fechado.png", context);
		//barra = picture.ImageManager("TelaPrincipal_Cor1_Creditos.png", context);

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(icone, getWidth()/10, 10, paint);
//		canvas.drawBitmap(nomeCampanha, getWidth()/24, getHeight()/2.4f, paint);
//		canvas.drawBitmap(informacaoCampanha, getWidth()/24,getHeight()/1.8f, paint);
//		canvas.drawBitmap(mapa, getWidth()/2, getHeight()/20, paint);
//		canvas.drawBitmap(barra, getWidth()/24, getHeight()/1.3f, paint);
		

/*		areaCampanhas = new Rect(getWidth()/24,getHeight()/2 - 26, getWidth()/24 + (int)nomeCampanha.getWidth(),
				getHeight()/2 + (int)nomeCampanha.getHeight() - 26);*/
		
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

			// Play
			if(areaCampanhas.contains(a,b))
			{
//				Log.i(MainActivity.TAG, "Entrou no Play !! ");
//				fase01 = new Fase01(activity);
//				activity.setContentView(fase01);			
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

