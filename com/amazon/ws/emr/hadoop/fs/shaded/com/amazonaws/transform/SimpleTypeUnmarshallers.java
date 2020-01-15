package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import java.nio.ByteBuffer;
import java.util.Date;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers
{
  public static class StringUnmarshaller
    implements Unmarshaller<String, Node>
  {
    private static StringUnmarshaller instance;
    
    public String unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asString(".", in);
    }
    
    public static StringUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new StringUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class DoubleUnmarshaller
    implements Unmarshaller<Double, Node>
  {
    private static DoubleUnmarshaller instance;
    
    public Double unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asDouble(".", in);
    }
    
    public static DoubleUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new DoubleUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class IntegerUnmarshaller
    implements Unmarshaller<Integer, Node>
  {
    private static IntegerUnmarshaller instance;
    
    public Integer unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asInteger(".", in);
    }
    
    public static IntegerUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new IntegerUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class BooleanUnmarshaller
    implements Unmarshaller<Boolean, Node>
  {
    private static BooleanUnmarshaller instance;
    
    public Boolean unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asBoolean(".", in);
    }
    
    public static BooleanUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new BooleanUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class FloatUnmarshaller
    implements Unmarshaller<Float, Node>
  {
    private static FloatUnmarshaller instance;
    
    public Float unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asFloat(".", in);
    }
    
    public static FloatUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new FloatUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class LongUnmarshaller
    implements Unmarshaller<Long, Node>
  {
    private static LongUnmarshaller instance;
    
    public Long unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asLong(".", in);
    }
    
    public static LongUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new LongUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class ByteUnmarshaller
    implements Unmarshaller<Byte, Node>
  {
    private static ByteUnmarshaller instance;
    
    public Byte unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asByte(".", in);
    }
    
    public static ByteUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new ByteUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class DateUnmarshaller
    implements Unmarshaller<Date, Node>
  {
    private static DateUnmarshaller instance;
    
    public Date unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asDate(".", in);
    }
    
    public static DateUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new DateUnmarshaller();
      }
      return instance;
    }
  }
  
  public static class ByteBufferUnmarshaller
    implements Unmarshaller<ByteBuffer, Node>
  {
    private static ByteBufferUnmarshaller instance;
    
    public ByteBuffer unmarshall(Node in)
      throws Exception
    {
      return XpathUtils.asByteBuffer(".", in);
    }
    
    public static ByteBufferUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new ByteBufferUnmarshaller();
      }
      return instance;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */