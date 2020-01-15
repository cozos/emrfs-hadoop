package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlan;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import com.amazon.ws.emr.hadoop.fs.util.Sleeper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Progressable;

public class MultipartUploadManager$Builder
{
  private MultipartUploadManager multipartUpload;
  
  public MultipartUploadManager$Builder()
  {
    multipartUpload = new MultipartUploadManager();
  }
  
  public Builder withServerSideEncryptionAlgorithm(String s)
  {
    MultipartUploadManager.access$002(multipartUpload, s);
    return this;
  }
  
  public Builder withServerSideKmsKeyId(String serverSideEncryptionKmsKeyId)
  {
    MultipartUploadManager.access$102(multipartUpload, serverSideEncryptionKmsKeyId);
    return this;
  }
  
  public Builder withUploadPlan(UploadPlan uploadPlan)
  {
    MultipartUploadManager.access$202(multipartUpload, uploadPlan);
    return this;
  }
  
  public Builder withUploadId(String s)
  {
    MultipartUploadManager.access$302(multipartUpload, s);
    return this;
  }
  
  public Builder withProgressable(Progressable progressable)
  {
    MultipartUploadManager.access$402(multipartUpload, progressable);
    return this;
  }
  
  @VisibleForTesting
  Builder withS3(AmazonS3Lite s3, int maxRetries)
  {
    MultipartUploadManager.access$502(multipartUpload, EmrFsUtils.getAmazonS3LiteWithRetryPolicy(s3, maxRetries));
    return this;
  }
  
  public Builder withS3(AmazonS3Lite s3)
  {
    MultipartUploadManager.access$502(multipartUpload, EmrFsUtils.getAmazonS3LiteWithRetryPolicy(s3));
    return this;
  }
  
  public Builder withExecutorService(ListeningExecutorService executorService)
  {
    MultipartUploadManager.access$602(multipartUpload, executorService);
    return this;
  }
  
  public Builder withConf(Configuration conf)
  {
    MultipartUploadManager.access$702(multipartUpload, conf);
    MultipartUploadManager.access$800(multipartUpload, conf);
    return this;
  }
  
  public Builder withMaxPartSize(long maxPartSize)
  {
    MultipartUploadManager.access$902(multipartUpload, maxPartSize);
    return this;
  }
  
  public Builder withTemporaryFiles(TemporaryFiles temporaryFiles)
  {
    MultipartUploadManager.access$1002(multipartUpload, temporaryFiles);
    return this;
  }
  
  @VisibleForTesting
  Builder withSleeper(Sleeper sleeper)
  {
    MultipartUploadManager.access$1102(multipartUpload, sleeper);
    return this;
  }
  
  public MultipartUploadManager build()
  {
    MultipartUploadManager newMultipartUpload = new MultipartUploadManager();
    MultipartUploadManager.access$002(newMultipartUpload, MultipartUploadManager.access$000(multipartUpload));
    MultipartUploadManager.access$102(newMultipartUpload, MultipartUploadManager.access$100(multipartUpload));
    MultipartUploadManager.access$302(newMultipartUpload, MultipartUploadManager.access$300(multipartUpload));
    MultipartUploadManager.access$402(newMultipartUpload, MultipartUploadManager.access$400(multipartUpload));
    MultipartUploadManager.access$202(newMultipartUpload, MultipartUploadManager.access$200(multipartUpload));
    MultipartUploadManager.access$502(newMultipartUpload, MultipartUploadManager.access$500(multipartUpload));
    MultipartUploadManager.access$602(newMultipartUpload, MultipartUploadManager.access$600(multipartUpload));
    MultipartUploadManager.access$1202(newMultipartUpload, MultipartUploadManager.access$1200(multipartUpload));
    MultipartUploadManager.access$1302(newMultipartUpload, MultipartUploadManager.access$1300(multipartUpload));
    MultipartUploadManager.access$1402(newMultipartUpload, MultipartUploadManager.access$1400(multipartUpload));
    MultipartUploadManager.access$902(newMultipartUpload, MultipartUploadManager.access$900(multipartUpload));
    MultipartUploadManager.access$702(newMultipartUpload, MultipartUploadManager.access$700(multipartUpload));
    MultipartUploadManager.access$1002(newMultipartUpload, MultipartUploadManager.access$1000(multipartUpload));
    MultipartUploadManager.access$1102(newMultipartUpload, MultipartUploadManager.access$1100(multipartUpload));
    return newMultipartUpload;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartUploadManager.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */