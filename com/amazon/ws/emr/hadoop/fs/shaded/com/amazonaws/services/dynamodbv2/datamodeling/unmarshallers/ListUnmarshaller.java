package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ListUnmarshaller
  extends LUnmarshaller
{
  private static final ListUnmarshaller INSTANCE = new ListUnmarshaller();
  private final ArgumentUnmarshaller memberUnmarshaller;
  
  public static ListUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  private ListUnmarshaller()
  {
    memberUnmarshaller = null;
  }
  
  public ListUnmarshaller(ArgumentUnmarshaller memberUnmarshaller)
  {
    if (memberUnmarshaller == null) {
      throw new NullPointerException("memberUnmarshaller");
    }
    this.memberUnmarshaller = memberUnmarshaller;
  }
  
  public Object unmarshall(AttributeValue value)
    throws ParseException
  {
    List<AttributeValue> values = value.getL();
    List<Object> objects = new ArrayList(values.size());
    for (AttributeValue v : values)
    {
      memberUnmarshaller.typeCheck(v, null);
      objects.add(memberUnmarshaller.unmarshall(v));
    }
    return objects;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ListUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */