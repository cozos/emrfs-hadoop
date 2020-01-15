package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DynamoDBMapperFieldModel<T, V>
  implements DynamoDBAutoGenerator<V>, DynamoDBTypeConverter<AttributeValue, V>
{
  private final Properties<V> properties;
  private final DynamoDBTypeConverter<AttributeValue, V> converter;
  private final DynamoDBAttributeType attributeType;
  private final Reflect<T, V> reflect;
  
  public static enum DynamoDBAttributeType
  {
    B,  N,  S,  BS,  NS,  SS,  BOOL,  NULL,  L,  M;
    
    private DynamoDBAttributeType() {}
  }
  
  private DynamoDBMapperFieldModel(Builder<T, V> builder)
  {
    properties = properties;
    converter = converter;
    attributeType = attributeType;
    reflect = reflect;
  }
  
  @Deprecated
  public String getDynamoDBAttributeName()
  {
    return properties.attributeName();
  }
  
  @Deprecated
  public DynamoDBAttributeType getDynamoDBAttributeType()
  {
    return attributeType;
  }
  
  public final String name()
  {
    return properties.attributeName();
  }
  
  public final V get(T object)
  {
    return (V)reflect.get(object);
  }
  
  public final void set(T object, V value)
  {
    reflect.set(object, value);
  }
  
  public final DynamoDBAutoGenerateStrategy getGenerateStrategy()
  {
    if (properties.autoGenerator() != null) {
      return properties.autoGenerator().getGenerateStrategy();
    }
    return null;
  }
  
  public final V generate(V currentValue)
  {
    return (V)properties.autoGenerator().generate(currentValue);
  }
  
  public final AttributeValue convert(V object)
  {
    return (AttributeValue)converter.convert(object);
  }
  
  public final V unconvert(AttributeValue object)
  {
    return (V)converter.unconvert(object);
  }
  
  public final AttributeValue getAndConvert(T object)
  {
    return convert(get(object));
  }
  
  public final void unconvertAndSet(T object, AttributeValue value)
  {
    set(object, unconvert(value));
  }
  
  public final DynamoDBAttributeType attributeType()
  {
    return attributeType;
  }
  
  public final KeyType keyType()
  {
    return properties.keyType();
  }
  
  public final boolean versioned()
  {
    return properties.versioned();
  }
  
  public final List<String> globalSecondaryIndexNames(KeyType keyType)
  {
    if (properties.globalSecondaryIndexNames().containsKey(keyType)) {
      return (List)properties.globalSecondaryIndexNames().get(keyType);
    }
    return Collections.emptyList();
  }
  
  public final List<String> localSecondaryIndexNames()
  {
    return properties.localSecondaryIndexNames();
  }
  
  public final boolean indexed()
  {
    return (!properties.globalSecondaryIndexNames().isEmpty()) || (!properties.localSecondaryIndexNames().isEmpty());
  }
  
  public final Condition beginsWith(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition between(V lo, V hi)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.BETWEEN).withAttributeValueList(new AttributeValue[] { convert(lo), convert(hi) });
  }
  
  public final Condition contains(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.CONTAINS).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition eq(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition ge(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.GE).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition gt(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.GT).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition in(Collection<V> values)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.IN).withAttributeValueList(StandardTypeConverters.Vector.LIST.convert(values, this));
  }
  
  public final Condition in(V... values)
  {
    return in(Arrays.asList(values));
  }
  
  public final Condition isNull()
  {
    return new Condition().withComparisonOperator(ComparisonOperator.NULL);
  }
  
  public final Condition le(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.LE).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition lt(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.LT).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition ne(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.NE).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition notContains(V value)
  {
    return new Condition().withComparisonOperator(ComparisonOperator.NOT_CONTAINS).withAttributeValueList(new AttributeValue[] { convert(value) });
  }
  
  public final Condition notNull()
  {
    return new Condition().withComparisonOperator(ComparisonOperator.NOT_NULL);
  }
  
  public final Condition betweenAny(V lo, V hi)
  {
    return lo.equals(hi) ? eq(lo) : hi == null ? ge(lo) : lo == null ? le(hi) : hi == null ? null : between(lo, hi);
  }
  
  static class Builder<T, V>
  {
    private final DynamoDBMapperFieldModel.Properties<V> properties;
    private DynamoDBTypeConverter<AttributeValue, V> converter;
    private DynamoDBMapperFieldModel.Reflect<T, V> reflect;
    private DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
    private Class<T> targetType;
    
    public Builder(Class<T> targetType, DynamoDBMapperFieldModel.Properties<V> properties)
    {
      this.properties = properties;
      this.targetType = targetType;
    }
    
    public final Builder<T, V> with(DynamoDBTypeConverter<AttributeValue, V> converter)
    {
      this.converter = converter;
      return this;
    }
    
    public final Builder<T, V> with(DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType)
    {
      this.attributeType = attributeType;
      return this;
    }
    
    public final Builder<T, V> with(DynamoDBMapperFieldModel.Reflect<T, V> reflect)
    {
      this.reflect = reflect;
      return this;
    }
    
    public final DynamoDBMapperFieldModel<T, V> build()
    {
      DynamoDBMapperFieldModel<T, V> result = new DynamoDBMapperFieldModel(this, null);
      if (((result.keyType() != null) || (result.indexed())) && (!result.attributeType().name().matches("[BNS]"))) {
        throw new DynamoDBMappingException(String.format("%s[%s]; only scalar (B, N, or S) type allowed for key", new Object[] {targetType
        
          .getSimpleName(), result.name() }));
      }
      if ((result.keyType() != null) && (result.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.ALWAYS)) {
        throw new DynamoDBMappingException(String.format("%s[%s]; auto-generated key and ALWAYS not allowed", new Object[] {targetType
        
          .getSimpleName(), result.name() }));
      }
      return result;
    }
  }
  
  static abstract interface Properties<V>
  {
    public abstract String attributeName();
    
    public abstract KeyType keyType();
    
    public abstract boolean versioned();
    
    public abstract Map<KeyType, List<String>> globalSecondaryIndexNames();
    
    public abstract List<String> localSecondaryIndexNames();
    
    public abstract DynamoDBAutoGenerator<V> autoGenerator();
    
    public static final class Immutable<V>
      implements DynamoDBMapperFieldModel.Properties<V>
    {
      private final String attributeName;
      private final KeyType keyType;
      private final boolean versioned;
      private final Map<KeyType, List<String>> globalSecondaryIndexNames;
      private final List<String> localSecondaryIndexNames;
      private final DynamoDBAutoGenerator<V> autoGenerator;
      
      public Immutable(DynamoDBMapperFieldModel.Properties<V> properties)
      {
        attributeName = properties.attributeName();
        keyType = properties.keyType();
        versioned = properties.versioned();
        globalSecondaryIndexNames = properties.globalSecondaryIndexNames();
        localSecondaryIndexNames = properties.localSecondaryIndexNames();
        autoGenerator = properties.autoGenerator();
      }
      
      public final String attributeName()
      {
        return attributeName;
      }
      
      public final KeyType keyType()
      {
        return keyType;
      }
      
      public final boolean versioned()
      {
        return versioned;
      }
      
      public final Map<KeyType, List<String>> globalSecondaryIndexNames()
      {
        return globalSecondaryIndexNames;
      }
      
      public final List<String> localSecondaryIndexNames()
      {
        return localSecondaryIndexNames;
      }
      
      public final DynamoDBAutoGenerator<V> autoGenerator()
      {
        return autoGenerator;
      }
    }
  }
  
  static abstract interface Reflect<T, V>
  {
    public abstract V get(T paramT);
    
    public abstract void set(T paramT, V paramV);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */