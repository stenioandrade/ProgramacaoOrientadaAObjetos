import java.util.ArrayList;
public class Eleicao {
    private ArrayList<Candidato> cand;
    
    public Eleicao(){
        cand = new ArrayList<Candidato>();
    }
    public void cadastrarCandidato(Candidato c){
        cand.add(c);
    }
    public void votarCandidato(String nome){
        if(cand.size()==0) throw new NullPointerException("(votarCandidato)Nenhum candidato cadastrado!");
        int i;
        for(i=0;i<cand.size();i++){
            if(cand.get(i).getNome().equals(nome)){
                cand.get(i).addVoto();
                return;
            }
        }
        throw new NullPointerException("(votarCandidato)"+nome+" nao esta dentre os candidatos");
    }
    
    public int contagem(String nome){
        if(cand.size()==0) throw new NullPointerException("(contagem)Nenhum candidato cadastrado!");
        int i;
        for(i=0;i<cand.size();i++){
            if(cand.get(i).getNome().equals(nome)){
                return cand.get(i).getVotos();
            }
        }
        throw new NullPointerException("(contagem)"+nome+" nao esta dentre os candidatos");
    }
    
    public void contagem(){
        if(cand.size()==0) throw new NullPointerException("(contagem)Nenhum candidato cadastrado!");
        int i, ctrl = 0, ind = 0, emp = 0;
        for(i=0;i<cand.size();i++){
            if(ctrl < cand.get(i).getVotos()){
                ctrl = cand.get(i).getVotos();
                ind = i;
            }
        }
        for(i=0;i<cand.size();i++){
            if(cand.get(i).getVotos()==ctrl){
                emp++;
            }
        }
        if(emp == 1){
            System.out.println(cand.get(ind).getNome()+" ganhou com "+ctrl+" votos.");
        }
        else{
            System.out.printf("Houve empate entre %d candidatos\n",emp);
            while(emp > 1){
                for(i=0;i<cand.size();i++){
                    if(cand.get(i).getVotos() == ctrl){
                        System.out.println(cand.get(i).getNome()+" com "+ctrl+" votos");
                        emp--;
                    }
                }
            }
        }
    }
}
