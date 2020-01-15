package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3EncryptionLite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MultiFileOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.IOUtils;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.nio.file.Path;
import java.util.Iterator;
import org.slf4j.Logger;

class CSEMultipartUploadOutputStream$2
  implements Runnable
{
  CSEMultipartUploadOutputStream$2(CSEMultipartUploadOutputStream this$0) {}
  
  public void run()
  {
    try
    {
      UploadObjectRequest req = new UploadObjectRequest(CSEMultipartUploadOutputStream.access$300(this$0), CSEMultipartUploadOutputStream.access$400(this$0), CSEMultipartUploadOutputStream.access$500(this$0), CSEMultipartUploadOutputStream.access$600(this$0)).withMaterialsDescription(
        CSEUtils.getMaterialsDescription(CSEMultipartUploadOutputStream.access$200(this$0), EmrFsUtils.getPathForS3Object(CSEMultipartUploadOutputStream.access$300(this$0), CSEMultipartUploadOutputStream.access$400(this$0))));
      CannedAccessControlList acl = ConfigurationUtils.getAcl(CSEMultipartUploadOutputStream.access$200(this$0));
      if (acl != null) {
        req.setCannedAcl(acl);
      }
      req.withUploadObjectObserver(CSEMultipartUploadOutputStream.access$700(this$0));
      req.withExecutorService(CSEMultipartUploadOutputStream.access$800(this$0));
      req.withPartSize(CSEMultipartUploadOutputStream.access$900(this$0));
      req.withMultiFileOutputStream(new MultiFileOutputStream(((Path)CSEMultipartUploadOutputStream.access$1000(this$0).next()).toFile(), 
        CSEMultipartUploadOutputStream.access$1100(this$0)));
      
      CSEMultipartUploadOutputStream.access$1200(this$0).uploadObject(req);
    }
    catch (Exception e)
    {
      CSEMultipartUploadOutputStream.access$1300().error("failed to upload object {}/{}, trying to close piped input stream.", CSEMultipartUploadOutputStream.access$300(this$0), CSEMultipartUploadOutputStream.access$400(this$0));
      throw new RuntimeException(e);
    }
    finally
    {
      IOUtils.closeQuietly(CSEMultipartUploadOutputStream.access$500(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEMultipartUploadOutputStream.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */