package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.Module.SetupContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleModule
  extends Module
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final String _name;
  protected final Version _version;
  protected SimpleSerializers _serializers = null;
  protected SimpleDeserializers _deserializers = null;
  protected SimpleSerializers _keySerializers = null;
  protected SimpleKeyDeserializers _keyDeserializers = null;
  protected SimpleAbstractTypeResolver _abstractTypes = null;
  protected SimpleValueInstantiators _valueInstantiators = null;
  protected BeanDeserializerModifier _deserializerModifier = null;
  protected BeanSerializerModifier _serializerModifier = null;
  protected HashMap<Class<?>, Class<?>> _mixins = null;
  protected LinkedHashSet<NamedType> _subtypes = null;
  protected PropertyNamingStrategy _namingStrategy = null;
  
  public SimpleModule()
  {
    _name = (getClass() == SimpleModule.class ? "SimpleModule-" + System.identityHashCode(this) : getClass().getName());
    
    _version = Version.unknownVersion();
  }
  
  public SimpleModule(String name)
  {
    this(name, Version.unknownVersion());
  }
  
  public SimpleModule(Version version)
  {
    _name = version.getArtifactId();
    _version = version;
  }
  
  public SimpleModule(String name, Version version)
  {
    _name = name;
    _version = version;
  }
  
  public SimpleModule(String name, Version version, Map<Class<?>, JsonDeserializer<?>> deserializers)
  {
    this(name, version, deserializers, null);
  }
  
  public SimpleModule(String name, Version version, List<JsonSerializer<?>> serializers)
  {
    this(name, version, null, serializers);
  }
  
  public SimpleModule(String name, Version version, Map<Class<?>, JsonDeserializer<?>> deserializers, List<JsonSerializer<?>> serializers)
  {
    _name = name;
    _version = version;
    if (deserializers != null) {
      _deserializers = new SimpleDeserializers(deserializers);
    }
    if (serializers != null) {
      _serializers = new SimpleSerializers(serializers);
    }
  }
  
  public Object getTypeId()
  {
    if (getClass() == SimpleModule.class) {
      return null;
    }
    return super.getTypeId();
  }
  
  public void setSerializers(SimpleSerializers s)
  {
    _serializers = s;
  }
  
  public void setDeserializers(SimpleDeserializers d)
  {
    _deserializers = d;
  }
  
  public void setKeySerializers(SimpleSerializers ks)
  {
    _keySerializers = ks;
  }
  
  public void setKeyDeserializers(SimpleKeyDeserializers kd)
  {
    _keyDeserializers = kd;
  }
  
  public void setAbstractTypes(SimpleAbstractTypeResolver atr)
  {
    _abstractTypes = atr;
  }
  
  public void setValueInstantiators(SimpleValueInstantiators svi)
  {
    _valueInstantiators = svi;
  }
  
  public SimpleModule setDeserializerModifier(BeanDeserializerModifier mod)
  {
    _deserializerModifier = mod;
    return this;
  }
  
  public SimpleModule setSerializerModifier(BeanSerializerModifier mod)
  {
    _serializerModifier = mod;
    return this;
  }
  
  protected SimpleModule setNamingStrategy(PropertyNamingStrategy naming)
  {
    _namingStrategy = naming;
    return this;
  }
  
  public SimpleModule addSerializer(JsonSerializer<?> ser)
  {
    if (_serializers == null) {
      _serializers = new SimpleSerializers();
    }
    _serializers.addSerializer(ser);
    return this;
  }
  
  public <T> SimpleModule addSerializer(Class<? extends T> type, JsonSerializer<T> ser)
  {
    if (_serializers == null) {
      _serializers = new SimpleSerializers();
    }
    _serializers.addSerializer(type, ser);
    return this;
  }
  
  public <T> SimpleModule addKeySerializer(Class<? extends T> type, JsonSerializer<T> ser)
  {
    if (_keySerializers == null) {
      _keySerializers = new SimpleSerializers();
    }
    _keySerializers.addSerializer(type, ser);
    return this;
  }
  
  public <T> SimpleModule addDeserializer(Class<T> type, JsonDeserializer<? extends T> deser)
  {
    if (_deserializers == null) {
      _deserializers = new SimpleDeserializers();
    }
    _deserializers.addDeserializer(type, deser);
    return this;
  }
  
  public SimpleModule addKeyDeserializer(Class<?> type, KeyDeserializer deser)
  {
    if (_keyDeserializers == null) {
      _keyDeserializers = new SimpleKeyDeserializers();
    }
    _keyDeserializers.addDeserializer(type, deser);
    return this;
  }
  
  public <T> SimpleModule addAbstractTypeMapping(Class<T> superType, Class<? extends T> subType)
  {
    if (_abstractTypes == null) {
      _abstractTypes = new SimpleAbstractTypeResolver();
    }
    _abstractTypes = _abstractTypes.addMapping(superType, subType);
    return this;
  }
  
  public SimpleModule addValueInstantiator(Class<?> beanType, ValueInstantiator inst)
  {
    if (_valueInstantiators == null) {
      _valueInstantiators = new SimpleValueInstantiators();
    }
    _valueInstantiators = _valueInstantiators.addValueInstantiator(beanType, inst);
    return this;
  }
  
  public SimpleModule registerSubtypes(Class<?>... subtypes)
  {
    if (_subtypes == null) {
      _subtypes = new LinkedHashSet(Math.max(16, subtypes.length));
    }
    for (Class<?> subtype : subtypes) {
      _subtypes.add(new NamedType(subtype));
    }
    return this;
  }
  
  public SimpleModule registerSubtypes(NamedType... subtypes)
  {
    if (_subtypes == null) {
      _subtypes = new LinkedHashSet(Math.max(16, subtypes.length));
    }
    for (NamedType subtype : subtypes) {
      _subtypes.add(subtype);
    }
    return this;
  }
  
  public SimpleModule setMixInAnnotation(Class<?> targetType, Class<?> mixinClass)
  {
    if (_mixins == null) {
      _mixins = new HashMap();
    }
    _mixins.put(targetType, mixinClass);
    return this;
  }
  
  public String getModuleName()
  {
    return _name;
  }
  
  public void setupModule(Module.SetupContext context)
  {
    if (_serializers != null) {
      context.addSerializers(_serializers);
    }
    if (_deserializers != null) {
      context.addDeserializers(_deserializers);
    }
    if (_keySerializers != null) {
      context.addKeySerializers(_keySerializers);
    }
    if (_keyDeserializers != null) {
      context.addKeyDeserializers(_keyDeserializers);
    }
    if (_abstractTypes != null) {
      context.addAbstractTypeResolver(_abstractTypes);
    }
    if (_valueInstantiators != null) {
      context.addValueInstantiators(_valueInstantiators);
    }
    if (_deserializerModifier != null) {
      context.addBeanDeserializerModifier(_deserializerModifier);
    }
    if (_serializerModifier != null) {
      context.addBeanSerializerModifier(_serializerModifier);
    }
    if ((_subtypes != null) && (_subtypes.size() > 0)) {
      context.registerSubtypes((NamedType[])_subtypes.toArray(new NamedType[_subtypes.size()]));
    }
    if (_namingStrategy != null) {
      context.setNamingStrategy(_namingStrategy);
    }
    if (_mixins != null) {
      for (Map.Entry<Class<?>, Class<?>> entry : _mixins.entrySet()) {
        context.setMixInAnnotations((Class)entry.getKey(), (Class)entry.getValue());
      }
    }
  }
  
  public Version version()
  {
    return _version;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module.SimpleModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */