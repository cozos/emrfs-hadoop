package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeContinuousBackupsResultJsonUnmarshaller
  implements Unmarshaller<DescribeContinuousBackupsResult, JsonUnmarshallerContext>
{
  private static DescribeContinuousBackupsResultJsonUnmarshaller instance;
  
  public DescribeContinuousBackupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeContinuousBackupsResult describeContinuousBackupsResult = new DescribeContinuousBackupsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeContinuousBackupsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ContinuousBackupsDescription", targetDepth))
        {
          context.nextToken();
          describeContinuousBackupsResult.setContinuousBackupsDescription(ContinuousBackupsDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return describeContinuousBackupsResult;
  }
  
  public static DescribeContinuousBackupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeContinuousBackupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */