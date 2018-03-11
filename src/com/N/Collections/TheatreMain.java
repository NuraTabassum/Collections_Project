package com.N.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TheatreMain {

	public static void main(String[] args) {
		Theatre theatre=new Theatre("AMC",6,12);
		//theater.getSeats();
		List<Theatre.Seat>seatCopy=new ArrayList<>(theatre.seats);//Theater.Seat because Seat is the inner class of Theater.otherwise we can just put Seat
		//Shellow copy by
		//passing it as a constructor send the object (theater.seats) because i want the copy of seats not the copy of theater.
		printList(seatCopy);
		
		List<Theatre.Seat> reverseSeats=new ArrayList<>(theatre.getSeats());
		Collections.reverse(reverseSeats);
		System.out.println("Print Reverse copy ");
		printList(reverseSeats);
		seatCopy.get(2).resrve();// its a copy but seatcopy is pointing to the
		//same location as theater so if reserve one other one is also getting reserved
		if(theatre.reserveSeat("A02")){//its original 
			System.out.println("Please Pay");
		}else{
			System.out.println("Sorry! the seat is taken");
		}
		
		Collections.shuffle(seatCopy);
		System.out.println("Print seatCopy");
		printList(seatCopy);
		
		System.out.println("Print theater.seat");
		printList(theatre.seats);
		sortList(seatCopy);//sorting the shuffled seatCopy
		System.out.println("Print sorted seatcopy");
		printList(seatCopy);
		System.out.println("------------------------------------");
		//.........................end of Shellow copy..............................
		
		//Creating deep copy of seats list using clone
		List<Theatre.Seat> newList=new ArrayList<>(theatre.seats.size());
		for(Iterator iterator=theatre.seats.iterator();iterator.hasNext();){
			Theatre.Seat seat=(Theatre.Seat) iterator.next();
			newList.add((Theatre.Seat)seat.clone());
		}
		theatre.seats.get(4).resrve();//only the original seat will be reserved not the clone list will not reserve
		printList(theatre.seats);
		printList(newList);
		//............................end of deep copy.......................//
		Theatre.Seat minSeat=Collections.min(seatCopy);
		System.out.println("Min seat number is "+minSeat.getSeatNumber());
		Theatre.Seat maxSeat=Collections.max(seatCopy);
		System.out.println("Max seat number is "+maxSeat.getSeatNumber());
		//System.out.println("Reservation status of theaterCopy A01"+ );
		
		//..........................min/max.....................................//
		List<Theatre.Seat> priceSeats=new ArrayList<>(theatre.getSeats());
		priceSeats.add(theatre.new Seat("B00", 13.00));//adding 2 more seats just check the comparison(new Seat) copiying it
		priceSeats.add(theatre.new Seat("A00",13.00));
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);// 2 parameter List and comparator
		printList(priceSeats);
		if(theatre.reserveSeat("F11")){
			System.out.println("Please Pay");
		}else{
			System.out.println("Sorry! the seat is taken");
		}
		if(theatre.reserveSeat("F11")){
			System.out.println("Please Pay");
		}else{
			System.out.println("Sorry! the seat is taken");
		}}
		
		
		
		
	public static void printList(List<Theatre.Seat>list){
		for(Theatre.Seat seat:list){
			System.out.print(" "+seat.getSeatNumber()+" Reserve status= "+seat.reserved +" Price = "+seat.getPrice()+"::");}
			System.out.println();
			System.out.println("===================");
			}
		public static void sortList(List<? extends Theatre.Seat> list){
			for(int i=0;i<list.size()-1;i++){
				for(int j=i+1;j<list.size();j++){
					if(list.get(i).compareTo(list.get(j))>0){
						Collections.swap(list, i, j);
						
					}
				}
			}
		}
	}
	


