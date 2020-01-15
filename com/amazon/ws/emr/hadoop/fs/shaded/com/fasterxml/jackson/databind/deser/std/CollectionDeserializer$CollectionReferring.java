package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class CollectionDeserializer$CollectionReferring
  extends ReadableObjectId.Referring
{
  private final CollectionDeserializer.CollectionReferringAccumulator _parent;
  public final List<Object> next = new ArrayList();
  
  CollectionDeserializer$CollectionReferring(CollectionDeserializer.CollectionReferringAccumulator parent, UnresolvedForwardReference reference, Class<?> contentType)
  {
    super(reference, contentType);
    _parent = parent;
  }
  
  public void handleResolvedForwardReference(Object id, Object value)
    throws IOException
  {
    _parent.resolveForwardReference(id, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */