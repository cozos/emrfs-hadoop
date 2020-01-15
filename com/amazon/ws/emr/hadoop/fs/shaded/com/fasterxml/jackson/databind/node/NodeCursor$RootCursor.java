package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;

public final class NodeCursor$RootCursor
  extends NodeCursor
{
  protected JsonNode _node;
  protected boolean _done = false;
  
  public NodeCursor$RootCursor(JsonNode n, NodeCursor p)
  {
    super(0, p);
    _node = n;
  }
  
  public void overrideCurrentName(String name) {}
  
  public JsonToken nextToken()
  {
    if (!_done)
    {
      _done = true;
      return _node.asToken();
    }
    _node = null;
    return null;
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
  
  public JsonToken endToken()
  {
    return null;
  }
  
  public JsonNode currentNode()
  {
    return _node;
  }
  
  public boolean currentHasChildren()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NodeCursor.RootCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */