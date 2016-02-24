/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 24, 2016 3:29:13 PM 
 * @version 1.0 
 *
 */
package metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;

/**
 * @author wyyl1
 */
public class Test {

    /**
     * 图片数据元提取
     */
    public static void metadataExtractor(){
        File jpegFile = new File("D:\\reus.png");
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag);
                }
            }
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        metadataExtractor();
    }
}
