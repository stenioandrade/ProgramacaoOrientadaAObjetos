package provaCD3;
import java.util.ArrayList;

public class CDcollection {
    private ArrayList<CD> cds;
    
    public CDcollection(){
        cds = new ArrayList<CD>();
    }
    public int numOfcds(){
        return cds.size();
    }
    public void insereCD(CD cd){
        cds.add(cd);
    }
    public void removeCD(int position){
        if (numOfcds()==0) return;
        if (position < 0) return;
        if (position < numOfcds()) cds.remove(position);
        if (position >= numOfcds()) return;
    }
    public boolean verificaCD(String titulo){
        int i = 0;
        boolean cont = true;
        if (numOfcds()==0) return false;
        while(cont && i != numOfcds()){
            if(cds.get(i).getTitulo().equals(titulo)){
                cont = false;
                return true;
            }
            i++;
        }
        return false;
    }
}
