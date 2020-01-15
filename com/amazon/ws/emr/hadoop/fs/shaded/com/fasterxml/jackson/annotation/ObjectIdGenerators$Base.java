package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

abstract class ObjectIdGenerators$Base<T>
  extends ObjectIdGenerator<T>
{
  protected final Class<?> _scope;
  
  protected ObjectIdGenerators$Base(Class<?> scope)
  {
    _scope = scope;
  }
  
  public final Class<?> getScope()
  {
    return _scope;
  }
  
  public boolean canUseFor(ObjectIdGenerator<?> gen)
  {
    return (gen.getClass() == getClass()) && (gen.getScope() == _scope);
  }
  
  public abstract T generateId(Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */