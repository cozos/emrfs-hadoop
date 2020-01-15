package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import java.util.Date;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$CopyObjectResultHandler
  extends AbstractSSEHandler
  implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult
{
  private final CopyObjectResult result = new CopyObjectResult();
  private String errorCode = null;
  private String errorMessage = null;
  private String errorRequestId = null;
  private String errorHostId = null;
  private boolean receivedErrorResponse = false;
  
  protected ServerSideEncryptionResult sseResult()
  {
    return result;
  }
  
  public Date getLastModified()
  {
    return result.getLastModifiedDate();
  }
  
  public String getVersionId()
  {
    return result.getVersionId();
  }
  
  public void setVersionId(String versionId)
  {
    result.setVersionId(versionId);
  }
  
  public Date getExpirationTime()
  {
    return result.getExpirationTime();
  }
  
  public void setExpirationTime(Date expirationTime)
  {
    result.setExpirationTime(expirationTime);
  }
  
  public String getExpirationTimeRuleId()
  {
    return result.getExpirationTimeRuleId();
  }
  
  public void setExpirationTimeRuleId(String expirationTimeRuleId)
  {
    result.setExpirationTimeRuleId(expirationTimeRuleId);
  }
  
  public String getETag()
  {
    return result.getETag();
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorHostId()
  {
    return errorHostId;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public String getErrorRequestId()
  {
    return errorRequestId;
  }
  
  public boolean isErrorResponse()
  {
    return receivedErrorResponse;
  }
  
  public boolean isRequesterCharged()
  {
    return result.isRequesterCharged();
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    result.setRequesterCharged(isRequesterCharged);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (atTopLevel()) {
      if ((name.equals("CopyObjectResult")) || (name.equals("CopyPartResult"))) {
        receivedErrorResponse = false;
      } else if (name.equals("Error")) {
        receivedErrorResponse = true;
      }
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (!in(new String[] { "CopyObjectResult" }))
    {
      if (!in(new String[] { "CopyPartResult" })) {}
    }
    else
    {
      if (name.equals("LastModified"))
      {
        result.setLastModifiedDate(ServiceUtils.parseIso8601Date(getText())); return;
      }
      if (!name.equals("ETag")) {
        return;
      }
      result.setETag(ServiceUtils.removeQuotes(getText())); return;
    }
    if (in(new String[] { "Error" })) {
      if (name.equals("Code")) {
        errorCode = getText();
      } else if (name.equals("Message")) {
        errorMessage = getText();
      } else if (name.equals("RequestId")) {
        errorRequestId = getText();
      } else if (name.equals("HostId")) {
        errorHostId = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.CopyObjectResultHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */