import java.io.*;
public class MainEleicao {

    public static void main(String[] args){
        Eleicao e = new Eleicao();
        Candidato x = new Candidato("Honesto");
        Candidato y = new Candidato("Decente");
        Candidato z = new Candidato("Trabalhador");
        try{
            e.contagem();
            e.votarCandidato("Qaulaquer");
        }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        e.cadastrarCandidato(x);
        e.cadastrarCandidato(y);
        e.cadastrarCandidato(z);
        try{
            e.votarCandidato("Honesto");
            e.contagem("Honesto");
            e.votarCandidato("Decente");
            e.votarCandidato("Decente");
            e.contagem("Decente");
            e.votarCandidato("Trabalhador");
            e.votarCandidato("Trabalhador");
            e.contagem("Trabalhador");
            e.contagem();
            
            //nova eleicao
            
            System.out.println("Nova eleicao");
            e.votarCandidato("Decente");
            e.votarCandidato("Decente");
            e.votarCandidato("Trabalhador");
            e.votarCandidato("Trabalhador");
            e.votarCandidato("Trabalhador");
            e.contagem();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        //Teste de excecao
        
        System.out.println("Teste de excecao");
        try{
            e.votarCandidato("Papai Noel");
            e.contagem("Papai Noel");
        }
        catch(Exception ex1){
            System.out.println(ex1.getMessage());
        }
        finally{
            System.out.println("FIM!!");
        } 
    }
}