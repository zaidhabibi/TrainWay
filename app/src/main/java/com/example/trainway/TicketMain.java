package com.example.trainway;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class TicketMain {

    public static class Ticket{                    // Ticket Object
        private String url = "https://trainway-9a85a-default-rtdb.firebaseio.com";  // URL for firebase database
        private DatabaseReference mDatabase;
        private String ID;                  // Ticket ID
        private String ticket_price;    // Ticket Price
        private String route;           // Ticket Route
        private String day;             // Day for Ticket
        private String time;            // Time for Train Departure
        public int count;              // Contains tickets available

        public Ticket(){};
        // Constructor for Ticket
        public Ticket(String tID,String price, String routeName, String date, String timer, int counter){
            this.ID = tID;
            this.ticket_price = price;
            this.route = routeName;
            this.day = date;
            this.time = timer;
            this.count = counter;
        }

        public void newTicket(String ticketID,String price, String routeName, String date, String timer, int counter)
        {
            mDatabase = FirebaseDatabase.getInstance(url).getReference();
            Ticket ticket = new Ticket(ticketID,price,routeName,date,timer,counter);
            mDatabase.child("tickets").child(ticketID).setValue(ticket);
        }

        public void refundCount(){count++;}                     // refund method
        public void buyCount(){count--;}                        // buy method


        // Getters for Ticket
        public String getPrice(){ return ticket_price;}
        public String getRoute(){ return route;}
        public String getDay(){ return day;}
        public String getTime(){ return time;}
        public int getCount(){return count;}

        // Mutators for Ticket
        public void editPrice(double price) {  this.ticket_price = String.valueOf(price);}
        public void editRoute(String Route) {  this.route = Route;}
        public void editDay(String newDay) {  this.day = newDay;}
        public void editTime(String newTime) {  this.time = newTime;}
        public void editCount(int newCount){this.count = newCount;}

        DatabaseReference ref;

        public void addTicket(String ID, User user) {
            user.tickets[user.index] = ID;
            user.index++;
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Ticket ticket = dataSnapshot.getValue(Ticket.class);
                    System.out.println(dataSnapshot.getKey() + " was " + ticket.count + " meters tall.");

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // ...
                }
            });


    }


}
    /*Spinner spinnerDestination = findViewByID(R.id.spinner);
    ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.spinner_String_Destination, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
    */
}