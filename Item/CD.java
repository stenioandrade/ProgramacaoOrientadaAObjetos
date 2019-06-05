public class CD extends Item{
	private String artist;
	private int numeroTrilhas;

	public CD(String titulo, int time, String artista, int trilhas){
		super(titulo, time);
		artist = artista;
		numeroTrilhas = trilhas;
	}
	public void setArtist(String artista){
		artist = artista;
	}
	public String getArtist(){
		return artist;
	}
	public void setTracks (int tracks){
		numeroTrilhas = tracks;
	}
	public int getTracks (){
		return numeroTrilhas;
	}
}