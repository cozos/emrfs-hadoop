package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@JacksonStdImpl
public class CollectionDeserializer
  extends ContainerDeserializerBase<Collection<Object>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = -1L;
  protected final JavaType _collectionType;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  protected final JsonDeserializer<Object> _delegateDeserializer;
  
  public CollectionDeserializer(JavaType collectionType, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, ValueInstantiator valueInstantiator)
  {
    this(collectionType, valueDeser, valueTypeDeser, valueInstantiator, null);
  }
  
  protected CollectionDeserializer(JavaType collectionType, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, ValueInstantiator valueInstantiator, JsonDeserializer<Object> delegateDeser)
  {
    super(collectionType);
    _collectionType = collectionType;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = valueTypeDeser;
    _valueInstantiator = valueInstantiator;
    _delegateDeserializer = delegateDeser;
  }
  
  protected CollectionDeserializer(CollectionDeserializer src)
  {
    super(_collectionType);
    _collectionType = _collectionType;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _valueInstantiator = _valueInstantiator;
    _delegateDeserializer = _delegateDeserializer;
  }
  
  protected CollectionDeserializer withResolved(JsonDeserializer<?> dd, JsonDeserializer<?> vd, TypeDeserializer vtd)
  {
    if ((dd == _delegateDeserializer) && (vd == _valueDeserializer) && (vtd == _valueTypeDeserializer)) {
      return this;
    }
    return new CollectionDeserializer(_collectionType, vd, vtd, _valueInstantiator, dd);
  }
  
  public boolean isCachable()
  {
    return (_valueDeserializer == null) && (_valueTypeDeserializer == null) && (_delegateDeserializer == null);
  }
  
  public CollectionDeserializer createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<Object> delegateDeser = null;
    if ((_valueInstantiator != null) && (_valueInstantiator.canCreateUsingDelegate()))
    {
      JavaType delegateType = _valueInstantiator.getDelegateType(ctxt.getConfig());
      if (delegateType == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + _collectionType + ": value instantiator (" + _valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      delegateDeser = findDeserializer(ctxt, delegateType, property);
    }
    JsonDeserializer<?> valueDeser = _valueDeserializer;
    
    valueDeser = findConvertingContentDeserializer(ctxt, property, valueDeser);
    JavaType vt = _collectionType.getContentType();
    if (valueDeser == null) {
      valueDeser = ctxt.findContextualValueDeserializer(vt, property);
    } else {
      valueDeser = ctxt.handleSecondaryContextualization(valueDeser, property, vt);
    }
    TypeDeserializer valueTypeDeser = _valueTypeDeserializer;
    if (valueTypeDeser != null) {
      valueTypeDeser = valueTypeDeser.forProperty(property);
    }
    return withResolved(delegateDeser, valueDeser, valueTypeDeser);
  }
  
  public JavaType getContentType()
  {
    return _collectionType.getContentType();
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return _valueDeserializer;
  }
  
  public Collection<Object> deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return (Collection)_valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    if (p.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      String str = p.getText();
      if (str.length() == 0) {
        return (Collection)_valueInstantiator.createFromString(ctxt, str);
      }
    }
    return deserialize(p, ctxt, (Collection)_valueInstantiator.createUsingDefault(ctxt));
  }
  
  public Collection<Object> deserialize(JsonParser p, DeserializationContext ctxt, Collection<Object> result)
    throws IOException
  {
    if (!p.isExpectedStartArrayToken()) {
      return handleNonArray(p, ctxt, result);
    }
    p.setCurrentValue(result);
    
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    CollectionReferringAccumulator referringAccumulator = valueDes.getObjectIdReader() == null ? null : new CollectionReferringAccumulator(_collectionType.getContentType().getRawClass(), result);
    JsonToken t;
    while ((t = p.nextToken()) != JsonToken.END_ARRAY) {
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
        if (referringAccumulator != null) {
          referringAccumulator.add(value);
        } else {
          result.add(value);
        }
      }
      catch (UnresolvedForwardReference reference)
      {
        if (referringAccumulator == null) {
          throw JsonMappingException.from(p, "Unresolved forward reference but no identity info", reference);
        }
        ReadableObjectId.Referring ref = referringAccumulator.handleUnresolvedReference(reference);
        reference.getRoid().appendReferring(ref);
      }
      catch (Exception e)
      {
        boolean wrap = (ctxt == null) || (ctxt.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS));
        if ((!wrap) && ((e instanceof RuntimeException))) {
          throw ((RuntimeException)e);
        }
        throw JsonMappingException.wrapWithPath(e, result, result.size());
      }
    }
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
  
  protected final Collection<Object> handleNonArray(JsonParser p, DeserializationContext ctxt, Collection<Object> result)
    throws IOException
  {
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw ctxt.mappingException(_collectionType.getRawClass());
    }
    JsonDeserializer<Object> valueDes = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    JsonToken t = p.getCurrentToken();
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
      throw JsonMappingException.wrapWithPath(e, Object.class, result.size());
    }
    result.add(value);
    return result;
  }
  
  public static final class CollectionReferringAccumulator
  {
    private final Class<?> _elementType;
    private final Collection<Object> _result;
    private List<CollectionDeserializer.CollectionReferring> _accumulator = new ArrayList();
    
    public CollectionReferringAccumulator(Class<?> elementType, Collection<Object> result)
    {
      _elementType = elementType;
      _result = result;
    }
    
    public void add(Object value)
    {
      if (_accumulator.isEmpty())
      {
        _result.add(value);
      }
      else
      {
        CollectionDeserializer.CollectionReferring ref = (CollectionDeserializer.CollectionReferring)_accumulator.get(_accumulator.size() - 1);
        next.add(value);
      }
    }
    
    public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference reference)
    {
      CollectionDeserializer.CollectionReferring id = new CollectionDeserializer.CollectionReferring(this, reference, _elementType);
      _accumulator.add(id);
      return id;
    }
    
    public void resolveForwardReference(Object id, Object value)
      throws IOException
    {
      Iterator<CollectionDeserializer.CollectionReferring> iterator = _accumulator.iterator();
      
      Collection<Object> previous = _result;
      while (iterator.hasNext())
      {
        CollectionDeserializer.CollectionReferring ref = (CollectionDeserializer.CollectionReferring)iterator.next();
        if (ref.hasId(id))
        {
          iterator.remove();
          previous.add(value);
          previous.addAll(next);
          return;
        }
        previous = next;
      }
      throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
    }
  }
  
  private static final class CollectionReferring
    extends ReadableObjectId.Referring
  {
    private final CollectionDeserializer.CollectionReferringAccumulator _parent;
    public final List<Object> next = new ArrayList();
    
    CollectionReferring(CollectionDeserializer.CollectionReferringAccumulator parent, UnresolvedForwardReference reference, Class<?> contentType)
    {
      super(contentType);
      _parent = parent;
    }
    
    public void handleResolvedForwardReference(Object id, Object value)
      throws IOException
    {
      _parent.resolveForwardReference(id, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */