public class Candidato {
    private String nome;
    private int votos;
    
    public Candidato(String nome){
        this.nome = nome;
        votos = 0;
    }
    public void addVoto(){
        votos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVotos() {
        return votos;
    }
    
    
    
}

