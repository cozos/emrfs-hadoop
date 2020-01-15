package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$2
  implements ObjectConstructor<T>
{
  ConstructorConstructor$2(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType) {}
  
  public T construct()
  {
    return (T)val$rawTypeCreator.createInstance(val$type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ConstructorConstructor.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */