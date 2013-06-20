package Creditos;

import com.example.projetointegrado.ImageManager;
import com.example.projetointegrado.PorMim;

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

public class CreditosPorMim extends View 
{
	private Bitmap background;	
	
	private Rect areaVoltar;
	
	private ImageManager picture;
	Paint paint;
	Activity activity;
	public static final String TAG = "PorMim";
	View voltar;
	
	public CreditosPorMim(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;

		background = picture.ImageManager("CreditosPorMim.png", context);

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(background, 0, -20, paint);
		
		// Desenhando os Rects.
		areaVoltar = new Rect(15, 20, 45, 50);	
				
		//canvas.drawRect(areaVoltar, paint);
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
			
			// Voltar
			if(areaVoltar.contains(a,b))
			{
				voltar = new PorMim(activity);
				activity.setContentView(voltar);		
			}
		}
		return super.onTouchEvent(event);
	}
	// TODO Auto-generated method stub
	
}
	
