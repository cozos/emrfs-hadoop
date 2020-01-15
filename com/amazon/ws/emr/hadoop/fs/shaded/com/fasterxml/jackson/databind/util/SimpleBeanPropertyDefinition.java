package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class SimpleBeanPropertyDefinition
  extends BeanPropertyDefinition
{
  protected final AnnotationIntrospector _introspector;
  protected final AnnotatedMember _member;
  protected final PropertyMetadata _metadata;
  protected final PropertyName _fullName;
  protected final JsonInclude.Include _inclusion;
  @Deprecated
  protected final String _name;
  
  @Deprecated
  public SimpleBeanPropertyDefinition(AnnotatedMember member)
  {
    this(member, member.getName(), null);
  }
  
  @Deprecated
  public SimpleBeanPropertyDefinition(AnnotatedMember member, String name)
  {
    this(member, new PropertyName(name), null, null, null);
  }
  
  protected SimpleBeanPropertyDefinition(AnnotatedMember member, PropertyName fullName, AnnotationIntrospector intr, PropertyMetadata metadata, JsonInclude.Include inclusion)
  {
    _introspector = intr;
    _member = member;
    _fullName = fullName;
    _name = fullName.getSimpleName();
    _metadata = (metadata == null ? PropertyMetadata.STD_OPTIONAL : metadata);
    _inclusion = inclusion;
  }
  
  @Deprecated
  protected SimpleBeanPropertyDefinition(AnnotatedMember member, String name, AnnotationIntrospector intr)
  {
    this(member, new PropertyName(name), intr, null, null);
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> config, AnnotatedMember member)
  {
    return new SimpleBeanPropertyDefinition(member, PropertyName.construct(member.getName()), config == null ? null : config.getAnnotationIntrospector(), null, null);
  }
  
  @Deprecated
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> config, AnnotatedMember member, String name)
  {
    return new SimpleBeanPropertyDefinition(member, PropertyName.construct(name), config == null ? null : config.getAnnotationIntrospector(), null, null);
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> config, AnnotatedMember member, PropertyName name)
  {
    return construct(config, member, name, null, null);
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> config, AnnotatedMember member, PropertyName name, PropertyMetadata metadata, JsonInclude.Include inclusion)
  {
    return new SimpleBeanPropertyDefinition(member, name, config == null ? null : config.getAnnotationIntrospector(), metadata, inclusion);
  }
  
  @Deprecated
  public BeanPropertyDefinition withName(String newName)
  {
    return withSimpleName(newName);
  }
  
  public BeanPropertyDefinition withSimpleName(String newName)
  {
    if ((_fullName.hasSimpleName(newName)) && (!_fullName.hasNamespace())) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, new PropertyName(newName), _introspector, _metadata, _inclusion);
  }
  
  public BeanPropertyDefinition withName(PropertyName newName)
  {
    if (_fullName.equals(newName)) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, newName, _introspector, _metadata, _inclusion);
  }
  
  public BeanPropertyDefinition withMetadata(PropertyMetadata metadata)
  {
    if (metadata.equals(_metadata)) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, _fullName, _introspector, metadata, _inclusion);
  }
  
  public BeanPropertyDefinition withInclusion(JsonInclude.Include inclusion)
  {
    if (_inclusion == inclusion) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, _fullName, _introspector, _metadata, inclusion);
  }
  
  public String getName()
  {
    return _fullName.getSimpleName();
  }
  
  public PropertyName getFullName()
  {
    return _fullName;
  }
  
  public boolean hasName(PropertyName name)
  {
    return _fullName.equals(name);
  }
  
  public String getInternalName()
  {
    return getName();
  }
  
  public PropertyName getWrapperName()
  {
    return (_introspector == null) && (_member != null) ? null : _introspector.findWrapperName(_member);
  }
  
  public boolean isExplicitlyIncluded()
  {
    return false;
  }
  
  public boolean isExplicitlyNamed()
  {
    return false;
  }
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public JsonInclude.Include findInclusion()
  {
    return _inclusion;
  }
  
  public boolean hasGetter()
  {
    return getGetter() != null;
  }
  
  public boolean hasSetter()
  {
    return getSetter() != null;
  }
  
  public boolean hasField()
  {
    return _member instanceof AnnotatedField;
  }
  
  public boolean hasConstructorParameter()
  {
    return _member instanceof AnnotatedParameter;
  }
  
  public AnnotatedMethod getGetter()
  {
    if (((_member instanceof AnnotatedMethod)) && (((AnnotatedMethod)_member).getParameterCount() == 0)) {
      return (AnnotatedMethod)_member;
    }
    return null;
  }
  
  public AnnotatedMethod getSetter()
  {
    if (((_member instanceof AnnotatedMethod)) && (((AnnotatedMethod)_member).getParameterCount() == 1)) {
      return (AnnotatedMethod)_member;
    }
    return null;
  }
  
  public AnnotatedField getField()
  {
    return (_member instanceof AnnotatedField) ? (AnnotatedField)_member : null;
  }
  
  public AnnotatedParameter getConstructorParameter()
  {
    return (_member instanceof AnnotatedParameter) ? (AnnotatedParameter)_member : null;
  }
  
  public Iterator<AnnotatedParameter> getConstructorParameters()
  {
    AnnotatedParameter param = getConstructorParameter();
    if (param == null) {
      return EmptyIterator.instance();
    }
    return Collections.singleton(param).iterator();
  }
  
  public AnnotatedMember getAccessor()
  {
    AnnotatedMember acc = getGetter();
    if (acc == null) {
      acc = getField();
    }
    return acc;
  }
  
  public AnnotatedMember getMutator()
  {
    AnnotatedMember acc = getConstructorParameter();
    if (acc == null)
    {
      acc = getSetter();
      if (acc == null) {
        acc = getField();
      }
    }
    return acc;
  }
  
  public AnnotatedMember getNonConstructorMutator()
  {
    AnnotatedMember acc = getSetter();
    if (acc == null) {
      acc = getField();
    }
    return acc;
  }
  
  public AnnotatedMember getPrimaryMember()
  {
    return _member;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */