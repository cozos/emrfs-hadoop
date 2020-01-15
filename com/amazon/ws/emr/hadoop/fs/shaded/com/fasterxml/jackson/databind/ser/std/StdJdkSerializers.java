package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class StdJdkSerializers
{
  public static Collection<Map.Entry<Class<?>, Object>> all()
  {
    HashMap<Class<?>, Object> sers = new HashMap();
    
    ToStringSerializer sls = ToStringSerializer.instance;
    
    sers.put(URL.class, sls);
    sers.put(URI.class, sls);
    
    sers.put(Currency.class, sls);
    sers.put(UUID.class, new UUIDSerializer());
    sers.put(Pattern.class, sls);
    sers.put(Locale.class, sls);
    
    sers.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
    sers.put(AtomicInteger.class, AtomicIntegerSerializer.class);
    sers.put(AtomicLong.class, AtomicLongSerializer.class);
    
    sers.put(File.class, FileSerializer.class);
    sers.put(Class.class, ClassSerializer.class);
    
    sers.put(Void.class, NullSerializer.instance);
    sers.put(Void.TYPE, NullSerializer.instance);
    try
    {
      sers.put(Timestamp.class, DateSerializer.instance);
      
      sers.put(Date.class, SqlDateSerializer.class);
      sers.put(Time.class, SqlTimeSerializer.class);
    }
    catch (NoClassDefFoundError e) {}
    return sers.entrySet();
  }
  
  public static class AtomicBooleanSerializer
    extends StdScalarSerializer<AtomicBoolean>
  {
    public AtomicBooleanSerializer()
    {
      super(false);
    }
    
    public void serialize(AtomicBoolean value, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      gen.writeBoolean(value.get());
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("boolean", true);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      visitor.expectBooleanFormat(typeHint);
    }
  }
  
  public static class AtomicIntegerSerializer
    extends StdScalarSerializer<AtomicInteger>
  {
    public AtomicIntegerSerializer()
    {
      super(false);
    }
    
    public void serialize(AtomicInteger value, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      gen.writeNumber(value.get());
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("integer", true);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
      if (v2 != null) {
        v2.numberType(JsonParser.NumberType.INT);
      }
    }
  }
  
  public static class AtomicLongSerializer
    extends StdScalarSerializer<AtomicLong>
  {
    public AtomicLongSerializer()
    {
      super(false);
    }
    
    public void serialize(AtomicLong value, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonGenerationException
    {
      gen.writeNumber(value.get());
    }
    
    public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    {
      return createSchemaNode("integer", true);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
      throws JsonMappingException
    {
      JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
      if (v2 != null) {
        v2.numberType(JsonParser.NumberType.LONG);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdJdkSerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */