package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableStatus;

public class TableUtils$TableNeverTransitionedToStateException
  extends SdkClientException
{
  private static final long serialVersionUID = 8920567021104846647L;
  
  public TableUtils$TableNeverTransitionedToStateException(String tableName, TableStatus desiredStatus)
  {
    super("Table " + tableName + " never transitioned to desired state of " + desiredStatus.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.util.TableUtils.TableNeverTransitionedToStateException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */