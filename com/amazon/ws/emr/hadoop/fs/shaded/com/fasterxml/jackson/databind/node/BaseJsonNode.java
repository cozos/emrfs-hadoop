package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public abstract class BaseJsonNode
  extends JsonNode
  implements JsonSerializable
{
  public final JsonNode findPath(String fieldName)
  {
    JsonNode value = findValue(fieldName);
    if (value == null) {
      return MissingNode.getInstance();
    }
    return value;
  }
  
  public abstract int hashCode();
  
  public JsonParser traverse()
  {
    return new TreeTraversingParser(this);
  }
  
  public JsonParser traverse(ObjectCodec codec)
  {
    return new TreeTraversingParser(this, codec);
  }
  
  public abstract JsonToken asToken();
  
  public JsonParser.NumberType numberType()
  {
    return null;
  }
  
  public abstract void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException;
  
  public abstract void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.BaseJsonNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */