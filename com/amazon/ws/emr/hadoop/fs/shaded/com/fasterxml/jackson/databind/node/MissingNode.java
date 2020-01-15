package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class MissingNode
  extends ValueNode
{
  private static final MissingNode instance = new MissingNode();
  
  public <T extends JsonNode> T deepCopy()
  {
    return this;
  }
  
  public static MissingNode getInstance()
  {
    return instance;
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.MISSING;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.NOT_AVAILABLE;
  }
  
  public String asText()
  {
    return "";
  }
  
  public String asText(String defaultValue)
  {
    return defaultValue;
  }
  
  public final void serialize(JsonGenerator jg, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    jg.writeNull();
  }
  
  public void serializeWithType(JsonGenerator jg, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonProcessingException
  {
    jg.writeNull();
  }
  
  public boolean equals(Object o)
  {
    return o == this;
  }
  
  public String toString()
  {
    return "";
  }
  
  public int hashCode()
  {
    return JsonNodeType.MISSING.ordinal();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.MissingNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */