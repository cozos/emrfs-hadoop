package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TableKeysAndAttributes
{
  private final String tableName;
  private List<PrimaryKey> primaryKeys;
  private Set<String> attributeNames;
  private boolean consistentRead;
  private String projectionExpression;
  private Map<String, String> nameMap;
  
  public TableKeysAndAttributes(String tableName)
  {
    if ((tableName == null) || (tableName.trim().length() == 0)) {
      throw new IllegalArgumentException("table name must not be null or empty");
    }
    this.tableName = tableName;
  }
  
  public List<PrimaryKey> getPrimaryKeys()
  {
    return primaryKeys;
  }
  
  public TableKeysAndAttributes withPrimaryKeys(PrimaryKey... primaryKeys)
  {
    if (primaryKeys == null)
    {
      this.primaryKeys = null;
    }
    else
    {
      Set<String> pkNameSet = null;
      for (PrimaryKey pk : primaryKeys) {
        if (pkNameSet == null) {
          pkNameSet = pk.getComponentNameSet();
        } else if (!pkNameSet.equals(pk.getComponentNameSet())) {
          throw new IllegalArgumentException("primary key attribute names must be consistent for the specified primary keys");
        }
      }
      this.primaryKeys = new ArrayList(Arrays.asList(primaryKeys));
    }
    return this;
  }
  
  public TableKeysAndAttributes withHashOnlyKeys(String hashKeyName, Object... hashKeyValues)
  {
    if (hashKeyName == null) {
      throw new IllegalArgumentException();
    }
    PrimaryKey[] primaryKeys = new PrimaryKey[hashKeyValues.length];
    for (int i = 0; i < hashKeyValues.length; i++) {
      primaryKeys[i] = new PrimaryKey(hashKeyName, hashKeyValues[i]);
    }
    return withPrimaryKeys(primaryKeys);
  }
  
  public TableKeysAndAttributes withHashAndRangeKeys(String hashKeyName, String rangeKeyName, Object... alternatingHashAndRangeKeyValues)
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
    return withPrimaryKeys(primaryKeys);
  }
  
  public TableKeysAndAttributes addPrimaryKey(PrimaryKey primaryKey)
  {
    if (primaryKey != null)
    {
      if (primaryKeys == null) {
        primaryKeys = new ArrayList();
      }
      checkConsistency(primaryKey);
      primaryKeys.add(primaryKey);
    }
    return this;
  }
  
  private void checkConsistency(PrimaryKey primaryKey)
  {
    if (primaryKeys.size() > 0)
    {
      Set<String> nameSet = ((PrimaryKey)primaryKeys.get(0)).getComponentNameSet();
      if (!nameSet.equals(primaryKey.getComponentNameSet())) {
        throw new IllegalArgumentException("primary key must be added with consistent key attribute name(s)");
      }
    }
  }
  
  public TableKeysAndAttributes addHashOnlyPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    addPrimaryKey(new PrimaryKey(hashKeyName, hashKeyValue));
    return this;
  }
  
  public TableKeysAndAttributes addHashOnlyPrimaryKeys(String hashKeyName, Object... hashKeyValues)
  {
    for (Object hashKeyValue : hashKeyValues) {
      addPrimaryKey(new PrimaryKey(hashKeyName, hashKeyValue));
    }
    return this;
  }
  
  public TableKeysAndAttributes addHashAndRangePrimaryKeys(String hashKeyName, String rangeKeyName, Object... alternatingHashRangeKeyValues)
  {
    if (alternatingHashRangeKeyValues.length % 2 != 0) {
      throw new IllegalArgumentException("The multiple hash and range key values must alternate");
    }
    for (int i = 0; i < alternatingHashRangeKeyValues.length; i += 2)
    {
      Object hashKeyValue = alternatingHashRangeKeyValues[i];
      Object rangeKeyValue = alternatingHashRangeKeyValues[(i + 1)];
      addPrimaryKey(new PrimaryKey()
      
        .addComponent(hashKeyName, hashKeyValue)
        .addComponent(rangeKeyName, rangeKeyValue));
    }
    return this;
  }
  
  public TableKeysAndAttributes addHashAndRangePrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    addPrimaryKey(new PrimaryKey()
    
      .addComponent(hashKeyName, hashKeyValue)
      .addComponent(rangeKeyName, rangeKeyValue));
    return this;
  }
  
  @Deprecated
  public TableKeysAndAttributes withAttrbuteNames(String... attributeNames)
  {
    return withAttributeNames(attributeNames);
  }
  
  @Deprecated
  public TableKeysAndAttributes withAttrbuteNames(List<String> attributeNames)
  {
    return withAttributeNames(attributeNames);
  }
  
  public TableKeysAndAttributes withAttributeNames(String... attributeNames)
  {
    if (attributeNames == null) {
      this.attributeNames = null;
    } else {
      this.attributeNames = Collections.unmodifiableSet(new LinkedHashSet(
        Arrays.asList(attributeNames)));
    }
    return this;
  }
  
  public TableKeysAndAttributes withAttributeNames(List<String> attributeNames)
  {
    if (attributeNames == null) {
      this.attributeNames = null;
    } else {
      this.attributeNames = Collections.unmodifiableSet(new LinkedHashSet(attributeNames));
    }
    return this;
  }
  
  public Set<String> getAttributeNames()
  {
    return attributeNames;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public boolean isConsistentRead()
  {
    return consistentRead;
  }
  
  public TableKeysAndAttributes withConsistentRead(boolean consistentRead)
  {
    this.consistentRead = consistentRead;
    return this;
  }
  
  public String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public TableKeysAndAttributes withProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
    return this;
  }
  
  public Map<String, String> getNameMap()
  {
    return nameMap;
  }
  
  public TableKeysAndAttributes withNameMap(Map<String, String> nameMap)
  {
    this.nameMap = (nameMap == null ? null : Collections.unmodifiableMap(new LinkedHashMap(nameMap)));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */