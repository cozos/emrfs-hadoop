package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SdkProtectedApi
public abstract interface MarshallingType<T>
{
  public static final MarshallingType<Void> NULL = new DefaultMarshallingType(Void.class);
  public static final MarshallingType<String> STRING = new DefaultMarshallingType(String.class);
  public static final MarshallingType<Integer> INTEGER = new DefaultMarshallingType(Integer.class);
  public static final MarshallingType<Long> LONG = new DefaultMarshallingType(Long.class);
  public static final MarshallingType<Short> SHORT = new DefaultMarshallingType(Short.class);
  public static final MarshallingType<Float> FLOAT = new DefaultMarshallingType(Float.class);
  public static final MarshallingType<Double> DOUBLE = new DefaultMarshallingType(Double.class);
  public static final MarshallingType<BigDecimal> BIG_DECIMAL = new DefaultMarshallingType(BigDecimal.class);
  public static final MarshallingType<Boolean> BOOLEAN = new DefaultMarshallingType(Boolean.class);
  public static final MarshallingType<Date> DATE = new DefaultMarshallingType(Date.class);
  public static final MarshallingType<ByteBuffer> BYTE_BUFFER = new DefaultMarshallingType(ByteBuffer.class);
  public static final MarshallingType<InputStream> STREAM = new DefaultMarshallingType(InputStream.class);
  public static final MarshallingType<StructuredPojo> STRUCTURED = new DefaultMarshallingType(StructuredPojo.class);
  public static final MarshallingType<List> LIST = new DefaultMarshallingType(List.class);
  public static final MarshallingType<Map> MAP = new DefaultMarshallingType(Map.class);
  public static final MarshallingType<String> JSON_VALUE = new MarshallingType()
  {
    public boolean isDefaultMarshallerForType(Class<?> type)
    {
      return false;
    }
  };
  
  public abstract boolean isDefaultMarshallerForType(Class<?> paramClass);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */