package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer.None;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnnotationIntrospectorPair
  extends AnnotationIntrospector
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final AnnotationIntrospector _primary;
  protected final AnnotationIntrospector _secondary;
  
  public AnnotationIntrospectorPair(AnnotationIntrospector p, AnnotationIntrospector s)
  {
    _primary = p;
    _secondary = s;
  }
  
  public Version version()
  {
    return _primary.version();
  }
  
  public static AnnotationIntrospector create(AnnotationIntrospector primary, AnnotationIntrospector secondary)
  {
    if (primary == null) {
      return secondary;
    }
    if (secondary == null) {
      return primary;
    }
    return new AnnotationIntrospectorPair(primary, secondary);
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors()
  {
    return allIntrospectors(new ArrayList());
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> result)
  {
    _primary.allIntrospectors(result);
    _secondary.allIntrospectors(result);
    return result;
  }
  
  public boolean isAnnotationBundle(Annotation ann)
  {
    return (_primary.isAnnotationBundle(ann)) || (_secondary.isAnnotationBundle(ann));
  }
  
  public PropertyName findRootName(AnnotatedClass ac)
  {
    PropertyName name1 = _primary.findRootName(ac);
    if (name1 == null) {
      return _secondary.findRootName(ac);
    }
    if (name1.hasSimpleName()) {
      return name1;
    }
    PropertyName name2 = _secondary.findRootName(ac);
    return name2 == null ? name1 : name2;
  }
  
  @Deprecated
  public String[] findPropertiesToIgnore(Annotated ac)
  {
    String[] result = _primary.findPropertiesToIgnore(ac);
    if (result == null) {
      result = _secondary.findPropertiesToIgnore(ac);
    }
    return result;
  }
  
  public String[] findPropertiesToIgnore(Annotated ac, boolean forSerialization)
  {
    String[] result = _primary.findPropertiesToIgnore(ac, forSerialization);
    if (result == null) {
      result = _secondary.findPropertiesToIgnore(ac, forSerialization);
    }
    return result;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass ac)
  {
    Boolean result = _primary.findIgnoreUnknownProperties(ac);
    if (result == null) {
      result = _secondary.findIgnoreUnknownProperties(ac);
    }
    return result;
  }
  
  public Boolean isIgnorableType(AnnotatedClass ac)
  {
    Boolean result = _primary.isIgnorableType(ac);
    if (result == null) {
      result = _secondary.isIgnorableType(ac);
    }
    return result;
  }
  
  @Deprecated
  public Object findFilterId(AnnotatedClass ac)
  {
    Object id = _primary.findFilterId(ac);
    if (id == null) {
      id = _secondary.findFilterId(ac);
    }
    return id;
  }
  
  public Object findFilterId(Annotated ann)
  {
    Object id = _primary.findFilterId(ann);
    if (id == null) {
      id = _secondary.findFilterId(ann);
    }
    return id;
  }
  
  public Object findNamingStrategy(AnnotatedClass ac)
  {
    Object str = _primary.findNamingStrategy(ac);
    if (str == null) {
      str = _secondary.findNamingStrategy(ac);
    }
    return str;
  }
  
  public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass ac, VisibilityChecker<?> checker)
  {
    checker = _secondary.findAutoDetectVisibility(ac, checker);
    return _primary.findAutoDetectVisibility(ac, checker);
  }
  
  public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> config, AnnotatedClass ac, JavaType baseType)
  {
    TypeResolverBuilder<?> b = _primary.findTypeResolver(config, ac, baseType);
    if (b == null) {
      b = _secondary.findTypeResolver(config, ac, baseType);
    }
    return b;
  }
  
  public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType)
  {
    TypeResolverBuilder<?> b = _primary.findPropertyTypeResolver(config, am, baseType);
    if (b == null) {
      b = _secondary.findPropertyTypeResolver(config, am, baseType);
    }
    return b;
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> config, AnnotatedMember am, JavaType baseType)
  {
    TypeResolverBuilder<?> b = _primary.findPropertyContentTypeResolver(config, am, baseType);
    if (b == null) {
      b = _secondary.findPropertyContentTypeResolver(config, am, baseType);
    }
    return b;
  }
  
  public List<NamedType> findSubtypes(Annotated a)
  {
    List<NamedType> types1 = _primary.findSubtypes(a);
    List<NamedType> types2 = _secondary.findSubtypes(a);
    if ((types1 == null) || (types1.isEmpty())) {
      return types2;
    }
    if ((types2 == null) || (types2.isEmpty())) {
      return types1;
    }
    ArrayList<NamedType> result = new ArrayList(types1.size() + types2.size());
    result.addAll(types1);
    result.addAll(types2);
    return result;
  }
  
  public String findTypeName(AnnotatedClass ac)
  {
    String name = _primary.findTypeName(ac);
    if ((name == null) || (name.length() == 0)) {
      name = _secondary.findTypeName(ac);
    }
    return name;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember member)
  {
    AnnotationIntrospector.ReferenceProperty r = _primary.findReferenceType(member);
    return r == null ? _secondary.findReferenceType(member) : r;
  }
  
  public NameTransformer findUnwrappingNameTransformer(AnnotatedMember member)
  {
    NameTransformer r = _primary.findUnwrappingNameTransformer(member);
    return r == null ? _secondary.findUnwrappingNameTransformer(member) : r;
  }
  
  public Object findInjectableValueId(AnnotatedMember m)
  {
    Object r = _primary.findInjectableValueId(m);
    return r == null ? _secondary.findInjectableValueId(m) : r;
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember m)
  {
    return (_primary.hasIgnoreMarker(m)) || (_secondary.hasIgnoreMarker(m));
  }
  
  public Boolean hasRequiredMarker(AnnotatedMember m)
  {
    Boolean r = _primary.hasRequiredMarker(m);
    return r == null ? _secondary.hasRequiredMarker(m) : r;
  }
  
  public Object findSerializer(Annotated am)
  {
    Object r = _primary.findSerializer(am);
    return _isExplicitClassOrOb(r, JsonSerializer.None.class) ? r : _secondary.findSerializer(am);
  }
  
  public Object findKeySerializer(Annotated a)
  {
    Object r = _primary.findKeySerializer(a);
    return _isExplicitClassOrOb(r, JsonSerializer.None.class) ? r : _secondary.findKeySerializer(a);
  }
  
  public Object findContentSerializer(Annotated a)
  {
    Object r = _primary.findContentSerializer(a);
    return _isExplicitClassOrOb(r, JsonSerializer.None.class) ? r : _secondary.findContentSerializer(a);
  }
  
  public Object findNullSerializer(Annotated a)
  {
    Object r = _primary.findNullSerializer(a);
    return _isExplicitClassOrOb(r, JsonSerializer.None.class) ? r : _secondary.findNullSerializer(a);
  }
  
  public JsonInclude.Include findSerializationInclusion(Annotated a, JsonInclude.Include defValue)
  {
    defValue = _secondary.findSerializationInclusion(a, defValue);
    defValue = _primary.findSerializationInclusion(a, defValue);
    return defValue;
  }
  
  public JsonInclude.Include findSerializationInclusionForContent(Annotated a, JsonInclude.Include defValue)
  {
    defValue = _secondary.findSerializationInclusion(a, defValue);
    defValue = _primary.findSerializationInclusion(a, defValue);
    return defValue;
  }
  
  public JsonInclude.Value findPropertyInclusion(Annotated a)
  {
    JsonInclude.Value v2 = _secondary.findPropertyInclusion(a);
    JsonInclude.Value v1 = _secondary.findPropertyInclusion(a);
    if (v2 == null) {
      return v1;
    }
    return v2.withOverrides(v1);
  }
  
  public Class<?> findSerializationType(Annotated a)
  {
    Class<?> r = _primary.findSerializationType(a);
    return r == null ? _secondary.findSerializationType(a) : r;
  }
  
  public Class<?> findSerializationKeyType(Annotated am, JavaType baseType)
  {
    Class<?> r = _primary.findSerializationKeyType(am, baseType);
    return r == null ? _secondary.findSerializationKeyType(am, baseType) : r;
  }
  
  public Class<?> findSerializationContentType(Annotated am, JavaType baseType)
  {
    Class<?> r = _primary.findSerializationContentType(am, baseType);
    return r == null ? _secondary.findSerializationContentType(am, baseType) : r;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated a)
  {
    JsonSerialize.Typing r = _primary.findSerializationTyping(a);
    return r == null ? _secondary.findSerializationTyping(a) : r;
  }
  
  public Object findSerializationConverter(Annotated a)
  {
    Object r = _primary.findSerializationConverter(a);
    return r == null ? _secondary.findSerializationConverter(a) : r;
  }
  
  public Object findSerializationContentConverter(AnnotatedMember a)
  {
    Object r = _primary.findSerializationContentConverter(a);
    return r == null ? _secondary.findSerializationContentConverter(a) : r;
  }
  
  public Class<?>[] findViews(Annotated a)
  {
    Class<?>[] result = _primary.findViews(a);
    if (result == null) {
      result = _secondary.findViews(a);
    }
    return result;
  }
  
  public Boolean isTypeId(AnnotatedMember member)
  {
    Boolean b = _primary.isTypeId(member);
    return b == null ? _secondary.isTypeId(member) : b;
  }
  
  public ObjectIdInfo findObjectIdInfo(Annotated ann)
  {
    ObjectIdInfo r = _primary.findObjectIdInfo(ann);
    return r == null ? _secondary.findObjectIdInfo(ann) : r;
  }
  
  public ObjectIdInfo findObjectReferenceInfo(Annotated ann, ObjectIdInfo objectIdInfo)
  {
    objectIdInfo = _secondary.findObjectReferenceInfo(ann, objectIdInfo);
    objectIdInfo = _primary.findObjectReferenceInfo(ann, objectIdInfo);
    return objectIdInfo;
  }
  
  public JsonFormat.Value findFormat(Annotated ann)
  {
    JsonFormat.Value r = _primary.findFormat(ann);
    return r == null ? _secondary.findFormat(ann) : r;
  }
  
  public PropertyName findWrapperName(Annotated ann)
  {
    PropertyName name = _primary.findWrapperName(ann);
    if (name == null)
    {
      name = _secondary.findWrapperName(ann);
    }
    else if (name == PropertyName.USE_DEFAULT)
    {
      PropertyName name2 = _secondary.findWrapperName(ann);
      if (name2 != null) {
        name = name2;
      }
    }
    return name;
  }
  
  public String findPropertyDefaultValue(Annotated ann)
  {
    String str = _primary.findPropertyDefaultValue(ann);
    return (str == null) || (str.isEmpty()) ? _secondary.findPropertyDefaultValue(ann) : str;
  }
  
  public String findPropertyDescription(Annotated ann)
  {
    String r = _primary.findPropertyDescription(ann);
    return r == null ? _secondary.findPropertyDescription(ann) : r;
  }
  
  public Integer findPropertyIndex(Annotated ann)
  {
    Integer r = _primary.findPropertyIndex(ann);
    return r == null ? _secondary.findPropertyIndex(ann) : r;
  }
  
  public String findImplicitPropertyName(AnnotatedMember param)
  {
    String r = _primary.findImplicitPropertyName(param);
    return r == null ? _secondary.findImplicitPropertyName(param) : r;
  }
  
  public JsonProperty.Access findPropertyAccess(Annotated ann)
  {
    JsonProperty.Access acc = _primary.findPropertyAccess(ann);
    if ((acc != null) && (acc != JsonProperty.Access.AUTO)) {
      return acc;
    }
    acc = _secondary.findPropertyAccess(ann);
    if (acc != null) {
      return acc;
    }
    return JsonProperty.Access.AUTO;
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass ac)
  {
    String[] r = _primary.findSerializationPropertyOrder(ac);
    return r == null ? _secondary.findSerializationPropertyOrder(ac) : r;
  }
  
  public Boolean findSerializationSortAlphabetically(Annotated ann)
  {
    Boolean r = _primary.findSerializationSortAlphabetically(ann);
    return r == null ? _secondary.findSerializationSortAlphabetically(ann) : r;
  }
  
  public void findAndAddVirtualProperties(MapperConfig<?> config, AnnotatedClass ac, List<BeanPropertyWriter> properties)
  {
    _primary.findAndAddVirtualProperties(config, ac, properties);
    _secondary.findAndAddVirtualProperties(config, ac, properties);
  }
  
  public PropertyName findNameForSerialization(Annotated a)
  {
    PropertyName n = _primary.findNameForSerialization(a);
    if (n == null)
    {
      n = _secondary.findNameForSerialization(a);
    }
    else if (n == PropertyName.USE_DEFAULT)
    {
      PropertyName n2 = _secondary.findNameForSerialization(a);
      if (n2 != null) {
        n = n2;
      }
    }
    return n;
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod am)
  {
    return (_primary.hasAsValueAnnotation(am)) || (_secondary.hasAsValueAnnotation(am));
  }
  
  public String findEnumValue(Enum<?> value)
  {
    String r = _primary.findEnumValue(value);
    return r == null ? _secondary.findEnumValue(value) : r;
  }
  
  public Object findDeserializer(Annotated am)
  {
    Object r = _primary.findDeserializer(am);
    return _isExplicitClassOrOb(r, JsonDeserializer.None.class) ? r : _secondary.findDeserializer(am);
  }
  
  public Object findKeyDeserializer(Annotated am)
  {
    Object r = _primary.findKeyDeserializer(am);
    return _isExplicitClassOrOb(r, KeyDeserializer.None.class) ? r : _secondary.findKeyDeserializer(am);
  }
  
  public Object findContentDeserializer(Annotated am)
  {
    Object r = _primary.findContentDeserializer(am);
    return _isExplicitClassOrOb(r, JsonDeserializer.None.class) ? r : _secondary.findContentDeserializer(am);
  }
  
  public Class<?> findDeserializationType(Annotated am, JavaType baseType)
  {
    Class<?> r = _primary.findDeserializationType(am, baseType);
    return r != null ? r : _secondary.findDeserializationType(am, baseType);
  }
  
  public Class<?> findDeserializationKeyType(Annotated am, JavaType baseKeyType)
  {
    Class<?> result = _primary.findDeserializationKeyType(am, baseKeyType);
    return result == null ? _secondary.findDeserializationKeyType(am, baseKeyType) : result;
  }
  
  public Class<?> findDeserializationContentType(Annotated am, JavaType baseContentType)
  {
    Class<?> result = _primary.findDeserializationContentType(am, baseContentType);
    return result == null ? _secondary.findDeserializationContentType(am, baseContentType) : result;
  }
  
  public Object findDeserializationConverter(Annotated a)
  {
    Object ob = _primary.findDeserializationConverter(a);
    return ob == null ? _secondary.findDeserializationConverter(a) : ob;
  }
  
  public Object findDeserializationContentConverter(AnnotatedMember a)
  {
    Object ob = _primary.findDeserializationContentConverter(a);
    return ob == null ? _secondary.findDeserializationContentConverter(a) : ob;
  }
  
  public Object findValueInstantiator(AnnotatedClass ac)
  {
    Object result = _primary.findValueInstantiator(ac);
    return result == null ? _secondary.findValueInstantiator(ac) : result;
  }
  
  public Class<?> findPOJOBuilder(AnnotatedClass ac)
  {
    Class<?> result = _primary.findPOJOBuilder(ac);
    return result == null ? _secondary.findPOJOBuilder(ac) : result;
  }
  
  public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass ac)
  {
    JsonPOJOBuilder.Value result = _primary.findPOJOBuilderConfig(ac);
    return result == null ? _secondary.findPOJOBuilderConfig(ac) : result;
  }
  
  public PropertyName findNameForDeserialization(Annotated a)
  {
    PropertyName n = _primary.findNameForDeserialization(a);
    if (n == null)
    {
      n = _secondary.findNameForDeserialization(a);
    }
    else if (n == PropertyName.USE_DEFAULT)
    {
      PropertyName n2 = _secondary.findNameForDeserialization(a);
      if (n2 != null) {
        n = n2;
      }
    }
    return n;
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod am)
  {
    return (_primary.hasAnySetterAnnotation(am)) || (_secondary.hasAnySetterAnnotation(am));
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod am)
  {
    return (_primary.hasAnyGetterAnnotation(am)) || (_secondary.hasAnyGetterAnnotation(am));
  }
  
  public boolean hasCreatorAnnotation(Annotated a)
  {
    return (_primary.hasCreatorAnnotation(a)) || (_secondary.hasCreatorAnnotation(a));
  }
  
  public JsonCreator.Mode findCreatorBinding(Annotated a)
  {
    JsonCreator.Mode mode = _primary.findCreatorBinding(a);
    if (mode != null) {
      return mode;
    }
    return _secondary.findCreatorBinding(a);
  }
  
  protected boolean _isExplicitClassOrOb(Object maybeCls, Class<?> implicit)
  {
    if (maybeCls == null) {
      return false;
    }
    if (!(maybeCls instanceof Class)) {
      return true;
    }
    Class<?> cls = (Class)maybeCls;
    return (cls != implicit) && (!ClassUtil.isBogusClass(cls));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */