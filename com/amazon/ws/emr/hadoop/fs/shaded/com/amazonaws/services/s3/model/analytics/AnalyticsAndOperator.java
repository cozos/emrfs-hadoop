package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.util.List;

public class AnalyticsAndOperator
  extends AnalyticsNAryOperator
{
  public AnalyticsAndOperator(List<AnalyticsFilterPredicate> operands)
  {
    super(operands);
  }
  
  public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor)
  {
    analyticsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */