package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class BootstrapActions$ConfigureHadoop
{
  List<String> args = new ArrayList();
  
  private BootstrapActions$ConfigureHadoop(BootstrapActions this$0) {}
  
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
      .withPath("s3://" + BootstrapActions.access$100(this$0) + "/bootstrap-actions/configure-hadoop")
      .withArgs(args));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.BootstrapActions.ConfigureHadoop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */