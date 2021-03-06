package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Beta
@Immutable
public class NULL
  extends PathOperand
{
  NULL(String path)
  {
    super(path);
  }
  
  public final SetAction set()
  {
    return new SetAction(this, new LiteralOperand(null));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.NULL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */