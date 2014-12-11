package com.talosdigital.kata.reflectionTest;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Logger {
	
	private static final Set<Class<?>> WRAPPER_TYPES = getWrapperTypes();
	/** 
	 * @param clazz
	 * @return
	 * True if clazz is wrapper of a primitive
	 */
    private static boolean isWrapperType(Class<?> clazz)
    {
        return WRAPPER_TYPES.contains(clazz);
    }
    /**
     * Used to set WRAPPER_TYPES
     * @return 
     * A set with all primitives wrappers
     */
    private static Set<Class<?>> getWrapperTypes()
    {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
	
	
	
	
	
	/**
	 * 
	 * @param object 
	 * the object to be analyze
	 * @return
	 * A string containing all the public attributes of the object
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static String getObjectInfo(Object object) throws IllegalArgumentException, IllegalAccessException{
		//get the class of the object
		String data = getAtributes(object, "");
		return data;
	}
	/**
	 * Called recursively to analyze a object and attributes of that object
	 * @param object
	 * the object to analyze
	 * It does not allow array of primitives, if required pass a array of the primitive wrapper (ei int[] -> Integer[])
	 * @param initialIndentation
	 * A string containing as many tabs ("\t") as deep in recursion we are
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private static String getAtributes(Object object, String initialIndentation) throws IllegalArgumentException, IllegalAccessException{
		//indentation will contain the indentation needed for the "level"
		StringBuilder indentation = new StringBuilder(initialIndentation);
		//data will contain the string which describes the object
		StringBuilder data = new StringBuilder(indentation.toString());
		//we are starting a new level so we get one tap deeper
		//indentation.append("\t");
		//add the class of the object we are testing
		data.append("Type: ").append(object.getClass().getName()).append("\n");
		//children off the object, thus new level
		indentation.append("\t");
		if(object.getClass().isArray()){
			//if the object its an array it takes each object and analyze it 
			int i = 0;
			for(Object subObject : (Object[])object){
				//ads the index of the current object
				data.append(indentation).append("[").append(i++).append("]\n");
				//recursive call
				data.append(getAtributes(subObject,indentation.toString()));
			}
		}else if(isWrapperType(object.getClass())){//object.getClass().isPrimitive() doesn't work so I used this method
			//if the object it's a primitive add its value
			data.append(indentation).append("Value : ").append(object).append("\n");
		}else if(object instanceof String){
			//if the object it's a String add its value
			data.append(indentation).append("Value : ").append(((String)object)).append("\n");
		}else{
			//if the code gets here its because the object it's a "object"
			//and so it needs to be analyzed as well
			//fields contains all public attributes and each one is passed again to be analyzed
			Field[] fields = object.getClass().getFields();
			//adds the Attributes label
			data.append(indentation).append("Attributes: \n");
			indentation.append("\t");
			for (Field field : fields){
				//adds the field name
				data.append(indentation).append(field.getName()).append("\n");
				//recursive call
				data.append(getAtributes(field.get(object), indentation.toString()));
			}
		}
		return data.toString();
	}
}
