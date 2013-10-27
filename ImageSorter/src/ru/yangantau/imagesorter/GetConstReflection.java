package ru.yangantau.imagesorter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.drew.metadata.Directory;

//**  class for get constant TAG fields by reflection
// take Only static int fields

public class GetConstReflection {
	ArrayList<String> tags = new ArrayList<String>();

	GetConstReflection(Class<?> cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			if (f.getType().getName() == "int")
				if (Modifier.isStatic(f.getModifiers())) {
					tags.add(f.getName());
				}
		}

	}

	ArrayList<String> getConst() {
		return tags;
	}
}
