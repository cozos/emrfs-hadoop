package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class StandardModelFactories$Rules<T>
  implements StandardModelFactories.RuleFactory<T>
{
  private final Set<StandardModelFactories.Rule<T>> rules = new LinkedHashSet();
  private final DynamoDBTypeConverterFactory scalars;
  
  private StandardModelFactories$Rules(DynamoDBTypeConverterFactory scalars)
  {
    this.scalars = scalars;
  }
  
  private void add(StandardModelFactories.Rule<?> rule)
  {
    rules.add(rule);
  }
  
  public StandardModelFactories.Rule<T> getRule(ConvertibleType<T> type)
  {
    for (StandardModelFactories.Rule<T> rule : rules) {
      if (rule.isAssignableFrom(type)) {
        return rule;
      }
    }
    return new NotSupported(null);
  }
  
  private class NativeType
    extends StandardModelFactories.AbstractRule<AttributeValue, T>
  {
    private NativeType(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (supported) && (type.is(AttributeValue.class));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { type.typeConverter() });
    }
    
    public AttributeValue get(AttributeValue o)
    {
      return o;
    }
    
    public void set(AttributeValue value, AttributeValue o)
    {
      value.withS(o.getS()).withN(o.getN()).withB(o.getB()).withSS(o.getSS()).withNS(o.getNS()).withBS(o.getBS()).withBOOL(o.getBOOL()).withL(o.getL()).withM(o.getM()).withNULL(o.getNULL());
    }
  }
  
  private class StringScalar
    extends StandardModelFactories.AbstractRule<String, T>
  {
    private StringScalar(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.S)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(String.class, type), type.typeConverter() });
    }
    
    public String get(AttributeValue value)
    {
      return value.getS();
    }
    
    public void set(AttributeValue value, String o)
    {
      value.setS(o);
    }
    
    public AttributeValue convert(String o)
    {
      return o.length() == 0 ? null : super.convert(o);
    }
  }
  
  private class NumberScalar
    extends StandardModelFactories.AbstractRule<String, T>
  {
    private NumberScalar(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.N)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(String.class, type), type.typeConverter() });
    }
    
    public String get(AttributeValue value)
    {
      return value.getN();
    }
    
    public void set(AttributeValue value, String o)
    {
      value.setN(o);
    }
  }
  
  private class DateToEpochRule
    extends StandardModelFactories.AbstractRule<Long, T>
  {
    private DateToEpochRule(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return ((type.is(Date.class)) || (type.is(Calendar.class)) || (type.is(DateTime.class))) && 
        (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.N)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(Long.class, type), type.typeConverter() });
    }
    
    public Long get(AttributeValue value)
    {
      return Long.valueOf(value.getN());
    }
    
    public void set(AttributeValue value, Long o)
    {
      value.setN(String.valueOf(o));
    }
  }
  
  private class BinaryScalar
    extends StandardModelFactories.AbstractRule<ByteBuffer, T>
  {
    private BinaryScalar(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.B)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(ByteBuffer.class, type), type.typeConverter() });
    }
    
    public ByteBuffer get(AttributeValue value)
    {
      return value.getB();
    }
    
    public void set(AttributeValue value, ByteBuffer o)
    {
      value.setB(o);
    }
  }
  
  private class StringScalarSet
    extends StandardModelFactories.AbstractRule<List<String>, Collection<T>>
  {
    private StringScalarSet(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.S, StandardTypeConverters.Vector.SET)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.this.getConverter(String.class, type.param(0))), type.typeConverter() });
    }
    
    public List<String> get(AttributeValue value)
    {
      return value.getSS();
    }
    
    public void set(AttributeValue value, List<String> o)
    {
      value.setSS(o);
    }
  }
  
  private class NumberScalarSet
    extends StandardModelFactories.AbstractRule<List<String>, Collection<T>>
  {
    private NumberScalarSet(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.N, StandardTypeConverters.Vector.SET)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.this.getConverter(String.class, type.param(0))), type.typeConverter() });
    }
    
    public List<String> get(AttributeValue value)
    {
      return value.getNS();
    }
    
    public void set(AttributeValue value, List<String> o)
    {
      value.setNS(o);
    }
  }
  
  private class BinaryScalarSet
    extends StandardModelFactories.AbstractRule<List<ByteBuffer>, Collection<T>>
  {
    private BinaryScalarSet(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.B, StandardTypeConverters.Vector.SET)));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.this.getConverter(ByteBuffer.class, type.param(0))), type.typeConverter() });
    }
    
    public List<ByteBuffer> get(AttributeValue value)
    {
      return value.getBS();
    }
    
    public void set(AttributeValue value, List<ByteBuffer> o)
    {
      value.setBS(o);
    }
  }
  
  private class ObjectStringSet
    extends StandardModelFactories.Rules<T>.StringScalarSet
  {
    private ObjectStringSet(boolean supported)
    {
      super(supported, null);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (type.attributeType() == null) && (supported) && (type.is(StandardTypeConverters.Vector.SET));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
    {
      StandardModelFactories.access$2500().warn("Marshaling a set of non-String objects to a DynamoDB StringSet. You won't be able to read these objects back out of DynamoDB unless you REALLY know what you're doing: it's probably a bug. If you DO know what you're doing feelfree to ignore this warning, but consider using a custom marshaler for this instead.");
      
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(scalars.getConverter(String.class, StandardTypeConverters.Scalar.DEFAULT.type())), type.typeConverter() });
    }
  }
  
  private class NativeBool
    extends StandardModelFactories.AbstractRule<Boolean, T>
  {
    private NativeBool(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.is(StandardTypeConverters.Scalar.BOOLEAN));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(Boolean.class, type), type.typeConverter() });
    }
    
    public Boolean get(AttributeValue o)
    {
      return o.getBOOL();
    }
    
    public void set(AttributeValue o, Boolean value)
    {
      o.setBOOL(value);
    }
    
    public Boolean unconvert(AttributeValue o)
    {
      if ((o.getBOOL() == null) && (o.getN() != null)) {
        return (Boolean)StandardTypeConverters.Scalar.BOOLEAN.convert(o.getN());
      }
      return (Boolean)super.unconvert(o);
    }
  }
  
  private class V2CompatibleBool
    extends StandardModelFactories.AbstractRule<String, T>
  {
    private V2CompatibleBool(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.is(StandardTypeConverters.Scalar.BOOLEAN));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.this.getConverter(String.class, type), type.typeConverter() });
    }
    
    public String get(AttributeValue o)
    {
      if (o.getBOOL() != null) {
        return o.getBOOL().booleanValue() ? "1" : "0";
      }
      return o.getN();
    }
    
    public void set(AttributeValue o, String value)
    {
      o.setN(value);
    }
  }
  
  private class ObjectSet
    extends StandardModelFactories.AbstractRule<List<AttributeValue>, Collection<T>>
  {
    private ObjectSet(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.param(0) != null) && (type.is(StandardTypeConverters.Vector.SET));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.this.getConverter(type.param(0))), type.typeConverter() });
    }
    
    public List<AttributeValue> get(AttributeValue value)
    {
      return value.getL();
    }
    
    public void set(AttributeValue value, List<AttributeValue> o)
    {
      value.setL(o);
    }
  }
  
  private class NativeBoolSet
    extends StandardModelFactories.Rules<T>.ObjectSet
  {
    private NativeBoolSet(boolean supported)
    {
      super(supported, null);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.param(0).is(StandardTypeConverters.Scalar.BOOLEAN));
    }
    
    public List<AttributeValue> unconvert(AttributeValue o)
    {
      if ((o.getL() == null) && (o.getNS() != null)) {
        return StandardTypeConverters.Vector.LIST.convert(o.getNS(), new StandardModelFactories.Rules.NativeBool(StandardModelFactories.Rules.this, true, null).join(scalars.getConverter(Boolean.class, String.class)));
      }
      return (List)super.unconvert(o);
    }
  }
  
  private class ObjectList
    extends StandardModelFactories.AbstractRule<List<AttributeValue>, List<T>>
  {
    private ObjectList(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.param(0) != null) && (type.is(StandardTypeConverters.Vector.LIST));
    }
    
    public DynamoDBTypeConverter<AttributeValue, List<T>> newConverter(ConvertibleType<List<T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.LIST.join(StandardModelFactories.Rules.this.getConverter(type.param(0))), type.typeConverter() });
    }
    
    public List<AttributeValue> get(AttributeValue value)
    {
      return value.getL();
    }
    
    public void set(AttributeValue value, List<AttributeValue> o)
    {
      value.setL(o);
    }
  }
  
  private class ObjectMap
    extends StandardModelFactories.AbstractRule<Map<String, AttributeValue>, Map<String, T>>
  {
    private ObjectMap(boolean supported)
    {
      super(supported);
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (super.isAssignableFrom(type)) && (type.param(1) != null) && (type.is(StandardTypeConverters.Vector.MAP)) && (type.param(0).is(StandardTypeConverters.Scalar.STRING));
    }
    
    public DynamoDBTypeConverter<AttributeValue, Map<String, T>> newConverter(ConvertibleType<Map<String, T>> type)
    {
      return joinAll(new DynamoDBTypeConverter[] {StandardTypeConverters.Vector.MAP
        .join(StandardModelFactories.Rules.this.getConverter(type.param(1))), type
        .typeConverter() });
    }
    
    public Map<String, AttributeValue> get(AttributeValue value)
    {
      return value.getM();
    }
    
    public void set(AttributeValue value, Map<String, AttributeValue> o)
    {
      value.setM(o);
    }
  }
  
  private class ObjectDocumentMap
    extends StandardModelFactories.AbstractRule<Map<String, AttributeValue>, T>
  {
    private final DynamoDBMapperModelFactory models;
    private final DynamoDBMapperConfig config;
    
    private ObjectDocumentMap(boolean supported, DynamoDBMapperModelFactory models, DynamoDBMapperConfig config)
    {
      super(supported);
      this.models = models;
      this.config = config;
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return (type.attributeType() == getAttributeType()) && (supported) && (!type.is(StandardTypeConverters.Vector.MAP));
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(final ConvertibleType<T> type)
    {
      joinAll(new DynamoDBTypeConverter[] { new DynamoDBTypeConverter()
      {
        public final Map<String, AttributeValue> convert(T o)
        {
          return models.getTableFactory(config).getTable(type.targetType()).convert(o);
        }
        
        public final T unconvert(Map<String, AttributeValue> o)
        {
          return (T)models.getTableFactory(config).getTable(type.targetType()).unconvert(o);
        }
      }, type.typeConverter() });
    }
    
    public Map<String, AttributeValue> get(AttributeValue value)
    {
      return value.getM();
    }
    
    public void set(AttributeValue value, Map<String, AttributeValue> o)
    {
      value.setM(o);
    }
  }
  
  private class NotSupported
    extends StandardModelFactories.AbstractRule<T, T>
  {
    private NotSupported()
    {
      super(false);
    }
    
    public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
    {
      return this;
    }
    
    public T get(AttributeValue value)
    {
      throw new DynamoDBMappingException("not supported; requires @DynamoDBTyped or @DynamoDBTypeConverted");
    }
    
    public void set(AttributeValue value, T o)
    {
      throw new DynamoDBMappingException("not supported; requires @DynamoDBTyped or @DynamoDBTypeConverted");
    }
  }
  
  private <S> DynamoDBTypeConverter<S, T> getConverter(Class<S> sourceType, ConvertibleType<T> type)
  {
    return scalars.getConverter(sourceType, type.targetType());
  }
  
  private DynamoDBTypeConverter<AttributeValue, T> getConverter(ConvertibleType<T> type)
  {
    new DynamoDBTypeConverter.DelegateConverter(getRule(type).newConverter(type))
    {
      public final AttributeValue convert(T o)
      {
        return o == null ? new AttributeValue().withNULL(Boolean.valueOf(true)) : (AttributeValue)super.convert(o);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */