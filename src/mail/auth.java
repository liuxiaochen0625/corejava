/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 3:43:12 PM 
 * @version 1.0 
 *
 */
package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class auth extends Authenticator{
    //Authenticator中的唯一一个方法，作用是返回用来认证的用户名和密码
    public PasswordAuthentication getPasswordAuthentication() {
                    //此处的username,password对应你163邮箱的账号名称和密码
        return new PasswordAuthentication("2656483638@qq.com", "liu920625,./");
        }
}