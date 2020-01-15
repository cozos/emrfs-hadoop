package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2CredentialsUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EC2MetadataUtils
{
  private static final String REGION = "region";
  private static final String INSTANCE_IDENTITY_DOCUMENT = "instance-identity/document";
  private static final String INSTANCE_IDENTITY_SIGNATURE = "instance-identity/signature";
  private static final String EC2_METADATA_ROOT = "/latest/meta-data";
  private static final String EC2_USERDATA_ROOT = "/latest/user-data/";
  private static final String EC2_DYNAMICDATA_ROOT = "/latest/dynamic/";
  private static final String EC2_METADATA_SERVICE_URL = "http://169.254.169.254";
  public static final String SECURITY_CREDENTIALS_RESOURCE = "/latest/meta-data/iam/security-credentials/";
  private static final int DEFAULT_QUERY_RETRIES = 3;
  private static final int MINIMUM_RETRY_WAIT_TIME_MILLISECONDS = 250;
  private static Map<String, String> cache = new ConcurrentHashMap();
  private static final ObjectMapper mapper = new ObjectMapper();
  
  static
  {
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    mapper
      .setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);
  }
  
  private static final Log log = LogFactory.getLog(EC2MetadataUtils.class);
  
  public static String getAmiId()
  {
    return fetchData("/latest/meta-data/ami-id");
  }
  
  public static String getAmiLaunchIndex()
  {
    return fetchData("/latest/meta-data/ami-launch-index");
  }
  
  public static String getAmiManifestPath()
  {
    return fetchData("/latest/meta-data/ami-manifest-path");
  }
  
  public static List<String> getAncestorAmiIds()
  {
    return getItems("/latest/meta-data/ancestor-ami-ids");
  }
  
  public static String getInstanceAction()
  {
    return fetchData("/latest/meta-data/instance-action");
  }
  
  public static String getInstanceId()
  {
    return fetchData("/latest/meta-data/instance-id");
  }
  
  public static String getInstanceType()
  {
    return fetchData("/latest/meta-data/instance-type");
  }
  
  public static String getLocalHostName()
  {
    return fetchData("/latest/meta-data/local-hostname");
  }
  
  public static String getMacAddress()
  {
    return fetchData("/latest/meta-data/mac");
  }
  
  public static String getPrivateIpAddress()
  {
    return fetchData("/latest/meta-data/local-ipv4");
  }
  
  public static String getAvailabilityZone()
  {
    return fetchData("/latest/meta-data/placement/availability-zone");
  }
  
  public static List<String> getProductCodes()
  {
    return getItems("/latest/meta-data/product-codes");
  }
  
  public static String getPublicKey()
  {
    return fetchData("/latest/meta-data/public-keys/0/openssh-key");
  }
  
  public static String getRamdiskId()
  {
    return fetchData("/latest/meta-data/ramdisk-id");
  }
  
  public static String getReservationId()
  {
    return fetchData("/latest/meta-data/reservation-id");
  }
  
  public static List<String> getSecurityGroups()
  {
    return getItems("/latest/meta-data/security-groups");
  }
  
  public static IAMInfo getIAMInstanceProfileInfo()
  {
    String json = getData("/latest/meta-data/iam/info");
    if (null == json) {
      return null;
    }
    try
    {
      return (IAMInfo)mapper.readValue(json, IAMInfo.class);
    }
    catch (Exception e)
    {
      log.warn("Unable to parse IAM Instance profile info (" + json + "): " + e
        .getMessage(), e);
    }
    return null;
  }
  
  public static InstanceInfo getInstanceInfo()
  {
    return doGetInstanceInfo(getData("/latest/dynamic/instance-identity/document"));
  }
  
  public static String getInstanceSignature()
  {
    return fetchData("/latest/dynamic/instance-identity/signature");
  }
  
  static InstanceInfo doGetInstanceInfo(String json)
  {
    if (null != json) {
      try
      {
        return (InstanceInfo)Jackson.fromJsonString(json, InstanceInfo.class);
      }
      catch (Exception e)
      {
        log.warn("Unable to parse dynamic EC2 instance info (" + json + ") : " + e
          .getMessage(), e);
      }
    }
    return null;
  }
  
  public static String getEC2InstanceRegion()
  {
    return doGetEC2InstanceRegion(getData("/latest/dynamic/instance-identity/document"));
  }
  
  static String doGetEC2InstanceRegion(String json)
  {
    if (null != json) {
      try
      {
        JsonNode node = mapper.readTree(json.getBytes(StringUtils.UTF8));
        JsonNode region = node.findValue("region");
        return region.asText();
      }
      catch (Exception e)
      {
        log.warn("Unable to parse EC2 instance info (" + json + ") : " + e
          .getMessage(), e);
      }
    }
    return null;
  }
  
  public static Map<String, IAMSecurityCredential> getIAMSecurityCredentials()
  {
    Map<String, IAMSecurityCredential> credentialsInfoMap = new HashMap();
    
    List<String> credentials = getItems("/latest/meta-data/iam/security-credentials");
    if (credentials != null) {
      for (String credential : credentials)
      {
        String json = getData("/latest/meta-data/iam/security-credentials/" + credential);
        try
        {
          IAMSecurityCredential credentialInfo = (IAMSecurityCredential)mapper.readValue(json, IAMSecurityCredential.class);
          credentialsInfoMap.put(credential, credentialInfo);
        }
        catch (Exception e)
        {
          log.warn("Unable to process the credential (" + credential + "). " + e.getMessage(), e);
        }
      }
    }
    return credentialsInfoMap;
  }
  
  public static Map<String, String> getBlockDeviceMapping()
  {
    Map<String, String> blockDeviceMapping = new HashMap();
    
    List<String> devices = getItems("/latest/meta-data/block-device-mapping");
    if (devices != null) {
      for (String device : devices) {
        blockDeviceMapping.put(device, getData("/latest/meta-data/block-device-mapping/" + device));
      }
    }
    return blockDeviceMapping;
  }
  
  public static List<NetworkInterface> getNetworkInterfaces()
  {
    List<NetworkInterface> networkInterfaces = new LinkedList();
    
    List<String> macs = getItems("/latest/meta-data/network/interfaces/macs/");
    if (macs != null) {
      for (String mac : macs)
      {
        String key = mac.trim();
        if (key.endsWith("/")) {
          key = key.substring(0, key.length() - 1);
        }
        networkInterfaces.add(new NetworkInterface(key));
      }
    }
    return networkInterfaces;
  }
  
  public static String getUserData()
  {
    return getData("/latest/user-data/");
  }
  
  public static String getData(String path)
  {
    return getData(path, 3);
  }
  
  public static String getData(String path, int tries)
  {
    List<String> items = getItems(path, tries, true);
    if ((null != items) && (items.size() > 0)) {
      return (String)items.get(0);
    }
    return null;
  }
  
  public static List<String> getItems(String path)
  {
    return getItems(path, 3, false);
  }
  
  public static List<String> getItems(String path, int tries)
  {
    return getItems(path, tries, false);
  }
  
  private static List<String> getItems(String path, int tries, boolean slurp)
  {
    if (tries == 0) {
      throw new SdkClientException("Unable to contact EC2 metadata service.");
    }
    try
    {
      String hostAddress = getHostAddressForEC2MetadataService();
      String response = EC2CredentialsUtils.getInstance().readResource(new URI(hostAddress + path));
      List<String> items;
      if (slurp) {
        items = Collections.singletonList(response);
      }
      return Arrays.asList(response.split("\n"));
    }
    catch (AmazonClientException ace)
    {
      log.warn("Unable to retrieve the requested metadata (" + path + "). " + ace.getMessage(), ace);
      return null;
    }
    catch (Exception e)
    {
      int pause = (int)(Math.pow(2.0D, 3 - tries) * 250.0D);
      try
      {
        Thread.sleep(pause < 250 ? 250L : pause);
      }
      catch (InterruptedException e1)
      {
        Thread.currentThread().interrupt();
      }
    }
    return getItems(path, tries - 1, slurp);
  }
  
  private static String fetchData(String path)
  {
    return fetchData(path, false);
  }
  
  private static String fetchData(String path, boolean force)
  {
    try
    {
      if ((force) || (!cache.containsKey(path))) {
        cache.put(path, getData(path));
      }
      return (String)cache.get(path);
    }
    catch (Exception e) {}
    return null;
  }
  
  public static String getHostAddressForEC2MetadataService()
  {
    String host = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.ec2MetadataServiceEndpointOverride");
    return host != null ? host : "http://169.254.169.254";
  }
  
  public static class IAMInfo
  {
    public String code;
    public String message;
    public String lastUpdated;
    public String instanceProfileArn;
    public String instanceProfileId;
  }
  
  public static class IAMSecurityCredential
  {
    public String code;
    public String message;
    public String lastUpdated;
    public String type;
    public String accessKeyId;
    public String secretAccessKey;
    public String token;
    public String expiration;
    @Deprecated
    public String secretAcessKey;
  }
  
  public static class InstanceInfo
  {
    private final String pendingTime;
    private final String instanceType;
    private final String imageId;
    private final String instanceId;
    private final String[] billingProducts;
    private final String architecture;
    private final String accountId;
    private final String kernelId;
    private final String ramdiskId;
    private final String region;
    private final String version;
    private final String availabilityZone;
    private final String privateIp;
    private final String[] devpayProductCodes;
    
    @JsonCreator
    public InstanceInfo(@JsonProperty(value="pendingTime", required=true) String pendingTime, @JsonProperty(value="instanceType", required=true) String instanceType, @JsonProperty(value="imageId", required=true) String imageId, @JsonProperty(value="instanceId", required=true) String instanceId, @JsonProperty(value="billingProducts", required=false) String[] billingProducts, @JsonProperty(value="architecture", required=true) String architecture, @JsonProperty(value="accountId", required=true) String accountId, @JsonProperty(value="kernelId", required=true) String kernelId, @JsonProperty(value="ramdiskId", required=false) String ramdiskId, @JsonProperty(value="region", required=true) String region, @JsonProperty(value="version", required=true) String version, @JsonProperty(value="availabilityZone", required=true) String availabilityZone, @JsonProperty(value="privateIp", required=true) String privateIp, @JsonProperty(value="devpayProductCodes", required=false) String[] devpayProductCodes)
    {
      this.pendingTime = pendingTime;
      this.instanceType = instanceType;
      this.imageId = imageId;
      this.instanceId = instanceId;
      this.billingProducts = (billingProducts == null ? null : 
        (String[])billingProducts.clone());
      this.architecture = architecture;
      this.accountId = accountId;
      this.kernelId = kernelId;
      this.ramdiskId = ramdiskId;
      this.region = region;
      this.version = version;
      this.availabilityZone = availabilityZone;
      this.privateIp = privateIp;
      this.devpayProductCodes = (devpayProductCodes == null ? null : 
        (String[])devpayProductCodes.clone());
    }
    
    public String getPendingTime()
    {
      return pendingTime;
    }
    
    public String getInstanceType()
    {
      return instanceType;
    }
    
    public String getImageId()
    {
      return imageId;
    }
    
    public String getInstanceId()
    {
      return instanceId;
    }
    
    public String[] getBillingProducts()
    {
      return billingProducts == null ? null : (String[])billingProducts.clone();
    }
    
    public String getArchitecture()
    {
      return architecture;
    }
    
    public String getAccountId()
    {
      return accountId;
    }
    
    public String getKernelId()
    {
      return kernelId;
    }
    
    public String getRamdiskId()
    {
      return ramdiskId;
    }
    
    public String getRegion()
    {
      return region;
    }
    
    public String getVersion()
    {
      return version;
    }
    
    public String getAvailabilityZone()
    {
      return availabilityZone;
    }
    
    public String getPrivateIp()
    {
      return privateIp;
    }
    
    public String[] getDevpayProductCodes()
    {
      return devpayProductCodes == null ? null : (String[])devpayProductCodes.clone();
    }
  }
  
  public static class NetworkInterface
  {
    private String path;
    private String mac;
    private List<String> availableKeys;
    private Map<String, String> data = new HashMap();
    
    public NetworkInterface(String macAddress)
    {
      mac = macAddress;
      path = ("/network/interfaces/macs/" + mac + "/");
    }
    
    public String getMacAddress()
    {
      return mac;
    }
    
    public String getOwnerId()
    {
      return getData("owner-id");
    }
    
    public String getProfile()
    {
      return getData("profile");
    }
    
    public String getHostname()
    {
      return getData("local-hostname");
    }
    
    public List<String> getLocalIPv4s()
    {
      return getItems("local-ipv4s");
    }
    
    public String getPublicHostname()
    {
      return getData("public-hostname");
    }
    
    public List<String> getPublicIPv4s()
    {
      return getItems("public-ipv4s");
    }
    
    public List<String> getSecurityGroups()
    {
      return getItems("security-groups");
    }
    
    public List<String> getSecurityGroupIds()
    {
      return getItems("security-group-ids");
    }
    
    public String getSubnetIPv4CidrBlock()
    {
      return getData("subnet-ipv4-cidr-block");
    }
    
    public String getSubnetId()
    {
      return getData("subnet-id");
    }
    
    public String getVpcIPv4CidrBlock()
    {
      return getData("vpc-ipv4-cidr-block");
    }
    
    public String getVpcId()
    {
      return getData("vpc-id");
    }
    
    public List<String> getIPv4Association(String publicIp)
    {
      return EC2MetadataUtils.getItems("/latest/meta-data" + path + "ipv4-associations/" + publicIp);
    }
    
    private String getData(String key)
    {
      if (data.containsKey(key)) {
        return (String)data.get(key);
      }
      if (null == availableKeys) {
        availableKeys = EC2MetadataUtils.getItems("/latest/meta-data" + path);
      }
      if ((availableKeys != null) && (availableKeys.contains(key)))
      {
        data.put(key, EC2MetadataUtils.getData("/latest/meta-data" + path + key));
        return (String)data.get(key);
      }
      return null;
    }
    
    private List<String> getItems(String key)
    {
      if (null == availableKeys) {
        availableKeys = EC2MetadataUtils.getItems("/latest/meta-data" + path);
      }
      if ((availableKeys != null) && (availableKeys.contains(key))) {
        return EC2MetadataUtils.getItems("/latest/meta-data" + path + key);
      }
      return new LinkedList();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */