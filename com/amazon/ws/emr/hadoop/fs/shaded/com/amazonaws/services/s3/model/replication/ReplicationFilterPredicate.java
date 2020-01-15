package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

import java.io.Serializable;

public abstract class ReplicationFilterPredicate
  implements Serializable
{
  public abstract void accept(ReplicationPredicateVisitor paramReplicationPredicateVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilterPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */