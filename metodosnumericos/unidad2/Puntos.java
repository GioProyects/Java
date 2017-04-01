package unidad2;
import java.lang.Math;
public class Puntos{
	public static void main(String[] bas){
		double x0=0,y0;
		for (int i=0;i<30;i++){
			x0=i*0.2;
			y0=y(x0);
			System.out.println(x0+"\t\t"+y0);}
				
	}
	
	public static double y(double c){
		//return (Math.sin(x)-Math.cos(x));
		//return (Math.exp(x)*Math.tan(x))-1;
		//return (Math.cos(x)*Math.exp(x/2)-(3*x));
		//return (25000*Math.pow(1+x, 12))-3750;
		//return Math.exp(-x)-Math.log(x);
		return (Math.exp(-0.5*c)*((Math.cos(Math.sqrt(8.75)*c))+(Math.sin(Math.sqrt(8.75)*c))))-0.04173;
		}
}
	