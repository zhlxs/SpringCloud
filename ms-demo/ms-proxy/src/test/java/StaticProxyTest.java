import com.demo.sp.bean.User;
import com.demo.sp.proxy.UserStaticProxy;
import com.demo.sp.service.IUserService;
import com.demo.sp.service.impl.UserServiceImpl;

public class StaticProxyTest
{
    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserStaticProxy userStaticProxy = new UserStaticProxy(userService);
        userStaticProxy.add(new User("1","胡山林","26",1));
    }
}
