package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

class S3ObjectWrapper
  implements Closeable
{
  private final S3Object s3obj;
  private final S3ObjectId id;
  
  S3ObjectWrapper(S3Object s3obj, S3ObjectId id)
  {
    if (s3obj == null) {
      throw new IllegalArgumentException();
    }
    this.s3obj = s3obj;
    this.id = id;
  }
  
  public S3ObjectId getS3ObjectId()
  {
    return id;
  }
  
  ObjectMetadata getObjectMetadata()
  {
    return s3obj.getObjectMetadata();
  }
  
  void setObjectMetadata(ObjectMetadata metadata)
  {
    s3obj.setObjectMetadata(metadata);
  }
  
  S3ObjectInputStream getObjectContent()
  {
    return s3obj.getObjectContent();
  }
  
  void setObjectContent(S3ObjectInputStream objectContent)
  {
    s3obj.setObjectContent(objectContent);
  }
  
  void setObjectContent(InputStream objectContent)
  {
    s3obj.setObjectContent(objectContent);
  }
  
  String getBucketName()
  {
    return s3obj.getBucketName();
  }
  
  void setBucketName(String bucketName)
  {
    s3obj.setBucketName(bucketName);
  }
  
  String getKey()
  {
    return s3obj.getKey();
  }
  
  void setKey(String key)
  {
    s3obj.setKey(key);
  }
  
  String getRedirectLocation()
  {
    return s3obj.getRedirectLocation();
  }
  
  void setRedirectLocation(String redirectLocation)
  {
    s3obj.setRedirectLocation(redirectLocation);
  }
  
  public String toString()
  {
    return s3obj.toString();
  }
  
  final boolean hasEncryptionInfo()
  {
    ObjectMetadata metadata = s3obj.getObjectMetadata();
    Map<String, String> userMeta = metadata.getUserMetadata();
    return (userMeta != null) && 
      (userMeta.containsKey("x-amz-iv")) && (
      (userMeta.containsKey("x-amz-key-v2")) || 
      (userMeta.containsKey("x-amz-key")));
  }
  
  String toJsonString()
  {
    try
    {
      return from(s3obj.getObjectContent());
    }
    catch (Exception e)
    {
      throw new SdkClientException("Error parsing JSON: " + e.getMessage());
    }
  }
  
  private static String from(InputStream is)
    throws IOException
  {
    if (is == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is, StringUtils.UTF8));
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    }
    finally
    {
      is.close();
    }
    return sb.toString();
  }
  
  public void close()
    throws IOException
  {
    s3obj.close();
  }
  
  S3Object getS3Object()
  {
    return s3obj;
  }
  
  ContentCryptoScheme encryptionSchemeOf(Map<String, String> instructionFile)
  {
    if (instructionFile != null)
    {
      String cekAlgo = (String)instructionFile.get("x-amz-cek-alg");
      return ContentCryptoScheme.fromCEKAlgo(cekAlgo);
    }
    ObjectMetadata meta = s3obj.getObjectMetadata();
    Map<String, String> userMeta = meta.getUserMetadata();
    String cekAlgo = (String)userMeta.get("x-amz-cek-alg");
    return ContentCryptoScheme.fromCEKAlgo(cekAlgo);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3ObjectWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */