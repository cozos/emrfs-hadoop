package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeCustomKeyStoresResultJsonUnmarshaller
  implements Unmarshaller<DescribeCustomKeyStoresResult, JsonUnmarshallerContext>
{
  private static DescribeCustomKeyStoresResultJsonUnmarshaller instance;
  
  public DescribeCustomKeyStoresResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeCustomKeyStoresResult describeCustomKeyStoresResult = new DescribeCustomKeyStoresResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeCustomKeyStoresResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CustomKeyStores", targetDepth))
        {
          context.nextToken();
          describeCustomKeyStoresResult.setCustomKeyStores(new ListUnmarshaller(
            CustomKeyStoresListEntryJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("NextMarker", targetDepth))
        {
          context.nextToken();
          describeCustomKeyStoresResult.setNextMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Truncated", targetDepth))
        {
          context.nextToken();
          describeCustomKeyStoresResult.setTruncated((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return describeCustomKeyStoresResult;
  }
  
  public static DescribeCustomKeyStoresResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeCustomKeyStoresResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */