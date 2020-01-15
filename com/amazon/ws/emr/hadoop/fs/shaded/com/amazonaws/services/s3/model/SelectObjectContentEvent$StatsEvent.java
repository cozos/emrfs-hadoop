package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public class SelectObjectContentEvent$StatsEvent
  extends SelectObjectContentEvent
{
  private Stats details;
  
  public Stats getDetails()
  {
    return details;
  }
  
  public void setDetails(Stats details)
  {
    this.details = details;
  }
  
  public StatsEvent withDetails(Stats details)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.StatsEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */