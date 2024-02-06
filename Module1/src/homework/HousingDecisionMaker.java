package homework;

import java.util.Scanner;

public class HousingDecisionMaker {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		int points = 0; //Determine how many points a student gets
		int year = 0; //Used to collect what the year the student is
		String input; //Used to collect "yes" or "no" from the student
		
		
		do {
			System.out.println("What is your class year? (1, 2, 3, 4)");
			year = scnr.nextInt();
			if(year == 1 || year == 2) {	//If the student is a freshman or sophomore, they get 1 point
				points += 1;
			} else if(year == 3 || year == 4) {	//If the student is a junior or senior, they get 2 points
				points += 2;
			} else {
				System.out.println("Invalid class year entered.");	//Error message if they didn't type in a year from 1-4
			}
		}while(year < 1 || year > 4); //Student will be prompted to answer the question again if they didn't give an answer from 1-4
		
		
		do {
			System.out.println("Is your place of residence more than 30 minutes away from campus? (yes or no)");
			input = scnr.next();
			switch(input.toLowerCase()) {
				case "yes":	//If the student answered yes, they'll answer a series of question based on where they live
					
					do {
						System.out.println("Are you an international student? (yes or no)");
						input = scnr.next();
						switch(input.toLowerCase()) {
							case "yes":	//If they're an international student, they'll get 3 points and the algorithm breaks there
								points += 3;
								break;
							case "no": //If they've answered no, they'll be asked if they're live out-of-state
								
								do {
									System.out.println("Do you live out-of-state? (yes or no)");
									input = scnr.next();
									switch(input.toLowerCase()) {
										case "yes":	// If they live out-of-state, they'll get 2 points and the algorithm breaks there
											points += 2;
											break;
										case "no": //If they answered no, that mean they're an in-state student that lives more than 30 minutes away from campus
											points += 1;
											break;
										default:
											System.out.println("Invalid answer entered.");	//Error message if they didn't type in yes or no if they live out-of-state
									}
								}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
								//Student will be prompted to answer again whether they live out-of-state if they didn't give a correct answer
								
								break;
							default:
								System.out.println("Invalid answer entered.");	//Error message if they didn't type in yes or no if they're an international student
						}
						
					}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
					//Student will be prompted to answer again if they're an international student if they didn't give a correct answer
					
					break;
				case "no":	//Algorithm breaks if they don't live more than 30 minutes away
					break;
				default:
					System.out.println("Invalid answer entered.");	//Error message if they didn't type in yes or no if they live more than 30 minutes away
			}
		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		//Student will be prompted to answer again if they live more than 30 minutes away if they didn't give a correct answer
		
		
		do {
			System.out.println("Are you on academic probation? (yes or no)");
			input = scnr.next();
			if(input.equalsIgnoreCase("yes")) {	//If they've answered yes, they'll lose one point and be prompted to answer if they'te facing possible academic suspension
				points -= 1;
				
				do {
					System.out.println("Are you facing possible academic suspension? (yes or no)");
					input = scnr.next();
					if(input.equalsIgnoreCase("yes")) {	//If they've answered yes, they'll lose another point
						points -= 1;
					} else if(input.equalsIgnoreCase("no")) {	//If no, nothing happens
						
					} else {
						System.out.println("Invalid answer entered.");	//Error message if they didn't type yes or no
					}
				}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
				//Student will be prompted to answer again if they're facing possible academic suspension if they didn't give a correct answer
				
			} else if(input.equalsIgnoreCase("no")) {	//If they've answered no to being academic probation, nothing happens
				
			} else {
				System.out.println("Invalid answer entered."); //Error message if they didn't type yes or no
			}
		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		//Student will be prompted to answer again if they're on academic probation if they didn't give a correct answer
		
		
		do {
			System.out.println("Do you have medical accomodations that need to be met? (yes or no)");
			input = scnr.next();
			if(input.equalsIgnoreCase("yes")) { //If yes, they'll get 2 points
				points += 2;
			} else if(input.equalsIgnoreCase("no")) { //If no, they'll get no points
				
			} else {
				System.out.println("Invalid answer entered"); //Error message
			}
		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		//Will be asked the question again if they didn't answer yes or no
		
		
		do {
			System.out.println("Do you have a campus job? (yes or no)");
			input = scnr.next();
			if(input.equalsIgnoreCase("yes")) {	//If yes, they'll get 1 point
				points += 1;
			} else if(input.equalsIgnoreCase("no")) {	//If no, they'll get no points
				points += 0;
			} else {
				System.out.println("Invalid answer entered");	//Error message
			}
		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		//Will be asked the question again if they didn't answer yes or no
		
		
		do {
			System.out.println("Do you demonstrate financial need? (yes or no)");
			input = scnr.next();
			if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {	//Checks if the answer is not yes and no
				System.out.println("Invalid answer entered");	//Error message
			} else if(input.equalsIgnoreCase("yes")) {	//If yes, they'll get 1 point
				points += 1;
			}
		}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		//Will be asked the question again if they didn't answer yes or no
		
		
		System.out.printf("%d points have been distributed in deciding your housing allocation.\n", points);
		//Prints out how many points the student will get, based on the previous questions above
		
		scnr.close();

		System.out.println("Hello, world");
		System.out.println("Hello, world");
	}
}
