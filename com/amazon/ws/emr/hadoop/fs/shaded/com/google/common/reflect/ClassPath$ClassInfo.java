package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;

@Beta
public final class ClassPath$ClassInfo
  extends ClassPath.ResourceInfo
{
  private final String className;
  
  ClassPath$ClassInfo(String resourceName, ClassLoader loader)
  {
    super(resourceName, loader);
    className = ClassPath.getClassName(resourceName);
  }
  
  public String getPackageName()
  {
    return Reflection.getPackageName(className);
  }
  
  public String getSimpleName()
  {
    int lastDollarSign = className.lastIndexOf('$');
    if (lastDollarSign != -1)
    {
      String innerClassName = className.substring(lastDollarSign + 1);
      
      return CharMatcher.DIGIT.trimLeadingFrom(innerClassName);
    }
    String packageName = getPackageName();
    if (packageName.isEmpty()) {
      return className;
    }
    return className.substring(packageName.length() + 1);
  }
  
  public String getName()
  {
    return className;
  }
  
  public Class<?> load()
  {
    try
    {
      return loader.loadClass(className);
    }
    catch (ClassNotFoundException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public String toString()
  {
    return className;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.ClassPath.ClassInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */