package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class RequestPaymentConfiguration
  implements Serializable
{
  private Payer payer;
  
  public static enum Payer
  {
    Requester,  BucketOwner;
    
    private Payer() {}
  }
  
  public RequestPaymentConfiguration(Payer payer)
  {
    this.payer = payer;
  }
  
  public Payer getPayer()
  {
    return payer;
  }
  
  public void setPayer(Payer payer)
  {
    this.payer = payer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */