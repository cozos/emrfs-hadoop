package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GetMetricWidgetImageResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ByteBuffer metricWidgetImage;
  
  public void setMetricWidgetImage(ByteBuffer metricWidgetImage)
  {
    this.metricWidgetImage = metricWidgetImage;
  }
  
  public ByteBuffer getMetricWidgetImage()
  {
    return metricWidgetImage;
  }
  
  public GetMetricWidgetImageResult withMetricWidgetImage(ByteBuffer metricWidgetImage)
  {
    setMetricWidgetImage(metricWidgetImage);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricWidgetImage() != null) {
      sb.append("MetricWidgetImage: ").append(getMetricWidgetImage());
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
    if (!(obj instanceof GetMetricWidgetImageResult)) {
      return false;
    }
    GetMetricWidgetImageResult other = (GetMetricWidgetImageResult)obj;
    if (((other.getMetricWidgetImage() == null ? 1 : 0) ^ (getMetricWidgetImage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricWidgetImage() != null) && (!other.getMetricWidgetImage().equals(getMetricWidgetImage()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetricWidgetImage() == null ? 0 : getMetricWidgetImage().hashCode());
    return hashCode;
  }
  
  public GetMetricWidgetImageResult clone()
  {
    try
    {
      return (GetMetricWidgetImageResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */