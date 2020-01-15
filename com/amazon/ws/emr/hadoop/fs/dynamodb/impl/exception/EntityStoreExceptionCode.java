package com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception;

public enum EntityStoreExceptionCode
{
  NONE,  ALREADY_EXISTS,  STALE_ENTITY,  INVALID_TABLE_ROLE,  AMAZON_CLIENT_EXCEPTION;
  
  private EntityStoreExceptionCode() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */