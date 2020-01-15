package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.Serializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeModifier;

class ObjectMapper$1
  implements Module.SetupContext
{
  ObjectMapper$1(ObjectMapper paramObjectMapper1, ObjectMapper paramObjectMapper2) {}
  
  public Version getMapperVersion()
  {
    return this$0.version();
  }
  
  public <C extends ObjectCodec> C getOwner()
  {
    return val$mapper;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this$0._typeFactory;
  }
  
  public boolean isEnabled(MapperFeature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public boolean isEnabled(DeserializationFeature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public boolean isEnabled(SerializationFeature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public boolean isEnabled(JsonFactory.Feature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public boolean isEnabled(JsonParser.Feature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public boolean isEnabled(JsonGenerator.Feature f)
  {
    return val$mapper.isEnabled(f);
  }
  
  public void addDeserializers(Deserializers d)
  {
    DeserializerFactory df = val$mapper._deserializationContext._factory.withAdditionalDeserializers(d);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(df);
  }
  
  public void addKeyDeserializers(KeyDeserializers d)
  {
    DeserializerFactory df = val$mapper._deserializationContext._factory.withAdditionalKeyDeserializers(d);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(df);
  }
  
  public void addBeanDeserializerModifier(BeanDeserializerModifier modifier)
  {
    DeserializerFactory df = val$mapper._deserializationContext._factory.withDeserializerModifier(modifier);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(df);
  }
  
  public void addSerializers(Serializers s)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalSerializers(s);
  }
  
  public void addKeySerializers(Serializers s)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalKeySerializers(s);
  }
  
  public void addBeanSerializerModifier(BeanSerializerModifier modifier)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withSerializerModifier(modifier);
  }
  
  public void addAbstractTypeResolver(AbstractTypeResolver resolver)
  {
    DeserializerFactory df = val$mapper._deserializationContext._factory.withAbstractTypeResolver(resolver);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(df);
  }
  
  public void addTypeModifier(TypeModifier modifier)
  {
    TypeFactory f = val$mapper._typeFactory;
    f = f.withModifier(modifier);
    val$mapper.setTypeFactory(f);
  }
  
  public void addValueInstantiators(ValueInstantiators instantiators)
  {
    DeserializerFactory df = val$mapper._deserializationContext._factory.withValueInstantiators(instantiators);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(df);
  }
  
  public void setClassIntrospector(ClassIntrospector ci)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.with(ci);
    val$mapper._serializationConfig = val$mapper._serializationConfig.with(ci);
  }
  
  public void insertAnnotationIntrospector(AnnotationIntrospector ai)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.withInsertedAnnotationIntrospector(ai);
    val$mapper._serializationConfig = val$mapper._serializationConfig.withInsertedAnnotationIntrospector(ai);
  }
  
  public void appendAnnotationIntrospector(AnnotationIntrospector ai)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.withAppendedAnnotationIntrospector(ai);
    val$mapper._serializationConfig = val$mapper._serializationConfig.withAppendedAnnotationIntrospector(ai);
  }
  
  public void registerSubtypes(Class<?>... subtypes)
  {
    val$mapper.registerSubtypes(subtypes);
  }
  
  public void registerSubtypes(NamedType... subtypes)
  {
    val$mapper.registerSubtypes(subtypes);
  }
  
  public void setMixInAnnotations(Class<?> target, Class<?> mixinSource)
  {
    val$mapper.addMixIn(target, mixinSource);
  }
  
  public void addDeserializationProblemHandler(DeserializationProblemHandler handler)
  {
    val$mapper.addHandler(handler);
  }
  
  public void setNamingStrategy(PropertyNamingStrategy naming)
  {
    val$mapper.setPropertyNamingStrategy(naming);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */