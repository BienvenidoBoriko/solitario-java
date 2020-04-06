package solitario;

import java.util.ArrayList;

import solitario.Carta.Palos;

public class Mazo {
	Palos tipo; // El mazo es de cartas de un mismo palo
	public ArrayList<Carta> cartas;
	
	public Palos getTipo() {
		return tipo;
	}
	public void setTipo(Palos tipo) {
		this.tipo = tipo;
	}
    public Mazo() {
    	cartas=new ArrayList<Carta>();
	}
    public Mazo(int tam) {
    	cartas=new ArrayList<Carta>(tam);
	}
    public Mazo(int tam,Palos tipe) {
    	this(tam);
    	tipo=tipe;
	}
    
    public void cargarTodas() {
    	for (Carta.Palos p : Carta.Palos.values()) {
    		for (Carta.Rangos r : Carta.Rangos.values()) {
    			cartas.add(new Carta(p,r));
    		}
		}
    }
    
    public void barajar() {
    	int num3=(int)(Math.random()*200);
    	for (int i = 0; i <=num3; i++) {
    		int num2=(int)((cartas.size()-1)/2);
    		int num=(int)(Math.random()*num2);
    		Carta primera=cartas.remove(cartas.size()-1);
    		cartas.add(0,primera);
    		Carta inter=cartas.remove(num);
    		cartas.add(num+num2,inter);	
		}
    }
    
    public void añadirCarta(Carta cc) {
    	cartas.add(cc);
    }
    public void eliminarCarta(Carta cc) {
    	cartas.remove(cc);
    }
    public void invertirCartas(){
    	for (int i = 0;i <cartas.size()-1;i+=2) {
    		cartas.add(i+1,cartas.remove(i));	
		}
    }
    
  
    
}
