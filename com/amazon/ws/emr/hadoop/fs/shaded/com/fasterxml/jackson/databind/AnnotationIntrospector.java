package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AnnotationIntrospector
  implements Versioned, Serializable
{
  public static class ReferenceProperty
  {
    private final Type _type;
    private final String _name;
    
    public static enum Type
    {
      MANAGED_REFERENCE,  BACK_REFERENCE;
      
      private Type() {}
    }
    
    public ReferenceProperty(Type t, String n)
    {
      _type = t;
      _name = n;
    }
    
    public static ReferenceProperty managed(String name)
    {
      return new ReferenceProperty(Type.MANAGED_REFERENCE, name);
    }
    
    public static ReferenceProperty back(String name)
    {
      return new ReferenceProperty(Type.BACK_REFERENCE, name);
    }
    
    public Type getType()
    {
      return _type;
    }
    
    public String getName()
    {
      return _name;
    }
    
    public boolean isManagedReference()
    {
      return _type == Type.MANAGED_REFERENCE;
    }
    
    public boolean isBackReference()
    {
      return _type == Type.BACK_REFERENCE;
    }
  }
  
  public static AnnotationIntrospector nopInstance()
  {
    return NopAnnotationIntrospector.instance;
  }
  
  public static AnnotationIntrospector pair(AnnotationIntrospector a1, AnnotationIntrospector a2)
  {
    return new AnnotationIntrospectorPair(a1, a2);
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors()
  {
    return Collections.singletonList(this);
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> result)
  {
    result.add(this);
    return result;
  }
  
  public abstract Version version();
  
  public boolean isAnnotationBundle(Annotation ann)
  {
    return false;
  }
  
  public ObjectIdInfo findObjectIdInfo(Annotated ann)
  {
    return null;
  }
  
  public ObjectIdInfo findObjectReferenceInfo(Annotated ann, ObjectIdInfo objectIdInfo)
  {
    return objectIdInfo;
  }
  
  public PropertyName findRootName(AnnotatedClass ac)
  {
    return null;
  }
  
  public String[] findPropertiesToIgnore(Annotated ac, boolean forSerialization)
  {
    return findPropertiesToIgnore(ac);
  }
  
  @Deprecated
  public String[] findPropertiesToIgnore(Annotated ac)
  {
    return null;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass ac)
  {
    return null;
  }
  
  public Boolean isIgnorableType(AnnotatedClass ac)
  {
    return null;
  }
  
  @Deprecated
  public Object findFilterId(AnnotatedClass ac)
  {
    return findFilterId(ac);
  }
  
  public Object findFilterId(Annotated ann)
  {
    return null;
  }
  
  public Object findNamingStrategy(AnnotatedClass ac)
  {
    return null;
  }
  
  public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass ac, VisibilityChecker<?> checker)
  {
    return checker;
  }
  
  public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> config, AnnotatedClass ac, JavaType baseType)
  {
    return null;
  }
  
  public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType)
  {
    return null;
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType containerType)
  {
    return null;
  }
  
  public List<NamedType> findSubtypes(Annotated a)
  {
    return null;
  }
  
  public String findTypeName(AnnotatedClass ac)
  {
    return null;
  }
  
  public Boolean isTypeId(AnnotatedMember member)
  {
    return null;
  }
  
  public ReferenceProperty findReferenceType(AnnotatedMember member)
  {
    return null;
  }
  
  public NameTransformer findUnwrappingNameTransformer(AnnotatedMember member)
  {
    return null;
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember m)
  {
    return false;
  }
  
  public Object findInjectableValueId(AnnotatedMember m)
  {
    return null;
  }
  
  public Boolean hasRequiredMarker(AnnotatedMember m)
  {
    return null;
  }
  
  public Class<?>[] findViews(Annotated a)
  {
    return null;
  }
  
  public JsonFormat.Value findFormat(Annotated memberOrClass)
  {
    return null;
  }
  
  public PropertyName findWrapperName(Annotated ann)
  {
    return null;
  }
  
  public String findPropertyDefaultValue(Annotated ann)
  {
    return null;
  }
  
  public String findPropertyDescription(Annotated ann)
  {
    return null;
  }
  
  public Integer findPropertyIndex(Annotated ann)
  {
    return null;
  }
  
  public String findImplicitPropertyName(AnnotatedMember member)
  {
    return null;
  }
  
  public JsonProperty.Access findPropertyAccess(Annotated ann)
  {
    return null;
  }
  
  public Object findSerializer(Annotated am)
  {
    return null;
  }
  
  public Object findKeySerializer(Annotated am)
  {
    return null;
  }
  
  public Object findContentSerializer(Annotated am)
  {
    return null;
  }
  
  public Object findNullSerializer(Annotated am)
  {
    return null;
  }
  
  public Class<?> findSerializationType(Annotated a)
  {
    return null;
  }
  
  public Class<?> findSerializationKeyType(Annotated am, JavaType baseType)
  {
    return null;
  }
  
  public Class<?> findSerializationContentType(Annotated am, JavaType baseType)
  {
    return null;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated a)
  {
    return null;
  }
  
  public Object findSerializationConverter(Annotated a)
  {
    return null;
  }
  
  public Object findSerializationContentConverter(AnnotatedMember a)
  {
    return null;
  }
  
  public JsonInclude.Include findSerializationInclusion(Annotated a, JsonInclude.Include defValue)
  {
    return defValue;
  }
  
  public JsonInclude.Include findSerializationInclusionForContent(Annotated a, JsonInclude.Include defValue)
  {
    return defValue;
  }
  
  public JsonInclude.Value findPropertyInclusion(Annotated a)
  {
    JsonInclude.Include def = JsonInclude.Include.USE_DEFAULTS;
    JsonInclude.Include vi = findSerializationInclusion(a, def);
    JsonInclude.Include ci = findSerializationInclusionForContent(a, def);
    return JsonInclude.Value.construct(vi, ci);
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass ac)
  {
    return null;
  }
  
  public Boolean findSerializationSortAlphabetically(Annotated ann)
  {
    return null;
  }
  
  public void findAndAddVirtualProperties(MapperConfig<?> config, AnnotatedClass ac, List<BeanPropertyWriter> properties) {}
  
  public PropertyName findNameForSerialization(Annotated a)
  {
    return null;
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod am)
  {
    return false;
  }
  
  public String findEnumValue(Enum<?> value)
  {
    return value.name();
  }
  
  public Object findDeserializer(Annotated am)
  {
    return null;
  }
  
  public Object findKeyDeserializer(Annotated am)
  {
    return null;
  }
  
  public Object findContentDeserializer(Annotated am)
  {
    return null;
  }
  
  public Class<?> findDeserializationType(Annotated am, JavaType baseType)
  {
    return null;
  }
  
  public Class<?> findDeserializationKeyType(Annotated am, JavaType baseKeyType)
  {
    return null;
  }
  
  public Class<?> findDeserializationContentType(Annotated am, JavaType baseContentType)
  {
    return null;
  }
  
  public Object findDeserializationConverter(Annotated a)
  {
    return null;
  }
  
  public Object findDeserializationContentConverter(AnnotatedMember a)
  {
    return null;
  }
  
  public Object findValueInstantiator(AnnotatedClass ac)
  {
    return null;
  }
  
  public Class<?> findPOJOBuilder(AnnotatedClass ac)
  {
    return null;
  }
  
  public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass ac)
  {
    return null;
  }
  
  public PropertyName findNameForDeserialization(Annotated a)
  {
    return null;
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod am)
  {
    return false;
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod am)
  {
    return false;
  }
  
  public boolean hasCreatorAnnotation(Annotated a)
  {
    return false;
  }
  
  public JsonCreator.Mode findCreatorBinding(Annotated a)
  {
    return null;
  }
  
  protected <A extends Annotation> A _findAnnotation(Annotated annotated, Class<A> annoClass)
  {
    return annotated.getAnnotation(annoClass);
  }
  
  protected boolean _hasAnnotation(Annotated annotated, Class<? extends Annotation> annoClass)
  {
    return annotated.hasAnnotation(annoClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */