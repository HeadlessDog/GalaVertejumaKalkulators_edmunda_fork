package pakotne;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GalvenaKlase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int studSk = 0, kritSk = 0, maxSvars = 100;
		String[] studenti = null;
		String[] kriteriji = null;
		int[] kriterijaSvars = null;
		int[][] kriterijaVertejums = null;
		double[] semestraVertejums = null;
		/*
		int[][] kriterijaVertejums = 
		double[] 
		*/
		
		String izvele;
		
		do {
			System.out.println("0 - Iziet\n"
			+ "1 - Ievadīt audzēkņus\n"
			+ "2 - Ievadīt kritērijus\n"
			+ "3 - Ievadīt kritēriju svarus\n"
			+ "4 - Ievadīt vērtējumus\n"
			+ "5 - Labot kritēriju\n"
			+ "6 - Labot kritērija svaru\n"
			+ "7 - Labot iegūto vērtējumu\n"
			+ "8 - Aprēķināt gala vērtējumu\n"
			+ "9 - Saglabāt rezultātus failā\n"
			+ "10 - Nolasīt rezultātus no faila");
				
			izvele = sc.nextLine();

			switch(izvele) {
			case "0":
				break;
			
			case "1":
				studSk = method_klase.sklSkEntry();
				studenti = new String[studSk];
				semestraVertejums = new double[studSk];
				
				method_klase.nameEntry(studenti);
				
				semestraVertejums = null;
				kriterijaVertejums = null;
				break;
			case "2":
				kritSk = method_klase.kritSkEntry(kriteriji);
				kriterijaSvars = new int[kritSk];
				
				semestraVertejums = null;
				kriterijaVertejums = null;
				break;
			case "3":
				if(kriteriji != null && !Arrays.stream(kriteriji).allMatch(Objects::isNull)) {
					method_klase.weightEntry(kriteriji, kriterijaSvars, maxSvars);
					
					semestraVertejums = null;
					kriterijaVertejums = null;
				}
				else
					System.out.println("Nav ievadīti kritēriji!");
				break;
			case "4":
				if(studenti != null && !Arrays.stream(studenti).allMatch(Objects::isNull)
					&& kriteriji != null && !Arrays.stream(kriteriji).allMatch(Objects::isNull)) {
					
					kriterijaVertejums = new int[studSk][kritSk];
					method_klase.kritResultsEntry(kriterijaVertejums, studenti, kriteriji);
					
					method_klase.finalResCalc(studenti, kriteriji, kriterijaSvars, kriterijaVertejums, semestraVertejums);
				}
				else
					System.out.println("Nav ievadīti studenti vai kritēriji!");
				break;
			case "5":
				method_klase.kritRedo(kriteriji);
				break;
			case "6":
				if(kriteriji != null && !Arrays.stream(kriteriji).allMatch(Objects::isNull)) {
					method_klase.redoWeight(kriteriji, kriterijaSvars, maxSvars);
					
					semestraVertejums = null;
					kriterijaVertejums = null;
				}
				else
					System.out.println("Kādi no datiem nav ievadīti.");
				break;	
			case "7":
				break;
			case "8":
				if(semestraVertejums != null && !Arrays.stream(semestraVertejums).allMatch(Objects::isNull))
					method_klase.fullResOut(studenti, kriteriji, kriterijaVertejums, semestraVertejums, kriterijaSvars);
				else
					System.out.println("Nav ievadīti kādi no datiem, iespējams pēc citu datu mainīšanas.");
				break;
			case "9":
				if(semestraVertejums != null && !Arrays.stream(semestraVertejums).allMatch(Objects::isNull))
					method_klase.saveResFile(studenti, kriteriji, kriterijaVertejums, kriterijaSvars, semestraVertejums);
				else
					System.out.println("Nav ievadīti kādi no datiem, iespējams pēc citu datu mainīšanas.");
				break;
			case "10":
				method_klase.readFile();
				break;
			default:
				System.out.println("Nederīga vērtība!");
			}
			
		}while(!izvele.equals("0"));
		
		method_klase.scan.close();
		sc.close();
	}
}