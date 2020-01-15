package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RawValue;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ContainerNode<T extends ContainerNode<T>>
  extends BaseJsonNode
  implements JsonNodeCreator
{
  protected final JsonNodeFactory _nodeFactory;
  
  protected ContainerNode(JsonNodeFactory nc)
  {
    _nodeFactory = nc;
  }
  
  public abstract JsonToken asToken();
  
  public String asText()
  {
    return "";
  }
  
  public abstract int size();
  
  public abstract JsonNode get(int paramInt);
  
  public abstract JsonNode get(String paramString);
  
  public final ArrayNode arrayNode()
  {
    return _nodeFactory.arrayNode();
  }
  
  public final ObjectNode objectNode()
  {
    return _nodeFactory.objectNode();
  }
  
  public final NullNode nullNode()
  {
    return _nodeFactory.nullNode();
  }
  
  public final BooleanNode booleanNode(boolean v)
  {
    return _nodeFactory.booleanNode(v);
  }
  
  public final NumericNode numberNode(byte v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(short v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(int v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(long v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(BigInteger v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(float v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(double v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final NumericNode numberNode(BigDecimal v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Byte v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Short v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Integer v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Long v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Float v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final ValueNode numberNode(Double v)
  {
    return _nodeFactory.numberNode(v);
  }
  
  public final TextNode textNode(String text)
  {
    return _nodeFactory.textNode(text);
  }
  
  public final BinaryNode binaryNode(byte[] data)
  {
    return _nodeFactory.binaryNode(data);
  }
  
  public final BinaryNode binaryNode(byte[] data, int offset, int length)
  {
    return _nodeFactory.binaryNode(data, offset, length);
  }
  
  public final ValueNode pojoNode(Object pojo)
  {
    return _nodeFactory.pojoNode(pojo);
  }
  
  public final ValueNode rawValueNode(RawValue value)
  {
    return _nodeFactory.rawValueNode(value);
  }
  
  public abstract T removeAll();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ContainerNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */