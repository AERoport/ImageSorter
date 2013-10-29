package ru.yangantau.imagesorter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.drew.metadata.Directory;

//**  class for get constant TAG fields by reflection
// take Only static int? not private and protected fields

public class GetConstReflection {

	static ArrayList<String> CalculateTags(Class<?> cl) {
		ArrayList<String> tags = new ArrayList<String>();
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			if ((f.getType().getName() == "int")
					&& (Modifier.isStatic(f.getModifiers()))
					&& (!Modifier.isProtected(f.getModifiers()))) {
				tags.add(f.getName());
			}
		
		};
		
		return tags;
	}

	static ArrayList<String> CalculateTags(String className)
			throws ClassNotFoundException {
		return CalculateTags(Class.forName(className));
	}

}
