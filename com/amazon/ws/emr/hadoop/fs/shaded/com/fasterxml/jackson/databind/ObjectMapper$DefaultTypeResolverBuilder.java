package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import java.io.Serializable;
import java.util.Collection;

public class ObjectMapper$DefaultTypeResolverBuilder
  extends StdTypeResolverBuilder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final ObjectMapper.DefaultTyping _appliesFor;
  
  public ObjectMapper$DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping t)
  {
    _appliesFor = t;
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
  {
    return useForType(baseType) ? super.buildTypeDeserializer(config, baseType, subtypes) : null;
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes)
  {
    return useForType(baseType) ? super.buildTypeSerializer(config, baseType, subtypes) : null;
  }
  
  public boolean useForType(JavaType t)
  {
    switch (ObjectMapper.2.$SwitchMap$com$fasterxml$jackson$databind$ObjectMapper$DefaultTyping[_appliesFor.ordinal()])
    {
    case 1: 
      while (t.isArrayType()) {
        t = t.getContentType();
      }
    case 2: 
      return (t.isJavaLangObject()) || ((!t.isConcrete()) && (!TreeNode.class.isAssignableFrom(t.getRawClass())));
    case 3: 
      while (t.isArrayType()) {
        t = t.getContentType();
      }
      return (!t.isFinal()) && (!TreeNode.class.isAssignableFrom(t.getRawClass()));
    }
    return t.isJavaLangObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */