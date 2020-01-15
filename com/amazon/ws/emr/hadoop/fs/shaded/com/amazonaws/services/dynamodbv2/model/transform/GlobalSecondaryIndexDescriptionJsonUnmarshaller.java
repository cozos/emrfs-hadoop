package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GlobalSecondaryIndexDescriptionJsonUnmarshaller
  implements Unmarshaller<GlobalSecondaryIndexDescription, JsonUnmarshallerContext>
{
  private static GlobalSecondaryIndexDescriptionJsonUnmarshaller instance;
  
  public GlobalSecondaryIndexDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GlobalSecondaryIndexDescription globalSecondaryIndexDescription = new GlobalSecondaryIndexDescription();
    
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
        if (context.testExpression("IndexName", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Projection", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("IndexStatus", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setIndexStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Backfilling", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setBackfilling((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedThroughput", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription
            .setProvisionedThroughput(ProvisionedThroughputDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("IndexSizeBytes", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setIndexSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ItemCount", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setItemCount((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("IndexArn", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexDescription.setIndexArn((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return globalSecondaryIndexDescription;
  }
  
  public static GlobalSecondaryIndexDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GlobalSecondaryIndexDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalSecondaryIndexDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */