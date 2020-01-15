package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProjectionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class DynamoDBMapperTableModel<T>
  implements DynamoDBTypeConverter<Map<String, AttributeValue>, T>
{
  private final Map<String, GlobalSecondaryIndex> globalSecondaryIndexes;
  private final Map<String, LocalSecondaryIndex> localSecondaryIndexes;
  private final Map<String, DynamoDBMapperFieldModel<T, Object>> versions;
  private final Map<String, DynamoDBMapperFieldModel<T, Object>> fields;
  private final Map<KeyType, DynamoDBMapperFieldModel<T, Object>> keys;
  private final Properties<T> properties;
  private final Class<T> targetType;
  
  private DynamoDBMapperTableModel(Builder<T> builder)
  {
    globalSecondaryIndexes = builder.globalSecondaryIndexes();
    localSecondaryIndexes = builder.localSecondaryIndexes();
    versions = builder.versions();
    fields = builder.fields();
    keys = builder.keys();
    properties = properties;
    targetType = targetType;
  }
  
  public Class<T> targetType()
  {
    return targetType;
  }
  
  public Collection<DynamoDBMapperFieldModel<T, Object>> fields()
  {
    return fields.values();
  }
  
  public <V> DynamoDBMapperFieldModel<T, V> field(String attributeName)
  {
    DynamoDBMapperFieldModel<T, V> field = (DynamoDBMapperFieldModel)fields.get(attributeName);
    if (field == null) {
      throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + attributeName + "]; no mapping for attribute by name");
    }
    return field;
  }
  
  public Collection<DynamoDBMapperFieldModel<T, Object>> keys()
  {
    return keys.values();
  }
  
  public <H> DynamoDBMapperFieldModel<T, H> hashKey()
  {
    DynamoDBMapperFieldModel<T, H> field = (DynamoDBMapperFieldModel)keys.get(KeyType.HASH);
    if (field == null) {
      throw new DynamoDBMappingException(targetType.getSimpleName() + "; no mapping for HASH key");
    }
    return field;
  }
  
  public <R> DynamoDBMapperFieldModel<T, R> rangeKey()
  {
    DynamoDBMapperFieldModel<T, R> field = (DynamoDBMapperFieldModel)keys.get(KeyType.RANGE);
    if (field == null) {
      throw new DynamoDBMappingException(targetType.getSimpleName() + "; no mapping for RANGE key");
    }
    return field;
  }
  
  public <R> DynamoDBMapperFieldModel<T, R> rangeKeyIfExists()
  {
    return (DynamoDBMapperFieldModel)keys.get(KeyType.RANGE);
  }
  
  public Collection<DynamoDBMapperFieldModel<T, Object>> versions()
  {
    return versions.values();
  }
  
  public boolean versioned()
  {
    return !versions.isEmpty();
  }
  
  public Collection<GlobalSecondaryIndex> globalSecondaryIndexes()
  {
    if (globalSecondaryIndexes.isEmpty()) {
      return null;
    }
    Collection<GlobalSecondaryIndex> copies = new ArrayList(globalSecondaryIndexes.size());
    for (String indexName : globalSecondaryIndexes.keySet()) {
      copies.add(globalSecondaryIndex(indexName));
    }
    return copies;
  }
  
  public GlobalSecondaryIndex globalSecondaryIndex(String indexName)
  {
    if (!globalSecondaryIndexes.containsKey(indexName)) {
      return null;
    }
    GlobalSecondaryIndex gsi = (GlobalSecondaryIndex)globalSecondaryIndexes.get(indexName);
    GlobalSecondaryIndex copy = new GlobalSecondaryIndex().withIndexName(gsi.getIndexName());
    copy.withProjection(new Projection().withProjectionType(gsi.getProjection().getProjectionType()));
    for (KeySchemaElement key : gsi.getKeySchema()) {
      copy.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(key.getAttributeName(), key.getKeyType()) });
    }
    return copy;
  }
  
  public Collection<LocalSecondaryIndex> localSecondaryIndexes()
  {
    if (localSecondaryIndexes.isEmpty()) {
      return null;
    }
    Collection<LocalSecondaryIndex> copies = new ArrayList(localSecondaryIndexes.size());
    for (String indexName : localSecondaryIndexes.keySet()) {
      copies.add(localSecondaryIndex(indexName));
    }
    return copies;
  }
  
  public LocalSecondaryIndex localSecondaryIndex(String indexName)
  {
    if (!localSecondaryIndexes.containsKey(indexName)) {
      return null;
    }
    LocalSecondaryIndex lsi = (LocalSecondaryIndex)localSecondaryIndexes.get(indexName);
    LocalSecondaryIndex copy = new LocalSecondaryIndex().withIndexName(lsi.getIndexName());
    copy.withProjection(new Projection().withProjectionType(lsi.getProjection().getProjectionType()));
    for (KeySchemaElement key : lsi.getKeySchema()) {
      copy.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(key.getAttributeName(), key.getKeyType()) });
    }
    return copy;
  }
  
  public Map<String, AttributeValue> convert(T object)
  {
    Map<String, AttributeValue> map = new LinkedHashMap();
    for (DynamoDBMapperFieldModel<T, Object> field : fields()) {
      try
      {
        AttributeValue value = field.getAndConvert(object);
        if (value != null) {
          map.put(field.name(), value);
        }
      }
      catch (RuntimeException e)
      {
        throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + field.name() + "]; could not convert attribute", e);
      }
    }
    return map;
  }
  
  public T unconvert(Map<String, AttributeValue> object)
  {
    T result = StandardBeanProperties.DeclaringReflect.newInstance(targetType);
    if (!object.isEmpty()) {
      for (DynamoDBMapperFieldModel<T, Object> field : fields()) {
        try
        {
          AttributeValue value = (AttributeValue)object.get(field.name());
          if (value != null) {
            field.unconvertAndSet(result, value);
          }
        }
        catch (RuntimeException e)
        {
          throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + field.name() + "]; could not unconvert attribute", e);
        }
      }
    }
    return result;
  }
  
  public <H, R> T createKey(H hashKey, R rangeKey)
  {
    T key = StandardBeanProperties.DeclaringReflect.newInstance(targetType);
    if (hashKey != null)
    {
      DynamoDBMapperFieldModel<T, H> hk = hashKey();
      hk.set(key, hashKey);
    }
    if (rangeKey != null)
    {
      DynamoDBMapperFieldModel<T, R> rk = rangeKey();
      rk.set(key, rangeKey);
    }
    return key;
  }
  
  public <H, R> Map<String, AttributeValue> convertKey(T key)
  {
    DynamoDBMapperFieldModel<T, H> hk = hashKey();
    DynamoDBMapperFieldModel<T, R> rk = rangeKeyIfExists();
    return convertKey(hk.get(key), rk == null ? null : rk.get(key));
  }
  
  public <H, R> Map<String, AttributeValue> convertKey(H hashKey, R rangeKey)
  {
    Map<String, AttributeValue> key = new LinkedHashMap(4);
    DynamoDBMapperFieldModel<T, H> hk = hashKey();
    AttributeValue hkValue = hashKey == null ? null : hk.convert(hashKey);
    if (hkValue != null) {
      key.put(hk.name(), hkValue);
    } else {
      throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + hk.name() + "]; no HASH key value present");
    }
    DynamoDBMapperFieldModel<T, R> rk = rangeKeyIfExists();
    AttributeValue rkValue = rangeKey == null ? null : rk.convert(rangeKey);
    if (rkValue != null) {
      key.put(rk.name(), rkValue);
    } else if (rk != null) {
      throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + rk.name() + "]; no RANGE key value present");
    }
    return key;
  }
  
  static class Builder<T>
  {
    private final Map<String, DynamoDBMapperFieldModel<T, Object>> versions;
    private final Map<String, DynamoDBMapperFieldModel<T, Object>> fields;
    private final Map<KeyType, DynamoDBMapperFieldModel<T, Object>> keys;
    private final DynamoDBMapperTableModel.Properties properties;
    private final Class<T> targetType;
    
    public Builder(Class<T> targetType, DynamoDBMapperTableModel.Properties<T> properties)
    {
      versions = new LinkedHashMap(4);
      fields = new LinkedHashMap();
      keys = new EnumMap(KeyType.class);
      this.properties = properties;
      this.targetType = targetType;
    }
    
    public Builder<T> with(DynamoDBMapperFieldModel<T, Object> field)
    {
      fields.put(field.name(), field);
      if (field.keyType() != null) {
        keys.put(field.keyType(), field);
      }
      if (field.versioned()) {
        versions.put(field.name(), field);
      }
      return this;
    }
    
    public Map<String, GlobalSecondaryIndex> globalSecondaryIndexes()
    {
      Map<String, GlobalSecondaryIndex> map = new LinkedHashMap();
      for (Iterator localIterator1 = fields.values().iterator(); localIterator1.hasNext();)
      {
        field = (DynamoDBMapperFieldModel)localIterator1.next();
        for (String indexName : field.globalSecondaryIndexNames(KeyType.HASH))
        {
          GlobalSecondaryIndex gsi = new GlobalSecondaryIndex().withIndexName(indexName);
          if (map.put(indexName, gsi) != null) {
            throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + field.name() + "]; must not duplicate GSI " + indexName);
          }
          gsi.withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY));
          gsi.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(field.name(), KeyType.HASH) });
        }
      }
      DynamoDBMapperFieldModel<T, Object> field;
      for (localIterator1 = fields.values().iterator(); localIterator1.hasNext();)
      {
        field = (DynamoDBMapperFieldModel)localIterator1.next();
        for (String indexName : field.globalSecondaryIndexNames(KeyType.RANGE))
        {
          GlobalSecondaryIndex gsi = (GlobalSecondaryIndex)map.get(indexName);
          if (gsi == null) {
            throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + field.name() + "]; no HASH key for GSI " + indexName);
          }
          gsi.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(field.name(), KeyType.RANGE) });
        }
      }
      DynamoDBMapperFieldModel<T, Object> field;
      if (map.isEmpty()) {
        return Collections.emptyMap();
      }
      return Collections.unmodifiableMap(map);
    }
    
    public Map<String, LocalSecondaryIndex> localSecondaryIndexes()
    {
      Map<String, LocalSecondaryIndex> map = new LinkedHashMap();
      for (Iterator localIterator1 = fields.values().iterator(); localIterator1.hasNext();)
      {
        field = (DynamoDBMapperFieldModel)localIterator1.next();
        for (String indexName : field.localSecondaryIndexNames())
        {
          LocalSecondaryIndex lsi = new LocalSecondaryIndex().withIndexName(indexName);
          if (map.put(indexName, lsi) != null) {
            throw new DynamoDBMappingException(targetType.getSimpleName() + "[" + field.name() + "]; must not duplicate LSI " + indexName);
          }
          lsi.withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY));
          lsi.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(((DynamoDBMapperFieldModel)keys.get(KeyType.HASH)).name(), KeyType.HASH) });
          lsi.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(field.name(), KeyType.RANGE) });
        }
      }
      DynamoDBMapperFieldModel<T, Object> field;
      if (map.isEmpty()) {
        return Collections.emptyMap();
      }
      return Collections.unmodifiableMap(map);
    }
    
    private Map<String, DynamoDBMapperFieldModel<T, Object>> versions()
    {
      if (versions.isEmpty()) {
        return Collections.emptyMap();
      }
      return Collections.unmodifiableMap(versions);
    }
    
    public Map<String, DynamoDBMapperFieldModel<T, Object>> fields()
    {
      if (fields.isEmpty()) {
        return Collections.emptyMap();
      }
      return Collections.unmodifiableMap(fields);
    }
    
    public Map<KeyType, DynamoDBMapperFieldModel<T, Object>> keys()
    {
      if (keys.isEmpty()) {
        return Collections.emptyMap();
      }
      return Collections.unmodifiableMap(keys);
    }
    
    public DynamoDBMapperTableModel<T> build()
    {
      DynamoDBMapperTableModel<T> result = new DynamoDBMapperTableModel(this, null);
      if (properties.tableName() != null) {
        result.hashKey();
      }
      return result;
    }
  }
  
  static abstract interface Properties<T>
  {
    public abstract String tableName();
    
    public static final class Immutable<T>
      implements DynamoDBMapperTableModel.Properties<T>
    {
      private final String tableName;
      
      public Immutable(DynamoDBMapperTableModel.Properties<T> properties)
      {
        tableName = properties.tableName();
      }
      
      public String tableName()
      {
        return tableName;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperTableModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */