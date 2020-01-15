package com.amazon.ws.emr.hadoop.fs.annotation;

import com.amazon.ws.emr.hadoop.fs.annotation.application.ApplicationTypeConfigurationProcessor;
import com.amazon.ws.emr.hadoop.fs.annotation.application.DefaultConfigurationProcessor;
import com.amazon.ws.emr.hadoop.fs.annotation.application.SparkConfigurationProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Enums;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrLookup;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemVariableLookup
  extends StrLookup<String>
{
  private static final Logger LOG = LoggerFactory.getLogger(SystemVariableLookup.class);
  private final Configuration configuration;
  private final ApplicationTypeConfigurationProcessor applicationTypeConfigurationProcessor;
  
  static enum Source
  {
    CONFIGURATION,  JOB_FLOW_INFO,  SYSTEM_ENV;
    
    private Source() {}
  }
  
  static enum SystemVariable
  {
    EMR_CLUSTER_ID("emr:cluster_id", SystemVariableLookup.Source.JOB_FLOW_INFO),  MAPREDUCE_JOB_ID("mapreduce:job_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_JOB_NAME("mapreduce:job_name", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_JOB_APP_ATTEMPT_ID("mapreduce:job_app_attempt_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_TASK_ID("mapreduce:task_id", SystemVariableLookup.Source.CONFIGURATION),  MAPREDUCE_TASK_ATTEMPT_ID("mapreduce:task_attempt_id", SystemVariableLookup.Source.CONFIGURATION),  YARN_CONTAINER_ID("yarn:container_id", SystemVariableLookup.Source.SYSTEM_ENV, "CONTAINER_ID"),  YARN_USER("yarn:user", SystemVariableLookup.Source.SYSTEM_ENV, "USER");
    
    private final String name;
    private final SystemVariableLookup.Source source;
    private final String sourceKey;
    
    private SystemVariable(String name, SystemVariableLookup.Source source)
    {
      this(name, source, null);
    }
    
    private SystemVariable(String name, SystemVariableLookup.Source source, String sourceKey)
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
  
  public SystemVariableLookup(Configuration configuration)
  {
    this.configuration = configuration;
    Optional<AnnotationProcessorImpl.ApplicationType> applicationTypeOptional = Enums.getIfPresent(AnnotationProcessorImpl.ApplicationType.class, configuration
      .get("yarn.application.type").toUpperCase());
    
    applicationTypeConfigurationProcessor = (applicationTypeOptional.isPresent() ? getApplicationTypeConfigurationProcessor((AnnotationProcessorImpl.ApplicationType)applicationTypeOptional.get()) : null);
  }
  
  public String lookup(String key)
  {
    SystemVariable systemVariable = SystemVariable.of(key);
    switch (systemVariable.getSource())
    {
    case CONFIGURATION: 
      return applicationTypeConfigurationProcessor != null ? 
        lookupConfiguration(systemVariable, applicationTypeConfigurationProcessor) : "";
    case SYSTEM_ENV: 
      return (String)Objects.firstNonNull(System.getenv(systemVariable.getSourceKey()), "");
    case JOB_FLOW_INFO: 
      return EmrFsUtils.getJobFlowId();
    }
    LOG.warn("System variable source {} is not supported", systemVariable.getSource());
    
    throw new UnsupportedOperationException(String.format("System variable source %s is not supported.", new Object[] {systemVariable.getSource() }));
  }
  
  private String lookupConfiguration(SystemVariable key, ApplicationTypeConfigurationProcessor configurationProcessor)
  {
    switch (key)
    {
    case MAPREDUCE_JOB_ID: 
      return configurationProcessor.getJobId();
    case MAPREDUCE_JOB_NAME: 
      return configurationProcessor.getJobName();
    case MAPREDUCE_JOB_APP_ATTEMPT_ID: 
      return configurationProcessor.getApplicationAttemptId();
    case MAPREDUCE_TASK_ID: 
      return configurationProcessor.getTaskId();
    case MAPREDUCE_TASK_ATTEMPT_ID: 
      return configurationProcessor.getTaskAttemptId();
    }
    return "";
  }
  
  private ApplicationTypeConfigurationProcessor getApplicationTypeConfigurationProcessor(AnnotationProcessorImpl.ApplicationType applicationType)
  {
    switch (applicationType)
    {
    case MAPREDUCE: 
      return new DefaultConfigurationProcessor(configuration);
    case SPARK: 
      return new SparkConfigurationProcessor();
    }
    return new DefaultConfigurationProcessor(configuration);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.SystemVariableLookup
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */