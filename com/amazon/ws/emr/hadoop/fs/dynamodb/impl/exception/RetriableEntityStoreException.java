package com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception;

public class RetriableEntityStoreException
  extends RuntimeException
{
  private EntityStoreExceptionCode entityStoreExceptionCode;
  
  public RetriableEntityStoreException(EntityStoreExceptionCode entityStoreExceptionCode)
  {
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public RetriableEntityStoreException(String message, EntityStoreExceptionCode entityStoreExceptionCode)
  {
    super(message);
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public RetriableEntityStoreException(Throwable e, EntityStoreExceptionCode entityStoreExceptionCode)
  {
    super(e);
    this.entityStoreExceptionCode = entityStoreExceptionCode;
  }
  
  public RetriableEntityStoreException(String message, Throwable e, EntityStoreExceptionCode entityStoreExceptionCode)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */