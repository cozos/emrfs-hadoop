package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserver;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlannerFactory;
import com.amazon.ws.emr.hadoop.fs.s3n.FileStatusFactory;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStoreFactory;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import java.net.URI;
import java.util.function.UnaryOperator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public class FileCreationSubsystemFactory$FileCreationSubsystemFactoryBuilder
{
  private URI uri;
  private Configuration conf;
  private AmazonS3Lite s3;
  private S3ObjectRequestFactory requestFactory;
  private UploadObserver uploadObserver;
  private UploadPlannerFactory nonStagingPlannerFactory;
  private UnaryOperator<Path> pathQualifier;
  private FileStatusFactory fileStatusFactory;
  private boolean stagingPathConverter$set;
  private StagingPathConverter stagingPathConverter;
  private boolean stagingMetadataStoreFactory$set;
  private StagingMetadataStoreFactory stagingMetadataStoreFactory;
  
  public String toString()
  {
    return "FileCreationSubsystemFactory.FileCreationSubsystemFactoryBuilder(uri=" + uri + ", conf=" + conf + ", s3=" + s3 + ", requestFactory=" + requestFactory + ", uploadObserver=" + uploadObserver + ", nonStagingPlannerFactory=" + nonStagingPlannerFactory + ", pathQualifier=" + pathQualifier + ", fileStatusFactory=" + fileStatusFactory + ", stagingPathConverter=" + stagingPathConverter + ", stagingMetadataStoreFactory=" + stagingMetadataStoreFactory + ")";
  }
  
  public FileCreationSubsystemFactory build()
  {
    StagingPathConverter stagingPathConverter = this.stagingPathConverter;
    if (!stagingPathConverter$set) {
      stagingPathConverter = FileCreationSubsystemFactory.access$000();
    }
    StagingMetadataStoreFactory stagingMetadataStoreFactory = this.stagingMetadataStoreFactory;
    if (!stagingMetadataStoreFactory$set) {
      stagingMetadataStoreFactory = FileCreationSubsystemFactory.access$100();
    }
    return new FileCreationSubsystemFactory(uri, conf, s3, requestFactory, uploadObserver, nonStagingPlannerFactory, pathQualifier, fileStatusFactory, stagingPathConverter, stagingMetadataStoreFactory);
  }
  
  public FileCreationSubsystemFactoryBuilder stagingMetadataStoreFactory(StagingMetadataStoreFactory stagingMetadataStoreFactory)
  {
    this.stagingMetadataStoreFactory = stagingMetadataStoreFactory;stagingMetadataStoreFactory$set = true;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder stagingPathConverter(StagingPathConverter stagingPathConverter)
  {
    this.stagingPathConverter = stagingPathConverter;stagingPathConverter$set = true;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder fileStatusFactory(FileStatusFactory fileStatusFactory)
  {
    this.fileStatusFactory = fileStatusFactory;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder pathQualifier(UnaryOperator<Path> pathQualifier)
  {
    this.pathQualifier = pathQualifier;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder nonStagingPlannerFactory(UploadPlannerFactory nonStagingPlannerFactory)
  {
    this.nonStagingPlannerFactory = nonStagingPlannerFactory;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder uploadObserver(UploadObserver uploadObserver)
  {
    this.uploadObserver = uploadObserver;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder requestFactory(S3ObjectRequestFactory requestFactory)
  {
    this.requestFactory = requestFactory;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder s3(AmazonS3Lite s3)
  {
    this.s3 = s3;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder conf(Configuration conf)
  {
    this.conf = conf;return this;
  }
  
  public FileCreationSubsystemFactoryBuilder uri(URI uri)
  {
    this.uri = uri;return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.FileCreationSubsystemFactory.FileCreationSubsystemFactoryBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */