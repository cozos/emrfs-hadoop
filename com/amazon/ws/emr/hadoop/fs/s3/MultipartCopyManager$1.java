package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import java.util.concurrent.Callable;
import org.slf4j.Logger;

class MultipartCopyManager$1
  implements Callable<String>
{
  MultipartCopyManager$1(MultipartCopyManager this$0, String paramString1, String paramString2, String paramString3, String paramString4, ObjectMetadata paramObjectMetadata) {}
  
  public String call()
    throws Exception
  {
    try
    {
      MultipartCopyManager.LOG.debug("Copying from '{}/{}' to '{}/{}' using s3 copy", new Object[] { val$srcBucketName, val$srcKey, val$dstBucketName, val$dstKey });
      
      CopyObjectRequest copyObjectRequest = MultipartCopyManager.access$1200(this$0).newCopyObjectRequest(val$srcBucketName, val$srcKey, val$dstBucketName, val$dstKey);
      if (MultipartCopyManager.access$1300(this$0) != null) {
        copyObjectRequest.setCannedAccessControlList(MultipartCopyManager.access$1300(this$0));
      }
      copyObjectRequest.setNewObjectMetadata(val$metadata);
      MultipartCopyManager.access$1400(this$0, copyObjectRequest);
      return val$dstKey;
    }
    catch (AmazonClientException e)
    {
      if (ConfigurationUtils.isClientSideEncryptionEnabled(MultipartCopyManager.access$1500(this$0))) {
        MultipartCopyManager.access$1600(this$0, val$dstBucketName, val$dstKey);
      }
      throw e;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */