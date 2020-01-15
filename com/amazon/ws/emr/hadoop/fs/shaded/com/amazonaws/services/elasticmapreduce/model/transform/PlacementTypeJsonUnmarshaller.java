package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PlacementType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PlacementTypeJsonUnmarshaller
  implements Unmarshaller<PlacementType, JsonUnmarshallerContext>
{
  private static PlacementTypeJsonUnmarshaller instance;
  
  public PlacementType unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PlacementType placementType = new PlacementType();
    
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
        if (context.testExpression("AvailabilityZone", targetDepth))
        {
          context.nextToken();
          placementType.setAvailabilityZone((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AvailabilityZones", targetDepth))
        {
          context.nextToken();
          placementType.setAvailabilityZones(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
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
    return placementType;
  }
  
  public static PlacementTypeJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PlacementTypeJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PlacementTypeJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */