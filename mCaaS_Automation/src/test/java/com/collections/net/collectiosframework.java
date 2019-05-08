package com.collections.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;



public class collectiosframework {

	public static void main(String[] args) {
		//arraylist
		/*ArrayList<String> al=new ArrayList<String>();
		al.add("data_01");
		al.add("data_02");
		al.add("data_01");
		al.add("data_02");
		al.add(null);
		//iterator
		Iterator<String> iterator = al.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		*/
		//for each loop-null doesn't work
		/*System.out.println("=================");
		for(String element:al){
			System.out.println(element.toString());
		}*/
		
		//Linkedlist
				/*LinkedList<String> Llist=new LinkedList<String>();
				Llist.add("data_01");
				Llist.add("data_02");
				Llist.add("data_01");
				Llist.add("data_02");
				Llist.add(null);
				//iterator
				Iterator<String> iterator = Llist.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}*/
				
			//Vector	
				/*Vector<String> v=new Vector<String>();
				v.add("data_01");
				v.add("data_02");
				v.add("data_03");
				v.add("data_02");
				v.add(null);
				//iterator
				Iterator<String> iterator = v.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}*/
			//hashset - no duplicates
				/*HashSet<String> v=new HashSet<String>();
				v.add("data_01");
				v.add("data_02");
				v.add("data_01");
				v.add("data_02");
				v.add(null);
				//iterator
				Iterator<String> iterator = v.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}*/
     //Linkedhashset - no duplocates
				/*LinkedHashSet<String> v=new LinkedHashSet<String>();
				v.add("data_01");
				v.add("data_02");
				v.add("data_01");
				v.add("data_02");
				v.add(null);
				//iterator
				Iterator<String> iterator = v.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}*/
				//Treeset -no null and duplicate values
				/*TreeSet<String> v=new TreeSet<String>();
				v.add("data_01");
				v.add("data_02");
				v.add("data_01");
				v.add("data_02");
				//v.add(null);
				//iterator
				Iterator<String> iterator = v.iterator();
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}*/
		
		/*HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(100, "India");
		hm.put(101, "China");
		hm.put(100, "India");
		hm.put(103, "Singapore");
		hm.put(null, "Bdsh");
		
		for(Integer x:hm.keySet() ){
			System.out.println(hm.get(x));
		}*/
		
		/*LinkedHashMap<Integer, String> hm=new LinkedHashMap<Integer, String>();
		hm.put(100, "India");
		hm.put(101, "China");
		hm.put(100, "India");
		hm.put(103, "Singapore");
		hm.put(null, "Bdsh");
		
		for(Integer x:hm.keySet() ){
			System.out.println(hm.get(x));
		}*/
		TreeMap<Integer, String> hm=new TreeMap<Integer, String>();
		hm.put(100, "India");
		hm.put(101, "China");
		hm.put(102, "India");
		hm.put(103, "Singapore");
		//hm.put(null, "Bdsh");
		
		for(Integer x:hm.keySet() ){
			System.out.println(hm.get(x));
		}
	}

}
