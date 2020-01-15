package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class LocalSecondaryIndexDescriptionJsonUnmarshaller
  implements Unmarshaller<LocalSecondaryIndexDescription, JsonUnmarshallerContext>
{
  private static LocalSecondaryIndexDescriptionJsonUnmarshaller instance;
  
  public LocalSecondaryIndexDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    LocalSecondaryIndexDescription localSecondaryIndexDescription = new LocalSecondaryIndexDescription();
    
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
          localSecondaryIndexDescription.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Projection", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexDescription.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("IndexSizeBytes", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexDescription.setIndexSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ItemCount", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexDescription.setItemCount((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("IndexArn", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexDescription.setIndexArn((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return localSecondaryIndexDescription;
  }
  
  public static LocalSecondaryIndexDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new LocalSecondaryIndexDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LocalSecondaryIndexDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */