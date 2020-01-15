package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;

class LifecyclePredicateVisitorImpl
  implements LifecyclePredicateVisitor
{
  private final XmlWriter xml;
  
  public LifecyclePredicateVisitorImpl(XmlWriter xml)
  {
    this.xml = xml;
  }
  
  public void visit(LifecyclePrefixPredicate lifecyclePrefixPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writePrefix(xml, lifecyclePrefixPredicate.getPrefix());
  }
  
  public void visit(LifecycleTagPredicate lifecycleTagPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writeTag(xml, lifecycleTagPredicate.getTag());
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.LifecyclePredicateVisitorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */