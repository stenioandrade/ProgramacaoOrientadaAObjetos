package Aula_18_pac;
public class Item{
	private String titulo;
	private int tempoReproducao;
	private boolean possuo;
	private String comentario;
	
	public Item(String titulo, int tempoReproducao){
		this.titulo = titulo;
		this.tempoReproducao = tempoReproducao;
		possuo = false;
		comentario = "";
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public int getTempoReproducao(){
		return tempoReproducao;
	}
	
	public void setTempoReproducao(int tempoReproducao){
		this.tempoReproducao = tempoReproducao;
	}
	
	public boolean getPossuo(){
		return possuo;
	}
	
	public void setPossuo(boolean possuo){
		this.possuo = possuo;
	}
	
	public String getComentario(){
		return comentario;
	}
	
	public void setComentario(String comentario){
		this.comentario = comentario;
	}
}