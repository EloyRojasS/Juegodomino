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
    
    //
  //  public boolean agregarFichaLinea(Ficha f,Jugador j){
    //    if(!(f instanceof FichaComodin)){
      //      if (lineaJuego.isEmpty()){
       //         lineaJuego.add(f);
        //        j.removerFicha(f);
      //          return true;
          //  }
       //     else{
          //      int inicio = obtenerValorInicioLinea();
           //     int fin= obtenerValorFinLinea();
                
             //   if(f.getLado2()== inicio || f.getLado1()==fin){
           //         int pos = (f.getLado2()==inicio)? 0:lineaJuego.size();
           //         lineaJuego.add(pos,f);
             //       j.removerFicha(f);
              //      return true;
             //   }
             //   else{
               //     return true;
           //     }
       // }
        //    else{
                    
         //           }
   // }
   /* public boolean agregarFichaLinea(Ficha f, Jugador j) {
        if (!(f instanceof FichaComodin)) {
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(f);
                j.removerFicha(f);
                return true;
            } else {
                int inicio = obtenerValorInicioLinea();
                int fin = obtenerValorFinLinea();

                if (f.getLado2() == inicio) {
                    lineaJuego.add(0, f);
                    j.removerFicha(f);
                    return true;
                } else if (f.getLado1() == fin) {
                    lineaJuego.add(f);
                    j.removerFicha(f);
                    return true;
                }
            }
            return false;
        } else {
            Scanner scanner = new Scanner(System.in);
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(f);
                System.out.println("Valor del lado1:");
                int lado1 = scanner.nextInt();
                System.out.println("Valor del lado2:");
                int lado2 = scanner.nextInt();
                ((FichaComodin) f).setLado1(lado1);
                ((FichaComodin) f).setLado2(lado2);
                return true;
            } else {
                System.out.println("Ingrese la posición donde quieres agregar:");
                String posicion = scanner.next();
                if (posicion.equals("Inicio") || posicion.equals("inicio")) {
                    lineaJuego.add(0, f);
                    System.out.println("Ingrese el valor del lado1 para el comodín:");
                    int lado1 = scanner.nextInt();
                    ((FichaComodin) f).setLado1(lado1);
                    return true;
                } else if (posicion.equalsIgnoreCase("Fin")||posicion.equalsIgnoreCase("fin")) {
                    lineaJuego.add(f);
                    System.out.println("Ingrese el valor del lado2 para el comodín:");
                    int lado2 = scanner.nextInt();
                    ((FichaComodin) f).setLado2(lado2);
                    return true;
                }
            }
            return false;
        }
    }*/
    /*public boolean agregarFichaLinea(Ficha f, Jugador j){
        if (!(f instanceof FichaComodin)) {
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(f);
                j.removerFicha(f);
                return true;
            } else {
                int inicio = obtenerValorInicioLinea();
                int fin = obtenerValorFinLinea();

                if (f.getLado2() == inicio || f.getLado1() == fin) {
                    int posicion = (f.getLado2() == inicio) ? 0 : lineaJuego.size();
                    lineaJuego.add(posicion, f);
                    j.removerFicha(f);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(f);
                int lado1 = obtenerValorInicioLinea();
                int lado2 = obtenerValorFinLinea();
                f.setLado1(lado1);
                f.setLado2(lado2);
                return true;
            } else {
                System.out.println("Ingrese la posiciÃ³n donde desea agregar la ficha: Inicio o Fin");
                // Supongamos que el jugador ingresÃ³ "Inicio"
                String posicion = "Inicio";

                if (posicion.equalsIgnoreCase("Inicio")) {
                    lineaJuego.add(0, f);
                    int lado1 = obtenerValorInicioLinea();
                    f.setLado1(lado1);
                    return true;
                } else if (posicion.equalsIgnoreCase("Fin")) {
                    lineaJuego.add(f);
                    int lado2 = obtenerValorFinLinea();
                    f.setLado2(lado2);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }*/
    /*
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
                System.out.println("Posición no válida. Inténtelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligió la ficha: " + ficha);
        return true;
    }
}
*/
    /*
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
                System.out.println("Movimiento erroneo. Intentelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligio la ficha: " + ficha);
        return true;
    } else {
        Scanner scanner = new Scanner(System.in);
        if (lineaJuego.isEmpty()) {
            lineaJuego.add(ficha);
            System.out.print("Numero inicio: ");
            int lado1 = scanner.nextInt();
            ficha.setLado1(lado1);
            System.out.print("Numero fin: ");
            int lado2 = scanner.nextInt();
            ficha.setLado2(lado2);
        } else {
            System.out.print("Posicion (Inicio o Fin): ");
            String posicion = scanner.next();
            if (posicion.equalsIgnoreCase("Inicio")) {
                lineaJuego.add(0, ficha);
                System.out.print("Numero inicio: ");
                int lado1 = scanner.nextInt();
                ficha.setLado1(lado1);
            } else if (posicion.equalsIgnoreCase("Fin")) {
                lineaJuego.add(ficha);
                System.out.print("Numero fin: ");
                int lado2 = scanner.nextInt();
                ficha.setLado2(lado2);
            } else {
                System.out.println("Error. Intentelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligio la ficha: " + ficha);

        // Verificar si el jugador no tiene más fichas y declarar al otro jugador como ganador
        if (jugador.getMano().isEmpty()) {
            Jugador otroJugador = (jugadores.indexOf(jugador) == 0) ? jugadores.get(1) : jugadores.get(0);
            System.out.println(otroJugador.getNombre() + " gano!");
        }

        return true;
    }
}
   */ 
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
                System.out.println("Posición no válida. Inténtelo de nuevo.");
                return false;
            }
        }
        jugador.removerFicha(ficha);
        System.out.println("Jugador " + jugador.getNombre() + " eligió la ficha: " + ficha);

        // Verificar si el jugador no tiene más fichas
        if (jugador.getMano().isEmpty()) {
            Jugador otroJugador = (jugadores.indexOf(jugador) == 0) ? jugadores.get(1) : jugadores.get(0);
            System.out.println("¡El jugador " + otroJugador.getNombre() + " ha ganado!");
            return true;  // Indicar que se agregó la ficha correctamente
        }

        // Verificar si el jugador no puede colocar ninguna ficha
        boolean puedeColocarFichas = false;
        for (Ficha manoFicha : jugador.getMano()) {
            if (agregarFichaLinea(manoFicha, jugador)) {
                puedeColocarFichas = true;
                break;
            }
        }

        // Si el jugador no puede colocar ninguna ficha, declarar al otro jugador como ganador
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
                //si es que va al final
                else{
                    f2.setLado2(rand.nextInt(1,7));
                    lineaJuego.add(f2);
                    maqui.removerFicha(f);
                    break;
                }
            }
            //si es que no hay elementos en la lineaJuego
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
                maqui.removerFicha(f);
                break;
            }else{
                    //si no es f comodin
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
    
    
    

