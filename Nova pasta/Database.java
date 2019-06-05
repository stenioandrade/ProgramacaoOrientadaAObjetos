import java.util.ArrayList;

public class Database{
	private ArrayList<Item> cds;
	private ArrayList<Item> dvds;
	
	public Database(){
		cds = new ArrayList<Item>();
		dvds = new ArrayList<Item>();
	}
	
	public void addCd(Cd cd){
		cds.add(cd);
	}
	
	public void addDvd(Dvd dvd){
		dvds.add(dvd);
	}
	
	public Item buscaCd(String titulo){
		int index = 0;
		while(index < cds.size()){
			if(cds.get(index).getTitulo().equals(titulo)){
				return cds.get(index);
			}
			index++;
		}
		
		return null;
	}
	
	public Item buscaDvd(String titulo){
		int index = 0;
		while(index < dvds.size()){
			if(dvds.get(index).getTitulo().equals(titulo)){
				return dvds.get(index);
			}
			index++;
		}
		
		return null;
	}
	
	public void listCd(){
		if(!cds.isEmpty()){
			int index = 0;
			while(index < cds.size()){
				System.out.println("CD:\nTitulo: " + cds.get(index).getTitulo() + "\nComentario: "+ cds.get(index).getComentario());
				index++;
			}	
		}else{
			System.out.println("Lista de CD vazia!");
		}
	}
	
	public void listDvd(){
		if(!dvds.isEmpty()){
			int index = 0;
			while(index < dvds.size()){
				System.out.println("DVD:\nTitulo: " + dvds.get(index).getTitulo() + "\nComentario: "+ dvds.get(index).getComentario());
				index++;
			}	
		}else{
			System.out.println("Lista de DVD vazia!");
		}
	}
	
	public void removeCd(String titulo){
		if(!cds.isEmpty()){
			int index = 0;
			boolean teste = true;
			while(index < cds.size()){
				if(cds.get(index).getTitulo().equals(titulo)){
					cds.remove(index);
					teste = false;
				}
				index++;
			}
			
			if(teste){
				System.out.println("Este titulo nao é um titulo valido de CD!");
			}
		}else{
			System.out.println("Lista Vazia!");
		}
	}
	
	public void removeDvd(String titulo){
		if(!dvds.isEmpty()){
			int index = 0;
			boolean teste = true;
			while(index < dvds.size()){
				if(dvds.get(index).getTitulo().equals(titulo)){
					dvds.remove(index);
					teste = false;
				}
				index++;
			}
			
			if(teste){
				System.out.println("Este titulo nao é um titulo valido de DVD!");
			}
		}else{
			System.out.println("Lista Vazia!");
		}
	}
}