package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeleteMessageBatchResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<DeleteMessageBatchResultEntry> successful;
  private SdkInternalList<BatchResultErrorEntry> failed;
  
  public List<DeleteMessageBatchResultEntry> getSuccessful()
  {
    if (successful == null) {
      successful = new SdkInternalList();
    }
    return successful;
  }
  
  public void setSuccessful(Collection<DeleteMessageBatchResultEntry> successful)
  {
    if (successful == null)
    {
      this.successful = null;
      return;
    }
    this.successful = new SdkInternalList(successful);
  }
  
  public DeleteMessageBatchResult withSuccessful(DeleteMessageBatchResultEntry... successful)
  {
    if (this.successful == null) {
      setSuccessful(new SdkInternalList(successful.length));
    }
    for (DeleteMessageBatchResultEntry ele : successful) {
      this.successful.add(ele);
    }
    return this;
  }
  
  public DeleteMessageBatchResult withSuccessful(Collection<DeleteMessageBatchResultEntry> successful)
  {
    setSuccessful(successful);
    return this;
  }
  
  public List<BatchResultErrorEntry> getFailed()
  {
    if (failed == null) {
      failed = new SdkInternalList();
    }
    return failed;
  }
  
  public void setFailed(Collection<BatchResultErrorEntry> failed)
  {
    if (failed == null)
    {
      this.failed = null;
      return;
    }
    this.failed = new SdkInternalList(failed);
  }
  
  public DeleteMessageBatchResult withFailed(BatchResultErrorEntry... failed)
  {
    if (this.failed == null) {
      setFailed(new SdkInternalList(failed.length));
    }
    for (BatchResultErrorEntry ele : failed) {
      this.failed.add(ele);
    }
    return this;
  }
  
  public DeleteMessageBatchResult withFailed(Collection<BatchResultErrorEntry> failed)
  {
    setFailed(failed);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSuccessful() != null) {
      sb.append("Successful: ").append(getSuccessful()).append(",");
    }
    if (getFailed() != null) {
      sb.append("Failed: ").append(getFailed());
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
    if (!(obj instanceof DeleteMessageBatchResult)) {
      return false;
    }
    DeleteMessageBatchResult other = (DeleteMessageBatchResult)obj;
    if (((other.getSuccessful() == null ? 1 : 0) ^ (getSuccessful() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSuccessful() != null) && (!other.getSuccessful().equals(getSuccessful()))) {
      return false;
    }
    if (((other.getFailed() == null ? 1 : 0) ^ (getFailed() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFailed() != null) && (!other.getFailed().equals(getFailed()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSuccessful() == null ? 0 : getSuccessful().hashCode());
    hashCode = 31 * hashCode + (getFailed() == null ? 0 : getFailed().hashCode());
    return hashCode;
  }
  
  public DeleteMessageBatchResult clone()
  {
    try
    {
      return (DeleteMessageBatchResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.DeleteMessageBatchResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */