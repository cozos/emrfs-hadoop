package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

public class MessageConstraints$Builder
{
  private int maxLineLength;
  private int maxHeaderCount;
  
  MessageConstraints$Builder()
  {
    maxLineLength = -1;
    maxHeaderCount = -1;
  }
  
  public Builder setMaxLineLength(int maxLineLength)
  {
    this.maxLineLength = maxLineLength;
    return this;
  }
  
  public Builder setMaxHeaderCount(int maxHeaderCount)
  {
    this.maxHeaderCount = maxHeaderCount;
    return this;
  }
  
  public MessageConstraints build()
  {
    return new MessageConstraints(maxLineLength, maxHeaderCount);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */