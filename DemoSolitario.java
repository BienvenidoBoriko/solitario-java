package solitario;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoSolitario {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1-Iniciar Partida" + "\n2-Salir");
		switch (sc.nextLine()) {
		case "1": {
			partida();
		}
			break;
		}

		System.out.println("Gracias Por Usar La App");
	}

	public static void partida() {
		Scanner sc = new Scanner(System.in);
		String nuevaPartida = "1";
		do {
			Integer numVSacDosCartas = 0;
			Mazo picas = new Mazo(12, Carta.Palos.PICA);
			Mazo corazones = new Mazo(12, Carta.Palos.CORAZON);
			Mazo treboles = new Mazo(12, Carta.Palos.TREBOL);
			Mazo diamantes = new Mazo(12, Carta.Palos.DIAMANTE);
			Mazo barajaPrinc = new Mazo(52);
			Mazo dosCartas = new Mazo(2);
			barajaPrinc.cargarTodas();
			barajaPrinc.barajar();
			numVSacDosCartas += 2;
			numVSacDosCartas = sacarDosCartas(dosCartas, barajaPrinc, numVSacDosCartas);
			dibujarEscenario(dosCartas, picas, corazones, diamantes, treboles);
			String entrada;
			do {
				System.out.println(" Elige una opcion (1-3)" + "\n 1-saca dos cartas" + "\n 2-Mover Carta(mazo)"
						+ "\n 3-Abandonar Partida");
				entrada = sc.nextLine();
				switch (entrada) {
				case "1": {// si el usuario quiere sacar dos cartas
					numVSacDosCartas += 2;
					numVSacDosCartas = sacarDosCartas(dosCartas, barajaPrinc, numVSacDosCartas);
					dibujarEscenario(dosCartas, picas, corazones, diamantes, treboles);
				}
					break;
				case "2": {// si el usuario quiere mover la carca
					if (!(dosCartas.cartas.isEmpty())) {
						if (!(moverCartaAMazo(barajaPrinc, dosCartas, picas, corazones, diamantes, treboles,
								dosCartas.cartas.get(dosCartas.cartas.size() - 1)))) {
							System.out.println("No se puede mover la carta");
							dibujarEscenario(dosCartas, picas, corazones, diamantes, treboles);
						}
						else {System.out.println("movida");
						dibujarEscenario(dosCartas, picas, corazones, diamantes, treboles);
						}
					}
					else {System.out.println("No hay cartas para mover");
					dibujarEscenario(dosCartas, picas, corazones, diamantes, treboles);
					}
				}
					break;
				}
			} while (!(entrada.equals("3")) & (!(barajaPrinc.cartas.isEmpty())));
			if (barajaPrinc.cartas.isEmpty())
				System.out.println("Enhorabuena!!! Has Ganado La Partida");
			else {
				System.out.println("Lo sientoo");
			}
			System.out.println("Quires Jugar Otra vez(1-si,2-no)");
			nuevaPartida = sc.nextLine();
		} while (nuevaPartida.equals("1"));
	}

	// mueve una carta del mazo de dos cartas a su mazo correspondiente,si se puede
	// mover elimina la carta
	// del mazo de dos cartas y del principal;hace uso de los metodos
	// esLaPosicionCorrecta y pertenMazo
	// recibe el mazo principal,el de dos cartas,y el mazo al que intentamos mover
	// la carta
	// devuelve un booleano
	public static boolean moverCartaAMazo(Mazo princ, Mazo dosCartas, Mazo picas, Mazo corazones, Mazo diamantes,
			Mazo treboles, Carta c) {
		boolean sePuedeMover = false;
		if (pertenMazo(picas, c)) {
			if (esLaPosicionCorrecta(picas, c)) {
				picas.añadirCarta(c);
				sePuedeMover = true;
			}
		} else if (pertenMazo(corazones, c)) {
			if (esLaPosicionCorrecta(corazones, c)) {
				corazones.añadirCarta(c);
				sePuedeMover = true;
			}
		} else if (pertenMazo(diamantes, c)) {
			if (esLaPosicionCorrecta(diamantes, c)) {
				diamantes.añadirCarta(c);
				sePuedeMover = true;
			}
		} else if (pertenMazo(treboles, c)) {
			if (esLaPosicionCorrecta(treboles, c)) {
				treboles.añadirCarta(c);
				sePuedeMover = true;
			}
		}
		if (sePuedeMover) {
			dosCartas.eliminarCarta(c);
			princ.eliminarCarta(c);
		}
		return sePuedeMover;
	};

	// verifica si la carta que queremos mover pertenece a dicho mazo
	// recibe el mazo y la carta
	// devuelve un booleano true si pertenece
	public static boolean pertenMazo(Mazo m, Carta c) {
		boolean pertenece = false;
		if (m.getTipo().equals(c.getPalo())) {
			pertenece = true;
		}
		return pertenece;
	}

	// verifica si la carta que queremos mover esta en la posicion correcta
	// recibe el mazo y la carta
	// devuelve un booleano true si pertenece
	public static boolean esLaPosicionCorrecta(Mazo m, Carta c) {
		boolean posCorrecta = false;
		if (m.cartas.isEmpty()) {
			if (c.getRango().toString().equals(Carta.Rangos.A.toString())) {
				posCorrecta = true;
				System.out.println("posCorrecta");
			}
		} else if ((c.getRango().ordinal() + 1) == (m.cartas.get(m.cartas.size() - 1).getRango().ordinal())) {
			posCorrecta = true;
			System.out.println("posCorrecta");
		} else {
			System.out.println("no posCorrecta");
		}
		return posCorrecta;
	}

	// dibuja el escenario de juego
	// recibe el mazo de dos cartas y el mazo de picas,corazon,diamante,trebol
	public static void dibujarEscenario(Mazo dosCartas, Mazo p, Mazo c, Mazo d, Mazo t) {
		for (int i = 0; i < 60; i++) {
			System.out.print("-");
		}
		System.out.print("Solitario By Bboriko");
		for (int i = 0; i < 60; i++) {
			System.out.print("-");
		}
		System.out.println("");
		System.out.println("Dos cartas del Mazo Principal");
		// imprimiendo dos cartas sacadas
		if (!(dosCartas.cartas.isEmpty())) {
			for (Carta cc : dosCartas.cartas) {
				System.out.println(cc.getImg());
			}
		}
		// imprimiendo mazo de picas
		System.out.println("Picas");
		if (!(p.cartas.isEmpty())) {
			System.out.print(p.cartas.get(p.cartas.size() - 1).getImg());
		}
		// imprimiendo mazo de corazones
		System.out.println("Corazones");
		if (!(c.cartas.isEmpty())) {
			System.out.print(c.cartas.get(c.cartas.size() - 1).getImg());
		}
		// imprimiendo mazo de diamantes
		System.out.println("Diamantes");
		if ((d.cartas.isEmpty()) == false) {
			System.out.print(d.cartas.get(d.cartas.size() - 1).getImg());
		}
		// imprimiendo mazo de treboles
		System.out.println("Treboles");
		if (!(t.cartas.isEmpty())) {
			System.out.print(t.cartas.get(t.cartas.size() - 1).getImg());
		}
	};

	// saca dos cartas del mazo principal y las copia en el mazo de dos cartas
	// recibe el mazo de dos cartas, el mazo principal y un integer numVSacDosCartas
	// numVSacDosCartas permite que cada vez que se llame al metodo se saque dos
	// cartas diferentes
	public static Integer sacarDosCartas(Mazo dosCartas, Mazo barajaPrinc, Integer numVSacDosCartas) {
		dosCartas.cartas.clear();
		if (numVSacDosCartas > barajaPrinc.cartas.size()) {
			numVSacDosCartas = 2;
			barajaPrinc.invertirCartas();
		}
		if (!(barajaPrinc.cartas.isEmpty()) && ((barajaPrinc.cartas.size()) != 1)) {
			dosCartas.añadirCarta(barajaPrinc.cartas.get(barajaPrinc.cartas.size() - numVSacDosCartas));
			dosCartas.añadirCarta(barajaPrinc.cartas.get(barajaPrinc.cartas.size() - (numVSacDosCartas - 1)));
			System.out.println("cartas sacadas");
		} else if ((barajaPrinc.cartas.size()) == 1) {
			dosCartas.añadirCarta(barajaPrinc.cartas.get(barajaPrinc.cartas.size() - (numVSacDosCartas - 1)));
		}
		return numVSacDosCartas;
	}
}
