package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;

@NotThreadSafe
public class TransactionLoadRequest
{
  private final List<Object> objectsToLoad;
  private final List<DynamoDBTransactionLoadExpression> objectLoadExpressions;
  
  public TransactionLoadRequest()
  {
    objectsToLoad = new ArrayList();
    objectLoadExpressions = new ArrayList();
  }
  
  public TransactionLoadRequest addLoad(Object key)
  {
    objectsToLoad.add(key);
    objectLoadExpressions.add(null);
    return this;
  }
  
  public TransactionLoadRequest addLoad(Object key, DynamoDBTransactionLoadExpression transactLoadExpression)
  {
    objectsToLoad.add(key);
    objectLoadExpressions.add(transactLoadExpression);
    return this;
  }
  
  public List<Object> getObjectsToLoad()
  {
    return objectsToLoad;
  }
  
  public List<DynamoDBTransactionLoadExpression> getObjectLoadExpressions()
  {
    return objectLoadExpressions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.TransactionLoadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */