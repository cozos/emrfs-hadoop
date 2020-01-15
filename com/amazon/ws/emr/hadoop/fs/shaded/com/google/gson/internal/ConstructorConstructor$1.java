package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$1
  implements ObjectConstructor<T>
{
  ConstructorConstructor$1(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return (T)val$typeCreator.createInstance(val$type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ConstructorConstructor.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */