package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class StandardAnnotationMaps$FieldMap<T>
  extends StandardAnnotationMaps.TypedMap<T>
  implements DynamoDBMapperFieldModel.Properties<T>
{
  private final String defaultName;
  
  private StandardAnnotationMaps$FieldMap(Class<T> targetType, String defaultName)
  {
    super(targetType, null);
    this.defaultName = defaultName;
  }
  
  public boolean ignored()
  {
    return actualOf(DynamoDBIgnore.class) != null;
  }
  
  public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
  {
    DynamoDBScalarAttribute annotation = (DynamoDBScalarAttribute)actualOf(DynamoDBScalarAttribute.class);
    if (annotation != null)
    {
      if (Set.class.isAssignableFrom(targetType())) {
        return DynamoDBMapperFieldModel.DynamoDBAttributeType.valueOf(annotation.type().name() + "S");
      }
      return DynamoDBMapperFieldModel.DynamoDBAttributeType.valueOf(annotation.type().name());
    }
    return super.attributeType();
  }
  
  public String attributeName()
  {
    DynamoDBHashKey hashKey = (DynamoDBHashKey)actualOf(DynamoDBHashKey.class);
    if ((hashKey != null) && (!hashKey.attributeName().isEmpty())) {
      return hashKey.attributeName();
    }
    DynamoDBIndexHashKey indexHashKey = (DynamoDBIndexHashKey)actualOf(DynamoDBIndexHashKey.class);
    if ((indexHashKey != null) && (!indexHashKey.attributeName().isEmpty())) {
      return indexHashKey.attributeName();
    }
    DynamoDBRangeKey rangeKey = (DynamoDBRangeKey)actualOf(DynamoDBRangeKey.class);
    if ((rangeKey != null) && (!rangeKey.attributeName().isEmpty())) {
      return rangeKey.attributeName();
    }
    DynamoDBIndexRangeKey indexRangeKey = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
    if ((indexRangeKey != null) && (!indexRangeKey.attributeName().isEmpty())) {
      return indexRangeKey.attributeName();
    }
    DynamoDBAttribute attribute = (DynamoDBAttribute)actualOf(DynamoDBAttribute.class);
    if ((attribute != null) && (!attribute.attributeName().isEmpty())) {
      return attribute.attributeName();
    }
    DynamoDBVersionAttribute versionAttribute = (DynamoDBVersionAttribute)actualOf(DynamoDBVersionAttribute.class);
    if ((versionAttribute != null) && (!versionAttribute.attributeName().isEmpty())) {
      return versionAttribute.attributeName();
    }
    DynamoDBScalarAttribute scalarAttribute = (DynamoDBScalarAttribute)actualOf(DynamoDBScalarAttribute.class);
    if ((scalarAttribute != null) && (!scalarAttribute.attributeName().isEmpty())) {
      return scalarAttribute.attributeName();
    }
    DynamoDBNamed annotation = (DynamoDBNamed)actualOf(DynamoDBNamed.class);
    if ((annotation != null) && (!annotation.value().isEmpty())) {
      return annotation.value();
    }
    return defaultName;
  }
  
  public KeyType keyType()
  {
    DynamoDBKeyed annotation = (DynamoDBKeyed)actualOf(DynamoDBKeyed.class);
    if (annotation != null) {
      return annotation.value();
    }
    return null;
  }
  
  public boolean versioned()
  {
    return actualOf(DynamoDBVersioned.class) != null;
  }
  
  public Map<KeyType, List<String>> globalSecondaryIndexNames()
  {
    Map<KeyType, List<String>> gsis = new EnumMap(KeyType.class);
    DynamoDBIndexHashKey indexHashKey = (DynamoDBIndexHashKey)actualOf(DynamoDBIndexHashKey.class);
    if (indexHashKey != null) {
      if (!indexHashKey.globalSecondaryIndexName().isEmpty())
      {
        if (indexHashKey.globalSecondaryIndexNames().length > 0) {
          throw new DynamoDBMappingException("@DynamoDBIndexHashKey must not specify both HASH GSI name/names");
        }
        gsis.put(KeyType.HASH, Collections.singletonList(indexHashKey.globalSecondaryIndexName()));
      }
      else if (indexHashKey.globalSecondaryIndexNames().length > 0)
      {
        gsis.put(KeyType.HASH, Collections.unmodifiableList(Arrays.asList(indexHashKey.globalSecondaryIndexNames())));
      }
      else
      {
        throw new DynamoDBMappingException("@DynamoDBIndexHashKey must specify one of HASH GSI name/names");
      }
    }
    DynamoDBIndexRangeKey indexRangeKey = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
    if (indexRangeKey != null) {
      if (!indexRangeKey.globalSecondaryIndexName().isEmpty())
      {
        if (indexRangeKey.globalSecondaryIndexNames().length > 0) {
          throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must not specify both RANGE GSI name/names");
        }
        gsis.put(KeyType.RANGE, Collections.singletonList(indexRangeKey.globalSecondaryIndexName()));
      }
      else if (indexRangeKey.globalSecondaryIndexNames().length > 0)
      {
        gsis.put(KeyType.RANGE, Collections.unmodifiableList(Arrays.asList(indexRangeKey.globalSecondaryIndexNames())));
      }
      else if (localSecondaryIndexNames().isEmpty())
      {
        throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must specify RANGE GSI and/or LSI name/names");
      }
    }
    if (!gsis.isEmpty()) {
      return Collections.unmodifiableMap(gsis);
    }
    return Collections.emptyMap();
  }
  
  public List<String> localSecondaryIndexNames()
  {
    DynamoDBIndexRangeKey annotation = (DynamoDBIndexRangeKey)actualOf(DynamoDBIndexRangeKey.class);
    if (annotation != null)
    {
      if (!annotation.localSecondaryIndexName().isEmpty())
      {
        if (annotation.localSecondaryIndexNames().length > 0) {
          throw new DynamoDBMappingException("@DynamoDBIndexRangeKey must not specify both LSI name/names");
        }
        return Collections.singletonList(annotation.localSecondaryIndexName());
      }
      if (annotation.localSecondaryIndexNames().length > 0) {
        return Collections.unmodifiableList(Arrays.asList(annotation.localSecondaryIndexNames()));
      }
    }
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps.FieldMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */