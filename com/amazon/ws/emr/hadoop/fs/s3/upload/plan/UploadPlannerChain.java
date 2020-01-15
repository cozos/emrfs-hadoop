package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import org.apache.hadoop.fs.Path;

final class UploadPlannerChain
  implements UploadPlanner
{
  private final List<ConditionalUploadPlanner> conditionalPlanners;
  private final UploadPlanner fallbackPlanner;
  
  public static class UploadPlannerChainBuilder
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
  
  public static UploadPlannerChainBuilder builder()
  {
    return new UploadPlannerChainBuilder();
  }
  
  private UploadPlannerChain(@NonNull List<ConditionalUploadPlanner> conditionalPlanners, @NonNull UploadPlanner fallbackPlanner)
  {
    if (conditionalPlanners == null) {
      throw new NullPointerException("conditionalPlanners");
    }
    if (fallbackPlanner == null) {
      throw new NullPointerException("fallbackPlanner");
    }
    checkFallbackPlanner(fallbackPlanner);
    this.conditionalPlanners = conditionalPlanners;
    this.fallbackPlanner = fallbackPlanner;
  }
  
  public UploadPlan plan(Path path, boolean overwrite)
    throws IOException
  {
    return getPlanner(path).plan(path, overwrite);
  }
  
  private UploadPlanner getPlanner(Path path)
  {
    for (ConditionalUploadPlanner conditionalPlanner : conditionalPlanners) {
      if (conditionalPlanner.canPlan(path)) {
        return conditionalPlanner;
      }
    }
    return fallbackPlanner;
  }
  
  private static void checkFallbackPlanner(@NonNull UploadPlanner fallbackPlanner)
  {
    if (fallbackPlanner == null) {
      throw new NullPointerException("fallbackPlanner");
    }
    Preconditions.checkArgument(!(fallbackPlanner instanceof ConditionalUploadPlanner), "Fallback planner must not be a %s", new Object[] {ConditionalUploadPlanner.class
      .getSimpleName() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlannerChain
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */