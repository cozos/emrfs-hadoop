package com.amazon.ws.emr.hadoop.fs.s3;

import org.apache.hadoop.util.Progressable;

class S3FSOutputStream$2$1
  implements Runnable
{
  S3FSOutputStream$2$1(S3FSOutputStream.2 this$1) {}
  
  public void run()
  {
    S3FSOutputStream.access$000(this$1.this$0).progress();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3FSOutputStream.2.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */