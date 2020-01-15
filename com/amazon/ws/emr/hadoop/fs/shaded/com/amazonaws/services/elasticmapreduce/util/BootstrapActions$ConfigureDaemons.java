package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class BootstrapActions$ConfigureDaemons
{
  List<String> args = new ArrayList();
  boolean replace = false;
  
  private BootstrapActions$ConfigureDaemons(BootstrapActions this$0) {}
  
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
      .withPath("s3://" + BootstrapActions.access$100(this$0) + "/bootstrap-actions/configure-daemons")
      .withArgs(args));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.BootstrapActions.ConfigureDaemons
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */