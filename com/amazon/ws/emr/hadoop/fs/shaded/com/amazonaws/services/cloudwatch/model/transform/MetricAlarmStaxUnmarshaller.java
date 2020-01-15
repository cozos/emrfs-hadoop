package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataQuery;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class MetricAlarmStaxUnmarshaller
  implements Unmarshaller<MetricAlarm, StaxUnmarshallerContext>
{
  private static MetricAlarmStaxUnmarshaller instance;
  
  public MetricAlarm unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MetricAlarm metricAlarm = new MetricAlarm();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return metricAlarm;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AlarmName", targetDepth)) {
          metricAlarm.setAlarmName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AlarmArn", targetDepth)) {
          metricAlarm.setAlarmArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AlarmDescription", targetDepth)) {
          metricAlarm.setAlarmDescription(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AlarmConfigurationUpdatedTimestamp", targetDepth)) {
          metricAlarm.setAlarmConfigurationUpdatedTimestamp(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("ActionsEnabled", targetDepth)) {
          metricAlarm.setActionsEnabled(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("OKActions", targetDepth)) {
          metricAlarm.withOKActions(new ArrayList());
        } else if (context.testExpression("OKActions/member", targetDepth)) {
          metricAlarm.withOKActions(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("AlarmActions", targetDepth)) {
          metricAlarm.withAlarmActions(new ArrayList());
        } else if (context.testExpression("AlarmActions/member", targetDepth)) {
          metricAlarm.withAlarmActions(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("InsufficientDataActions", targetDepth)) {
          metricAlarm.withInsufficientDataActions(new ArrayList());
        } else if (context.testExpression("InsufficientDataActions/member", targetDepth)) {
          metricAlarm.withInsufficientDataActions(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("StateValue", targetDepth)) {
          metricAlarm.setStateValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StateReason", targetDepth)) {
          metricAlarm.setStateReason(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StateReasonData", targetDepth)) {
          metricAlarm.setStateReasonData(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StateUpdatedTimestamp", targetDepth)) {
          metricAlarm.setStateUpdatedTimestamp(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("MetricName", targetDepth)) {
          metricAlarm.setMetricName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Namespace", targetDepth)) {
          metricAlarm.setNamespace(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Statistic", targetDepth)) {
          metricAlarm.setStatistic(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ExtendedStatistic", targetDepth)) {
          metricAlarm.setExtendedStatistic(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Dimensions", targetDepth)) {
          metricAlarm.withDimensions(new ArrayList());
        } else if (context.testExpression("Dimensions/member", targetDepth)) {
          metricAlarm.withDimensions(new Dimension[] { DimensionStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Period", targetDepth)) {
          metricAlarm.setPeriod(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Unit", targetDepth)) {
          metricAlarm.setUnit(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EvaluationPeriods", targetDepth)) {
          metricAlarm.setEvaluationPeriods(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("DatapointsToAlarm", targetDepth)) {
          metricAlarm.setDatapointsToAlarm(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Threshold", targetDepth)) {
          metricAlarm.setThreshold(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ComparisonOperator", targetDepth)) {
          metricAlarm.setComparisonOperator(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("TreatMissingData", targetDepth)) {
          metricAlarm.setTreatMissingData(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EvaluateLowSampleCountPercentile", targetDepth)) {
          metricAlarm.setEvaluateLowSampleCountPercentile(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Metrics", targetDepth)) {
          metricAlarm.withMetrics(new ArrayList());
        } else if (context.testExpression("Metrics/member", targetDepth)) {
          metricAlarm.withMetrics(new MetricDataQuery[] { MetricDataQueryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("ThresholdMetricId", targetDepth)) {
          metricAlarm.setThresholdMetricId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return metricAlarm;
      }
    }
  }
  
  public static MetricAlarmStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MetricAlarmStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MetricAlarmStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */