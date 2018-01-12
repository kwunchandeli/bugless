package com.kun.bugless.core.factory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.tree.VariableHeightLayoutCache;

import com.kun.bugless.core.annotation.Keyword;
import com.kun.bugless.core.keyword.KeywordInfo;
import com.kun.bugless.core.library.ILibrary;
import com.kun.bugless.core.library.Library;

public class LibraryFactory implements ILibaryFactory {
	private String propertyFileName;
	private Map<String, ILibrary> libraryMap = new HashMap<String, ILibrary>();

	public LibraryFactory(String propertyFileName) {
		this.propertyFileName = propertyFileName;
		load();
	}

	public void load() {
		Properties prop = new Properties();
		InputStream in;
		try {
			in = LibraryFactory.class.getClassLoader().getResourceAsStream(
					this.propertyFileName);
			prop.load(in); // /加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String classNameString = prop.getProperty(key);
				Library library = new Library(key,classNameString);
				Class clazz = Class.forName(classNameString);
				Method[] methods = clazz.getMethods();
				for (Method m : methods) {
					if (m.getAnnotation(Keyword.class) != null) {
						KeywordInfo info = new KeywordInfo(m.getName(),
								m.toGenericString());
						library.addKeyword(info);
					}
				}
				libraryMap.put(key, library);
			}
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ILibrary getLibrary(String libraryName){
		return libraryMap.get(libraryName);
	}
	
	public String[] getLibaryNames() {
		Set<String> set = libraryMap.keySet();
		return set.toArray(new String[set.size()]);
	}

	public String[] getKeywordNames() {
		List<String> list = new ArrayList<String>();
		for (String key : libraryMap.keySet()) {
			list.addAll(libraryMap.get(key).getKeywordList());
		}
		return list.toArray(new String[list.size()]);
	}

}
