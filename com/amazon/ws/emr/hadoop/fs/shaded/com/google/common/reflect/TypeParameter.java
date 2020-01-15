package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

@Beta
public abstract class TypeParameter<T>
  extends TypeCapture<T>
{
  final TypeVariable<?> typeVariable;
  
  protected TypeParameter()
  {
    Type type = capture();
    Preconditions.checkArgument(type instanceof TypeVariable, "%s should be a type variable.", new Object[] { type });
    typeVariable = ((TypeVariable)type);
  }
  
  public final int hashCode()
  {
    return typeVariable.hashCode();
  }
  
  public final boolean equals(@Nullable Object o)
  {
    if ((o instanceof TypeParameter))
    {
      TypeParameter<?> that = (TypeParameter)o;
      return typeVariable.equals(typeVariable);
    }
    return false;
  }
  
  public String toString()
  {
    return typeVariable.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeParameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */