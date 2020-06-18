

>Progetto per l'esame Sistemi Informativi su Web (Professore: Paolo Merialdo) 

>Realizzatori: 
>- Ravago    Ryan James N.
>- Serafini  Federico 

**GestioneProgetti**  è un sistema software di tipo **client-server** , usato dagli utenti e dagli amministratori per la gestione dei progetti e task. 

Il sistema consente di gestire:
* I propri utenti, registrandosi e poi autenticandosi nel sistema.
* I propri progetti, creandone di nuovi, aggiornali, visualizzarli e cancellarli dalla lista dei progetti.
* La visualizzazione del profilo degli utenti registrati con la possibilità di aggiornarli.

L’uso del sistema in discussione è descritto principalmente dai seguenti casi d’uso:

**Caso d’uso UC1** : Un nuovo Utente usa il Sistema per registrarsi nel Sistema.

**Caso d’uso UC2** : Inserimento nuovo progetto – Attore primario: un Utente registrato.
1. Un Utente registrato vuole inserire un nuovo progetto.
2. L'Utente inserisce la sua username e la sua password. Il Sistema verifica la correttezza dei dati immessi, e autentica l'Utente.
3. L'Utente sceglie l’attività “create new Project”. 
4. L'Utente inserisce il nome del progetto e una descrizione del progetto.
5. Da questo momento, gli utenti del Sistema potranno vedere i propri progetti (Caso D'Uso UC3).

Estensioni:

2a Credenziali dell'Utente non convalidate. Il Sistema termina l’esecuzione del caso d’uso.

3-5a L'Utente annulla l’operazione di inserimento. Il Sistema non registra nessuna informazione sul progetto.

**Caso d’uso UC3** : Visualizzare i progetti creati dall'Utente – Attore primario: un Utente registrato.

L’Utente registrato usa il Sistema per visualizzare i propri progetti tramite il collegamento (My Projects) presente sulla sua Home Page. 
Per ciascun progetto, il Sistema mostra l’elenco dei progetti dell'Utente, con l'identificatore, nome e descrizione del progetto.

**Caso d’uso UC4** : Visualizzare il profilo dell’Utente – Attore primario: un Utente registrato.

L’Utente registrato usa il Sistema per visualizzare il proprio profilo tramite il collegamento (Profile). Il Sistema mostra dati sull'Utente.

**Caso d’uso UC5** : Aggiornare il profilo dell’Utente – Attore primario: un Utente registrato.

L'Utente registrato usa il Sistema per aggiornare il suo profilo tramite il collegamento ‘Aggiorna Profilo’ presente sulla sua Profile Page(ad es., per modificare la sua username, per modificare la password, per modificare la firtName e la lastName). 
Una volta aggiornato il profilo è necessario effettuare il LogOut per far si che le modifiche vengano effettuate. 

**Caso d’uso UC6**: Aggiornare i progetti dell’Utente – Attore primario: un Utente registrato.

L'Utente registrato usa il Sistema per aggiornare i suoi progetti tramite il tasto ‘Edit’ presente sulla sua lista progetti (in My Projects), (ad es., per modificare i nomi, e le descrizioni dei progetti ).

**Caso d’uso UC7** : Cancellazione dei progetti creati dall'Utente – Attore primario: un Utente registrato.

L'Utente registrato usa il Sistema per effettuare la cancellazione dei progetti creati. Il progetto cancellato non sarà più presente dall’elenco dei progetti dell’utente. 

 
