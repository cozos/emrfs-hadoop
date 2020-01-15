package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDeserializer
  extends StdDeserializer<AtomicReference<?>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _referencedType;
  protected final TypeDeserializer _valueTypeDeserializer;
  protected final JsonDeserializer<?> _valueDeserializer;
  
  public AtomicReferenceDeserializer(JavaType referencedType)
  {
    this(referencedType, null, null);
  }
  
  public AtomicReferenceDeserializer(JavaType referencedType, TypeDeserializer typeDeser, JsonDeserializer<?> deser)
  {
    super(AtomicReference.class);
    _referencedType = referencedType;
    _valueDeserializer = deser;
    _valueTypeDeserializer = typeDeser;
  }
  
  public AtomicReferenceDeserializer withResolved(TypeDeserializer typeDeser, JsonDeserializer<?> valueDeser)
  {
    return new AtomicReferenceDeserializer(_referencedType, typeDeser, valueDeser);
  }
  
  public AtomicReference<?> getNullValue(DeserializationContext ctxt)
  {
    return new AtomicReference();
  }
  
  @Deprecated
  public AtomicReference<?> getNullValue()
  {
    return new AtomicReference();
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<?> deser = _valueDeserializer;
    TypeDeserializer typeDeser = _valueTypeDeserializer;
    if (deser == null) {
      deser = ctxt.findContextualValueDeserializer(_referencedType, property);
    }
    if (typeDeser != null) {
      typeDeser = typeDeser.forProperty(property);
    }
    if ((deser == _valueDeserializer) && (typeDeser == _valueTypeDeserializer)) {
      return this;
    }
    return withResolved(typeDeser, deser);
  }
  
  public AtomicReference<?> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_valueTypeDeserializer != null) {
      return new AtomicReference(_valueDeserializer.deserializeWithType(jp, ctxt, _valueTypeDeserializer));
    }
    return new AtomicReference(_valueDeserializer.deserialize(jp, ctxt));
  }
  
  public Object[] deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return (Object[])typeDeserializer.deserializeTypedFromAny(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */