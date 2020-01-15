package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import org.apache.hadoop.util.Progressable;

class CSEMultipartUploadOutputStream$1
  implements ProgressListener
{
  CSEMultipartUploadOutputStream$1(CSEMultipartUploadOutputStream this$0) {}
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    CSEMultipartUploadOutputStream.access$000(this$0).progress();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEMultipartUploadOutputStream.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */