/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Thijs Vercammen
 * Created: 3-nov-2020
 */

drop table Gebruiker purge;
drop table Contacten purge;
drop table Test purge;

create table Gebruiker (
    gebruikernr int,
    naam varchar(255),
    wachtwoord varchar(255),
    risicostatus varchar(255),
    PRIMARY KEY(knr)
);

create table Contacten (
    contactnr int,
    gebruikernr int,
    contact int,
    soort_contact varchar(255),
    PRIMARY KEY(contactnr),
    FOREIGN KEY(gebruikernr) REFERENCES Gebruiker(gebruikernr),
    FOREIGN KEY(contact) REFERENCES Gebruiker(gebruikernr),
);

create table Test (
    testnr int,
    gebruiker int,
    status varchar(255),
    PRIMARY KEY(testnr),
    FOREIGN KEY(gebruiker) REFERENCES Gebruiker(gebruikernr)
);
