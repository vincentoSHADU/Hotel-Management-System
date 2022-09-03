package com.example.demo8;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

    //CREATING VARIABLES
    public class EmployeeViewController {

        private final StringProperty firstname;
        private final StringProperty lastname;
        private final StringProperty econtact;
        private final StringProperty password;
        private final StringProperty dateofbirth;
        private final StringProperty empidnumber;


        public  EmployeeViewController()  {

            firstname = new SimpleStringProperty(this, "firstname");

            lastname = new SimpleStringProperty(this, "lastname");

            econtact = new SimpleStringProperty(this, "econtact");

            empidnumber  = new SimpleStringProperty(this, "empidnumber");

            password = new SimpleStringProperty(this, "password");

            dateofbirth = new SimpleStringProperty(this, "dateofbirth");
        }


        //CREATING GETTERS AND SETTERS
        public  StringProperty empidnumberProperty(){return empidnumber;}
        public String getempidnumber() { return empidnumber.get(); }
        public void setempidnumber(String newempidnumber) {empidnumber.set(newempidnumber);}

        public  StringProperty firstnameProperty(){return firstname;}
        public String getfirstname() { return firstname.get(); }
        public void setfirstname(String newfirstname) {firstname.set(newfirstname);}

        public  StringProperty lastnameProperty(){return lastname;}
        public String getlastname() { return lastname.get(); }
        public void setlastname(String newlastname) {lastname.set(newlastname);}

        public  StringProperty passwordProperty(){return password;}
        public String getpassword() { return password.get(); }
        public void setpassword(String newpassword) {password.set(newpassword);}

        public  StringProperty econtactProperty(){return econtact;}
        public String getecontact() { return econtact.get(); }
        public void setecontact(String newecontact) {econtact.set(newecontact);}

        public  StringProperty dateofbirthProperty(){return dateofbirth;}
        public String getdateofbirth() { return dateofbirth.get(); }
        public void setdateofbirth(String newdateofbirth) {dateofbirth.set(newdateofbirth);}

        @Override
        public String toString() {
            return String.format(getdateofbirth(), getempidnumber(), getecontact(), getfirstname(), getlastname(), getpassword());
        }


        // public  String getLastName() {return  LastName;}
        //  void setLastName(String LastName){this.LastName = LastName;}
        //
        // public  String getContact() {return Contact;}
        // public void setContact(String Contact){this.Contact = Contact;}
        //
        // public  String getBooking() {return Booking;}
        // public void setBooking(String Booking){this.Booking = Booking;}
    }
