package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.util.UUID;

public class ObjectIdGenerators
{
  private static abstract class Base<T>
    extends ObjectIdGenerator<T>
  {
    protected final Class<?> _scope;
    
    protected Base(Class<?> scope)
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
  
  public static abstract class None
    extends ObjectIdGenerator<Object>
  {}
  
  public static abstract class PropertyGenerator
    extends ObjectIdGenerators.Base<Object>
  {
    private static final long serialVersionUID = 1L;
    
    protected PropertyGenerator(Class<?> scope)
    {
      super();
    }
  }
  
  public static final class IntSequenceGenerator
    extends ObjectIdGenerators.Base<Integer>
  {
    private static final long serialVersionUID = 1L;
    protected transient int _nextValue;
    
    public IntSequenceGenerator()
    {
      this(Object.class, -1);
    }
    
    public IntSequenceGenerator(Class<?> scope, int fv)
    {
      super();
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
  
  public static final class UUIDGenerator
    extends ObjectIdGenerators.Base<UUID>
  {
    private static final long serialVersionUID = 1L;
    
    public UUIDGenerator()
    {
      this(Object.class);
    }
    
    private UUIDGenerator(Class<?> scope)
    {
      super();
    }
    
    public ObjectIdGenerator<UUID> forScope(Class<?> scope)
    {
      return this;
    }
    
    public ObjectIdGenerator<UUID> newForSerialization(Object context)
    {
      return this;
    }
    
    public UUID generateId(Object forPojo)
    {
      return UUID.randomUUID();
    }
    
    public ObjectIdGenerator.IdKey key(Object key)
    {
      if (key == null) {
        return null;
      }
      return new ObjectIdGenerator.IdKey(getClass(), null, key);
    }
    
    public boolean canUseFor(ObjectIdGenerator<?> gen)
    {
      return gen.getClass() == getClass();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */