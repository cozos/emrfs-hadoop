package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type;

import java.lang.reflect.Type;

public abstract class TypeReference<T>
  implements Comparable<TypeReference<T>>
{
  protected final Type _type;
  
  protected TypeReference()
  {
    Type superClass = getClass().getGenericSuperclass();
    if ((superClass instanceof Class)) {
      throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }
    _type = ((java.lang.reflect.ParameterizedType)superClass).getActualTypeArguments()[0];
  }
  
  public Type getType()
  {
    return _type;
  }
  
  public int compareTo(TypeReference<T> o)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */