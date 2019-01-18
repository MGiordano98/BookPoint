use bookpoint;

Insert into utente(email, nome, cognome, dataDiNascita, psw,tipo)
values('g.teodoro@studenti.unisa.it','Gennaro','Teodoro','1997-11-14','Gennaro','Cliente');

Insert into utente(email, nome, cognome, dataDiNascita, psw,tipo)
values('v.sammartino@studenti.unisa.it','Vittorio','Sammartino','1997-06-24','Gennaro','Cliente');

Insert into utente(email, nome, cognome, dataDiNascita, psw,tipo)
values('m.giordano162@studenti.unisa.it','Massimo','Giordano','1998-01-05','Massimo','Amministratore');

Insert into utente(email, nome, cognome, dataDiNascita, psw,tipo)
values('g.buonocore15@studenti.unisa.it','Giovanni','Buonocore','1997-06-07','Giovanni','AmministratoreOrdine');

insert into indirizzo(via,numeroCivico,cap,città,utente)
values('Enrico Fermi',9,'80040','Terzigno','g.teodoro@studenti.unisa.it');

insert into indirizzo(via,numeroCivico,cap,città,utente)
values('Enrico Fermi',7,'80040','Terzigno','g.teodoro@studenti.unisa.it');

insert into indirizzo(via,numeroCivico,cap,città,utente)
values('Striscia',14,'83050','Avellino','v.sammartino@studenti.unisa.it');

insert into cartaDiCredito(numeroDiCarta,intestatario,dataScadenza,cvv,utente)
values('0000000000000000','Gennaro Teodoro','2020-01-01','000','g.teodoro@studenti.unisa.it');

insert into cartaDiCredito(numeroDiCarta,intestatario,dataScadenza,cvv,utente)
values('0000000000000001','Vittorio Sammartino','2020-01-01','001','v.sammartino@studenti.unisa.it');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788804679622','Dieci piccoli indiani','Dieci persone estranee l''una all''altra sono state invitate a soggiornare in una splendida villa a Nigger Island, senza sapere il nome del generoso ospite. Eppure, chi per curiosità, chi per bisogno, chi per opportunità, hanno accettato l''invito. E ora sono lì, su quell''isola che sorge dal mare, simile a una gigantesca testa, che fa rabbrividire soltanto a vederla. Non hanno trovato il padrone di casa ad aspettarli. Ma hanno trovato una poesia incorniciata e appesa sopra il caminetto di ciascuna camera. E una voce inumana e penetrante che li accusa di essere tutti assassini. Per gli ospiti intrappolati è l''inizio di un interminabile incubo. Con "Dieci piccoli indiani", scritto nel 1939, Agatha Christie ha sfidato se stessa: dieci assassini, isolati, vittime a loro volta di un assassino invisibile.','','Mondadori',8.40,50,'Giallo','2017-02-27');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788804598893','Il barone rampante','La storia del Barone Cosimo Piovasco di Rondò, indomabile ribelle che a dodici anni sale su un albero per non ridiscenderne mai più, è considerata uno dei capolavori di Calvino. Questa splendida versione, dedicata ai ragazzi, fu realizzata dall''autore nel 1959 mantenendo intatte la qualità della scrittura e la suggestione del racconto. Una storia piena di avventure, leggerezza e libertà.','','Mondadori',11.0,50,'Romanzo','2010-03-10');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788807901638','Il giocatore','Un giovane precettore viene posseduto dal demone del gioco d''azzardo. Il racconto diventa così la narrazione di un''ossessione descritta con lucida genialità dal giocatore stesso. L''incalzante ritmo narrativo segue passo passo l''incrinarsi del destino. Poi uno stacco temporale e il lettore è proiettato d''improvviso in un''intricata matassa di rapporti di cui il protagonista cerca disperatamente il bandolo. La tecnica narrativa procede per interrogativi, supposizioni, indizi, suscitando un''atmosfera di autentica suspense che si risolve solo alla fine, quando il racconto perde il ritmo convulso e premette al lettore di sciogliere dubbi ed enigmi.','','Feltrinelli',8.0,50,'Narrativo','2014-10-10');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788804687290','Io, te e il mare','«Ti sei mai sentito solo al mondo? Ti sei mai sentito senza un senso, diviso a metà, come se ti mancasse qualcosa? Ecco, quando ti ho visto per la prima volta è stato come ritrovare la parte di me che avevo perso, forse, quando ho messo piede in questo mondo». Eccola, l''essenza del primo, vero amore, che travolge i protagonisti di questa storia: la sensazione meravigliosa che, tutto a un tratto, il caos che hanno dentro trovi finalmente un punto intorno al quale sciogliersi, permettendogli di accarezzare quella felicità di cui fino a un momento prima avevano solo fantasticato. Perché quando si è ragazzi e ci si ama, si può davvero tutto, persino regalarsi il mare. Che poi, a pensarci bene, ogni cosa bella comincia sempre da lì, dal mare, metafora perfetta di quell''esplosione di emozioni che senti dentro quando ti innamori. Il mare, che quando ci entri lo fai velocemente, senza pensare alle conseguenze: ti tuffi e basta. Il mare che, da solo, è in grado di curarti il cuore e che, persino quando ti tramortisce con le sue onde, è talmente bello che proprio non riesci a concepire che potrebbe anche farti del male. Eppure potrebbe, potrebbe eccome. E infatti, la lei e il lui di questo romanzo in cui i sentimenti si muovono liberamente attraverso le poesie e la prosa, ben presto saranno costretti ad affrontare le loro personali tempeste: un misto di insicurezze, fragilità, paura di non essere "abbastanza" con il rischio, inevitabile, di andare alla deriva, l''uno lontano dall''altra. Pure loro mare, un mare mai calmo, che distrugge tutto ma che vale sempre la pena guardare, respirare, vivere, anche se fa male, fin che ce n''è.','','Mondadori',16.0,50,'Romanzo','2018-04-24');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788817105156','Sono io Amleto','Dentro "Sono io Amleto" c''è tutto l''immaginario di Achille Lauro: un mondo lirico e non convenzionale, le lucide visioni di un''anima forgiata dalla solitudine, dalla strada, dalle droghe. Come tutta la sua produzione, anche questo libro è una prova di creatività che non si lascia intrappolare in nessun modello, e non segue nessuna regola. Con il suo modo unico di usare la parola e lungo inconsueti percorsi narrativi, Lauro ci guida in un viaggio psichedelico, visionario, malinconico e poetico. Ad accompagnarlo, ventitré opere di artisti contemporanei. In un attimo siamo quel bambino silenzioso che sogna di uccidere la Bestia per scappare dal Labirinto, siamo quel ragazzino che si affaccia timido al mondo dei grandi e che fin da subito decide di rompere le regole e infrangere le convenzioni sociali. Ma siamo anche quel giovane uomo che ce l''ha fatta, che ha costruito un impero dalla polvere, che ha sfidato la morte, ha attraversato l''inferno e ha trovato la sua strada nella musica.','','Mondadori',16.90,50,'Musica','2019-01-15');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788866320326','L''amica geniale','L''amica geniale di Elena Ferrante comincia seguendo le due protagoniste bambine, e poi adolescenti, tra le quinte di un rione miserabile della periferia napoletana, tra una folla di personaggi minori accompagnati lungo il loro percorso con attenta assiduità. L''autrice scava intanto nella natura complessa dell''amicizia tra due bambine, tra due ragazzine, tra due donne, seguendo passo passo la loro crescita individuale, il modo di influenzarsi reciprocamente, i buoni e i cattivi sentimenti che nutrono nei decenni un rapporto vero, robusto. Narra poi gli effetti dei cambiamenti che investono il rione, Napoli, l''Italia, in più di un cinquantennio, trasformando le amiche e il loro legame. E tutto ciò precipita nella pagina con l''andamento delle grandi narrazioni popolari, dense e insieme veloci, profonde e lievi, rovesciando di continuo situazioni, svelando fondi segreti dei personaggi, sommando evento a evento senza tregua, ma con la profondità e la potenza di voce a cui l''autrice ci ha abituati...','','Mondadori',18.0,50,'Romanzo','2011-10-19');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788868363574','After','Ambiziosa, riservata e con un ragazzo perfetto che l''aspetta a casa, Tessa ama pensare di avere il controllo della sua vita. Al primo anno di college, il suo futuro sembra già segnato: una laurea, un buon lavoro, un matrimonio felice... Sembra, perché Tessa fa a malapena in tempo a mettere piede nel campus che subito s''imbatte in Hardin. E da allora niente è più come prima. Lui è il classico cattivo ragazzo, tutto fascino e sregolatezza, arrabbiato con il mondo, arrogante e ribelle, pieno di piercing e tatuaggi. E la persona più detestabile che Tessa abbia mai conosciuto. Eppure, il giorno in cui si ritrova sola con lui nella sua stanza, non può fare a meno di baciarlo. Un bacio che cambierà tutto. E accenderà in lei una passione incontrollabile. Una passione che, contro ogni previsione, sembra reciproca. Nonostante Hardin, per ogni passo che fa verso di lei, con un altro poi retroceda. Per entrambi sarebbe più facile arrendersi e voltare pagina, ma se stare insieme è difficile, a tratti impossibile, lo è ancora di più stare lontani. Quello che c''è tra Tessa e Hardin è solo una storia sbagliata o l''inizio di un amore infinito? Che sia davvero questo l''amore?','','Mondadori',9.90,50,'Rosa','2017-01-17');

insert into libro(isbn,titolo,trama,foto,casaEditrice,prezzo,quantitàDisponibile,categoria,dataUscita)
values('9788804665793','L''arte di essere fragili. Come Leopardi può salvarti la vita','L’arte di essere fragili è il quarto libro di Alessandro D’Avenia, già autore di romanzi di grande successo a cominciare da Bianca come il latte rossa come il sangue (l’esordio del 2010, oltre un milione di copie vendute e tante traduzioni all’estero), Cose che nessuno sa (2011) e Ciò che inferno non è (2014, apertamente ispirato alla figura di un insegnante di cui D’Avenia era stato allievo ai tempi del liceo a Palermo, ossia don Pino Puglisi, il sacerdote ucciso dalla mafia nel ’93).','','Mondadori',19.00,50,'Romanzi','2016-10-31');


insert into ordine(dataOrdine,totale,stato,dataConsegna,oraConsegna,utente,via,numeroCivico,cap,città, numeroCarta)
values('2019-01-07',8.40,'consegnato','2019-01-15','12:00:00','g.teodoro@studenti.unisa.it','Enrico Fermi',9,80040,'Terzigno','1');

insert into ordine(dataOrdine,totale,stato,dataConsegna,oraConsegna,utente,via,numeroCivico,cap,città, numeroCarta)
values('2019-01-08',11.00,'consegnato','2019-01-16','12:00:00','v.sammartino@studenti.unisa.it','Striscia',14,8305,'Avellino','2');

insert into libriAcquistati(prezzoAcquisto,quantità,titolo,ordine,libro)
values(8.40,1,'Dieci piccoli indiani','1','9788804679622');

insert into libriAcquistati(prezzoAcquisto,quantità,titolo,ordine,libro)
values(11.00,1,'Il barone rampante','2','9788804598893');

insert into preferisce(utente,libro)
values('g.teodoro@studenti.unisa.it','9788804679622');

insert into preferisce(utente,libro)
values('g.teodoro@studenti.unisa.it','9788804665793');

insert into preferisce(utente,libro)
values('v.sammartino@studenti.unisa.it','9788868363574');

insert into recensione(testo,libro,utente)
values('Bello','9788804679622','g.teodoro@studenti.unisa.it');

insert into recensione(testo,libro,utente)
values('brutto','9788868363574','v.sammartino@studenti.unisa.it');

insert into autore(nome)
values('Agatha Christie');

insert into autore(nome)
values('Italo calvino');

insert into autore(nome)
values('Fëdor Dostoevskij');

insert into autore(nome)
values('Marzia Sicignano');

insert into autore(nome)
values('Achille Lauro');

insert into autore(nome)
values('Elena Ferrante');

insert into autore(nome)
values('Anna Todd');

insert into autore(nome)
values('Alessandro D''Avenia');

insert into scrive(autore,libro)
values('Agatha Christie','9788804679622');

insert into scrive(autore,libro)
values('Italo calvino','9788804598893');

insert into scrive(autore,libro)
values('Fëdor Dostoevskij','9788807901638');

insert into scrive(autore,libro)
values('Marzia Sicignano','9788804687290');

insert into scrive(autore,libro)
values('Achille Lauro','9788817105156');

insert into scrive(autore,libro)
values('Elena Ferrante','9788866320326');

insert into scrive(autore,libro)
values('Anna Todd','9788868363574');

insert into scrive(autore,libro)
values('Alessandro D''Avenia','9788804665793');
