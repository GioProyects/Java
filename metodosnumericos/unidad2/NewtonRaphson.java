package unidad2;

public class NewtonRaphson {
	
	private double x0;
	private double tolerancia;
	private int iteraciones;
	
	
	public NewtonRaphson(double x0, double tolerancia, int iteraciones) {
		this.x0 = x0;
		this.tolerancia = tolerancia*100;
		this.iteraciones = iteraciones;
	}
	
	public static double funcion(double c){
		//return (Math.exp(c)*Math.tan(c))-1;
		//return (25000*Math.pow(1+c, 12))-3750;
		return Math.exp(-0.5*c)*((Math.cos(Math.sqrt(8.75)*c))+(Math.sin(Math.sqrt(8.75)*c)))-0.04173;
	}
	public static double funcion_derivada(double c){
		//return (Math.exp(c)*Math.pow(1/Math.cos(c),2))+(Math.tan(c)*Math.exp(c));
		//return 25000*Math.pow(1+c, 11);
		return (2.45804*(Math.exp(-0.5*c)*Math.cos(2.95804*c)))-(3.45804*(Math.exp(-0.5*c)*Math.sin(2.95804*c)));
	}
	
	public void newtonraphson(){
		double xr = 0;
		String tabla=String.format("%.4f\n", x0);
		double errorCal=0;
		int conta=1;
		while(true){
			xr=x0-(funcion(x0)/funcion_derivada(x0));
			if (funcion(xr)==0) {
				System.out.printf("La raiz es:%.5f en %d iteraciones" , xr,conta);
				break;
			} else {
				conta++;
				errorCal=Math.abs((((xr-x0)/xr)))*100;
				tabla+=String.format("%.4f\t\t%.4f\n", xr,errorCal);
				if (errorCal<tolerancia) {
					System.out.printf("Aprox. raiz\tError aprox.\n%s", tabla);
					System.out.printf("La raiz es:%.5f en %d iteraciones" , xr,conta);
					break;
				}else {
					x0=xr;
				}				
			}
			if (conta>iteraciones) {
				System.out.println("No se ha encontrado raiz");
				break;
			}
		}
	}
			
	public static void main(String[] args) {
		NewtonRaphson nr=new NewtonRaphson(0, 0.1, 200);
		nr.newtonraphson();
		
		
	}
}
