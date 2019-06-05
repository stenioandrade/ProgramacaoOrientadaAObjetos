public class Main{
	public static void main(String args[]){
		Database db = new Database();
		Cd cd = new Cd("Mamonas Assassinas", 120, "Mamonas", 10);
		cd.setComentario("Epico");
		
		Dvd dvd = new Dvd("Renato da Guerra", 120, "Santa Monica");
		dvd.setComentario("Saga 2");
		
		db.addCd(cd);
		db.addDvd(dvd);
		
		db.listCd();
		db.listDvd();
	
		Item cd = db.buscaCd("Mamonas Assassinas");
		Item dvd = db.buscaDvd("Renato da Guerra");
		
		System.out.println("Cd: "+ cd.getTitulo() + " Comentario: " + cd.getComentario());
		System.out.println("Dvd: "+ dvd.getTitulo() + " Comentario: " + dvd.getComentario());
	}
}