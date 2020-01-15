package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BigDecimalSetUnmarshaller
  extends NSUnmarshaller
{
  private static final BigDecimalSetUnmarshaller INSTANCE = new BigDecimalSetUnmarshaller();
  
  public static BigDecimalSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<BigDecimal> result = new HashSet();
    for (String s : value.getNS()) {
      result.add(new BigDecimal(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BigDecimalSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */