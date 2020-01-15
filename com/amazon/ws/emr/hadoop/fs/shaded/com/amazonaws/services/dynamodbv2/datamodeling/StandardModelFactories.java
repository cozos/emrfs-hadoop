package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SdkInternalApi
final class StandardModelFactories
{
  private static final Log LOG = LogFactory.getLog(StandardModelFactories.class);
  
  static final DynamoDBMapperModelFactory of(S3Link.Factory s3Links)
  {
    return new StandardModelFactory(s3Links, null);
  }
  
  private static final class StandardModelFactory
    implements DynamoDBMapperModelFactory
  {
    private final ConcurrentMap<ConversionSchema, DynamoDBMapperModelFactory.TableFactory> cache;
    private final S3Link.Factory s3Links;
    
    private StandardModelFactory(S3Link.Factory s3Links)
    {
      cache = new ConcurrentHashMap();
      this.s3Links = s3Links;
    }
    
    public DynamoDBMapperModelFactory.TableFactory getTableFactory(DynamoDBMapperConfig config)
    {
      ConversionSchema schema = config.getConversionSchema();
      if (!cache.containsKey(schema))
      {
        StandardModelFactories.RuleFactory<Object> rules = StandardModelFactories.rulesOf(config, s3Links, this);
        rules = new ConversionSchemas.ItemConverterRuleFactory(config, s3Links, rules);
        cache.putIfAbsent(schema, new StandardModelFactories.StandardTableFactory(rules, null));
      }
      return (DynamoDBMapperModelFactory.TableFactory)cache.get(schema);
    }
  }
  
  private static final class StandardTableFactory
    implements DynamoDBMapperModelFactory.TableFactory
  {
    private final ConcurrentMap<Class<?>, DynamoDBMapperTableModel<?>> cache;
    private final StandardModelFactories.RuleFactory<Object> rules;
    
    private StandardTableFactory(StandardModelFactories.RuleFactory<Object> rules)
    {
      cache = new ConcurrentHashMap();
      this.rules = rules;
    }
    
    public <T> DynamoDBMapperTableModel<T> getTable(Class<T> clazz)
    {
      if (!cache.containsKey(clazz)) {
        cache.putIfAbsent(clazz, new StandardModelFactories.TableBuilder(clazz, rules, null).build());
      }
      return (DynamoDBMapperTableModel)cache.get(clazz);
    }
  }
  
  private static final class TableBuilder<T>
    extends DynamoDBMapperTableModel.Builder<T>
  {
    private TableBuilder(Class<T> clazz, StandardBeanProperties.Beans<T> beans, StandardModelFactories.RuleFactory<Object> rules)
    {
      super(beans.properties());
      for (StandardBeanProperties.Bean<T, Object> bean : beans.map().values()) {
        try
        {
          with(new StandardModelFactories.FieldBuilder(clazz, bean, rules.getRule(bean.type()), null).build());
        }
        catch (RuntimeException e)
        {
          throw new DynamoDBMappingException(String.format("%s[%s] could not be mapped for type %s", new Object[] {clazz
          
            .getSimpleName(), bean.properties().attributeName(), bean.type() }), e);
        }
      }
    }
    
    private TableBuilder(Class<T> clazz, StandardModelFactories.RuleFactory<Object> rules)
    {
      this(clazz, StandardBeanProperties.of(clazz), rules);
    }
  }
  
  private static final class FieldBuilder<T, V>
    extends DynamoDBMapperFieldModel.Builder<T, V>
  {
    private FieldBuilder(Class<T> clazz, StandardBeanProperties.Bean<T, V> bean, StandardModelFactories.Rule<V> rule)
    {
      super(bean.properties());
      if (bean.type().attributeType() != null) {
        with(bean.type().attributeType());
      } else {
        with(rule.getAttributeType());
      }
      with(rule.newConverter(bean.type()));
      with(bean.reflect());
    }
  }
  
  private static final <T> RuleFactory<T> rulesOf(DynamoDBMapperConfig config, S3Link.Factory s3Links, DynamoDBMapperModelFactory models)
  {
    boolean ver1 = config.getConversionSchema() == ConversionSchemas.V1;
    boolean ver2 = config.getConversionSchema() == ConversionSchemas.V2;
    boolean v2Compatible = config.getConversionSchema() == ConversionSchemas.V2_COMPATIBLE;
    
    DynamoDBTypeConverterFactory.Builder scalars = config.getTypeConverterFactory().override();
    scalars.with(String.class, S3Link.class, s3Links);
    
    Rules<T> factory = new Rules(scalars.build(), null); Rules<T> 
      tmp93_91 = factory;tmp93_91.getClass();factory.add(new StandardModelFactories.Rules.NativeType(tmp93_91, !ver1, null)); Rules<T> 
      tmp122_120 = factory;tmp122_120.getClass();factory.add(new StandardModelFactories.Rules.V2CompatibleBool(tmp122_120, v2Compatible, null)); Rules<T> 
      tmp144_142 = factory;tmp144_142.getClass();factory.add(new StandardModelFactories.Rules.NativeBool(tmp144_142, ver2, null)); Rules<T> 
      tmp166_164 = factory;tmp166_164.getClass();factory.add(new StandardModelFactories.Rules.StringScalar(tmp166_164, true, null)); Rules<T> 
      tmp187_185 = factory;tmp187_185.getClass();factory.add(new StandardModelFactories.Rules.DateToEpochRule(tmp187_185, true, null)); Rules<T> 
      tmp208_206 = factory;tmp208_206.getClass();factory.add(new StandardModelFactories.Rules.NumberScalar(tmp208_206, true, null)); Rules<T> 
      tmp229_227 = factory;tmp229_227.getClass();factory.add(new StandardModelFactories.Rules.BinaryScalar(tmp229_227, true, null)); Rules<T> 
      tmp250_248 = factory;tmp250_248.getClass();factory.add(new StandardModelFactories.Rules.NativeBoolSet(tmp250_248, ver2, null)); Rules<T> 
      tmp272_270 = factory;tmp272_270.getClass();factory.add(new StandardModelFactories.Rules.StringScalarSet(tmp272_270, true, null)); Rules<T> 
      tmp293_291 = factory;tmp293_291.getClass();factory.add(new StandardModelFactories.Rules.NumberScalarSet(tmp293_291, true, null)); Rules<T> 
      tmp314_312 = factory;tmp314_312.getClass();factory.add(new StandardModelFactories.Rules.BinaryScalarSet(tmp314_312, true, null)); Rules<T> 
      tmp335_333 = factory;tmp335_333.getClass();factory.add(new StandardModelFactories.Rules.ObjectSet(tmp335_333, ver2, null)); Rules<T> 
      tmp357_355 = factory;tmp357_355.getClass();factory.add(new StandardModelFactories.Rules.ObjectStringSet(tmp357_355, !ver2, null)); Rules<T> 
      tmp387_385 = factory;tmp387_385.getClass();factory.add(new StandardModelFactories.Rules.ObjectList(tmp387_385, !ver1, null)); Rules<T> 
      tmp416_414 = factory;tmp416_414.getClass();factory.add(new StandardModelFactories.Rules.ObjectMap(tmp416_414, !ver1, null)); Rules<T> 
      tmp445_443 = factory;tmp445_443.getClass();factory.add(new StandardModelFactories.Rules.ObjectDocumentMap(tmp445_443, !ver1, models, config, null));
    return factory;
  }
  
  private static final class Rules<T>
    implements StandardModelFactories.RuleFactory<T>
  {
    private final Set<StandardModelFactories.Rule<T>> rules = new LinkedHashSet();
    private final DynamoDBTypeConverterFactory scalars;
    
    private Rules(DynamoDBTypeConverterFactory scalars)
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
        StandardModelFactories.LOG.warn("Marshaling a set of non-String objects to a DynamoDB StringSet. You won't be able to read these objects back out of DynamoDB unless you REALLY know what you're doing: it's probably a bug. If you DO know what you're doing feelfree to ignore this warning, but consider using a custom marshaler for this instead.");
        
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
  
  private static abstract class AbstractRule<S, T>
    extends DynamoDBTypeConverter.AbstractConverter<AttributeValue, S>
    implements DynamoDBMapperFieldModel.Reflect<AttributeValue, S>, StandardModelFactories.Rule<T>
  {
    protected final DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
    protected final boolean supported;
    
    protected AbstractRule(DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType, boolean supported)
    {
      this.attributeType = attributeType;
      this.supported = supported;
    }
    
    public boolean isAssignableFrom(ConvertibleType<?> type)
    {
      return type.attributeType() == attributeType ? true : type.attributeType() == null ? supported : false;
    }
    
    public DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType()
    {
      return attributeType;
    }
    
    public AttributeValue convert(S o)
    {
      AttributeValue value = new AttributeValue();
      set(value, o);
      return value;
    }
    
    public S unconvert(AttributeValue o)
    {
      S value = get(o);
      if ((value == null) && (o.isNULL() == null)) {
        throw new DynamoDBMappingException("expected " + attributeType + " in value " + o);
      }
      return value;
    }
  }
  
  static abstract interface Rule<T>
  {
    public abstract boolean isAssignableFrom(ConvertibleType<?> paramConvertibleType);
    
    public abstract DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> paramConvertibleType);
    
    public abstract DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType();
  }
  
  static abstract interface RuleFactory<T>
  {
    public abstract StandardModelFactories.Rule<T> getRule(ConvertibleType<T> paramConvertibleType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */