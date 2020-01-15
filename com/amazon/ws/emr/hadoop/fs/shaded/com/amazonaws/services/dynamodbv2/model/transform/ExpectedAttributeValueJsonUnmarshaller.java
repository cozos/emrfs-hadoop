package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ExpectedAttributeValueJsonUnmarshaller
  implements Unmarshaller<ExpectedAttributeValue, JsonUnmarshallerContext>
{
  private static ExpectedAttributeValueJsonUnmarshaller instance;
  
  public ExpectedAttributeValue unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue();
    
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
        if (context.testExpression("Value", targetDepth))
        {
          context.nextToken();
          expectedAttributeValue.setValue(AttributeValueJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Exists", targetDepth))
        {
          context.nextToken();
          expectedAttributeValue.setExists((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("ComparisonOperator", targetDepth))
        {
          context.nextToken();
          expectedAttributeValue.setComparisonOperator((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AttributeValueList", targetDepth))
        {
          context.nextToken();
          expectedAttributeValue.setAttributeValueList(new ListUnmarshaller(AttributeValueJsonUnmarshaller.getInstance())
            .unmarshall(context));
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
    return expectedAttributeValue;
  }
  
  public static ExpectedAttributeValueJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ExpectedAttributeValueJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ExpectedAttributeValueJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */