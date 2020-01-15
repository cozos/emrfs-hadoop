package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MarshallerRegistry$Builder
{
  private final Map<MarshallLocation, Map<MarshallingType, JsonMarshaller<?>>> marshallers = new HashMap();
  private final Set<MarshallingType<?>> marshallingTypes = new HashSet();
  
  public <T> Builder payloadMarshaller(MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    return addMarshaller(MarshallLocation.PAYLOAD, marshallingType, marshaller);
  }
  
  public <T> Builder headerMarshaller(MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    return addMarshaller(MarshallLocation.HEADER, marshallingType, marshaller);
  }
  
  public <T> Builder queryParamMarshaller(MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    return addMarshaller(MarshallLocation.QUERY_PARAM, marshallingType, marshaller);
  }
  
  public <T> Builder pathParamMarshaller(MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    return addMarshaller(MarshallLocation.PATH, marshallingType, marshaller);
  }
  
  public <T> Builder greedyPathParamMarshaller(MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    return addMarshaller(MarshallLocation.GREEDY_PATH, marshallingType, marshaller);
  }
  
  public <T> Builder addMarshaller(MarshallLocation marshallLocation, MarshallingType<T> marshallingType, JsonMarshaller<T> marshaller)
  {
    marshallingTypes.add(marshallingType);
    if (!marshallers.containsKey(marshallLocation)) {
      marshallers.put(marshallLocation, new HashMap());
    }
    ((Map)marshallers.get(marshallLocation)).put(marshallingType, marshaller);
    return this;
  }
  
  public MarshallerRegistry build()
  {
    return new MarshallerRegistry(this, null);
  }
  
  private void copyMarshallersFromRegistry(Map<MarshallLocation, Map<MarshallingType, JsonMarshaller<?>>> sourceMarshallers)
  {
    for (Iterator localIterator1 = sourceMarshallers.entrySet().iterator(); localIterator1.hasNext();)
    {
      byLocationEntry = (Map.Entry)localIterator1.next();
      for (Map.Entry<MarshallingType, JsonMarshaller<?>> byTypeEntry : ((Map)byLocationEntry.getValue()).entrySet()) {
        addMarshaller((MarshallLocation)byLocationEntry.getKey(), (MarshallingType)byTypeEntry.getKey(), (JsonMarshaller)byTypeEntry.getValue());
      }
    }
    Map.Entry<MarshallLocation, Map<MarshallingType, JsonMarshaller<?>>> byLocationEntry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.MarshallerRegistry.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */