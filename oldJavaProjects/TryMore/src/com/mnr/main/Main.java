package com.mnr.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		/*A b = new B();
		C c = new C();
		//A.meth1();
		c.meth1();
		//b.meth1();
		b = c;
		//b.meth1();
		int w = 0;
		try{
			try{
				throw new RuntimeException();
			}catch(RuntimeException e){
				System.out.println("e: "+e);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int[] q = {1,2};
			int f = 42/w;
			q[99] = 53;
		}catch(ArithmeticException e){
			System.out.println("Exception: " + e);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception2: " + e);
		}
		A c2 = new C();
		//c2.m2();
		System.out.println(c.qMeth(2));
		
		C d = new D();
		d.qMeth(3);
		d.m2();
		*/
		
		
		
		/* Map
		
		Map<Integer,String> a = new HashMap<>();
		
		a.put(1, "Roman");
		a.put(2, "Sasha");
		a.put(5, "Boris");
		a.put(6, "Felix");
		a.put(12, "Misha");
		
		if(a.get(123) == null){
			System.out.println("empty");
		}else{
			System.out.println("full " + a.get(4));
		}
		
		System.out.println(a.keySet());
		*/
		

		/* LinkedList
		
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		
		l.set(2, 14);
		l.removeFirst();
		l.removeLast();
		System.out.println(l);
		
		l.getFirst();
		
		Iterator<Integer> li = l.iterator();
		while(li.hasNext()){
			//li.remove();
			Integer i = li.next();
			if(i==14 || i == 4) li.remove();
			System.out.println("-> "+i);
		}

		System.out.println(l);
		*/
		/*ListIterator<Integer> li = l.listIterator();
		
		while(li.hasNext()){
			
			if(li.next()==3){
				System.out.println("a");
				li.remove();
			}
				
		}
		System.out.println("====");
		while(li.hasPrevious()){
			System.out.println(li.previous().hashCode());
		}
		/*li.set(777);
		
		while(li.hasPrevious()){
			System.out.println("last:" + li.previous());
		}*/
		
		/* HashSet
		
		HashSet<String> h = new HashSet<>();
		h.add("a");
		h.add("b");
		h.add("c");
		h.add("d");
		h.add("e");
		
		System.out.println("First: " + h);
		
		Iterator<String> hsi = h.iterator();
		
		while(hsi.hasNext()){
			
			String eString = hsi.next();
			if(eString.equals("b")){
				hsi.remove();
			}
			
			
		}
		System.out.println("Last: " + h);
		*/
		
		/* Map
		Map<String, String> m = new HashMap<>();
		m.put("1", "a");
		m.put("2", "b");
		m.put("3", "c");
		m.put("4", "d");
		
		for(Map.Entry<String, String> mEntry : m.entrySet()){
			System.out.println(mEntry.getKey() + "_" + mEntry.getValue());
		}
		
		for(Iterator<Map.Entry<String, String>> it = m.entrySet().iterator(); it.hasNext(); ){
			Map.Entry<String, String> entry = it.next();
			if(entry.getKey().equals("2")){
				it.remove();
			}
		}
		System.out.println(m);
		*/
		
		/* Ternary
		
		int a = 2;
		int b = 4;
		int min = a < b ? a : b;// int c; if(a<b){c=a;}else{c=b;}
		boolean q = a < b;
		System.out.println( min + " " + q );
		
		String s = "s".equals("ss") ? "yes" : "no";
		System.out.println(s);
		
		String r = "s"=="s" ? "yes" : "no";
		System.out.println(r);
		
		int v = 12==12 ? 1 : 0;
		System.out.println(v);
		*/
		
		/* Lambda
		SomeInterface aI;
		aI = ()->12;
		System.out.println(aI.m1());
		
		SomeInterface2 aC2 = (i) -> i*2==2;
		SomeInterface2 aC3 = (int i) -> i*2==4;
		SomeInterface2 aC4 = i -> i*2==6;
		
		System.out.println( aC2.m2(2) + " : " + aC3.m2(2) + " : " + aC4.m2(3) );
		
		SomeInterface2 aC5 = i ->{
			
			if( i > 100 ){
				return true;
			}else{
				return false;
			}
			
		};
		System.out.println(aC5.m2(1000));
		*/
		
		E e = (a,b)->{
			return a==b ? true : false;
		};
		boolean k = e.method(1, 1);
		String q = "";
		if((k+"").equals("true")){
			q = "F";
		}
		
		System.out.println(q+2);
		
		
		
	}

}