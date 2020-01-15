package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class DynamoDBDelimited$Converter$Field<T, V>
{
  private final DynamoDBTypeConverter<String, V> converter;
  private final StandardBeanProperties.Bean<T, V> bean;
  
  private DynamoDBDelimited$Converter$Field(Class<T> type, StandardBeanProperties.Bean<T, V> bean)
  {
    if (bean.type().typeConverter() == null) {
      converter = StandardTypeConverters.factory().getConverter(String.class, bean.type().targetType());
    } else {
      converter = bean.type().typeConverter();
    }
    this.bean = bean;
  }
  
  private final String get(T object)
  {
    V value = bean.reflect().get(object);
    if (value == null) {
      return null;
    }
    return (String)converter.convert(value);
  }
  
  private final void set(T object, String string)
  {
    if (!string.isEmpty())
    {
      V value = converter.unconvert(string);
      if (value != null) {
        bean.reflect().set(object, value);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDelimited.Converter.Field
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */