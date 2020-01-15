package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashMap;
import java.util.Map;

class SerializationUtils$ClassLoaderAwareObjectInputStream
  extends ObjectInputStream
{
  private static final Map<String, Class<?>> primitiveTypes = new HashMap();
  private final ClassLoader classLoader;
  
  public SerializationUtils$ClassLoaderAwareObjectInputStream(InputStream in, ClassLoader classLoader)
    throws IOException
  {
    super(in);
    this.classLoader = classLoader;
    
    primitiveTypes.put("byte", Byte.TYPE);
    primitiveTypes.put("short", Short.TYPE);
    primitiveTypes.put("int", Integer.TYPE);
    primitiveTypes.put("long", Long.TYPE);
    primitiveTypes.put("float", Float.TYPE);
    primitiveTypes.put("double", Double.TYPE);
    primitiveTypes.put("boolean", Boolean.TYPE);
    primitiveTypes.put("char", Character.TYPE);
    primitiveTypes.put("void", Void.TYPE);
  }
  
  protected Class<?> resolveClass(ObjectStreamClass desc)
    throws IOException, ClassNotFoundException
  {
    String name = desc.getName();
    try
    {
      return Class.forName(name, false, classLoader);
    }
    catch (ClassNotFoundException ex)
    {
      try
      {
        return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
      }
      catch (ClassNotFoundException cnfe)
      {
        Class<?> cls = (Class)primitiveTypes.get(name);
        if (cls != null) {
          return cls;
        }
        throw cnfe;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */