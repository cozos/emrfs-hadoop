package com.amazon.ws.emr.hadoop.fs.staging;

import com.amazon.ws.emr.hadoop.fs.s3n.FileStatusFactory;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import java.util.function.UnaryOperator;
import org.apache.hadoop.fs.Path;

public class DefaultStagingMechanism$DefaultStagingMechanismBuilder
{
  private StagingPathConverter pathConverter;
  private StagingMetadataStore store;
  private UnaryOperator<Path> pathQualifier;
  private FileStatusFactory fileStatusFactory;
  
  public String toString()
  {
    return "DefaultStagingMechanism.DefaultStagingMechanismBuilder(pathConverter=" + pathConverter + ", store=" + store + ", pathQualifier=" + pathQualifier + ", fileStatusFactory=" + fileStatusFactory + ")";
  }
  
  public DefaultStagingMechanism build()
  {
    return new DefaultStagingMechanism(pathConverter, store, pathQualifier, fileStatusFactory);
  }
  
  public DefaultStagingMechanismBuilder fileStatusFactory(FileStatusFactory fileStatusFactory)
  {
    this.fileStatusFactory = fileStatusFactory;return this;
  }
  
  public DefaultStagingMechanismBuilder pathQualifier(UnaryOperator<Path> pathQualifier)
  {
    this.pathQualifier = pathQualifier;return this;
  }
  
  public DefaultStagingMechanismBuilder store(StagingMetadataStore store)
  {
    this.store = store;return this;
  }
  
  public DefaultStagingMechanismBuilder pathConverter(StagingPathConverter pathConverter)
  {
    this.pathConverter = pathConverter;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.DefaultStagingMechanism.DefaultStagingMechanismBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */