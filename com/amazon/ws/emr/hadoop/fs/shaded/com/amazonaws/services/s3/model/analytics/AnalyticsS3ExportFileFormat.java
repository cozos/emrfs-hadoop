package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public enum AnalyticsS3ExportFileFormat
  implements Serializable
{
  CSV("CSV");
  
  private final String format;
  
  private AnalyticsS3ExportFileFormat(String format)
  {
    this.format = format;
  }
  
  public String toString()
  {
    return format;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsS3ExportFileFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */