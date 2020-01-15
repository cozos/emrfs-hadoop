package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;

public class UnrecognizedPropertyException
  extends PropertyBindingException
{
  private static final long serialVersionUID = 1L;
  
  public UnrecognizedPropertyException(String msg, JsonLocation loc, Class<?> referringClass, String propName, Collection<Object> propertyIds)
  {
    super(msg, loc, referringClass, propName, propertyIds);
  }
  
  public static UnrecognizedPropertyException from(JsonParser jp, Object fromObjectOrClass, String propertyName, Collection<Object> propertyIds)
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
    String msg = "Unrecognized field \"" + propertyName + "\" (class " + ref.getName() + "), not marked as ignorable";
    UnrecognizedPropertyException e = new UnrecognizedPropertyException(msg, jp.getCurrentLocation(), ref, propertyName, propertyIds);
    
    e.prependPath(fromObjectOrClass, propertyName);
    return e;
  }
  
  @Deprecated
  public String getUnrecognizedPropertyName()
  {
    return getPropertyName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */