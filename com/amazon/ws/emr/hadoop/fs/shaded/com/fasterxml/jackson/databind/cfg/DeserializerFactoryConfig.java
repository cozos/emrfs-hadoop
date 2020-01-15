package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

public class DeserializerFactoryConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];
  protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
  protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
  protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
  protected static final KeyDeserializers[] DEFAULT_KEY_DESERIALIZERS = { new StdKeyDeserializers() };
  protected final Deserializers[] _additionalDeserializers;
  protected final KeyDeserializers[] _additionalKeyDeserializers;
  protected final BeanDeserializerModifier[] _modifiers;
  protected final AbstractTypeResolver[] _abstractTypeResolvers;
  protected final ValueInstantiators[] _valueInstantiators;
  
  public DeserializerFactoryConfig()
  {
    this(null, null, null, null, null);
  }
  
  protected DeserializerFactoryConfig(Deserializers[] allAdditionalDeserializers, KeyDeserializers[] allAdditionalKeyDeserializers, BeanDeserializerModifier[] modifiers, AbstractTypeResolver[] atr, ValueInstantiators[] vi)
  {
    _additionalDeserializers = (allAdditionalDeserializers == null ? NO_DESERIALIZERS : allAdditionalDeserializers);
    
    _additionalKeyDeserializers = (allAdditionalKeyDeserializers == null ? DEFAULT_KEY_DESERIALIZERS : allAdditionalKeyDeserializers);
    
    _modifiers = (modifiers == null ? NO_MODIFIERS : modifiers);
    _abstractTypeResolvers = (atr == null ? NO_ABSTRACT_TYPE_RESOLVERS : atr);
    _valueInstantiators = (vi == null ? NO_VALUE_INSTANTIATORS : vi);
  }
  
  public DeserializerFactoryConfig withAdditionalDeserializers(Deserializers additional)
  {
    if (additional == null) {
      throw new IllegalArgumentException("Can not pass null Deserializers");
    }
    Deserializers[] all = (Deserializers[])ArrayBuilders.insertInListNoDup(_additionalDeserializers, additional);
    return new DeserializerFactoryConfig(all, _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withAdditionalKeyDeserializers(KeyDeserializers additional)
  {
    if (additional == null) {
      throw new IllegalArgumentException("Can not pass null KeyDeserializers");
    }
    KeyDeserializers[] all = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(_additionalKeyDeserializers, additional);
    return new DeserializerFactoryConfig(_additionalDeserializers, all, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withDeserializerModifier(BeanDeserializerModifier modifier)
  {
    if (modifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    BeanDeserializerModifier[] all = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, modifier);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, all, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withAbstractTypeResolver(AbstractTypeResolver resolver)
  {
    if (resolver == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    AbstractTypeResolver[] all = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(_abstractTypeResolvers, resolver);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, all, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withValueInstantiators(ValueInstantiators instantiators)
  {
    if (instantiators == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    ValueInstantiators[] all = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(_valueInstantiators, instantiators);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, all);
  }
  
  public boolean hasDeserializers()
  {
    return _additionalDeserializers.length > 0;
  }
  
  public boolean hasKeyDeserializers()
  {
    return _additionalKeyDeserializers.length > 0;
  }
  
  public boolean hasDeserializerModifiers()
  {
    return _modifiers.length > 0;
  }
  
  public boolean hasAbstractTypeResolvers()
  {
    return _abstractTypeResolvers.length > 0;
  }
  
  public boolean hasValueInstantiators()
  {
    return _valueInstantiators.length > 0;
  }
  
  public Iterable<Deserializers> deserializers()
  {
    return new ArrayIterator(_additionalDeserializers);
  }
  
  public Iterable<KeyDeserializers> keyDeserializers()
  {
    return new ArrayIterator(_additionalKeyDeserializers);
  }
  
  public Iterable<BeanDeserializerModifier> deserializerModifiers()
  {
    return new ArrayIterator(_modifiers);
  }
  
  public Iterable<AbstractTypeResolver> abstractTypeResolvers()
  {
    return new ArrayIterator(_abstractTypeResolvers);
  }
  
  public Iterable<ValueInstantiators> valueInstantiators()
  {
    return new ArrayIterator(_valueInstantiators);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */