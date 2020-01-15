package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public enum Classes
{
  private Classes() {}
  
  public static Class<?> childClassOf(Class<?> parentClass, Object instance)
  {
    if ((instance == null) || (instance == Object.class)) {
      return null;
    }
    if ((parentClass != null) && 
      (parentClass.isInterface())) {
      return null;
    }
    Class<?> childClass = instance.getClass();
    for (;;)
    {
      Class<?> parent = childClass.getSuperclass();
      if (parent == parentClass) {
        return childClass;
      }
      if (parent == null) {
        return null;
      }
      childClass = parent;
    }
  }
  
  public static JarFile jarFileOf(Class<?> klass)
  {
    URL url = klass.getResource("/" + klass
      .getName().replace('.', '/') + ".class");
    if (url == null) {
      return null;
    }
    String s = url.getFile();
    int beginIndex = s.indexOf("file:") + "file:".length();
    int endIndex = s.indexOf(".jar!");
    if (endIndex == -1) {
      return null;
    }
    endIndex += ".jar".length();
    String f = s.substring(beginIndex, endIndex);
    File file = new File(f);
    try
    {
      return file.exists() ? new JarFile(file) : null;
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Classes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */