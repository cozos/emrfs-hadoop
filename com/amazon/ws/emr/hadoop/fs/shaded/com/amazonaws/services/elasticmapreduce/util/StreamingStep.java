package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StreamingStep
{
  private List<String> inputs = new ArrayList();
  private String output;
  private String mapper;
  private String reducer;
  private Map<String, String> hadoopConfig = new HashMap();
  
  public List<String> getInputs()
  {
    return inputs;
  }
  
  public void setInputs(Collection<String> inputs)
  {
    List<String> newInputs = new ArrayList();
    if (inputs != null) {
      newInputs.addAll(inputs);
    }
    this.inputs = newInputs;
  }
  
  public StreamingStep withInputs(String... inputs)
  {
    for (String input : inputs) {
      this.inputs.add(input);
    }
    return this;
  }
  
  public String getOutput()
  {
    return output;
  }
  
  public void setOutput(String output)
  {
    this.output = output;
  }
  
  public StreamingStep withOutput(String output)
  {
    this.output = output;
    return this;
  }
  
  public String getMapper()
  {
    return mapper;
  }
  
  public void setMapper(String mapper)
  {
    this.mapper = mapper;
  }
  
  public StreamingStep withMapper(String mapper)
  {
    this.mapper = mapper;
    return this;
  }
  
  public String getReducer()
  {
    return reducer;
  }
  
  public void setReducer(String reducer)
  {
    this.reducer = reducer;
  }
  
  public StreamingStep withReducer(String reducer)
  {
    this.reducer = reducer;
    return this;
  }
  
  public Map<String, String> getHadoopConfig()
  {
    return hadoopConfig;
  }
  
  public void setHadoopConfig(Map<String, String> hadoopConfig)
  {
    this.hadoopConfig = hadoopConfig;
  }
  
  public StreamingStep withHadoopConfig(String key, String value)
  {
    hadoopConfig.put(key, value);
    return this;
  }
  
  public HadoopJarStepConfig toHadoopJarStepConfig()
  {
    List<String> args = new ArrayList();
    if (reducer == null) {
      hadoopConfig.put("mapred.reduce.tasks", "0");
    }
    for (Map.Entry<String, String> entry : hadoopConfig.entrySet())
    {
      args.add("-D");
      args.add((String)entry.getKey() + "=" + (String)entry.getValue());
    }
    for (String input : inputs)
    {
      args.add("-input");
      args.add(input);
    }
    if (output != null)
    {
      args.add("-output");
      args.add(output);
    }
    if (mapper != null)
    {
      args.add("-mapper");
      args.add(mapper);
    }
    if (reducer != null)
    {
      args.add("-reducer");
      args.add(reducer);
    }
    return 
    
      new HadoopJarStepConfig().withJar("/home/hadoop/contrib/streaming/hadoop-streaming.jar").withArgs(args);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.StreamingStep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */