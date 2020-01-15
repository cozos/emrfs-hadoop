package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListBootstrapActionsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<Command> bootstrapActions;
  private String marker;
  
  public List<Command> getBootstrapActions()
  {
    if (bootstrapActions == null) {
      bootstrapActions = new SdkInternalList();
    }
    return bootstrapActions;
  }
  
  public void setBootstrapActions(Collection<Command> bootstrapActions)
  {
    if (bootstrapActions == null)
    {
      this.bootstrapActions = null;
      return;
    }
    this.bootstrapActions = new SdkInternalList(bootstrapActions);
  }
  
  public ListBootstrapActionsResult withBootstrapActions(Command... bootstrapActions)
  {
    if (this.bootstrapActions == null) {
      setBootstrapActions(new SdkInternalList(bootstrapActions.length));
    }
    for (Command ele : bootstrapActions) {
      this.bootstrapActions.add(ele);
    }
    return this;
  }
  
  public ListBootstrapActionsResult withBootstrapActions(Collection<Command> bootstrapActions)
  {
    setBootstrapActions(bootstrapActions);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListBootstrapActionsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBootstrapActions() != null) {
      sb.append("BootstrapActions: ").append(getBootstrapActions()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof ListBootstrapActionsResult)) {
      return false;
    }
    ListBootstrapActionsResult other = (ListBootstrapActionsResult)obj;
    if (((other.getBootstrapActions() == null ? 1 : 0) ^ (getBootstrapActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBootstrapActions() != null) && (!other.getBootstrapActions().equals(getBootstrapActions()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBootstrapActions() == null ? 0 : getBootstrapActions().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListBootstrapActionsResult clone()
  {
    try
    {
      return (ListBootstrapActionsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */