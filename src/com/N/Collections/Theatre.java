package com.N.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Theatre {
private final String theatreName;
public List<Seat> seats=new ArrayList<>();//list is child of collection
//private Collection<Seat> seats=new ArrayList<>();
//private Collection<Seat> seats=new HashSet<>();
static final Comparator<Seat> PRICE_ORDER= new Comparator<Seat>(){//comparator is variable declared

	@Override
	public int compare(Seat seat1, Seat seat2){
		if(seat1.getPrice() < seat2.getPrice()){
			return-1;
		}else if (seat1.getPrice()> seat2.getPrice())	{
			return 1;
	}else {
		return 0;
}}

	
};;



public Theatre(String theatreName,int numRow, int seatsPerRow){
this.theatreName=theatreName;
int lastRow='A'+(numRow-1);
//lastRow will be A7 and numRow is 8 A to F 
//ascii value of 'A'is 65 so instead of 'A' if give 65 and lastRow 'F'=70 it ill also work fine,
//since we give the type int it will convert 'A' to ascii value itselfe;
System.out.println("value of lastRow is "+lastRow);
for (char row='A';row<=lastRow;row++){
	for(int seatNum=1;seatNum<=seatsPerRow;seatNum++){
		double price=12.00;
		if((row<'c')&& (seatNum >=4 && seatNum <=9)){
			price= 14.00;
		}else if((row>'D')|| (seatNum<4|| seatNum >9)){
			price=7.00;
		}
		Seat seat= new Seat(row+String.format("%02d", seatNum),price);
		seats.add(seat);
		
	}
}}

public boolean reserveSeat(String seatNumber){
	Seat requestedSeat=new Seat(seatNumber,0);
	int foundSeat=Collections.binarySearch(seats,requestedSeat,null);
	//list already sorted 
	//binarysearch compare all the seats (seats) with requestedSeat and give u back 
	//index of foundSeatNumber based on if its greater or equel zero u have 
	//found a seat and  u can reserve it
	if(foundSeat>=0){
		return seats.get(foundSeat).resrve();
	}else{
		System.out.println("There is no seat "+seatNumber);
		return false;
	}
	/*Seat requestedSeat=null;
	for(Seat seat:seats){//loop once found the seat
		if(seat.gatSeatNumber().equals(seatNumber)){
			requestedSeat=seat;//set the seat to requestedseat
			break;
		}
	}
	if(requestedSeat==null){//if looping dont go inside the if condition that
		//there is no seat available of the requestedseat number.
		System.out.println("There is no seat "+seatNumber);
		return false;
	}
	return requestedSeat.resrve();//from method reserve*/
}

public String getTheatreName() {
	return theatreName;
}
public Collection<Seat> getSeats(){
	return seats;
	//for(Seat seat:seats){
		//System.out.println(seat.getSeatNumber());
	}

public class Seat implements Comparable<Seat>, Cloneable{
	private final String seatNumber;
	public boolean reserved=false;//false means by default seats are not reserved
	//to print directly u can make boolean reserved public originally private
	private double price;
	private String color="Red";
	
	public Seat(String seatNumber, double price){
		this.seatNumber=seatNumber;
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean resrve(){
		if(!this.reserved){//!this.reserved (if it is not reserved =reserved = false not reserved
			this.reserved=true;//then it will reserve
			System.out.println("Seat "+seatNumber+" reserved");
			return true;
		}else{//if already reserved return false
			return false;
		}}
	public boolean cancel(){
		if(this.reserved){
			this.reserved=false;//undo reservation
			System.out.println("Reservation of seat "+seatNumber+" is canceled" );
			return true;
		}else{
			return false;
		}}
	public String getSeatNumber(){
		return seatNumber;
		}
	    //Deep copy of the seats using clone advantage of clone 
	//is in future if add more primitive data type super.clone will copy all data type
	@Override
	public Object clone(){
		try{
			return super.clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}}
	
	@Override
	public int compareTo(Seat seat) {//compare seats say wether its small or big
		//returns -1,0,1
		
		return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		//comparison of 2 seat numbers local seat number which is this.seatNumber 
		//with the input seat number
		/*if the seat number in int
		 * if(seatNumber>seat.seatNumber)
		 * return 1;
		 * }else if(seatNumber<seat.seatNumber)
		 * return -1;
		 * }else 
		 * return 0;
		 */
	}
	}
	

		}
		
	


