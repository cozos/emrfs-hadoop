package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.RecordsEvent;
import java.nio.ByteBuffer;

public class SelectObjectContentEventUnmarshaller$RecordsEventUnmarshaller
  extends SelectObjectContentEventUnmarshaller
{
  public SelectObjectContentEvent.RecordsEvent unmarshal(Message message)
  {
    return new SelectObjectContentEvent.RecordsEvent().withPayload(ByteBuffer.wrap(message.getPayload()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller.RecordsEventUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */