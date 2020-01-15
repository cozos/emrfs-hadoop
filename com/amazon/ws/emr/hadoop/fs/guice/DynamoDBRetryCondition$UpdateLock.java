package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;

class DynamoDBRetryCondition$UpdateLock
{
  String owner;
  boolean completed;
  long timeout;
  
  DynamoDBRetryCondition$UpdateLock(String owner, boolean completed, long timeout)
  {
    this.owner = owner;
    this.completed = completed;
    this.timeout = timeout;
  }
  
  byte[] toByteArray()
  {
    return new Gson().toJson(this).getBytes();
  }
  
  static UpdateLock fromByteArray(byte[] bytes)
  {
    return (UpdateLock)new Gson().fromJson(new String(bytes), UpdateLock.class);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.DynamoDBRetryCondition.UpdateLock
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */