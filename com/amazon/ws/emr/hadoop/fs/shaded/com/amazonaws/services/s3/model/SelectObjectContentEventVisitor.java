package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public abstract class SelectObjectContentEventVisitor
{
  public void visit(SelectObjectContentEvent.RecordsEvent event)
  {
    visitDefault(event);
  }
  
  public void visit(SelectObjectContentEvent.ContinuationEvent event)
  {
    visitDefault(event);
  }
  
  public void visit(SelectObjectContentEvent.ProgressEvent event)
  {
    visitDefault(event);
  }
  
  public void visit(SelectObjectContentEvent.StatsEvent event)
  {
    visitDefault(event);
  }
  
  public void visit(SelectObjectContentEvent.EndEvent event)
  {
    visitDefault(event);
  }
  
  public void visitDefault(SelectObjectContentEvent selectEvent) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */