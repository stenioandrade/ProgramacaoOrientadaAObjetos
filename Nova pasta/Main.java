package Aula_18_pac;
public class Main{
	public static void main(String args[]){
		Database db = new Database();
		CD cd = new CD("Mamonas Assassinas", 120, "Mamonas", 10);
		cd.setComentario("Epico");
		
		DVD dvd = new DVD("Renato da Guerra", 120, "Santa Monica");
		dvd.setComentario("Saga 2");
		
		db.addCd(cd);
		db.addDVD(dvd);
		
		db.listaCD();
		db.listaDVD();
	
		Item CD = db.buscaCD("Mamonas Assassinas");
		Item DVD = db.buscaDVD("Renato da Guerra");
		
		System.out.println("Cd: "+ cd.getTitulo() + " Comentario: " + cd.getComentario());
		System.out.println("Dvd: "+ dvd.getTitulo() + " Comentario: " + dvd.getComentario());
	}
}