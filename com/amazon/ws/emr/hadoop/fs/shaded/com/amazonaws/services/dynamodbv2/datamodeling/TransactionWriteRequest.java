package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValuesOnConditionCheckFailure;
import java.util.ArrayList;
import java.util.List;

@NotThreadSafe
public class TransactionWriteRequest
{
  private final List<TransactionWriteOperation> transactionWriteOperations;
  private String idempotencyToken;
  
  public TransactionWriteRequest()
  {
    transactionWriteOperations = new ArrayList();
  }
  
  public TransactionWriteRequest addPut(Object object)
  {
    return addPut(object, null);
  }
  
  public TransactionWriteRequest addPut(Object object, DynamoDBTransactionWriteExpression transactionWriteExpression)
  {
    return addPut(object, transactionWriteExpression, null);
  }
  
  public TransactionWriteRequest addPut(Object object, DynamoDBTransactionWriteExpression transactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    transactionWriteOperations.add(new TransactionWriteOperation(object, TransactionWriteOperationType.Put, transactionWriteExpression, returnValuesOnConditionCheckFailure));
    return this;
  }
  
  public TransactionWriteRequest addUpdate(Object object)
  {
    return addUpdate(object, null);
  }
  
  public TransactionWriteRequest addUpdate(Object object, DynamoDBTransactionWriteExpression transactionWriteExpression)
  {
    return addUpdate(object, transactionWriteExpression, null);
  }
  
  public TransactionWriteRequest addUpdate(Object object, DynamoDBTransactionWriteExpression transactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    transactionWriteOperations.add(new TransactionWriteOperation(object, TransactionWriteOperationType.Update, transactionWriteExpression, returnValuesOnConditionCheckFailure));
    return this;
  }
  
  public TransactionWriteRequest addDelete(Object key)
  {
    return addDelete(key, null);
  }
  
  public TransactionWriteRequest addDelete(Object key, DynamoDBTransactionWriteExpression transactionWriteExpression)
  {
    return addDelete(key, transactionWriteExpression, null);
  }
  
  public TransactionWriteRequest addDelete(Object key, DynamoDBTransactionWriteExpression transactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    transactionWriteOperations.add(new TransactionWriteOperation(key, TransactionWriteOperationType.Delete, transactionWriteExpression, returnValuesOnConditionCheckFailure));
    return this;
  }
  
  public TransactionWriteRequest addConditionCheck(Object key, DynamoDBTransactionWriteExpression transactionWriteExpression)
  {
    return addConditionCheck(key, transactionWriteExpression, null);
  }
  
  public TransactionWriteRequest addConditionCheck(Object key, DynamoDBTransactionWriteExpression transactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
  {
    transactionWriteOperations.add(new TransactionWriteOperation(key, TransactionWriteOperationType.ConditionCheck, transactionWriteExpression, returnValuesOnConditionCheckFailure));
    return this;
  }
  
  public TransactionWriteRequest withIdempotencyToken(String idempotencyToken)
  {
    this.idempotencyToken = idempotencyToken;
    return this;
  }
  
  public List<TransactionWriteOperation> getTransactionWriteOperations()
  {
    return transactionWriteOperations;
  }
  
  public String getIdempotencyToken()
  {
    return idempotencyToken;
  }
  
  public static class TransactionWriteOperation
  {
    private Object object;
    private TransactionWriteRequest.TransactionWriteOperationType transactionWriteOperationType;
    private DynamoDBTransactionWriteExpression dynamoDBTransactionWriteExpression;
    private ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure;
    
    public TransactionWriteOperation(Object object, TransactionWriteRequest.TransactionWriteOperationType transactionWriteOperationType, DynamoDBTransactionWriteExpression dynamoDBTransactionWriteExpression, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure)
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
  
  public static enum TransactionWriteOperationType
  {
    Put,  Update,  ConditionCheck,  Delete;
    
    private TransactionWriteOperationType() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */