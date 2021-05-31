package robot.ihover;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
	static int xDimension, yDimension;
	static int xPosition, yPosition;
	static String direction, command;
	static Scanner scan = new Scanner(System.in);
	static boolean isInt = false;

	public static void main(String[] args) {
		System.out.println("Veuillez lire la documentation \"README.txt\" avant de continuer. ");

		assignUserInput();

		robotTravel();
		
		returnRobotPosition();
	}

	private static void returnRobotPosition() {
		System.out.println("x=" + xPosition + " y=" + yPosition + " orientation=" + direction);
	}

	private static void assignUserInput() {
		System.out.println("Veuillez saisir la longueur de la pièce : ");
		xDimension = takeValue();

		System.out.println("Veuillez saisir la largeur de la pièce : ");
		yDimension = takeValue();

		System.out.println("Veuillez saisir la position x du robot : ");
		do {
			xPosition = takeValue();
		} while(xPositionGreaterThanDimension());

		System.out.println("Veuillez saisir la position y du robot : ");
		do {
			yPosition = takeValue();
		} while(yPositionGreaterThanDimension());

		System.out.println("Veuillez saisir la direction du robot : ");
		do {
			direction = scan.nextLine().toUpperCase();
		} while (!isOneCardinalDirectionCaracter(direction));

		System.out.println("Veuillez saisir la commande pour déplacer le robot");
		do {
			command = scan.nextLine().toUpperCase();
		} while (doesNotContainCorrectLetters(command));
	}

	private static boolean xPositionGreaterThanDimension() {
		if(xPosition > xDimension) {
			System.out.println("La valeur doit être plus petite que la longueur. Veuillez réessayer : ");
			return true;
		}
		return false;
	}

	private static boolean yPositionGreaterThanDimension() {
		if(yPosition > yDimension) {
			System.out.println("La valeur doit être plus petite que la largeur. Veuillez réessayer : ");
			return true;
		}
		return false;
	}

	private static void robotTravel() {
		String[] singleCommand = command.split("");
		for (int i = 0; i < singleCommand.length; i++) {
			commandRotateRight(singleCommand, i);

			commandRotateLeft(singleCommand, i);

			commandMoveForward(singleCommand, i);
			
			scan.close();
		}
	}

	private static void commandMoveForward(String[] singleCommand, int i) {
		// vérifier si la commande est A
		if (singleCommand[i].equals("A")) {
			switch (direction) {
			case "N": {
				if (yPosition + 1 > yDimension) {
					// ne pas dépasser le mur nord
					System.out.println("Le robot a touche le mur et ne peut plus avancer.");
					break;
				}
				yPosition++;
				break;
			}
			case "E": {
				if (xPosition + 1 > xDimension) {
					// ne pas dépasser le mur est
					System.out.println("Le robot a touche le mur et ne peut plus avancer.");
					break;
				}
				xPosition++;
				break;
			}
			case "S": {
				if (yPosition - 1 < 0) {
					// ne pas dépasser le mur sud
					System.out.println("Le robot a touche le mur et ne peut plus avancer.");
					break;
				}
				yPosition--;
				break;
			}
			case "W": {
				if (xPosition - 1 < 0) {
					// ne pas dépasser le mur ouest
					System.out.println("Le robot a touche le mur et ne peut plus avancer.");
					break;
				}
				xPosition--;
				break;
			}
			}
		}
	}

	private static void commandRotateLeft(String[] singleCommand, int i) {
		// vérifier si la commande est G
		if (singleCommand[i].equals("G")) {
			switch (direction) {
			case "N":
				direction = "W";
				break;
			case "W":
				direction = "S";
				break;
			case "S":
				direction = "E";
				break;
			case "E":
				direction = "N";
				break;
			}
		}
	}

	private static void commandRotateRight(String[] singleCommand, int i) {
		// vérifier si la commande est D
		if (singleCommand[i].equals("D")) {
			switch (direction) {
			case "N":
				direction = "E";
				break;
			case "E":
				direction = "S";
				break;
			case "S":
				direction = "W";
				break;
			case "W":
				direction = "N";
				break;
			}
		}
	}

	private static int takeValue() {
		// attribuer une valeur entrée par l'utilisateur à un int
		int value = 0;
		do {
			try {
				value = Integer.parseInt(scan.nextLine());
				if (value < 0) {
					System.out.println("La valeur doit être positive. Veuillez réessayer : ");
					isInt = false;
				} else {
					isInt = true;
				}
			} catch (InputMismatchException e) {
				// s'assurer que la valeur est un nom
				System.out.println("La valeur doit être un nombre entier. Veuillez réessayer : ");
			} catch (NumberFormatException e) {
				// s'assurer que le nombre est un entier
				System.out.println("La valeur doit être un nombre entier. Veuillez réessayer : ");
			}
		} while (!isInt);
		isInt = false;
		if (value < 0) {

		}

		return value;
	}

	private static boolean doesNotContainCorrectLetters(String command) {
		// verifier si le string contient des les lettres autre que G, D et A
		if (!command.matches("[DGA]+")) {
			System.out.println("Veuillez tapez une commande valide qui combine les lettres D, G, et/ou A : ");
			return true;
		}
		return false;
	}

	private static boolean isOneCardinalDirectionCaracter(String direction) {
		// verifier le string est une des 4 lettres : N,E,S et W
		if (direction.length() == 1 && direction.matches("[NESW]+")) {
			return true;
		}
		System.out.println("La direction doit être un seul charactère valide (N, W, S, ou E). Veuillez réessayer : ");
		return false;
	}
}
