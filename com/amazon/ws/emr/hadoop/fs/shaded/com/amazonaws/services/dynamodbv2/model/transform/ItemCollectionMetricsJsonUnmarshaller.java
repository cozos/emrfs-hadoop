package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemCollectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ItemCollectionMetricsJsonUnmarshaller
  implements Unmarshaller<ItemCollectionMetrics, JsonUnmarshallerContext>
{
  private static ItemCollectionMetricsJsonUnmarshaller instance;
  
  public ItemCollectionMetrics unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ItemCollectionMetrics itemCollectionMetrics = new ItemCollectionMetrics();
    
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
        if (context.testExpression("ItemCollectionKey", targetDepth))
        {
          context.nextToken();
          itemCollectionMetrics.setItemCollectionKey(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("SizeEstimateRangeGB", targetDepth))
        {
          context.nextToken();
          itemCollectionMetrics.setSizeEstimateRangeGB(new ListUnmarshaller(context.getUnmarshaller(Double.class)).unmarshall(context));
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
    return itemCollectionMetrics;
  }
  
  public static ItemCollectionMetricsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ItemCollectionMetricsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionMetricsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */