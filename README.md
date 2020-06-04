# Projet ResIoT Tony HENRY et Pol-Ewen Mouraud
## Création d'un chennillard avec une maquette KNX




<p> N'ayant pas pu faire le serveur Rest à cause de notre erreur, nous allons donc vous décrire les fonctionnalités des 4 boutons sur l'interface que vous nous avez donné.
  
                        - Interrupreur 1 : Initialisation du chenillard standard (lampe 1 - 2 - 3 - 4) avec une seconde entre chaque lampe 
                        - Interrupteur 2 : Permet d'augmenter la vitesse du chenillard en action, c'est à dire diminuer le temps entre 2 lampes. A chaque clique le temps diminue de 100ms.
                        - Interrupteur 3 : Permet de changer le motif du chenillard à chaque clique. Nous avons 3 motifs : le standard, l'alterné (lampe 1 - 3 - 2 - 4) et l'inverse (lampe 4 - 3 - 2 - 1)/
                        - Interrupteur 4 : Permet d'arrêter le chenillard en action et ferme le lien KNX.
                      
 Si nous cliquons sur le bouton 1 alors que le chenillard à une vitesse rapide et une motif alterné par exemple, le chenillard se stoppe et démarre un chenillard standard de 1s.
</p>
