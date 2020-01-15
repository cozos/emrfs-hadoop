package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

class SelectObjectContentEventStream$EventStreamEnumeration
  extends SelectObjectContentEventStream.LazyLoadedIterator<InputStream>
  implements Enumeration<InputStream>
{
  private final Iterator<SelectObjectContentEvent> selectEventIterator;
  private final SelectObjectContentEventVisitor additionalVisitor;
  private boolean initialized = false;
  
  private SelectObjectContentEventStream$EventStreamEnumeration(Iterator<SelectObjectContentEvent> arg1, SelectObjectContentEventVisitor selectEventIterator)
  {
    super(???, null);
    this.selectEventIterator = selectEventIterator;
    this.additionalVisitor = additionalVisitor;
  }
  
  protected Collection<? extends InputStream> getNext()
  {
    if (!initialized)
    {
      initialized = true;
      return Collections.singleton(SelectObjectContentEventStream.access$400());
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream.EventStreamEnumeration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */