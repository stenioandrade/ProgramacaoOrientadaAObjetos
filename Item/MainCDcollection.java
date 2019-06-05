public class MainCDcollection{

	public static void main (String args[]) {
		
		CD cd = new CD("k","o",0);
		CD cd2 = new CD("x","Y",0);
		
		cd.setArtist("chet faker");
		cd.setTitle("breaking glass");
		cd.setTracks(24);
		
		cd2.setArtist("Angus");
		cd2.setTitle("old friends");
		cd2.setTracks(12);
		
		CDcollection collection = new CDcollection();
		
		collection.storeCD(cd);
		collection.storeCD(cd2);
		//collection.showCds();
		collection.removeCD("breaking glass");
		collection.removeCD("Amianto");		
		System.out.println();
		System.out.println(collection.verificaCD("breaking glass"));
		System.out.println(collection.verificaCD("black crow"));
		//System.out.println();
		//cdcollection.showCds();
	
		
	}
}