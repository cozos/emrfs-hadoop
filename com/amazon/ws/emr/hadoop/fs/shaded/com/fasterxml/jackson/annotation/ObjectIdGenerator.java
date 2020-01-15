package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

import java.io.Serializable;

public abstract class ObjectIdGenerator<T>
  implements Serializable
{
  public abstract Class<?> getScope();
  
  public abstract boolean canUseFor(ObjectIdGenerator<?> paramObjectIdGenerator);
  
  public boolean maySerializeAsObject()
  {
    return false;
  }
  
  public boolean isValidReferencePropertyName(String name, Object parser)
  {
    return false;
  }
  
  public abstract ObjectIdGenerator<T> forScope(Class<?> paramClass);
  
  public abstract ObjectIdGenerator<T> newForSerialization(Object paramObject);
  
  public abstract IdKey key(Object paramObject);
  
  public abstract T generateId(Object paramObject);
  
  public static final class IdKey
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public final Class<?> type;
    public final Class<?> scope;
    public final Object key;
    private final int hashCode;
    
    public IdKey(Class<?> type, Class<?> scope, Object key)
    {
      if (key == null) {
        throw new IllegalArgumentException("Can not construct IdKey for null key");
      }
      this.type = type;
      this.scope = scope;
      this.key = key;
      
      int h = key.hashCode() + type.getName().hashCode();
      if (scope != null) {
        h ^= scope.getName().hashCode();
      }
      hashCode = h;
    }
    
    public int hashCode()
    {
      return hashCode;
    }
    
    public boolean equals(Object o)
    {
      if (o == this) {
        return true;
      }
      if (o == null) {
        return false;
      }
      if (o.getClass() != getClass()) {
        return false;
      }
      IdKey other = (IdKey)o;
      return (key.equals(key)) && (type == type) && (scope == scope);
    }
    
    public String toString()
    {
      return String.format("[ObjectId: key=%s, type=%s, scope=%s]", new Object[] { key, type == null ? "NONE" : type.getName(), scope == null ? "NONE" : scope.getName() });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */