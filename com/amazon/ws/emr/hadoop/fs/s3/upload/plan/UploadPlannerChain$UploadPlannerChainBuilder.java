package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UploadPlannerChain$UploadPlannerChainBuilder
{
  private ArrayList<ConditionalUploadPlanner> conditionalPlanners;
  private UploadPlanner fallbackPlanner;
  
  public String toString()
  {
    return "UploadPlannerChain.UploadPlannerChainBuilder(conditionalPlanners=" + conditionalPlanners + ", fallbackPlanner=" + fallbackPlanner + ")";
  }
  
  public UploadPlannerChain build()
  {
    List<ConditionalUploadPlanner> conditionalPlanners;
    List<ConditionalUploadPlanner> conditionalPlanners;
    List<ConditionalUploadPlanner> conditionalPlanners;
    switch (this.conditionalPlanners == null ? 0 : this.conditionalPlanners.size())
    {
    case 0: 
      conditionalPlanners = Collections.emptyList(); break;
    case 1: 
      conditionalPlanners = Collections.singletonList(this.conditionalPlanners.get(0)); break;
    default: 
      conditionalPlanners = Collections.unmodifiableList(new ArrayList(this.conditionalPlanners));
    }
    return new UploadPlannerChain(conditionalPlanners, fallbackPlanner, null);
  }
  
  public UploadPlannerChainBuilder fallbackPlanner(UploadPlanner fallbackPlanner)
  {
    this.fallbackPlanner = fallbackPlanner;return this;
  }
  
  public UploadPlannerChainBuilder clearConditionalPlanners()
  {
    if (conditionalPlanners != null) {
      conditionalPlanners.clear();
    }
    return this;
  }
  
  public UploadPlannerChainBuilder conditionalPlanners(Collection<? extends ConditionalUploadPlanner> conditionalPlanners)
  {
    if (this.conditionalPlanners == null) {
      this.conditionalPlanners = new ArrayList();
    }
    this.conditionalPlanners.addAll(conditionalPlanners);return this;
  }
  
  public UploadPlannerChainBuilder conditionalPlanner(ConditionalUploadPlanner conditionalPlanner)
  {
    if (conditionalPlanners == null) {
      conditionalPlanners = new ArrayList();
    }
    conditionalPlanners.add(conditionalPlanner);return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlannerChain.UploadPlannerChainBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */