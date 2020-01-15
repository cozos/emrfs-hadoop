package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class DeleteObjectsCall
  extends AbstractS3GenericCall<DeleteObjectsResult, DeleteObjectsRequest>
{
  public DeleteObjectsCall(DeleteObjectsRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((DeleteObjectsRequest)request).getBucketName();
  }
  
  public DeleteObjectsResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.deleteObjects((DeleteObjectsRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    List<String> keys = new ArrayList();
    for (DeleteObjectsRequest.KeyVersion keyVersion : ((DeleteObjectsRequest)request).getKeys()) {
      keys.add(keyVersion.getKey());
    }
    return S3Resources.fromBucketAndKeys(((DeleteObjectsRequest)request).getBucketName(), keys);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.DeleteObjectsCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */