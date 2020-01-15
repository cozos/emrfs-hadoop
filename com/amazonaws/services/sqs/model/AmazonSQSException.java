package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;

public class AmazonSQSException
  extends AmazonServiceException
{
  private static final long serialVersionUID = 1L;
  
  public AmazonSQSException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.AmazonSQSException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */