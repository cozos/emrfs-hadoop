package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.nio.charset.Charset;
import java.util.Date;

@SdkInternalApi
public class ValueToStringConverters
{
  public static final ValueToString<String> FROM_STRING = new ValueToString()
  {
    public String convert(String val)
    {
      return val;
    }
  };
  public static final ValueToString<Integer> FROM_INTEGER = new ValueToString()
  {
    public String convert(Integer val)
    {
      return StringUtils.fromInteger(val);
    }
  };
  public static final ValueToString<Long> FROM_LONG = new ValueToString()
  {
    public String convert(Long val)
    {
      return StringUtils.fromLong(val);
    }
  };
  public static final ValueToString<Short> FROM_SHORT = new ValueToString()
  {
    public String convert(Short val)
    {
      return StringUtils.fromShort(val);
    }
  };
  public static final ValueToString<Float> FROM_FLOAT = new ValueToString()
  {
    public String convert(Float val)
    {
      return StringUtils.fromFloat(val);
    }
  };
  public static final ValueToString<Double> FROM_DOUBLE = new ValueToString()
  {
    public String convert(Double val)
    {
      return StringUtils.fromDouble(val);
    }
  };
  public static final ValueToString<Boolean> FROM_BOOLEAN = new ValueToString()
  {
    public String convert(Boolean val)
    {
      return StringUtils.fromBoolean(val);
    }
  };
  public static final ValueToString<Date> FROM_DATE = new ValueToString()
  {
    public String convert(Date val)
    {
      return StringUtils.fromDate(val);
    }
  };
  public static final ValueToString<String> FROM_JSON_VALUE_HEADER = new ValueToString()
  {
    public String convert(String val)
    {
      return Base64.encodeAsString(val.getBytes(Charset.forName("utf-8")));
    }
  };
  
  public static abstract interface ValueToString<T>
  {
    public abstract String convert(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.ValueToStringConverters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */