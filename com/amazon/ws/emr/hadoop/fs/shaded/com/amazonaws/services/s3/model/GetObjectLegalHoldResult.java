package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GetObjectLegalHoldResult
  implements Serializable
{
  private ObjectLockLegalHold legalHold;
  
  public ObjectLockLegalHold getLegalHold()
  {
    return legalHold;
  }
  
  public GetObjectLegalHoldResult withLegalHold(ObjectLockLegalHold legalHold)
  {
    this.legalHold = legalHold;
    return this;
  }
  
  public void setLegalHold(ObjectLockLegalHold legalHold)
  {
    withLegalHold(legalHold);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */