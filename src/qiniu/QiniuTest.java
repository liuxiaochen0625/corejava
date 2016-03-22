/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 22, 2016 10:55:29 AM 
 * @version 1.0 
 *
 */
package qiniu;

import java.util.UUID;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class QiniuTest {

	/**
	 * 七牛操作视频
	 */
	public static void main(String[] args) throws QiniuException {
		Auth auth = Auth.create(StringStorage.ACCESS_KEY, StringStorage.SECRET_KEY);
		String bucket = "liuxiaoqiang";
		String key = "IMG_0341.mp4";
		String new_key = UUID.randomUUID().toString().replaceAll("-", "");
		String entry = bucket+":"+new_key;
		String encodedEntryURI = UrlSafeBase64.encodeToString(entry);
		OperationManager om = new OperationManager(auth);
		
        String notifyURL = "";
        boolean force = true;
        String pipeline = "";
        StringMap params = new StringMap().putNotEmpty("notifyURL", notifyURL)
                .putWhen("force", 1, force).putNotEmpty("pipeline", pipeline);
        //截取视频中的某一段
        String fops = "avthumb/mp4/ss/60/t/100|saveas/"+encodedEntryURI;
        
        fops = "avthumb/mp4/wmImage/aHR0cDovL3Rlc3QtMi5xaW5pdWRuLmNvbS9sb2dvLnBuZw==/wmText/d2Vsb3ZlcWluaXU=/"
        		+ "wmFontColor/cmVk/wmFontSize/60/wmGravityText/North|saveas/"+encodedEntryURI;
       
        try {
            String id = om.pfop(bucket, key, fops, params);
            String purl = "http://api.qiniu.com/status/get/prefop?id=" + id;
            System.out.println(purl);
        } catch (QiniuException e) {
            Response res = e.response;
            System.out.println(res);
            try {
                System.out.println(res.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
            }
        }
	}

}
