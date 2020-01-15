package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.s3.lite.S3Constants;
import com.amazon.ws.emr.hadoop.fs.s3.lite.exception.RepeatS3CallException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.util.io.RestartableInputStream;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class AbstractUploadingS3Call<O, I extends AmazonWebServiceRequest, C extends AmazonS3>
  implements S3Call<O, C>, Closeable
{
  private final RestartableInputStream inputStream;
  private final I request;
  
  protected AbstractUploadingS3Call(I request)
  {
    inputStream = wrapInputStreamIfPresent(request);
    this.request = replaceInputStream(request, inputStream);
  }
  
  public String getBucketName()
  {
    return getBucketName(request);
  }
  
  public O perform(C client)
  {
    if (inputStream != null) {
      try
      {
        inputStream.restart();
      }
      catch (IOException e)
      {
        throw new RepeatS3CallException("Cannot restart input stream for S3 call", e);
      }
    }
    return (O)performCall(client, request);
  }
  
  public void close()
    throws IOException
  {
    if (inputStream != null) {
      inputStream.release();
    }
  }
  
  protected abstract String getBucketName(I paramI);
  
  protected abstract String getKey(I paramI);
  
  protected abstract InputStream getInputStream(I paramI);
  
  protected abstract I cloneWithInputStream(I paramI, InputStream paramInputStream);
  
  protected abstract O performCall(C paramC, I paramI);
  
  private RestartableInputStream wrapInputStreamIfPresent(I request)
  {
    InputStream in = getInputStream(request);
    if (in == null) {
      return null;
    }
    return new RestartableInputStream(in, getReadLimit(request));
  }
  
  private I replaceInputStream(I request, InputStream in)
  {
    if (in == null) {
      return request;
    }
    return cloneWithInputStream(request, in);
  }
  
  private static int getReadLimit(AmazonWebServiceRequest request)
  {
    Integer s3StreamBufferSize = S3Constants.getS3StreamBufferSize();
    if (s3StreamBufferSize != null) {
      return s3StreamBufferSize.intValue();
    }
    return request.getRequestClientOptions().getReadLimit();
  }
  
  public void setCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    request.setRequestCredentialsProvider(credentialsProvider);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(getBucketName(request), getKey(request));
  }
  
  public void enableRequesterPays()
  {
    request.putCustomRequestHeader("x-amz-request-payer", "requester");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.AbstractUploadingS3Call
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */