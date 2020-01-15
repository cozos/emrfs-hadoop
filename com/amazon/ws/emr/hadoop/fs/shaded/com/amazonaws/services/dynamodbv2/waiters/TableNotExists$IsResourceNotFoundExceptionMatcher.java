package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;

class TableNotExists$IsResourceNotFoundExceptionMatcher
  extends WaiterAcceptor<DescribeTableResult>
{
  public boolean matches(AmazonServiceException e)
  {
    return "ResourceNotFoundException".equals(e.getErrorCode());
  }
  
  public WaiterState getState()
  {
    return WaiterState.SUCCESS;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.TableNotExists.IsResourceNotFoundExceptionMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */