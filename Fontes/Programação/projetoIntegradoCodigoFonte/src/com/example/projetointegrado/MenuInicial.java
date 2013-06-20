package com.example.projetointegrado;

import java.io.InputStream;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class MenuInicial extends View implements Runnable
{
	private Bitmap background;
	private Bitmap backgroundOpcoes;
	private Bitmap picture_PorMim;
	private Bitmap picture_PeloOutro;
	private Bitmap picture_PeloMundo;
	
	private Rect areaPorMim;
	private Rect areaPeloOutro;
	private Rect areaPeloMundo;
	
	ImageManager img;
	Paint paint;
	Activity activity;
	public static final String TAG = "MenuInicial";
	
	View loadPorMim;
	View loadPeloOutro;
	View loadPeloMundo;
	
	
	public MenuInicial(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		img = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;
		
		// Carregando as imagens.
		background = img.ImageManager("backgroundMenu.png", context);
		backgroundOpcoes = img.ImageManager("fundoOpcoes.png", context);
		picture_PorMim = img.ImageManager("barraEscolhaPorMim.png", context);
		picture_PeloOutro = img.ImageManager("barraEscolhaPeloOutro.png", context);
		picture_PeloMundo = img.ImageManager("barraEscolhaPeloMundo.png", context);
				
		// TODO Auto-generated constructor stub
}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);		
		paint.setTextSize(20);
		
		// Desenhando o background
		canvas.drawBitmap(background, 0, 0, paint);
		canvas.drawBitmap(backgroundOpcoes, 20, 80, paint);

		// Desenhando as opcoes.
		canvas.drawBitmap(picture_PorMim, getWidth()/10, getHeight()/3, paint);
		canvas.drawBitmap(picture_PeloOutro, getWidth()/10, getHeight()/2, paint);
		canvas.drawBitmap(picture_PeloMundo, getWidth()/10, getHeight()/1.5f, paint);
		
	//	areaObjectsUp[0]= new Rect(0,0, 0+ (int)geometricFigures[0].getWidth(), (int)geometricFigures[0].getHeight());

		// Desenhando os Rects.
		areaPorMim = new Rect(getWidth()/10,getHeight()/3, getWidth()/10 + (int)picture_PorMim.getWidth(),
				getHeight()/3 + (int)picture_PorMim.getHeight() + 10);
		
		areaPeloOutro = new Rect(getWidth()/10,getHeight()/2, getWidth()/10 + (int)picture_PeloOutro.getWidth(),
				getHeight()/2 + (int)picture_PeloOutro.getHeight() + 10);
		
		areaPeloMundo = new Rect(getWidth()/10,getHeight()/2 + 50, getWidth()/10 + (int)picture_PeloMundo.getWidth(),
				getHeight()/2 + (int)picture_PeloMundo.getHeight() + 60);

/*		canvas.drawRect(areaPorMim, paint);
		canvas.drawRect(areaPeloOutro, paint);
		canvas.drawRect(areaPeloMundo, paint);*/
}	
	public boolean onTouchEvent(MotionEvent event) 
	{	
		if (event.getAction() == MotionEvent.ACTION_DOWN) 
		{
			Log.i(TAG, "Entrou no action down");
			
			int a = (int)event.getRawX();
			int b = (int)event.getRawY();

			// Por Mim
			if(areaPorMim.contains(a,b))
			{
				Log.i(TAG, "Escolhi Por Mim!! ");
				loadPorMim = new PorMim(activity);
				activity.setContentView(loadPorMim);
				
				
				//porMim = new PorMimPadrao(super.getContext());
			}
			
			// Pelo Outro
			if(areaPeloOutro.contains(a,b))
			{
				Log.i(TAG, "Escolhi Pelo Outro!! ");
				loadPeloOutro = new PeloOutro(activity);
				activity.setContentView(loadPeloOutro);	
			}
			
			// Pelo Mundo
			if(areaPeloMundo.contains(a,b))
			{
				Log.i(TAG, "Escolhi Pelo Mundo!! ");
				loadPeloMundo = new PeloMundo(activity);
				activity.setContentView(loadPeloMundo);	
			}
			
			
		}
		
		if (event.getAction() == MotionEvent.ACTION_MOVE) 
		{
//			Log.i(TAG, "Entrou no action move");
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
//			Log.i(TAG, "Entrou no action up");
			int a = (int)event.getRawX();
			int b = (int)event.getRawY();

			// Por Mim
		/*	if(areaPorMim.contains(a,b))
			{
				Log.i(TAG, "Escolhi Por Mim!! ");
				//loadPorMim = new PorMimPadrao(activity);
				//activity.setContentView(loadPorMim);	
				PorMimPadrao c = new PorMimPadrao(super.getContext());
			}
			*/
/*			// Pelo Outro
			if(areaPeloOutro.contains(a,b))
			{
				Log.i(TAG, "Escolhi Pelo Outro!! ");
				loadPorMim = new PorMimPadrao(activity);
				activity.setContentView(loadPorMim);	
			}
	*/		
			// Pelo Mundo
/*			if(areaPeloMundo.contains(a,b))
			{
				Log.i(TAG, "Escolhi Pelo Mundo!! ");
				loadPorMim = new PorMimPadrao(activity);
				activity.setContentView(loadPorMim);	
			}
			*/
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