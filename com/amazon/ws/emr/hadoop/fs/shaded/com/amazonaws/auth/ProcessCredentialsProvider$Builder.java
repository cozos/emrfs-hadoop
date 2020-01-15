package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import java.util.concurrent.TimeUnit;

public class ProcessCredentialsProvider$Builder
{
  private String command;
  private int expirationBufferValue = 15;
  private TimeUnit expirationBufferUnit = TimeUnit.SECONDS;
  private long processOutputLimit = 1024L;
  
  private void setCommand(String command)
  {
    this.command = command;
  }
  
  public Builder withCommand(String command)
  {
    setCommand(command);
    return this;
  }
  
  public void setCredentialExpirationBuffer(int value, TimeUnit unit)
  {
    expirationBufferValue = value;
    expirationBufferUnit = unit;
  }
  
  public Builder withCredentialExpirationBuffer(int value, TimeUnit unit)
  {
    setCredentialExpirationBuffer(value, unit);
    return this;
  }
  
  private void setProcessOutputLimit(long outputByteLimit)
  {
    processOutputLimit = outputByteLimit;
  }
  
  public Builder withProcessOutputLimit(long outputByteLimit)
  {
    setProcessOutputLimit(outputByteLimit);
    return this;
  }
  
  public ProcessCredentialsProvider build()
  {
    return new ProcessCredentialsProvider(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ProcessCredentialsProvider.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */