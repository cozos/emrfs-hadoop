package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Collection;

class SelectObjectContentEventStream$EventStreamEnumeration$1
  extends SelectObjectContentEventVisitor
{
  SelectObjectContentEventStream$EventStreamEnumeration$1(SelectObjectContentEventStream.EventStreamEnumeration this$1, Collection paramCollection) {}
  
  public void visit(SelectObjectContentEvent.RecordsEvent event)
  {
    ByteBuffer records = event.getPayload();
    if (records != null) {
      val$result.add(new ByteArrayInputStream(BinaryUtils.copyBytesFrom(records)));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream.EventStreamEnumeration.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */