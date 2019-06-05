public class Estudante extends Pessoa {
    
    private int identidade;
    private String grau;
    
    public Estudante(){
        identidade = 0;
        grau = null;
    }
    public Estudante(String name,String sobrename, int gen,String dat, int identidade, String grau){
        super(name, sobrename, gen, dat);
        this.identidade = identidade;
        this.grau = grau;
    }
    
    public String toString(){
        System.out.println(getNome() +"\n"+ getSobrenome()+"\n" + getGenero()+"\n" + getData()+"\n" + getIdentidade()+ "\n" + getGrau()+"\n");
        return getNome() + getSobrenome() + getGenero() + getData() + getIdentidade() + getGrau();
    } 
    
    public String getGrau(){
        return grau;
    }

    public int getIdentidade() {
        return identidade;
    }

   

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }
    
}
