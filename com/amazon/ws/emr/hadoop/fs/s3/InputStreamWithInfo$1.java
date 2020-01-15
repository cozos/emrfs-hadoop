package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Progress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.EndEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.StatsEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Stats;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;

class InputStreamWithInfo$1
  extends SelectObjectContentEventVisitor
{
  InputStreamWithInfo$1(InputStreamWithInfo this$0, String paramString) {}
  
  public void visit(SelectObjectContentEvent.EndEvent event)
  {
    InputStreamWithInfo.LOG.debug("Select object content of '{}' received EndEvent", val$key);
    InputStreamWithInfo.access$000(this$0).set(true);
  }
  
  public void visit(SelectObjectContentEvent.ProgressEvent event)
  {
    InputStreamWithInfo.access$100(this$0).set(event.getDetails().getBytesScanned().longValue());
    InputStreamWithInfo.access$200(this$0).set(event.getDetails().getBytesReturned().longValue());
    InputStreamWithInfo.access$300(this$0);
  }
  
  public void visit(SelectObjectContentEvent.StatsEvent event)
  {
    InputStreamWithInfo.access$100(this$0).set(event.getDetails().getBytesScanned().longValue());
    InputStreamWithInfo.access$200(this$0).set(event.getDetails().getBytesReturned().longValue());
    InputStreamWithInfo.access$300(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfo.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */