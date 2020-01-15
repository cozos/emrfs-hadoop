package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScanResultJsonUnmarshaller
  implements Unmarshaller<ScanResult, JsonUnmarshallerContext>
{
  private static ScanResultJsonUnmarshaller instance;
  
  public ScanResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScanResult scanResult = new ScanResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return scanResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Items", targetDepth))
        {
          context.nextToken();
          scanResult.setItems(new ListUnmarshaller(new MapUnmarshaller(context
            .getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())).unmarshall(context));
        }
        if (context.testExpression("Count", targetDepth))
        {
          context.nextToken();
          scanResult.setCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("ScannedCount", targetDepth))
        {
          context.nextToken();
          scanResult.setScannedCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("LastEvaluatedKey", targetDepth))
        {
          context.nextToken();
          scanResult.setLastEvaluatedKey(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          scanResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(context));
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
    return scanResult;
  }
  
  public static ScanResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScanResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */