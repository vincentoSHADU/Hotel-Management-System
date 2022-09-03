package com.example.demo8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


//CREATING VARIABLES
public class CustomerViewController {

    private final StringProperty id;
    private final StringProperty fname;
    private final StringProperty lname;
    private final StringProperty contact;
    private final StringProperty booking;


    //CREATING CONSTRUCTS
        public  CustomerViewController(){

            id  = new SimpleStringProperty(this, "id");

            fname = new SimpleStringProperty(this, "fname");

            lname  = new SimpleStringProperty(this, "lname");

            booking = new SimpleStringProperty(this, "booking");

            contact = new SimpleStringProperty(this, "contact");
        }


    //CREATING GETTERS AND SETTERS

        public  StringProperty idProperty(){return id;}
        public String getid() { return id.get(); }
        public void setid(String newid) {id.set(newid);}

        public  StringProperty fnameProperty(){return fname;}
        public String getfname() { return fname.get(); }
        public void setfname(String newfname) {fname.set(newfname);}

        public  StringProperty lnameProperty(){return lname;}
        public  String getlname(){return  lname.get();}
        public  void  setlname(String newlname) {lname.set(newlname);}

        public StringProperty bookingProperty(){return booking;}
        public String getbooking() {return  booking.get();}
        public  void  setbooking(String newbooking) {booking.set(newbooking);}

        public StringProperty contactProperty(){return contact;}
        public String getcontact() {return  contact.get();}
        public  void  setcontact(String newcontact) {contact.set(newcontact);}



        @Override
        public String toString(){
            return String.format ( getid(), getbooking(), getfname(), getlname());
        }



/*
        public  String getLastName() {return  LastName;}
         void setLastName(String LastName){this.LastName = LastName;}

        public  String getContact() {return Contact;}
        public void setContact(String Contact){this.Contact = Contact;}

        public  String getBooking() {return Booking;}
        public void setBooking(String Booking){this.Booking = Booking;}
    */

}
