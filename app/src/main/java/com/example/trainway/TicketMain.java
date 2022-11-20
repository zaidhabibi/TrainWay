package com.example.trainway;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TicketMain {

    public static class Ticket{                    // Ticket Object
        private String url = "https://trainway-9a85a-default-rtdb.firebaseio.com";  // URL for firebase database
        private DatabaseReference mDatabase;
        private int ID;                  // Ticket ID
        private double ticket_price;    // Ticket Price
        private String route;           // Ticket Route
        private String day;             // Day for Ticket
        private String time;            // Time for Train Departure
        private int count;              // Contains tickets available

        public Ticket(){};
        // Constructor for Ticket
        public Ticket(double price, String routeName, String date, String timer, int counter){
            ticket_price = price;
            route = routeName;
            day = date;
            time = timer;
            count = counter;
        }

        public void newTicket(String ticketID,double price, String routeName, String date, String timer, int counter)
        {
            mDatabase = FirebaseDatabase.getInstance(url).getReference();
            Ticket ticket = new Ticket(price,routeName,date,timer,counter);
            mDatabase.child("tickets").child(ticketID).setValue(ticket);
        }

        public void refundCount(){count++;}                     // refund method
        public void buyCount(){count--;}                        // buy method


        // Accessors for Ticket
        public double getPrice(){ return ticket_price;}
        public String getRoute(){ return route;}
        public String getDay(){ return day;}
        public String getTime(){ return time;}
        public int getCount(){return count;}

        // Mutators for Ticket
        public void editPrice(double price) {  ticket_price = price;}
        public void editRoute(String Route) {  route = Route;}
        public void editDay(String newDay) {  day = newDay;}
        public void editTime(String newTime) {  time = newTime;}
        public void editCount(int newCount){count = newCount;}





    }


}