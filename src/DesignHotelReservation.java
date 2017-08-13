Design Hotel Reservation

Design a hotel reservation system. To make it simple, we assume that the hotel has only one building and the building has only one floor. Design your objects so that they work better with a non-sql database, say a document-oriented database.

The reservation system needs at least two another class. The first one is the Room class, which is identified by the room number and have several methods such as book() or unbook().

The second one is the Customer class. This class contains the information of a customer who has made a reservation.

I also use two maps to store all rooms and customers. The reason to use map is that it is easy for retrieval: I can use the name and room number to find the customer and room I want.

Two public methods: makeReservation and cancelReservation.

makeReservation() will create a Customer object, find the next available room, and assign that to the customer, so when the customer checks in, he/she can easily find the room. If there is no available room, then no reservation can be made.

cancelReservation() will remove the Customer object c out of the customers map and make the room available.

There are couple private helper methods that I don't want to go detail.


?
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
public class ReservationSystem{
 final Map<integer room=""> rooms;
 Map<string customer=""> customers;
  
 public ReservationSystem(List<room> builtRoom){
  rooms = new HashMap<integer room=""> ();
  //when the hotel is built, all the rooms are added into the system
  rooms.add(builtRoom);
  customers = new HashMap<string customer=""> ();
 }
  
 public boolean makeReservation(String name, String id, String information){
  int room = findNextAvailableRoom();
  if(room == -1){
   System.out.println("No available room!");
   return false;
  }
  Customer c = new Customer(name, id, information, room);
  rooms.get(room).book();
  customers.put(name, c);
  return true;
 }
  
 public boolean cancelReservation(String name){
  Customer c = findCustomer(name);
  if(c == null){
   System.out.println("No reservation found!");
   return false;
  }
  customers.remove(name);
  makeAvailable(c.roomBooked);
  return true;
 }
  
 private Customer findCustomer(String name){
  if(!customers.containsKey(name))
   return null;
  return customers.get(name);
 }
  
 private void makeAvailable(int roomNumber){
  rooms.get(roomNumber).unbook();
 }
 private int findNextAvailableRoom(){
  for(Room r : rooms.values()){
   if(!r.isBooked())
    return r.roomNumber;
  }
  return -1;
 }
  
  
 class Room{
  final int roomNumber;
  private boolean available;
   
  public Room(int rN){
   roomNumber = rN;
   available = true;
  }
   
  public void book(){
   available = false;
  }
  void unbook(){
   available = true;
  }
  public boolean isBooked(){
   return !available;
  }
 }
  
 class Customer{
  String name;
  String id;
  String information;
  int roomBooked;
   
  public Customer(String name, String id, String information, int roomNumber){
   this.name = name;
   this.id = id;
   this.information = information;
   roomBooked = roomNumber;
  }
 }
