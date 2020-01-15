package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactionCanceledException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TransactionCanceledExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static TransactionCanceledExceptionUnmarshaller instance;
  
  private TransactionCanceledExceptionUnmarshaller()
  {
    super(TransactionCanceledException.class, "TransactionCanceledException");
  }
  
  public TransactionCanceledException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    TransactionCanceledException transactionCanceledException = new TransactionCanceledException(null);
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CancellationReasons", targetDepth))
        {
          context.nextToken();
          transactionCanceledException.setCancellationReasons(new ListUnmarshaller(
            CancellationReasonJsonUnmarshaller.getInstance()).unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return transactionCanceledException;
  }
  
  public static TransactionCanceledExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TransactionCanceledExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactionCanceledExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */