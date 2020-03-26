import com.demo.sp.bean.User;
import com.demo.sp.proxy.DynamicProxy;
import com.demo.sp.service.IUserService;
import com.demo.sp.service.impl.UserServiceImpl;

public class DynamicProxyTest
{
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        IUserService userService = (IUserService) dynamicProxy.bind(new UserServiceImpl());
        userService.addUser(new User("1","胡山林","26",1));
        userService.getUser("1");
    }
}
