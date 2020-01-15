package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.VolumeSpecification;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class VolumeSpecificationJsonUnmarshaller
  implements Unmarshaller<VolumeSpecification, JsonUnmarshallerContext>
{
  private static VolumeSpecificationJsonUnmarshaller instance;
  
  public VolumeSpecification unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    VolumeSpecification volumeSpecification = new VolumeSpecification();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("VolumeType", targetDepth))
        {
          context.nextToken();
          volumeSpecification.setVolumeType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Iops", targetDepth))
        {
          context.nextToken();
          volumeSpecification.setIops((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("SizeInGB", targetDepth))
        {
          context.nextToken();
          volumeSpecification.setSizeInGB((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
      }
      else
      {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return volumeSpecification;
  }
  
  public static VolumeSpecificationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new VolumeSpecificationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.VolumeSpecificationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */