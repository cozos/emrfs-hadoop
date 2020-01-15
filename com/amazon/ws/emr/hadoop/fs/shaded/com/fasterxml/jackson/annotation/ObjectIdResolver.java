package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public abstract interface ObjectIdResolver
{
  public abstract void bindItem(ObjectIdGenerator.IdKey paramIdKey, Object paramObject);
  
  public abstract Object resolveId(ObjectIdGenerator.IdKey paramIdKey);
  
  public abstract ObjectIdResolver newForDeserialization(Object paramObject);
  
  public abstract boolean canUseFor(ObjectIdResolver paramObjectIdResolver);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */