package com.example.projetointegrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import PorMim.AceleracaoAgentes;
import PorMim.AceleracaoEscolar;
import PorMim.BolsaFormacao;
import PorMim.CienciaSemFronteira;
import PorMim.JovemAprendiz;
import PorMim.JovensEmbaixadores;
import PorMim.ParqueDasVizinhancas;
import PorMim.SaudeVesteKimono;
import PorMim.VilaOlimpicaCarlosCastilho;
import PorMim.VilaOlimpicaClaraNunes;
import PorMim.VilaOlimpicaDaGamboa;
import PorMim.VilaOlimpicaDaMare;
import PorMim.VilaOlimpicaJornAryDeCarvalho;
import PorMim.VilaOlimpicaMestreAndre;
import PorMim.VilaOlimpicaOscarShidmit;
import PorMim.VilaOlimpicaProfMan;
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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class CampanhasPorMim extends Activity {
  
    private ListView lstLinguagens;
    private List<JSONObject> linguagens;
    private LinguagemArrayAdapter adapter;
    //public static CAMPANHASPM currentCampanha;
    public int currentCampanha;
    String nome;
  
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Cria��o de uma lista quer ser� utilizada em nosso adapter
        linguagens = new ArrayList<JSONObject>();
        // Informa��es que ser�o utilizados no exemplo
        try 
        {        
          currentCampanha = 0;

          JSONObject acelera��oEscolar = new JSONObject();
          acelera��oEscolar.put("nome", "Acelera��o Escolar");          
          linguagens.add(acelera��oEscolar);
          
          JSONObject aceleracaoEscolarparaAgentesComunitariosDaSaude = new JSONObject();
          aceleracaoEscolarparaAgentesComunitariosDaSaude.put("nome", "Acelera��o Escolar para Agentes Comunitarios da Saude");          
          linguagens.add(aceleracaoEscolarparaAgentesComunitariosDaSaude);

          JSONObject bolsaformacao = new JSONObject();
          bolsaformacao.put("nome", "Bolsa Forma��o");          
          linguagens.add(bolsaformacao);
          
          JSONObject cienciaSemFronteira = new JSONObject();
          cienciaSemFronteira.put("nome", "Ci�ncia Sem Fronteiras");         
          linguagens.add(cienciaSemFronteira);
          
          JSONObject jovemAprendiz = new JSONObject();
          jovemAprendiz.put("nome", "jovemAprendiz");          
          linguagens.add(jovemAprendiz);
          
          JSONObject jovensEmb = new JSONObject();
          jovensEmb.put("nome", "Jovens Embaixadores"); 
          linguagens.add(jovensEmb);          

          JSONObject parquedasVizinhacasDiasGomes = new JSONObject();
          parquedasVizinhacasDiasGomes.put("nome", "Parque das Vizinha�as Dias Gomes");          
          linguagens.add(parquedasVizinhacasDiasGomes);
         
          JSONObject saudeVesteKimono = new JSONObject();
          saudeVesteKimono.put("nome", "Sa�de Veste Kimono");          
          linguagens.add(saudeVesteKimono);

          JSONObject vilaOlimpicaClaraNunes = new JSONObject();
          vilaOlimpicaClaraNunes.put("nome", "Vila Ol�mpica Clara Nunes");          
          linguagens.add(vilaOlimpicaClaraNunes);
          
          JSONObject vilaOlimpicaCarlosCastilho = new JSONObject();
          vilaOlimpicaCarlosCastilho.put("nome", "Vila Ol�mpica Carlos Castilho");          
          linguagens.add(vilaOlimpicaCarlosCastilho);
          
          JSONObject vilaOlimpicadaGamboa = new JSONObject();
          vilaOlimpicadaGamboa.put("nome", "Vila Ol�mpica da Gamboa");          
          linguagens.add(vilaOlimpicadaGamboa);
                    
          JSONObject vilaOlimpicadaMare = new JSONObject();
          vilaOlimpicadaMare.put("nome", "Vila Ol�mpica da Mar�");          
          linguagens.add(vilaOlimpicadaMare);
          
          JSONObject vilaOlimpicaJornalistaArydeCarvalho = new JSONObject();
          vilaOlimpicaJornalistaArydeCarvalho.put("nome", "Vila Ol�mpica Jornalista Ary de Carvalho");          
          linguagens.add(vilaOlimpicaJornalistaArydeCarvalho);
                   
          JSONObject vilaOlimpicaMestreAndre = new JSONObject();
          vilaOlimpicaMestreAndre.put("nome", "Vila Ol�mpica Mestre Andre");          
          linguagens.add(vilaOlimpicaMestreAndre);
         
          JSONObject vilaOlimpicaOscarSchimdt = new JSONObject();
          vilaOlimpicaOscarSchimdt.put("nome", "Vila Ol�mpica Oscar Schimdt");          
          linguagens.add(vilaOlimpicaOscarSchimdt);
                    
          JSONObject vilaOlimpicaProfessorManoelJoseGomesTubino = new JSONObject();
          vilaOlimpicaProfessorManoelJoseGomesTubino.put("nome", "Vila Ol�mpica Professor Manoel Jos� Gomes Tubino- Mato Alto (Jacarepagu�)");          
          linguagens.add(vilaOlimpicaProfessorManoelJoseGomesTubino);

          
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
			
			try {
				
				JSONObject linguagem = linguagens.get(position);
				nome = linguagem.getString("nome");

				if (nome == "Acelera��o Escolar")
				{
					currentCampanha +=1;
				}
				
				if (nome == "Acelera��o Escolar para Agentes Comunitarios da Saude")
				{
					currentCampanha +=2;
				}
				
				if (nome == "Bolsa Forma��o")
				{
					currentCampanha +=3;
				}
				
				if (nome == "Ci�ncia Sem Fronteiras")
				{
					currentCampanha +=4;
				}
				
				if (nome == "jovemAprendiz")
				{
					currentCampanha +=5;
				}
				
				if (nome == "Jovens Embaixadores")
				{
					currentCampanha +=6;
				}
				
				if (nome == "Parque das Vizinha�as Dias Gomes")
				{
					currentCampanha +=7;
				}
				
				if (nome == "Sa�de Veste Kimono")
				{
					currentCampanha +=8;
				}
				
				if (nome == "Vila Ol�mpica Clara Nunes")
				{
					currentCampanha +=9;
				}
				
				if (nome == "Vila Ol�mpica Carlos Castilho")
				{
					currentCampanha +=10;
				}
				
				if (nome == "Vila Ol�mpica da Gamboa")
				{
					currentCampanha +=11;
				}
				
				if (nome == "Vila Ol�mpica da Mar�")
				{
					currentCampanha +=12;
				}
				
				if (nome == "Vila Ol�mpica Jornalista Ary de Carvalho")
				{
					currentCampanha +=13;
				}
				
				if (nome == "Vila Ol�mpica Mestre Andre")
				{
					currentCampanha +=14;
				}
				
				if (nome == "Vila Ol�mpica Oscar Schimdt")
				{
					currentCampanha +=15;
				}
				
				if (nome == "Vila Ol�mpica Professor Manoel Jos� Gomes Tubino- Mato Alto (Jacarepagu�)")
				{
					currentCampanha +=16;
				}
				
				changeCampanha(nome);
				
				
			} catch (JSONException e) {
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
    	
    	Log.i("campanhasPorMim", "entrou no chaange campanha");
    	
    	switch(currentCampanha){
        
        case 1:
        	AceleracaoEscolar aEscolar = new AceleracaoEscolar(this);
        	setContentView(aEscolar);
        	break;
        	
        case 2:
        	AceleracaoAgentes aceleracaoAgentes = new AceleracaoAgentes(this);
        	setContentView(aceleracaoAgentes);
        	break; 
        	
        case 3:
        	BolsaFormacao bFormacao = new BolsaFormacao(this);
        	setContentView(bFormacao);
        	break; 
        	
        case 4:
        	CienciaSemFronteira cFronteira = new CienciaSemFronteira(this);
        	setContentView(cFronteira);
        	break; 
	
        case 5:
        	JovemAprendiz jovemAprendiz = new JovemAprendiz(this);
        	setContentView(jovemAprendiz);
        	break; 
        	
        case 6:
        	JovensEmbaixadores jEmbaixadores = new JovensEmbaixadores(this);
        	setContentView(jEmbaixadores);
        	break; 
        	
        case 7:
        	ParqueDasVizinhancas parqueVizinhancas = new ParqueDasVizinhancas(this);
        	setContentView(parqueVizinhancas);
        	break; 
        	
        case 8:
        	SaudeVesteKimono sVesteKimono = new SaudeVesteKimono(this);
        	setContentView(sVesteKimono);
        	break; 
        	
        case 9:
        	VilaOlimpicaCarlosCastilho vCarlos = new VilaOlimpicaCarlosCastilho(this);
        	setContentView(vCarlos);
        	break; 
        	
        case 10:
        	VilaOlimpicaClaraNunes vClaraNunes = new VilaOlimpicaClaraNunes(this);
        	setContentView(vClaraNunes);
        	break; 
        	
        case 11:
        	VilaOlimpicaDaGamboa vGamboa = new VilaOlimpicaDaGamboa(this);
        	setContentView(vGamboa);
        	break; 
        	
        case 12:
        	VilaOlimpicaDaMare vMare = new VilaOlimpicaDaMare(this);
        	setContentView(vMare);
        	break; 
        	
        case 13:
        	VilaOlimpicaJornAryDeCarvalho vCarvalho = new VilaOlimpicaJornAryDeCarvalho(this);
        	setContentView(vCarvalho);        	
        	break; 
        	
        case 14:
        	VilaOlimpicaMestreAndre vAndre = new VilaOlimpicaMestreAndre(this);
        	setContentView(vAndre); 
        	break; 
        	
        case 15:
        	VilaOlimpicaOscarShidmit vOscar = new VilaOlimpicaOscarShidmit(this);
        	setContentView(vOscar);
        	break; 
        	
        case 16:
        	VilaOlimpicaProfMan vilaOlimpicaProfMan = new VilaOlimpicaProfMan(this);
        	setContentView(vilaOlimpicaProfMan);
        	break; 
        }
    	
    }
}