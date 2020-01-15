package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.util.UUID;

public final class ObjectIdGenerators$UUIDGenerator
  extends ObjectIdGenerators.Base<UUID>
{
  private static final long serialVersionUID = 1L;
  
  public ObjectIdGenerators$UUIDGenerator()
  {
    this(Object.class);
  }
  
  private ObjectIdGenerators$UUIDGenerator(Class<?> scope)
  {
    super(Object.class);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */