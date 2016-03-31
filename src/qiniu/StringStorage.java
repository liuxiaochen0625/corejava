/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 3, 2016 10:44:28 AM 
 * @version 1.0 
 *
 */
package qiniu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

public class StringStorage {
	public final static String ACCESS_KEY = "Fm_suhFTIjJJOW0PYvcH3UIUB2wFN_VehKRQNa9Z";
	public final static String SECRET_KEY = "IeWgV0BrNIw12A0iYY42cDGhX_h20U-GgoBv6XzM";
	public final static Auth AUTH = Auth.create(ACCESS_KEY, SECRET_KEY);
	public final static BucketManager bucketManager = new BucketManager(AUTH);
	
	/**
	 * 
	 * 获取七牛云某个bucket下的所有文件
	 * @param bucket	bucket名字
	 * @param prefix	想要获取的文件前缀,""为所有文件
	 * @param limit		每次获取文件个数,最大为1000
	 * 
	 */
	
	public static List<FileInfo> getAllFileOfBucket(String bucket,String prefix,int limit){
		ArrayList<FileInfo> list = new ArrayList<FileInfo>();
		BucketManager.FileListIterator it = bucketManager.createFileListIterator(bucket, prefix, limit, "");
		while(it.hasNext()){
			FileInfo []items = it.next();
			if(null!=items&&items.length>0)
				list.addAll(Arrays.asList(items));
		}
		return list;
	}
	
	/**
	 * 重命名某个bucket下面的key
	 * 
	 */
	public static void renameKey(String bucket,String srcKey,String desKey){
		try {
			bucketManager.rename(bucket, srcKey, desKey);
		} catch (QiniuException e) {
			e.printStackTrace();
			System.out.println(srcKey);
		}
	}
	
}
