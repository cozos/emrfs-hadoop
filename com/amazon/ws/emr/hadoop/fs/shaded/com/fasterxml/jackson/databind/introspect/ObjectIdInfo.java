package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;

public class ObjectIdInfo
{
  protected final PropertyName _propertyName;
  protected final Class<? extends ObjectIdGenerator<?>> _generator;
  protected final Class<? extends ObjectIdResolver> _resolver;
  protected final Class<?> _scope;
  protected final boolean _alwaysAsId;
  
  public ObjectIdInfo(PropertyName name, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen, Class<? extends ObjectIdResolver> resolver)
  {
    this(name, scope, gen, false, resolver);
  }
  
  @Deprecated
  public ObjectIdInfo(PropertyName name, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen)
  {
    this(name, scope, gen, false);
  }
  
  @Deprecated
  public ObjectIdInfo(String name, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen)
  {
    this(new PropertyName(name), scope, gen, false);
  }
  
  protected ObjectIdInfo(PropertyName prop, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen, boolean alwaysAsId)
  {
    this(prop, scope, gen, alwaysAsId, SimpleObjectIdResolver.class);
  }
  
  protected ObjectIdInfo(PropertyName prop, Class<?> scope, Class<? extends ObjectIdGenerator<?>> gen, boolean alwaysAsId, Class<? extends ObjectIdResolver> resolver)
  {
    _propertyName = prop;
    _scope = scope;
    _generator = gen;
    _alwaysAsId = alwaysAsId;
    if (resolver == null) {
      resolver = SimpleObjectIdResolver.class;
    }
    _resolver = resolver;
  }
  
  public ObjectIdInfo withAlwaysAsId(boolean state)
  {
    if (_alwaysAsId == state) {
      return this;
    }
    return new ObjectIdInfo(_propertyName, _scope, _generator, state, _resolver);
  }
  
  public PropertyName getPropertyName()
  {
    return _propertyName;
  }
  
  public Class<?> getScope()
  {
    return _scope;
  }
  
  public Class<? extends ObjectIdGenerator<?>> getGeneratorType()
  {
    return _generator;
  }
  
  public Class<? extends ObjectIdResolver> getResolverType()
  {
    return _resolver;
  }
  
  public boolean getAlwaysAsId()
  {
    return _alwaysAsId;
  }
  
  public String toString()
  {
    return "ObjectIdInfo: propName=" + _propertyName + ", scope=" + (_scope == null ? "null" : _scope.getName()) + ", generatorType=" + (_generator == null ? "null" : _generator.getName()) + ", alwaysAsId=" + _alwaysAsId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */