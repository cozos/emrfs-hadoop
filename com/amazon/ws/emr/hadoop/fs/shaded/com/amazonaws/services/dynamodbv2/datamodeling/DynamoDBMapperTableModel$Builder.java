package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProjectionType;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class DynamoDBMapperTableModel$Builder<T>
{
  private final Map<String, DynamoDBMapperFieldModel<T, Object>> versions;
  private final Map<String, DynamoDBMapperFieldModel<T, Object>> fields;
  private final Map<KeyType, DynamoDBMapperFieldModel<T, Object>> keys;
  private final DynamoDBMapperTableModel.Properties properties;
  private final Class<T> targetType;
  
  public DynamoDBMapperTableModel$Builder(Class<T> targetType, DynamoDBMapperTableModel.Properties<T> properties)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperTableModel.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */