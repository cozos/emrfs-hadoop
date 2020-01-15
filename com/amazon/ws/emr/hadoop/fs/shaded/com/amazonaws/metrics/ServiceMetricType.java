package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public abstract interface ServiceMetricType
  extends MetricType
{
  public static final String UPLOAD_THROUGHPUT_NAME_SUFFIX = "UploadThroughput";
  public static final String UPLOAD_BYTE_COUNT_NAME_SUFFIX = "UploadByteCount";
  public static final String DOWNLOAD_THROUGHPUT_NAME_SUFFIX = "DownloadThroughput";
  public static final String DOWNLOAD_BYTE_COUNT_NAME_SUFFIX = "DownloadByteCount";
  
  public abstract String getServiceName();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */