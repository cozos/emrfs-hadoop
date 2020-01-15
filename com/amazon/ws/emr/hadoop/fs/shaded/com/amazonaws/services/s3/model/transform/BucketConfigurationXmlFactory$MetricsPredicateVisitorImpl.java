package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPredicateVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;

class BucketConfigurationXmlFactory$MetricsPredicateVisitorImpl
  implements MetricsPredicateVisitor
{
  private final XmlWriter xml;
  
  public BucketConfigurationXmlFactory$MetricsPredicateVisitorImpl(BucketConfigurationXmlFactory paramBucketConfigurationXmlFactory, XmlWriter xml)
  {
    this.xml = xml;
  }
  
  public void visit(MetricsPrefixPredicate metricsPrefixPredicate)
  {
    BucketConfigurationXmlFactoryFunctions.writePrefix(xml, metricsPrefixPredicate.getPrefix());
  }
  
  public void visit(MetricsTagPredicate metricsTagPredicate)
  {
    BucketConfigurationXmlFactory.access$000(this$0, xml, metricsTagPredicate.getTag());
  }
  
  public void visit(MetricsAndOperator metricsAndOperator)
  {
    xml.start("And");
    for (MetricsFilterPredicate predicate : metricsAndOperator.getOperands()) {
      predicate.accept(this);
    }
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactory.MetricsPredicateVisitorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */