package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;

public class PlatformInfo$Builder
{
  private String extraInstanceDataJsonFile;
  private String emrJobFlowJsonFile;
  private String configEndpoint;
  
  public Builder withExtraInstanceDataJsonFile(String extraInstanceDataJson)
  {
    extraInstanceDataJsonFile = extraInstanceDataJson;
    return this;
  }
  
  public Builder withEmrJobFlowJsonFile(String emrJobFlowJson)
  {
    emrJobFlowJsonFile = emrJobFlowJson;
    return this;
  }
  
  public Builder withConfigurationEndpoint(String configEndpoint)
  {
    this.configEndpoint = configEndpoint;
    return this;
  }
  
  public PlatformInfo build()
  {
    return new PlatformInfo(
      (String)Optional.fromNullable(extraInstanceDataJsonFile).or("/var/lib/instance-controller/extraInstanceData.json"), 
      (String)Optional.fromNullable(emrJobFlowJsonFile).or("/var/lib/info/job-flow.json"), 
      (String)Optional.fromNullable(configEndpoint).or("http://localhost:8321/configuration"), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.PlatformInfo.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */