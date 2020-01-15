package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public class SelectObjectContentEvent$ProgressEvent
  extends SelectObjectContentEvent
{
  private Progress details;
  
  public Progress getDetails()
  {
    return details;
  }
  
  public void setDetails(Progress details)
  {
    this.details = details;
  }
  
  public ProgressEvent withDetails(Progress details)
  {
    setDetails(details);
    return this;
  }
  
  public void visit(SelectObjectContentEventVisitor visitor)
  {
    visitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ProgressEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */