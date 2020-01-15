package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

public class KeyPair
{
  private Object hashKey;
  private Object rangeKey;
  
  public KeyPair withHashKey(Object hashkey)
  {
    hashKey = hashkey;
    return this;
  }
  
  public KeyPair withRangeKey(Object rangeKey)
  {
    this.rangeKey = rangeKey;
    return this;
  }
  
  public void setHashKey(Object hashKey)
  {
    this.hashKey = hashKey;
  }
  
  public void setRangeKey(Object rangeKey)
  {
    this.rangeKey = rangeKey;
  }
  
  public Object getHashKey()
  {
    return hashKey;
  }
  
  public Object getRangeKey()
  {
    return rangeKey;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.KeyPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */