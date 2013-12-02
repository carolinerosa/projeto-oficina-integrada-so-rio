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
	private Rect areabackground;
	private Rect areabackgroundOpcoes;
		
	
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
		background = img.ImageManager("TelaOpacidade-01.png", context);
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
		
		areabackground = new Rect(0,0, getWidth(), getHeight());
		areabackgroundOpcoes = new Rect(getWidth()/12, (int)(getHeight()/4f), (int)(getWidth()/1.05f), (int)(getHeight()/1.2f));
		
		areaPorMim = new Rect(getWidth()/8,(int)(getHeight()/3f), (int)(getWidth()/1.13f), (int)(getHeight()/2.3));
		areaPeloOutro = new Rect(getWidth()/8,(int)(getHeight()/2f), (int)(getWidth()/1.13f), (int)(getHeight()/1.7));
		areaPeloMundo = new Rect(getWidth()/8,(int)(getHeight()/1.5f), (int)(getWidth()/1.13f), (int)(getHeight()/1.3f));
		
		// Desenhando o background
		canvas.drawBitmap(background, null, areabackground, paint);
		canvas.drawBitmap(backgroundOpcoes, null, areabackgroundOpcoes, paint);

		// Desenhando as opcoes.
		canvas.drawBitmap(picture_PorMim, null, areaPorMim, paint);
		canvas.drawBitmap(picture_PeloOutro, null, areaPeloOutro, paint);
		canvas.drawBitmap(picture_PeloMundo, null, areaPeloMundo, paint);
		
		// Desenhando os Rects.
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
		}
		
		if (event.getAction() == MotionEvent.ACTION_MOVE) 
		{
//			Log.i(TAG, "Entrou no action move");
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			Log.i(TAG, "Entrou no action up");
			
			int a = (int)event.getX();
			int b = (int)event.getY();

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