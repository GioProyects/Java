package unidad3;

import java.io.File;

import javax.swing.JOptionPane;

public class Gauss_Jordan {
	private double matriz[][];
	private int row;
	private int col;
	private int iteraciones=0;

	public Gauss_Jordan(int datos) {
		row =datos;
		col=datos+1;
		matriz=new double[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matriz[i][j]=Integer.parseInt(JOptionPane.showInputDialog("dato:"));
			}
		}
	}
	
	
	
	
	public Gauss_Jordan() {
		Archivo a=new Archivo();
		a.leer(new File("matriz"));
		row=a.getFilas();
		col=a.getColum();
		matriz=a.getMatrix();
	}
	
	public boolean intercambio() {
		if (matriz[0][0]==0) {
			for (int i = 1; i < row; i++) {
				if (matriz[i][0]!=0) {
					double temp;
					for (int j = 0; j < col; j++) {
						temp=matriz[i][j];
						matriz[i][j]=matriz[0][j];
						matriz[0][j]=temp;
					}
					return true;					
				}
			}
		}
		return false;
	}
	
	public int getIteraciones() {
		return iteraciones;
	}
	
	public boolean intercambio(int fila) {
		if (fila+1<row) {
			double temp;
			for (int i = 0; i < col; i++) {
				temp=matriz[fila][i];
				matriz[fila][i]=matriz[fila+1][i];
				matriz[fila+1][i]=temp;
			}
			return true;
		}else{
			return false;
		}
	}
	
	public void solucion() {
		
		double d;
		double p;
		int i=0;
		while (i<row) {
			d=matriz[i][i];
			if (d!=0) {
				for (int j = 0; j < col; j++) {
					matriz[i][j]=matriz[i][j]/d;
				}
				//iteraciones++;
				for (int j = 0; j < row; j++) {
					if (j!=i) {
						p=matriz[j][i];
						for (int k = 0; k < col; k++) {
							double temp=matriz[j][k]-p*matriz[i][k];
							matriz[j][k]=temp;
						}
					//	iteraciones++;
					}
				}
				iteraciones++;
				i++;
				//System.out.println("iteracion:"+iteraciones);
			}else {
				if (!intercambio(i)) {
					System.out.println("no tiene solucion o despeje manualmente las incognitas");
					break;
				}
			}
			
		}
	}
	
	public void imprimir() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Gauss_Jordan se=new Gauss_Jordan();
		se.imprimir();
		System.out.println();
		se.solucion();
		//System.out.println("Iteraciones:"+se.getIteraciones());
		se.imprimir();
	}

}
