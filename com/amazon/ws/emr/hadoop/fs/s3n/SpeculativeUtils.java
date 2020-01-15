package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.files.TemporaryFiles;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SpeculativeUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(SpeculativeUtils.class);
  
  public static Path clonePartFileIfNotAlreadyCompleted(TemporaryFiles temporaryFiles, Path cloneFrom, int partNum)
    throws IOException
  {
    try
    {
      return temporaryFiles.hardLink(cloneFrom);
    }
    catch (FileNotFoundException e)
    {
      LOG.debug("An upload task for partNum: {} has already completed, no need to schedule another speculative task", 
        Integer.valueOf(partNum));
      return null;
    }
    catch (IOException e)
    {
      if (!temporaryFiles.isTracked(cloneFrom))
      {
        LOG.debug("IOException occured when attempting to schedule an upload task for partNum: {}.  But there is no need to schedule another speculative task as another upload task has completed.", 
        
          Integer.valueOf(partNum), e);
        return null;
      }
      LOG.error("Hard Link creation failed for partNum: {}", Integer.valueOf(partNum), e);
      throw e;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.SpeculativeUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */