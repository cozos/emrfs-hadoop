package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@JacksonStdImpl
public class StdKeyDeserializer
  extends KeyDeserializer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final int TYPE_BOOLEAN = 1;
  public static final int TYPE_BYTE = 2;
  public static final int TYPE_SHORT = 3;
  public static final int TYPE_CHAR = 4;
  public static final int TYPE_INT = 5;
  public static final int TYPE_LONG = 6;
  public static final int TYPE_FLOAT = 7;
  public static final int TYPE_DOUBLE = 8;
  public static final int TYPE_LOCALE = 9;
  public static final int TYPE_DATE = 10;
  public static final int TYPE_CALENDAR = 11;
  public static final int TYPE_UUID = 12;
  public static final int TYPE_URI = 13;
  public static final int TYPE_URL = 14;
  public static final int TYPE_CLASS = 15;
  public static final int TYPE_CURRENCY = 16;
  protected final int _kind;
  protected final Class<?> _keyClass;
  protected final FromStringDeserializer<?> _deser;
  
  protected StdKeyDeserializer(int kind, Class<?> cls)
  {
    this(kind, cls, null);
  }
  
  protected StdKeyDeserializer(int kind, Class<?> cls, FromStringDeserializer<?> deser)
  {
    _kind = kind;
    _keyClass = cls;
    _deser = deser;
  }
  
  public static StdKeyDeserializer forType(Class<?> raw)
  {
    if ((raw == String.class) || (raw == Object.class)) {
      return StringKD.forType(raw);
    }
    int kind;
    if (raw == UUID.class)
    {
      kind = 12;
    }
    else
    {
      int kind;
      if (raw == Integer.class)
      {
        kind = 5;
      }
      else
      {
        int kind;
        if (raw == Long.class)
        {
          kind = 6;
        }
        else
        {
          int kind;
          if (raw == Date.class)
          {
            kind = 10;
          }
          else
          {
            int kind;
            if (raw == Calendar.class)
            {
              kind = 11;
            }
            else
            {
              int kind;
              if (raw == Boolean.class)
              {
                kind = 1;
              }
              else
              {
                int kind;
                if (raw == Byte.class)
                {
                  kind = 2;
                }
                else
                {
                  int kind;
                  if (raw == Character.class)
                  {
                    kind = 4;
                  }
                  else
                  {
                    int kind;
                    if (raw == Short.class)
                    {
                      kind = 3;
                    }
                    else
                    {
                      int kind;
                      if (raw == Float.class)
                      {
                        kind = 7;
                      }
                      else
                      {
                        int kind;
                        if (raw == Double.class)
                        {
                          kind = 8;
                        }
                        else
                        {
                          int kind;
                          if (raw == URI.class)
                          {
                            kind = 13;
                          }
                          else
                          {
                            int kind;
                            if (raw == URL.class)
                            {
                              kind = 14;
                            }
                            else
                            {
                              int kind;
                              if (raw == Class.class)
                              {
                                kind = 15;
                              }
                              else
                              {
                                if (raw == Locale.class)
                                {
                                  FromStringDeserializer<?> deser = FromStringDeserializer.findDeserializer(Locale.class);
                                  return new StdKeyDeserializer(9, raw, deser);
                                }
                                if (raw == Currency.class)
                                {
                                  FromStringDeserializer<?> deser = FromStringDeserializer.findDeserializer(Currency.class);
                                  return new StdKeyDeserializer(16, raw, deser);
                                }
                                return null;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    int kind;
    return new StdKeyDeserializer(kind, raw);
  }
  
  public Object deserializeKey(String key, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (key == null) {
      return null;
    }
    try
    {
      Object result = _parse(key, ctxt);
      if (result != null) {
        return result;
      }
    }
    catch (Exception re)
    {
      throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation: " + re.getMessage());
    }
    if ((_keyClass.isEnum()) && (ctxt.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL))) {
      return null;
    }
    throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation");
  }
  
  public Class<?> getKeyClass()
  {
    return _keyClass;
  }
  
  protected Object _parse(String key, DeserializationContext ctxt)
    throws Exception
  {
    switch (_kind)
    {
    case 1: 
      if ("true".equals(key)) {
        return Boolean.TRUE;
      }
      if ("false".equals(key)) {
        return Boolean.FALSE;
      }
      throw ctxt.weirdKeyException(_keyClass, key, "value not 'true' or 'false'");
    case 2: 
      int value = _parseInt(key);
      if ((value < -128) || (value > 255)) {
        throw ctxt.weirdKeyException(_keyClass, key, "overflow, value can not be represented as 8-bit value");
      }
      return Byte.valueOf((byte)value);
    case 3: 
      int value = _parseInt(key);
      if ((value < 32768) || (value > 32767)) {
        throw ctxt.weirdKeyException(_keyClass, key, "overflow, value can not be represented as 16-bit value");
      }
      return Short.valueOf((short)value);
    case 4: 
      if (key.length() == 1) {
        return Character.valueOf(key.charAt(0));
      }
      throw ctxt.weirdKeyException(_keyClass, key, "can only convert 1-character Strings");
    case 5: 
      return Integer.valueOf(_parseInt(key));
    case 6: 
      return Long.valueOf(_parseLong(key));
    case 7: 
      return Float.valueOf((float)_parseDouble(key));
    case 8: 
      return Double.valueOf(_parseDouble(key));
    case 9: 
      try
      {
        return _deser._deserialize(key, ctxt);
      }
      catch (IOException e)
      {
        throw ctxt.weirdKeyException(_keyClass, key, "unable to parse key as locale");
      }
    case 16: 
      try
      {
        return _deser._deserialize(key, ctxt);
      }
      catch (IOException e)
      {
        throw ctxt.weirdKeyException(_keyClass, key, "unable to parse key as currency");
      }
    case 10: 
      return ctxt.parseDate(key);
    case 11: 
      Date date = ctxt.parseDate(key);
      return date == null ? null : ctxt.constructCalendar(date);
    case 12: 
      return UUID.fromString(key);
    case 13: 
      return URI.create(key);
    case 14: 
      return new URL(key);
    case 15: 
      try
      {
        return ctxt.findClass(key);
      }
      catch (Exception e)
      {
        throw ctxt.weirdKeyException(_keyClass, key, "unable to parse key as Class");
      }
    }
    return null;
  }
  
  protected int _parseInt(String key)
    throws IllegalArgumentException
  {
    return Integer.parseInt(key);
  }
  
  protected long _parseLong(String key)
    throws IllegalArgumentException
  {
    return Long.parseLong(key);
  }
  
  protected double _parseDouble(String key)
    throws IllegalArgumentException
  {
    return NumberInput.parseDouble(key);
  }
  
  @JacksonStdImpl
  static final class StringKD
    extends StdKeyDeserializer
  {
    private static final long serialVersionUID = 1L;
    private static final StringKD sString = new StringKD(String.class);
    private static final StringKD sObject = new StringKD(Object.class);
    
    private StringKD(Class<?> nominalType)
    {
      super(nominalType);
    }
    
    public static StringKD forType(Class<?> nominalType)
    {
      if (nominalType == String.class) {
        return sString;
      }
      if (nominalType == Object.class) {
        return sObject;
      }
      return new StringKD(nominalType);
    }
    
    public Object deserializeKey(String key, DeserializationContext ctxt)
      throws IOException, JsonProcessingException
    {
      return key;
    }
  }
  
  static final class DelegatingKD
    extends KeyDeserializer
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final Class<?> _keyClass;
    protected final JsonDeserializer<?> _delegate;
    
    protected DelegatingKD(Class<?> cls, JsonDeserializer<?> deser)
    {
      _keyClass = cls;
      _delegate = deser;
    }
    
    public final Object deserializeKey(String key, DeserializationContext ctxt)
      throws IOException, JsonProcessingException
    {
      if (key == null) {
        return null;
      }
      try
      {
        Object result = _delegate.deserialize(ctxt.getParser(), ctxt);
        if (result != null) {
          return result;
        }
      }
      catch (Exception re)
      {
        throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation: " + re.getMessage());
      }
      throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation");
    }
    
    public Class<?> getKeyClass()
    {
      return _keyClass;
    }
  }
  
  @JacksonStdImpl
  static final class EnumKD
    extends StdKeyDeserializer
  {
    private static final long serialVersionUID = 1L;
    protected final EnumResolver _resolver;
    protected final AnnotatedMethod _factory;
    
    protected EnumKD(EnumResolver er, AnnotatedMethod factory)
    {
      super(er.getEnumClass());
      _resolver = er;
      _factory = factory;
    }
    
    public Object _parse(String key, DeserializationContext ctxt)
      throws JsonMappingException
    {
      if (_factory != null) {
        try
        {
          return _factory.call1(key);
        }
        catch (Exception e)
        {
          ClassUtil.unwrapAndThrowAsIAE(e);
        }
      }
      Enum<?> e = _resolver.findEnum(key);
      if ((e == null) && (!ctxt.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL))) {
        throw ctxt.weirdKeyException(_keyClass, key, "not one of values for Enum class");
      }
      return e;
    }
  }
  
  static final class StringCtorKeyDeserializer
    extends StdKeyDeserializer
  {
    private static final long serialVersionUID = 1L;
    protected final Constructor<?> _ctor;
    
    public StringCtorKeyDeserializer(Constructor<?> ctor)
    {
      super(ctor.getDeclaringClass());
      _ctor = ctor;
    }
    
    public Object _parse(String key, DeserializationContext ctxt)
      throws Exception
    {
      return _ctor.newInstance(new Object[] { key });
    }
  }
  
  static final class StringFactoryKeyDeserializer
    extends StdKeyDeserializer
  {
    private static final long serialVersionUID = 1L;
    final Method _factoryMethod;
    
    public StringFactoryKeyDeserializer(Method fm)
    {
      super(fm.getDeclaringClass());
      _factoryMethod = fm;
    }
    
    public Object _parse(String key, DeserializationContext ctxt)
      throws Exception
    {
      return _factoryMethod.invoke(null, new Object[] { key });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */