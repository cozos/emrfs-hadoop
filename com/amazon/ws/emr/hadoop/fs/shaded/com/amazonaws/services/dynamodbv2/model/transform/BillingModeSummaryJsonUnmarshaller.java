package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BillingModeSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BillingModeSummaryJsonUnmarshaller
  implements Unmarshaller<BillingModeSummary, JsonUnmarshallerContext>
{
  private static BillingModeSummaryJsonUnmarshaller instance;
  
  public BillingModeSummary unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BillingModeSummary billingModeSummary = new BillingModeSummary();
    
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
        if (context.testExpression("BillingMode", targetDepth))
        {
          context.nextToken();
          billingModeSummary.setBillingMode((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LastUpdateToPayPerRequestDateTime", targetDepth))
        {
          context.nextToken();
          billingModeSummary.setLastUpdateToPayPerRequestDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return billingModeSummary;
  }
  
  public static BillingModeSummaryJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BillingModeSummaryJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BillingModeSummaryJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */