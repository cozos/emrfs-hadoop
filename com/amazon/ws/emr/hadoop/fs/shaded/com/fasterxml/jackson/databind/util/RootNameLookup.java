package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

public class RootNameLookup
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected transient LRUMap<ClassKey, PropertyName> _rootNames;
  
  public RootNameLookup()
  {
    _rootNames = new LRUMap(20, 200);
  }
  
  public PropertyName findRootName(JavaType rootType, MapperConfig<?> config)
  {
    return findRootName(rootType.getRawClass(), config);
  }
  
  public PropertyName findRootName(Class<?> rootType, MapperConfig<?> config)
  {
    ClassKey key = new ClassKey(rootType);
    PropertyName name = (PropertyName)_rootNames.get(key);
    if (name != null) {
      return name;
    }
    BeanDescription beanDesc = config.introspectClassAnnotations(rootType);
    AnnotationIntrospector intr = config.getAnnotationIntrospector();
    AnnotatedClass ac = beanDesc.getClassInfo();
    name = intr.findRootName(ac);
    if ((name == null) || (!name.hasSimpleName())) {
      name = PropertyName.construct(rootType.getSimpleName());
    }
    _rootNames.put(key, name);
    return name;
  }
  
  protected Object readResolve()
  {
    return new RootNameLookup();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RootNameLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */