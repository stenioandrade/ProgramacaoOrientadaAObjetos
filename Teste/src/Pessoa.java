public class Pessoa {
    
   private String nome;
   private String sobrenome;
   private int genero;
   private String data;
    
    
    public Pessoa(){
        nome = null;
        sobrenome = null;
        genero = 0;
        data = null;
    }
    public Pessoa(String name, String sobrename, int gen, String dat){
        nome = name;
        sobrenome=sobrename;
        genero = gen;
        data = dat;
    }
    
    
    public String toString(){
        System.out.println("Nome: "+nome+"\nSobrenome: "+sobrenome+"\nGenero: "+genero+"\nData: "+data);
        return nome + sobrenome + genero + data;
    } 

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getGenero() {
        return genero;
    }

    public String getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
