package solitario;

public class Carta {
	public enum Palos{CORAZON,DIAMANTE,PICA,TREBOL};
	public enum Rangos {K,Q,J,c10,c9,c8,c7,c6,c5,c4,c3,c2,A};
	private StringBuffer img;
	private Palos palo;
	private Rangos rango;
	
	public Carta(Palos palo, Rangos rango) {
		this.palo = palo;
		this.rango = rango;
		this.img=new StringBuffer(crearImgCarta());
	}

	public StringBuffer getImg() {
		return img;
	}

	public Palos getPalo() {
		return palo;
	}

	public void setPalo(Palos palo) {
		this.palo = palo;
	}

	public Rangos getRango() {
		return rango;
	}

	public void setRango(Rangos rango) {
		this.rango = rango;
	}
	
	private StringBuffer crearImgCarta() {
		 StringBuffer img;
		 String a="";
		 String b="";
		 String c="";
		 for (int i = 0; i <Math.ceil((16-(double)palo.toString().length())/2); i++) {
				a=(a+" ");
			 }
		 if (palo==Palos.CORAZON){
		 for (int i = 0; i <(Math.ceil((16-(double)palo.toString().length())/2))-1; i++) {
				c=(c+" ");
			 }
		 }
		 else {
			 for (int i = 0; i <Math.ceil((16-(double)palo.toString().length())/2); i++) {
					c=(c+" ");
				 } 
		 }
		 for (int j = 0; j <(16-rango.toString().length()); j++) {
			b=(b+" ");
		 }
		 return img=new StringBuffer("------------------"+"\n"+
					
			    "|" +rango.toString()+b+"|" +"\n"+
				"|"+ a+ palo.toString()+c+"|"+ "\n"+
				"|"+b+rango.toString()+"|"+"\n"+
				"------------------"+"\n"
				
				);
		 
	 }
	 }
