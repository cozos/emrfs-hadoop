package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetMetricWidgetImageRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String metricWidget;
  private String outputFormat;
  
  public void setMetricWidget(String metricWidget)
  {
    this.metricWidget = metricWidget;
  }
  
  public String getMetricWidget()
  {
    return metricWidget;
  }
  
  public GetMetricWidgetImageRequest withMetricWidget(String metricWidget)
  {
    setMetricWidget(metricWidget);
    return this;
  }
  
  public void setOutputFormat(String outputFormat)
  {
    this.outputFormat = outputFormat;
  }
  
  public String getOutputFormat()
  {
    return outputFormat;
  }
  
  public GetMetricWidgetImageRequest withOutputFormat(String outputFormat)
  {
    setOutputFormat(outputFormat);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricWidget() != null) {
      sb.append("MetricWidget: ").append(getMetricWidget()).append(",");
    }
    if (getOutputFormat() != null) {
      sb.append("OutputFormat: ").append(getOutputFormat());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof GetMetricWidgetImageRequest)) {
      return false;
    }
    GetMetricWidgetImageRequest other = (GetMetricWidgetImageRequest)obj;
    if (((other.getMetricWidget() == null ? 1 : 0) ^ (getMetricWidget() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricWidget() != null) && (!other.getMetricWidget().equals(getMetricWidget()))) {
      return false;
    }
    if (((other.getOutputFormat() == null ? 1 : 0) ^ (getOutputFormat() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOutputFormat() != null) && (!other.getOutputFormat().equals(getOutputFormat()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetricWidget() == null ? 0 : getMetricWidget().hashCode());
    hashCode = 31 * hashCode + (getOutputFormat() == null ? 0 : getOutputFormat().hashCode());
    return hashCode;
  }
  
  public GetMetricWidgetImageRequest clone()
  {
    return (GetMetricWidgetImageRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */