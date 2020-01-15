package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.select.SelectConstants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataInputStreamBuilder;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class EmrFSDataInputStreamBuilder
  extends FSDataInputStreamBuilder<FSDataInputStream, EmrFSDataInputStreamBuilder>
{
  public EmrFSDataInputStreamBuilder(FileSystem fileSystem, Path path)
  {
    super(fileSystem, path);
  }
  
  public FSDataInputStream build()
    throws IOException, UnsupportedOperationException
  {
    Set<String> unsupported = new HashSet(getMandatoryKeys());
    
    Configuration options = getOptions();
    String selectExpression = options.get("fs.s3.select.expression");
    if (selectExpression == null)
    {
      Preconditions.checkArgument(unsupported.isEmpty(), "unsupported key found: " + unsupported);
      return getFS().open(getPath(), getBufferSize());
    }
    Preconditions.checkArgument(!selectExpression.isEmpty(), "fs.s3.select.expression is empty");
    
    unsupported.removeAll(SelectConstants.s3selectKeys);
    Preconditions.checkArgument(unsupported.isEmpty(), "unsupported key found: " + unsupported);
    
    FileSystem fs = getFS();
    if ((fs instanceof S3NativeCommonFileSystem)) {
      return ((S3NativeCommonFileSystem)fs).select(
        getPath(), options, 
        
        getBufferSize());
    }
    throw new UnsupportedOperationException("FileSystem does not support S3 Select");
  }
  
  protected EmrFSDataInputStreamBuilder getThisBuilder()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.EmrFSDataInputStreamBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */