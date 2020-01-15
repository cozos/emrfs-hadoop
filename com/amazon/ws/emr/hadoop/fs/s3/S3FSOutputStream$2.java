package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import java.util.concurrent.ExecutorService;
import org.apache.hadoop.util.Progressable;

class S3FSOutputStream$2
  implements ProgressListener
{
  S3FSOutputStream$2(S3FSOutputStream this$0) {}
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    S3FSOutputStream.access$100(this$0).submit(new Runnable()
    {
      public void run()
      {
        S3FSOutputStream.access$000(this$0).progress();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3FSOutputStream.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */