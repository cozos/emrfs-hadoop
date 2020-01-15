package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class StorageClassAnalysisDataExport
  implements Serializable
{
  private String outputSchemaVersion;
  private AnalyticsExportDestination destination;
  
  public void setOutputSchemaVersion(StorageClassAnalysisSchemaVersion outputSchemaVersion)
  {
    if (outputSchemaVersion == null) {
      setOutputSchemaVersion((String)null);
    } else {
      setOutputSchemaVersion(outputSchemaVersion.toString());
    }
  }
  
  public StorageClassAnalysisDataExport withOutputSchemaVersion(StorageClassAnalysisSchemaVersion outputSchemaVersion)
  {
    setOutputSchemaVersion(outputSchemaVersion);
    return this;
  }
  
  public String getOutputSchemaVersion()
  {
    return outputSchemaVersion;
  }
  
  public void setOutputSchemaVersion(String outputSchemaVersion)
  {
    this.outputSchemaVersion = outputSchemaVersion;
  }
  
  public StorageClassAnalysisDataExport withOutputSchemaVersion(String outputSchemaVersion)
  {
    setOutputSchemaVersion(outputSchemaVersion);
    return this;
  }
  
  public AnalyticsExportDestination getDestination()
  {
    return destination;
  }
  
  public void setDestination(AnalyticsExportDestination destination)
  {
    this.destination = destination;
  }
  
  public StorageClassAnalysisDataExport withDestination(AnalyticsExportDestination destination)
  {
    setDestination(destination);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */