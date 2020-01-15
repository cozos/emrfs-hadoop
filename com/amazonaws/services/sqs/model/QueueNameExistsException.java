package com.amazonaws.services.sqs.model;

public class QueueNameExistsException
  extends AmazonSQSException
{
  private static final long serialVersionUID = 1L;
  
  public QueueNameExistsException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.QueueNameExistsException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */