package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public abstract class DynamoDBTypeConverterFactory
{
  public abstract <S, T> DynamoDBTypeConverter<S, T> getConverter(Class<S> paramClass, Class<T> paramClass1);
  
  public final Builder override()
  {
    return new Builder(this, null);
  }
  
  public static final DynamoDBTypeConverterFactory standard()
  {
    return StandardTypeConverters.factory();
  }
  
  public static final class Builder
  {
    private final DynamoDBTypeConverterFactory.ConverterMap overrides = new DynamoDBTypeConverterFactory.ConverterMap(null);
    private final DynamoDBTypeConverterFactory defaults;
    
    private Builder(DynamoDBTypeConverterFactory defaults)
    {
      this.defaults = defaults;
    }
    
    public <S, T> Builder with(Class<S> sourceType, Class<T> targetType, DynamoDBTypeConverter<? extends S, ? extends T> converter)
    {
      if ((StandardTypeConverters.Vector.SET.is(sourceType)) || (StandardTypeConverters.Vector.LIST.is(sourceType)) || (StandardTypeConverters.Vector.MAP.is(sourceType))) {
        throw new DynamoDBMappingException("type [" + sourceType + "] is not supported; type-converter factory only supports scalar conversions");
      }
      overrides.put(sourceType, targetType, converter);
      return this;
    }
    
    public DynamoDBTypeConverterFactory build()
    {
      return new DynamoDBTypeConverterFactory.OverrideFactory(defaults, overrides);
    }
  }
  
  public static class DelegateFactory
    extends DynamoDBTypeConverterFactory
  {
    private final DynamoDBTypeConverterFactory delegate;
    
    public DelegateFactory(DynamoDBTypeConverterFactory delegate)
    {
      this.delegate = delegate;
    }
    
    public <S, T> DynamoDBTypeConverter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
    {
      return delegate.getConverter(sourceType, targetType);
    }
  }
  
  private static class OverrideFactory
    extends DynamoDBTypeConverterFactory.DelegateFactory
  {
    private final DynamoDBTypeConverterFactory.ConverterMap overrides;
    
    public OverrideFactory(DynamoDBTypeConverterFactory defaults, DynamoDBTypeConverterFactory.ConverterMap overrides)
    {
      super();
      this.overrides = overrides;
    }
    
    public <S, T> DynamoDBTypeConverter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
    {
      DynamoDBTypeConverter<S, T> converter = overrides.get(sourceType, targetType);
      if (converter == null) {
        converter = super.getConverter(sourceType, targetType);
      }
      return converter;
    }
  }
  
  private static final class ConverterMap
    extends LinkedHashMap<DynamoDBTypeConverterFactory.Key<?, ?>, DynamoDBTypeConverter<?, ?>>
  {
    private static final long serialVersionUID = -1L;
    
    public <S, T> void put(Class<S> sourceType, Class<T> targetType, DynamoDBTypeConverter<? extends S, ? extends T> converter)
    {
      put(DynamoDBTypeConverterFactory.Key.of(sourceType, targetType), converter);
    }
    
    public <S, T> DynamoDBTypeConverter<S, T> get(Class<S> sourceType, Class<T> targetType)
    {
      for (Map.Entry<DynamoDBTypeConverterFactory.Key<?, ?>, DynamoDBTypeConverter<?, ?>> entry : entrySet()) {
        if (((DynamoDBTypeConverterFactory.Key)entry.getKey()).isAssignableFrom(sourceType, targetType)) {
          return (DynamoDBTypeConverter)entry.getValue();
        }
      }
      return null;
    }
  }
  
  private static final class Key<S, T>
    extends AbstractMap.SimpleImmutableEntry<Class<S>, Class<T>>
  {
    private static final long serialVersionUID = -1L;
    
    private Key(Class<S> sourceType, Class<T> targetType)
    {
      super(targetType);
    }
    
    public boolean isAssignableFrom(Class<?> sourceType, Class<?> targetType)
    {
      return (((Class)getKey()).isAssignableFrom(sourceType)) && (((Class)getValue()).isAssignableFrom(targetType));
    }
    
    public static <S, T> Key<S, T> of(Class<S> sourceType, Class<T> targetType)
    {
      return new Key(sourceType, targetType);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */