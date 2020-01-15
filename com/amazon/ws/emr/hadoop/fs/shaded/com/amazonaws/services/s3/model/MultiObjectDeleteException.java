package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiObjectDeleteException
  extends AmazonS3Exception
  implements Serializable
{
  private static final long serialVersionUID = -2004213552302446866L;
  private final List<DeleteError> errors = new ArrayList();
  private final List<DeleteObjectsResult.DeletedObject> deletedObjects = new ArrayList();
  
  public MultiObjectDeleteException(Collection<DeleteError> errors, Collection<DeleteObjectsResult.DeletedObject> deletedObjects)
  {
    super("One or more objects could not be deleted");
    this.deletedObjects.addAll(deletedObjects);
    this.errors.addAll(errors);
  }
  
  public String getErrorCode()
  {
    return super.getErrorCode();
  }
  
  public List<DeleteObjectsResult.DeletedObject> getDeletedObjects()
  {
    return deletedObjects;
  }
  
  public List<DeleteError> getErrors()
  {
    return errors;
  }
  
  public static class DeleteError
    implements Serializable
  {
    private String key;
    private String versionId;
    private String code;
    private String message;
    
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
    
    public String getCode()
    {
      return code;
    }
    
    public void setCode(String code)
    {
      this.code = code;
    }
    
    public String getMessage()
    {
      return message;
    }
    
    public void setMessage(String message)
    {
      this.message = message;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */