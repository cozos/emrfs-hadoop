package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;

public class SelectObjectContentEventUnmarshaller$ProgressEventUnmarshaller
  extends SelectObjectContentEventUnmarshaller
{
  public SelectObjectContentEvent.ProgressEvent unmarshal(Message message)
    throws Exception
  {
    StaxUnmarshallerContext context = SelectObjectContentEventUnmarshaller.access$000(message);
    return new SelectObjectContentEvent.ProgressEvent().withDetails(ProgressStaxUnmarshaller.getInstance().unmarshall(context));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller.ProgressEventUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */