package unidad2;

/**
 * @author gio
 *
 */
public class FalsaPosicion {
	
	private double xa,xs;
	private double tolerancia;
	private int iteraciones;	
	
	public FalsaPosicion(double a, double b, double tolerancia, int iteraciones) {
		
		this.xa = a;
		this.xs = b;
		this.tolerancia = tolerancia;
		this.iteraciones = iteraciones;
	}
		

	public static double funcion(double c){
		//return (Math.cos(c)*Math.exp(c/2)-(3*c));
		//return (25000*(Math.pow(1+c, 12)/12))-3750;
		return (Math.exp(c)*Math.tan(c))-1;
	}
	
	public void falsaposicion(){
		double xr;
		String tabla="";
		double errorCal=0;
		int conta=0;
		while(true){
			xr=xs-((funcion(xs)/(funcion(xs)-funcion(xa)))*(xs-xa));
			if (funcion(xr)==0) {
				System.out.printf("La raiz es:%.4f en %d iteraciones" , xr,conta);
				break;
			} else {
				if ((funcion(xa)*funcion(xr))<0) {
					xs=xr;
				} else {
					xa=xr;
				}				
			}
			conta++;
			
			if (conta>1) {
				errorCal=Math.abs(((xs-xa)))/xr;
				tabla+=String.format("%.4f\t\t%.4f\n", xr,errorCal);
				if (errorCal<tolerancia) {
					System.out.printf("Aprox. raiz\tError aprox.\n%s", tabla);
					System.out.printf("La raiz es:%.4f en %d iteraciones" , xr,conta);
					break;
				}
			}else{
				tabla+=String.format("%.4f\n",xr);
				}
			if (conta>iteraciones) {
				System.out.println("No se ha encontrado raiz");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		FalsaPosicion falsa=new FalsaPosicion(1.5,2, 0.001, 300);		
		falsa.falsaposicion();
	}

}
