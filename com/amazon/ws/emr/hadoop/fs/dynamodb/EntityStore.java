package com.amazon.ws.emr.hadoop.fs.dynamodb;

import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import java.util.Collection;

public abstract interface EntityStore<T extends Entity>
  extends AutoCloseable
{
  public abstract String getTableName();
  
  public abstract void create(T paramT)
    throws EntityStoreException;
  
  public abstract void create(Collection<T> paramCollection)
    throws EntityStoreException;
  
  public abstract void update(T paramT)
    throws EntityStoreException;
  
  public abstract T retrieve(ItemKey paramItemKey);
  
  public abstract void delete(T paramT)
    throws EntityStoreException;
  
  public abstract void delete(ItemKey paramItemKey)
    throws EntityStoreException;
  
  public abstract void delete(Collection<ItemKey> paramCollection)
    throws EntityStoreException;
  
  public abstract Iterable<T> dump()
    throws EntityStoreException;
  
  public abstract Iterable<T> dump(ItemKeyCondition paramItemKeyCondition)
    throws EntityStoreException;
  
  public abstract Iterable<T> list(ItemKey paramItemKey);
  
  public abstract Iterable<T> list(ItemKey paramItemKey1, boolean paramBoolean1, ItemKey paramItemKey2, boolean paramBoolean2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */