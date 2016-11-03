package com.mnr.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		/*
		// sort
		int[] arr = new int[10000];
		Random random = new Random();
		
		for(int t=0;t<arr.length;t++){
			arr[t] = random.nextInt(20);
		}
		
		// Bubble sort
		long startTime = System.currentTimeMillis();
		for(int i=arr.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(arr[j] > arr[j+1]){
					int buf = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = buf;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		for(int k=0;k<arr.length;k++){
			System.out.println(arr[k]);
		}
		System.out.println("bubble time: " + (endTime-startTime));
		*/
		
		/* from min to max
		long startTime = System.currentTimeMillis();
		Arrays.sort(arr);
		System.out.println("Arrays.sort time: " + (System.currentTimeMillis()-startTime));
		*/
		/* from max to min . ONLY Integer
		Integer[] arr2 = new Integer[10000];
		Random random2 = new Random();
		for(int t=0;t<arr2.length;t++){
			arr2[t] = random.nextInt(20);
		}
		long startTime = System.currentTimeMillis();
		
		Arrays.sort(arr2, Collections.reverseOrder());
		
		System.out.println("Arrays.sort time: " + (System.currentTimeMillis()-startTime));
		*/
		
		/*
		String[] names = new String[]{
				"Roman","Boris","Elena","Marty","Mary","Richard","Anna","Meggy"
		};
		
		long startTime = System.currentTimeMillis();
		
		Arrays.sort(names);
		long allTime = System.currentTimeMillis() - startTime;
		
		for (String string : names) {
			System.out.println(string);
		}
		System.out.println("time: " + allTime);
		*/
		
		
	//	LinkedList<String> aL = new LinkedList<>();// 953 ms
		ArrayList<String> aL = new ArrayList<>();// 1016
		
		Random rand = new Random();
		for(int j=0;j<1000000;j++){
			String newName = "Me" + rand.nextInt(2993);
			aL.add(newName);
		}
		long startTime = System.currentTimeMillis();
		
		Collections.sort(aL);
		
		long allTime = System.currentTimeMillis() - startTime;
		System.out.println("time: " + allTime);
		
		String[] ala = aL.toArray(new String[0]);
		
		
	}

}
