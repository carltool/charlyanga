package com.example.comotuiter;


public class Track {
	private String trackTitulo, trackArtista, trackAlbum, trackLetra;
	
	public Track(String titulo, String artista, String album, String letra){
		this.trackAlbum = album;
		this.trackArtista = artista;
		this.trackTitulo = titulo;
		this.trackLetra = letra;
	}

	public void setLetra(String letra){
		this.trackLetra = letra;
	}
	
	public void setTitulo(String titulo){
		this.trackTitulo = titulo;
	}
	public void setArtista(String artista){
		this.trackTitulo = artista;
	}
	
	public void setAlbum(String album){
		this.trackTitulo = album;
	}
	
	
	public String getTitulo(){
		return trackTitulo;
	}
	
	public String getArtista(){
		return trackArtista;
	}
	public String getAlbum(){
		return trackAlbum;
	}
	public String getLetra(){
		return trackLetra;
	}
}
