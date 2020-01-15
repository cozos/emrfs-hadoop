package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public enum StorageClassAnalysisSchemaVersion
  implements Serializable
{
  V_1("V_1");
  
  private final String version;
  
  private StorageClassAnalysisSchemaVersion(String version)
  {
    this.version = version;
  }
  
  public String toString()
  {
    return version;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysisSchemaVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */