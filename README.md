# AP_23_2E4_Mihai_Breaban

# Homework_Lab_1

  In functia main am verificat la primul pas daca exista argumente sau nu, apoi folosind comanda try/catch am ferificat daca acel argument este int sau nu. In cazul pozitiv executa comenzile din try: atribuirea lui n, atribuirea latinMatrix folosind functia getLatinSquare si afisarea concatenarii fiecarei linii si coloane daca n <=  30000, altfel afiseaza timpul de compilare in milisecunde. In cazul negativ se va fisa o eroare.
  
  Functia getLatinSquare genereaza o matrice care respecta termenii din cerinta folosind o lista cu liste. Am creat o coada careia i-am dat valori de la 1 la n. La pasul urmator o adaug in matice, urmand ca intr-un auxiliar sa retin prima valoare din coada (folosind comanda poll(atribuie valoarea si apoi o scoate din lista)) si o pun la caparul cozii folosind comanda add.
  
  Functia printLatinSquare afiseaza concatenarile fiecarei linii si coloane.


# Homework_Lab_5

  Am creat interfata Command.java cu ajutorul careiva voi voi apela comenzile.
  
  In clasa ListCommand am facut un streams (forEach) cu ajutorul caruia voi afisa documentul. 
  
  In clasa ViewCommand fac o verificare daca Desktop-ul e compatibil, urmata de comparatie daca exista fisierul, iar daca trece de ambele comparatii deschide "catalogul", altfel returneaza o exceptie.
  
  In clasa ReportCommand creez documentul HTML folosindu-ma de template-ul creat in HTMLdocument.vm
