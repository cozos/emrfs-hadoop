package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import java.util.function.LongSupplier;
import java.util.function.UnaryOperator;
import org.apache.hadoop.fs.Path;

public class BasicFileStatusFactory$BasicFileStatusFactoryBuilder
{
  private FileSystemOwner fileSystemOwner;
  private UnaryOperator<Path> pathQualifier;
  private LongSupplier blockSizeSupplier;
  
  public String toString()
  {
    return "BasicFileStatusFactory.BasicFileStatusFactoryBuilder(fileSystemOwner=" + fileSystemOwner + ", pathQualifier=" + pathQualifier + ", blockSizeSupplier=" + blockSizeSupplier + ")";
  }
  
  public BasicFileStatusFactory build()
  {
    return new BasicFileStatusFactory(fileSystemOwner, pathQualifier, blockSizeSupplier);
  }
  
  public BasicFileStatusFactoryBuilder blockSizeSupplier(LongSupplier blockSizeSupplier)
  {
    this.blockSizeSupplier = blockSizeSupplier;return this;
  }
  
  public BasicFileStatusFactoryBuilder pathQualifier(UnaryOperator<Path> pathQualifier)
  {
    this.pathQualifier = pathQualifier;return this;
  }
  
  public BasicFileStatusFactoryBuilder fileSystemOwner(FileSystemOwner fileSystemOwner)
  {
    this.fileSystemOwner = fileSystemOwner;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.BasicFileStatusFactory.BasicFileStatusFactoryBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */