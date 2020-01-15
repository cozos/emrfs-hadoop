package com.amazon.ws.emr.hadoop.fs.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class DeleteUtil
{
  private static final Logger LOG = LoggerFactory.getLogger(DeleteUtil.class);
  
  static boolean deleteIfExistsOrLog(Path tempPath)
  {
    try
    {
      Files.deleteIfExists(tempPath);
      return true;
    }
    catch (Exception e)
    {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Could not delete path: " + tempPath, e);
      }
    }
    return false;
  }
  
  static boolean recursiveDeleteIfExistsOrLog(Path tempPathDir)
  {
    CountingDeletingFileVisitor visitor = new CountingDeletingFileVisitor(null);
    try
    {
      Files.walkFileTree(tempPathDir, visitor);
      if (visitor.hasAtLeastOneFailure())
      {
        if (LOG.isDebugEnabled())
        {
          LOG.debug("Could not recursively delete directory tree: " + tempPathDir);
          visitor.logFailures();
        }
        return false;
      }
      return true;
    }
    catch (Exception e)
    {
      if (LOG.isDebugEnabled())
      {
        LOG.debug("Could not recursively delete directory tree: " + tempPathDir, e);
        visitor.logFailures();
      }
    }
    return false;
  }
  
  private static final class CountingDeletingFileVisitor
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
        DeleteUtil.LOG.debug(String.format("%d directory deletion failures, %d file deletion failures and %d failed visits.", new Object[] {
        
          Integer.valueOf(failedDirectoryDeletes), 
          Integer.valueOf(failedFileDeletes), 
          Integer.valueOf(failedVisits) }));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.DeleteUtil
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */