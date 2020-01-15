package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PlatformInfo
{
  private static final String EXTRA_INSTANCE_DATA_JSON_FILE = "/var/lib/instance-controller/extraInstanceData.json";
  private static final String EMR_JOB_FLOW_JSON_FILE = "/var/lib/info/job-flow.json";
  private static final String CONFIG_ENDPOINT = "http://localhost:8321/configuration";
  private static final String CLUSTER_ID_KEY = "clusterId";
  private static final String JOB_FLOW_ID_KEY = "jobFlowId";
  private final String extraInstanceDataJson;
  private final String emrJobFlowJson;
  private final String configEndpoint;
  private final Logger LOG = LoggerFactory.getLogger(PlatformInfo.class);
  
  private PlatformInfo(String extraInstanceDataJson, String emrJobFlowJson, String configEndpoint)
  {
    this.extraInstanceDataJson = extraInstanceDataJson;
    this.emrJobFlowJson = emrJobFlowJson;
    this.configEndpoint = configEndpoint;
  }
  
  public static PlatformInfo forDefaultResourceLocations()
  {
    return new PlatformInfo("/var/lib/instance-controller/extraInstanceData.json", "/var/lib/info/job-flow.json", "http://localhost:8321/configuration");
  }
  
  private String getClusterIdFromConfigurationEndpoint()
    throws IOException
  {
    return (String)((Map)new ObjectMapper().readValue(new URL(configEndpoint), Map.class)).get("clusterId");
  }
  
  private String getClusterIdFromEmrJobFlowJson()
    throws IOException
  {
    return (String)((Map)new ObjectMapper().readValue(new File(emrJobFlowJson), Map.class)).get("jobFlowId");
  }
  
  private String getClusterIdFromExtraInstanceDataJson()
    throws IOException
  {
    return (String)((Map)new ObjectMapper().readValue(new File(extraInstanceDataJson), Map.class)).get("jobFlowId");
  }
  
  public String getJobFlowId()
  {
    String clusterId = null;
    try
    {
      clusterId = getClusterIdFromConfigurationEndpoint();
    }
    catch (IOException e)
    {
      LOG.info("Unable to read clusterId from {}, trying extra instance data file: {}", configEndpoint, extraInstanceDataJson);
    }
    if (Strings.isNullOrEmpty(clusterId)) {
      try
      {
        clusterId = getClusterIdFromExtraInstanceDataJson();
      }
      catch (IOException e)
      {
        LOG.info("Unable to read clusterId from {}, trying EMR job-flow data file: {}", extraInstanceDataJson, emrJobFlowJson);
      }
    }
    if (Strings.isNullOrEmpty(clusterId)) {
      try
      {
        clusterId = getClusterIdFromEmrJobFlowJson();
      }
      catch (IOException e)
      {
        LOG.info("Unable to read clusterId from {}, out of places to look", emrJobFlowJson);
      }
    }
    return clusterId;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.PlatformInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */