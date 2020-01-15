package com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception;

public class EntityStoreException
  extends RuntimeException
{
  private EntityStoreExceptionCode entityStoreExceptionCode;
  
  public EntityStoreException(EntityStoreExceptionCode entityStoreExceptionCode)
  {
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public EntityStoreException(String message, EntityStoreExceptionCode entityStoreExceptionCode)
  {
    super(message);
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public EntityStoreException(Throwable e, EntityStoreExceptionCode entityStoreExceptionCode)
  {
    super(e);
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public EntityStoreException(String message, Throwable e, EntityStoreExceptionCode entityStoreExceptionCode)
  {
    super(message, e);
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public EntityStoreExceptionCode getEntityStoreExceptionCode()
  {
    return entityStoreExceptionCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */