package com.example.projetointegrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import PeloOutro.AcaoCrista;
import PeloOutro.ActionLaser;
import PeloOutro.AsiloLegiaoBem;
import PeloOutro.AsiloTherezaChristina;
import PeloOutro.AssociacaoBrasileira;
import PeloOutro.CasaDaCrianca;
import PeloOutro.CentroCriar;
import PeloOutro.EducandarioNossaSenhora;
import PeloOutro.Habilitarem;
import PeloOutro.InstitutoAnaFreud;
import PeloOutro.LarPedro;
import PeloOutro.ResidenciaSaoTiago;

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

public class CampanhasPeloOutro extends Activity 
{
  
    private ListView lstLinguagens;
    private List<JSONObject> linguagens;
    private LinguagemArrayAdapter adapter;
	private int currentCampanha;
	String nome;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Criação de uma lista quer será utilizada em nosso adapter
        linguagens = new ArrayList<JSONObject>();
        // Informações que serão utilizados no exemplo
        try {
  
            JSONObject AcaoCristaVicenteMoretti  = new JSONObject();
            AcaoCristaVicenteMoretti.put("nome", "Acao Crista Vicente Moretti");          
            linguagens.add(AcaoCristaVicenteMoretti);

            JSONObject ActionLaser = new JSONObject();
            ActionLaser.put("nome", "Action Laser");          
            linguagens.add(ActionLaser);

            JSONObject asilodaLegiaodoBem = new JSONObject();
            asilodaLegiaodoBem.put("nome", "Asilo da Legião do Bem");          
            linguagens.add(asilodaLegiaodoBem);

            JSONObject asiloTherezaChristina = new JSONObject();
            asiloTherezaChristina.put("nome", "Asilo Thereza Christina");          
            linguagens.add(asiloTherezaChristina);

            JSONObject AssociacaoBrasileiraDeReabilitacao = new JSONObject();
            AssociacaoBrasileiraDeReabilitacao.put("nome", "Associacao Brasileira de Reabilitacao");  
            linguagens.add(AssociacaoBrasileiraDeReabilitacao);

            JSONObject CasaDaCriancaDrBezerraMenezes = new JSONObject();
            CasaDaCriancaDrBezerraMenezes.put("nome", "CasaDaCriancaDrBezerraMenezes");  
            linguagens.add(CasaDaCriancaDrBezerraMenezes);

            JSONObject CentroDeReabilitacaoCriar = new JSONObject();
            CentroDeReabilitacaoCriar.put("nome", "Centro de Reabilitacao Criar");          
            linguagens.add(CentroDeReabilitacaoCriar);

            JSONObject educandarioNossaSenhoraDores = new JSONObject();
            educandarioNossaSenhoraDores.put("nome", "Educandario Nossa Senhora Dores");          
            linguagens.add(educandarioNossaSenhoraDores);

            JSONObject habilitarem = new JSONObject();
            habilitarem.put("nome", "Habilitarem");          
            linguagens.add(habilitarem);
          
            JSONObject institutoAnaFreud = new JSONObject();
            institutoAnaFreud.put("nome", "Instituto Ana Freud");          
            linguagens.add(institutoAnaFreud);

            JSONObject larPedroRichard = new JSONObject();
            larPedroRichard.put("nome", "Lar Pedro Richard");          
            linguagens.add(larPedroRichard);

            JSONObject ResidenciaSaoTiagoApostolo = new JSONObject();
            ResidenciaSaoTiagoApostolo.put("nome", "Residencia Sao Tiago Apostolo");          
            linguagens.add(ResidenciaSaoTiagoApostolo);
          
        } catch (JSONException e) {
          // Tratando possivel exception ao adicionar informacoes no json
        }
        
        // Passamos a lista de exemplo para gerar nosso adpater
        adapter = new LinguagemArrayAdapter(getApplicationContext(), R.layout.linguagem, linguagens);
        
        // Buscando o elemento Listview da nossa interface principal interface 
        lstLinguagens = (ListView) findViewById(R.id.lstLinguagens);
        // Setando o adapter em nossa ListView
        lstLinguagens.setAdapter(adapter);
        
        // Setando callback ao selecionar um item da lista
        lstLinguagens.setOnItemClickListener(new OnItemClickListener() {          

		public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {
			
            try{           	

            	JSONObject linguagem = linguagens.get(position);
				nome = linguagem.getString("nome");
				
                    // TRATA O CLICK NO ITEM DA LISTA
   //             changeCampanha(nome);
                
                if (nome == "Acao Crista Vicente Moretti")
                {
                	currentCampanha +=1;
                }
                
                if (nome == "Action Laser")
                {
                	currentCampanha +=2;
                }
                if (nome == "Asilo da Legião do Bem")
                {
                	currentCampanha +=3;
                }
                if (nome == "Asilo Thereza Christina")
                {
                	currentCampanha +=4;
                }
                if (nome == "Associacao Brasileira de Reabilitacao")
                {
                	currentCampanha +=5;
                }
                if (nome == "CasaDaCriancaDrBezerraMenezes")
                {
                	currentCampanha +=6;
                }
                if (nome == "Centro de Reabilitacao Criar")
                {
                	currentCampanha +=7;
                }
                if (nome == "Educandario Nossa Senhora Dores")
                {
                	currentCampanha +=8;
                }
                if (nome == "Habilitarem")
                {
                	currentCampanha +=9;
                }
                if (nome == "Instituto Ana Freud")
                {
                	currentCampanha +=10;
                }
                if (nome == "Lar Pedro Richard")
                {
                	currentCampanha +=11;
                }              
                if (nome == "Residencia Sao Tiago Apostolo")
                {
                	currentCampanha +=12;
                }
                
				changeCampanha(nome);
                
            }catch (JSONException e) {
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
    	
    	switch(currentCampanha){
        
        case 1:
        	AcaoCrista aCrista = new AcaoCrista(this);
    		setContentView(aCrista);	        	
        	break;
        	
        case 2:
        	ActionLaser aLaser = new ActionLaser(this);
    		setContentView(aLaser);	        	        	
        	break;
        	
        case 3:
        	AsiloLegiaoBem asiloLegiao = new AsiloLegiaoBem(this);
    		setContentView(asiloLegiao);	   
        	break;
        	
        case 4:
        	AsiloTherezaChristina asiloThereza = new AsiloTherezaChristina(this);
    		setContentView(asiloThereza);	   
        	break;
        	
        case 5:
        	AssociacaoBrasileira assBrasileira = new AssociacaoBrasileira(this);
    		setContentView(assBrasileira);	   
        	break;
        	
        case 6:	
        	CasaDaCrianca casaCrianca = new CasaDaCrianca(this);
    		setContentView(casaCrianca);	   
        	break;
        	
        case 7:	
        	CentroCriar centroCriar = new CentroCriar(this);
    		setContentView(centroCriar);	   
        	break;
        	
        case 8:	
        	EducandarioNossaSenhora educandarNossaSenhora = new EducandarioNossaSenhora(this);
    		setContentView(educandarNossaSenhora);	   
        	break;
        	
        case 9:	
        	Habilitarem habilitarem = new Habilitarem(this);
    		setContentView(habilitarem);	   
        	break;
        	
        case 10:	
        	InstitutoAnaFreud institutoAna = new InstitutoAnaFreud(this);
    		setContentView(institutoAna);	   
        	break;
        	
        case 11:	
        	LarPedro larPedro = new LarPedro(this);
    		setContentView(larPedro);	   
        	break;
        	
        case 12:	
        	ResidenciaSaoTiago residenciaSaoTiago = new ResidenciaSaoTiago(this);
    		setContentView(residenciaSaoTiago);	   
        	break;
        }
    	
    }
           

}