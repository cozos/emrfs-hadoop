package com.amazon.ws.emr.hadoop.fs.staging;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeferredUploadStatistics
{
  public DeferredUploadStatistics(@NonNull StagingRoot root)
  {
    if (root == null) {
      throw new NullPointerException("root");
    }
    this.root = root;
  }
  
  private static final Logger logger = LoggerFactory.getLogger(DeferredUploadStatistics.class);
  private static final double MEDIAN_PERCENTILE = 50.0D;
  private final DescriptiveStatistics deferredTimeStats = new DescriptiveStatistics();
  private final DescriptiveStatistics fileSizeStats = new DescriptiveStatistics();
  @NonNull
  private final StagingRoot root;
  
  public void addCompletedUpload(@NonNull DeferredUpload upload)
  {
    if (upload == null) {
      throw new NullPointerException("upload");
    }
    Preconditions.checkArgument(upload.isCompleted(), "upload must be completed");
    deferredTimeStats.addValue(upload.getCompletedTime().longValue() - upload.getDeferralTime());
    fileSizeStats.addValue(upload.getMetadata().getTotalLength());
  }
  
  public void log()
  {
    long numFiles = deferredTimeStats.getN();
    if (logger.isInfoEnabled()) {
      logger.info("Completed {} deferred upload(s) under staging directory at '{}' ({}; {})", new Object[] {
        Long.valueOf(numFiles), root, 
        statsToString(deferredTimeStats, "upload completion deferral time", "msec"), 
        statsToString(fileSizeStats, "file size", "bytes") });
    }
  }
  
  private static String statsToString(DescriptiveStatistics stats, String desc, String units)
  {
    return String.format("%s (%s): min=%s, avg=%s, median=%s, max=%s", new Object[] { desc, units, 
      Long.valueOf(Math.round(stats.getMin())), 
      Long.valueOf(Math.round(stats.getMean())), 
      Long.valueOf(Math.round(stats.getPercentile(50.0D))), 
      Long.valueOf(Math.round(stats.getMax())) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.DeferredUploadStatistics
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */