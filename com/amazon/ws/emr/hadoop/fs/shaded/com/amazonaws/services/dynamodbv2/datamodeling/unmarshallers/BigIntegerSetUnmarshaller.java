package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class BigIntegerSetUnmarshaller
  extends NSUnmarshaller
{
  private static final BigIntegerSetUnmarshaller INSTANCE = new BigIntegerSetUnmarshaller();
  
  public static BigIntegerSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<BigInteger> result = new HashSet();
    for (String s : value.getNS()) {
      result.add(new BigInteger(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigIntegerSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */