package com.example.projetointegrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Campanhas extends Activity {
  
    private ListView lstLinguagens;
    private List<JSONObject> linguagens;
    private LinguagemArrayAdapter adapter;
    private HashMap<String, Activity> viewsCampanhas;
	//private Activity o = new JovensEmbaixadores();
    
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Criação de uma lista quer será utilizada em nosso adapter
        linguagens = new ArrayList<JSONObject>();
        viewsCampanhas = new HashMap<String, Activity>();
        //viewsCampanhas.put("nome", o);
        // Informações que serão utilizados no exemplo
        try {
          JSONObject bolsaformacao = new JSONObject();
          bolsaformacao.put("nome", "Bolsa Formação");          
          linguagens.add(bolsaformacao);
          
//          JSONObject jovensEmb = new JSONObject();
//          jovensEmb.put(adapter.savedName, "Jovens Embaixadores");         
//          linguagens.add(jovensEmb);
          
          JSONObject perl = new JSONObject();
          perl.put("nome", "Ciência Sem Fronteiras");         
          linguagens.add(perl);
          
          JSONObject saudeVesteKimono = new JSONObject();
          saudeVesteKimono.put("nome", "Saúde Veste Kimono");          
          linguagens.add(saudeVesteKimono);
          
          JSONObject jovensEmb = new JSONObject();
          jovensEmb.put("nome", "Jovens Embaixadores"); 
         // viewsCampanhas.put("nome", o);
          linguagens.add(jovensEmb);
          
          JSONObject aceleraçãoEscolar = new JSONObject();
          aceleraçãoEscolar.put("nome", "Aceleração Escolar");          
          linguagens.add(aceleraçãoEscolar);
          
          JSONObject jovemAprendiz = new JSONObject();
          jovemAprendiz.put("nome", "jovemAprendiz");          
          linguagens.add(jovemAprendiz);
          
          JSONObject aceleracaoEscolarparaAgentesComunitariosDaSaude = new JSONObject();
          aceleracaoEscolarparaAgentesComunitariosDaSaude.put("nome", "Aceleração Escolar para Agentes Comunitários da Saúde");          
          linguagens.add(aceleracaoEscolarparaAgentesComunitariosDaSaude);
          
          JSONObject vilaOlimpicaProfessorManoelJoseGomesTubino = new JSONObject();
          vilaOlimpicaProfessorManoelJoseGomesTubino.put("nome", "Vila Olímpica Professor Manoel José Gomes Tubino- Mato Alto (Jacarepaguá)");          
          linguagens.add(vilaOlimpicaProfessorManoelJoseGomesTubino);
          
          JSONObject vilaOlimpicaCarlosCastilho = new JSONObject();
          vilaOlimpicaCarlosCastilho.put("nome", "Vila Olímpica Carlos Castilho");          
          linguagens.add(vilaOlimpicaCarlosCastilho);
          
          JSONObject vilaOlimpicadaMare = new JSONObject();
          vilaOlimpicadaMare.put("nome", "Vila Olímpica da Maré");          
          linguagens.add(vilaOlimpicadaMare);
          
          JSONObject vilaOlimpicaJornalistaArydeCarvalho = new JSONObject();
          vilaOlimpicaJornalistaArydeCarvalho.put("nome", "Vila Olímpica Jornalista Ary de Carvalho");          
          linguagens.add(vilaOlimpicaJornalistaArydeCarvalho);
          
          JSONObject parquedasVizinhacasDiasGomes = new JSONObject();
          parquedasVizinhacasDiasGomes.put("nome", "Parque das Vizinhaças Dias Gomes");          
          linguagens.add(parquedasVizinhacasDiasGomes);
          
          JSONObject vilaOlimpicaClaraNunes = new JSONObject();
          vilaOlimpicaClaraNunes.put("nome", "Vila Olímpica Clara Nunes");          
          linguagens.add(vilaOlimpicaClaraNunes);
          
          JSONObject vilaOlimpicaMestreAndre = new JSONObject();
          vilaOlimpicaMestreAndre.put("nome", "Vila Olímpica Mestre Andre");          
          linguagens.add(vilaOlimpicaMestreAndre);
          
          JSONObject vilaOlimpicaOscarSchimdt = new JSONObject();
          vilaOlimpicaOscarSchimdt.put("nome", "Vila Olímpica Oscar Schimdt");          
          linguagens.add(vilaOlimpicaOscarSchimdt);
          
          JSONObject vilaOlimpicadaGamboa = new JSONObject();
          vilaOlimpicadaGamboa.put("nome", "Vila Olímpica da Gamboa");          
          linguagens.add(vilaOlimpicadaGamboa);
          
          JSONObject aceleracaoEscolarparaAgentesComunitariosdaSaude = new JSONObject();
          aceleracaoEscolarparaAgentesComunitariosdaSaude.put("nome", "Aceleração Escolar para Agentes Comunitários da Saúde");          
          linguagens.add(aceleracaoEscolarparaAgentesComunitariosdaSaude);
          
         /* A terminar
          * 
          * JSONObject perl = new JSONObject();
          perl.put("nome", "Ciência Sem Fronteiras");
          perl.put("descricao", "Sobre a campanha Ciência Sem Fronteiras");
          linguagens.add(perl);
          
          JSONObject saudeVesteKimono = new JSONObject();
          saudeVesteKimono.put("nome", "Saúde Veste Kimono");
          saudeVesteKimono.put("descricao", "Sobre a campanha saudeVesteKimono");
          linguagens.add(saudeVesteKimono);
          
          JSONObject python = new JSONObject();
          python.put("nome", "Jovens Embaixadores");
          python.put("descricao", "Sobre a campanha Jovens Embaixadores");
          linguagens.add(python);
          
          JSONObject perl = new JSONObject();
          perl.put("nome", "Ciência Sem Fronteiras");
          perl.put("descricao", "Sobre a campanha Ciência Sem Fronteiras");
          linguagens.add(perl);
          
          JSONObject saudeVesteKimono = new JSONObject();
          saudeVesteKimono.put("nome", "Saúde Veste Kimono");
          saudeVesteKimono.put("descricao", "Sobre a campanha saudeVesteKimono");
          linguagens.add(saudeVesteKimono);*/
          
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
          
          private Context context;

		public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {
			
            try{           	

                JSONObject linguagem = linguagens.get(position);
                String nome = linguagem.getString("nome");
                    // TRATA O CLICK NO ITEM DA LISTA
                    
            	
            	
            	
            	
            
            	/*
              
              //Toast.makeText(getApplicationContext(), nome, 10000).show();
              	Intent i = new Intent();
      			i.setClass(context, viewsCampanhas.get("nome").getClass());
      			startActivity(i);
             // viewsCampanhas.get("nome");
              */
            }catch (JSONException e) {
            }
		}
          
        });
        
    }
           

}
/*package com.example.projetointegrado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Campanhas extends Activity
{
  
	private ListView lstLinguagens;
    private List<JSONObject> linguagens;
    private LinguagemArrayAdapter adapter;
    private HashMap<String, View> viewsCampanhas;
	private View PeloOutro;
	private Activity activity;
	private String nome;

	public static final String TAG = "Campanha";

    
   public void onCreate(Bundle savedInstanceState)
    {
		Log.i(TAG, "Entrou no Construtor Campanha");
        super.onCreate(savedInstanceState);
    
	
//	 public Campanhas(final Context context) {
//			super(context);
			
		Log.i(TAG, "Entrou no Construtor Campanha");
			
		//activity = (Activity) context;
		
		//activity.setContentView(R.layout.main);
		
		//setContentView(R.layout.main);
        // Criação de uma lista quer será utilizada em nosso adapter
        linguagens = new ArrayList<JSONObject>();
        viewsCampanhas = new HashMap<String, View>();
        
        
        // Informações que serão utilizados no exemplo
        try {
          JSONObject bolsaformacao = new JSONObject();
          bolsaformacao.put("nome", "Bolsa Formação");          
          linguagens.add(bolsaformacao);
          viewsCampanhas.put(nome, PeloOutro);
          
       // -----------------Estourando ------------------------        
          JSONObject jovensEmb = new JSONObject();
          jovensEmb.put(adapter.savedName, "Jovens Embaixadores");         
          linguagens.add(jovensEmb); 
      // -----------------------------------------        
          
          JSONObject cienciaSemFronteiras = new JSONObject();
          cienciaSemFronteiras.put("nome", "Ciência Sem Fronteiras");         
          linguagens.add(cienciaSemFronteiras);
         
          JSONObject saudeVesteKimono = new JSONObject();
          saudeVesteKimono.put("nome", "Saúde Veste Kimono");          
          linguagens.add(saudeVesteKimono);
          
          JSONObject capacitacaooEmProjetosCulturais = new JSONObject();
          capacitacaooEmProjetosCulturais.put("nome", "Capacitacão Em Projetos Culturais");          
          linguagens.add(capacitacaooEmProjetosCulturais);
          
          JSONObject aceleraçãoEscolar = new JSONObject();
          aceleraçãoEscolar.put("nome", "Aceleração Escolar");          
          linguagens.add(aceleraçãoEscolar);
          
          JSONObject jovemAprendiz = new JSONObject();
          jovemAprendiz.put("nome", "jovemAprendiz");          
          linguagens.add(jovemAprendiz);
          
          JSONObject aceleracaoEscolarparaAgentesComunitáriosDaSaude = new JSONObject();
          aceleracaoEscolarparaAgentesComunitáriosDaSaude.put("nome", "Aceleração Escolar para Agentes Comunitários da Saúde");          
          linguagens.add(aceleracaoEscolarparaAgentesComunitáriosDaSaude);
          
          JSONObject vilaOlimpicaProfessorManoelJoseGomesTubino = new JSONObject();
          vilaOlimpicaProfessorManoelJoseGomesTubino.put("nome", "Vila Olímpica Professor Manoel José Gomes Tubino- Mato Alto (Jacarepaguá)");          
          linguagens.add(vilaOlimpicaProfessorManoelJoseGomesTubino);
          
          JSONObject vilaOlimpicaCarlosCastilho = new JSONObject();
          vilaOlimpicaCarlosCastilho.put("nome", "Vila Olímpica Carlos Castilho");          
          linguagens.add(vilaOlimpicaCarlosCastilho);
          
          JSONObject vilaOlimpicadaMare = new JSONObject();
          vilaOlimpicadaMare.put("nome", "Vila Olímpica da Maré");          
          linguagens.add(vilaOlimpicadaMare);
          
          JSONObject vilaOlimpicaJornalistaArydeCarvalho = new JSONObject();
          vilaOlimpicaJornalistaArydeCarvalho.put("nome", "Vila Olímpica Jornalista Ary de Carvalho");          
          linguagens.add(vilaOlimpicaJornalistaArydeCarvalho);
          
          JSONObject parquedasVizinhacasDiasGomes = new JSONObject();
          parquedasVizinhacasDiasGomes.put("nome", "Parque das Vizinhaças Dias Gomes");          
          linguagens.add(parquedasVizinhacasDiasGomes);
          
          JSONObject vilaOlimpicaClaraNunes = new JSONObject();
          parquedasVizinhacasDiasGomes.put("nome", "Vila Olímpica Clara Nunes");          
          linguagens.add(vilaOlimpicaClaraNunes);
          
          JSONObject vilaOlimpicaMestreAndre = new JSONObject();
          vilaOlimpicaMestreAndre.put("nome", "Vila Olímpica Mestre Andre");          
          linguagens.add(vilaOlimpicaMestreAndre);
          
          JSONObject vilaOlimpicaOscarSchimdt = new JSONObject();
          vilaOlimpicaOscarSchimdt.put("nome", "Vila Olímpica Oscar Schimdt");          
          linguagens.add(vilaOlimpicaOscarSchimdt);
          
          JSONObject vilaOlimpicadaGamboa = new JSONObject();
          vilaOlimpicadaGamboa .put("nome", "Vila Olímpica da Gamboa");          
          linguagens.add(vilaOlimpicadaGamboa);
          
          JSONObject aceleracaoEscolarparaAgentesComunitariosdaSaude = new JSONObject();
          aceleracaoEscolarparaAgentesComunitariosdaSaude.put("nome", "Aceleração Escolar para Agentes Comunitários da Saúde");          
          linguagens.add(aceleracaoEscolarparaAgentesComunitariosdaSaude);
          
        } 
        catch (JSONException e)
        {
          // Tratando possivel exception ao adicionar informacoes no json
        }
        
        // Passamos a lista de exemplo para gerar nosso adpater
        adapter = new LinguagemArrayAdapter(this, R.layout.linguagem, linguagens);
        
        // Buscando o elemento Listview da nossa interface principal interface 
        lstLinguagens = (ListView) findViewById(R.id.lstLinguagens);

// -----------------Estourando ------------------------        
        // Setando o adapter em nossa ListView
        lstLinguagens.setAdapter(adapter);
     
        // Setando callback ao selecionar um item da lista
       lstLinguagens.setOnItemClickListener(new OnItemClickListener()
        {
          
          public void onItemClick(AdapterView<?> parent, View view, int position, long id)
          {
            
	            try
	            {
	              JSONObject linguagem = linguagens.get(position);
	              String name = linguagem.getString("nome");              
	             
	              //viewsCampanhas.get(nome);
	              Toast.makeText(getApplicationContext(), name, 10000).show();
	              
	            }
	            catch (JSONException e) 
	            {
	            
	            }
          }
        });
     // -----------------------------------------        
    
	 }
}

*/