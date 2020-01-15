package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

public class GetCredentialReportResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ByteBuffer content;
  private String reportFormat;
  private Date generatedTime;
  
  public void setContent(ByteBuffer content)
  {
    this.content = content;
  }
  
  public ByteBuffer getContent()
  {
    return content;
  }
  
  public GetCredentialReportResult withContent(ByteBuffer content)
  {
    setContent(content);
    return this;
  }
  
  public void setReportFormat(String reportFormat)
  {
    this.reportFormat = reportFormat;
  }
  
  public String getReportFormat()
  {
    return reportFormat;
  }
  
  public GetCredentialReportResult withReportFormat(String reportFormat)
  {
    setReportFormat(reportFormat);
    return this;
  }
  
  public void setReportFormat(ReportFormatType reportFormat)
  {
    withReportFormat(reportFormat);
  }
  
  public GetCredentialReportResult withReportFormat(ReportFormatType reportFormat)
  {
    this.reportFormat = reportFormat.toString();
    return this;
  }
  
  public void setGeneratedTime(Date generatedTime)
  {
    this.generatedTime = generatedTime;
  }
  
  public Date getGeneratedTime()
  {
    return generatedTime;
  }
  
  public GetCredentialReportResult withGeneratedTime(Date generatedTime)
  {
    setGeneratedTime(generatedTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getContent() != null) {
      sb.append("Content: ").append(getContent()).append(",");
    }
    if (getReportFormat() != null) {
      sb.append("ReportFormat: ").append(getReportFormat()).append(",");
    }
    if (getGeneratedTime() != null) {
      sb.append("GeneratedTime: ").append(getGeneratedTime());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof GetCredentialReportResult)) {
      return false;
    }
    GetCredentialReportResult other = (GetCredentialReportResult)obj;
    if (((other.getContent() == null ? 1 : 0) ^ (getContent() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContent() != null) && (!other.getContent().equals(getContent()))) {
      return false;
    }
    if (((other.getReportFormat() == null ? 1 : 0) ^ (getReportFormat() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReportFormat() != null) && (!other.getReportFormat().equals(getReportFormat()))) {
      return false;
    }
    if (((other.getGeneratedTime() == null ? 1 : 0) ^ (getGeneratedTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGeneratedTime() != null) && (!other.getGeneratedTime().equals(getGeneratedTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getContent() == null ? 0 : getContent().hashCode());
    hashCode = 31 * hashCode + (getReportFormat() == null ? 0 : getReportFormat().hashCode());
    hashCode = 31 * hashCode + (getGeneratedTime() == null ? 0 : getGeneratedTime().hashCode());
    return hashCode;
  }
  
  public GetCredentialReportResult clone()
  {
    try
    {
      return (GetCredentialReportResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */