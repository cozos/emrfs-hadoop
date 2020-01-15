package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@DynamoDB
@DynamoDBTypeConverted(converter=Converter.class)
@DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface DynamoDBConvertedBool
{
  Format value();
  
  public static enum Format
  {
    true_false,  T_F,  Y_N;
    
    private Format() {}
  }
  
  public static final class Converter
    implements DynamoDBTypeConverter<String, Boolean>
  {
    private final String valueTrue;
    private final String valueFalse;
    
    public Converter(Class<Boolean> targetType, DynamoDBConvertedBool annotation)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBConvertedBool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */