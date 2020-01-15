package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectSetToStringSetMarshaller;
import java.util.ArrayList;
import java.util.List;

final class ConversionSchemas$V1MarshallerSet
{
  private static List<ConversionSchemas.Pair<ArgumentMarshaller>> marshallers()
  {
    List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
    
    ConversionSchemas.access$800(list);
    ConversionSchemas.access$1800(list);
    ConversionSchemas.access$1000(list);
    ConversionSchemas.access$1100(list);
    ConversionSchemas.access$1200(list);
    ConversionSchemas.access$1300(list);
    
    return list;
  }
  
  private static List<ConversionSchemas.Pair<ArgumentMarshaller>> setMarshallers()
  {
    List<ConversionSchemas.Pair<ArgumentMarshaller>> list = new ArrayList();
    
    ConversionSchemas.access$1400(list);
    ConversionSchemas.access$1900(list);
    ConversionSchemas.access$1500(list);
    ConversionSchemas.access$1600(list);
    ConversionSchemas.access$1700(list);
    
    list.add(ConversionSchemas.Pair.of(Object.class, 
      ObjectSetToStringSetMarshaller.instance()));
    
    return list;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.V1MarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */