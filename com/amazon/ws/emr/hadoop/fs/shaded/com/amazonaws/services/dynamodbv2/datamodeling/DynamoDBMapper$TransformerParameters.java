package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Collections;
import java.util.Map;

class DynamoDBMapper$TransformerParameters<T>
  implements AttributeTransformer.Parameters<T>
{
  private final DynamoDBMapperTableModel<T> model;
  private final Map<String, AttributeValue> attributeValues;
  private final boolean partialUpdate;
  private final Class<T> modelClass;
  private final DynamoDBMapperConfig mapperConfig;
  private final String tableName;
  
  public DynamoDBMapper$TransformerParameters(DynamoDBMapperTableModel<T> model, Map<String, AttributeValue> attributeValues, boolean partialUpdate, Class<T> modelClass, DynamoDBMapperConfig mapperConfig, String tableName)
  {
    this.model = model;
    this.attributeValues = 
      Collections.unmodifiableMap(attributeValues);
    this.partialUpdate = partialUpdate;
    this.modelClass = modelClass;
    this.mapperConfig = mapperConfig;
    this.tableName = tableName;
  }
  
  public Map<String, AttributeValue> getAttributeValues()
  {
    return attributeValues;
  }
  
  public boolean isPartialUpdate()
  {
    return partialUpdate;
  }
  
  public Class<T> getModelClass()
  {
    return modelClass;
  }
  
  public DynamoDBMapperConfig getMapperConfig()
  {
    return mapperConfig;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public String getHashKeyName()
  {
    return model.hashKey().name();
  }
  
  public String getRangeKeyName()
  {
    return model.rangeKeyIfExists() == null ? null : model.rangeKey().name();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.TransformerParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */