/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.juegodomino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;

    public Juego() {
        lineaJuego = new ArrayList<> ();
        jugadores = new ArrayList<> ();
    }
    public void agregarJugador(String nombre){
        ArrayList<Ficha> mano = Utilitaria.crearManoJugador();
        Jugador newjugador= new Jugador(nombre,mano);
        jugadores.add(newjugador);
        
    }
    
    public int obtenerValorInicioLinea(){
        return lineaJuego.get(0).getLado1();
    }
    public int obtenerValorFinLinea(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea(){
        for(int i=0; i<lineaJuego.size();i++){
            Ficha f = lineaJuego.get(i);
            if(i!=lineaJuego.size()-1)
                System.out.print(f.toString()+"-");
            else
                System.out.println(f.toString());
        }
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
   
       public boolean agregarFichaLinea(Ficha ficha, Jugador jugador) {
    if (!(ficha instanceof FichaComodin)) {
        if (lineaJuego.isEmpty()) {
            lineaJuego.add(ficha);
        } else {
            if (ficha.getLado2() == obtenerValorInicioLinea()) {
                lineaJuego.add(0, ficha);
            } else if (ficha.getLado1() == obtenerValorFinLinea()) {
                lineaJuego.add(ficha);
            } else {
                System.out.println("Movimiento no válido. Inténtelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligió la ficha: " + ficha);
        return true;
    } else {
        Scanner scanner = new Scanner(System.in);
        if (lineaJuego.isEmpty()) {
            lineaJuego.add(ficha);
            System.out.print("Ingrese el valor del lado1 del comodín: ");
            int lado1 = scanner.nextInt();
            ficha.setLado1(lado1);
            System.out.print("Ingrese el valor del lado2 del comodín: ");
            int lado2 = scanner.nextInt();
            ficha.setLado2(lado2);
        } else {
            System.out.print("Ingrese la posición (Inicio o Fin) donde quiere agregar el comodín: ");
            String posicion = scanner.next();
            if (posicion.equalsIgnoreCase("Inicio")) {
                lineaJuego.add(0, ficha);
                System.out.print("Ingrese el valor del lado1 del comodín: ");
                int lado1 = scanner.nextInt();
                ficha.setLado1(lado1);
            } else if (posicion.equalsIgnoreCase("Fin")) {
                lineaJuego.add(ficha);
                System.out.print("Ingrese el valor del lado2 del comodín: ");
                int lado2 = scanner.nextInt();
                ficha.setLado2(lado2);
            } else {
                System.out.println("Posicion no válida. Inténtelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligió la ficha: " + ficha);

        
        if (jugador.getMano().isEmpty()) {
            Jugador otroJugador = (jugadores.indexOf(jugador) == 0) ? jugadores.get(1) : jugadores.get(0);
            System.out.println("¡El jugador " + otroJugador.getNombre() + " ha ganado!");
            return true;  
        }

        
        boolean puedeColocarFichas = false;
        for (Ficha manoFicha : jugador.getMano()) {
            if (agregarFichaLinea(manoFicha, jugador)) {
                puedeColocarFichas = true;
                break;
            }
        }

        
        if (!puedeColocarFichas) {
            Jugador otroJugador = (jugadores.indexOf(jugador) == 0) ? jugadores.get(1) : jugadores.get(0);
            System.out.println("¡El jugador " + otroJugador.getNombre() + " ha ganado!");
        }

        return true;
    }
}     
           
    
    
    
        public void maquina(Jugador maqui){
        for(Ficha f: maqui.getMano()){
            
            if(f instanceof FichaComodin f2){
                Random rand = new Random();
                
                boolean aleatorio1 = rand.nextBoolean();
                
                if (aleatorio1){
                    f2.setLado1(rand.nextInt(1,7));
                    lineaJuego.add(0, f2);
                    maqui.removerFicha(f);
                    break;
                }
                
                else{
                    f2.setLado2(rand.nextInt(1,7));
                    lineaJuego.add(f2);
                    maqui.removerFicha(f);
                    break;
                }
            }
            
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
                maqui.removerFicha(f);
                break;
            }else{
                    
                    if (lineaJuego.isEmpty()){
                        lineaJuego.add(f);
                        maqui.removerFicha(f);
                        break;
                    }
                    else{
                        if(f.getLado2() == this.obtenerValorInicioLinea()){
                            lineaJuego.add(0, f);
                            maqui.removerFicha(f);
                            break;
                        }
                        else 
                            if(f.getLado1() == this.obtenerValorFinLinea()){
                            lineaJuego.add(f);
                            maqui.removerFicha(f);
                            break;
                        }
                    }
                }
        }}}
    
    
    

