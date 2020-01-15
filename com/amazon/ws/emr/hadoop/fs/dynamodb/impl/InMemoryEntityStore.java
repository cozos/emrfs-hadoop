package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKeyCondition;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class InMemoryEntityStore
  implements EntityStore<Entity>
{
  private final ConcurrentSkipListMap<ItemKey, Entity> db = new ConcurrentSkipListMap();
  private boolean conditionalUpdate = false;
  private String tableName;
  private final long atomicCounterInitialValue = 1L;
  
  public boolean isConditionalUpdate()
  {
    return conditionalUpdate;
  }
  
  public void setConditionalUpdate(boolean conditionalUpdate)
  {
    this.conditionalUpdate = conditionalUpdate;
  }
  
  public InMemoryEntityStore withConditionalUpdate(boolean conditionalUpdate)
  {
    setConditionalUpdate(conditionalUpdate);
    return this;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public InMemoryEntityStore withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public synchronized void create(Entity entity)
    throws EntityStoreException
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    
    Preconditions.checkNotNull(entity.getPayload(), "must supply a payload");
    Preconditions.checkArgument(entity.getPayload().length > 0, "payload must have positive size");
    
    String hashKey = entity.getItemKey().getHashKey();
    String rangeKey = entity.getItemKey().getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Create: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Create: range key cannot be empty");
    if (db.containsKey(entity.getItemKey())) {
      throw new EntityStoreException(String.format("Item already exists: '%s'", new Object[] { entity.getItemKey() }), EntityStoreExceptionCode.ALREADY_EXISTS);
    }
    Entity copy = new Entity(entity);
    copy.setLastModified(Long.valueOf(DateTime.now().getMillis()));
    copy.setCounter(conditionalUpdate ? Long.valueOf(1L) : null);
    copy.setDeletionTTL(0L);
    if (copy.getPayload() == null) {
      copy.setPayload(new byte[0]);
    }
    db.put(copy.getItemKey(), copy);
  }
  
  public synchronized void create(Collection<Entity> entities)
  {
    Preconditions.checkNotNull(entities, "entities must have a value");
    for (Entity e : entities) {
      Preconditions.checkNotNull(e, "entity must have a value");
    }
    for (Entity e : entities) {
      create(e);
    }
  }
  
  public synchronized void update(Entity entity)
    throws EntityStoreException
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    String hashKey = entity.getItemKey().getHashKey();
    String rangeKey = entity.getItemKey().getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Update: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Update: range key cannot be empty");
    if (!db.containsKey(entity.getItemKey())) {
      throw new EntityStoreException(String.format("Item doesn't already exist: '%s'", new Object[] { entity.getItemKey() }), EntityStoreExceptionCode.STALE_ENTITY);
    }
    Entity existing = (Entity)db.get(entity.getItemKey());
    if ((conditionalUpdate) && (entity.getCounter() != existing.getCounter())) {
      throw new EntityStoreException(String.format("Stale data: '%s'", new Object[] { entity }), EntityStoreExceptionCode.STALE_ENTITY);
    }
    existing.setLastModified(Long.valueOf(DateTime.now().getMillis()));
    existing.setPayload(entity.getPayload() == null ? new byte[0] : entity.getPayload());
    existing.setDeletionTTL(entity.getDeletionTTL().longValue());
    if (conditionalUpdate) {
      existing.setCounter(Long.valueOf(existing.getCounter() == null ? 1L : existing.getCounter().longValue() + 1L));
    }
  }
  
  public Entity retrieve(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    String hashKey = itemKey.getHashKey();
    String rangeKey = itemKey.getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Retrieve: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Retrieve: range key cannot be empty");
    
    return db.get(itemKey) == null ? null : new Entity((Entity)db.get(itemKey));
  }
  
  public synchronized void delete(Entity entity)
    throws EntityStoreException
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    String hashKey = entity.getItemKey().getHashKey();
    String rangeKey = entity.getItemKey().getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Delete: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Delete: range key cannot be empty");
    if (!db.containsKey(entity.getItemKey())) {
      return;
    }
    Entity existing = (Entity)db.get(entity.getItemKey());
    if ((conditionalUpdate) && (entity.getCounter() != existing.getCounter())) {
      throw new EntityStoreException(String.format("Stale data: '%s'", new Object[] { entity }), EntityStoreExceptionCode.STALE_ENTITY);
    }
    db.remove(entity.getItemKey());
  }
  
  public synchronized void delete(ItemKey itemKey)
    throws EntityStoreException
  {
    delete(new Entity(itemKey));
  }
  
  public synchronized void delete(Collection<ItemKey> itemKeys)
    throws EntityStoreException
  {
    Preconditions.checkNotNull(itemKeys, "itemKeys must have a value");
    for (ItemKey itemKey : itemKeys) {
      Preconditions.checkNotNull(itemKey, "itemKey must have a value");
    }
    for (ItemKey itemKey : itemKeys)
    {
      String hashKey = itemKey.getHashKey();
      String rangeKey = itemKey.getRangeKey();
      Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Delete: hash key cannot be empty");
      Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Delete: range key cannot be empty");
      if (!db.containsKey(itemKey)) {
        return;
      }
      db.remove(itemKey);
    }
  }
  
  public Iterable<Entity> dump()
  {
    ArrayList<Entity> results = new ArrayList(db.values().size());
    results.addAll(db.values());
    return results;
  }
  
  public Iterable<Entity> dump(final ItemKeyCondition condition)
  {
    final String conditionalRangeKey = condition.getItemKey().getRangeKey();
    final String conditionalHashKey = condition.getItemKey().getHashKey();
    Iterables.filter(dump(), new Predicate()
    {
      public boolean apply(Entity input)
      {
        ItemKey itemKey = input.getItemKey();
        switch (InMemoryEntityStore.2.$SwitchMap$com$amazon$ws$emr$hadoop$fs$dynamodb$Condition[condition.getCondition().ordinal()])
        {
        case 1: 
          if ((!Strings.isNullOrEmpty(conditionalRangeKey)) && (!itemKey.getRangeKey().startsWith(conditionalRangeKey))) {
            return false;
          }
          return itemKey.getHashKey().startsWith(conditionalHashKey);
        case 2: 
          if ((!Strings.isNullOrEmpty(conditionalRangeKey)) && (!itemKey.getRangeKey().equals(conditionalRangeKey))) {
            return false;
          }
          return itemKey.getHashKey().equals(conditionalHashKey);
        }
        throw new UnsupportedOperationException();
      }
    });
  }
  
  public Iterable<Entity> list(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    if (!Strings.isNullOrEmpty(itemKey.getRangeKey()))
    {
      ArrayList<Entity> ret = Lists.newArrayList();
      if (db.containsKey(itemKey)) {
        ret.add(new Entity((Entity)db.get(itemKey)));
      }
      return ret;
    }
    ItemKey startKey = new ItemKey(itemKey.getHashKey(), "");
    StringBuilder nextHashKeyBuilder = new StringBuilder(itemKey.getHashKey());
    nextHashKeyBuilder.append('\000');
    ItemKey endKey = new ItemKey(nextHashKeyBuilder.toString(), "");
    return list(startKey, true, endKey, false);
  }
  
  public Iterable<Entity> list(ItemKey startKey, boolean startKeyInclusive, ItemKey endKey, boolean endKeyInclusive)
  {
    Preconditions.checkNotNull(startKey, "Start key cannot be null");
    Preconditions.checkNotNull(endKey, "End key cannot be null");
    ArrayList<Entity> ret = Lists.newArrayList();
    for (Entity entity : db.subMap(startKey, startKeyInclusive, endKey, endKeyInclusive).values()) {
      ret.add(new Entity(entity));
    }
    return ret;
  }
  
  public void close() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.InMemoryEntityStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */