/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 16, 2016 11:48:36 AM 
 * @version 1.0 
 *
 */
package mongodb;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class MongodbTest {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("test");
		FindIterable<Document> iterable = db.getCollection("restaurants").find();
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
		mongoClient.close();
	}

}
