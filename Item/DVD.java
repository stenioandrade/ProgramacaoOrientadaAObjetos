public class DVD extends Item{
	private String diretor;

	public DVD(String theTitle, int time, String theDirector){
		super(theTitle, time);
		diretor = theDirector;

	}
	public void setDiretor(String diretor){
		this.diretor = diretor;
	}
	public String getDiretor(){
		return diretor;
	}
}