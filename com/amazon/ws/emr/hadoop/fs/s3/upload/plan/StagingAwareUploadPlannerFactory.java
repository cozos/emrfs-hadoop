package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import lombok.NonNull;

public final class StagingAwareUploadPlannerFactory
  implements UploadPlannerFactory
{
  @NonNull
  private final StagingPathConverter stagingPathConverter;
  @NonNull
  private final StagingMetadataStore stagingMetadataStore;
  @NonNull
  private final UploadPlannerFactory nonStagingPlannerFactory;
  
  public StagingAwareUploadPlannerFactory(@NonNull StagingPathConverter stagingPathConverter, @NonNull StagingMetadataStore stagingMetadataStore, @NonNull UploadPlannerFactory nonStagingPlannerFactory)
  {
    if (stagingPathConverter == null) {
      throw new NullPointerException("stagingPathConverter");
    }
    if (stagingMetadataStore == null) {
      throw new NullPointerException("stagingMetadataStore");
    }
    if (nonStagingPlannerFactory == null) {
      throw new NullPointerException("nonStagingPlannerFactory");
    }
    this.stagingPathConverter = stagingPathConverter;this.stagingMetadataStore = stagingMetadataStore;this.nonStagingPlannerFactory = nonStagingPlannerFactory;
  }
  
  public UploadPlanner create(@NonNull UploadPlanTemplate template)
  {
    if (template == null) {
      throw new NullPointerException("template");
    }
    return 
    
      UploadPlannerChain.builder().conditionalPlanner(createStagingPlanner(template)).fallbackPlanner(createFallbackPlanner(template)).build();
  }
  
  private ConditionalUploadPlanner createStagingPlanner(UploadPlanTemplate template)
  {
    return 
    
      StagingUploadPlanner.builder().bucket(template.getBucket()).conf(template.getConfiguration()).multipartDispatcher(template.getMultipartDispatcher()).stagingPathConverter(stagingPathConverter).stagingMetadataStore(stagingMetadataStore).build();
  }
  
  private UploadPlanner createFallbackPlanner(UploadPlanTemplate template)
  {
    return nonStagingPlannerFactory.create(template);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.StagingAwareUploadPlannerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */