package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValuesOnConditionCheckFailure;

public class TransactionWriteRequest$TransactionWriteOperation
{
  private Object object;
  private TransactionWriteRequest.TransactionWriteOperationType transactionWriteOperationType;
  private DynamoDBTransactionWriteExpression dynamoDBTransactionWriteExpression;
  private ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure;
  
  public TransactionWriteRequest$TransactionWriteOperation(Object object, TransactionWriteRequest.TransactionWriteOperationType transactionWriteOperationType, DynamoDBTransactionWriteExpression dynamoDBTransactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    this.object = object;
    this.transactionWriteOperationType = transactionWriteOperationType;
    this.dynamoDBTransactionWriteExpression = dynamoDBTransactionWriteExpression;
    this.returnValuesOnConditionCheckFailure = returnValuesOnConditionCheckFailure;
  }
  
  public Object getObject()
  {
    return object;
  }
  
  public TransactionWriteRequest.TransactionWriteOperationType getTransactionWriteOperationType()
  {
    return transactionWriteOperationType;
  }
  
  public DynamoDBTransactionWriteExpression getDynamoDBTransactionWriteExpression()
  {
    return dynamoDBTransactionWriteExpression;
  }
  
  public ReturnValuesOnConditionCheckFailure getReturnValuesOnConditionCheckFailure()
  {
    return returnValuesOnConditionCheckFailure;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest.TransactionWriteOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */