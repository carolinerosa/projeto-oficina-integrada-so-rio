package PeloOutro;

import com.example.projetointegrado.ImageManager;
import com.example.projetointegrado.CampanhasPeloOutro;
import com.example.projetointegrado.PeloOutro;

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

public class AssociacaoBrasileira extends View 
{
	private Bitmap background;
	
	private Rect  areaVoltarPeloOutroMenu;
	private Rect  areaVoltarPeloOutroCampanhas;
	private Rect  areaVerNoMapa;
	private ImageManager picture;
	private Paint paint;
	private Activity activity;
	private View voltarPeloOutro;
	private View voltarPeloOutroCampanhas;
	
	public static final String TAG = "AcaoCrista";
	
	public AssociacaoBrasileira(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		picture = new ImageManager();
		paint = new Paint();

		activity = (Activity) context;

		background = picture.ImageManager("CampanhaPeloOutro_AssociacaoBrasileiraDeReabilitacao.png", context);

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		canvas.drawBitmap(background, 0, -20, paint);	

		areaVoltarPeloOutroMenu = new Rect(15, 15, 55, 55);	
		areaVoltarPeloOutroCampanhas = new Rect(60, 15, 230, 55);
		areaVerNoMapa = new Rect(210, 100,230, 250);
		
/*		canvas.drawRect(areaVoltarPeloOutroMenu, paint);
		canvas.drawRect(areaVoltarPeloOutroCampanhas, paint);
		canvas.drawRect(areaVerNoMapa, paint);*/

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
			
			if (areaVoltarPeloOutroMenu.contains(a,b))
			{
				voltarPeloOutro = new PeloOutro(activity);
				activity.setContentView(voltarPeloOutro);
			}
			
			if (areaVoltarPeloOutroCampanhas.contains(a,b))
			{
				Intent intent = new Intent(activity, CampanhasPeloOutro.class);
				activity.startActivity(intent);
				activity.finish();					
			}
			
			if (areaVerNoMapa.contains(a,b))
			{
				// Por código da Vitória aqui.
				
				
			}
		}
		
		return super.onTouchEvent(event);
	}	
}

