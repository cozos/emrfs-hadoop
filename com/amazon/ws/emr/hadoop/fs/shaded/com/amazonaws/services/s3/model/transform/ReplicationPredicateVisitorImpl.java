package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationTagPredicate;

class ReplicationPredicateVisitorImpl
  implements ReplicationPredicateVisitor
{
  private final XmlWriter xml;
  
  public ReplicationPredicateVisitorImpl(XmlWriter xml)
  {
    this.xml = xml;
  }
  
  public void visit(ReplicationPrefixPredicate replicationPrefixPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writePrefix(xml, replicationPrefixPredicate.getPrefix());
  }
  
  public void visit(ReplicationTagPredicate replicationTagPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writeTag(xml, replicationTagPredicate.getTag());
  }
  
  public void visit(ReplicationAndOperator replicationAndOperator)
  {
    xml.start("And");
    for (ReplicationFilterPredicate predicate : replicationAndOperator.getOperands()) {
      predicate.accept(this);
    }
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ReplicationPredicateVisitorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */