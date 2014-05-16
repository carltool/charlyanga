package com.example.comotuiter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ElementoActivity extends Activity {

	TextView tit,alb,art,letra;
	Bundle b;
	String ctit,calb,cart,cletra;
	String ARTISTA = "artista", TITULO = "titulo", ALBUM = "album", LETRA = "letra";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elemento);
		
		//iniciar los elementos del activity
	
		tit = (TextView) findViewById(R.id.showTitulo);
		alb = (TextView)findViewById(R.id.showAlbum);
		art = (TextView)findViewById(R.id.showArtista);
		letra = (TextView)findViewById(R.id.showLetra);
		
		b = getIntent().getExtras();
		
		ctit = b.getString(TITULO);
		calb = b.getString(ALBUM);
		cart = b.getString(ARTISTA);
		cletra = b.getString(LETRA);
		
		tit.setText(ctit);
		alb.setText(calb);
		art.setText(cart);
		letra.setText(cletra);
	}
}
