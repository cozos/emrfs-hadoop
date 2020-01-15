package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;

public abstract interface S3DirectSpi
{
  public abstract PutObjectResult putObject(PutObjectRequest paramPutObjectRequest);
  
  public abstract S3Object getObject(GetObjectRequest paramGetObjectRequest);
  
  public abstract ObjectMetadata getObject(GetObjectRequest paramGetObjectRequest, File paramFile);
  
  public abstract CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest paramCompleteMultipartUploadRequest);
  
  public abstract InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest paramInitiateMultipartUploadRequest);
  
  public abstract UploadPartResult uploadPart(UploadPartRequest paramUploadPartRequest);
  
  public abstract CopyPartResult copyPart(CopyPartRequest paramCopyPartRequest);
  
  public abstract void abortMultipartUpload(AbortMultipartUploadRequest paramAbortMultipartUploadRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3DirectSpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */