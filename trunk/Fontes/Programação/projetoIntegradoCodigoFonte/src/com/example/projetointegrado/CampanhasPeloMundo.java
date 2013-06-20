package com.example.projetointegrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import PeloMundo.GreenPeace;
import PeloMundo.HoraDoPlaneta;
import PeloMundo.LigaDasFlorestas;
import PeloMundo.PegadaEcologica;
import PeloMundo.Recicloteca;
import PeloMundo.ValeVerde;
import PeloMundo.WWF;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class CampanhasPeloMundo extends Activity {

	private ListView lstLinguagens;
	private List<JSONObject> linguagens;
	private LinguagemArrayAdapter adapter;
	private int currentCampanha1;
	private int currentCampanha2;	
	private String nome;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Criação de uma lista quer será utilizada em nosso adapter
		linguagens = new ArrayList<JSONObject>();
		// Informações que serão utilizados no exemplo
		try {
			currentCampanha1 = 0;
			
			JSONObject greenpace = new JSONObject();
			greenpace.put("nome", "Greenpeace");
			linguagens.add(greenpace);
			
			JSONObject horadoPlaneta = new JSONObject();
			horadoPlaneta.put("nome", "Hora do Planeta");
			linguagens.add(horadoPlaneta);
			// currentCampanha =4;
			
			JSONObject ligadasFlorestas = new JSONObject();
			ligadasFlorestas.put("nome", "Liga das Florestas");
			linguagens.add(ligadasFlorestas);
			
			JSONObject pegadaEcologica = new JSONObject();
			pegadaEcologica.put("nome", "Pegada Ecológica");
			linguagens.add(pegadaEcologica);
			
			JSONObject recicloteca = new JSONObject();
			recicloteca.put("nome", "Recicloteca");
			linguagens.add(recicloteca);
			
			JSONObject valeVerde = new JSONObject();
			valeVerde.put("nome", "Vale Verde");
			linguagens.add(valeVerde);

			JSONObject wWF = new JSONObject();
			wWF.put("nome", "WWF");
			linguagens.add(wWF);


		} catch (JSONException e) {
			// Tratando possivel exception ao adicionar informacoes no json
		}

		// Passamos a lista de exemplo para gerar nosso adpater
		adapter = new LinguagemArrayAdapter(getApplicationContext(),
				R.layout.linguagem, linguagens);

		// Buscando o elemento Listview da nossa interface principal interface
		lstLinguagens = (ListView) findViewById(R.id.lstLinguagens);
		// Setando o adapter em nossa ListView
		lstLinguagens.setAdapter(adapter);

		// Setando callback ao selecionar um item da lista
		lstLinguagens.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				try {

					JSONObject linguagem = linguagens.get(position);
					nome = linguagem.getString("nome");

					// TRATA O CLICK NO ITEM DA LISTA
					
					if(nome == "Greenpeace")
					{
						currentCampanha1 +=1;
					}
						
					if(nome == "Hora do Planeta")
					{
						currentCampanha1 +=2;
					}
					
					if(nome == "Liga das Florestas")
					{
						currentCampanha1 +=3;
					}
					
					if(nome == "Pegada Ecológica")
					{
						currentCampanha1 +=4;
					}
										
					if(nome == "Recicloteca")
					{
						currentCampanha1 +=5;
					}
					
					if(nome == "Vale Verde")
					{
						currentCampanha1 +=6;
					}
					
					if(nome == "WWF")
					{
						currentCampanha1 +=7;
					}
					
					changeCampanha(nome);
				}

				catch (JSONException e) {
				}
			}

		});

	}
	
    
    public void pormim(View sender)
	{
		
		PorMim pm = new PorMim(this);
		setContentView(pm);
	}
    
    public void pelooutro(View sender)
	{
    	PeloOutro po = new PeloOutro(this);
		setContentView(po);		
	}
    
    public void pelomundo(View sender)
	{
    	PeloMundo pm = new PeloMundo(this);
		setContentView(pm);		
	}

	public void changeCampanha(String nomee){
    	
    	Log.i("campanhasPorOutro", "entrou no chaange campanha pelo Outro");
  
    	
    	switch(currentCampanha1){
        
        case 1:
        	// GreenPeace
        	Log.i("campanhasPorOutro", "Entrou no case1");
        	GreenPeace greenPeace = new GreenPeace(this);
            setContentView(greenPeace);
            currentCampanha1 = 0;
        	break;
        	       	
        case 2:
           	HoraDoPlaneta hPlaneta = new HoraDoPlaneta(this);
            setContentView(hPlaneta);
            currentCampanha1 = 0;
        	break;
        	
        case 3:
        	LigaDasFlorestas lFlorestas = new LigaDasFlorestas(this);
            setContentView(lFlorestas);
            currentCampanha1 = 0;
        	break;
        	
        case 4:
        	PegadaEcologica pEcologica = new PegadaEcologica(this);
            setContentView(pEcologica);
            currentCampanha1 = 0;
            break;
 
        case 5:	
        	Recicloteca recicloteca = new Recicloteca(this);
            setContentView(recicloteca);
        	break;
        	
        
        case 6:
          	ValeVerde vVerde = new ValeVerde(this);
            setContentView(vVerde);
            currentCampanha1 = 0;
        	break;
        	
        case 7:

        	WWF wwf = new WWF(this);
            setContentView(wwf);
            currentCampanha1 = 0;
        	break;
        }
    	
    }
	
}