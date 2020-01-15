package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public abstract class S3CryptoModule<T extends MultipartUploadContext>
{
  public abstract PutObjectResult putObjectSecurely(PutObjectRequest paramPutObjectRequest);
  
  public abstract S3Object getObjectSecurely(GetObjectRequest paramGetObjectRequest);
  
  public abstract ObjectMetadata getObjectSecurely(GetObjectRequest paramGetObjectRequest, File paramFile);
  
  public abstract CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest paramCompleteMultipartUploadRequest);
  
  public abstract InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest paramInitiateMultipartUploadRequest);
  
  public abstract UploadPartResult uploadPartSecurely(UploadPartRequest paramUploadPartRequest);
  
  public abstract CopyPartResult copyPartSecurely(CopyPartRequest paramCopyPartRequest);
  
  public abstract void abortMultipartUploadSecurely(AbortMultipartUploadRequest paramAbortMultipartUploadRequest);
  
  public abstract PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest paramPutInstructionFileRequest);
  
  public abstract void putLocalObjectSecurely(UploadObjectRequest paramUploadObjectRequest, String paramString, OutputStream paramOutputStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */