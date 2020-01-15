package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransactionCanceledException
  extends AmazonDynamoDBException
{
  private static final long serialVersionUID = 1L;
  private List<CancellationReason> cancellationReasons;
  
  public TransactionCanceledException(String message)
  {
    super(message);
  }
  
  @JsonProperty("CancellationReasons")
  public List<CancellationReason> getCancellationReasons()
  {
    return cancellationReasons;
  }
  
  @JsonProperty("CancellationReasons")
  public void setCancellationReasons(Collection<CancellationReason> cancellationReasons)
  {
    if (cancellationReasons == null)
    {
      this.cancellationReasons = null;
      return;
    }
    this.cancellationReasons = new ArrayList(cancellationReasons);
  }
  
  public TransactionCanceledException withCancellationReasons(CancellationReason... cancellationReasons)
  {
    if (this.cancellationReasons == null) {
      setCancellationReasons(new ArrayList(cancellationReasons.length));
    }
    for (CancellationReason ele : cancellationReasons) {
      this.cancellationReasons.add(ele);
    }
    return this;
  }
  
  public TransactionCanceledException withCancellationReasons(Collection<CancellationReason> cancellationReasons)
  {
    setCancellationReasons(cancellationReasons);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactionCanceledException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */