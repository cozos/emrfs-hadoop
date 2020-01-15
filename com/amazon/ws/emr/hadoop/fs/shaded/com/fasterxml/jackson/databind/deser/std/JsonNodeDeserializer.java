package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ArrayNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NullNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class JsonNodeDeserializer
  extends BaseNodeDeserializer<JsonNode>
{
  private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();
  
  protected JsonNodeDeserializer()
  {
    super(JsonNode.class);
  }
  
  public static JsonDeserializer<? extends JsonNode> getDeserializer(Class<?> nodeClass)
  {
    if (nodeClass == ObjectNode.class) {
      return ObjectDeserializer.getInstance();
    }
    if (nodeClass == ArrayNode.class) {
      return ArrayDeserializer.getInstance();
    }
    return instance;
  }
  
  public JsonNode getNullValue(DeserializationContext ctxt)
  {
    return NullNode.getInstance();
  }
  
  @Deprecated
  public JsonNode getNullValue()
  {
    return NullNode.getInstance();
  }
  
  public JsonNode deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 1: 
      return deserializeObject(p, ctxt, ctxt.getNodeFactory());
    case 3: 
      return deserializeArray(p, ctxt, ctxt.getNodeFactory());
    }
    return deserializeAny(p, ctxt, ctxt.getNodeFactory());
  }
  
  static final class ObjectDeserializer
    extends BaseNodeDeserializer<ObjectNode>
  {
    private static final long serialVersionUID = 1L;
    protected static final ObjectDeserializer _instance = new ObjectDeserializer();
    
    protected ObjectDeserializer()
    {
      super();
    }
    
    public static ObjectDeserializer getInstance()
    {
      return _instance;
    }
    
    public ObjectNode deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException
    {
      if ((p.isExpectedStartObjectToken()) || (p.hasToken(JsonToken.FIELD_NAME))) {
        return deserializeObject(p, ctxt, ctxt.getNodeFactory());
      }
      if (p.hasToken(JsonToken.END_OBJECT)) {
        return ctxt.getNodeFactory().objectNode();
      }
      throw ctxt.mappingException(ObjectNode.class);
    }
  }
  
  static final class ArrayDeserializer
    extends BaseNodeDeserializer<ArrayNode>
  {
    private static final long serialVersionUID = 1L;
    protected static final ArrayDeserializer _instance = new ArrayDeserializer();
    
    protected ArrayDeserializer()
    {
      super();
    }
    
    public static ArrayDeserializer getInstance()
    {
      return _instance;
    }
    
    public ArrayNode deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException
    {
      if (p.isExpectedStartArrayToken()) {
        return deserializeArray(p, ctxt, ctxt.getNodeFactory());
      }
      throw ctxt.mappingException(ArrayNode.class);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */