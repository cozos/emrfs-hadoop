package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@DynamoDB
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface DynamoDBIndexHashKey
{
  String attributeName() default "";
  
  String globalSecondaryIndexName() default "";
  
  String[] globalSecondaryIndexNames() default {};
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */