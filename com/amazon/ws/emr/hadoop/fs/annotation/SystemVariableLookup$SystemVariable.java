package com.amazon.ws.emr.hadoop.fs.annotation;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;

 enum SystemVariableLookup$SystemVariable
{
  EMR_CLUSTER_ID("emr:cluster_id", SystemVariableLookup.Source.JOB_FLOW_INFO),  MAPREDUCE_JOB_ID("mapreduce:job_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_JOB_NAME("mapreduce:job_name", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_JOB_APP_ATTEMPT_ID("mapreduce:job_app_attempt_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_TASK_ID("mapreduce:task_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_TASK_ATTEMPT_ID("mapreduce:task_attempt_id", SystemVariableLookup.Source.CONFIGURATION),  YARN_CONTAINER_ID("yarn:container_id", SystemVariableLookup.Source.SYSTEM_ENV, "CONTAINER_ID"),  YARN_USER("yarn:user", SystemVariableLookup.Source.SYSTEM_ENV, "USER");
  
  private final String name;
  private final SystemVariableLookup.Source source;
  private final String sourceKey;
  
  private SystemVariableLookup$SystemVariable(String name, SystemVariableLookup.Source source)
  {
    this(name, source, null);
  }
  
  private SystemVariableLookup$SystemVariable(String name, SystemVariableLookup.Source source, String sourceKey)
  {
    this.name = name;
    this.source = source;
    this.sourceKey = sourceKey;
  }
  
  public String getName()
  {
    return name;
  }
  
  public SystemVariableLookup.Source getSource()
  {
    return source;
  }
  
  public String getSourceKey()
  {
    return sourceKey;
  }
  
  public static SystemVariable of(String name)
  {
    Preconditions.checkNotNull(name);
    for (SystemVariable systemVariable : values()) {
      if (StringUtils.equals(systemVariable.getName(), name)) {
        return systemVariable;
      }
    }
    throw new IllegalArgumentException(String.format("%s is not a valid SystemVariable", new Object[] { name }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.SystemVariableLookup.SystemVariable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */