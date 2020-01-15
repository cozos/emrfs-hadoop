package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TableDescriptionJsonUnmarshaller
  implements Unmarshaller<TableDescription, JsonUnmarshallerContext>
{
  private static TableDescriptionJsonUnmarshaller instance;
  
  public TableDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TableDescription tableDescription = new TableDescription();
    
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
        if (context.testExpression("AttributeDefinitions", targetDepth))
        {
          context.nextToken();
          tableDescription.setAttributeDefinitions(new ListUnmarshaller(AttributeDefinitionJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          tableDescription.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          tableDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("TableStatus", targetDepth))
        {
          context.nextToken();
          tableDescription.setTableStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          tableDescription.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("ProvisionedThroughput", targetDepth))
        {
          context.nextToken();
          tableDescription.setProvisionedThroughput(ProvisionedThroughputDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("TableSizeBytes", targetDepth))
        {
          context.nextToken();
          tableDescription.setTableSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ItemCount", targetDepth))
        {
          context.nextToken();
          tableDescription.setItemCount((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("TableArn", targetDepth))
        {
          context.nextToken();
          tableDescription.setTableArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableId", targetDepth))
        {
          context.nextToken();
          tableDescription.setTableId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BillingModeSummary", targetDepth))
        {
          context.nextToken();
          tableDescription.setBillingModeSummary(BillingModeSummaryJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("LocalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          tableDescription.setLocalSecondaryIndexes(new ListUnmarshaller(
            LocalSecondaryIndexDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("GlobalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          tableDescription.setGlobalSecondaryIndexes(new ListUnmarshaller(
            GlobalSecondaryIndexDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("StreamSpecification", targetDepth))
        {
          context.nextToken();
          tableDescription.setStreamSpecification(StreamSpecificationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("LatestStreamLabel", targetDepth))
        {
          context.nextToken();
          tableDescription.setLatestStreamLabel((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LatestStreamArn", targetDepth))
        {
          context.nextToken();
          tableDescription.setLatestStreamArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RestoreSummary", targetDepth))
        {
          context.nextToken();
          tableDescription.setRestoreSummary(RestoreSummaryJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("SSEDescription", targetDepth))
        {
          context.nextToken();
          tableDescription.setSSEDescription(SSEDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return tableDescription;
  }
  
  public static TableDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TableDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */