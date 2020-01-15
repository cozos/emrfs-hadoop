package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public final class ObjectIdGenerators$IntSequenceGenerator
  extends ObjectIdGenerators.Base<Integer>
{
  private static final long serialVersionUID = 1L;
  protected transient int _nextValue;
  
  public ObjectIdGenerators$IntSequenceGenerator()
  {
    this(Object.class, -1);
  }
  
  public ObjectIdGenerators$IntSequenceGenerator(Class<?> scope, int fv)
  {
    super(scope);
    _nextValue = fv;
  }
  
  protected int initialValue()
  {
    return 1;
  }
  
  public ObjectIdGenerator<Integer> forScope(Class<?> scope)
  {
    return _scope == scope ? this : new IntSequenceGenerator(scope, _nextValue);
  }
  
  public ObjectIdGenerator<Integer> newForSerialization(Object context)
  {
    return new IntSequenceGenerator(_scope, initialValue());
  }
  
  public ObjectIdGenerator.IdKey key(Object key)
  {
    if (key == null) {
      return null;
    }
    return new ObjectIdGenerator.IdKey(getClass(), _scope, key);
  }
  
  public Integer generateId(Object forPojo)
  {
    if (forPojo == null) {
      return null;
    }
    int id = _nextValue;
    _nextValue += 1;
    return Integer.valueOf(id);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */