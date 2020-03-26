import com.demo.sp.bean.User;
import com.demo.sp.proxy.CGLibProxy;
import com.demo.sp.service.IUserService;
import com.demo.sp.service.impl.UserServiceImpl;

public class CGLibProxyTest
{
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserService userService = (IUserService) cgLibProxy.bind(new UserServiceImpl());
        userService.addUser(new User("1","胡山林","26",1));
        userService.getUser("1");
    }
}
