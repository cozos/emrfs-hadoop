package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.cse.CSEUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartialListing
{
  private final List<FileMetadata> files;
  private final List<String> commonPrefixes;
  private final String startAfter;
  private final String continuationToken;
  private String nextContinuationToken;
  
  public PartialListing(String startAfter, String continuationToken)
  {
    files = new ArrayList();
    commonPrefixes = new ArrayList();
    this.startAfter = startAfter;
    this.continuationToken = continuationToken;
  }
  
  public void addFile(S3ObjectSummary summary)
  {
    if (!CSEUtils.isInstructionFile(summary.getKey())) {
      files.add(new FileMetadata(summary.getKey(), summary.getSize(), summary.getLastModified().getTime()));
    }
  }
  
  public void addFiles(List<S3ObjectSummary> summary)
  {
    for (S3ObjectSummary v : summary) {
      addFile(v);
    }
  }
  
  public void addDir(String commonPrefix)
  {
    commonPrefixes.add(commonPrefix);
  }
  
  public void addDirs(List<String> commonPrefix)
  {
    commonPrefixes.addAll(commonPrefix);
  }
  
  public void setNextContinuationToken(String nextContinuationToken)
  {
    this.nextContinuationToken = nextContinuationToken;
  }
  
  public List<FileMetadata> getFiles()
  {
    return files;
  }
  
  public List<String> getDirs()
  {
    return commonPrefixes;
  }
  
  public String getContinuationToken()
  {
    return continuationToken;
  }
  
  public String getNextContinuationToken()
  {
    return nextContinuationToken;
  }
  
  @Deprecated
  public List<String> getCommonPrefixes()
  {
    return commonPrefixes;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("PartialListing startAfter:%s continuationToken:%s nextContinuationToken:%s %d dirs %d files:", new Object[] { startAfter == null ? "" : startAfter, continuationToken == null ? "" : continuationToken, nextContinuationToken == null ? "" : nextContinuationToken, 
    
      Integer.valueOf(commonPrefixes.size()), Integer.valueOf(files.size()) }));
    if ((commonPrefixes.size() > 0) || (files.size() > 0)) {
      sb.append("\n  ");
    }
    sb.append(Joiner.on("\n  ").join(commonPrefixes));
    for (FileMetadata v : files) {
      sb.append("\n  " + v.getKey());
    }
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.PartialListing
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */