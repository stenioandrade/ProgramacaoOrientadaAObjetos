import java.util.ArrayList;
public class CDcollection {
	private ArrayList <CD> cds;
	public CDcollection(){
		cds = new ArrayList<CD>();
	}
	public void storeCD (CD novoCD){
		cds.add(novoCD);
	}
	public void removeCD(String nomeCD){
		int index = 0;
		if(verificaCD(nomeCD)){
			while (index<cds.size()){
				if(cds.get(index).getTitle().equals(nomeCD)){
					cds.remove(index);
				}
			index++;			
			}
		}
		else{
			System.out.println("O Titulo "+nomeCD+ " não foi encontrado");
		}
	}
	public boolean verificaCD(String nomeCD){
		int index=0;
		while (index<cds.size()){
			if(cds.get(index).getTitle().equals(nomeCD)){
				return true;
			}
		index++;
		}
		return false;
	}
}