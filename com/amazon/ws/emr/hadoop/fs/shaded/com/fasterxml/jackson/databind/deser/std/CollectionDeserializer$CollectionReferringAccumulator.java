package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class CollectionDeserializer$CollectionReferringAccumulator
{
  private final Class<?> _elementType;
  private final Collection<Object> _result;
  private List<CollectionDeserializer.CollectionReferring> _accumulator = new ArrayList();
  
  public CollectionDeserializer$CollectionReferringAccumulator(Class<?> elementType, Collection<Object> result)
  {
    _elementType = elementType;
    _result = result;
  }
  
  public void add(Object value)
  {
    if (_accumulator.isEmpty())
    {
      _result.add(value);
    }
    else
    {
      CollectionDeserializer.CollectionReferring ref = (CollectionDeserializer.CollectionReferring)_accumulator.get(_accumulator.size() - 1);
      next.add(value);
    }
  }
  
  public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference reference)
  {
    CollectionDeserializer.CollectionReferring id = new CollectionDeserializer.CollectionReferring(this, reference, _elementType);
    _accumulator.add(id);
    return id;
  }
  
  public void resolveForwardReference(Object id, Object value)
    throws IOException
  {
    Iterator<CollectionDeserializer.CollectionReferring> iterator = _accumulator.iterator();
    
    Collection<Object> previous = _result;
    while (iterator.hasNext())
    {
      CollectionDeserializer.CollectionReferring ref = (CollectionDeserializer.CollectionReferring)iterator.next();
      if (ref.hasId(id))
      {
        iterator.remove();
        previous.add(value);
        previous.addAll(next);
        return;
      }
      previous = next;
    }
    throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferringAccumulator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */