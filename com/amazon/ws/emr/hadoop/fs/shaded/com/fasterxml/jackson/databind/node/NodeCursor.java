package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class NodeCursor
  extends JsonStreamContext
{
  protected final NodeCursor _parent;
  protected String _currentName;
  protected Object _currentValue;
  
  public NodeCursor(int contextType, NodeCursor p)
  {
    _type = contextType;
    _index = -1;
    _parent = p;
  }
  
  public final NodeCursor getParent()
  {
    return _parent;
  }
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public void overrideCurrentName(String name)
  {
    _currentName = name;
  }
  
  public Object getCurrentValue()
  {
    return _currentValue;
  }
  
  public void setCurrentValue(Object v)
  {
    _currentValue = v;
  }
  
  public abstract JsonToken nextToken();
  
  public abstract JsonToken nextValue();
  
  public abstract JsonToken endToken();
  
  public abstract JsonNode currentNode();
  
  public abstract boolean currentHasChildren();
  
  public final NodeCursor iterateChildren()
  {
    JsonNode n = currentNode();
    if (n == null) {
      throw new IllegalStateException("No current node");
    }
    if (n.isArray()) {
      return new ArrayCursor(n, this);
    }
    if (n.isObject()) {
      return new ObjectCursor(n, this);
    }
    throw new IllegalStateException("Current node of type " + n.getClass().getName());
  }
  
  protected static final class RootCursor
    extends NodeCursor
  {
    protected JsonNode _node;
    protected boolean _done = false;
    
    public RootCursor(JsonNode n, NodeCursor p)
    {
      super(p);
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
  
  protected static final class ArrayCursor
    extends NodeCursor
  {
    protected Iterator<JsonNode> _contents;
    protected JsonNode _currentNode;
    
    public ArrayCursor(JsonNode n, NodeCursor p)
    {
      super(p);
      _contents = n.elements();
    }
    
    public JsonToken nextToken()
    {
      if (!_contents.hasNext())
      {
        _currentNode = null;
        return null;
      }
      _currentNode = ((JsonNode)_contents.next());
      return _currentNode.asToken();
    }
    
    public JsonToken nextValue()
    {
      return nextToken();
    }
    
    public JsonToken endToken()
    {
      return JsonToken.END_ARRAY;
    }
    
    public JsonNode currentNode()
    {
      return _currentNode;
    }
    
    public boolean currentHasChildren()
    {
      return ((ContainerNode)currentNode()).size() > 0;
    }
  }
  
  protected static final class ObjectCursor
    extends NodeCursor
  {
    protected Iterator<Map.Entry<String, JsonNode>> _contents;
    protected Map.Entry<String, JsonNode> _current;
    protected boolean _needEntry;
    
    public ObjectCursor(JsonNode n, NodeCursor p)
    {
      super(p);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NodeCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */