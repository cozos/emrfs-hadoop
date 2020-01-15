package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public final class DynamoDBConvertedBool$Converter
  implements DynamoDBTypeConverter<String, Boolean>
{
  private final String valueTrue;
  private final String valueFalse;
  
  public DynamoDBConvertedBool$Converter(Class<Boolean> targetType, DynamoDBConvertedBool annotation)
  {
    valueTrue = annotation.value().name().split("_")[0];
    valueFalse = annotation.value().name().split("_")[1];
  }
  
  public final String convert(Boolean object)
  {
    return Boolean.TRUE.equals(object) ? valueTrue : valueFalse;
  }
  
  public final Boolean unconvert(String object)
  {
    return valueTrue.equals(object) ? Boolean.TRUE : Boolean.FALSE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBConvertedBool.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */