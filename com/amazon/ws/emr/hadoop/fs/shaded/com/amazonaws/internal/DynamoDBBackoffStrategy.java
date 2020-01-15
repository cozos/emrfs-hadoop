package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

public class DynamoDBBackoffStrategy
  extends CustomBackoffStrategy
{
  public int getBackoffPeriod(int retries)
  {
    if (retries <= 0) {
      return 0;
    }
    int delay = 50 * (int)Math.pow(2.0D, retries - 1);
    if (delay < 0) {
      delay = Integer.MAX_VALUE;
    }
    return delay;
  }
  
  public static final CustomBackoffStrategy DEFAULT = new DynamoDBBackoffStrategy();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DynamoDBBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */