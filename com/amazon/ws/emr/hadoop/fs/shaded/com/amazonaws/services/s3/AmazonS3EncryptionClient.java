package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MultiFileOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoModuleDispatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonS3EncryptionClient
  extends AmazonS3Client
  implements AmazonS3Encryption
{
  public static final String USER_AGENT = AmazonS3EncryptionClient.class.getName() + "/" + 
    VersionInfoUtils.getVersion();
  private final S3CryptoModule<?> crypto;
  private final AWSKMS kms;
  private final boolean isKMSClientInternal;
  
  @Deprecated
  public AmazonS3EncryptionClient(EncryptionMaterials encryptionMaterials)
  {
    this(new StaticEncryptionMaterialsProvider(encryptionMaterials));
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    this(new StaticCredentialsProvider(new AnonymousAWSCredentials()), encryptionMaterialsProvider, configFactory
    
      .getConfig(), new CryptoConfiguration());
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(EncryptionMaterials encryptionMaterials, CryptoConfiguration cryptoConfig)
  {
    this(new StaticEncryptionMaterialsProvider(encryptionMaterials), cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(new StaticCredentialsProvider(new AnonymousAWSCredentials()), encryptionMaterialsProvider, configFactory
    
      .getConfig(), cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterials encryptionMaterials)
  {
    this(credentials, new StaticEncryptionMaterialsProvider(encryptionMaterials));
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    this(credentials, encryptionMaterialsProvider, configFactory
      .getConfig(), new CryptoConfiguration());
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider)
  {
    this(credentialsProvider, encryptionMaterialsProvider, configFactory
      .getConfig(), new CryptoConfiguration());
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterials encryptionMaterials, CryptoConfiguration cryptoConfig)
  {
    this(credentials, new StaticEncryptionMaterialsProvider(encryptionMaterials), cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(credentials, encryptionMaterialsProvider, configFactory
      .getConfig(), cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(credentialsProvider, encryptionMaterialsProvider, configFactory
      .getConfig(), cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterials encryptionMaterials, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig)
  {
    this(credentials, new StaticEncryptionMaterialsProvider(encryptionMaterials), clientConfig, cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentials credentials, EncryptionMaterialsProvider encryptionMaterialsProvider, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig)
  {
    this(new StaticCredentialsProvider(credentials), encryptionMaterialsProvider, clientConfig, cryptoConfig);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider kekMaterialsProvider, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig)
  {
    this(credentialsProvider, kekMaterialsProvider, clientConfig, cryptoConfig, null);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider kekMaterialsProvider, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig, RequestMetricCollector requestMetricCollector)
  {
    this(null, credentialsProvider, kekMaterialsProvider, clientConfig, cryptoConfig, requestMetricCollector);
  }
  
  @Deprecated
  public AmazonS3EncryptionClient(AWSKMSClient kms, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider kekMaterialsProvider, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig, RequestMetricCollector requestMetricCollector)
  {
    super(credentialsProvider, clientConfig, requestMetricCollector);
    assertParameterNotNull(kekMaterialsProvider, "EncryptionMaterialsProvider parameter must not be null.");
    
    assertParameterNotNull(cryptoConfig, "CryptoConfiguration parameter must not be null.");
    
    isKMSClientInternal = (kms == null);
    this.kms = (isKMSClientInternal ? 
      newAWSKMSClient(credentialsProvider, clientConfig, cryptoConfig, requestMetricCollector) : kms);
    
    crypto = new CryptoModuleDispatcher(this.kms, new S3DirectImpl(null), credentialsProvider, kekMaterialsProvider, cryptoConfig);
  }
  
  @SdkInternalApi
  AmazonS3EncryptionClient(AmazonS3EncryptionClientParams params)
  {
    super(params);
    assertParameterNotNull(params.getEncryptionMaterials(), "EncryptionMaterialsProvider parameter must not be null.");
    assertParameterNotNull(params.getCryptoConfiguration(), "CryptoConfiguration parameter must not be null.");
    isKMSClientInternal = (params.getKmsClient() == null);
    
    kms = (isKMSClientInternal ? newAWSKMSClient(params.getClientParams().getCredentialsProvider(), params.getClientParams().getClientConfiguration(), params.getCryptoConfiguration(), params.getClientParams().getRequestMetricCollector()) : params.getKmsClient());
    
    crypto = new CryptoModuleDispatcher(kms, new S3DirectImpl(null), params.getClientParams().getCredentialsProvider(), params.getEncryptionMaterials(), params.getCryptoConfiguration());
  }
  
  public static AmazonS3EncryptionClientBuilder encryptionBuilder()
  {
    return AmazonS3EncryptionClientBuilder.standard();
  }
  
  private AWSKMSClient newAWSKMSClient(AWSCredentialsProvider credentialsProvider, ClientConfiguration clientConfig, CryptoConfiguration cryptoConfig, RequestMetricCollector requestMetricCollector)
  {
    AWSKMSClient kmsClient = new AWSKMSClient(credentialsProvider, clientConfig, requestMetricCollector);
    
    Region kmsRegion = cryptoConfig.getAwsKmsRegion();
    if (kmsRegion != null) {
      kmsClient.setRegion(kmsRegion);
    }
    return kmsClient;
  }
  
  private void assertParameterNotNull(Object parameterValue, String errorMessage)
  {
    if (parameterValue == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
  
  public PutObjectResult putObject(PutObjectRequest req)
  {
    return crypto.putObjectSecurely(req.clone());
  }
  
  public S3Object getObject(GetObjectRequest req)
  {
    return crypto.getObjectSecurely(req);
  }
  
  public ObjectMetadata getObject(GetObjectRequest req, File dest)
  {
    return crypto.getObjectSecurely(req, dest);
  }
  
  public void deleteObject(DeleteObjectRequest req)
  {
    req.getRequestClientOptions().appendUserAgent(USER_AGENT);
    
    super.deleteObject(req);
    
    InstructionFileId ifid = new S3ObjectId(req.getBucketName(), req.getKey()).instructionFileId();
    
    DeleteObjectRequest instructionDeleteRequest = (DeleteObjectRequest)req.clone();
    instructionDeleteRequest.withBucketName(ifid.getBucket()).withKey(ifid.getKey());
    super.deleteObject(instructionDeleteRequest);
  }
  
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest req)
  {
    return crypto.completeMultipartUploadSecurely(req);
  }
  
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest req)
  {
    boolean isCreateEncryptionMaterial = true;
    if ((req instanceof EncryptedInitiateMultipartUploadRequest))
    {
      EncryptedInitiateMultipartUploadRequest cryptoReq = (EncryptedInitiateMultipartUploadRequest)req;
      
      isCreateEncryptionMaterial = cryptoReq.isCreateEncryptionMaterial();
    }
    return isCreateEncryptionMaterial ? crypto
      .initiateMultipartUploadSecurely(req) : 
      super.initiateMultipartUpload(req);
  }
  
  public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest)
    throws SdkClientException, AmazonServiceException
  {
    return crypto.uploadPartSecurely(uploadPartRequest);
  }
  
  public CopyPartResult copyPart(CopyPartRequest copyPartRequest)
  {
    return crypto.copyPartSecurely(copyPartRequest);
  }
  
  public void abortMultipartUpload(AbortMultipartUploadRequest req)
  {
    crypto.abortMultipartUploadSecurely(req);
  }
  
  public PutObjectResult putInstructionFile(PutInstructionFileRequest req)
  {
    return crypto.putInstructionFileSecurely(req);
  }
  
  public void shutdown()
  {
    super.shutdown();
    if (isKMSClientInternal) {
      kms.shutdown();
    }
  }
  
  private final class S3DirectImpl
    extends S3Direct
  {
    private S3DirectImpl() {}
    
    public PutObjectResult putObject(PutObjectRequest req)
    {
      return AmazonS3EncryptionClient.this.putObject(req);
    }
    
    public S3Object getObject(GetObjectRequest req)
    {
      return AmazonS3EncryptionClient.this.getObject(req);
    }
    
    public ObjectMetadata getObject(GetObjectRequest req, File dest)
    {
      return AmazonS3EncryptionClient.this.getObject(req, dest);
    }
    
    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest req)
    {
      return AmazonS3EncryptionClient.this.completeMultipartUpload(req);
    }
    
    public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest req)
    {
      return AmazonS3EncryptionClient.this.initiateMultipartUpload(req);
    }
    
    public UploadPartResult uploadPart(UploadPartRequest req)
      throws SdkClientException, AmazonServiceException
    {
      return AmazonS3EncryptionClient.this.uploadPart(req);
    }
    
    public CopyPartResult copyPart(CopyPartRequest req)
    {
      return AmazonS3EncryptionClient.this.copyPart(req);
    }
    
    public void abortMultipartUpload(AbortMultipartUploadRequest req)
    {
      AmazonS3EncryptionClient.this.abortMultipartUpload(req);
    }
  }
  
  public CompleteMultipartUploadResult uploadObject(UploadObjectRequest req)
    throws IOException, InterruptedException, ExecutionException
  {
    ExecutorService es = req.getExecutorService();
    boolean defaultExecutorService = es == null;
    if (es == null) {
      es = Executors.newFixedThreadPool(clientConfiguration.getMaxConnections());
    }
    UploadObjectObserver observer = req.getUploadObjectObserver();
    if (observer == null) {
      observer = new UploadObjectObserver();
    }
    observer.init(req, new S3DirectImpl(null), this, es);
    
    String uploadId = observer.onUploadInitiation(req);
    List<PartETag> partETags = new ArrayList();
    MultiFileOutputStream mfos = req.getMultiFileOutputStream();
    if (mfos == null) {
      mfos = new MultiFileOutputStream();
    }
    try
    {
      mfos.init(observer, req.getPartSize(), req.getDiskLimit());
      
      crypto.putLocalObjectSecurely(req, uploadId, mfos);
      for (Future<UploadPartResult> future : observer.getFutures())
      {
        UploadPartResult partResult = (UploadPartResult)future.get();
        partETags.add(new PartETag(partResult.getPartNumber(), partResult.getETag()));
      }
    }
    catch (IOException ex)
    {
      throw ((IOException)onAbort(observer, ex));
    }
    catch (InterruptedException ex)
    {
      throw ((InterruptedException)onAbort(observer, ex));
    }
    catch (ExecutionException ex)
    {
      throw ((ExecutionException)onAbort(observer, ex));
    }
    catch (RuntimeException ex)
    {
      throw ((RuntimeException)onAbort(observer, ex));
    }
    catch (Error ex)
    {
      throw ((Error)onAbort(observer, ex));
    }
    finally
    {
      if (defaultExecutorService) {
        es.shutdownNow();
      }
      mfos.cleanup();
    }
    return observer.onCompletion(partETags);
  }
  
  private <T extends Throwable> T onAbort(UploadObjectObserver observer, T t)
  {
    observer.onAbort();
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */