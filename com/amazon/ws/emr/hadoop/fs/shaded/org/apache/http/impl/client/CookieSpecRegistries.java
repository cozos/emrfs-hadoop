package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.RegistryBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixMatcherLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.DefaultCookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.IgnoreSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.NetscapeDraftSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC6265CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.RFC6265CookieSpecProvider.CompatibilityLevel;

public final class CookieSpecRegistries
{
  public static RegistryBuilder<CookieSpecProvider> createDefaultBuilder(PublicSuffixMatcher publicSuffixMatcher)
  {
    CookieSpecProvider defaultProvider = new DefaultCookieSpecProvider(publicSuffixMatcher);
    CookieSpecProvider laxStandardProvider = new RFC6265CookieSpecProvider(RFC6265CookieSpecProvider.CompatibilityLevel.RELAXED, publicSuffixMatcher);
    
    CookieSpecProvider strictStandardProvider = new RFC6265CookieSpecProvider(RFC6265CookieSpecProvider.CompatibilityLevel.STRICT, publicSuffixMatcher);
    
    return RegistryBuilder.create().register("default", defaultProvider).register("best-match", defaultProvider).register("compatibility", defaultProvider).register("standard", laxStandardProvider).register("standard-strict", strictStandardProvider).register("netscape", new NetscapeDraftSpecProvider()).register("ignoreCookies", new IgnoreSpecProvider());
  }
  
  public static RegistryBuilder<CookieSpecProvider> createDefaultBuilder()
  {
    return createDefaultBuilder(PublicSuffixMatcherLoader.getDefault());
  }
  
  public static Lookup<CookieSpecProvider> createDefault()
  {
    return createDefault(PublicSuffixMatcherLoader.getDefault());
  }
  
  public static Lookup<CookieSpecProvider> createDefault(PublicSuffixMatcher publicSuffixMatcher)
  {
    return createDefaultBuilder(publicSuffixMatcher).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.CookieSpecRegistries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */