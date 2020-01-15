package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

public final class ReplicationTagPredicate
  extends ReplicationFilterPredicate
{
  private final Tag tag;
  
  public ReplicationTagPredicate(Tag tag)
  {
    this.tag = tag;
  }
  
  public Tag getTag()
  {
    return tag;
  }
  
  public void accept(ReplicationPredicateVisitor replicationPredicateVisitor)
  {
    replicationPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationTagPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */