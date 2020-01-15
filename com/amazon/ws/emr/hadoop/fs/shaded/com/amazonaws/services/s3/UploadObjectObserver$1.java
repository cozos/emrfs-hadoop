package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.util.concurrent.Callable;

class UploadObjectObserver$1
  implements Callable<UploadPartResult>
{
  UploadObjectObserver$1(UploadObjectObserver this$0, UploadPartRequest paramUploadPartRequest, File paramFile, OnFileDelete paramOnFileDelete) {}
  
  public UploadPartResult call()
  {
    try
    {
      return this$0.uploadPart(val$reqUploadPart);
    }
    finally
    {
      if (!val$part.delete()) {
        LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + val$part + " which has already been uploaded");
      } else if (val$fileDeleteObserver != null) {
        val$fileDeleteObserver.onFileDelete(null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.UploadObjectObserver.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */