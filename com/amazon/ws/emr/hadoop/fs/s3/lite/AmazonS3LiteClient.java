package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.AbortMultipartUploadCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.CompleteMultipartUploadCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.CopyObjectCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.CopyPartCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.CreateBucketCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.DeleteObjectCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.DeleteObjectsCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.DoesBucketExistCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetBucketVersioningConfigurationCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetObjectCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetObjectMetadataCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.InitiateMultipartUploadCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListMultipartUploadsCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListObjectsV2Call;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListPartsCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListVersionsCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.PutObjectCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.SelectObjectContentCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.SetBucketVersioningConfigurationCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.UploadPartCall;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3Executor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;

class AmazonS3LiteClient<C extends AmazonS3>
  extends AbstractAmazonS3Lite
{
  private final S3Executor<C> executor;
  
  AmazonS3LiteClient(S3Executor<C> executor)
  {
    this.executor = executor;
  }
  
  public ListObjectsV2Result listObjectsV2(ListObjectsV2Request request)
    throws AmazonClientException
  {
    return (ListObjectsV2Result)invoke(new ListObjectsV2Call(request));
  }
  
  public VersionListing listVersions(ListVersionsRequest request)
    throws AmazonClientException
  {
    return (VersionListing)invoke(new ListVersionsCall(request));
  }
  
  public Bucket createBucket(CreateBucketRequest request)
    throws AmazonClientException
  {
    return (Bucket)invoke(new CreateBucketCall(request));
  }
  
  public boolean doesBucketExist(String bucketName)
    throws AmazonClientException
  {
    return ((Boolean)invoke(new DoesBucketExistCall(bucketName))).booleanValue();
  }
  
  public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest request)
    throws AmazonClientException
  {
    return (ObjectMetadata)invoke(new GetObjectMetadataCall(request));
  }
  
  public S3Object getObject(GetObjectRequest request, boolean shouldTryInitialTimeout)
    throws AmazonClientException
  {
    return (S3Object)invoke(new GetObjectCall(request), shouldTryInitialTimeout);
  }
  
  public PutObjectResult putObject(PutObjectRequest request)
    throws AmazonClientException
  {
    return (PutObjectResult)invoke(new PutObjectCall(request));
  }
  
  public CopyObjectResult copyObject(CopyObjectRequest request)
    throws AmazonClientException
  {
    return (CopyObjectResult)invoke(new CopyObjectCall(request));
  }
  
  public CopyPartResult copyPart(CopyPartRequest request)
    throws AmazonClientException
  {
    return (CopyPartResult)invoke(new CopyPartCall(request));
  }
  
  public void deleteObject(String bucketName, String key)
    throws AmazonClientException
  {
    invoke(new DeleteObjectCall(bucketName, key));
  }
  
  public DeleteObjectsResult deleteObjects(DeleteObjectsRequest request)
    throws AmazonClientException
  {
    return (DeleteObjectsResult)invoke(new DeleteObjectsCall(request));
  }
  
  public BucketVersioningConfiguration getBucketVersioningConfiguration(String bucket)
    throws AmazonClientException
  {
    return (BucketVersioningConfiguration)invoke(new GetBucketVersioningConfigurationCall(bucket));
  }
  
  public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest request)
    throws AmazonClientException
  {
    invoke(new SetBucketVersioningConfigurationCall(request));
  }
  
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest request)
    throws AmazonClientException
  {
    return (InitiateMultipartUploadResult)invoke(new InitiateMultipartUploadCall(request));
  }
  
  public UploadPartResult uploadPart(UploadPartRequest request)
    throws AmazonClientException
  {
    return (UploadPartResult)invoke(new UploadPartCall(request));
  }
  
  public PartListing listParts(ListPartsRequest request)
    throws AmazonClientException
  {
    return (PartListing)invoke(new ListPartsCall(request));
  }
  
  public void abortMultipartUpload(AbortMultipartUploadRequest request)
    throws AmazonClientException
  {
    invoke(new AbortMultipartUploadCall(request));
  }
  
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest request)
    throws AmazonClientException
  {
    return (CompleteMultipartUploadResult)invoke(new CompleteMultipartUploadCall(request));
  }
  
  public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest request)
    throws AmazonClientException
  {
    return (MultipartUploadListing)invoke(new ListMultipartUploadsCall(request));
  }
  
  public SelectObjectContentResult selectObjectContent(SelectObjectContentRequest request)
    throws AmazonClientException
  {
    return (SelectObjectContentResult)invoke(new SelectObjectContentCall(request));
  }
  
  protected <R> R invoke(S3Call<R, ? super C> call)
  {
    return (R)invoke(call, false);
  }
  
  /* Error */
  protected <R> R invoke(S3Call<R, ? super C> call, boolean shouldTryInitialTimeout)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 238	com/amazon/ws/emr/hadoop/fs/util/io/MoreCloseables:asCloseable	(Ljava/lang/Object;)Ljava/io/Closeable;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 16	com/amazon/ws/emr/hadoop/fs/s3/lite/AmazonS3LiteClient:executor	Lcom/amazon/ws/emr/hadoop/fs/s3/lite/executor/S3Executor;
    //   12: aload_1
    //   13: iload_2
    //   14: invokeinterface 243 3 0
    //   19: astore 5
    //   21: aload_3
    //   22: ifnull +35 -> 57
    //   25: aload 4
    //   27: ifnull +24 -> 51
    //   30: aload_3
    //   31: invokeinterface 248 1 0
    //   36: goto +21 -> 57
    //   39: astore 6
    //   41: aload 4
    //   43: aload 6
    //   45: invokevirtual 256	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   48: goto +9 -> 57
    //   51: aload_3
    //   52: invokeinterface 248 1 0
    //   57: aload 5
    //   59: areturn
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: aload 5
    //   68: athrow
    //   69: astore 7
    //   71: aload_3
    //   72: ifnull +35 -> 107
    //   75: aload 4
    //   77: ifnull +24 -> 101
    //   80: aload_3
    //   81: invokeinterface 248 1 0
    //   86: goto +21 -> 107
    //   89: astore 8
    //   91: aload 4
    //   93: aload 8
    //   95: invokevirtual 256	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   98: goto +9 -> 107
    //   101: aload_3
    //   102: invokeinterface 248 1 0
    //   107: aload 7
    //   109: athrow
    //   110: astore_3
    //   111: new 23	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/AmazonClientException
    //   114: dup
    //   115: ldc_w 258
    //   118: aload_3
    //   119: invokespecial 261	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/AmazonClientException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: athrow
    // Line number table:
    //   Java source line #188	-> byte code offset #0
    //   Java source line #189	-> byte code offset #8
    //   Java source line #190	-> byte code offset #21
    //   Java source line #189	-> byte code offset #57
    //   Java source line #188	-> byte code offset #60
    //   Java source line #190	-> byte code offset #69
    //   Java source line #191	-> byte code offset #111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	AmazonS3LiteClient<C>
    //   0	123	1	call	S3Call<R, ? super C>
    //   0	123	2	shouldTryInitialTimeout	boolean
    //   4	98	3	ignored	java.io.Closeable
    //   110	9	3	e	java.io.IOException
    //   6	86	4	localThrowable3	Throwable
    //   60	7	5	localThrowable1	Throwable
    //   60	7	5	localThrowable4	Throwable
    //   39	5	6	localThrowable	Throwable
    //   69	39	7	localObject2	Object
    //   89	5	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   30	36	39	java/lang/Throwable
    //   8	21	60	java/lang/Throwable
    //   8	21	69	finally
    //   60	71	69	finally
    //   80	86	89	java/lang/Throwable
    //   0	57	110	java/io/IOException
    //   60	110	110	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3LiteClient
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */