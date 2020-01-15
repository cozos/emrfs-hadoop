package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class DeleteObjectsResult$DeletedObject
  implements Serializable
{
  private String key;
  private String versionId;
  private boolean deleteMarker;
  private String deleteMarkerVersionId;
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public boolean isDeleteMarker()
  {
    return deleteMarker;
  }
  
  public void setDeleteMarker(boolean deleteMarker)
  {
    this.deleteMarker = deleteMarker;
  }
  
  public String getDeleteMarkerVersionId()
  {
    return deleteMarkerVersionId;
  }
  
  public void setDeleteMarkerVersionId(String deleteMarkerVersionId)
  {
    this.deleteMarkerVersionId = deleteMarkerVersionId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */