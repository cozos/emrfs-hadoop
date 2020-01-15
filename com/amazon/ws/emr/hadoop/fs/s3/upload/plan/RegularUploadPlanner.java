package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import com.amazon.ws.emr.hadoop.fs.util.io.IOPredicate;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.fs.FileAlreadyExistsException;
import org.apache.hadoop.fs.Path;

final class RegularUploadPlanner
  implements UploadPlanner
{
  @NonNull
  private final UploadPlanTemplate template;
  @NonNull
  private final IOPredicate<Path> existenceCheck;
  
  public RegularUploadPlanner(@NonNull UploadPlanTemplate template, @NonNull IOPredicate<Path> existenceCheck)
  {
    if (template == null) {
      throw new NullPointerException("template");
    }
    if (existenceCheck == null) {
      throw new NullPointerException("existenceCheck");
    }
    this.template = template;this.existenceCheck = existenceCheck;
  }
  
  public UploadPlan plan(Path path, boolean overwrite)
    throws IOException
  {
    checkExistenceIfNotOverwriting(path, overwrite);
    return newPlan(path);
  }
  
  private void checkExistenceIfNotOverwriting(Path path, boolean overwrite)
    throws IOException
  {
    if ((!overwrite) && (existenceCheck.test(path))) {
      throw new FileAlreadyExistsException("File already exists:" + path);
    }
  }
  
  private UploadPlan newPlan(Path path)
  {
    return 
    
      newPlanBuilderFromTemplate().key(EmrFsUtils.pathToKey(path)).extraUploadMetadata(ExtraUploadMetadata.empty()).build();
  }
  
  private UploadPlan.UploadPlanBuilder newPlanBuilderFromTemplate()
  {
    UploadPlan.UploadPlanBuilder builder = UploadPlan.builder().bucket(template.getBucket()).singlePartDispatcher(template.getSinglePartDispatcher());
    if (isMultipartUploadEnabled()) {
      builder.multipartDispatcher(template.getMultipartDispatcher());
    } else {
      builder.constraint(UploadConstraint.SINGLE_PART_UPLOAD);
    }
    return builder;
  }
  
  private boolean isMultipartUploadEnabled()
  {
    return ConfigurationUtils.isMultipartUploadEnabled(template.getConfiguration());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.RegularUploadPlanner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */