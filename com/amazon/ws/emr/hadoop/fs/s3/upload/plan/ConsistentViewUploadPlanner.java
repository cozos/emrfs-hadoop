package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.consistency.FileStatusExt;
import com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrencyToken;
import com.amazon.ws.emr.hadoop.fs.consistency.exception.FileDeletedInMetadataNotFoundException;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.ExtraUploadMetadata;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import com.amazon.ws.emr.hadoop.fs.util.io.IOFunction;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.NonNull;
import org.apache.hadoop.fs.FileAlreadyExistsException;
import org.apache.hadoop.fs.Path;

final class ConsistentViewUploadPlanner
  implements UploadPlanner
{
  @NonNull
  private final UploadPlanTemplate template;
  @NonNull
  private final IOFunction<Path, FileStatusExt> statusGetter;
  
  public ConsistentViewUploadPlanner(@NonNull UploadPlanTemplate template, @NonNull IOFunction<Path, FileStatusExt> statusGetter)
  {
    if (template == null) {
      throw new NullPointerException("template");
    }
    if (statusGetter == null) {
      throw new NullPointerException("statusGetter");
    }
    this.template = template;this.statusGetter = statusGetter;
  }
  
  public UploadPlan plan(Path path, boolean overwrite)
    throws IOException
  {
    ConcurrencyToken concurrencyToken = checkPreexistence(path, overwrite);
    return UploadPlan.builder()
      .bucket(template.getBucket())
      .key(EmrFsUtils.pathToKey(path))
      .singlePartDispatcher(template.getSinglePartDispatcher())
      .multipartDispatcher(template.getMultipartDispatcher())
      .extraUploadMetadata(new ExtraUploadMetadata(concurrencyToken))
      .build();
  }
  
  private ConcurrencyToken checkPreexistence(Path path, boolean overwrite)
    throws IOException
  {
    try
    {
      FileStatusExt status = (FileStatusExt)statusGetter.apply(path);
      if (status.isDirectory()) {
        throw new IOException("Path already exists as a directory: " + path);
      }
      if (!overwrite) {
        throw new FileAlreadyExistsException("Path already exists as a file: " + path);
      }
      return ConcurrencyToken.of(status.getEntity());
    }
    catch (FileDeletedInMetadataNotFoundException e)
    {
      return ConcurrencyToken.of(e.getEntity());
    }
    catch (FileNotFoundException e) {}
    return ConcurrencyToken.ofNonexistentEntity();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.ConsistentViewUploadPlanner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */