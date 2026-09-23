package pakotne;

public class GalvenaKlase {
	
	
	public static void main(String[] args) {
		int studSk, kritSk;
		
		studSk = method_klase.sklSkEntry();
		String[] studenti = new String[studSk];
		
		kritSk = method_klase.kritSkEntry();
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		
		
		method_klase.nameEntry(studenti);
		
		// Definē kritērijus
		int maxSvars = 100;
		
		method_klase.weightEntry(kriteriji, kriterijaSvars, maxSvars);
		
		method_klase.kritResultsEntry(kriterijaVertejums, studenti, kriteriji);
		
		method_klase.finalResCalc(studenti, kriteriji, kriterijaSvars, kriterijaVertejums, semestraVertejums);
		
		method_klase.fullResOut(studenti, kriteriji, kriterijaVertejums, semestraVertejums, kriterijaSvars);
		
		method_klase.scan.close();
	}
}