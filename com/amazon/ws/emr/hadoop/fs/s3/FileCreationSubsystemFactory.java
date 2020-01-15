package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.DefaultMultipartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.DefaultSinglePartUploadDispatcher;
import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserver;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.StagingAwareUploadPlannerFactory;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanTemplate;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanTemplate.UploadPlanTemplateBuilder;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanner;
import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlannerFactory;
import com.amazon.ws.emr.hadoop.fs.s3n.FileStatusFactory;
import com.amazon.ws.emr.hadoop.fs.staging.DefaultStagingMechanism;
import com.amazon.ws.emr.hadoop.fs.staging.DefaultStagingMechanism.DefaultStagingMechanismBuilder;
import com.amazon.ws.emr.hadoop.fs.staging.StagingMechanism;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStore;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingMetadataStoreFactory;
import com.amazon.ws.emr.hadoop.fs.staging.path.StagingPathConverter;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.net.URI;
import java.util.function.UnaryOperator;
import lombok.NonNull;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public final class FileCreationSubsystemFactory
{
  @NonNull
  private final URI uri;
  @NonNull
  private final Configuration conf;
  @NonNull
  private final AmazonS3Lite s3;
  @NonNull
  private final S3ObjectRequestFactory requestFactory;
  @NonNull
  private final UploadObserver uploadObserver;
  @NonNull
  private final UploadPlannerFactory nonStagingPlannerFactory;
  @NonNull
  private final UnaryOperator<Path> pathQualifier;
  @NonNull
  private final FileStatusFactory fileStatusFactory;
  @NonNull
  private final StagingPathConverter stagingPathConverter;
  @NonNull
  private final StagingMetadataStoreFactory stagingMetadataStoreFactory;
  
  public static class FileCreationSubsystemFactoryBuilder
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
  
  private static StagingPathConverter $default$stagingPathConverter()
  {
    return StagingPathConverter.defaultConverter();
  }
  
  private static StagingMetadataStoreFactory $default$stagingMetadataStoreFactory()
  {
    return StagingMetadataStoreFactory.defaultFactory();
  }
  
  FileCreationSubsystemFactory(@NonNull URI uri, @NonNull Configuration conf, @NonNull AmazonS3Lite s3, @NonNull S3ObjectRequestFactory requestFactory, @NonNull UploadObserver uploadObserver, @NonNull UploadPlannerFactory nonStagingPlannerFactory, @NonNull UnaryOperator<Path> pathQualifier, @NonNull FileStatusFactory fileStatusFactory, @NonNull StagingPathConverter stagingPathConverter, @NonNull StagingMetadataStoreFactory stagingMetadataStoreFactory)
  {
    if (uri == null) {
      throw new NullPointerException("uri");
    }
    if (conf == null) {
      throw new NullPointerException("conf");
    }
    if (s3 == null) {
      throw new NullPointerException("s3");
    }
    if (requestFactory == null) {
      throw new NullPointerException("requestFactory");
    }
    if (uploadObserver == null) {
      throw new NullPointerException("uploadObserver");
    }
    if (nonStagingPlannerFactory == null) {
      throw new NullPointerException("nonStagingPlannerFactory");
    }
    if (pathQualifier == null) {
      throw new NullPointerException("pathQualifier");
    }
    if (fileStatusFactory == null) {
      throw new NullPointerException("fileStatusFactory");
    }
    if (stagingPathConverter == null) {
      throw new NullPointerException("stagingPathConverter");
    }
    if (stagingMetadataStoreFactory == null) {
      throw new NullPointerException("stagingMetadataStoreFactory");
    }
    this.uri = uri;this.conf = conf;this.s3 = s3;this.requestFactory = requestFactory;this.uploadObserver = uploadObserver;this.nonStagingPlannerFactory = nonStagingPlannerFactory;this.pathQualifier = pathQualifier;this.fileStatusFactory = fileStatusFactory;this.stagingPathConverter = stagingPathConverter;this.stagingMetadataStoreFactory = stagingMetadataStoreFactory;
  }
  
  public static FileCreationSubsystemFactoryBuilder builder()
  {
    return new FileCreationSubsystemFactoryBuilder();
  }
  
  public FileCreationSubsystem create()
  {
    UploadPlanTemplate planTemplate = newUploadPlanTemplate();
    return newFileCreationSubsystem(planTemplate);
  }
  
  private UploadPlanTemplate newUploadPlanTemplate()
  {
    return 
    
      UploadPlanTemplate.builder().bucket(EmrFsUtils.uriToBucket(uri)).configuration(conf).singlePartDispatcher(newSinglePartDispatcher()).multipartDispatcher(newMultipartDispatcher()).build();
  }
  
  private DefaultSinglePartUploadDispatcher newSinglePartDispatcher()
  {
    return new DefaultSinglePartUploadDispatcher(s3, requestFactory, uploadObserver);
  }
  
  private DefaultMultipartUploadDispatcher newMultipartDispatcher()
  {
    return new DefaultMultipartUploadDispatcher(s3, uploadObserver);
  }
  
  private FileCreationSubsystem newFileCreationSubsystem(UploadPlanTemplate template)
  {
    StagingMetadataStore store = newStagingMetadataStore(template);
    StagingMechanism stagingMechanism = newStagingMechanism(store);
    UploadPlanner planner = newUploadPlanner(template, store);
    return new FileCreationSubsystem(stagingMechanism, planner);
  }
  
  private StagingMetadataStore newStagingMetadataStore(UploadPlanTemplate template)
  {
    return stagingMetadataStoreFactory.create(uri, template.getMultipartDispatcher());
  }
  
  private StagingMechanism newStagingMechanism(StagingMetadataStore store)
  {
    return 
    
      DefaultStagingMechanism.builder().pathConverter(stagingPathConverter).store(store).pathQualifier(pathQualifier).fileStatusFactory(fileStatusFactory).build();
  }
  
  private UploadPlanner newUploadPlanner(UploadPlanTemplate template, StagingMetadataStore store)
  {
    UploadPlannerFactory factory = newStagingAwareUploadPlannerFactory(store);
    return factory.create(template);
  }
  
  private UploadPlannerFactory newStagingAwareUploadPlannerFactory(StagingMetadataStore store)
  {
    return new StagingAwareUploadPlannerFactory(stagingPathConverter, store, nonStagingPlannerFactory);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.FileCreationSubsystemFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */