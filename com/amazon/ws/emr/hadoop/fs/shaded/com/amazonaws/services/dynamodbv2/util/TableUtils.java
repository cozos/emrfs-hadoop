package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public class TableUtils
{
  private static final int DEFAULT_WAIT_TIMEOUT = 600000;
  private static final int DEFAULT_WAIT_INTERVAL = 20000;
  
  public static class TableNeverTransitionedToStateException
    extends SdkClientException
  {
    private static final long serialVersionUID = 8920567021104846647L;
    
    public TableNeverTransitionedToStateException(String tableName, TableStatus desiredStatus)
    {
      super();
    }
  }
  
  private static final Log LOG = LogFactory.getLog(TableUtils.class);
  
  public static void waitUntilExists(AmazonDynamoDB dynamo, String tableName)
    throws InterruptedException
  {
    waitUntilExists(dynamo, tableName, 600000, 20000);
  }
  
  public static void waitUntilExists(AmazonDynamoDB dynamo, String tableName, int timeout, int interval)
    throws InterruptedException
  {
    TableDescription table = waitForTableDescription(dynamo, tableName, null, timeout, interval);
    if (table == null) {
      throw new SdkClientException("Table " + tableName + " never returned a result");
    }
  }
  
  public static void waitUntilActive(AmazonDynamoDB dynamo, String tableName)
    throws InterruptedException, TableUtils.TableNeverTransitionedToStateException
  {
    waitUntilActive(dynamo, tableName, 600000, 20000);
  }
  
  public static void waitUntilActive(AmazonDynamoDB dynamo, String tableName, int timeout, int interval)
    throws InterruptedException, TableUtils.TableNeverTransitionedToStateException
  {
    TableDescription table = waitForTableDescription(dynamo, tableName, TableStatus.ACTIVE, timeout, interval);
    if ((table == null) || (!table.getTableStatus().equals(TableStatus.ACTIVE.toString()))) {
      throw new TableNeverTransitionedToStateException(tableName, TableStatus.ACTIVE);
    }
  }
  
  private static TableDescription waitForTableDescription(AmazonDynamoDB dynamo, String tableName, TableStatus desiredStatus, int timeout, int interval)
    throws InterruptedException, IllegalArgumentException
  {
    if (timeout < 0) {
      throw new IllegalArgumentException("Timeout must be >= 0");
    }
    if ((interval <= 0) || (interval >= timeout)) {
      throw new IllegalArgumentException("Interval must be > 0 and < timeout");
    }
    long startTime = System.currentTimeMillis();
    long endTime = startTime + timeout;
    
    TableDescription table = null;
    while (System.currentTimeMillis() < endTime)
    {
      try
      {
        table = dynamo.describeTable(new DescribeTableRequest(tableName)).getTable();
        if ((desiredStatus == null) || (table.getTableStatus().equals(desiredStatus.toString()))) {
          return table;
        }
      }
      catch (ResourceNotFoundException localResourceNotFoundException) {}
      Thread.sleep(interval);
    }
    return table;
  }
  
  public static final boolean createTableIfNotExists(AmazonDynamoDB dynamo, CreateTableRequest createTableRequest)
  {
    try
    {
      dynamo.createTable(createTableRequest);
      return true;
    }
    catch (ResourceInUseException e)
    {
      if (LOG.isTraceEnabled()) {
        LOG.trace("Table " + createTableRequest.getTableName() + " already exists", e);
      }
    }
    return false;
  }
  
  public static final boolean deleteTableIfExists(AmazonDynamoDB dynamo, DeleteTableRequest deleteTableRequest)
  {
    try
    {
      dynamo.deleteTable(deleteTableRequest);
      return true;
    }
    catch (ResourceNotFoundException e)
    {
      if (LOG.isTraceEnabled()) {
        LOG.trace("Table " + deleteTableRequest.getTableName() + " does not exist", e);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.util.TableUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */