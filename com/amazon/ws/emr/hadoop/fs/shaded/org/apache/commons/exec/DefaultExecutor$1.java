package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

import java.util.Map;

class DefaultExecutor$1
  implements Runnable
{
  private final CommandLine val$command;
  private final Map val$environment;
  private final ExecuteResultHandler val$handler;
  private final DefaultExecutor this$0;
  
  DefaultExecutor$1(DefaultExecutor paramDefaultExecutor, CommandLine paramCommandLine, Map paramMap, ExecuteResultHandler paramExecuteResultHandler)
  {
    this$0 = paramDefaultExecutor;val$command = paramCommandLine;val$environment = paramMap;val$handler = paramExecuteResultHandler;
  }
  
  public void run()
  {
    int exitValue = -559038737;
    try
    {
      exitValue = DefaultExecutor.access$200(this$0, val$command, val$environment, DefaultExecutor.access$000(this$0), DefaultExecutor.access$100(this$0));
      val$handler.onProcessComplete(exitValue);
    }
    catch (ExecuteException e)
    {
      val$handler.onProcessFailed(e);
    }
    catch (Exception e)
    {
      val$handler.onProcessFailed(new ExecuteException("Execution failed", exitValue, e));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.DefaultExecutor.1
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */