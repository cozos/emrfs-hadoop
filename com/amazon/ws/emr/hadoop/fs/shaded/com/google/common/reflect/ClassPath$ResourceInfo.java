package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.net.URL;

@Beta
public class ClassPath$ResourceInfo
{
  private final String resourceName;
  final ClassLoader loader;
  
  static ResourceInfo of(String resourceName, ClassLoader loader)
  {
    if (resourceName.endsWith(".class")) {
      return new ClassPath.ClassInfo(resourceName, loader);
    }
    return new ResourceInfo(resourceName, loader);
  }
  
  ClassPath$ResourceInfo(String resourceName, ClassLoader loader)
  {
    this.resourceName = ((String)Preconditions.checkNotNull(resourceName));
    this.loader = ((ClassLoader)Preconditions.checkNotNull(loader));
  }
  
  public final URL url()
  {
    return (URL)Preconditions.checkNotNull(loader.getResource(resourceName), "Failed to load resource: %s", new Object[] { resourceName });
  }
  
  public final String getResourceName()
  {
    return resourceName;
  }
  
  public int hashCode()
  {
    return resourceName.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ResourceInfo))
    {
      ResourceInfo that = (ResourceInfo)obj;
      return (resourceName.equals(resourceName)) && (loader == loader);
    }
    return false;
  }
  
  public String toString()
  {
    return resourceName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.ClassPath.ResourceInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */