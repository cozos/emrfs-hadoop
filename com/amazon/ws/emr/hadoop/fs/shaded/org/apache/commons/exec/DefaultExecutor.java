package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncher;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncherFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class DefaultExecutor
  implements Executor
{
  private ExecuteStreamHandler streamHandler;
  private File workingDirectory;
  private ExecuteWatchdog watchdog;
  private int[] exitValues;
  private final CommandLauncher launcher;
  private ProcessDestroyer processDestroyer;
  private Thread executorThread;
  private IOException exceptionCaught;
  
  public DefaultExecutor()
  {
    streamHandler = new PumpStreamHandler();
    launcher = CommandLauncherFactory.createVMLauncher();
    exitValues = new int[0];
    workingDirectory = new File(".");
    exceptionCaught = null;
  }
  
  public ExecuteStreamHandler getStreamHandler()
  {
    return streamHandler;
  }
  
  public void setStreamHandler(ExecuteStreamHandler streamHandler)
  {
    this.streamHandler = streamHandler;
  }
  
  public ExecuteWatchdog getWatchdog()
  {
    return watchdog;
  }
  
  public void setWatchdog(ExecuteWatchdog watchDog)
  {
    watchdog = watchDog;
  }
  
  public ProcessDestroyer getProcessDestroyer()
  {
    return processDestroyer;
  }
  
  public void setProcessDestroyer(ProcessDestroyer processDestroyer)
  {
    this.processDestroyer = processDestroyer;
  }
  
  public File getWorkingDirectory()
  {
    return workingDirectory;
  }
  
  public void setWorkingDirectory(File dir)
  {
    workingDirectory = dir;
  }
  
  public int execute(CommandLine command)
    throws ExecuteException, IOException
  {
    return execute(command, (Map)null);
  }
  
  public int execute(CommandLine command, Map environment)
    throws ExecuteException, IOException
  {
    if ((workingDirectory != null) && (!workingDirectory.exists())) {
      throw new IOException(workingDirectory + " doesn't exist.");
    }
    return executeInternal(command, environment, workingDirectory, streamHandler);
  }
  
  public void execute(CommandLine command, ExecuteResultHandler handler)
    throws ExecuteException, IOException
  {
    execute(command, null, handler);
  }
  
  public void execute(CommandLine command, Map environment, ExecuteResultHandler handler)
    throws ExecuteException, IOException
  {
    if ((workingDirectory != null) && (!workingDirectory.exists())) {
      throw new IOException(workingDirectory + " doesn't exist.");
    }
    if (watchdog != null) {
      watchdog.setProcessNotStarted();
    }
    Runnable runnable = new Runnable()
    {
      private final CommandLine val$command;
      private final Map val$environment;
      private final ExecuteResultHandler val$handler;
      
      public void run()
      {
        int exitValue = -559038737;
        try
        {
          exitValue = DefaultExecutor.this.executeInternal(val$command, val$environment, workingDirectory, streamHandler);
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
    };
    executorThread = createThread(runnable, "Exec Default Executor");
    getExecutorThread().start();
  }
  
  public void setExitValue(int value)
  {
    setExitValues(new int[] { value });
  }
  
  public void setExitValues(int[] values)
  {
    exitValues = (values == null ? null : (int[])values.clone());
  }
  
  public boolean isFailure(int exitValue)
  {
    if (exitValues == null) {
      return false;
    }
    if (exitValues.length == 0) {
      return launcher.isFailure(exitValue);
    }
    for (int i = 0; i < exitValues.length; i++) {
      if (exitValues[i] == exitValue) {
        return false;
      }
    }
    return true;
  }
  
  protected Thread createThread(Runnable runnable, String name)
  {
    return new Thread(runnable, name);
  }
  
  protected Process launch(CommandLine command, Map env, File dir)
    throws IOException
  {
    if (launcher == null) {
      throw new IllegalStateException("CommandLauncher can not be null");
    }
    if ((dir != null) && (!dir.exists())) {
      throw new IOException(dir + " doesn't exist.");
    }
    return launcher.exec(command, env, dir);
  }
  
  protected Thread getExecutorThread()
  {
    return executorThread;
  }
  
  private void closeProcessStreams(Process process)
  {
    try
    {
      process.getInputStream().close();
    }
    catch (IOException e)
    {
      setExceptionCaught(e);
    }
    try
    {
      process.getOutputStream().close();
    }
    catch (IOException e)
    {
      setExceptionCaught(e);
    }
    try
    {
      process.getErrorStream().close();
    }
    catch (IOException e)
    {
      setExceptionCaught(e);
    }
  }
  
  private int executeInternal(CommandLine command, Map environment, File dir, ExecuteStreamHandler streams)
    throws IOException
  {
    setExceptionCaught(null);
    
    Process process = launch(command, environment, dir);
    try
    {
      streams.setProcessInputStream(process.getOutputStream());
      streams.setProcessOutputStream(process.getInputStream());
      streams.setProcessErrorStream(process.getErrorStream());
    }
    catch (IOException e)
    {
      process.destroy();
      throw e;
    }
    streams.start();
    try
    {
      if (getProcessDestroyer() != null) {
        getProcessDestroyer().add(process);
      }
      if (watchdog != null) {
        watchdog.start(process);
      }
      int exitValue = -559038737;
      try
      {
        exitValue = process.waitFor();
      }
      catch (InterruptedException e)
      {
        process.destroy();
      }
      finally
      {
        Thread.interrupted();
      }
      if (watchdog != null) {
        watchdog.stop();
      }
      try
      {
        streams.stop();
      }
      catch (IOException e)
      {
        setExceptionCaught(e);
      }
      closeProcessStreams(process);
      if (getExceptionCaught() != null) {
        throw getExceptionCaught();
      }
      if (watchdog != null) {
        try
        {
          watchdog.checkException();
        }
        catch (IOException e)
        {
          throw e;
        }
        catch (Exception e)
        {
          throw new IOException(e.getMessage());
        }
      }
      if (isFailure(exitValue)) {
        throw new ExecuteException("Process exited with an error: " + exitValue, exitValue);
      }
      return exitValue;
    }
    finally
    {
      if (getProcessDestroyer() != null) {
        getProcessDestroyer().remove(process);
      }
    }
  }
  
  private void setExceptionCaught(IOException e)
  {
    if (exceptionCaught == null) {
      exceptionCaught = e;
    }
  }
  
  private IOException getExceptionCaught()
  {
    return exceptionCaught;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.DefaultExecutor
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */