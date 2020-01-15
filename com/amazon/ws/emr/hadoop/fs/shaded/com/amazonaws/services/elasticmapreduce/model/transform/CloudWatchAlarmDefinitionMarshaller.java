package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CloudWatchAlarmDefinition;
import java.util.List;

@SdkInternalApi
public class CloudWatchAlarmDefinitionMarshaller
{
  private static final MarshallingInfo<String> COMPARISONOPERATOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ComparisonOperator").build();
  private static final MarshallingInfo<Integer> EVALUATIONPERIODS_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EvaluationPeriods").build();
  private static final MarshallingInfo<String> METRICNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("MetricName").build();
  private static final MarshallingInfo<String> NAMESPACE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Namespace").build();
  private static final MarshallingInfo<Integer> PERIOD_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Period").build();
  private static final MarshallingInfo<String> STATISTIC_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Statistic").build();
  private static final MarshallingInfo<Double> THRESHOLD_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Threshold").build();
  private static final MarshallingInfo<String> UNIT_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Unit").build();
  private static final MarshallingInfo<List> DIMENSIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Dimensions").build();
  private static final CloudWatchAlarmDefinitionMarshaller instance = new CloudWatchAlarmDefinitionMarshaller();
  
  public static CloudWatchAlarmDefinitionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(CloudWatchAlarmDefinition cloudWatchAlarmDefinition, ProtocolMarshaller protocolMarshaller)
  {
    if (cloudWatchAlarmDefinition == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getComparisonOperator(), COMPARISONOPERATOR_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getEvaluationPeriods(), EVALUATIONPERIODS_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getMetricName(), METRICNAME_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getNamespace(), NAMESPACE_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getPeriod(), PERIOD_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getStatistic(), STATISTIC_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getThreshold(), THRESHOLD_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getUnit(), UNIT_BINDING);
      protocolMarshaller.marshall(cloudWatchAlarmDefinition.getDimensions(), DIMENSIONS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CloudWatchAlarmDefinitionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */