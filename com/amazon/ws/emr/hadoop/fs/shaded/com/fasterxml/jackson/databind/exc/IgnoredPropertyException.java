package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;

public class IgnoredPropertyException
  extends PropertyBindingException
{
  private static final long serialVersionUID = 1L;
  
  public IgnoredPropertyException(String msg, JsonLocation loc, Class<?> referringClass, String propName, Collection<Object> propertyIds)
  {
    super(msg, loc, referringClass, propName, propertyIds);
  }
  
  public static IgnoredPropertyException from(JsonParser jp, Object fromObjectOrClass, String propertyName, Collection<Object> propertyIds)
  {
    if (fromObjectOrClass == null) {
      throw new IllegalArgumentException();
    }
    Class<?> ref;
    Class<?> ref;
    if ((fromObjectOrClass instanceof Class)) {
      ref = (Class)fromObjectOrClass;
    } else {
      ref = fromObjectOrClass.getClass();
    }
    String msg = "Ignored field \"" + propertyName + "\" (class " + ref.getName() + ") encountered; mapper configured not to allow this";
    
    IgnoredPropertyException e = new IgnoredPropertyException(msg, jp.getCurrentLocation(), ref, propertyName, propertyIds);
    
    e.prependPath(fromObjectOrClass, propertyName);
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.IgnoredPropertyException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */