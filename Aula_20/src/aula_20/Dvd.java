package aula_20;
public class Dvd extends Item{
	private String diretor;
	
        public Dvd(){
            diretor = "";
        }
        
	public Dvd(String titulo, int tempoReproducao, String diretor){
		super(titulo, tempoReproducao);
		this.diretor = diretor;
	}
	
	public String getDiretor(){
		return diretor;
	}
	
	public void setDiretor(String diretor){
		this.diretor = diretor;
	}
}