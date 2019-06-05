public class MainCD {
	public static void main (String[] args){
		CD cd = new CD("CD Gabriel", "Gabriel", 10);
		System.out.println(cd.getTitle());
		cd.setTitle("NovoCD");
		System.out.println(cd.getTitle());
		System.out.println(cd.getArtist());
		cd.setArtist("NovoArtista");
		System.out.println(cd.getArtist());
		System.out.println(cd.getTracks());
		cd.setTracks(15);
		System.out.println(cd.getTracks());
		cd.imprime();
	} 
}