package com.mainfiles;

import java.util.Scanner;

import com.daolayer.FlightDAO;
import com.daolayer.PassengerDAO;
import com.daolayer.PaymentDAO;
import com.pojo.Flight;
import com.pojo.Payment;
import com.pojo.Traveller;

public class MainCode {
	static {
		System.out.println("----------------------    WELCOME TO AIRLINE RESERVATION     --------------------");
		System.out.println();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		FlightDAO fd= new FlightDAO();
		Flight ff=new Flight();
		
		
		PassengerDAO emp = new PassengerDAO();
		Traveller t =new Traveller();
		
		PaymentDAO p = new PaymentDAO();
		Payment p1 = new Payment();
		
		
		Scanner sc =new Scanner(System.in);
		
		String enter = null;
		
		do {
			System.out.println("What are you logging as :");
			System.out.println("1) ADMIN \n2) USER");
			int choice = sc.nextInt();
		
		if(choice ==1) {
			
			System.out.println();
			System.out.println("ADMIN LOGIN SUCCESFUL");
			System.out.println("------------------------");
			System.out.println();
			System.out.println("Choose an operation to perform :: "); 
			System.out.println();
			 System.out.println("1. INSERT FLIGHT");	
			System.out.println("2. UPDATE FLIGHT ");
			System.out.println("3. DELETE FLIGHT ");
			System.out.println("4. DISPLAY FLIGHT DETAILS ");
			System.out.println("5. DISPLAY BOOKING DETAILS ");
			System.out.println("6. DELETE TRAVELLER  ");
			System.out.println("7. Check A Particular Passenger Booking Details");
			System.out.println("8. Check list of travellers Based on flight code ::");
			
			System.out.println();
			System.out.println("Enter your choice ");
			choice =sc.nextInt();
			
			switch(choice) {
				case 1: System.out.println(); 
						System.out.println("Flight Insertion Called ");
						System.out.println();
						fd.fliinsert(ff);
						break;
				case 2:System.out.println(); 
						fd.fliupdate();
						System.out.println();
						break;
				case 3:System.out.println(); 
						fd.flidelete();
						System.out.println();
						break;
				case 4:System.out.println(); 
						fd.flidisplay();
						System.out.println();
							break;
				case 5:System.out.println(); 
				p.paydisplay();
				System.out.println();
					break;
				case 6:System.out.println(); 
						emp.pasdelete();
						System.out.println();
						break;
				case 7:System.out.println(); 
						p.bookingPas();
						System.out.println();
						break;
				case 8:System.out.println(); 
						p.pasFlight();
						System.out.println();
						break;
							
				default : System.out.println("Invalid Input ");
					
			}
			System.out.println("Do you want to continue (y/n)?");
			 enter=sc.next();
			
			}
		
			else if(choice==2) {
				System.out.println();
				System.out.println("TRAVELLER LOGIN  SUCCESFUL");
				System.out.println("------------------------");
				System.out.println();
				System.out.println("Choose an operation to perform :: "); 
				System.out.println();
				System.out.println("1. INSERT TRAVELLER DETAILS");	
				System.out.println("2. UPDATE TRAVELLER DETAILS ");
				System.out.println("3. DISPLAY TRAVELLER DETAILS ");
				System.out.println();
				System.out.println("Enter your choice ");
				choice =sc.nextInt();
				
				switch(choice) {
				case 1: System.out.println(); 
					System.out.println("Flight Insertion Called ");
					System.out.println();
					emp.pasinsert(t);
						break;
				case 2:System.out.println(); 
					emp.pasupdate();
					System.out.println();
						break;
				case 3:System.out.println(); 
						emp.pasdisplay();
						System.out.println();
							break;
				default:
					System.out.println("invalid input ");
					break;
				}
				System.out.println("Do you want to continue (y/n)?");
				 enter=sc.next();
				
			}
			
		
	}while(enter.equals("Y") || enter.equals("y"));
		sc.close();	
	}
	
}

