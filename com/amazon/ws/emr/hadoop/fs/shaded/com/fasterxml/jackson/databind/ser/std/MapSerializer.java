package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer
  extends ContainerSerializer<Map<?, ?>>
  implements ContextualSerializer
{
  private static final long serialVersionUID = 1L;
  protected static final JavaType UNSPECIFIED_TYPE = ;
  protected final BeanProperty _property;
  protected final HashSet<String> _ignoredEntries;
  protected final boolean _valueTypeIsStatic;
  protected final JavaType _keyType;
  protected final JavaType _valueType;
  protected JsonSerializer<Object> _keySerializer;
  protected JsonSerializer<Object> _valueSerializer;
  protected final TypeSerializer _valueTypeSerializer;
  protected PropertySerializerMap _dynamicValueSerializers;
  protected final Object _filterId;
  protected final boolean _sortKeys;
  protected final Object _suppressableValue;
  
  protected MapSerializer(HashSet<String> ignoredEntries, JavaType keyType, JavaType valueType, boolean valueTypeIsStatic, TypeSerializer vts, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer)
  {
    super(Map.class, false);
    _ignoredEntries = ignoredEntries;
    _keyType = keyType;
    _valueType = valueType;
    _valueTypeIsStatic = valueTypeIsStatic;
    _valueTypeSerializer = vts;
    _keySerializer = keySerializer;
    _valueSerializer = valueSerializer;
    _dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
    _property = null;
    _filterId = null;
    _sortKeys = false;
    _suppressableValue = null;
  }
  
  protected void _ensureOverride()
  {
    if (getClass() != MapSerializer.class) {
      throw new IllegalStateException("Missing override in class " + getClass().getName());
    }
  }
  
  protected MapSerializer(MapSerializer src, BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer, HashSet<String> ignored)
  {
    super(Map.class, false);
    _ignoredEntries = ignored;
    _keyType = _keyType;
    _valueType = _valueType;
    _valueTypeIsStatic = _valueTypeIsStatic;
    _valueTypeSerializer = _valueTypeSerializer;
    _keySerializer = keySerializer;
    _valueSerializer = valueSerializer;
    _dynamicValueSerializers = _dynamicValueSerializers;
    _property = property;
    _filterId = _filterId;
    _sortKeys = _sortKeys;
    _suppressableValue = _suppressableValue;
  }
  
  @Deprecated
  protected MapSerializer(MapSerializer src, TypeSerializer vts)
  {
    this(src, vts, _suppressableValue);
  }
  
  protected MapSerializer(MapSerializer src, TypeSerializer vts, Object suppressableValue)
  {
    super(Map.class, false);
    _ignoredEntries = _ignoredEntries;
    _keyType = _keyType;
    _valueType = _valueType;
    _valueTypeIsStatic = _valueTypeIsStatic;
    _valueTypeSerializer = vts;
    _keySerializer = _keySerializer;
    _valueSerializer = _valueSerializer;
    _dynamicValueSerializers = _dynamicValueSerializers;
    _property = _property;
    _filterId = _filterId;
    _sortKeys = _sortKeys;
    if (suppressableValue == JsonInclude.Include.NON_ABSENT) {
      suppressableValue = _valueType.isReferenceType() ? JsonInclude.Include.NON_EMPTY : JsonInclude.Include.NON_NULL;
    }
    _suppressableValue = suppressableValue;
  }
  
  protected MapSerializer(MapSerializer src, Object filterId, boolean sortKeys)
  {
    super(Map.class, false);
    _ignoredEntries = _ignoredEntries;
    _keyType = _keyType;
    _valueType = _valueType;
    _valueTypeIsStatic = _valueTypeIsStatic;
    _valueTypeSerializer = _valueTypeSerializer;
    _keySerializer = _keySerializer;
    _valueSerializer = _valueSerializer;
    _dynamicValueSerializers = _dynamicValueSerializers;
    _property = _property;
    _filterId = filterId;
    _sortKeys = sortKeys;
    _suppressableValue = _suppressableValue;
  }
  
  public MapSerializer _withValueTypeSerializer(TypeSerializer vts)
  {
    if (_valueTypeSerializer == vts) {
      return this;
    }
    _ensureOverride();
    return new MapSerializer(this, vts, null);
  }
  
  public MapSerializer withResolved(BeanProperty property, JsonSerializer<?> keySerializer, JsonSerializer<?> valueSerializer, HashSet<String> ignored, boolean sortKeys)
  {
    _ensureOverride();
    MapSerializer ser = new MapSerializer(this, property, keySerializer, valueSerializer, ignored);
    if (sortKeys != _sortKeys) {
      ser = new MapSerializer(ser, _filterId, sortKeys);
    }
    return ser;
  }
  
  public MapSerializer withFilterId(Object filterId)
  {
    if (_filterId == filterId) {
      return this;
    }
    _ensureOverride();
    return new MapSerializer(this, filterId, _sortKeys);
  }
  
  public MapSerializer withContentInclusion(Object suppressableValue)
  {
    if (suppressableValue == _suppressableValue) {
      return this;
    }
    _ensureOverride();
    return new MapSerializer(this, _valueTypeSerializer, suppressableValue);
  }
  
  public static MapSerializer construct(String[] ignoredList, JavaType mapType, boolean staticValueType, TypeSerializer vts, JsonSerializer<Object> keySerializer, JsonSerializer<Object> valueSerializer, Object filterId)
  {
    HashSet<String> ignoredEntries = (ignoredList == null) || (ignoredList.length == 0) ? null : ArrayBuilders.arrayToSet(ignoredList);
    JavaType keyType;
    JavaType keyType;
    JavaType valueType;
    if (mapType == null)
    {
      JavaType valueType;
      keyType = valueType = UNSPECIFIED_TYPE;
    }
    else
    {
      keyType = mapType.getKeyType();
      valueType = mapType.getContentType();
    }
    if (!staticValueType) {
      staticValueType = (valueType != null) && (valueType.isFinal());
    } else if (valueType.getRawClass() == Object.class) {
      staticValueType = false;
    }
    MapSerializer ser = new MapSerializer(ignoredEntries, keyType, valueType, staticValueType, vts, keySerializer, valueSerializer);
    if (filterId != null) {
      ser = ser.withFilterId(filterId);
    }
    return ser;
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = null;
    JsonSerializer<?> keySer = null;
    AnnotationIntrospector intr = provider.getAnnotationIntrospector();
    AnnotatedMember propertyAcc = property == null ? null : property.getMember();
    Object suppressableValue = _suppressableValue;
    if ((propertyAcc != null) && (intr != null))
    {
      Object serDef = intr.findKeySerializer(propertyAcc);
      if (serDef != null) {
        keySer = provider.serializerInstance(propertyAcc, serDef);
      }
      serDef = intr.findContentSerializer(propertyAcc);
      if (serDef != null) {
        ser = provider.serializerInstance(propertyAcc, serDef);
      }
      JsonInclude.Include incl = intr.findSerializationInclusionForContent(propertyAcc, null);
      if (incl != null) {
        suppressableValue = incl;
      }
    }
    if (ser == null) {
      ser = _valueSerializer;
    }
    ser = findConvertingContentSerializer(provider, property, ser);
    if (ser == null)
    {
      if (((_valueTypeIsStatic) && (_valueType.getRawClass() != Object.class)) || (hasContentTypeAnnotation(provider, property))) {
        ser = provider.findValueSerializer(_valueType, property);
      }
    }
    else {
      ser = provider.handleSecondaryContextualization(ser, property);
    }
    if (keySer == null) {
      keySer = _keySerializer;
    }
    if (keySer == null) {
      keySer = provider.findKeySerializer(_keyType, property);
    } else {
      keySer = provider.handleSecondaryContextualization(keySer, property);
    }
    HashSet<String> ignored = _ignoredEntries;
    boolean sortKeys = false;
    if ((intr != null) && (propertyAcc != null))
    {
      String[] moreToIgnore = intr.findPropertiesToIgnore(propertyAcc, true);
      if (moreToIgnore != null)
      {
        ignored = ignored == null ? new HashSet() : new HashSet(ignored);
        for (String str : moreToIgnore) {
          ignored.add(str);
        }
      }
      Boolean b = intr.findSerializationSortAlphabetically(propertyAcc);
      sortKeys = (b != null) && (b.booleanValue());
    }
    MapSerializer mser = withResolved(property, keySer, ser, ignored, sortKeys);
    if (suppressableValue != _suppressableValue) {
      mser = mser.withContentInclusion(suppressableValue);
    }
    if (property != null)
    {
      AnnotatedMember m = property.getMember();
      if (m != null)
      {
        Object filterId = intr.findFilterId(m);
        if (filterId != null) {
          mser = mser.withFilterId(filterId);
        }
      }
    }
    return mser;
  }
  
  public JavaType getContentType()
  {
    return _valueType;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return _valueSerializer;
  }
  
  public boolean isEmpty(SerializerProvider prov, Map<?, ?> value)
  {
    return (value == null) || (value.isEmpty());
  }
  
  public boolean hasSingleElement(Map<?, ?> value)
  {
    return value.size() == 1;
  }
  
  public JsonSerializer<?> getKeySerializer()
  {
    return _keySerializer;
  }
  
  public void serialize(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeStartObject();
    
    gen.setCurrentValue(value);
    if (!value.isEmpty())
    {
      Object suppressableValue = _suppressableValue;
      if (suppressableValue == JsonInclude.Include.ALWAYS) {
        suppressableValue = null;
      } else if ((suppressableValue == null) && 
        (!provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES))) {
        suppressableValue = JsonInclude.Include.NON_NULL;
      }
      if ((_sortKeys) || (provider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS))) {
        value = _orderEntries(value);
      }
      if (_filterId != null) {
        serializeFilteredFields(value, gen, provider, findPropertyFilter(provider, _filterId, value), suppressableValue);
      } else if (suppressableValue != null) {
        serializeOptionalFields(value, gen, provider, suppressableValue);
      } else if (_valueSerializer != null) {
        serializeFieldsUsing(value, gen, provider, _valueSerializer);
      } else {
        serializeFields(value, gen, provider);
      }
    }
    gen.writeEndObject();
  }
  
  public void serializeWithType(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForObject(value, gen);
    
    gen.setCurrentValue(value);
    if (!value.isEmpty())
    {
      Object suppressableValue = _suppressableValue;
      if (suppressableValue == JsonInclude.Include.ALWAYS) {
        suppressableValue = null;
      } else if ((suppressableValue == null) && 
        (!provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES))) {
        suppressableValue = JsonInclude.Include.NON_NULL;
      }
      if ((_sortKeys) || (provider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS))) {
        value = _orderEntries(value);
      }
      if (_filterId != null) {
        serializeFilteredFields(value, gen, provider, findPropertyFilter(provider, _filterId, value), suppressableValue);
      } else if (suppressableValue != null) {
        serializeOptionalFields(value, gen, provider, suppressableValue);
      } else if (_valueSerializer != null) {
        serializeFieldsUsing(value, gen, provider, _valueSerializer);
      } else {
        serializeFields(value, gen, provider);
      }
    }
    typeSer.writeTypeSuffixForObject(value, gen);
  }
  
  public void serializeFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (_valueTypeSerializer != null)
    {
      serializeTypedFields(value, gen, provider, null);
      return;
    }
    JsonSerializer<Object> keySerializer = _keySerializer;
    HashSet<String> ignored = _ignoredEntries;
    
    PropertySerializerMap serializers = _dynamicValueSerializers;
    for (Map.Entry<?, ?> entry : value.entrySet())
    {
      Object valueElem = entry.getValue();
      
      Object keyElem = entry.getKey();
      if (keyElem == null)
      {
        provider.findNullKeySerializer(_keyType, _property).serialize(null, gen, provider);
      }
      else
      {
        if ((ignored != null) && (ignored.contains(keyElem))) {
          continue;
        }
        keySerializer.serialize(keyElem, gen, provider);
      }
      if (valueElem == null)
      {
        provider.defaultSerializeNull(gen);
      }
      else
      {
        Class<?> cc = valueElem.getClass();
        JsonSerializer<Object> serializer = serializers.serializerFor(cc);
        if (serializer == null)
        {
          if (_valueType.hasGenericTypes()) {
            serializer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_valueType, cc), provider);
          } else {
            serializer = _findAndAddDynamic(serializers, cc, provider);
          }
          serializers = _dynamicValueSerializers;
        }
        try
        {
          serializer.serialize(valueElem, gen, provider);
        }
        catch (Exception e)
        {
          String keyDesc = "" + keyElem;
          wrapAndThrow(provider, e, value, keyDesc);
        }
      }
    }
  }
  
  public void serializeOptionalFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, Object suppressableValue)
    throws IOException
  {
    if (_valueTypeSerializer != null)
    {
      serializeTypedFields(value, gen, provider, suppressableValue);
      return;
    }
    HashSet<String> ignored = _ignoredEntries;
    PropertySerializerMap serializers = _dynamicValueSerializers;
    for (Map.Entry<?, ?> entry : value.entrySet())
    {
      Object keyElem = entry.getKey();
      JsonSerializer<Object> keySerializer;
      JsonSerializer<Object> keySerializer;
      if (keyElem == null)
      {
        keySerializer = provider.findNullKeySerializer(_keyType, _property);
      }
      else
      {
        if ((ignored != null) && (ignored.contains(keyElem))) {
          continue;
        }
        keySerializer = _keySerializer;
      }
      Object valueElem = entry.getValue();
      JsonSerializer<Object> valueSer;
      if (valueElem == null)
      {
        if (suppressableValue != null) {
          continue;
        }
        JsonSerializer<Object> valueSer = provider.getDefaultNullValueSerializer();
      }
      else
      {
        valueSer = _valueSerializer;
        if (valueSer == null)
        {
          Class<?> cc = valueElem.getClass();
          valueSer = serializers.serializerFor(cc);
          if (valueSer == null)
          {
            if (_valueType.hasGenericTypes()) {
              valueSer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_valueType, cc), provider);
            } else {
              valueSer = _findAndAddDynamic(serializers, cc, provider);
            }
            serializers = _dynamicValueSerializers;
          }
        }
        if ((suppressableValue == JsonInclude.Include.NON_EMPTY) && (valueSer.isEmpty(provider, valueElem))) {
          continue;
        }
      }
      try
      {
        keySerializer.serialize(keyElem, gen, provider);
        valueSer.serialize(valueElem, gen, provider);
      }
      catch (Exception e)
      {
        String keyDesc = "" + keyElem;
        wrapAndThrow(provider, e, value, keyDesc);
      }
    }
  }
  
  protected void serializeFieldsUsing(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, JsonSerializer<Object> ser)
    throws IOException
  {
    JsonSerializer<Object> keySerializer = _keySerializer;
    HashSet<String> ignored = _ignoredEntries;
    TypeSerializer typeSer = _valueTypeSerializer;
    for (Map.Entry<?, ?> entry : value.entrySet())
    {
      Object keyElem = entry.getKey();
      if ((ignored == null) || (!ignored.contains(keyElem)))
      {
        if (keyElem == null) {
          provider.findNullKeySerializer(_keyType, _property).serialize(null, gen, provider);
        } else {
          keySerializer.serialize(keyElem, gen, provider);
        }
        Object valueElem = entry.getValue();
        if (valueElem == null) {
          provider.defaultSerializeNull(gen);
        } else {
          try
          {
            if (typeSer == null) {
              ser.serialize(valueElem, gen, provider);
            } else {
              ser.serializeWithType(valueElem, gen, provider, typeSer);
            }
          }
          catch (Exception e)
          {
            String keyDesc = "" + keyElem;
            wrapAndThrow(provider, e, value, keyDesc);
          }
        }
      }
    }
  }
  
  public void serializeFilteredFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, PropertyFilter filter, Object suppressableValue)
    throws IOException
  {
    HashSet<String> ignored = _ignoredEntries;
    
    PropertySerializerMap serializers = _dynamicValueSerializers;
    MapProperty prop = new MapProperty(_valueTypeSerializer, _property);
    for (Map.Entry<?, ?> entry : value.entrySet())
    {
      Object keyElem = entry.getKey();
      if ((ignored == null) || (!ignored.contains(keyElem)))
      {
        JsonSerializer<Object> keySerializer;
        JsonSerializer<Object> keySerializer;
        if (keyElem == null) {
          keySerializer = provider.findNullKeySerializer(_keyType, _property);
        } else {
          keySerializer = _keySerializer;
        }
        Object valueElem = entry.getValue();
        JsonSerializer<Object> valueSer;
        if (valueElem == null)
        {
          if (suppressableValue != null) {
            continue;
          }
          JsonSerializer<Object> valueSer = provider.getDefaultNullValueSerializer();
        }
        else
        {
          valueSer = _valueSerializer;
          if (valueSer == null)
          {
            Class<?> cc = valueElem.getClass();
            valueSer = serializers.serializerFor(cc);
            if (valueSer == null)
            {
              if (_valueType.hasGenericTypes()) {
                valueSer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_valueType, cc), provider);
              } else {
                valueSer = _findAndAddDynamic(serializers, cc, provider);
              }
              serializers = _dynamicValueSerializers;
            }
          }
          if ((suppressableValue == JsonInclude.Include.NON_EMPTY) && (valueSer.isEmpty(provider, valueElem))) {
            continue;
          }
        }
        prop.reset(keyElem, keySerializer, valueSer);
        try
        {
          filter.serializeAsField(valueElem, gen, provider, prop);
        }
        catch (Exception e)
        {
          String keyDesc = "" + keyElem;
          wrapAndThrow(provider, e, value, keyDesc);
        }
      }
    }
  }
  
  @Deprecated
  public void serializeFilteredFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, PropertyFilter filter)
    throws IOException
  {
    serializeFilteredFields(value, gen, provider, filter, provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : JsonInclude.Include.NON_NULL);
  }
  
  protected void serializeTypedFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider, Object suppressableValue)
    throws IOException
  {
    HashSet<String> ignored = _ignoredEntries;
    PropertySerializerMap serializers = _dynamicValueSerializers;
    for (Map.Entry<?, ?> entry : value.entrySet())
    {
      Object keyElem = entry.getKey();
      JsonSerializer<Object> keySerializer;
      JsonSerializer<Object> keySerializer;
      if (keyElem == null)
      {
        keySerializer = provider.findNullKeySerializer(_keyType, _property);
      }
      else
      {
        if ((ignored != null) && (ignored.contains(keyElem))) {
          continue;
        }
        keySerializer = _keySerializer;
      }
      Object valueElem = entry.getValue();
      JsonSerializer<Object> valueSer;
      if (valueElem == null)
      {
        if (suppressableValue != null) {
          continue;
        }
        JsonSerializer<Object> valueSer = provider.getDefaultNullValueSerializer();
      }
      else
      {
        valueSer = _valueSerializer;
        Class<?> cc = valueElem.getClass();
        valueSer = serializers.serializerFor(cc);
        if (valueSer == null)
        {
          if (_valueType.hasGenericTypes()) {
            valueSer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_valueType, cc), provider);
          } else {
            valueSer = _findAndAddDynamic(serializers, cc, provider);
          }
          serializers = _dynamicValueSerializers;
        }
        if ((suppressableValue == JsonInclude.Include.NON_EMPTY) && (valueSer.isEmpty(provider, valueElem))) {
          continue;
        }
      }
      keySerializer.serialize(keyElem, gen, provider);
      try
      {
        valueSer.serializeWithType(valueElem, gen, provider, _valueTypeSerializer);
      }
      catch (Exception e)
      {
        String keyDesc = "" + keyElem;
        wrapAndThrow(provider, e, value, keyDesc);
      }
    }
  }
  
  @Deprecated
  protected void serializeTypedFields(Map<?, ?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    serializeTypedFields(value, gen, provider, provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : JsonInclude.Include.NON_NULL);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    ObjectNode o = createSchemaNode("object", true);
    
    return o;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    JsonMapFormatVisitor v2 = visitor == null ? null : visitor.expectMapFormat(typeHint);
    if (v2 != null)
    {
      v2.keyFormat(_keySerializer, _keyType);
      JsonSerializer<?> valueSer = _valueSerializer;
      if (valueSer == null) {
        valueSer = _findAndAddDynamic(_dynamicValueSerializers, _valueType, visitor.getProvider());
      }
      v2.valueFormat(valueSer, _valueType);
    }
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicValueSerializers = map;
    }
    return serializer;
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, JavaType type, SerializerProvider provider)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result = map.findAndAddSecondarySerializer(type, provider, _property);
    if (map != map) {
      _dynamicValueSerializers = map;
    }
    return serializer;
  }
  
  protected Map<?, ?> _orderEntries(Map<?, ?> input)
  {
    if ((input instanceof SortedMap)) {
      return input;
    }
    return new TreeMap(input);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.MapSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */