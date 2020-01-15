package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StdSubtypeResolver
  extends SubtypeResolver
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected LinkedHashSet<NamedType> _registeredSubtypes;
  
  public void registerSubtypes(NamedType... types)
  {
    if (_registeredSubtypes == null) {
      _registeredSubtypes = new LinkedHashSet();
    }
    for (NamedType type : types) {
      _registeredSubtypes.add(type);
    }
  }
  
  public void registerSubtypes(Class<?>... classes)
  {
    NamedType[] types = new NamedType[classes.length];
    int i = 0;
    for (int len = classes.length; i < len; i++) {
      types[i] = new NamedType(classes[i]);
    }
    registerSubtypes(types);
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedMember property, JavaType baseType)
  {
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    
    Class<?> rawBase = baseType == null ? property.getRawType() : baseType.getRawClass();
    
    HashMap<NamedType, NamedType> collected = new HashMap();
    if (_registeredSubtypes != null) {
      for (NamedType subtype : _registeredSubtypes) {
        if (rawBase.isAssignableFrom(subtype.getType()))
        {
          AnnotatedClass curr = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
          _collectAndResolve(curr, subtype, config, ai, collected);
        }
      }
    }
    Collection<NamedType> st = ai.findSubtypes(property);
    if (st != null) {
      for (NamedType nt : st)
      {
        AnnotatedClass ac = AnnotatedClass.constructWithoutSuperTypes(nt.getType(), ai, config);
        _collectAndResolve(ac, nt, config, ai, collected);
      }
    }
    NamedType rootType = new NamedType(rawBase, null);
    AnnotatedClass ac = AnnotatedClass.constructWithoutSuperTypes(rawBase, ai, config);
    
    _collectAndResolve(ac, rootType, config, ai, collected);
    
    return new ArrayList(collected.values());
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedClass type)
  {
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    HashMap<NamedType, NamedType> subtypes = new HashMap();
    Class<?> rawBase;
    if (_registeredSubtypes != null)
    {
      rawBase = type.getRawType();
      for (NamedType subtype : _registeredSubtypes) {
        if (rawBase.isAssignableFrom(subtype.getType()))
        {
          AnnotatedClass curr = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
          _collectAndResolve(curr, subtype, config, ai, subtypes);
        }
      }
    }
    NamedType rootType = new NamedType(type.getRawType(), null);
    _collectAndResolve(type, rootType, config, ai, subtypes);
    return new ArrayList(subtypes.values());
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> config, AnnotatedMember property, JavaType baseType)
  {
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    Class<?> rawBase = baseType == null ? property.getRawType() : baseType.getRawClass();
    
    Set<Class<?>> typesHandled = new HashSet();
    Map<String, NamedType> byName = new LinkedHashMap();
    
    NamedType rootType = new NamedType(rawBase, null);
    AnnotatedClass ac = AnnotatedClass.constructWithoutSuperTypes(rawBase, ai, config);
    _collectAndResolveByTypeId(ac, rootType, config, typesHandled, byName);
    
    Collection<NamedType> st = ai.findSubtypes(property);
    if (st != null) {
      for (NamedType nt : st)
      {
        ac = AnnotatedClass.constructWithoutSuperTypes(nt.getType(), ai, config);
        _collectAndResolveByTypeId(ac, nt, config, typesHandled, byName);
      }
    }
    if (_registeredSubtypes != null) {
      for (NamedType subtype : _registeredSubtypes) {
        if (rawBase.isAssignableFrom(subtype.getType()))
        {
          AnnotatedClass curr = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
          _collectAndResolveByTypeId(curr, subtype, config, typesHandled, byName);
        }
      }
    }
    return _combineNamedAndUnnamed(typesHandled, byName);
  }
  
  public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> config, AnnotatedClass type)
  {
    Set<Class<?>> typesHandled = new HashSet();
    Map<String, NamedType> byName = new LinkedHashMap();
    
    NamedType rootType = new NamedType(type.getRawType(), null);
    _collectAndResolveByTypeId(type, rootType, config, typesHandled, byName);
    Class<?> rawBase;
    if (_registeredSubtypes != null)
    {
      rawBase = type.getRawType();
      for (NamedType subtype : _registeredSubtypes) {
        if (rawBase.isAssignableFrom(subtype.getType()))
        {
          AnnotationIntrospector ai = config.getAnnotationIntrospector();
          AnnotatedClass curr = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
          _collectAndResolveByTypeId(curr, subtype, config, typesHandled, byName);
        }
      }
    }
    return _combineNamedAndUnnamed(typesHandled, byName);
  }
  
  @Deprecated
  public Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember property, MapperConfig<?> config, AnnotationIntrospector ai, JavaType baseType)
  {
    return collectAndResolveSubtypesByClass(config, property, baseType);
  }
  
  @Deprecated
  public Collection<NamedType> collectAndResolveSubtypes(AnnotatedClass type, MapperConfig<?> config, AnnotationIntrospector ai)
  {
    return collectAndResolveSubtypesByClass(config, type);
  }
  
  protected void _collectAndResolve(AnnotatedClass annotatedType, NamedType namedType, MapperConfig<?> config, AnnotationIntrospector ai, HashMap<NamedType, NamedType> collectedSubtypes)
  {
    if (!namedType.hasName())
    {
      String name = ai.findTypeName(annotatedType);
      if (name != null) {
        namedType = new NamedType(namedType.getType(), name);
      }
    }
    if (collectedSubtypes.containsKey(namedType))
    {
      if (namedType.hasName())
      {
        NamedType prev = (NamedType)collectedSubtypes.get(namedType);
        if (!prev.hasName()) {
          collectedSubtypes.put(namedType, namedType);
        }
      }
      return;
    }
    collectedSubtypes.put(namedType, namedType);
    Collection<NamedType> st = ai.findSubtypes(annotatedType);
    if ((st != null) && (!st.isEmpty())) {
      for (NamedType subtype : st)
      {
        AnnotatedClass subtypeClass = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
        _collectAndResolve(subtypeClass, subtype, config, ai, collectedSubtypes);
      }
    }
  }
  
  protected void _collectAndResolveByTypeId(AnnotatedClass annotatedType, NamedType namedType, MapperConfig<?> config, Set<Class<?>> typesHandled, Map<String, NamedType> byName)
  {
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    if (!namedType.hasName())
    {
      String name = ai.findTypeName(annotatedType);
      if (name != null) {
        namedType = new NamedType(namedType.getType(), name);
      }
    }
    if (namedType.hasName()) {
      byName.put(namedType.getName(), namedType);
    }
    if (typesHandled.add(namedType.getType()))
    {
      Collection<NamedType> st = ai.findSubtypes(annotatedType);
      if ((st != null) && (!st.isEmpty())) {
        for (NamedType subtype : st)
        {
          AnnotatedClass subtypeClass = AnnotatedClass.constructWithoutSuperTypes(subtype.getType(), ai, config);
          _collectAndResolveByTypeId(subtypeClass, subtype, config, typesHandled, byName);
        }
      }
    }
  }
  
  protected Collection<NamedType> _combineNamedAndUnnamed(Set<Class<?>> typesHandled, Map<String, NamedType> byName)
  {
    ArrayList<NamedType> result = new ArrayList(byName.values());
    for (NamedType t : byName.values()) {
      typesHandled.remove(t.getType());
    }
    for (Class<?> cls : typesHandled) {
      result.add(new NamedType(cls));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */