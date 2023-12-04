/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.juegodomino;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class JuegoDomino {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego();

        System.out.println("Inicio Domino");

        System.out.print("Nombre del Jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        juego.agregarJugador(nombreJugador1);

        System.out.print("¿Quieres jugar solo?: (si/no)");
        String opcion = scanner.next();

        if (opcion.equalsIgnoreCase("no")) {
            System.out.print("Nombre del Jugador 2: ");
            String nombreJugador2 = scanner.next();
            juego.agregarJugador(nombreJugador2);
        } else if (opcion.equalsIgnoreCase("si")) {
            juego.agregarJugador("Computadora");
        } else {
            System.out.println("Error");
            return;
        }

        while (true) {
            System.out.println("Inicio:");
            for (int i = 0; i < juego.getJugadores().size(); i++) {
                Jugador jugador = juego.getJugadores().get(i);
                System.out.print("Jugador " + i + ": " + jugador.getNombre() + " - Mano -> ");
                jugador.imprimirMano();
            }
            juego.mostrarLinea();

            for (int i = 0; i < juego.getJugadores().size(); i++) {
                Jugador jugador = juego.getJugadores().get(i);
                System.out.println("Turno del Jugador " + i + ": " + jugador.getNombre());

                if (jugador.getNombre().equals("Computadora")) {
                    juego.maquina(jugador);
                } else {
                    System.out.println("Mano -> " + jugador.getMano());
                    
                    
                    System.out.print("Elige una ficha (0 es la primero): ");
                    int indiceFicha = scanner.nextInt();
                    Ficha ficha = jugador.getFicha(indiceFicha);

                    if (ficha == null) {
                        System.out.println("Error. Intentelo de nuevo.");
                        i--; 
                        continue;
                    }

                    boolean movimientoValido = juego.agregarFichaLinea(ficha, jugador);

                    if (!movimientoValido) {
                        System.out.println("Movimiento no valido. Intentelo de nuevo.");
                        i--; 
                        continue;
                    }
                }
            }
       
                  
            
            
            for (Jugador jugador : juego.getJugadores()) {
                if (jugador.getMano().isEmpty()) {
                    System.out.println("¡El jugador " + jugador.getNombre() + " ha ganado!");
                    return;
                }
            }
        }
    }
}
