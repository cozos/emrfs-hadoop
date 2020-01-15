package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public enum ClassLoaderHelper
{
  private ClassLoaderHelper() {}
  
  public static URL getResource(String resource, Class<?>... classes)
  {
    return getResource(resource, false, classes);
  }
  
  public static URL getResource(String resource, boolean classesFirst, Class<?>... classes)
  {
    URL url;
    if (classesFirst)
    {
      URL url = getResourceViaClasses(resource, classes);
      if (url == null) {
        url = getResourceViaContext(resource);
      }
    }
    else
    {
      url = getResourceViaContext(resource);
      if (url == null) {
        url = getResourceViaClasses(resource, classes);
      }
    }
    return url == null ? ClassLoaderHelper.class.getResource(resource) : url;
  }
  
  private static URL getResourceViaClasses(String resource, Class<?>[] classes)
  {
    if (classes != null) {
      for (Class<?> c : classes)
      {
        URL url = c.getResource(resource);
        if (url != null) {
          return url;
        }
      }
    }
    return null;
  }
  
  private static URL getResourceViaContext(String resource)
  {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    return loader == null ? null : loader.getResource(resource);
  }
  
  private static Class<?> loadClassViaClasses(String fqcn, Class<?>[] classes)
  {
    if (classes != null) {
      for (Class<?> c : classes)
      {
        ClassLoader loader = c.getClassLoader();
        if (loader != null) {
          try
          {
            return loader.loadClass(fqcn);
          }
          catch (ClassNotFoundException localClassNotFoundException) {}
        }
      }
    }
    return null;
  }
  
  private static Class<?> loadClassViaContext(String fqcn)
  {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try
    {
      return loader == null ? null : loader.loadClass(fqcn);
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static Class<?> loadClass(String fqcn, Class<?>... classes)
    throws ClassNotFoundException
  {
    return loadClass(fqcn, true, classes);
  }
  
  public static Class<?> loadClass(String fqcn, boolean classesFirst, Class<?>... classes)
    throws ClassNotFoundException
  {
    Class<?> target = null;
    if (classesFirst)
    {
      target = loadClassViaClasses(fqcn, classes);
      if (target == null) {
        target = loadClassViaContext(fqcn);
      }
    }
    else
    {
      target = loadClassViaContext(fqcn);
      if (target == null) {
        target = loadClassViaClasses(fqcn, classes);
      }
    }
    return target == null ? Class.forName(fqcn) : target;
  }
  
  public static InputStream getResourceAsStream(String resource, Class<?>... classes)
  {
    return getResourceAsStream(resource, false, classes);
  }
  
  public static InputStream getResourceAsStream(String resource, boolean classesFirst, Class<?>... classes)
  {
    URL url = getResource(resource, classesFirst, classes);
    try
    {
      return url != null ? url.openStream() : null;
    }
    catch (IOException e) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ClassLoaderHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */