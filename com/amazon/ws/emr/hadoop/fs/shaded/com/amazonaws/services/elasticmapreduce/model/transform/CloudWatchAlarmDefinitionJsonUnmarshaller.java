package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CloudWatchAlarmDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CloudWatchAlarmDefinitionJsonUnmarshaller
  implements Unmarshaller<CloudWatchAlarmDefinition, JsonUnmarshallerContext>
{
  private static CloudWatchAlarmDefinitionJsonUnmarshaller instance;
  
  public CloudWatchAlarmDefinition unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CloudWatchAlarmDefinition cloudWatchAlarmDefinition = new CloudWatchAlarmDefinition();
    
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
        if (context.testExpression("ComparisonOperator", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setComparisonOperator((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EvaluationPeriods", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setEvaluationPeriods((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("MetricName", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setMetricName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Namespace", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setNamespace((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Period", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setPeriod((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("Statistic", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setStatistic((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Threshold", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setThreshold((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("Unit", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setUnit((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Dimensions", targetDepth))
        {
          context.nextToken();
          cloudWatchAlarmDefinition.setDimensions(new ListUnmarshaller(MetricDimensionJsonUnmarshaller.getInstance())
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
    return cloudWatchAlarmDefinition;
  }
  
  public static CloudWatchAlarmDefinitionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CloudWatchAlarmDefinitionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CloudWatchAlarmDefinitionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */