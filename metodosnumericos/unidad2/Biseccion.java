package unidad2;

public class Biseccion{
	private double xa,xs,tolerancia,iteraciones;
	
	

	public Biseccion(double xa, double xs, double tolerancia, double iteraciones) {
		this.xa = xa;
		this.xs = xs;
		this.tolerancia = tolerancia;
		this.iteraciones = iteraciones;
	}

	private double funcion(double x){
		//return (Math.cos(x)*Math.exp(x/2)-(3*x));
		//return (-3750+(25000*(Math.pow(1+x, 12)/12)));
		return (Math.exp(x)*Math.tan(x))-1;
	}
	
	public void biseccion(){
		double xr;
		String tabla="";
		double errorCal=0;
		int conta=0;
		while(true){
			xr=(xa+xs)/2;
			if (funcion(xr)==0) {
				System.out.printf("La raiz es:%.4f" , xr);
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
				errorCal=Math.abs(((xs-xa)/xr));
				tabla+=String.format("%.4f\t\t%.3f\n", xr,errorCal);
				if (errorCal<tolerancia) {
					System.out.printf("Aprox. raiz\tError aprox.\n%s", tabla);
					System.out.printf("La raiz es:%.4f" , xr);
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
		Biseccion bise=new Biseccion(7,8,0.001, 200);
		bise.biseccion();
	}
	
}
		