package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.Serializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

public final class SerializerFactoryConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
  protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
  protected final Serializers[] _additionalSerializers;
  protected final Serializers[] _additionalKeySerializers;
  protected final BeanSerializerModifier[] _modifiers;
  
  public SerializerFactoryConfig()
  {
    this(null, null, null);
  }
  
  protected SerializerFactoryConfig(Serializers[] allAdditionalSerializers, Serializers[] allAdditionalKeySerializers, BeanSerializerModifier[] modifiers)
  {
    _additionalSerializers = (allAdditionalSerializers == null ? NO_SERIALIZERS : allAdditionalSerializers);
    
    _additionalKeySerializers = (allAdditionalKeySerializers == null ? NO_SERIALIZERS : allAdditionalKeySerializers);
    
    _modifiers = (modifiers == null ? NO_MODIFIERS : modifiers);
  }
  
  public SerializerFactoryConfig withAdditionalSerializers(Serializers additional)
  {
    if (additional == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    Serializers[] all = (Serializers[])ArrayBuilders.insertInListNoDup(_additionalSerializers, additional);
    return new SerializerFactoryConfig(all, _additionalKeySerializers, _modifiers);
  }
  
  public SerializerFactoryConfig withAdditionalKeySerializers(Serializers additional)
  {
    if (additional == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    Serializers[] all = (Serializers[])ArrayBuilders.insertInListNoDup(_additionalKeySerializers, additional);
    return new SerializerFactoryConfig(_additionalSerializers, all, _modifiers);
  }
  
  public SerializerFactoryConfig withSerializerModifier(BeanSerializerModifier modifier)
  {
    if (modifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    BeanSerializerModifier[] modifiers = (BeanSerializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, modifier);
    return new SerializerFactoryConfig(_additionalSerializers, _additionalKeySerializers, modifiers);
  }
  
  public boolean hasSerializers()
  {
    return _additionalSerializers.length > 0;
  }
  
  public boolean hasKeySerializers()
  {
    return _additionalKeySerializers.length > 0;
  }
  
  public boolean hasSerializerModifiers()
  {
    return _modifiers.length > 0;
  }
  
  public Iterable<Serializers> serializers()
  {
    return new ArrayIterator(_additionalSerializers);
  }
  
  public Iterable<Serializers> keySerializers()
  {
    return new ArrayIterator(_additionalKeySerializers);
  }
  
  public Iterable<BeanSerializerModifier> serializerModifiers()
  {
    return new ArrayIterator(_modifiers);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */