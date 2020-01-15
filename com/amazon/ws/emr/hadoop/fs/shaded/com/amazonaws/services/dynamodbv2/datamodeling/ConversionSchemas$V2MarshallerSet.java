package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CollectionToListMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.MapToMapMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectToMapMarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ConversionSchemas$V2MarshallerSet
{
  private static List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers()
  {
    List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
    
    ConversionSchemas.access$800(list);
    ConversionSchemas.access$900(list);
    ConversionSchemas.access$1000(list);
    ConversionSchemas.access$1100(list);
    ConversionSchemas.access$1200(list);
    ConversionSchemas.access$1300(list);
    
    list.add(ConversionSchemas.Pair.of(List.class, CollectionToListMarshaller.instance()));
    list.add(ConversionSchemas.Pair.of(Map.class, MapToMapMarshaller.instance()));
    
    list.add(ConversionSchemas.Pair.of(Object.class, ObjectToMapMarshaller.instance()));
    
    return list;
  }
  
  private static List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers()
  {
    List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
    
    ConversionSchemas.access$1400(list);
    ConversionSchemas.access$1500(list);
    ConversionSchemas.access$1600(list);
    ConversionSchemas.access$1700(list);
    
    list.add(ConversionSchemas.Pair.of(Object.class, 
    
      CollectionToListMarshaller.instance()));
    
    return list;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.V2MarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */