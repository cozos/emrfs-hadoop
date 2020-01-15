package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class BootstrapActions
{
  private final String bucket;
  
  public BootstrapActions()
  {
    this("us-east-1.elasticmapreduce");
  }
  
  public BootstrapActions(String bucket)
  {
    this.bucket = bucket;
  }
  
  public BootstrapActionConfig newRunIf(String condition, BootstrapActionConfig config)
  {
    List<String> args = config.getScriptBootstrapAction().getArgs();
    args.add(0, condition);
    args.add(1, config.getScriptBootstrapAction().getPath());
    
    return new BootstrapActionConfig()
      .withName("Run If, " + config.getName())
      .withScriptBootstrapAction(new ScriptBootstrapActionConfig()
      .withPath("s3://" + bucket + "/bootstrap-actions/run-if")
      .withArgs(args));
  }
  
  public static enum ConfigFile
  {
    Site,  Default,  Core,  Hdfs,  Mapred;
    
    private ConfigFile() {}
  }
  
  public ConfigureHadoop newConfigureHadoop()
  {
    return new ConfigureHadoop(null);
  }
  
  @Deprecated
  public class ConfigureHadoop
  {
    List<String> args = new ArrayList();
    
    private ConfigureHadoop() {}
    
    public ConfigureHadoop withXml(BootstrapActions.ConfigFile file, String xmlPath)
    {
      String arg = "";
      switch (BootstrapActions.1.$SwitchMap$com$amazonaws$services$elasticmapreduce$util$BootstrapActions$ConfigFile[file.ordinal()])
      {
      case 1: 
        arg = "-S"; break;
      case 2: 
        arg = "-D"; break;
      case 3: 
        arg = "-C"; break;
      case 4: 
        arg = "-H"; break;
      case 5: 
        arg = "-M";
      }
      args.add(arg);
      args.add(xmlPath);
      return this;
    }
    
    public ConfigureHadoop withKeyValue(BootstrapActions.ConfigFile file, String key, String value)
    {
      String arg = "";
      switch (BootstrapActions.1.$SwitchMap$com$amazonaws$services$elasticmapreduce$util$BootstrapActions$ConfigFile[file.ordinal()])
      {
      case 1: 
        arg = "-s"; break;
      case 2: 
        arg = "-d"; break;
      case 3: 
        arg = "-c"; break;
      case 4: 
        arg = "-h"; break;
      case 5: 
        arg = "-m";
      }
      args.add(arg);
      args.add(key + "=" + value);
      return this;
    }
    
    public BootstrapActionConfig build()
    {
      return 
      
        new BootstrapActionConfig().withName("Configure Hadoop").withScriptBootstrapAction(new ScriptBootstrapActionConfig()
        .withPath("s3://" + bucket + "/bootstrap-actions/configure-hadoop")
        .withArgs(args));
    }
  }
  
  public static enum Daemon
  {
    NameNode,  DataNode,  JobTracker,  TaskTracker,  Client;
    
    private Daemon() {}
  }
  
  public ConfigureDaemons newConfigureDaemons()
  {
    return new ConfigureDaemons(null);
  }
  
  public class ConfigureDaemons
  {
    List<String> args = new ArrayList();
    boolean replace = false;
    
    private ConfigureDaemons() {}
    
    public ConfigureDaemons withHeapSize(BootstrapActions.Daemon daemon, int megabytes)
    {
      args.add("--" + StringUtils.lowerCase(daemon.name()) + "-heap-size=" + megabytes);
      return this;
    }
    
    public ConfigureDaemons withOpts(BootstrapActions.Daemon daemon, String opts)
    {
      args.add("--" + StringUtils.lowerCase(daemon.name()) + "-opts=\"" + opts + "\"");
      return this;
    }
    
    public ConfigureDaemons withReplace(boolean replace)
    {
      this.replace = replace;
      return this;
    }
    
    public BootstrapActionConfig build()
    {
      if (replace) {
        args.add("--replace");
      }
      return 
      
        new BootstrapActionConfig().withName("Configure Daemons").withScriptBootstrapAction(new ScriptBootstrapActionConfig()
        .withPath("s3://" + bucket + "/bootstrap-actions/configure-daemons")
        .withArgs(args));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.BootstrapActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */