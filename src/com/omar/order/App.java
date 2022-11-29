package com.omar.order;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();
		List<Integer> listaFinal = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Integer length = null;
		Integer [] array = null;
		String response = null;

		System.out.println("En este programa ordenaremos los números de un array.");
		System.out.println("La longitud del mismo la dará el usuario.");

		try {

			System.out.println("Introduzca la longitud del array");
			length = sc.nextInt();
			
			array=generarArray(length);
			
			for (Integer indice : array) {
				lista.add(indice);
			}
			
			System.out.println("Su array es el siguiente:");
			System.out.println(lista);
			System.out.println("¿Desea ordenarlo? Sí(S) // No(N)");
			sc.nextLine();
			response = sc.nextLine();
			response.toUpperCase();
			
			if(response.equals("S")) {
				insertionSort(array);
				
				for (Integer indice : array) {
					listaFinal.add(indice);
				}

				System.out.println(listaFinal);
			}

		} catch (InputMismatchException e) {
			System.out.println("Introduzca números enteros por favor");
		}

	}

	public static void insertionSort(Integer array[]) {

		int n = array.length;

		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}

	public static Integer [] generarArray(Integer length) {

		Integer[] array = new Integer[length];
		
		for(Integer i=0; i<array.length; i++) {
			array[i]= (int)(Math.random()*100+1);
		}
		
		return array;
	}

}
