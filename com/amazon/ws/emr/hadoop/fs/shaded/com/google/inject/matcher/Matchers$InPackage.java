package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;

class Matchers$InPackage
  extends AbstractMatcher<Class>
  implements Serializable
{
  private final transient Package targetPackage;
  private final String packageName;
  private static final long serialVersionUID = 0L;
  
  public Matchers$InPackage(Package targetPackage)
  {
    this.targetPackage = ((Package).Preconditions.checkNotNull(targetPackage, "package"));
    packageName = targetPackage.getName();
  }
  
  public boolean matches(Class c)
  {
    return c.getPackage().equals(targetPackage);
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof InPackage)) && (targetPackage.equals(targetPackage));
  }
  
  public int hashCode()
  {
    return 37 * targetPackage.hashCode();
  }
  
  public String toString()
  {
    return "inPackage(" + targetPackage.getName() + ")";
  }
  
  public Object readResolve()
  {
    return Matchers.inPackage(Package.getPackage(packageName));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.InPackage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */