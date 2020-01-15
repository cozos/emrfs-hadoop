package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.MessageDecoder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@NotThreadSafe
public class SelectObjectContentEventStream
  implements Closeable
{
  private static final InputStream EMPTY_INPUT_STREAM = new ByteArrayInputStream(new byte[0]);
  private final SdkFilterInputStream inputStream;
  private boolean readOptionChosen = false;
  
  public SelectObjectContentEventStream(SdkFilterInputStream inputStream)
  {
    this.inputStream = ((SdkFilterInputStream)ValidationUtils.assertNotNull(inputStream, "inputStream"));
  }
  
  public List<SelectObjectContentEvent> getAllEvents()
    throws SelectObjectContentEventException
  {
    List<SelectObjectContentEvent> events = new ArrayList();
    Iterator<SelectObjectContentEvent> eventsIterator = getEventsIterator();
    while (eventsIterator.hasNext()) {
      events.add(eventsIterator.next());
    }
    return events;
  }
  
  public void visitAllEvents(SelectObjectContentEventVisitor visitor)
    throws SelectObjectContentEventException
  {
    Iterator<SelectObjectContentEvent> eventsIterator = getEventsIterator();
    while (eventsIterator.hasNext()) {
      ((SelectObjectContentEvent)eventsIterator.next()).visit(visitor);
    }
  }
  
  public Iterator<SelectObjectContentEvent> getEventsIterator()
    throws SelectObjectContentEventException
  {
    readOptionChosen();
    return new SelectEventIterator(null);
  }
  
  public SelectRecordsInputStream getRecordsInputStream()
    throws SelectObjectContentEventException
  {
    getRecordsInputStream(new SelectObjectContentEventVisitor() {});
  }
  
  public SelectRecordsInputStream getRecordsInputStream(SelectObjectContentEventVisitor listener)
    throws SelectObjectContentEventException
  {
    InputStream recordInputStream = new SequenceInputStream(new EventStreamEnumeration(getEventsIterator(), listener, null));
    
    recordInputStream = ReleasableInputStream.wrap(recordInputStream).disableClose();
    
    return new SelectRecordsInputStream(recordInputStream, inputStream);
  }
  
  public void abort()
  {
    inputStream.abort();
  }
  
  public void close()
    throws IOException
  {
    inputStream.close();
  }
  
  private void readOptionChosen()
  {
    if (readOptionChosen) {
      throw new IllegalStateException("Reading of the select event stream was already started by another method.");
    }
    readOptionChosen = true;
  }
  
  private class SelectEventIterator
    extends SelectObjectContentEventStream.LazyLoadedIterator<SelectObjectContentEvent>
  {
    private SelectEventIterator()
    {
      super(null);
    }
    
    private final MessageDecoder decoder = new MessageDecoder();
    
    protected Collection<SelectObjectContentEvent> getNext()
      throws IOException
    {
      List<SelectObjectContentEvent> next = new ArrayList();
      byte[] payload = new byte['Ā'];
      while (next.isEmpty())
      {
        int read = inputStream.read(payload);
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
  
  private class EventStreamEnumeration
    extends SelectObjectContentEventStream.LazyLoadedIterator<InputStream>
    implements Enumeration<InputStream>
  {
    private final Iterator<SelectObjectContentEvent> selectEventIterator;
    private final SelectObjectContentEventVisitor additionalVisitor;
    private boolean initialized = false;
    
    private EventStreamEnumeration(SelectObjectContentEventVisitor selectEventIterator)
    {
      super(null);
      this.selectEventIterator = selectEventIterator;
      this.additionalVisitor = additionalVisitor;
    }
    
    protected Collection<? extends InputStream> getNext()
    {
      if (!initialized)
      {
        initialized = true;
        return Collections.singleton(SelectObjectContentEventStream.EMPTY_INPUT_STREAM);
      }
      final Collection<InputStream> result = new ArrayList();
      while (selectEventIterator.hasNext())
      {
        SelectObjectContentEvent event = (SelectObjectContentEvent)selectEventIterator.next();
        
        event.visit(additionalVisitor);
        
        event.visit(new SelectObjectContentEventVisitor()
        {
          public void visit(SelectObjectContentEvent.RecordsEvent event)
          {
            ByteBuffer records = event.getPayload();
            if (records != null) {
              result.add(new ByteArrayInputStream(BinaryUtils.copyBytesFrom(records)));
            }
          }
        });
        if (!result.isEmpty()) {
          return result;
        }
      }
      return result;
    }
    
    public boolean hasMoreElements()
    {
      return super.hasNext();
    }
    
    public InputStream nextElement()
    {
      return (InputStream)super.next();
    }
  }
  
  private abstract class LazyLoadedIterator<T>
    implements Iterator<T>
  {
    private final Queue<T> next = new ArrayDeque();
    private boolean isDone = false;
    
    private LazyLoadedIterator() {}
    
    public boolean hasNext()
    {
      advanceIfNeeded();
      return !isDone;
    }
    
    public T next()
    {
      advanceIfNeeded();
      if (isDone) {
        throw new NoSuchElementException();
      }
      return (T)next.poll();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
    
    private void advanceIfNeeded()
    {
      if ((!isDone) && (next.isEmpty())) {
        try
        {
          next.addAll(getNext());
          isDone = next.isEmpty();
        }
        catch (IOException e)
        {
          throw new SelectObjectContentEventException("Failed to read S3 select event.", e);
        }
      }
    }
    
    protected abstract Collection<? extends T> getNext()
      throws IOException;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */