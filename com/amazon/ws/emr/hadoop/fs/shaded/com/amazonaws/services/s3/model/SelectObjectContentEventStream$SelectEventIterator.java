package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.MessageDecoder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SelectObjectContentEventStream$SelectEventIterator
  extends SelectObjectContentEventStream.LazyLoadedIterator<SelectObjectContentEvent>
{
  private SelectObjectContentEventStream$SelectEventIterator(SelectObjectContentEventStream paramSelectObjectContentEventStream)
  {
    super(paramSelectObjectContentEventStream, null);
  }
  
  private final MessageDecoder decoder = new MessageDecoder();
  
  protected Collection<SelectObjectContentEvent> getNext()
    throws IOException
  {
    List<SelectObjectContentEvent> next = new ArrayList();
    byte[] payload = new byte['Ā'];
    while (next.isEmpty())
    {
      int read = SelectObjectContentEventStream.access$300(this$0).read(payload);
      if (read == -1)
      {
        if (!decoder.hasPendingContent()) {
          break;
        }
        throw new SelectObjectContentEventException("Service stream ended before an event could be entirely decoded.");
      }
      List<Message> messages = decoder.feed(payload, 0, read);
      for (Message message : messages) {
        next.add(SelectObjectContentEventUnmarshaller.unmarshalMessage(message));
      }
    }
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream.SelectEventIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */