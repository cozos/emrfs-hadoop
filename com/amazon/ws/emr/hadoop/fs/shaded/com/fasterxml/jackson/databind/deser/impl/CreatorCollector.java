package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreatorCollector
{
  protected static final int C_DEFAULT = 0;
  protected static final int C_STRING = 1;
  protected static final int C_INT = 2;
  protected static final int C_LONG = 3;
  protected static final int C_DOUBLE = 4;
  protected static final int C_BOOLEAN = 5;
  protected static final int C_DELEGATE = 6;
  protected static final int C_PROPS = 7;
  protected static final String[] TYPE_DESCS = { "default", "String", "int", "long", "double", "boolean", "delegate", "property-based" };
  protected final BeanDescription _beanDesc;
  protected final boolean _canFixAccess;
  protected final AnnotatedWithParams[] _creators = new AnnotatedWithParams[8];
  protected int _explicitCreators = 0;
  protected boolean _hasNonDefaultCreator = false;
  protected SettableBeanProperty[] _delegateArgs;
  protected SettableBeanProperty[] _propertyBasedArgs;
  protected AnnotatedParameter _incompleteParameter;
  
  public CreatorCollector(BeanDescription beanDesc, boolean canFixAccess)
  {
    _beanDesc = beanDesc;
    _canFixAccess = canFixAccess;
  }
  
  public ValueInstantiator constructValueInstantiator(DeserializationConfig config)
  {
    boolean maybeVanilla = !_hasNonDefaultCreator;
    JavaType delegateType;
    JavaType delegateType;
    if ((maybeVanilla) || (_creators[6] == null))
    {
      delegateType = null;
    }
    else
    {
      int ix = 0;
      if (_delegateArgs != null)
      {
        int i = 0;
        for (int len = _delegateArgs.length; i < len; i++) {
          if (_delegateArgs[i] == null)
          {
            ix = i;
            break;
          }
        }
      }
      TypeBindings bindings = _beanDesc.bindingsForBeanType();
      delegateType = bindings.resolveType(_creators[6].getGenericParameterType(ix));
    }
    JavaType type = _beanDesc.getType();
    
    maybeVanilla &= !_hasNonDefaultCreator;
    if (maybeVanilla)
    {
      Class<?> rawType = type.getRawClass();
      if ((rawType == Collection.class) || (rawType == List.class) || (rawType == ArrayList.class)) {
        return new Vanilla(1);
      }
      if ((rawType == Map.class) || (rawType == LinkedHashMap.class)) {
        return new Vanilla(2);
      }
      if (rawType == HashMap.class) {
        return new Vanilla(3);
      }
    }
    StdValueInstantiator inst = new StdValueInstantiator(config, type);
    inst.configureFromObjectSettings(_creators[0], _creators[6], delegateType, _delegateArgs, _creators[7], _propertyBasedArgs);
    
    inst.configureFromStringCreator(_creators[1]);
    inst.configureFromIntCreator(_creators[2]);
    inst.configureFromLongCreator(_creators[3]);
    inst.configureFromDoubleCreator(_creators[4]);
    inst.configureFromBooleanCreator(_creators[5]);
    inst.configureIncompleteParameter(_incompleteParameter);
    return inst;
  }
  
  public void setDefaultCreator(AnnotatedWithParams creator)
  {
    _creators[0] = ((AnnotatedWithParams)_fixAccess(creator));
  }
  
  public void addStringCreator(AnnotatedWithParams creator, boolean explicit)
  {
    verifyNonDup(creator, 1, explicit);
  }
  
  public void addIntCreator(AnnotatedWithParams creator, boolean explicit)
  {
    verifyNonDup(creator, 2, explicit);
  }
  
  public void addLongCreator(AnnotatedWithParams creator, boolean explicit)
  {
    verifyNonDup(creator, 3, explicit);
  }
  
  public void addDoubleCreator(AnnotatedWithParams creator, boolean explicit)
  {
    verifyNonDup(creator, 4, explicit);
  }
  
  public void addBooleanCreator(AnnotatedWithParams creator, boolean explicit)
  {
    verifyNonDup(creator, 5, explicit);
  }
  
  public void addDelegatingCreator(AnnotatedWithParams creator, boolean explicit, SettableBeanProperty[] injectables)
  {
    verifyNonDup(creator, 6, explicit);
    _delegateArgs = injectables;
  }
  
  public void addPropertyCreator(AnnotatedWithParams creator, boolean explicit, SettableBeanProperty[] properties)
  {
    verifyNonDup(creator, 7, explicit);
    if (properties.length > 1)
    {
      HashMap<String, Integer> names = new HashMap();
      int i = 0;
      for (int len = properties.length; i < len; i++)
      {
        String name = properties[i].getName();
        if ((name.length() != 0) || (properties[i].getInjectableValueId() == null))
        {
          Integer old = (Integer)names.put(name, Integer.valueOf(i));
          if (old != null) {
            throw new IllegalArgumentException("Duplicate creator property \"" + name + "\" (index " + old + " vs " + i + ")");
          }
        }
      }
    }
    _propertyBasedArgs = properties;
  }
  
  public void addIncompeteParameter(AnnotatedParameter parameter)
  {
    if (_incompleteParameter == null) {
      _incompleteParameter = parameter;
    }
  }
  
  @Deprecated
  public void addStringCreator(AnnotatedWithParams creator)
  {
    addStringCreator(creator, false);
  }
  
  @Deprecated
  public void addIntCreator(AnnotatedWithParams creator)
  {
    addBooleanCreator(creator, false);
  }
  
  @Deprecated
  public void addLongCreator(AnnotatedWithParams creator)
  {
    addBooleanCreator(creator, false);
  }
  
  @Deprecated
  public void addDoubleCreator(AnnotatedWithParams creator)
  {
    addBooleanCreator(creator, false);
  }
  
  @Deprecated
  public void addBooleanCreator(AnnotatedWithParams creator)
  {
    addBooleanCreator(creator, false);
  }
  
  @Deprecated
  public void addDelegatingCreator(AnnotatedWithParams creator, CreatorProperty[] injectables)
  {
    addDelegatingCreator(creator, false, injectables);
  }
  
  @Deprecated
  public void addPropertyCreator(AnnotatedWithParams creator, CreatorProperty[] properties)
  {
    addPropertyCreator(creator, false, properties);
  }
  
  public boolean hasDefaultCreator()
  {
    return _creators[0] != null;
  }
  
  public boolean hasDelegatingCreator()
  {
    return _creators[6] != null;
  }
  
  public boolean hasPropertyBasedCreator()
  {
    return _creators[7] != null;
  }
  
  private <T extends AnnotatedMember> T _fixAccess(T member)
  {
    if ((member != null) && (_canFixAccess)) {
      ClassUtil.checkAndFixAccess((Member)member.getAnnotated());
    }
    return member;
  }
  
  protected void verifyNonDup(AnnotatedWithParams newOne, int typeIndex, boolean explicit)
  {
    int mask = 1 << typeIndex;
    _hasNonDefaultCreator = true;
    AnnotatedWithParams oldOne = _creators[typeIndex];
    if (oldOne != null)
    {
      boolean verify;
      boolean verify;
      if ((_explicitCreators & mask) != 0)
      {
        if (!explicit) {
          return;
        }
        verify = true;
      }
      else
      {
        verify = !explicit;
      }
      if ((verify) && (oldOne.getClass() == newOne.getClass()))
      {
        Class<?> oldType = oldOne.getRawParameterType(0);
        Class<?> newType = newOne.getRawParameterType(0);
        if (oldType == newType) {
          throw new IllegalArgumentException("Conflicting " + TYPE_DESCS[typeIndex] + " creators: already had explicitly marked " + oldOne + ", encountered " + newOne);
        }
        if (newType.isAssignableFrom(oldType)) {
          return;
        }
      }
    }
    if (explicit) {
      _explicitCreators |= mask;
    }
    _creators[typeIndex] = ((AnnotatedWithParams)_fixAccess(newOne));
  }
  
  protected static final class Vanilla
    extends ValueInstantiator
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public static final int TYPE_COLLECTION = 1;
    public static final int TYPE_MAP = 2;
    public static final int TYPE_HASH_MAP = 3;
    private final int _type;
    
    public Vanilla(int t)
    {
      _type = t;
    }
    
    public String getValueTypeDesc()
    {
      switch (_type)
      {
      case 1: 
        return ArrayList.class.getName();
      case 2: 
        return LinkedHashMap.class.getName();
      case 3: 
        return HashMap.class.getName();
      }
      return Object.class.getName();
    }
    
    public boolean canInstantiate()
    {
      return true;
    }
    
    public boolean canCreateUsingDefault()
    {
      return true;
    }
    
    public Object createUsingDefault(DeserializationContext ctxt)
      throws IOException
    {
      switch (_type)
      {
      case 1: 
        return new ArrayList();
      case 2: 
        return new LinkedHashMap();
      case 3: 
        return new HashMap();
      }
      throw new IllegalStateException("Unknown type " + _type);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.CreatorCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */