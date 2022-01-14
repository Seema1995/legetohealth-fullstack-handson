package com.fullstack.day3;

public class MovieApp {

	public static void main(String[] args) {
		Movie m = new Movie("Jersey", "Dil Raju", "Gowtam Tinnanuri", 2.50F, 2021, "Sports/Drama");
		Movie m2 = new Movie("Zindagi na milegi dobara", "Farhan Akhtar", "Zoya Akhtar", 2.55F, 2011,
				"Comedy/Adventure/Drama");
		Movie m3 = new Movie("83", "Deepika Padukone/Kabir Khan/ Sajid Nadiadwala", "Kabir Khan", 2.60F, 2021,
				"Drama/Sports");

		Movie m4 = new InternationalMovie("Lagaan", "Aamir Khan", "India", "Hindi");
		Movie m5 = new InternationalMovie("The Disciple", "Vivek Gomber", "India", "Marathi");

		System.out.println("Here are some National and International Movie recommendations - ");
		System.out.println("*****************************************************************");

		System.out.println(m.showDetails());
		System.out.println("*****************************************************************");
		System.out.println(m2.showDetails());
		System.out.println("*****************************************************************");
		System.out.println(m3.showDetails());
		System.out.println("*****************************************************************");
		System.out.println(m4.showDetails());
		System.out.println("*****************************************************************");
		System.out.println(m5.showDetails());

	}

}
