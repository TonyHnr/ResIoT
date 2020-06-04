# Projet ResIoT Tony HENRY et Pol-Ewen Mouraud#
## Création d'un chennillard avec une maquette KNX#

###Construction de nos classes#

<p> 
 Nous avons créés 3 classes :
  <ul>
    <li><strong>Chenillard.java : </strong> Création des 3 chenillards présentés dans un thread qui permet de gérer le temps et l'attente entre 2 actions. 
    Un compteur permet de savoir quel chenillard activer</li>
    <li><strong>Connection.java  : </strong> Initialise un thread (chenillard). Permet de savoir sur quels boutons on clique grâce à leur adresse. Ainsi en connaissant le bouton, nous pouvons activer, stopper, changer, modifier l'allure du chenillard. La vitesse et le compteur sont initialisés ici. </li>
    <li><strong>test.java  : </strong> Permet d'initialiser la connection du lien KNX. C'est lui qu'il faut "Run"</li>
</ul>
        

###Fonctionnalités des interrupteurs#

<p> N'ayant pas pu faire le serveur Rest à cause de notre erreur, nous allons donc vous décrire les fonctionnalités des 4 interrupteurs sur l'interface que vous nous avez donné.
  
  
  <ul>
    <li><strong>Interrupreur 1  : </strong> Initialisation du chenillard standard (lampe 1 - 2 - 3 - 4) avec une seconde entre chaque lampe </li>
    <li><strong>Interrupreur 2  : </strong> Permet d'augmenter la vitesse du chenillard en action, c'est à dire diminuer le temps entre 2 lampes. A chaque clique le temps diminue de 100ms.</li>
    <li><strong>Interrupreur 3  : </strong> Permet de changer le motif du chenillard à chaque clique. Nous avons 3 motifs : le standard, l'alterné (lampe 1 - 3 - 2 - 4) et l'inverse (lampe 4 - 3 - 2 - 1).</li>
    <li><strong>Interrupreur 4  : </strong> Permet d'arrêter le chenillard en action et ferme le lien KNX.</li>
</ul>
                        
                        
                       
                      
                      
 Si nous cliquons sur le bouton 1 alors que le chenillard à une vitesse rapide et une motif alterné par exemple, le chenillard se stoppe et démarre un chenillard standard de 1s.
</p>
