package com.amazon.ws.emr.hadoop.fs.staging.path;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.util.HadoopPaths;
import lombok.NonNull;
import org.apache.hadoop.fs.Path;

public final class StagingRoot
{
  private final Path outputPath;
  private final String stageName;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof StagingRoot)) {
      return false;
    }
    StagingRoot other = (StagingRoot)o;Object this$outputPath = getOutputPath();Object other$outputPath = other.getOutputPath();
    if (this$outputPath == null ? other$outputPath != null : !this$outputPath.equals(other$outputPath)) {
      return false;
    }
    Object this$stageName = getStageName();Object other$stageName = other.getStageName();return this$stageName == null ? other$stageName == null : this$stageName.equals(other$stageName);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $outputPath = getOutputPath();result = result * 59 + ($outputPath == null ? 43 : $outputPath.hashCode());Object $stageName = getStageName();result = result * 59 + ($stageName == null ? 43 : $stageName.hashCode());return result;
  }
  
  private StagingRoot(Path outputPath, String stageName)
  {
    this.outputPath = outputPath;this.stageName = stageName;
  }
  
  public Path getOutputPath()
  {
    return outputPath;
  }
  
  public String getStageName()
  {
    return stageName;
  }
  
  public static StagingRoot of(@NonNull Path outputPath, @NonNull String stageName)
  {
    if (outputPath == null) {
      throw new NullPointerException("outputPath");
    }
    if (stageName == null) {
      throw new NullPointerException("stageName");
    }
    Preconditions.checkArgument(HadoopPaths.isFullyQualified(outputPath), "OutputPath (%s) must be fully qualified", new Object[] { outputPath });
    
    Preconditions.checkArgument(!stageName.isEmpty(), "StageName must not be empty");
    return new StagingRoot(outputPath, stageName);
  }
  
  public String toString()
  {
    return 
    
      StagingPathConverter.defaultConverter().toHadoopPath(this).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.path.StagingRoot
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */