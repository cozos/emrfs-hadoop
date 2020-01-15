package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent;

public class SelectObjectContentEventUnmarshaller$UnknownEventUnmarshaller
  extends SelectObjectContentEventUnmarshaller
{
  public SelectObjectContentEvent unmarshal(Message message)
  {
    return new SelectObjectContentEvent();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller.UnknownEventUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */