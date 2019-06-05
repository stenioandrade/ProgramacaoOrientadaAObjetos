import java.util.ArrayList;

public class Cadastro {
    ArrayList<Pessoa> pessoas;
    
    public Cadastro(){
        pessoas = new ArrayList<Pessoa>();
    }
    
    public void addPessoa(String name, String sobrename, int gen, String dat){
       Pessoa person = new Pessoa(name, sobrename, gen, dat);
			pessoas.add(person);
                        System.out.printf( "Add Pessoa: " );
                        System.out.println( person.getNome() );
    }
    public void addPessoa(Pessoa p){
        pessoas.add(p);
    }
    public int numeroPessoas(){
        System.out.println(pessoas.size()+" pessoas adicionadas.");
        return pessoas.size();
    }
    public Pessoa buscaPessoa(String nome){
        if(pessoas.size()==0) return null;
        int i;
        for(i=0;i<pessoas.size();i++){
            if(pessoas.get(i).getNome().equals(nome)){
                return pessoas.get(i);
            }
        }
        return null;
    }
    
    public void removePessoa(int i){
        if (i >= pessoas.size()){
            throw new NullPointerException("Indice: "+i+", Size: "+pessoas.size());
        }
        else{
            pessoas.remove(i);
            System.out.println("Pessoa removida\n");
        }
    /*
        try{
            pessoas.remove(i);
                System.out.println("Pessoa "+i+" removida\n");
        }
        catch (Exception e){
                System.out.println("====================");
                System.out.println("|      ERRO        |");
                System.out.println("|Indice invalido   |");
                System.out.println("|"+e.getMessage()+" |");
                System.out.println("====================");
        }*/
    }
    
    
    
}
