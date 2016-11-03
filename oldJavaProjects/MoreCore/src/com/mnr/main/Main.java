package com.mnr.makesome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.mnr.makesome.Room.Wall;

public class Main {

	public static void main(String[] args) {
		
		/*B bClass = new B(1, 2, 3, 4);
		//bClass.c = 12;

		System.out.println(bClass.c);

		//System.out.println(bClass.c);
		
		bClass.showShit();
		bClass.showShit(2);
		*/
		
		/*AbsB absB = new AbsB();
		
		absB.callme();
		absB.callMe18();
		
		AbsB b2 = null;
		
		try {
			b2 = (AbsB) absB.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//b2.c = 12;
		System.out.println(b2.c = 12);
		
		b2 = null;
		System.out.println(absB.getClass());

		System.gc();*/
		
		/*T t = new T(12);
		
		
		t=null;
		
		System.gc();*/
		
		/*
		LinkedList<String> l = new LinkedList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		
		ListIterator<String> i = l.listIterator();
		
		String buf;
		while(i.hasNext()){
		
			buf = i.next();
			if(buf.equals("c")){
				i.add("q");
				System.out.println("Added");
			}
			if(buf.equals("d")){
				i.set("d2");
				i.add("u");
				i.add("u2");
				System.out.println("Set and Added");
			}	
		}
		
		l.add("f");
		i=l.listIterator();
		while(i.hasNext()){
			if(i.next().equals("c")){
				i.add("1");
			}
		}
		
		buf = null;
		System.out.println(l);
		
		stoppedMeth();
		
		System.out.println("end");
		*/
		
		/*
		Integer.valueOf(16);
		System.out.println(Integer.valueOf(16) == Integer.valueOf(16));// value == value
		System.out.println(16 == Integer.valueOf(16));//value == value
		System.out.println(new Integer(16) == Integer.valueOf(16));// link != value
		System.out.println(new Integer(16) == new Integer(16));// link != link
		System.out.println('\u03A6');
		System.out.println("short min/max val = " + Short.MIN_VALUE + " / " + Short.MAX_VALUE);
		System.out.println("Integer: " + Integer.MIN_VALUE + " / " + Integer.MAX_VALUE);
		System.out.println("Long: " + Long.MIN_VALUE + " / " + Long.MAX_VALUE);
		System.out.println("Double: " + Double.MIN_VALUE + " / " + Double.MAX_VALUE);
		System.out.println("Float: " + Float.MIN_VALUE + " / " + Float.MAX_VALUE);
		*/
		
		/*int[] q = new int[]{1,2,3,4,5};
		for (int i : q) {

			System.out.print(i+" ");
			
		}
		System.out.println();
		
		int[] r = new int[34];
		
		r[1] = 3;
		for (int i : r) {

			System.out.print(i+" ");
			
		}
		System.out.println();
		
		int[] n = new int[15];
		Arrays.fill(n, 14);
		for (int i : n) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
		//
		
		String[] s = {"a","s","s","s"};
		String[] s2 = new String[3];
		System.out.println(s);
		
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add(3,"q");
		
		System.out.println(l);
		
		String[] s3 = new String[l.size()];
		l.toArray( s3 );
		
		for (String string : s3) {
			System.out.print(string);
		}*/
		
		Set<String> aSet = new LinkedHashSet<>();
		aSet.add("a");
		aSet.add("b");
		aSet.add("Q");
		aSet.add("d");
		aSet.add("Q");
		
		System.out.println(aSet);
		
		Room room = new Room(12, 20, 4);
		room.showParameters();
		
//		Wall wall = new Wall(1, 1);
//		System.out.println(wall.wallHeight);
		
		int a = 12;
		Integer q = a;
		a = 0;
		int b = q;
		q =0;
		
		System.out.println("a: " + a + "| q:" + q + " " + b);
		
		
		
		
		
	}
	
	
	public static void stoppedMeth(){
		
		boolean stopping = true;
		
		while(stopping){
			
			int k = 0;
			stop:
				while(k<4){
				
				System.out.println("+" + k);
				int r = 0;
				while(r<3){
					
					System.out.println("r " + ++r);
					//break stop;// stop while cycles 1&2
					break;// stop current cycle
				}
				k++;
				//return; // stop method
			}
			
			stopping = false;
			System.out.println("boolean while stopped");
			
		}
		
		System.out.println("end of meth");
		
	}

}

