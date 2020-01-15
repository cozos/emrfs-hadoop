package com.amazon.ws.emr.hadoop.fs.annotation;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public abstract interface AnnotationProcessor
{
  public static final String ANNOTATION_PROVIDER_PROPERTY_NAME = "fs.s3.annotation.provider";
  public static final Charset SUPPORTED_CHARSET = StandardCharsets.ISO_8859_1;
  public static final int MAX_ANNOTATION_SIZE = 2048;
  
  public abstract Annotations process(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.AnnotationProcessor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */