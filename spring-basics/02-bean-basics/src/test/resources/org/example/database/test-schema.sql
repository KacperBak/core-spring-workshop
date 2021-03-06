drop table Booking;
drop table Person;
drop table Room;
create table Person(ID INT PRIMARY KEY NOT NULL , NAME VARCHAR (40), AGE INT );
create table Room(ID INT PRIMARY KEY NOT NULL , ROOMNUMBER VARCHAR (40));
create table Booking(
   ID INT PRIMARY KEY NOT NULL ,
   PERSON_ID INT NOT NULL ,
   ROOM_ID INT NOT NULL ,
   BOOKING_DATE VARCHAR (40),
   CONSTRAINT person_fk FOREIGN KEY (PERSON_ID) REFERENCES person (ID),
   CONSTRAINT room_fk FOREIGN KEY (ROOM_ID) REFERENCES room (ID)
 );