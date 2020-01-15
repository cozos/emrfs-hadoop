package com.amazon.ws.emr.hadoop.fs.dynamodb;

import java.util.Collection;

public abstract interface EntityStoreManager<T extends Entity>
{
  public abstract Collection<EntityStore<T>> describeEntityStores();
  
  public abstract EntityStore<T> getEntityStore(String paramString, boolean paramBoolean);
  
  public abstract void destroyEntityStore(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStoreManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */