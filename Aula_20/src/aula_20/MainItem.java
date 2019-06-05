package aula_20;
public class MainItem{
    public static void main(String args[]){
	Database db = new Database();
	Cd cd = new Cd("Californication", 60, "rhcp", 12);
	cd.setComentario("muito bom");
		
	Dvd dvd = new Dvd("turmadaxuxa", 50, "xuxa");
	dvd.setComentario("I edicao");
		
	db.addItem(cd);
	db.addItem(dvd);
	System.out.println("Listagem de itens\n####################");
	db.listItem();
	System.out.println("####################\nFim da listagem de itens\n\n");
        //Item it = db.buscaItem("Californication");
        Item it = db.buscaItem("turmadaxuxa");
        Cd cd1;
        Dvd dvd1;
        if (it instanceof Cd){
            cd1 = new Cd();
            cd1 = (Cd) it;
            System.out.println("Cd: "+ cd1.getTitulo() + "\nArtista: "+ cd1.getArtista() + "\nComentario: " + cd1.getComentario());
        }else{
            dvd1 = new Dvd();
            dvd1 = (Dvd) it;
            System.out.println("Dvd: "+ dvd1.getTitulo() + "\nDiretor: "+dvd1.getDiretor() + "\nComentario: " + dvd1.getComentario());
        }      
    }
}