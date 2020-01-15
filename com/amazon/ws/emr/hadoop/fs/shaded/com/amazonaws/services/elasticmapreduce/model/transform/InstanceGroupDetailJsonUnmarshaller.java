package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceGroupDetailJsonUnmarshaller
  implements Unmarshaller<InstanceGroupDetail, JsonUnmarshallerContext>
{
  private static InstanceGroupDetailJsonUnmarshaller instance;
  
  public InstanceGroupDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceGroupDetail instanceGroupDetail = new InstanceGroupDetail();
    
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
        if (context.testExpression("InstanceGroupId", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setInstanceGroupId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Market", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setMarket((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceRole", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setInstanceRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BidPrice", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setBidPrice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceType", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceRequestCount", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setInstanceRequestCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceRunningCount", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setInstanceRunningCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("State", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LastStateChangeReason", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setLastStateChangeReason((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("StartDateTime", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setStartDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("ReadyDateTime", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setReadyDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("EndDateTime", targetDepth))
        {
          context.nextToken();
          instanceGroupDetail.setEndDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return instanceGroupDetail;
  }
  
  public static InstanceGroupDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceGroupDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */