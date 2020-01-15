package com.amazon.ws.emr.hadoop.fs.notification;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractSQSMessage
{
  private static final Logger LOG = LoggerFactory.getLogger(AbstractSQSMessage.class);
  private static final int TRACE_DEPTH = 15;
  private Notifier.Api api;
  private String arg1;
  private String arg2;
  private long epoch;
  private String timestamp;
  private String username;
  private String hostname;
  private String jobId;
  private String taskId;
  private String attemptId;
  private String inputFile;
  private String logFile;
  private QueryType queryType;
  private String queryId;
  private List<String> stackTrace;
  private String customMsg;
  
  public static enum QueryType
  {
    Hive,  Pig,  Unknown;
    
    private QueryType() {}
  }
  
  public AbstractSQSMessage(Configuration configuration, Notifier.Api api, Path arg1, Path arg2)
  {
    this.api = api;
    if (arg1 != null) {
      this.arg1 = arg1.toString();
    }
    if (arg2 != null) {
      this.arg2 = arg2.toString();
    }
    hostname = "unknown";
    try
    {
      hostname = InetAddress.getLocalHost().getHostName();
    }
    catch (UnknownHostException e)
    {
      LOG.warn("Failed to identify hostname", e);
    }
    epoch = System.currentTimeMillis();
    
    timestamp = new Date(epoch).toString();
    
    username = configuration.get("user.name", System.getProperty("user.name"));
    try
    {
      username = UserGroupInformation.getCurrentUser().getUserName();
    }
    catch (IOException e)
    {
      LOG.warn("Failed to identify user using hadoop library.", e);
    }
    customMsg = configuration.get("fs.s3.consistent.notification.SQS.customMsg");
    
    queryId = configuration.get("hive.query.id");
    queryType = QueryType.Unknown;
    if (queryId != null)
    {
      queryType = QueryType.Hive;
      logFile = configuration.get("hive.log.file");
    }
    else
    {
      queryId = configuration.get("pig.script.id");
      if (queryId != null)
      {
        queryType = QueryType.Pig;
        logFile = configuration.get("pig.logfile");
      }
    }
    taskId = configuration.get("mapreduce.task.id");
    if (Strings.isNullOrEmpty(taskId)) {
      taskId = configuration.get("mapred.tip.id");
    }
    attemptId = configuration.get("mapreduce.task.attempt.id");
    if (Strings.isNullOrEmpty(attemptId)) {
      attemptId = configuration.get("mapred.task.id");
    }
    inputFile = configuration.get("mapred.input.file");
    
    jobId = configuration.get("mapreduce.job.id");
    if (Strings.isNullOrEmpty(jobId)) {
      jobId = configuration.get("mapred.job.id");
    }
    try
    {
      if (jobId == null)
      {
        String[] split = configuration.get("mapreduce.job.dir").split("/");
        jobId = split[(split.length - 1)];
      }
    }
    catch (RuntimeException e)
    {
      LOG.debug("Failed to determine job id");
    }
    try
    {
      StackTraceElement[] stack = Thread.currentThread().getStackTrace();
      stackTrace = new ArrayList(15);
      int depth = Math.min(15, stack.length);
      for (int i = 0; i < depth; i++) {
        stackTrace.add(stack[i].toString());
      }
    }
    catch (Exception e)
    {
      LOG.debug("Stacktrace generation failed", e);
    }
  }
  
  public Notifier.Api getApi()
  {
    return api;
  }
  
  public String getArg1()
  {
    return arg1;
  }
  
  public String getArg2()
  {
    return arg2;
  }
  
  public long getEpoch()
  {
    return epoch;
  }
  
  public String getTimestamp()
  {
    return timestamp;
  }
  
  public String getUsername()
  {
    return username;
  }
  
  public String getHostname()
  {
    return hostname;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public String getTaskId()
  {
    return taskId;
  }
  
  public String getAttemptId()
  {
    return attemptId;
  }
  
  public String getInputFile()
  {
    return inputFile;
  }
  
  public String getLogFile()
  {
    return logFile;
  }
  
  public QueryType getQueryType()
  {
    return queryType;
  }
  
  public String getQueryId()
  {
    return queryId;
  }
  
  public List<String> getStackTrace()
  {
    return stackTrace;
  }
  
  public String getCustomMsg()
  {
    return customMsg;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.AbstractSQSMessage
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */