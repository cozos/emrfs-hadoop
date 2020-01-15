package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public final class NullNode
  extends ValueNode
{
  public static final NullNode instance = new NullNode();
  
  public static NullNode getInstance()
  {
    return instance;
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.NULL;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NULL;
  }
  
  public String asText(String defaultValue)
  {
    return defaultValue;
  }
  
  public String asText()
  {
    return "null";
  }
  
  public final void serialize(JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    provider.defaultSerializeNull(g);
  }
  
  public boolean equals(Object o)
  {
    return o == this;
  }
  
  public int hashCode()
  {
    return JsonNodeType.NULL.ordinal();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NullNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */