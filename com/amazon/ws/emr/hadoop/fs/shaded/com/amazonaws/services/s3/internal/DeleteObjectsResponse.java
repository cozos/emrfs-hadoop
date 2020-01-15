package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResponse
  implements S3RequesterChargedResult
{
  private List<DeleteObjectsResult.DeletedObject> deletedObjects;
  private List<MultiObjectDeleteException.DeleteError> errors;
  private boolean isRequesterCharged;
  
  public DeleteObjectsResponse()
  {
    this(new ArrayList(), new ArrayList());
  }
  
  public DeleteObjectsResponse(List<DeleteObjectsResult.DeletedObject> deletedObjects, List<MultiObjectDeleteException.DeleteError> errors)
  {
    this.deletedObjects = deletedObjects;
    this.errors = errors;
  }
  
  public List<DeleteObjectsResult.DeletedObject> getDeletedObjects()
  {
    return deletedObjects;
  }
  
  public void setDeletedObjects(List<DeleteObjectsResult.DeletedObject> deletedObjects)
  {
    this.deletedObjects = deletedObjects;
  }
  
  public List<MultiObjectDeleteException.DeleteError> getErrors()
  {
    return errors;
  }
  
  public void setErrors(List<MultiObjectDeleteException.DeleteError> errors)
  {
    this.errors = errors;
  }
  
  public boolean isRequesterCharged()
  {
    return isRequesterCharged;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    this.isRequesterCharged = isRequesterCharged;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */