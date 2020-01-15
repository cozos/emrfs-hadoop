package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.IOException;
import java.io.Serializable;

@JacksonStdImpl
public class StdValueInstantiator
  extends ValueInstantiator
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final String _valueTypeDesc;
  protected AnnotatedWithParams _defaultCreator;
  protected AnnotatedWithParams _withArgsCreator;
  protected SettableBeanProperty[] _constructorArguments;
  protected JavaType _delegateType;
  protected AnnotatedWithParams _delegateCreator;
  protected SettableBeanProperty[] _delegateArguments;
  protected AnnotatedWithParams _fromStringCreator;
  protected AnnotatedWithParams _fromIntCreator;
  protected AnnotatedWithParams _fromLongCreator;
  protected AnnotatedWithParams _fromDoubleCreator;
  protected AnnotatedWithParams _fromBooleanCreator;
  protected AnnotatedParameter _incompleteParameter;
  
  public StdValueInstantiator(DeserializationConfig config, Class<?> valueType)
  {
    _valueTypeDesc = (valueType == null ? "UNKNOWN TYPE" : valueType.getName());
  }
  
  public StdValueInstantiator(DeserializationConfig config, JavaType valueType)
  {
    _valueTypeDesc = (valueType == null ? "UNKNOWN TYPE" : valueType.toString());
  }
  
  protected StdValueInstantiator(StdValueInstantiator src)
  {
    _valueTypeDesc = _valueTypeDesc;
    
    _defaultCreator = _defaultCreator;
    
    _constructorArguments = _constructorArguments;
    _withArgsCreator = _withArgsCreator;
    
    _delegateType = _delegateType;
    _delegateCreator = _delegateCreator;
    _delegateArguments = _delegateArguments;
    
    _fromStringCreator = _fromStringCreator;
    _fromIntCreator = _fromIntCreator;
    _fromLongCreator = _fromLongCreator;
    _fromDoubleCreator = _fromDoubleCreator;
    _fromBooleanCreator = _fromBooleanCreator;
  }
  
  public void configureFromObjectSettings(AnnotatedWithParams defaultCreator, AnnotatedWithParams delegateCreator, JavaType delegateType, SettableBeanProperty[] delegateArgs, AnnotatedWithParams withArgsCreator, SettableBeanProperty[] constructorArgs)
  {
    _defaultCreator = defaultCreator;
    _delegateCreator = delegateCreator;
    _delegateType = delegateType;
    _delegateArguments = delegateArgs;
    _withArgsCreator = withArgsCreator;
    _constructorArguments = constructorArgs;
  }
  
  public void configureFromStringCreator(AnnotatedWithParams creator)
  {
    _fromStringCreator = creator;
  }
  
  public void configureFromIntCreator(AnnotatedWithParams creator)
  {
    _fromIntCreator = creator;
  }
  
  public void configureFromLongCreator(AnnotatedWithParams creator)
  {
    _fromLongCreator = creator;
  }
  
  public void configureFromDoubleCreator(AnnotatedWithParams creator)
  {
    _fromDoubleCreator = creator;
  }
  
  public void configureFromBooleanCreator(AnnotatedWithParams creator)
  {
    _fromBooleanCreator = creator;
  }
  
  public void configureIncompleteParameter(AnnotatedParameter parameter)
  {
    _incompleteParameter = parameter;
  }
  
  public String getValueTypeDesc()
  {
    return _valueTypeDesc;
  }
  
  public boolean canCreateFromString()
  {
    return _fromStringCreator != null;
  }
  
  public boolean canCreateFromInt()
  {
    return _fromIntCreator != null;
  }
  
  public boolean canCreateFromLong()
  {
    return _fromLongCreator != null;
  }
  
  public boolean canCreateFromDouble()
  {
    return _fromDoubleCreator != null;
  }
  
  public boolean canCreateFromBoolean()
  {
    return _fromBooleanCreator != null;
  }
  
  public boolean canCreateUsingDefault()
  {
    return _defaultCreator != null;
  }
  
  public boolean canCreateUsingDelegate()
  {
    return _delegateType != null;
  }
  
  public boolean canCreateFromObjectWith()
  {
    return _withArgsCreator != null;
  }
  
  public JavaType getDelegateType(DeserializationConfig config)
  {
    return _delegateType;
  }
  
  public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig config)
  {
    return _constructorArguments;
  }
  
  public Object createUsingDefault(DeserializationContext ctxt)
    throws IOException
  {
    if (_defaultCreator == null) {
      throw new IllegalStateException("No default constructor for " + getValueTypeDesc());
    }
    try
    {
      return _defaultCreator.call();
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
  }
  
  public Object createFromObjectWith(DeserializationContext ctxt, Object[] args)
    throws IOException
  {
    if (_withArgsCreator == null) {
      throw new IllegalStateException("No with-args constructor for " + getValueTypeDesc());
    }
    try
    {
      return _withArgsCreator.call(args);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
  }
  
  public Object createUsingDelegate(DeserializationContext ctxt, Object delegate)
    throws IOException
  {
    if (_delegateCreator == null) {
      throw new IllegalStateException("No delegate constructor for " + getValueTypeDesc());
    }
    try
    {
      if (_delegateArguments == null) {
        return _delegateCreator.call1(delegate);
      }
      int len = _delegateArguments.length;
      Object[] args = new Object[len];
      for (int i = 0; i < len; i++)
      {
        SettableBeanProperty prop = _delegateArguments[i];
        if (prop == null) {
          args[i] = delegate;
        } else {
          args[i] = ctxt.findInjectableValue(prop.getInjectableValueId(), prop, null);
        }
      }
      return _delegateCreator.call(args);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
  }
  
  public Object createFromString(DeserializationContext ctxt, String value)
    throws IOException
  {
    if (_fromStringCreator != null) {
      try
      {
        return _fromStringCreator.call1(value);
      }
      catch (Exception e)
      {
        throw wrapException(e);
      }
      catch (ExceptionInInitializerError e)
      {
        throw wrapException(e);
      }
    }
    return _createFromStringFallbacks(ctxt, value);
  }
  
  public Object createFromInt(DeserializationContext ctxt, int value)
    throws IOException
  {
    try
    {
      if (_fromIntCreator != null) {
        return _fromIntCreator.call1(Integer.valueOf(value));
      }
      if (_fromLongCreator != null) {
        return _fromLongCreator.call1(Long.valueOf(value));
      }
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    throw ctxt.mappingException("Can not instantiate value of type %s from Integral number (%s); no single-int-arg constructor/factory method", new Object[] { getValueTypeDesc(), Integer.valueOf(value) });
  }
  
  public Object createFromLong(DeserializationContext ctxt, long value)
    throws IOException
  {
    try
    {
      if (_fromLongCreator != null) {
        return _fromLongCreator.call1(Long.valueOf(value));
      }
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    throw ctxt.mappingException("Can not instantiate value of type %s from Long integral number (%s); no single-long-arg constructor/factory method", new Object[] { getValueTypeDesc(), Long.valueOf(value) });
  }
  
  public Object createFromDouble(DeserializationContext ctxt, double value)
    throws IOException
  {
    try
    {
      if (_fromDoubleCreator != null) {
        return _fromDoubleCreator.call1(Double.valueOf(value));
      }
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    throw ctxt.mappingException("Can not instantiate value of type %s from Floating-point number (%s); no one-double/Double-arg constructor/factory method", new Object[] { getValueTypeDesc(), Double.valueOf(value) });
  }
  
  public Object createFromBoolean(DeserializationContext ctxt, boolean value)
    throws IOException
  {
    try
    {
      if (_fromBooleanCreator != null) {
        return _fromBooleanCreator.call1(Boolean.valueOf(value));
      }
    }
    catch (Exception e)
    {
      throw wrapException(e);
    }
    catch (ExceptionInInitializerError e)
    {
      throw wrapException(e);
    }
    throw ctxt.mappingException("Can not instantiate value of type %s from Boolean value (%s); no single-boolean/Boolean-arg constructor/factory method", new Object[] { getValueTypeDesc(), Boolean.valueOf(value) });
  }
  
  public AnnotatedWithParams getDelegateCreator()
  {
    return _delegateCreator;
  }
  
  public AnnotatedWithParams getDefaultCreator()
  {
    return _defaultCreator;
  }
  
  public AnnotatedWithParams getWithArgsCreator()
  {
    return _withArgsCreator;
  }
  
  public AnnotatedParameter getIncompleteParameter()
  {
    return _incompleteParameter;
  }
  
  protected JsonMappingException wrapException(Throwable t)
  {
    while (t.getCause() != null) {
      t = t.getCause();
    }
    if ((t instanceof JsonMappingException)) {
      return (JsonMappingException)t;
    }
    return new JsonMappingException("Instantiation of " + getValueTypeDesc() + " value failed: " + t.getMessage(), t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdValueInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */