

create table if not exists Theatre (
	id 				int 	AUTO_INCREMENT 	PRIMARY KEY,
	address			varchar(50)
);

create table if not exists Ticket(
	ID 				int 	AUTO_INCREMENT 	PRIMARY KEY,
    name 			char(20)	NULL,
	  surname			char(20),
    place 			char(5),
    price 			int 	not null,
    theatre_id		int 	not null
);

ALTER TABLE Ticket ADD CONSTRAINT FK_Theatre_Ticket FOREIGN KEY (theatre_id) REFERENCES Theatre(id);

#insert into theatre values (1, 'Lviv'), (2, 'Vin'),(3, 'odesa'),(4, 'Kyiv'),(5, 'Chernivci'),(6, 'Lug');
insert into ticket values (1, "Artem", "Kostrych", 12, 200, 1), (2, "Bogdan", "Ivaniv", 13, 202, 1);