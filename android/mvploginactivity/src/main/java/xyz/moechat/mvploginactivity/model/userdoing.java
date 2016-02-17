package xyz.moechat.mvploginactivity.model;

/**
 * Created by timeloveboy on 16/2/17.
 */
public class userdoing implements Iuserdoing {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener)
    {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("abc".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setName(username);
                    user.setPassword(Integer.parseInt(password));
                    loginListener.Success(user);
                } else
                {
                    loginListener.passwordError();
                }
            }
        }.start();
    }
}
