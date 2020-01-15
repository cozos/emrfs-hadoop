package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;

public abstract interface ArgumentUnmarshaller
{
  public abstract void typeCheck(AttributeValue paramAttributeValue, Method paramMethod);
  
  public abstract Object unmarshall(AttributeValue paramAttributeValue)
    throws ParseException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */