package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ArrayNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

abstract class BaseNodeDeserializer<T extends JsonNode>
  extends StdDeserializer<T>
{
  public BaseNodeDeserializer(Class<T> vc)
  {
    super(vc);
  }
  
  public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromAny(p, ctxt);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  protected void _reportProblem(JsonParser p, String msg)
    throws JsonMappingException
  {
    throw new JsonMappingException(msg, p.getTokenLocation());
  }
  
  protected void _handleDuplicateField(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory, String fieldName, ObjectNode objectNode, JsonNode oldValue, JsonNode newValue)
    throws JsonProcessingException
  {
    if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
      _reportProblem(p, "Duplicate field '" + fieldName + "' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled");
    }
  }
  
  protected final ObjectNode deserializeObject(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    ObjectNode node = nodeFactory.objectNode();
    String key;
    if (p.isExpectedStartObjectToken())
    {
      key = p.nextFieldName();
    }
    else
    {
      JsonToken t = p.getCurrentToken();
      if (t == JsonToken.END_OBJECT) {
        return node;
      }
      if (t != JsonToken.FIELD_NAME) {
        throw ctxt.mappingException(handledType(), p.getCurrentToken());
      }
    }
    for (String key = p.getCurrentName(); key != null; key = p.nextFieldName())
    {
      JsonToken t = p.nextToken();
      JsonNode value;
      switch (t.id())
      {
      case 1: 
        value = deserializeObject(p, ctxt, nodeFactory);
        break;
      case 3: 
        value = deserializeArray(p, ctxt, nodeFactory);
        break;
      case 12: 
        value = _fromEmbedded(p, ctxt, nodeFactory);
        break;
      case 6: 
        value = nodeFactory.textNode(p.getText());
        break;
      case 7: 
        value = _fromInt(p, ctxt, nodeFactory);
        break;
      case 9: 
        value = nodeFactory.booleanNode(true);
        break;
      case 10: 
        value = nodeFactory.booleanNode(false);
        break;
      case 11: 
        value = nodeFactory.nullNode();
        break;
      case 2: 
      case 4: 
      case 5: 
      case 8: 
      default: 
        value = deserializeAny(p, ctxt, nodeFactory);
      }
      JsonNode old = node.replace(key, value);
      if (old != null) {
        _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
      }
    }
    return node;
  }
  
  protected final ArrayNode deserializeArray(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    ArrayNode node = nodeFactory.arrayNode();
    for (;;)
    {
      JsonToken t = p.nextToken();
      if (t == null) {
        throw ctxt.mappingException("Unexpected end-of-input when binding data into ArrayNode");
      }
      switch (t.id())
      {
      case 1: 
        node.add(deserializeObject(p, ctxt, nodeFactory));
        break;
      case 3: 
        node.add(deserializeArray(p, ctxt, nodeFactory));
        break;
      case 4: 
        return node;
      case 12: 
        node.add(_fromEmbedded(p, ctxt, nodeFactory));
        break;
      case 6: 
        node.add(nodeFactory.textNode(p.getText()));
        break;
      case 7: 
        node.add(_fromInt(p, ctxt, nodeFactory));
        break;
      case 9: 
        node.add(nodeFactory.booleanNode(true));
        break;
      case 10: 
        node.add(nodeFactory.booleanNode(false));
        break;
      case 11: 
        node.add(nodeFactory.nullNode());
        break;
      case 2: 
      case 5: 
      case 8: 
      default: 
        node.add(deserializeAny(p, ctxt, nodeFactory));
      }
    }
  }
  
  protected final JsonNode deserializeAny(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 1: 
    case 2: 
      return deserializeObject(p, ctxt, nodeFactory);
    case 3: 
      return deserializeArray(p, ctxt, nodeFactory);
    case 5: 
      return deserializeObject(p, ctxt, nodeFactory);
    case 12: 
      return _fromEmbedded(p, ctxt, nodeFactory);
    case 6: 
      return nodeFactory.textNode(p.getText());
    case 7: 
      return _fromInt(p, ctxt, nodeFactory);
    case 8: 
      return _fromFloat(p, ctxt, nodeFactory);
    case 9: 
      return nodeFactory.booleanNode(true);
    case 10: 
      return nodeFactory.booleanNode(false);
    case 11: 
      return nodeFactory.nullNode();
    }
    throw ctxt.mappingException(handledType());
  }
  
  protected final JsonNode _fromInt(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    int feats = ctxt.getDeserializationFeatures();
    JsonParser.NumberType nt;
    JsonParser.NumberType nt;
    if ((feats & F_MASK_INT_COERCIONS) != 0)
    {
      JsonParser.NumberType nt;
      if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats))
      {
        nt = JsonParser.NumberType.BIG_INTEGER;
      }
      else
      {
        JsonParser.NumberType nt;
        if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
          nt = JsonParser.NumberType.LONG;
        } else {
          nt = p.getNumberType();
        }
      }
    }
    else
    {
      nt = p.getNumberType();
    }
    if (nt == JsonParser.NumberType.INT) {
      return nodeFactory.numberNode(p.getIntValue());
    }
    if (nt == JsonParser.NumberType.LONG) {
      return nodeFactory.numberNode(p.getLongValue());
    }
    return nodeFactory.numberNode(p.getBigIntegerValue());
  }
  
  protected final JsonNode _fromFloat(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    JsonParser.NumberType nt = p.getNumberType();
    if ((nt == JsonParser.NumberType.BIG_DECIMAL) || (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS))) {
      return nodeFactory.numberNode(p.getDecimalValue());
    }
    return nodeFactory.numberNode(p.getDoubleValue());
  }
  
  protected final JsonNode _fromEmbedded(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory)
    throws IOException
  {
    Object ob = p.getEmbeddedObject();
    if (ob == null) {
      return nodeFactory.nullNode();
    }
    Class<?> type = ob.getClass();
    if (type == byte[].class) {
      return nodeFactory.binaryNode((byte[])ob);
    }
    if ((ob instanceof RawValue)) {
      return nodeFactory.rawValueNode((RawValue)ob);
    }
    if ((ob instanceof JsonNode)) {
      return (JsonNode)ob;
    }
    return nodeFactory.pojoNode(ob);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */