/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 2:40:34 PM 
 * @version 1.0 
 *
 */
package mail;

public class SendEmail {
    public SendEmail() {
    }
    /***以后需要两个参数：接收方地址 、 内容***/
    public static void send(String subject, String toaddress,String content)throws Exception {

            String hostName = ReadPropertity.getProperty("emailsmtp");
            String fromAddress = ReadPropertity.getProperty("emailaddress");
            String fromAPass = ReadPropertity.getProperty("emailpass");

            EmailHandle emailHandle = new EmailHandle(hostName);
            emailHandle.setFrom(fromAddress);
            emailHandle.setNeedAuth(true);
            emailHandle.setSubject(subject);
            emailHandle.setBody(content);
            emailHandle.setTo(toaddress);
            emailHandle.setFrom(fromAddress);
            emailHandle.addFileAffix("D:/总图片/XY_1.jpg");// 附件文件路径
            emailHandle.setNamePass(fromAddress, fromAPass);
            emailHandle.sendEmail();
            System.out.println("...............................");
    }
    public static void main(String[] args) {
            try {
    SendEmail.send("带附件的邮件测试","liuxiaochen_0625@163.com","测试内容<a href='http://www.crazyiter.com'>疯狂的IT人</a>");
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }
}