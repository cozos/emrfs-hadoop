package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.io.Serializable;

public class ObjectIdReader
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _idType;
  public final PropertyName propertyName;
  public final ObjectIdGenerator<?> generator;
  public final ObjectIdResolver resolver;
  protected final JsonDeserializer<Object> _deserializer;
  public final SettableBeanProperty idProperty;
  
  protected ObjectIdReader(JavaType t, PropertyName propName, ObjectIdGenerator<?> gen, JsonDeserializer<?> deser, SettableBeanProperty idProp, ObjectIdResolver resolver)
  {
    _idType = t;
    propertyName = propName;
    generator = gen;
    this.resolver = resolver;
    _deserializer = deser;
    idProperty = idProp;
  }
  
  @Deprecated
  protected ObjectIdReader(JavaType t, PropertyName propName, ObjectIdGenerator<?> gen, JsonDeserializer<?> deser, SettableBeanProperty idProp)
  {
    this(t, propName, gen, deser, idProp, new SimpleObjectIdResolver());
  }
  
  public static ObjectIdReader construct(JavaType idType, PropertyName propName, ObjectIdGenerator<?> generator, JsonDeserializer<?> deser, SettableBeanProperty idProp, ObjectIdResolver resolver)
  {
    return new ObjectIdReader(idType, propName, generator, deser, idProp, resolver);
  }
  
  @Deprecated
  public static ObjectIdReader construct(JavaType idType, PropertyName propName, ObjectIdGenerator<?> generator, JsonDeserializer<?> deser, SettableBeanProperty idProp)
  {
    return construct(idType, propName, generator, deser, idProp, new SimpleObjectIdResolver());
  }
  
  public JsonDeserializer<Object> getDeserializer()
  {
    return _deserializer;
  }
  
  public JavaType getIdType()
  {
    return _idType;
  }
  
  public boolean maySerializeAsObject()
  {
    return generator.maySerializeAsObject();
  }
  
  public boolean isValidReferencePropertyName(String name, JsonParser parser)
  {
    return generator.isValidReferencePropertyName(name, parser);
  }
  
  public Object readObjectReference(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _deserializer.deserialize(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */