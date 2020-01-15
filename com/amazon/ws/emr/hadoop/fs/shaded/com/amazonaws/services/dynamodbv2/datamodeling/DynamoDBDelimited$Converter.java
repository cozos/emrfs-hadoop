package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.regex.Pattern;

public final class DynamoDBDelimited$Converter<T>
  implements DynamoDBTypeConverter<String, T>
{
  private final Field<T, Object>[] fields;
  private final Class<T> targetType;
  private final String delimiter;
  
  public DynamoDBDelimited$Converter(Class<T> targetType, DynamoDBDelimited annotation)
  {
    StandardBeanProperties.BeanMap<T, Object> beans = new StandardBeanProperties.BeanMap(targetType, true);
    
    String[] names = annotation.attributeNames();
    if (names.length <= 1) {
      throw new DynamoDBMappingException(targetType + " missing attributeNames in @DynamoDBDelimited; must specify two or more attribute names");
    }
    delimiter = String.valueOf(annotation.delimiter());
    fields = new Field[names.length];
    this.targetType = targetType;
    for (int i = 0; i < fields.length; i++)
    {
      if (!beans.containsKey(names[i])) {
        throw new DynamoDBMappingException(targetType + " does not map %s on model " + names[i]);
      }
      fields[i] = new Field(targetType, (StandardBeanProperties.Bean)beans.get(names[i]), null);
    }
  }
  
  public final String convert(T object)
  {
    StringBuilder string = new StringBuilder();
    for (int i = 0; i < fields.length; i++)
    {
      if (i > 0) {
        string.append(delimiter);
      }
      String value = fields[i].get(object);
      if (value != null)
      {
        if (value.contains(delimiter)) {
          throw new DynamoDBMappingException(String.format("%s[%s] field value \"%s\" must not contain delimiter %s", new Object[] { targetType, 
          
            fields[i].bean.properties().attributeName(), value, delimiter }));
        }
        string.append(value);
      }
    }
    return string.length() < fields.length ? null : string.toString();
  }
  
  public final T unconvert(String string)
  {
    T object = StandardBeanProperties.DeclaringReflect.newInstance(targetType);
    String[] values = string.split(Pattern.quote(delimiter));
    int i = 0;
    for (int its = Math.min(fields.length, values.length); i < its; i++) {
      fields[i].set(object, values[i]);
    }
    return object;
  }
  
  private static final class Field<T, V>
  {
    private final DynamoDBTypeConverter<String, V> converter;
    private final StandardBeanProperties.Bean<T, V> bean;
    
    private Field(Class<T> type, StandardBeanProperties.Bean<T, V> bean)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDelimited.Converter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */