package com.kun.bugless.core;

import org.junit.Test;

import com.kun.bugless.core.factory.LibraryFactory;

public class LibraryFactoryTest {
	
	@Test
	public void TestLibraryFactory(){
		LibraryFactory lf =new LibraryFactory("bugless-core.properties");
		for(int i=0;i<lf.getLibaryNames().length;i++){
			System.out.println(lf.getLibaryNames()[i]);
			//System.out.println(lf.getClass());
		}
		for(int i=0;i<lf.getKeywordNames().length;i++){
			System.out.println(lf.getKeywordNames()[i]);
		}
	}
}
