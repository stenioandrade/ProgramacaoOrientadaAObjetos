package aula_20;
public class Cd extends Item{
	private String artista;
	private int numeroTrilhas;
	
        public Cd(){
            artista = "";
            numeroTrilhas = 0;
        }
        
	public Cd(String titulo, int tempo, String artista, int numeroTrilhas){
		super(titulo, tempo);
		this.artista = artista;
		this.numeroTrilhas = numeroTrilhas;
	}
	
	public String getArtista(){
		return artista;
	}
	
	public void setArtista(String artista){
		this.artista = artista;
	}
	
	public int getNumeroTrilhas(){
		return numeroTrilhas;
	}
	
	public void setNumeroTrilhas(int numeroTrilhas){
		this.numeroTrilhas = numeroTrilhas;
	}
}