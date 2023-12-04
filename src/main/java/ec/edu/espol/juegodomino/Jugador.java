/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.juegodomino;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }
    
    public Ficha getFicha(int in){
        if(in >=0 && in < mano.size())
            return mano.get(in);
        else
            return null;
    }
    public void removerFicha(Ficha fi){
        this.mano.remove(fi);
    }
    
    public String getNombre() {
        return nombre;
    }

    
    public void imprimirMano(){
    ArrayList<String> fichas = new ArrayList<>();
    for(Ficha f : mano){
        fichas.add(f.getLado1()+":"+f.getLado2());
    }
        String manoJugador = String.join("-", fichas);
        System.out.println(manoJugador);
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
    
    
    
    
}
        
