package com.lumia.collection.list;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class ListTest {
	
	private static final Logger L = LoggerFactory.getLogger( ListTest.class );

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for ( String str : getArrayList() ) {
			L.info( str );
		}
	}

	public static List<String> getArrayList() {
		 
		return Lists.newArrayList( new String[] { "1", "2", "3" } );
	}
	
	public static List<String> getLinkedList() {
		
		return Lists.newLinkedList();
	}
	
}
