package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JacksonStdImpl
public class MapDeserializer
  extends ContainerDeserializerBase<Map<Object, Object>>
  implements ContextualDeserializer, ResolvableDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _mapType;
  protected final KeyDeserializer _keyDeserializer;
  protected boolean _standardStringKey;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  protected final boolean _hasDefaultCreator;
  protected JsonDeserializer<Object> _delegateDeserializer;
  protected PropertyBasedCreator _propertyBasedCreator;
  protected HashSet<String> _ignorableProperties;
  
  public MapDeserializer(JavaType mapType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser)
  {
    super(mapType);
    _mapType = mapType;
    _keyDeserializer = keyDeser;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
    _valueInstantiator = valueInstantiator;
    _hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
    _delegateDeserializer = null;
    _propertyBasedCreator = null;
    _standardStringKey = _isStdKeyDeser(mapType, keyDeser);
  }
  
  protected MapDeserializer(MapDeserializer src)
  {
    super(_mapType);
    _mapType = _mapType;
    _keyDeserializer = _keyDeserializer;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _valueInstantiator = _valueInstantiator;
    _propertyBasedCreator = _propertyBasedCreator;
    _delegateDeserializer = _delegateDeserializer;
    _hasDefaultCreator = _hasDefaultCreator;
    
    _ignorableProperties = _ignorableProperties;
    
    _standardStringKey = _standardStringKey;
  }
  
  protected MapDeserializer(MapDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, HashSet<String> ignorable)
  {
    super(_mapType);
    _mapType = _mapType;
    _keyDeserializer = keyDeser;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
    _valueInstantiator = _valueInstantiator;
    _propertyBasedCreator = _propertyBasedCreator;
    _delegateDeserializer = _delegateDeserializer;
    _hasDefaultCreator = _hasDefaultCreator;
    _ignorableProperties = ignorable;
    
    _standardStringKey = _isStdKeyDeser(_mapType, keyDeser);
  }
  
  protected MapDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser, HashSet<String> ignorable)
  {
    if ((_keyDeserializer == keyDeser) && (_valueDeserializer == valueDeser) && (_valueTypeDeserializer == valueTypeDeser) && (_ignorableProperties == ignorable)) {
      return this;
    }
    return new MapDeserializer(this, keyDeser, valueDeser, valueTypeDeser, ignorable);
  }
  
  protected final boolean _isStdKeyDeser(JavaType mapType, KeyDeserializer keyDeser)
  {
    if (keyDeser == null) {
      return true;
    }
    JavaType keyType = mapType.getKeyType();
    if (keyType == null) {
      return true;
    }
    Class<?> rawKeyType = keyType.getRawClass();
    return ((rawKeyType == String.class) || (rawKeyType == Object.class)) && (isDefaultKeyDeserializer(keyDeser));
  }
  
  public void setIgnorableProperties(String[] ignorable)
  {
    _ignorableProperties = ((ignorable == null) || (ignorable.length == 0) ? null : ArrayBuilders.arrayToSet(ignorable));
  }
  
  public void resolve(DeserializationContext ctxt)
    throws JsonMappingException
  {
    if (_valueInstantiator.canCreateUsingDelegate())
    {
      JavaType delegateType = _valueInstantiator.getDelegateType(ctxt.getConfig());
      if (delegateType == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + _mapType + ": value instantiator (" + _valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      _delegateDeserializer = findDeserializer(ctxt, delegateType, null);
    }
    if (_valueInstantiator.canCreateFromObjectWith())
    {
      SettableBeanProperty[] creatorProps = _valueInstantiator.getFromObjectArguments(ctxt.getConfig());
      _propertyBasedCreator = PropertyBasedCreator.construct(ctxt, _valueInstantiator, creatorProps);
    }
    _standardStringKey = _isStdKeyDeser(_mapType, _keyDeserializer);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    KeyDeserializer kd = _keyDeserializer;
    if (kd == null) {
      kd = ctxt.findKeyDeserializer(_mapType.getKeyType(), property);
    } else if ((kd instanceof ContextualKeyDeserializer)) {
      kd = ((ContextualKeyDeserializer)kd).createContextual(ctxt, property);
    }
    JsonDeserializer<?> vd = _valueDeserializer;
    if (property != null) {
      vd = findConvertingContentDeserializer(ctxt, property, vd);
    }
    JavaType vt = _mapType.getContentType();
    if (vd == null) {
      vd = ctxt.findContextualValueDeserializer(vt, property);
    } else {
      vd = ctxt.handleSecondaryContextualization(vd, property, vt);
    }
    TypeDeserializer vtd = _valueTypeDeserializer;
    if (vtd != null) {
      vtd = vtd.forProperty(property);
    }
    HashSet<String> ignored = _ignorableProperties;
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    if ((intr != null) && (property != null))
    {
      AnnotatedMember member = property.getMember();
      if (member != null)
      {
        String[] moreToIgnore = intr.findPropertiesToIgnore(member, false);
        if (moreToIgnore != null)
        {
          ignored = ignored == null ? new HashSet() : new HashSet(ignored);
          for (String str : moreToIgnore) {
            ignored.add(str);
          }
        }
      }
    }
    return withResolved(kd, vtd, vd, ignored);
  }
  
  public JavaType getContentType()
  {
    return _mapType.getContentType();
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _valueDeserializer;
  }
  
  public boolean isCachable()
  {
    return (_valueDeserializer == null) && (_keyDeserializer == null) && (_valueTypeDeserializer == null) && (_ignorableProperties == null);
  }
  
  public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_propertyBasedCreator != null) {
      return _deserializeUsingCreator(p, ctxt);
    }
    if (_delegateDeserializer != null) {
      return (Map)_valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    if (!_hasDefaultCreator) {
      throw ctxt.instantiationException(getMapClass(), "No default constructor found");
    }
    JsonToken t = p.getCurrentToken();
    if ((t != JsonToken.START_OBJECT) && (t != JsonToken.FIELD_NAME) && (t != JsonToken.END_OBJECT))
    {
      if (t == JsonToken.VALUE_STRING) {
        return (Map)_valueInstantiator.createFromString(ctxt, p.getText());
      }
      return (Map)_deserializeFromEmpty(p, ctxt);
    }
    Map<Object, Object> result = (Map)_valueInstantiator.createUsingDefault(ctxt);
    if (_standardStringKey)
    {
      _readAndBindStringMap(p, ctxt, result);
      return result;
    }
    _readAndBind(p, ctxt, result);
    return result;
  }
  
  public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result)
    throws IOException
  {
    p.setCurrentValue(result);
    
    JsonToken t = p.getCurrentToken();
    if ((t != JsonToken.START_OBJECT) && (t != JsonToken.FIELD_NAME)) {
      throw ctxt.mappingException(getMapClass());
    }
    if (_standardStringKey)
    {
      _readAndBindStringMap(p, ctxt, result);
      return result;
    }
    _readAndBind(p, ctxt, result);
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException, JsonProcessingException
  {
    return typeDeserializer.deserializeTypedFromObject(jp, ctxt);
  }
  
  public final Class<?> getMapClass()
  {
    return _mapType.getRawClass();
  }
  
  public JavaType getValueType()
  {
    return _mapType;
  }
  
  protected final void _readAndBind(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result)
    throws IOException
  {
    KeyDeserializer keyDes = _keyDeserializer;
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    
    MapReferringAccumulator referringAccumulator = null;
    boolean useObjectId = valueDes.getObjectIdReader() != null;
    if (useObjectId) {
      referringAccumulator = new MapReferringAccumulator(_mapType.getContentType().getRawClass(), result);
    }
    String keyStr;
    if (p.isExpectedStartObjectToken())
    {
      keyStr = p.nextFieldName();
    }
    else
    {
      JsonToken t = p.getCurrentToken();
      if (t == JsonToken.END_OBJECT) {
        return;
      }
      if (t != JsonToken.FIELD_NAME) {
        throw ctxt.mappingException(_mapType.getRawClass(), p.getCurrentToken());
      }
    }
    for (String keyStr = p.getCurrentName(); keyStr != null; keyStr = p.nextFieldName())
    {
      Object key = keyDes.deserializeKey(keyStr, ctxt);
      
      JsonToken t = p.nextToken();
      if ((_ignorableProperties != null) && (_ignorableProperties.contains(keyStr))) {
        p.skipChildren();
      } else {
        try
        {
          Object value;
          Object value;
          if (t == JsonToken.VALUE_NULL)
          {
            value = valueDes.getNullValue(ctxt);
          }
          else
          {
            Object value;
            if (typeDeser == null) {
              value = valueDes.deserialize(p, ctxt);
            } else {
              value = valueDes.deserializeWithType(p, ctxt, typeDeser);
            }
          }
          if (useObjectId) {
            referringAccumulator.put(key, value);
          } else {
            result.put(key, value);
          }
        }
        catch (UnresolvedForwardReference reference)
        {
          handleUnresolvedReference(p, referringAccumulator, key, reference);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, result, keyStr);
        }
      }
    }
  }
  
  protected final void _readAndBindStringMap(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result)
    throws IOException
  {
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    MapReferringAccumulator referringAccumulator = null;
    boolean useObjectId = valueDes.getObjectIdReader() != null;
    if (useObjectId) {
      referringAccumulator = new MapReferringAccumulator(_mapType.getContentType().getRawClass(), result);
    }
    String key;
    if (p.isExpectedStartObjectToken())
    {
      key = p.nextFieldName();
    }
    else
    {
      JsonToken t = p.getCurrentToken();
      if (t == JsonToken.END_OBJECT) {
        return;
      }
      if (t != JsonToken.FIELD_NAME) {
        throw ctxt.mappingException(_mapType.getRawClass(), p.getCurrentToken());
      }
    }
    for (String key = p.getCurrentName(); key != null; key = p.nextFieldName())
    {
      JsonToken t = p.nextToken();
      if ((_ignorableProperties != null) && (_ignorableProperties.contains(key))) {
        p.skipChildren();
      } else {
        try
        {
          Object value;
          Object value;
          if (t == JsonToken.VALUE_NULL)
          {
            value = valueDes.getNullValue(ctxt);
          }
          else
          {
            Object value;
            if (typeDeser == null) {
              value = valueDes.deserialize(p, ctxt);
            } else {
              value = valueDes.deserializeWithType(p, ctxt, typeDeser);
            }
          }
          if (useObjectId) {
            referringAccumulator.put(key, value);
          } else {
            result.put(key, value);
          }
        }
        catch (UnresolvedForwardReference reference)
        {
          handleUnresolvedReference(p, referringAccumulator, key, reference);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, result, key);
        }
      }
    }
  }
  
  public Map<Object, Object> _deserializeUsingCreator(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    PropertyBasedCreator creator = _propertyBasedCreator;
    
    PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, null);
    
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    String key;
    if (p.isExpectedStartObjectToken())
    {
      key = p.nextFieldName();
    }
    else
    {
      String key;
      if (p.hasToken(JsonToken.FIELD_NAME)) {
        key = p.getCurrentName();
      }
    }
    for (String key = null; key != null; key = p.nextFieldName())
    {
      JsonToken t = p.nextToken();
      if ((_ignorableProperties != null) && (_ignorableProperties.contains(key)))
      {
        p.skipChildren();
      }
      else
      {
        SettableBeanProperty prop = creator.findCreatorProperty(key);
        if (prop != null)
        {
          if (buffer.assignParameter(prop, prop.deserialize(p, ctxt)))
          {
            p.nextToken();
            Map<Object, Object> result;
            try
            {
              result = (Map)creator.build(ctxt, buffer);
            }
            catch (Exception e)
            {
              wrapAndThrow(e, _mapType.getRawClass(), key);
              return null;
            }
            _readAndBind(p, ctxt, result);
            return result;
          }
        }
        else
        {
          Object actualKey = _keyDeserializer.deserializeKey(key, ctxt);
          Object value;
          try
          {
            Object value;
            if (t == JsonToken.VALUE_NULL)
            {
              value = valueDes.getNullValue(ctxt);
            }
            else
            {
              Object value;
              if (typeDeser == null) {
                value = valueDes.deserialize(p, ctxt);
              } else {
                value = valueDes.deserializeWithType(p, ctxt, typeDeser);
              }
            }
          }
          catch (Exception e)
          {
            wrapAndThrow(e, _mapType.getRawClass(), key);
            return null;
          }
          buffer.bufferMapProperty(actualKey, value);
        }
      }
    }
    try
    {
      return (Map)creator.build(ctxt, buffer);
    }
    catch (Exception e)
    {
      wrapAndThrow(e, _mapType.getRawClass(), null);
    }
    return null;
  }
  
  @Deprecated
  protected void wrapAndThrow(Throwable t, Object ref)
    throws IOException
  {
    wrapAndThrow(t, ref, null);
  }
  
  private void handleUnresolvedReference(JsonParser jp, MapReferringAccumulator accumulator, Object key, UnresolvedForwardReference reference)
    throws JsonMappingException
  {
    if (accumulator == null) {
      throw JsonMappingException.from(jp, "Unresolved forward reference but no identity info.", reference);
    }
    ReadableObjectId.Referring referring = accumulator.handleUnresolvedReference(reference, key);
    reference.getRoid().appendReferring(referring);
  }
  
  private static final class MapReferringAccumulator
  {
    private final Class<?> _valueType;
    private Map<Object, Object> _result;
    private List<MapDeserializer.MapReferring> _accumulator = new ArrayList();
    
    public MapReferringAccumulator(Class<?> valueType, Map<Object, Object> result)
    {
      _valueType = valueType;
      _result = result;
    }
    
    public void put(Object key, Object value)
    {
      if (_accumulator.isEmpty())
      {
        _result.put(key, value);
      }
      else
      {
        MapDeserializer.MapReferring ref = (MapDeserializer.MapReferring)_accumulator.get(_accumulator.size() - 1);
        next.put(key, value);
      }
    }
    
    public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference reference, Object key)
    {
      MapDeserializer.MapReferring id = new MapDeserializer.MapReferring(this, reference, _valueType, key);
      _accumulator.add(id);
      return id;
    }
    
    public void resolveForwardReference(Object id, Object value)
      throws IOException
    {
      Iterator<MapDeserializer.MapReferring> iterator = _accumulator.iterator();
      
      Map<Object, Object> previous = _result;
      while (iterator.hasNext())
      {
        MapDeserializer.MapReferring ref = (MapDeserializer.MapReferring)iterator.next();
        if (ref.hasId(id))
        {
          iterator.remove();
          previous.put(key, value);
          previous.putAll(next);
          return;
        }
        previous = next;
      }
      throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
    }
  }
  
  static final class MapReferring
    extends ReadableObjectId.Referring
  {
    private final MapDeserializer.MapReferringAccumulator _parent;
    public final Map<Object, Object> next = new LinkedHashMap();
    public final Object key;
    
    MapReferring(MapDeserializer.MapReferringAccumulator parent, UnresolvedForwardReference ref, Class<?> valueType, Object key)
    {
      super(valueType);
      _parent = parent;
      this.key = key;
    }
    
    public void handleResolvedForwardReference(Object id, Object value)
      throws IOException
    {
      _parent.resolveForwardReference(id, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.MapDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */