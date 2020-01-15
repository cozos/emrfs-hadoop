package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

class TypeToken$1
  extends Invokable.MethodInvokable<T>
{
  TypeToken$1(TypeToken paramTypeToken, Method x0)
  {
    super(x0);
  }
  
  Type getGenericReturnType()
  {
    return this$0.resolveType(super.getGenericReturnType()).getType();
  }
  
  Type[] getGenericParameterTypes()
  {
    return TypeToken.access$000(this$0, super.getGenericParameterTypes());
  }
  
  Type[] getGenericExceptionTypes()
  {
    return TypeToken.access$000(this$0, super.getGenericExceptionTypes());
  }
  
  public TypeToken<T> getOwnerType()
  {
    return this$0;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(getOwnerType()));String str2 = String.valueOf(String.valueOf(super.toString()));return 1 + str1.length() + str2.length() + str1 + "." + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */