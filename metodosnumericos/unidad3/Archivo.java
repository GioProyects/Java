package unidad3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	
	private int filas;
	private int colum;
	private double matrix[][];
	
	public int getFilas() {
		return filas;
	}
	
	public int getColum() {
		return colum;
	}
	
	public void  leer(File archivo) {
		BufferedReader br = null;
		String temp[];
		String linea;
		int conta=0;
		try {
			br =new BufferedReader(new FileReader(archivo));
			linea =br.readLine();
			temp=linea.split(" ");	
			filas=temp.length-1;
			colum=filas+1;
			matrix=new double[filas][colum];
			while (linea!=null) {
				//System.out.println(linea);
				for (int i = 0; i < temp.length; i++) {
					String string = temp[i];
					matrix[conta][i]=Double.parseDouble(string);
				}
			    conta++;
				linea=br.readLine();
				temp=linea.split(" ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public double[][] getMatrix() {
		return matrix;
	}

}
