package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import java.lang.reflect.Type;
import java.util.Map;

public abstract class Diff<T>
  extends Pair<T, T>
{
  private static final long serialVersionUID = 1L;
  private final Type type;
  private final String fieldName;
  
  protected Diff(String fieldName)
  {
    type = ((Type)ObjectUtils.defaultIfNull(TypeUtils.getTypeArguments(getClass(), Diff.class).get(Diff.class.getTypeParameters()[0]), Object.class));
    
    this.fieldName = fieldName;
  }
  
  public final Type getType()
  {
    return type;
  }
  
  public final String getFieldName()
  {
    return fieldName;
  }
  
  public final String toString()
  {
    return String.format("[%s: %s, %s]", new Object[] { fieldName, getLeft(), getRight() });
  }
  
  public final T setValue(T value)
  {
    throw new UnsupportedOperationException("Cannot alter Diff object.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.Diff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */