package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DatabindContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class TypeNameIdResolver
  extends TypeIdResolverBase
{
  protected final MapperConfig<?> _config;
  protected final HashMap<String, String> _typeToId;
  protected final HashMap<String, JavaType> _idToType;
  
  protected TypeNameIdResolver(MapperConfig<?> config, JavaType baseType, HashMap<String, String> typeToId, HashMap<String, JavaType> idToType)
  {
    super(baseType, config.getTypeFactory());
    _config = config;
    _typeToId = typeToId;
    _idToType = idToType;
  }
  
  public static TypeNameIdResolver construct(MapperConfig<?> config, JavaType baseType, Collection<NamedType> subtypes, boolean forSer, boolean forDeser)
  {
    if (forSer == forDeser) {
      throw new IllegalArgumentException();
    }
    HashMap<String, String> typeToId = null;
    HashMap<String, JavaType> idToType = null;
    if (forSer) {
      typeToId = new HashMap();
    }
    if (forDeser) {
      idToType = new HashMap();
    }
    if (subtypes != null) {
      for (NamedType t : subtypes)
      {
        Class<?> cls = t.getType();
        String id = t.hasName() ? t.getName() : _defaultTypeId(cls);
        if (forSer) {
          typeToId.put(cls.getName(), id);
        }
        if (forDeser)
        {
          JavaType prev = (JavaType)idToType.get(id);
          if ((prev == null) || 
            (!cls.isAssignableFrom(prev.getRawClass()))) {
            idToType.put(id, config.constructType(cls));
          }
        }
      }
    }
    return new TypeNameIdResolver(config, baseType, typeToId, idToType);
  }
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.NAME;
  }
  
  public String idFromValue(Object value)
  {
    return idFromClass(value.getClass());
  }
  
  protected String idFromClass(Class<?> clazz)
  {
    if (clazz == null) {
      return null;
    }
    Class<?> cls = _typeFactory.constructType(clazz).getRawClass();
    String key = cls.getName();
    String name;
    synchronized (_typeToId)
    {
      name = (String)_typeToId.get(key);
      if (name == null)
      {
        if (_config.isAnnotationProcessingEnabled())
        {
          BeanDescription beanDesc = _config.introspectClassAnnotations(cls);
          name = _config.getAnnotationIntrospector().findTypeName(beanDesc.getClassInfo());
        }
        if (name == null) {
          name = _defaultTypeId(cls);
        }
        _typeToId.put(key, name);
      }
    }
    return name;
  }
  
  public String idFromValueAndType(Object value, Class<?> type)
  {
    if (value == null) {
      return idFromClass(type);
    }
    return idFromValue(value);
  }
  
  @Deprecated
  public JavaType typeFromId(String id)
  {
    return _typeFromId(id);
  }
  
  public JavaType typeFromId(DatabindContext context, String id)
  {
    return _typeFromId(id);
  }
  
  protected JavaType _typeFromId(String id)
  {
    return (JavaType)_idToType.get(id);
  }
  
  public String getDescForKnownTypeIds()
  {
    return new TreeSet(_idToType.keySet()).toString();
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[').append(getClass().getName());
    sb.append("; id-to-type=").append(_idToType);
    sb.append(']');
    return sb.toString();
  }
  
  protected static String _defaultTypeId(Class<?> cls)
  {
    String n = cls.getName();
    int ix = n.lastIndexOf('.');
    return ix < 0 ? n : n.substring(ix + 1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.impl.TypeNameIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */