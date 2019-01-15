use bookpoint;

create table utente
(
	email varchar(60) primary key,
	nome varchar(30),
    cognome varchar(30),
    dataDiNascita date,
    psw varchar(30),
    tipo varchar(20)
);

create table libro
(
	isbn integer(13) primary key,
    titolo varchar(50),
    trama varchar(300),
    foto varchar(60),
    casaEditrice varchar(30),
    prezzo float(10),
    quantitàDisponibile integer(4),
    categoria varchar(30)
);

create table autore
(
	id integer(10) primary key,
    nome varchar(30),
    cognome varchar(30)
);

create table indirizzo
(
	id integer(10) primary key,
    via varchar(30),
    numeroCivico integer(4),
    cap integer(5),
    città varchar(30),
    utente varchar(60),
    foreign key (utente) references utente(email)
    on delete set null on update cascade
);

create table cartaDiCredito
(
	numeroDiCarta integer(16),
    intestatario varchar(30),
    dataScadenza date,
    cvv integer(3),
    utente varchar(60), 
    foreign key (utente) references utente(email)
    on delete set null on update cascade
);

create table ordine
(
	numero integer(20) primary key,
    dataOrdine date,
    totale float(10),
    stato varchar(15),
    dataConsegna date,
    oraConsegna time(6),
    utente varchar(60),
    foreign key (utente) references utente(email)
    on delete set null on update cascade,
    via varchar(30),
    numeroCivico integer(4),
    cap integer(5),
    città varchar(30),
    cartaDiCredito integer(16)
);

create table libriAcquistati
(
	prezzoAcquisto integer(10),
    quantità integer(10),
    titolo varchar(50),
    ordine integer(20),
    foreign key (ordine) references ordine(numero)
    on delete set null on update cascade,
    libro integer(13),
    foreign key (libro) references libro(isbn)
    on delete set null on update cascade
);
create table preferisce
(
	utente varchar(60),
    foreign key (utente) references utente(email)
    on delete set null on update cascade,
    libro integer(13),
    foreign key (libro) references libro(isbn)
    on delete set null on update cascade
);

create table recensione
(
	id integer(10) primary key,
    testo varchar(300),
    utente varchar(60),
    foreign key (utente) references utente(email)
    on delete set null on update cascade,
    libro integer(13),
    foreign key (libro) references libro(isbn)
    on delete set null on update cascade
);

create table scrive
(
	autore integer(10),
    foreign key (autore) references autore(id)
    on delete set null on update cascade,
	libro integer(13),
    foreign key (libro) references libro(isbn)
    on delete set null on update cascade
);