package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Beta
@Immutable
public final class RemoveAction
  extends UpdateAction
{
  RemoveAction(PathOperand attr)
  {
    super("REMOVE", attr, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.RemoveAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */