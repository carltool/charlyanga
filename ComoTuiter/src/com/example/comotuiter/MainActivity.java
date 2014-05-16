package com.example.comotuiter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

	TabHost th;
	ListView listView;
	ArrayList<Track> listaTracks;
	EditText inTitulo, inArtista, inAlbum, inLetra;
	Button btAdd;
	Intent i;
	String ARTISTA = "artista", TITULO = "titulo", ALBUM = "album", LETRA = "letra";
	String ti,art,al,le;

// Creamos un adapter personalizado
	AdapterTracks adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        th = (TabHost) findViewById (R.id.tabhost);
       
        th.setup();
        TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("Pistas");
        th.addTab(specs);
        
        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Agregar");
        th.addTab(specs);
        
        
        //listview

    	listView = (ListView) findViewById(R.id.lTracks);
    	listaTracks = new ArrayList<Track>();

    	// Al adapter personalizado le pasamos el contexto y la lista que contiene
    	// Añadimos el adapter al listview
    	adapter = new AdapterTracks(this, listaTracks);
    	listView.setAdapter(adapter);
        
    	//declarar los elementos
    	btAdd = (Button) findViewById(R.id.botonAgregar);
    	inAlbum= (EditText) findViewById(R.id.inAlbum);
    	inArtista= (EditText) findViewById(R.id.inArtista);
    	inTitulo= (EditText) findViewById(R.id.inTitulo);
    	inLetra = (EditText)findViewById(R.id.inLetra);
    	btAdd.setOnClickListener(new View.OnClickListener() {
    		//agrega elementos con el otro tab
            @Override
            public void onClick(View v) {
                listaTracks.add(new Track(inTitulo.getText().toString(),inArtista.getText().toString(), inAlbum.getText().toString(), inLetra.getText().toString() ));
             //Aquí le decimos al adapter que notifique los cambios
                adapter.notifyDataSetChanged();
             //Borramos el contenido del EditText
                inAlbum.setText("");
                inArtista.setText("");
                inTitulo.setText("");
                inLetra.setText("");
                
            }
        });
    	
    	//click en los elementos de la lista
    	listView.setOnItemClickListener(new OnItemClickListener(){
	    	 
	        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
	            // TODO Auto-generated method stub
	        	//variables string que serán enviados
	        	
	        	//extrae un objeto de la lista de tracks
	        
	        	Track tr = listaTracks.get(position);
	        	//asigna valores correspondientes a las variables
	        	ti = tr.getTitulo();
	        	art = tr.getArtista();
	        	al = tr.getAlbum();
	        	le = tr.getLetra();
	        	
	        	i = new Intent(MainActivity.this,ElementoActivity.class);
	        	//envia los strings al activity elementoActivity
	        	i.putExtra(TITULO, ti);
	        	i.putExtra(ARTISTA, art);
	        	i.putExtra(ALBUM, al);
	        	i.putExtra(LETRA, le);
	        	startActivity(i);
	        }
			
	    }); 
    }

    
}
