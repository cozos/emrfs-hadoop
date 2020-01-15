package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

public class PresignedUrlUploadRequest
  extends AmazonWebServiceRequest
  implements S3DataSource, Serializable
{
  private static final long serialVersionUID = 1L;
  private URL presignedUrl;
  private HttpMethodName httpMethodName = HttpMethodName.PUT;
  private File file;
  private transient InputStream inputStream;
  private ObjectMetadata metadata;
  
  public PresignedUrlUploadRequest(URL presignedUrl)
  {
    this.presignedUrl = presignedUrl;
  }
  
  public URL getPresignedUrl()
  {
    return presignedUrl;
  }
  
  public void setPresignedUrl(URL presignedUrl)
  {
    this.presignedUrl = presignedUrl;
  }
  
  public PresignedUrlUploadRequest withPresignedUrl(URL presignedUrl)
  {
    setPresignedUrl(presignedUrl);
    return this;
  }
  
  public HttpMethodName getHttpMethodName()
  {
    return httpMethodName;
  }
  
  public void setHttpMethodName(HttpMethodName httpMethodName)
  {
    this.httpMethodName = httpMethodName;
  }
  
  public PresignedUrlUploadRequest withHttpMethodName(HttpMethodName httpMethodName)
  {
    setHttpMethodName(httpMethodName);
    return this;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public void setFile(File file)
  {
    this.file = file;
  }
  
  public PresignedUrlUploadRequest withFile(File file)
  {
    setFile(file);
    return this;
  }
  
  public InputStream getInputStream()
  {
    return inputStream;
  }
  
  public void setInputStream(InputStream inputStream)
  {
    this.inputStream = inputStream;
  }
  
  public PresignedUrlUploadRequest withInputStream(InputStream inputStream)
  {
    setInputStream(inputStream);
    return this;
  }
  
  public ObjectMetadata getMetadata()
  {
    return metadata;
  }
  
  public void setMetadata(ObjectMetadata metadata)
  {
    this.metadata = metadata;
  }
  
  public PresignedUrlUploadRequest withMetadata(ObjectMetadata metadata)
  {
    setMetadata(metadata);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */