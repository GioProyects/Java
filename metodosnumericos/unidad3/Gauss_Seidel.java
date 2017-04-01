package unidad3;

import java.io.File;

public class Gauss_Seidel{
	private int n,k,i,j,h,band,siga,miter;
	private double tol;
	private double m[][];
	private double [] r,x,y,error,cont;
	private double suma,l;


	public Gauss_Seidel(int nIncognitas,double tolerancia,int iteraciones) {
		n=nIncognitas;
		Archivo a=new Archivo();
		a.leer(new File("matriz"));
		int row=a.getFilas();
		int col=a.getColum();
		tol=tolerancia;
		miter=iteraciones;
		//m= new double [n][n];
		m= new double [row][col];
		r= new double [row];     
		x= new double [row];
		y= new double [row];
		cont= new double [row];     
		error= new double [row];
		
		double temp[][]=a.getMatrix();
		
		//matriz de soluciones
		for (int i = 0; i < row; i++) {
			r[i]=temp[i][col-1];
		}
		
		//matriz inicial 
		/*for (int i = 0; i < row; i++) {
			x[i]=Double.parseDouble(JOptionPane.showInputDialog
					("ingrese el valor en el cual quiere comenzar a evaluar x"+i));
		}*/
		for (int i = 0; i < row; i++) {
			x[i]=0;
		}
		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col-1; j++) {
				m[i][j]=temp[i][j];
			}
		}

		/*for(int i=0;i<=n-1;i++){
			k=i+1;
			r[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el elemento "+k+" del vector de soluciones"));
			x[i]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el valor en el cual quiere comenzar a evaluar x"+k));
			y[i]=0;
			for(j=0;j<=n-1;j++){
				h=j+1;
				m[i][j]=Double.parseDouble(JOptionPane.showInputDialog("ingrese el elemento "+k+h+" de la matriz de coeficientes"));
			}
		}*/
	}

	public void solucion() {
		band=0;
		for(i=0;i<n;i++){
			suma=0;
			for(j=0;j<n;j++){
				if(i!=j){
					suma=suma+m[i][j];
				}
			}
			cont[i]=suma;
			if(Math.abs(m[i][i])>cont[i]){
				band=band+1;
			}
		}

		if(band==n){
			siga=n-1;
			int iter=0;
			while(siga!=n && iter<miter){
				iter=iter+1;
				for(i=0;i<n;i++){
					l=0;
					for(j=0;j<n;j++){
						if(i==j){
							l=l+r[i]/m[i][j];
						}
						else{
							l=l-((m[i][j]*x[j])/m[i][i]);
						}
					}
					x[i]=l;
				}
				for(i=0;i<n;i++){
					error[i]=Math.abs((x[i]-y[i])/x[i])*100;
					y[i]=x[i];
				}
				siga=0;
				for(i=0;i<n;i++){
					if(error[i]<tol){
						siga=siga+1;
					}
				}
			}
			h=0;
			String tabla="";
			for(i=0;i<n;i++){
				h=h+1;
				tabla+=String.format("x%d = %.5f\n", h,x[i]);
			}
			System.out.println(tabla);
			System.out.println("El número total de iteraciones fue de "+iter);
		}else {
			System.out.println("No se puede solucionar por este "
					+ 			"metodo debido a que la matriz de "
					+ 			"coeficientes no es diagonalmente dominante");
		}

	}

	public static void main(String[] args) {
		Gauss_Seidel gs=new Gauss_Seidel(3, 0.001, 100);
		gs.solucion();
	}	
}