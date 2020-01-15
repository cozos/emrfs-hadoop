package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepFactory
{
  private final String bucket;
  
  public static enum HiveVersion
  {
    Hive_0_5("0.5"),  Hive_0_7("0.7"),  Hive_0_7_1("0.7.1"),  Hive_0_8_1("0.8.1"),  Hive_0_8_1_1("0.8.1.1"),  Hive_0_8_1_2("0.8.1.2"),  Hive_0_8_1_3("0.8.1.3"),  Hive_0_8_1_4("0.8.1.4"),  Hive_0_8_1_5("0.8.1.5"),  Hive_0_8_1_6("0.8.1.6"),  Hive_0_8_1_7("0.8.1.7"),  Hive_0_8_1_8("0.8.1.8"),  Hive_0_11_0("0.11.0"),  Hive_Latest("latest");
    
    private String stringVal;
    
    private HiveVersion(String str)
    {
      stringVal = str;
    }
    
    public String toString()
    {
      return stringVal;
    }
  }
  
  public StepFactory()
  {
    this("us-east-1.elasticmapreduce");
  }
  
  public StepFactory(String bucket)
  {
    this.bucket = bucket;
  }
  
  public HadoopJarStepConfig newScriptRunnerStep(String script, String... args)
  {
    List<String> argsList = new ArrayList();
    argsList.add(script);
    for (String arg : args) {
      argsList.add(arg);
    }
    return 
    
      new HadoopJarStepConfig().withJar("s3://" + bucket + "/libs/script-runner/script-runner.jar").withArgs(argsList);
  }
  
  public HadoopJarStepConfig newEnableDebuggingStep()
  {
    return newScriptRunnerStep("s3://" + bucket + "/libs/state-pusher/0.1/fetch", new String[0]);
  }
  
  public HadoopJarStepConfig newInstallHiveStep(HiveVersion... hiveVersions)
  {
    if (hiveVersions.length > 0)
    {
      String[] versionStrings = new String[hiveVersions.length];
      for (int i = 0; i < hiveVersions.length; i++) {
        versionStrings[i] = hiveVersions[i].toString();
      }
      return newInstallHiveStep(versionStrings);
    }
    return newHivePigStep("hive", new String[] { "--install-hive", "--hive-versions", "latest" });
  }
  
  public HadoopJarStepConfig newInstallHiveStep(String... hiveVersions)
  {
    if (hiveVersions.length > 0) {
      return newHivePigStep("hive", new String[] { "--install-hive", "--hive-versions", 
        StringUtils.join(",", hiveVersions) });
    }
    return newHivePigStep("hive", new String[] { "--install-hive", "--hive-versions", "latest" });
  }
  
  public HadoopJarStepConfig newInstallHiveStep()
  {
    return newInstallHiveStep(new HiveVersion[0]);
  }
  
  public HadoopJarStepConfig newRunHiveScriptStepVersioned(String script, String hiveVersion, String... scriptArgs)
  {
    List<String> hiveArgs = new ArrayList();
    hiveArgs.add("--hive-versions");
    hiveArgs.add(hiveVersion);
    hiveArgs.add("--run-hive-script");
    hiveArgs.add("--args");
    hiveArgs.add("-f");
    hiveArgs.add(script);
    hiveArgs.addAll(Arrays.asList(scriptArgs));
    return newHivePigStep("hive", (String[])hiveArgs.toArray(new String[0]));
  }
  
  public HadoopJarStepConfig newRunHiveScriptStep(String script, String... args)
  {
    return newRunHiveScriptStepVersioned(script, "latest", args);
  }
  
  public HadoopJarStepConfig newInstallPigStep()
  {
    return newInstallPigStep(new String[0]);
  }
  
  public HadoopJarStepConfig newInstallPigStep(String... pigVersions)
  {
    if ((pigVersions != null) && (pigVersions.length > 0)) {
      return newHivePigStep("pig", new String[] { "--install-pig", "--pig-versions", 
        StringUtils.join(",", pigVersions) });
    }
    return newHivePigStep("pig", new String[] { "--install-pig", "--pig-versions", "latest" });
  }
  
  public HadoopJarStepConfig newRunPigScriptStep(String script, String pigVersion, String... scriptArgs)
  {
    List<String> pigArgs = new ArrayList();
    pigArgs.add("--pig-versions");
    pigArgs.add(pigVersion);
    pigArgs.add("--run-pig-script");
    pigArgs.add("--args");
    pigArgs.add("-f");
    pigArgs.add(script);
    pigArgs.addAll(Arrays.asList(scriptArgs));
    return newHivePigStep("pig", (String[])pigArgs.toArray(new String[0]));
  }
  
  public HadoopJarStepConfig newRunPigScriptStep(String script, String... scriptArgs)
  {
    return newRunPigScriptStep(script, "latest", scriptArgs);
  }
  
  private HadoopJarStepConfig newHivePigStep(String type, String... args)
  {
    List<String> appArgs = new ArrayList();
    appArgs.add("--base-path");
    appArgs.add("s3://" + bucket + "/libs/" + type + "/");
    appArgs.addAll(Arrays.asList(args));
    return newScriptRunnerStep("s3://" + bucket + "/libs/" + type + "/" + type + "-script", (String[])appArgs.toArray(new String[0]));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.StepFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */