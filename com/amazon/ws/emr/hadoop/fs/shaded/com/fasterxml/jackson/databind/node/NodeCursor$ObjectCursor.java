package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

public final class NodeCursor$ObjectCursor
  extends NodeCursor
{
  protected Iterator<Map.Entry<String, JsonNode>> _contents;
  protected Map.Entry<String, JsonNode> _current;
  protected boolean _needEntry;
  
  public NodeCursor$ObjectCursor(JsonNode n, NodeCursor p)
  {
    super(2, p);
    _contents = ((ObjectNode)n).fields();
    _needEntry = true;
  }
  
  public JsonToken nextToken()
  {
    if (_needEntry)
    {
      if (!_contents.hasNext())
      {
        _currentName = null;
        _current = null;
        return null;
      }
      _needEntry = false;
      _current = ((Map.Entry)_contents.next());
      _currentName = (_current == null ? null : (String)_current.getKey());
      return JsonToken.FIELD_NAME;
    }
    _needEntry = true;
    return ((JsonNode)_current.getValue()).asToken();
  }
  
  public JsonToken nextValue()
  {
    JsonToken t = nextToken();
    if (t == JsonToken.FIELD_NAME) {
      t = nextToken();
    }
    return t;
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_OBJECT;
  }
  
  public JsonNode currentNode()
  {
    return _current == null ? null : (JsonNode)_current.getValue();
  }
  
  public boolean currentHasChildren()
  {
    return ((ContainerNode)currentNode()).size() > 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NodeCursor.ObjectCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */