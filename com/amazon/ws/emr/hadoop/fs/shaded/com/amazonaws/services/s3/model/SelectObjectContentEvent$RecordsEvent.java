package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.nio.ByteBuffer;

public class SelectObjectContentEvent$RecordsEvent
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.RecordsEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */