package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CancelStepsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<CancelStepsInfo> cancelStepsInfoList;
  
  public List<CancelStepsInfo> getCancelStepsInfoList()
  {
    if (cancelStepsInfoList == null) {
      cancelStepsInfoList = new SdkInternalList();
    }
    return cancelStepsInfoList;
  }
  
  public void setCancelStepsInfoList(Collection<CancelStepsInfo> cancelStepsInfoList)
  {
    if (cancelStepsInfoList == null)
    {
      this.cancelStepsInfoList = null;
      return;
    }
    this.cancelStepsInfoList = new SdkInternalList(cancelStepsInfoList);
  }
  
  public CancelStepsResult withCancelStepsInfoList(CancelStepsInfo... cancelStepsInfoList)
  {
    if (this.cancelStepsInfoList == null) {
      setCancelStepsInfoList(new SdkInternalList(cancelStepsInfoList.length));
    }
    for (CancelStepsInfo ele : cancelStepsInfoList) {
      this.cancelStepsInfoList.add(ele);
    }
    return this;
  }
  
  public CancelStepsResult withCancelStepsInfoList(Collection<CancelStepsInfo> cancelStepsInfoList)
  {
    setCancelStepsInfoList(cancelStepsInfoList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCancelStepsInfoList() != null) {
      sb.append("CancelStepsInfoList: ").append(getCancelStepsInfoList());
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
    if (!(obj instanceof CancelStepsResult)) {
      return false;
    }
    CancelStepsResult other = (CancelStepsResult)obj;
    if (((other.getCancelStepsInfoList() == null ? 1 : 0) ^ (getCancelStepsInfoList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCancelStepsInfoList() != null) && (!other.getCancelStepsInfoList().equals(getCancelStepsInfoList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCancelStepsInfoList() == null ? 0 : getCancelStepsInfoList().hashCode());
    return hashCode;
  }
  
  public CancelStepsResult clone()
  {
    try
    {
      return (CancelStepsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */