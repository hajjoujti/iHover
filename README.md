# iHover
Ce document explique l'utilisation de l'application iHover qui commande un robot aspirateur de se déplacer dans une zone spécifique
Cette application utilise la version 1.8 du jre Java.

1 - Pour commencer veuillez importer le fichier "iHover" dans votre IDE Java.
2 - Veuillez ensuite exécuter la classe "Application.java".
3 - L'application vous demandera de saisir la dimension x "longueur".
4 - Après avoir saisi la valeur de x appuyez sur la touche "Entrer" pour valider.
5 - Répéter la même procédure pour la valeur de y "largeur", les position x et y du robot, l'orientation du robot et la ligne de commande.
6 - Le programme affiche la position finale du robot sous forme x=... y=... orientation=...

N.B.: si votre saisie est incorrecte, l'application informe et vous demande de saisir de nouveau.

IMPORTANT:
- La valeur de l'orientation du robot doit être une lettre selon la notation cardinale anglaise (N,E,S,W).
- La ligne de commande pour déplacer le robot consiste de la combinaison des trois lettres A, D et G. Chaque lettre peut être utilisée plusieurs fois.
- La lettre A commande le robot pour avancer d'un seul pas.
- La lettre G commande le robot de pivoter le robot 90 degrés vers la gauche
- La lettre D commande le robot de pivoter le robot 90 degrés vers la droite