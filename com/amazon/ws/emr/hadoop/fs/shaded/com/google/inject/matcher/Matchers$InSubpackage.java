package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import java.io.Serializable;

class Matchers$InSubpackage
  extends AbstractMatcher<Class>
  implements Serializable
{
  private final String targetPackageName;
  private static final long serialVersionUID = 0L;
  
  public Matchers$InSubpackage(String targetPackageName)
  {
    this.targetPackageName = targetPackageName;
  }
  
  public boolean matches(Class c)
  {
    String classPackageName = c.getPackage().getName();
    return (classPackageName.equals(targetPackageName)) || (classPackageName.startsWith(targetPackageName + "."));
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof InSubpackage)) && (targetPackageName.equals(targetPackageName));
  }
  
  public int hashCode()
  {
    return 37 * targetPackageName.hashCode();
  }
  
  public String toString()
  {
    return "inSubpackage(" + targetPackageName + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.InSubpackage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */