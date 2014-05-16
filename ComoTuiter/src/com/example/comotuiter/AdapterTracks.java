package com.example.comotuiter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterTracks extends ArrayAdapter<Track> {

	Activity context;
	ArrayList<Track> listaTracks;
	
	public AdapterTracks(Activity context, ArrayList<Track> listaTracks){
		super(context, R.layout.layout_adapter, listaTracks);
		this.context = context;
		this.listaTracks = listaTracks;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.layout_adapter,null);
		Track t = listaTracks.get(position);
		
		TextView trackAlbum = (TextView)item.findViewById(R.id.txAlbum);
		TextView trackArtista = (TextView)item.findViewById(R.id.txArtista);
		TextView trackTitulo = (TextView)item.findViewById(R.id.txTitulo);
		
		trackAlbum.setText(t.getAlbum());
		trackArtista.setText(t.getArtista());
		trackTitulo.setText(t.getTitulo());
		
		return item;
	}
	
	public Track getTrack(int pos){
		Track t=  listaTracks.get(pos);
		return t;
	}
}
