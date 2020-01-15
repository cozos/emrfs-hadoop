package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

@Deprecated
public abstract interface DynamoDBMarshaller<T>
{
  public abstract String marshall(T paramT);
  
  public abstract T unmarshall(Class<T> paramClass, String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */