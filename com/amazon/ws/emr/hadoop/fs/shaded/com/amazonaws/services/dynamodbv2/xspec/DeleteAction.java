package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;

@Beta
public final class DeleteAction
  extends UpdateAction
{
  DeleteAction(PathOperand attr, LiteralOperand value)
  {
    super("DELETE", attr, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.DeleteAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */