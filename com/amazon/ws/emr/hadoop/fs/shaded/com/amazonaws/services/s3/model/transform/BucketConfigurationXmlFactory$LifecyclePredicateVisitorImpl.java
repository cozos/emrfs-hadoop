package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;

class BucketConfigurationXmlFactory$LifecyclePredicateVisitorImpl
  implements LifecyclePredicateVisitor
{
  private final XmlWriter xml;
  
  public BucketConfigurationXmlFactory$LifecyclePredicateVisitorImpl(BucketConfigurationXmlFactory paramBucketConfigurationXmlFactory, XmlWriter xml)
  {
    this.xml = xml;
  }
  
  public void visit(LifecyclePrefixPredicate lifecyclePrefixPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writePrefix(xml, lifecyclePrefixPredicate.getPrefix());
  }
  
  public void visit(LifecycleTagPredicate lifecycleTagPredicate)
  {
    BucketConfigurationXmlFactory.access$000(this$0, xml, lifecycleTagPredicate.getTag());
  }
  
  public void visit(LifecycleAndOperator lifecycleAndOperator)
  {
    xml.start("And");
    for (LifecycleFilterPredicate predicate : lifecycleAndOperator.getOperands()) {
      predicate.accept(this);
    }
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory.LifecyclePredicateVisitorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */