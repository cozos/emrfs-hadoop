package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class MapDeserializer$MapReferringAccumulator
{
  private final Class<?> _valueType;
  private Map<Object, Object> _result;
  private List<MapDeserializer.MapReferring> _accumulator = new ArrayList();
  
  public MapDeserializer$MapReferringAccumulator(Class<?> valueType, Map<Object, Object> result)
  {
    _valueType = valueType;
    _result = result;
  }
  
  public void put(Object key, Object value)
  {
    if (_accumulator.isEmpty())
    {
      _result.put(key, value);
    }
    else
    {
      MapDeserializer.MapReferring ref = (MapDeserializer.MapReferring)_accumulator.get(_accumulator.size() - 1);
      next.put(key, value);
    }
  }
  
  public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference reference, Object key)
  {
    MapDeserializer.MapReferring id = new MapDeserializer.MapReferring(this, reference, _valueType, key);
    _accumulator.add(id);
    return id;
  }
  
  public void resolveForwardReference(Object id, Object value)
    throws IOException
  {
    Iterator<MapDeserializer.MapReferring> iterator = _accumulator.iterator();
    
    Map<Object, Object> previous = _result;
    while (iterator.hasNext())
    {
      MapDeserializer.MapReferring ref = (MapDeserializer.MapReferring)iterator.next();
      if (ref.hasId(id))
      {
        iterator.remove();
        previous.put(key, value);
        previous.putAll(next);
        return;
      }
      previous = next;
    }
    throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.MapDeserializer.MapReferringAccumulator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */