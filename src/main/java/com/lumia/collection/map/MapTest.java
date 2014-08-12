package com.lumia.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class MapTest {
	
	private static final Logger L = LoggerFactory.getLogger( MapTest.class );

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		listMapByEntry( testHashMap() );
//		listMapByEntry( testLinkedHashMap() );
//		listMapByEntry( testTreeMap() );
	}

	/**
	 * get a HashMap Object
	 * 
	 * @return
	 */
	public static Map<String, String> testHashMap() {
		
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map1 = Maps.newHashMap();
		map.put( "1", "1" );
		map.put( "3", "3" );
		map.put( "2", "2" );
		
		return map;
	}
	
	/**
	 * get a HashTable Object
	 * 
	 * @return
	 */
	public static Map<String, String> testHashTable() {
		
		Map<String, String> map = new Hashtable<String, String>();
		map.put( "1", "1" );
		map.put( "3", "3" );
		map.put( "2", "2" );
		
		return map;
	}
	
	public static Map<String, String> testTreeMap() {
		
		Map<String, String> map = new TreeMap<String, String>();
		map.put( "1", "1" );
		map.put( "3", "3" );
		map.put( "2", "2" );
		
		return map;
	}
	
	public static Map<String, String> testLinkedHashMap() {
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put( "1", "1" );
		map.put( "3", "3" );
		map.put( "2", "2" );
		
		return map;
	}
	
	public static void listMapByEntry( Map<String, String> map ) {
		
		for ( Entry<String, String> enty : map.entrySet() ) {
			L.info( enty.getKey() + "--" + enty.getValue() );
		}
	}
	
	public static void listMapByKey ( Map<String, String> map ) {
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while ( it.hasNext() ) {
			L.info( it.next() + "--" + map.get( it.next() ) );
		}
	}
}
