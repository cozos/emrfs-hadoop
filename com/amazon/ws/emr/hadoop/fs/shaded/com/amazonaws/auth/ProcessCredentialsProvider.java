package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Platform;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ProcessCredentialsProvider
  implements AWSCredentialsProvider
{
  private final List<String> command;
  private final int expirationBufferValue;
  private final TimeUnit expirationBufferUnit;
  private final long processOutputLimit;
  private final Object credentialLock = new Object();
  private volatile AWSCredentials credentials = null;
  private volatile DateTime credentialExpirationTime = DateTime.now();
  
  private ProcessCredentialsProvider(Builder builder)
  {
    List<String> cmd = new ArrayList();
    if (Platform.isWindows())
    {
      cmd.add("cmd.exe");
      cmd.add("/C");
    }
    else
    {
      cmd.add("sh");
      cmd.add("-c");
    }
    String builderCommand = (String)ValidationUtils.assertNotNull(command, "command");
    
    cmd.add(builderCommand);
    
    command = Collections.unmodifiableList(cmd);
    processOutputLimit = ((Long)ValidationUtils.assertNotNull(Long.valueOf(processOutputLimit), "processOutputLimit")).longValue();
    expirationBufferValue = ((Integer)ValidationUtils.assertNotNull(Integer.valueOf(expirationBufferValue), "expirationBufferValue")).intValue();
    expirationBufferUnit = ((TimeUnit)ValidationUtils.assertNotNull(expirationBufferUnit, "expirationBufferUnit"));
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public AWSCredentials getCredentials()
  {
    if (credentialsNeedUpdating()) {
      synchronized (credentialLock)
      {
        if (credentialsNeedUpdating()) {
          refresh();
        }
      }
    }
    return credentials;
  }
  
  public void refresh()
  {
    try
    {
      String processOutput = executeCommand();
      JsonNode credentialsJson = parseProcessOutput(processOutput);
      
      AWSCredentials credentials = credentials(credentialsJson);
      DateTime credentialExpirationTime = credentialExpirationTime(credentialsJson);
      
      this.credentials = credentials;
      this.credentialExpirationTime = credentialExpirationTime;
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Process-based credential refreshing has been interrupted.", e);
    }
    catch (Exception e)
    {
      throw new IllegalStateException("Failed to refresh process-based credentials.", e);
    }
  }
  
  public DateTime getCredentialExpirationTime()
  {
    return credentialExpirationTime;
  }
  
  private boolean credentialsNeedUpdating()
  {
    return (credentials == null) || (credentialExpirationTime.isBeforeNow());
  }
  
  private JsonNode parseProcessOutput(String processOutput)
  {
    JsonNode credentialsJson = (JsonNode)Jackson.fromSensitiveJsonString(processOutput, JsonNode.class);
    if (!credentialsJson.isObject()) {
      throw new IllegalStateException("Process did not return a JSON object.");
    }
    JsonNode version = credentialsJson.get("Version");
    if ((version == null) || (!version.isInt()) || (version.asInt() != 1)) {
      throw new IllegalStateException("Unsupported credential version: " + version);
    }
    return credentialsJson;
  }
  
  private AWSCredentials credentials(JsonNode credentialsJson)
  {
    String accessKeyId = getText(credentialsJson, "AccessKeyId");
    String secretAccessKey = getText(credentialsJson, "SecretAccessKey");
    String sessionToken = getText(credentialsJson, "SessionToken");
    
    ValidationUtils.assertStringNotEmpty(accessKeyId, "AccessKeyId");
    ValidationUtils.assertStringNotEmpty(secretAccessKey, "SecretAccessKey");
    if (sessionToken != null) {
      return new BasicSessionCredentials(accessKeyId, secretAccessKey, sessionToken);
    }
    return new BasicAWSCredentials(accessKeyId, secretAccessKey);
  }
  
  private DateTime credentialExpirationTime(JsonNode credentialsJson)
  {
    String expiration = getText(credentialsJson, "Expiration");
    if (expiration != null)
    {
      DateTime credentialExpiration = new DateTime(DateUtils.parseISO8601Date(expiration));
      credentialExpiration = credentialExpiration.minus(expirationBufferUnit.toMillis(expirationBufferValue));
      return credentialExpiration;
    }
    return DateTime.now().plusYears(9999);
  }
  
  private String getText(JsonNode jsonObject, String nodeName)
  {
    JsonNode subNode = jsonObject.get(nodeName);
    if (subNode == null) {
      return null;
    }
    if (!subNode.isTextual()) {
      throw new IllegalStateException(nodeName + " from credential process should be textual, but was " + subNode.getNodeType());
    }
    return subNode.asText();
  }
  
  private String executeCommand()
    throws IOException, InterruptedException
  {
    ProcessBuilder processBuilder = new ProcessBuilder(command);
    
    ByteArrayOutputStream commandOutput = new ByteArrayOutputStream();
    
    Process process = processBuilder.start();
    try
    {
      IOUtils.copy(process.getInputStream(), commandOutput, processOutputLimit);
      
      process.waitFor();
      if (process.exitValue() != 0) {
        throw new IllegalStateException("Command returned non-zero exit value: " + process.exitValue());
      }
      return new String(commandOutput.toByteArray(), StringUtils.UTF8);
    }
    finally
    {
      process.destroy();
    }
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ProcessCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */