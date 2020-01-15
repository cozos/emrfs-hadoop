package com.amazon.ws.emr.hadoop.fs.notification;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.StandardUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudWatchNotifier
  implements Notifier
{
  private static final Logger LOG = LoggerFactory.getLogger(CloudWatchNotifier.class);
  private final AmazonCloudWatch cloudWatch;
  private final String jobFlowId;
  
  public CloudWatchNotifier(AmazonCloudWatch cloudWatch, String jobFlowId)
  {
    this.cloudWatch = cloudWatch;
    this.jobFlowId = jobFlowId;
  }
  
  private void sendOneDataPoint(String metricName, Notifier.Api api, double value)
  {
    MetricDatum datum = new MetricDatum();
    datum.setMetricName(metricName);
    Set<Dimension> dimensions = new HashSet();
    dimensions.add(new Dimension().withName("JobFlowId").withValue(jobFlowId));
    dimensions.add(new Dimension().withName("API").withValue(api.toString()));
    datum.setDimensions(dimensions);
    datum.setUnit(StandardUnit.Count);
    datum.setValue(Double.valueOf(value));
    
    PutMetricDataRequest request = new PutMetricDataRequest();
    request.setNamespace("EMRFS");
    request.setMetricData(Collections.singleton(datum));
    try
    {
      cloudWatch.putMetricData(request);
    }
    catch (Exception e)
    {
      LOG.warn("Failed to send {} notification", metricName, e);
    }
  }
  
  public void inconsistency(Notifier.Api api, Path arg1, Path arg2, List<Path> inconsistentPaths)
  {
    sendOneDataPoint("Inconsistency", api, 1.0D);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.CloudWatchNotifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */