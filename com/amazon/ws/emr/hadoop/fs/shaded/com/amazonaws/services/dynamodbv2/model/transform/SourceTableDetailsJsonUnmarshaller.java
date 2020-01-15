package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SourceTableDetailsJsonUnmarshaller
  implements Unmarshaller<SourceTableDetails, JsonUnmarshallerContext>
{
  private static SourceTableDetailsJsonUnmarshaller instance;
  
  public SourceTableDetails unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SourceTableDetails sourceTableDetails = new SourceTableDetails();
    
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
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableId", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setTableId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableArn", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setTableArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableSizeBytes", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setTableSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("TableCreationDateTime", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setTableCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("ProvisionedThroughput", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ItemCount", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setItemCount((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("BillingMode", targetDepth))
        {
          context.nextToken();
          sourceTableDetails.setBillingMode((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return sourceTableDetails;
  }
  
  public static SourceTableDetailsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SourceTableDetailsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableDetailsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */