import java.util.ArrayList;
public class Database {
	private ArrayList <Item> itens;
	public Database (){
		itens = new ArrayList<Item>();
	}
	public void storeItem (CD novoCD){
		itens.add(novoCD);
	}
	public void removeItem(String nomeItem){
		int index = 0;
		if(verificaItem(nomeItem)){
			while (index<itens.size()){
				if(itens.get(index).getTitle().equals(nomeItem)){
					itens.remove(index);
				}
			index++;			
			}
		}
		else{
			System.out.println("O Titulo "+nomeItem+ " não foi encontrado");
		}
	}
	public boolean verificaItem(String nomeItem){
		int index=0;
		while (index<itens.size()){
			if(itens.get(index).getTitle().equals(nomeItem)){
				return true;
			}
		index++;
		}
		return false;
	}
	public void imprimeItem(){ 
		for(int i = 0; i<itens.size();i++){
			Item get = itens.get(i);
			System.out.println("Titulo: "+get.getTitle());
			System.out.println("Tempo: "+get.getReprod());
			System.out.println("Comentario: "+get.getComent());		
		}
	}
}