package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class StorageClassAnalysis
  implements Serializable
{
  private StorageClassAnalysisDataExport dataExport;
  
  public StorageClassAnalysisDataExport getDataExport()
  {
    return dataExport;
  }
  
  public void setDataExport(StorageClassAnalysisDataExport dataExport)
  {
    this.dataExport = dataExport;
  }
  
  public StorageClassAnalysis withDataExport(StorageClassAnalysisDataExport dataExport)
  {
    setDataExport(dataExport);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */