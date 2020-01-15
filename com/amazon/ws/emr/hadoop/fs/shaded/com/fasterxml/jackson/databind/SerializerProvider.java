package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class SerializerProvider
  extends DatabindContext
{
  protected static final boolean CACHE_UNKNOWN_MAPPINGS = false;
  public static final JsonSerializer<Object> DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
  protected static final JsonSerializer<Object> DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
  protected final SerializationConfig _config;
  protected final Class<?> _serializationView;
  protected final SerializerFactory _serializerFactory;
  protected final SerializerCache _serializerCache;
  protected transient ContextAttributes _attributes;
  protected JsonSerializer<Object> _unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
  protected JsonSerializer<Object> _keySerializer;
  protected JsonSerializer<Object> _nullValueSerializer = NullSerializer.instance;
  protected JsonSerializer<Object> _nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
  protected final ReadOnlyClassToSerializerMap _knownSerializers;
  protected DateFormat _dateFormat;
  protected final boolean _stdNullValueSerializer;
  
  public SerializerProvider()
  {
    _config = null;
    _serializerFactory = null;
    _serializerCache = new SerializerCache();
    
    _knownSerializers = null;
    
    _serializationView = null;
    _attributes = null;
    
    _stdNullValueSerializer = true;
  }
  
  protected SerializerProvider(SerializerProvider src, SerializationConfig config, SerializerFactory f)
  {
    if (config == null) {
      throw new NullPointerException();
    }
    _serializerFactory = f;
    _config = config;
    
    _serializerCache = _serializerCache;
    _unknownTypeSerializer = _unknownTypeSerializer;
    _keySerializer = _keySerializer;
    _nullValueSerializer = _nullValueSerializer;
    _nullKeySerializer = _nullKeySerializer;
    
    _stdNullValueSerializer = (_nullValueSerializer == DEFAULT_NULL_KEY_SERIALIZER);
    
    _serializationView = config.getActiveView();
    _attributes = config.getAttributes();
    
    _knownSerializers = _serializerCache.getReadOnlyLookupMap();
  }
  
  protected SerializerProvider(SerializerProvider src)
  {
    _config = null;
    _serializationView = null;
    _serializerFactory = null;
    _knownSerializers = null;
    
    _serializerCache = new SerializerCache();
    
    _unknownTypeSerializer = _unknownTypeSerializer;
    _keySerializer = _keySerializer;
    _nullValueSerializer = _nullValueSerializer;
    _nullKeySerializer = _nullKeySerializer;
    
    _stdNullValueSerializer = _stdNullValueSerializer;
  }
  
  public void setDefaultKeySerializer(JsonSerializer<Object> ks)
  {
    if (ks == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    _keySerializer = ks;
  }
  
  public void setNullValueSerializer(JsonSerializer<Object> nvs)
  {
    if (nvs == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    _nullValueSerializer = nvs;
  }
  
  public void setNullKeySerializer(JsonSerializer<Object> nks)
  {
    if (nks == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    _nullKeySerializer = nks;
  }
  
  public final SerializationConfig getConfig()
  {
    return _config;
  }
  
  public final AnnotationIntrospector getAnnotationIntrospector()
  {
    return _config.getAnnotationIntrospector();
  }
  
  public final TypeFactory getTypeFactory()
  {
    return _config.getTypeFactory();
  }
  
  public final Class<?> getActiveView()
  {
    return _serializationView;
  }
  
  @Deprecated
  public final Class<?> getSerializationView()
  {
    return _serializationView;
  }
  
  public Locale getLocale()
  {
    return _config.getLocale();
  }
  
  public TimeZone getTimeZone()
  {
    return _config.getTimeZone();
  }
  
  public Object getAttribute(Object key)
  {
    return _attributes.getAttribute(key);
  }
  
  public SerializerProvider setAttribute(Object key, Object value)
  {
    _attributes = _attributes.withPerCallAttribute(key, value);
    return this;
  }
  
  public final boolean isEnabled(SerializationFeature feature)
  {
    return _config.isEnabled(feature);
  }
  
  public final boolean hasSerializationFeatures(int featureMask)
  {
    return _config.hasSerializationFeatures(featureMask);
  }
  
  public final FilterProvider getFilterProvider()
  {
    return _config.getFilterProvider();
  }
  
  public abstract WritableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator);
  
  public JsonSerializer<Object> findValueSerializer(Class<?> valueType, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _serializerCache.untypedValueSerializer(_config.constructType(valueType));
        if (ser == null)
        {
          ser = _createAndCacheUntypedSerializer(valueType);
          if (ser == null)
          {
            ser = getUnknownTypeSerializer(valueType);
            
            return ser;
          }
        }
      }
    }
    return handleSecondaryContextualization(ser, property);
  }
  
  public JsonSerializer<Object> findValueSerializer(JavaType valueType, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _createAndCacheUntypedSerializer(valueType);
        if (ser == null)
        {
          ser = getUnknownTypeSerializer(valueType.getRawClass());
          
          return ser;
        }
      }
    }
    return handleSecondaryContextualization(ser, property);
  }
  
  public JsonSerializer<Object> findValueSerializer(Class<?> valueType)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _serializerCache.untypedValueSerializer(_config.constructType(valueType));
        if (ser == null)
        {
          ser = _createAndCacheUntypedSerializer(valueType);
          if (ser == null) {
            ser = getUnknownTypeSerializer(valueType);
          }
        }
      }
    }
    return ser;
  }
  
  public JsonSerializer<Object> findValueSerializer(JavaType valueType)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _createAndCacheUntypedSerializer(valueType);
        if (ser == null) {
          ser = getUnknownTypeSerializer(valueType.getRawClass());
        }
      }
    }
    return ser;
  }
  
  public JsonSerializer<Object> findPrimaryPropertySerializer(JavaType valueType, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _createAndCacheUntypedSerializer(valueType);
        if (ser == null)
        {
          ser = getUnknownTypeSerializer(valueType.getRawClass());
          
          return ser;
        }
      }
    }
    return handlePrimaryContextualization(ser, property);
  }
  
  public JsonSerializer<Object> findPrimaryPropertySerializer(Class<?> valueType, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(valueType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(valueType);
      if (ser == null)
      {
        ser = _serializerCache.untypedValueSerializer(_config.constructType(valueType));
        if (ser == null)
        {
          ser = _createAndCacheUntypedSerializer(valueType);
          if (ser == null)
          {
            ser = getUnknownTypeSerializer(valueType);
            
            return ser;
          }
        }
      }
    }
    return handlePrimaryContextualization(ser, property);
  }
  
  public JsonSerializer<Object> findTypedValueSerializer(Class<?> valueType, boolean cache, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.typedValueSerializer(valueType);
    if (ser != null) {
      return ser;
    }
    ser = _serializerCache.typedValueSerializer(valueType);
    if (ser != null) {
      return ser;
    }
    ser = findValueSerializer(valueType, property);
    TypeSerializer typeSer = _serializerFactory.createTypeSerializer(_config, _config.constructType(valueType));
    if (typeSer != null)
    {
      typeSer = typeSer.forProperty(property);
      ser = new TypeWrappedSerializer(typeSer, ser);
    }
    if (cache) {
      _serializerCache.addTypedSerializer(valueType, ser);
    }
    return ser;
  }
  
  public JsonSerializer<Object> findTypedValueSerializer(JavaType valueType, boolean cache, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.typedValueSerializer(valueType);
    if (ser != null) {
      return ser;
    }
    ser = _serializerCache.typedValueSerializer(valueType);
    if (ser != null) {
      return ser;
    }
    ser = findValueSerializer(valueType, property);
    TypeSerializer typeSer = _serializerFactory.createTypeSerializer(_config, valueType);
    if (typeSer != null)
    {
      typeSer = typeSer.forProperty(property);
      ser = new TypeWrappedSerializer(typeSer, ser);
    }
    if (cache) {
      _serializerCache.addTypedSerializer(valueType, ser);
    }
    return ser;
  }
  
  public TypeSerializer findTypeSerializer(JavaType javaType)
    throws JsonMappingException
  {
    return _serializerFactory.createTypeSerializer(_config, javaType);
  }
  
  public JsonSerializer<Object> findKeySerializer(JavaType keyType, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _serializerFactory.createKeySerializer(_config, keyType, _keySerializer);
    
    return _handleContextualResolvable(ser, property);
  }
  
  public JsonSerializer<Object> findKeySerializer(Class<?> rawKeyType, BeanProperty property)
    throws JsonMappingException
  {
    return findKeySerializer(_config.constructType(rawKeyType), property);
  }
  
  public JsonSerializer<Object> getDefaultNullKeySerializer()
  {
    return _nullKeySerializer;
  }
  
  public JsonSerializer<Object> getDefaultNullValueSerializer()
  {
    return _nullValueSerializer;
  }
  
  public JsonSerializer<Object> findNullKeySerializer(JavaType serializationType, BeanProperty property)
    throws JsonMappingException
  {
    return _nullKeySerializer;
  }
  
  public JsonSerializer<Object> findNullValueSerializer(BeanProperty property)
    throws JsonMappingException
  {
    return _nullValueSerializer;
  }
  
  public JsonSerializer<Object> getUnknownTypeSerializer(Class<?> unknownType)
  {
    if (unknownType == Object.class) {
      return _unknownTypeSerializer;
    }
    return new UnknownSerializer(unknownType);
  }
  
  public boolean isUnknownTypeSerializer(JsonSerializer<?> ser)
  {
    if ((ser == _unknownTypeSerializer) || (ser == null)) {
      return true;
    }
    if ((isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) && 
      (ser.getClass() == UnknownSerializer.class)) {
      return true;
    }
    return false;
  }
  
  public abstract JsonSerializer<Object> serializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException;
  
  public JsonSerializer<?> handlePrimaryContextualization(JsonSerializer<?> ser, BeanProperty property)
    throws JsonMappingException
  {
    if ((ser != null) && 
      ((ser instanceof ContextualSerializer))) {
      ser = ((ContextualSerializer)ser).createContextual(this, property);
    }
    return ser;
  }
  
  public JsonSerializer<?> handleSecondaryContextualization(JsonSerializer<?> ser, BeanProperty property)
    throws JsonMappingException
  {
    if ((ser != null) && 
      ((ser instanceof ContextualSerializer))) {
      ser = ((ContextualSerializer)ser).createContextual(this, property);
    }
    return ser;
  }
  
  public final void defaultSerializeValue(Object value, JsonGenerator jgen)
    throws IOException
  {
    if (value == null)
    {
      if (_stdNullValueSerializer) {
        jgen.writeNull();
      } else {
        _nullValueSerializer.serialize(null, jgen, this);
      }
    }
    else
    {
      Class<?> cls = value.getClass();
      findTypedValueSerializer(cls, true, null).serialize(value, jgen, this);
    }
  }
  
  public final void defaultSerializeField(String fieldName, Object value, JsonGenerator jgen)
    throws IOException
  {
    jgen.writeFieldName(fieldName);
    if (value == null)
    {
      if (_stdNullValueSerializer) {
        jgen.writeNull();
      } else {
        _nullValueSerializer.serialize(null, jgen, this);
      }
    }
    else
    {
      Class<?> cls = value.getClass();
      findTypedValueSerializer(cls, true, null).serialize(value, jgen, this);
    }
  }
  
  public final void defaultSerializeDateValue(long timestamp, JsonGenerator gen)
    throws IOException
  {
    if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
      gen.writeNumber(timestamp);
    } else {
      gen.writeString(_dateFormat().format(new Date(timestamp)));
    }
  }
  
  public final void defaultSerializeDateValue(Date date, JsonGenerator gen)
    throws IOException
  {
    if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
      gen.writeNumber(date.getTime());
    } else {
      gen.writeString(_dateFormat().format(date));
    }
  }
  
  public void defaultSerializeDateKey(long timestamp, JsonGenerator gen)
    throws IOException
  {
    if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
      gen.writeFieldName(String.valueOf(timestamp));
    } else {
      gen.writeFieldName(_dateFormat().format(new Date(timestamp)));
    }
  }
  
  public void defaultSerializeDateKey(Date date, JsonGenerator gen)
    throws IOException
  {
    if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
      gen.writeFieldName(String.valueOf(date.getTime()));
    } else {
      gen.writeFieldName(_dateFormat().format(date));
    }
  }
  
  public final void defaultSerializeNull(JsonGenerator jgen)
    throws IOException
  {
    if (_stdNullValueSerializer) {
      jgen.writeNull();
    } else {
      _nullValueSerializer.serialize(null, jgen, this);
    }
  }
  
  public JsonMappingException mappingException(String message, Object... args)
  {
    if ((args != null) && (args.length > 0)) {
      message = String.format(message, args);
    }
    return new JsonMappingException(message);
  }
  
  protected void _reportIncompatibleRootType(Object value, JavaType rootType)
    throws IOException, JsonProcessingException
  {
    if (rootType.isPrimitive())
    {
      Class<?> wrapperType = ClassUtil.wrapperType(rootType.getRawClass());
      if (wrapperType.isAssignableFrom(value.getClass())) {
        return;
      }
    }
    throw new JsonMappingException("Incompatible types: declared root type (" + rootType + ") vs " + value.getClass().getName());
  }
  
  protected JsonSerializer<Object> _findExplicitUntypedSerializer(Class<?> runtimeType)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser = _knownSerializers.untypedValueSerializer(runtimeType);
    if (ser == null)
    {
      ser = _serializerCache.untypedValueSerializer(runtimeType);
      if (ser == null) {
        ser = _createAndCacheUntypedSerializer(runtimeType);
      }
    }
    if (isUnknownTypeSerializer(ser)) {
      return null;
    }
    return ser;
  }
  
  protected JsonSerializer<Object> _createAndCacheUntypedSerializer(Class<?> rawType)
    throws JsonMappingException
  {
    JavaType type = _config.constructType(rawType);
    JsonSerializer<Object> ser;
    try
    {
      ser = _createUntypedSerializer(type);
    }
    catch (IllegalArgumentException iae)
    {
      throw new JsonMappingException(iae.getMessage(), null, iae);
    }
    if (ser != null) {
      _serializerCache.addAndResolveNonTypedSerializer(type, ser, this);
    }
    return ser;
  }
  
  protected JsonSerializer<Object> _createAndCacheUntypedSerializer(JavaType type)
    throws JsonMappingException
  {
    JsonSerializer<Object> ser;
    try
    {
      ser = _createUntypedSerializer(type);
    }
    catch (IllegalArgumentException iae)
    {
      throw new JsonMappingException(iae.getMessage(), null, iae);
    }
    if (ser != null) {
      _serializerCache.addAndResolveNonTypedSerializer(type, ser, this);
    }
    return ser;
  }
  
  /* Error */
  protected JsonSerializer<Object> _createUntypedSerializer(JavaType type)
    throws JsonMappingException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/SerializerProvider:_serializerCache	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerCache;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 56	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/SerializerProvider:_serializerFactory	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerFactory;
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 449	com/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/ser/SerializerFactory:createSerializer	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/SerializerProvider;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JavaType;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/fasterxml/jackson/databind/JsonSerializer;
    //   16: aload_2
    //   17: monitorexit
    //   18: areturn
    //   19: astore_3
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_3
    //   23: athrow
    // Line number table:
    //   Java source line #1201	-> byte code offset #0
    //   Java source line #1203	-> byte code offset #7
    //   Java source line #1204	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SerializerProvider
    //   0	24	1	type	JavaType
    //   5	16	2	Ljava/lang/Object;	Object
    //   19	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  protected JsonSerializer<Object> _handleContextualResolvable(JsonSerializer<?> ser, BeanProperty property)
    throws JsonMappingException
  {
    if ((ser instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)ser).resolve(this);
    }
    return handleSecondaryContextualization(ser, property);
  }
  
  protected JsonSerializer<Object> _handleResolvable(JsonSerializer<?> ser)
    throws JsonMappingException
  {
    if ((ser instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)ser).resolve(this);
    }
    return ser;
  }
  
  protected final DateFormat _dateFormat()
  {
    if (_dateFormat != null) {
      return _dateFormat;
    }
    DateFormat df = _config.getDateFormat();
    _dateFormat = (df = (DateFormat)df.clone());
    
    return df;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */