package com.amazon.ws.emr.hadoop.fs.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.slf4j.Logger;

final class DeleteUtil$CountingDeletingFileVisitor
  extends SimpleFileVisitor<Path>
{
  private int failedFileDeletes = 0;
  private int failedDirectoryDeletes = 0;
  private int failedVisits = 0;
  
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
  {
    if (!DeleteUtil.deleteIfExistsOrLog(file)) {
      failedFileDeletes += 1;
    }
    return FileVisitResult.CONTINUE;
  }
  
  public FileVisitResult visitFileFailed(Path file, IOException exc)
  {
    failedVisits += 1;
    return FileVisitResult.CONTINUE;
  }
  
  public FileVisitResult postVisitDirectory(Path dir, IOException exc)
  {
    if (!DeleteUtil.deleteIfExistsOrLog(dir)) {
      failedDirectoryDeletes += 1;
    }
    return FileVisitResult.CONTINUE;
  }
  
  boolean hasAtLeastOneFailure()
  {
    return (failedVisits > 0) || (failedDirectoryDeletes > 0) || (failedFileDeletes > 0);
  }
  
  void logFailures()
  {
    if (hasAtLeastOneFailure()) {
      DeleteUtil.access$100().debug(String.format("%d directory deletion failures, %d file deletion failures and %d failed visits.", new Object[] {
      
        Integer.valueOf(failedDirectoryDeletes), 
        Integer.valueOf(failedFileDeletes), 
        Integer.valueOf(failedVisits) }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.DeleteUtil.CountingDeletingFileVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */