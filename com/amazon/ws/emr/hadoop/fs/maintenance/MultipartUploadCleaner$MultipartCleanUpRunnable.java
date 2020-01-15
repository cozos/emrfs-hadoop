package com.amazon.ws.emr.hadoop.fs.maintenance;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.time.Duration;
import java.util.Date;
import org.slf4j.Logger;

@VisibleForTesting
class MultipartUploadCleaner$MultipartCleanUpRunnable
  implements Runnable
{
  private final String bucketName;
  private final String prefix;
  private final Duration nextRoundDelay;
  private final int multipartListingPageSize;
  private Date cleanBefore;
  private MultipartUploadListing uploadListing;
  
  public MultipartUploadCleaner$MultipartCleanUpRunnable(MultipartUploadCleaner this$0, String bucketName, String prefix, Duration nextRoundDelay, int multipartListingPageSize)
  {
    this.bucketName = bucketName;this.prefix = prefix;this.nextRoundDelay = nextRoundDelay;this.multipartListingPageSize = multipartListingPageSize;
  }
  
  MultipartUploadCleaner$MultipartCleanUpRunnable(MultipartUploadCleaner this$0, String bucketName)
  {
    this(this$0, bucketName, null, cleanerThreadFixedDelay, 1000);
  }
  
  private void scheduleNextCleanupRound()
  {
    MultipartUploadCleaner.access$000().debug("Scheduling next cleanup round for bucket {} in approximately {} seconds", bucketName, 
      Long.valueOf(nextRoundDelay.getSeconds()));
    cleanBefore = null;
    uploadListing = null;
    MultipartUploadCleaner.access$100(this$0, nextRoundDelay, this);
  }
  
  private void scheduleNextPageCleanup()
  {
    MultipartUploadCleaner.access$000().debug("Scheduling cleanup for next page of multipart uploads for bucket {} in approximately 0 seconds", bucketName);
    
    MultipartUploadCleaner.access$100(this$0, Duration.ZERO, this);
  }
  
  public void run()
  {
    try
    {
      if (cleanBefore == null) {
        cleanBefore = new Date(new Date().getTime() - MultipartUploadCleaner.access$200(this$0).toMillis());
      }
      if (uploadListing == null)
      {
        MultipartUploadCleaner.access$000().debug("Cleaning multipart uploads before {} for bucket {}", cleanBefore, bucketName);
        uploadListing = MultipartUploadCleaner.access$300(this$0).listMultipartUploads(newListMultipartUploadsRequest());
      }
      else
      {
        MultipartUploadCleaner.access$000().debug("Cleaning next page of multipart uploads before {} for bucket {}", cleanBefore, bucketName);
        
        ListMultipartUploadsRequest request = newListMultipartUploadsRequest().withKeyMarker(uploadListing.getNextKeyMarker()).withUploadIdMarker(uploadListing.getNextUploadIdMarker());
        uploadListing = MultipartUploadCleaner.access$300(this$0).listMultipartUploads(request);
      }
      this$0.abortMultipartUploads(uploadListing.getMultipartUploads(), cleanBefore, bucketName);
      if (uploadListing.isTruncated()) {
        scheduleNextPageCleanup();
      } else {
        scheduleNextCleanupRound();
      }
    }
    catch (Exception ex)
    {
      MultipartUploadCleaner.access$400(this$0, "Exception caught while clearing multipart uploads", ex);
      
      scheduleNextCleanupRound();
    }
  }
  
  private ListMultipartUploadsRequest newListMultipartUploadsRequest()
  {
    return 
    
      new ListMultipartUploadsRequest(bucketName).withPrefix(prefix).withMaxUploads(multipartListingPageSize);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.maintenance.MultipartUploadCleaner.MultipartCleanUpRunnable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */