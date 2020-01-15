package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

public class Principal
{
  public static final Principal AllUsers = new Principal("AWS", "*");
  public static final Principal AllServices = new Principal("Service", "*");
  public static final Principal AllWebProviders = new Principal("Federated", "*");
  public static final Principal All = new Principal("*", "*");
  private final String id;
  private final String provider;
  
  public Principal(Services service)
  {
    if (service == null) {
      throw new IllegalArgumentException("Null AWS service name specified");
    }
    id = service.getServiceId();
    provider = "Service";
  }
  
  public Principal(String accountId)
  {
    this("AWS", accountId);
    if (accountId == null) {
      throw new IllegalArgumentException("Null AWS account ID specified");
    }
  }
  
  public Principal(String provider, String id)
  {
    this(provider, id, provider.equals("AWS"));
  }
  
  public Principal(String provider, String id, boolean stripHyphen)
  {
    this.provider = provider;
    this.id = (stripHyphen ? id
      .replace("-", "") : id);
  }
  
  public Principal(WebIdentityProviders webIdentityProvider)
  {
    if (webIdentityProvider == null) {
      throw new IllegalArgumentException("Null web identity provider specified");
    }
    id = webIdentityProvider.getWebIdentityProvider();
    provider = "Federated";
  }
  
  public String getProvider()
  {
    return provider;
  }
  
  public String getId()
  {
    return id;
  }
  
  public static enum Services
  {
    AmazonApiGateway("apigateway.amazonaws.com"),  AWSDataPipeline("datapipeline.amazonaws.com"),  AmazonElasticTranscoder("elastictranscoder.amazonaws.com"),  AmazonEC2("ec2.amazonaws.com"),  AWSOpsWorks("opsworks.amazonaws.com"),  AWSCloudHSM("cloudhsm.amazonaws.com"),  AllServices("*");
    
    private String serviceId;
    
    private Services(String serviceId)
    {
      this.serviceId = serviceId;
    }
    
    public String getServiceId()
    {
      return serviceId;
    }
    
    public static Services fromString(String serviceId)
    {
      if (serviceId != null) {
        for (Services s : values()) {
          if (s.getServiceId().equalsIgnoreCase(serviceId)) {
            return s;
          }
        }
      }
      return null;
    }
  }
  
  public static enum WebIdentityProviders
  {
    Facebook("graph.facebook.com"),  Google("accounts.google.com"),  Amazon("www.amazon.com"),  AllProviders("*");
    
    private String webIdentityProvider;
    
    private WebIdentityProviders(String webIdentityProvider)
    {
      this.webIdentityProvider = webIdentityProvider;
    }
    
    public String getWebIdentityProvider()
    {
      return webIdentityProvider;
    }
    
    public static WebIdentityProviders fromString(String webIdentityProvider)
    {
      if (webIdentityProvider != null) {
        for (WebIdentityProviders provider : values()) {
          if (provider.getWebIdentityProvider().equalsIgnoreCase(webIdentityProvider)) {
            return provider;
          }
        }
      }
      return null;
    }
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + provider.hashCode();
    hashCode = 31 * hashCode + id.hashCode();
    return hashCode;
  }
  
  public boolean equals(Object principal)
  {
    if (this == principal) {
      return true;
    }
    if (principal == null) {
      return false;
    }
    if (!(principal instanceof Principal)) {
      return false;
    }
    Principal other = (Principal)principal;
    if ((getProvider().equals(other.getProvider())) && 
      (getId().equals(other.getId()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */