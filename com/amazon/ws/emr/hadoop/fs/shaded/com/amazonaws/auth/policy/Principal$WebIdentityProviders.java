package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

public enum Principal$WebIdentityProviders
{
  Facebook("graph.facebook.com"),  Google("accounts.google.com"),  Amazon("www.amazon.com"),  AllProviders("*");
  
  private String webIdentityProvider;
  
  private Principal$WebIdentityProviders(String webIdentityProvider)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal.WebIdentityProviders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */