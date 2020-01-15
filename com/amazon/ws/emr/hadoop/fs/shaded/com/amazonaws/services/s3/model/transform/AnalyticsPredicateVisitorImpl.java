package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;

class AnalyticsPredicateVisitorImpl
  implements AnalyticsPredicateVisitor
{
  private final XmlWriter xml;
  
  public AnalyticsPredicateVisitorImpl(XmlWriter xml)
  {
    this.xml = xml;
  }
  
  public void visit(AnalyticsPrefixPredicate analyticsPrefixPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writePrefix(xml, analyticsPrefixPredicate.getPrefix());
  }
  
  public void visit(AnalyticsTagPredicate analyticsTagPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writeTag(xml, analyticsTagPredicate.getTag());
  }
  
  public void visit(AnalyticsAndOperator analyticsAndOperator)
  {
    xml.start("And");
    for (AnalyticsFilterPredicate predicate : analyticsAndOperator.getOperands()) {
      predicate.accept(this);
    }
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.AnalyticsPredicateVisitorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */