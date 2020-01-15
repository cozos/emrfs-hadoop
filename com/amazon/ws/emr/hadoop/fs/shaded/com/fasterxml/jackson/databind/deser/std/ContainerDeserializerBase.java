package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class ContainerDeserializerBase<T>
  extends StdDeserializer<T>
{
  protected ContainerDeserializerBase(JavaType selfType)
  {
    super(selfType);
  }
  
  @Deprecated
  protected ContainerDeserializerBase(Class<?> selfType)
  {
    super(selfType);
  }
  
  public SettableBeanProperty findBackReference(String refName)
  {
    JsonDeserializer<Object> valueDeser = getContentDeserializer();
    if (valueDeser == null) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + refName + "': type: container deserializer of type " + getClass().getName() + " returned null for 'getContentDeserializer()'");
    }
    return valueDeser.findBackReference(refName);
  }
  
  public abstract JavaType getContentType();
  
  public abstract JsonDeserializer<Object> getContentDeserializer();
  
  protected void wrapAndThrow(Throwable t, Object ref, String key)
    throws IOException
  {
    while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    if (((t instanceof IOException)) && (!(t instanceof JsonMappingException))) {
      throw ((IOException)t);
    }
    throw JsonMappingException.wrapWithPath(t, ref, key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */