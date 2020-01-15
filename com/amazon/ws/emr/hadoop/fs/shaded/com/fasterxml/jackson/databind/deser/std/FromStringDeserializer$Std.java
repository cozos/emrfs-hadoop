package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class FromStringDeserializer$Std
  extends FromStringDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  public static final int STD_FILE = 1;
  public static final int STD_URL = 2;
  public static final int STD_URI = 3;
  public static final int STD_CLASS = 4;
  public static final int STD_JAVA_TYPE = 5;
  public static final int STD_CURRENCY = 6;
  public static final int STD_PATTERN = 7;
  public static final int STD_LOCALE = 8;
  public static final int STD_CHARSET = 9;
  public static final int STD_TIME_ZONE = 10;
  public static final int STD_INET_ADDRESS = 11;
  public static final int STD_INET_SOCKET_ADDRESS = 12;
  protected final int _kind;
  
  protected FromStringDeserializer$Std(Class<?> valueType, int kind)
  {
    super(valueType);
    _kind = kind;
  }
  
  protected Object _deserialize(String value, DeserializationContext ctxt)
    throws IOException
  {
    switch (_kind)
    {
    case 1: 
      return new File(value);
    case 2: 
      return new URL(value);
    case 3: 
      return URI.create(value);
    case 4: 
      try
      {
        return ctxt.findClass(value);
      }
      catch (Exception e)
      {
        throw ctxt.instantiationException(_valueClass, ClassUtil.getRootCause(e));
      }
    case 5: 
      return ctxt.getTypeFactory().constructFromCanonical(value);
    case 6: 
      return Currency.getInstance(value);
    case 7: 
      return Pattern.compile(value);
    case 8: 
      int ix = value.indexOf('_');
      if (ix < 0) {
        return new Locale(value);
      }
      String first = value.substring(0, ix);
      value = value.substring(ix + 1);
      ix = value.indexOf('_');
      if (ix < 0) {
        return new Locale(first, value);
      }
      String second = value.substring(0, ix);
      return new Locale(first, second, value.substring(ix + 1));
    case 9: 
      return Charset.forName(value);
    case 10: 
      return TimeZone.getTimeZone(value);
    case 11: 
      return InetAddress.getByName(value);
    case 12: 
      if (value.startsWith("["))
      {
        int i = value.lastIndexOf(']');
        if (i == -1) {
          throw new InvalidFormatException("Bracketed IPv6 address must contain closing bracket", value, InetSocketAddress.class);
        }
        int j = value.indexOf(':', i);
        int port = j > -1 ? Integer.parseInt(value.substring(j + 1)) : 0;
        return new InetSocketAddress(value.substring(0, i + 1), port);
      }
      int ix = value.indexOf(':');
      if ((ix >= 0) && (value.indexOf(':', ix + 1) < 0))
      {
        int port = Integer.parseInt(value.substring(ix + 1));
        return new InetSocketAddress(value.substring(0, ix), port);
      }
      return new InetSocketAddress(value, 0);
    }
    throw new IllegalArgumentException();
  }
  
  protected Object _deserializeFromEmptyString()
    throws IOException
  {
    if (_kind == 3) {
      return URI.create("");
    }
    if (_kind == 8) {
      return Locale.ROOT;
    }
    return super._deserializeFromEmptyString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */