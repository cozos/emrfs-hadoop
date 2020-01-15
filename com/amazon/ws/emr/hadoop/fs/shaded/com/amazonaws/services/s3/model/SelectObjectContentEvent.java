package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class SelectObjectContentEvent
  implements Serializable, Cloneable
{
  public void visit(SelectObjectContentEventVisitor visitor)
  {
    visitor.visitDefault(this);
  }
  
  public static class RecordsEvent
    extends SelectObjectContentEvent
  {
    private ByteBuffer payload;
    
    public ByteBuffer getPayload()
    {
      return payload;
    }
    
    public void setPayload(ByteBuffer payload)
    {
      this.payload = payload;
    }
    
    public RecordsEvent withPayload(ByteBuffer payload)
    {
      setPayload(payload);
      return this;
    }
    
    public void visit(SelectObjectContentEventVisitor visitor)
    {
      visitor.visit(this);
    }
  }
  
  public static class StatsEvent
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
  
  public static class ProgressEvent
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
  
  public static class ContinuationEvent
    extends SelectObjectContentEvent
  {
    public void visit(SelectObjectContentEventVisitor visitor)
    {
      visitor.visit(this);
    }
  }
  
  public static class EndEvent
    extends SelectObjectContentEvent
  {
    public void visit(SelectObjectContentEventVisitor visitor)
    {
      visitor.visit(this);
    }
  }
  
  public SelectObjectContentEvent clone()
  {
    try
    {
      return (SelectObjectContentEvent)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new RuntimeException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */