package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResult
  implements Serializable, S3RequesterChargedResult
{
  private final List<DeletedObject> deletedObjects = new ArrayList();
  private boolean isRequesterCharged;
  
  public DeleteObjectsResult(List<DeletedObject> deletedObjects)
  {
    this(deletedObjects, false);
  }
  
  public DeleteObjectsResult(List<DeletedObject> deletedObjects, boolean isRequesterCharged)
  {
    this.deletedObjects.addAll(deletedObjects);
    setRequesterCharged(isRequesterCharged);
  }
  
  public List<DeletedObject> getDeletedObjects()
  {
    return deletedObjects;
  }
  
  public boolean isRequesterCharged()
  {
    return isRequesterCharged;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    this.isRequesterCharged = isRequesterCharged;
  }
  
  public static class DeletedObject
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */