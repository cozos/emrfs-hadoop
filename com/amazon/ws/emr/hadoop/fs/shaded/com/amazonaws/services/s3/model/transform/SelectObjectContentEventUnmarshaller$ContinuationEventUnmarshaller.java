package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ContinuationEvent;

public class SelectObjectContentEventUnmarshaller$ContinuationEventUnmarshaller
  extends SelectObjectContentEventUnmarshaller
{
  public SelectObjectContentEvent.ContinuationEvent unmarshal(Message message)
  {
    return new SelectObjectContentEvent.ContinuationEvent();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller.ContinuationEventUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */