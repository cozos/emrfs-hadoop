package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardAnnotationMaps$TableMap<T>
  extends StandardAnnotationMaps.TypedMap<T>
  implements DynamoDBMapperTableModel.Properties<T>
{
  private StandardAnnotationMaps$TableMap(Class<T> targetType)
  {
    super(targetType, null);
  }
  
  public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
  {
    DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType = super.attributeType();
    if ((attributeType == null) && (actualOf(DynamoDBTable.class) != null)) {
      attributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.M;
    }
    return attributeType;
  }
  
  public String tableName()
  {
    DynamoDBTable annotation = (DynamoDBTable)actualOf(DynamoDBTable.class);
    if ((annotation != null) && (!annotation.tableName().isEmpty())) {
      return annotation.tableName();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps.TableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */