package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

final class MapDeserializer$MapReferring
  extends ReadableObjectId.Referring
{
  private final MapDeserializer.MapReferringAccumulator _parent;
  public final Map<Object, Object> next = new LinkedHashMap();
  public final Object key;
  
  MapDeserializer$MapReferring(MapDeserializer.MapReferringAccumulator parent, UnresolvedForwardReference ref, Class<?> valueType, Object key)
  {
    super(ref, valueType);
    _parent = parent;
    this.key = key;
  }
  
  public void handleResolvedForwardReference(Object id, Object value)
    throws IOException
  {
    _parent.resolveForwardReference(id, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.MapDeserializer.MapReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */