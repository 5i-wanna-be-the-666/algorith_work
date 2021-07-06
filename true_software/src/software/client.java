package software;

import java.io.Serializable;

import true_book.BookingInformation;
import card.CreditCard;

import person.Person;
import room.RoomInformation;

import user_role.UserRole;

public class client implements Serializable {
	Person me;
	UserRole I;
	RoomInformation home;
	BookingInformation book;
	CreditCard card;
	public client(Person me,UserRole I,RoomInformation home,BookingInformation book,CreditCard card)
	{
		this.me=me;
		this.I=I;
		this.home=home;
		this.book=book;
		this.card=card;
	}
	public client() {
		// TODO Auto-generated constructor stub
	}
	public void set_house(RoomInformation home)
	{
		this.home=home;
	}
	public void set_role(UserRole I)
	{
		this.I=I;
	}
	public void set_person(Person me)
	{
		this.me=me;
	}
	
	public void set_booking(BookingInformation book)
	{
		this.book=book;
	}
	public void set_card(CreditCard card)
	{
		this.card=card;
	}
	
	
	public RoomInformation get_house()
	{
		return this.home;
	}
	public UserRole get_role()
	{
		return this.I;
	}
	public Person get_person()
	{ 
		return this.me;
	}
	
	public BookingInformation get_booking()
	{
		return this.book;
	}
	public CreditCard get_card()
	{
		return this.card;
	}

}
