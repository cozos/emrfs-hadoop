package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TableWriteItems
{
  private final String tableName;
  private List<PrimaryKey> primaryKeysToDelete;
  private Collection<Item> itemsToPut;
  
  public TableWriteItems(String tableName)
  {
    if ((tableName == null) || (tableName.trim().length() == 0)) {
      throw new IllegalArgumentException("table name must not be null or empty");
    }
    this.tableName = tableName;
  }
  
  public List<PrimaryKey> getPrimaryKeysToDelete()
  {
    return primaryKeysToDelete;
  }
  
  public TableWriteItems withPrimaryKeysToDelete(PrimaryKey... primaryKeysToDelete)
  {
    if (primaryKeysToDelete == null)
    {
      this.primaryKeysToDelete = null;
    }
    else
    {
      Set<String> pkNameSet = null;
      for (PrimaryKey pk : primaryKeysToDelete) {
        if (pkNameSet == null) {
          pkNameSet = pk.getComponentNameSet();
        } else if (!pkNameSet.equals(pk.getComponentNameSet())) {
          throw new IllegalArgumentException("primary key attribute names must be consistent for the specified primary keys");
        }
      }
      this.primaryKeysToDelete = new ArrayList(Arrays.asList(primaryKeysToDelete));
    }
    return this;
  }
  
  public TableWriteItems withHashOnlyKeysToDelete(String hashKeyName, Object... hashKeyValues)
  {
    if (hashKeyName == null) {
      throw new IllegalArgumentException();
    }
    PrimaryKey[] primaryKeys = new PrimaryKey[hashKeyValues.length];
    for (int i = 0; i < hashKeyValues.length; i++) {
      primaryKeys[i] = new PrimaryKey(hashKeyName, hashKeyValues[i]);
    }
    return withPrimaryKeysToDelete(primaryKeys);
  }
  
  public TableWriteItems withHashAndRangeKeysToDelete(String hashKeyName, String rangeKeyName, Object... alternatingHashAndRangeKeyValues)
  {
    if (hashKeyName == null) {
      throw new IllegalArgumentException("hash key name must be specified");
    }
    if (rangeKeyName == null) {
      throw new IllegalArgumentException("range key name must be specified");
    }
    if (alternatingHashAndRangeKeyValues.length % 2 != 0) {
      throw new IllegalArgumentException("number of hash and range key values must be the same");
    }
    int len = alternatingHashAndRangeKeyValues.length / 2;
    PrimaryKey[] primaryKeys = new PrimaryKey[len];
    for (int i = 0; i < alternatingHashAndRangeKeyValues.length; i += 2) {
      primaryKeys[(i >> 1)] = new PrimaryKey(hashKeyName, alternatingHashAndRangeKeyValues[i], rangeKeyName, alternatingHashAndRangeKeyValues[(i + 1)]);
    }
    return withPrimaryKeysToDelete(primaryKeys);
  }
  
  public TableWriteItems addPrimaryKeyToDelete(PrimaryKey primaryKey)
  {
    if (primaryKey != null)
    {
      if (primaryKeysToDelete == null) {
        primaryKeysToDelete = new ArrayList();
      }
      checkConsistency(primaryKey);
      primaryKeysToDelete.add(primaryKey);
    }
    return this;
  }
  
  private void checkConsistency(PrimaryKey primaryKey)
  {
    if (primaryKeysToDelete.size() > 0)
    {
      Set<String> nameSet = ((PrimaryKey)primaryKeysToDelete.get(0)).getComponentNameSet();
      if (!nameSet.equals(primaryKey.getComponentNameSet())) {
        throw new IllegalArgumentException("primary key must be added with consistent key attribute name(s)");
      }
    }
  }
  
  public TableWriteItems addHashOnlyPrimaryKeyToDelete(String hashKeyName, Object hashKeyValue)
  {
    addPrimaryKeyToDelete(new PrimaryKey(hashKeyName, hashKeyValue));
    return this;
  }
  
  public TableWriteItems addHashOnlyPrimaryKeysToDelete(String hashKeyName, Object... hashKeyValues)
  {
    for (Object hashKeyValue : hashKeyValues) {
      addPrimaryKeyToDelete(new PrimaryKey(hashKeyName, hashKeyValue));
    }
    return this;
  }
  
  public TableWriteItems addHashAndRangePrimaryKeysToDelete(String hashKeyName, String rangeKeyName, Object... alternatingHashRangeKeyValues)
  {
    if (alternatingHashRangeKeyValues.length % 2 != 0) {
      throw new IllegalArgumentException("The multiple hash and range key values must alternate");
    }
    for (int i = 0; i < alternatingHashRangeKeyValues.length; i += 2)
    {
      Object hashKeyValue = alternatingHashRangeKeyValues[i];
      Object rangeKeyValue = alternatingHashRangeKeyValues[(i + 1)];
      addPrimaryKeyToDelete(new PrimaryKey()
      
        .addComponent(hashKeyName, hashKeyValue)
        .addComponent(rangeKeyName, rangeKeyValue));
    }
    return this;
  }
  
  public TableWriteItems addHashAndRangePrimaryKeyToDelete(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    addPrimaryKeyToDelete(new PrimaryKey()
    
      .addComponent(hashKeyName, hashKeyValue)
      .addComponent(rangeKeyName, rangeKeyValue));
    return this;
  }
  
  public TableWriteItems withItemsToPut(Item... itemsToPut)
  {
    if (itemsToPut == null) {
      this.itemsToPut = null;
    } else {
      this.itemsToPut = new ArrayList(Arrays.asList(itemsToPut));
    }
    return this;
  }
  
  public TableWriteItems withItemsToPut(Collection<Item> itemsToPut)
  {
    if (itemsToPut == null) {
      this.itemsToPut = null;
    } else {
      this.itemsToPut = new ArrayList(itemsToPut);
    }
    return this;
  }
  
  public Collection<Item> getItemsToPut()
  {
    return itemsToPut == null ? null : 
    
      Collections.unmodifiableCollection(itemsToPut);
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public TableWriteItems addItemToPut(Item item)
  {
    if (item != null)
    {
      if (itemsToPut == null) {
        itemsToPut = new ArrayList();
      }
      itemsToPut.add(item);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableWriteItems
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */