package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SdkInternalApi
public class MarshallerRegistry
{
  private final Map<MarshallLocation, Map<MarshallingType, JsonMarshaller<?>>> marshallers;
  private final Set<MarshallingType<?>> marshallingTypes;
  private final Map<Class<?>, MarshallingType<?>> marshallingTypeCache;
  
  private MarshallerRegistry(Builder builder)
  {
    marshallers = marshallers;
    marshallingTypes = marshallingTypes;
    marshallingTypeCache = new HashMap(marshallingTypes.size());
  }
  
  public <T> JsonMarshaller<T> getMarshaller(MarshallLocation marshallLocation, T val)
  {
    return getMarshaller(marshallLocation, toMarshallingType(val));
  }
  
  public <T> JsonMarshaller<T> getMarshaller(MarshallLocation marshallLocation, MarshallingType<T> marshallingType, T val)
  {
    return getMarshaller(marshallLocation, val == null ? MarshallingType.NULL : marshallingType);
  }
  
  private <T> JsonMarshaller<T> getMarshaller(MarshallLocation marshallLocation, MarshallingType<?> marshallingType)
  {
    return (JsonMarshaller)((Map)marshallers.get(marshallLocation)).get(marshallingType);
  }
  
  public <T> MarshallingType<T> toMarshallingType(T val)
  {
    if (val == null) {
      return MarshallingType.NULL;
    }
    if ((val instanceof StructuredPojo)) {
      return MarshallingType.STRUCTURED;
    }
    if (!marshallingTypeCache.containsKey(val.getClass())) {
      return populateMarshallingTypeCache(val.getClass());
    }
    return (MarshallingType)marshallingTypeCache.get(val.getClass());
  }
  
  private MarshallingType<?> populateMarshallingTypeCache(Class<?> clzz)
  {
    synchronized (marshallingTypeCache)
    {
      if (!marshallingTypeCache.containsKey(clzz))
      {
        for (MarshallingType<?> marshallingType : marshallingTypes) {
          if (marshallingType.isDefaultMarshallerForType(clzz))
          {
            marshallingTypeCache.put(clzz, marshallingType);
            return marshallingType;
          }
        }
        throw new SdkClientException("MarshallingType not found for class " + clzz);
      }
    }
    return (MarshallingType)marshallingTypeCache.get(clzz);
  }
  
  public MarshallerRegistry merge(Builder marshallerRegistryOverrides)
  {
    if (marshallerRegistryOverrides == null) {
      return this;
    }
    Builder merged = builder();
    merged.copyMarshallersFromRegistry(marshallers);
    merged.copyMarshallersFromRegistry(marshallers);
    return merged.build();
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.MarshallerRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */