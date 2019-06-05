package aula_20;
import java.util.ArrayList;
 public class ItemCollection{
     private ArrayList<Item> its;
     
     public ItemCollection(){
     
     }
     public void addItem(Item it){
        its.add(it);
     }
     public Item buscaItem(String titulo){
	int i = 0;
            while(i < its.size()){
		if(its.get(i).getTitulo().equals(titulo)){
		return its.get(i);
		}
                i++;
            }
		
	return null;
    }
     public void listItem(){
		if(!its.isEmpty()){
			int index = 0;
			while(index < its.size()){
				System.out.printf("Titulo: %s\n",its.get(index).getTitulo());
				index++;
			}	
		}else{
			System.out.println("Lista de Itens vazia!");
		}
	}
     public void removeItem(String titulo){
		if(!its.isEmpty()){
			int index = 0;
			boolean teste = true;
			while(index < its.size()){
				if(its.get(index).getTitulo().equals(titulo)){
					its.remove(index);
					teste = false;
				}
				index++;
			}
			
			if(teste){
				System.out.println("Este titulo nao é um titulo valido de item!");
			}
		}else{
			System.out.println("Lista Vazia!");
		}
	}
	
}