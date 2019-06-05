package provaCD2;
import java.util.ArrayList;

public class CDcollection {
    private ArrayList<CD> cds;

    public CDcollection(){
    cds = new ArrayList<CD>();
    }
    public int numberOfcds(){
        return cds.size();
    }
    public void insereCD(CD cd){
        cds.add(cd);
    }
    public void removeCD(String titulo){
        boolean cont = true;
        int i = 0;
        while(cont && i != numberOfcds()){
            if(cds.get(i).getTitulo().equals(titulo)){
                cds.remove(i);
                cont = false;
            }
            i++;
        }
    }
    public boolean verificaCD(String titulo){
        boolean cont = true;
        int i = 0;
        while(cont && i != numberOfcds()){
            if(cds.get(i).getTitulo().equals(titulo)){
                cont = false;
                return true;
            }
            i++;
        }
        return false;
    }
}
