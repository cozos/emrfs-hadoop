package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import java.util.Date;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$CompleteMultipartUploadHandler
  extends AbstractSSEHandler
  implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult
{
  private CompleteMultipartUploadResult result;
  private AmazonS3Exception ase;
  private String hostId;
  private String requestId;
  private String errorCode;
  
  protected ServerSideEncryptionResult sseResult()
  {
    return result;
  }
  
  public Date getExpirationTime()
  {
    return result == null ? null : result.getExpirationTime();
  }
  
  public void setExpirationTime(Date expirationTime)
  {
    if (result != null) {
      result.setExpirationTime(expirationTime);
    }
  }
  
  public String getExpirationTimeRuleId()
  {
    return result == null ? null : result.getExpirationTimeRuleId();
  }
  
  public void setExpirationTimeRuleId(String expirationTimeRuleId)
  {
    if (result != null) {
      result.setExpirationTimeRuleId(expirationTimeRuleId);
    }
  }
  
  public void setVersionId(String versionId)
  {
    if (result != null) {
      result.setVersionId(versionId);
    }
  }
  
  public String getVersionId()
  {
    return result == null ? null : result.getVersionId();
  }
  
  public boolean isRequesterCharged()
  {
    return result == null ? false : result.isRequesterCharged();
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    if (result != null) {
      result.setRequesterCharged(isRequesterCharged);
    }
  }
  
  public CompleteMultipartUploadResult getCompleteMultipartUploadResult()
  {
    return result;
  }
  
  public AmazonS3Exception getAmazonS3Exception()
  {
    return ase;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if ((atTopLevel()) && 
      (name.equals("CompleteMultipartUploadResult"))) {
      result = new CompleteMultipartUploadResult();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (atTopLevel())
    {
      if ((name.equals("Error")) && 
        (ase != null))
      {
        ase.setErrorCode(errorCode);
        ase.setRequestId(requestId);
        ase.setExtendedRequestId(hostId);
      }
    }
    else if (in(new String[] { "CompleteMultipartUploadResult" }))
    {
      if (name.equals("Location")) {
        result.setLocation(getText());
      } else if (name.equals("Bucket")) {
        result.setBucketName(getText());
      } else if (name.equals("Key")) {
        result.setKey(getText());
      } else if (name.equals("ETag")) {
        result.setETag(ServiceUtils.removeQuotes(getText()));
      }
    }
    else if (in(new String[] { "Error" })) {
      if (name.equals("Code")) {
        errorCode = getText();
      } else if (name.equals("Message")) {
        ase = new AmazonS3Exception(getText());
      } else if (name.equals("RequestId")) {
        requestId = getText();
      } else if (name.equals("HostId")) {
        hostId = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CompleteMultipartUploadHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */