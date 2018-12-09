package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KindWomen kw = new PJL();
		
		//代理模式的优点在于隐藏了原型，并且可以扩展一系列的功能，如(double)args[0]/2，将金钱减半
		KindWomen proxy = (KindWomen) Proxy.newProxyInstance(kw.getClass().getClassLoader(), kw.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("先前操作");
				  Object invoke = method.invoke(kw, (double)args[0]/2);
				  System.out.println("后续操作");
				return invoke;
			}
		});
		//proxy.这个过程就会自动调用代理模式的invoke方法
		proxy.throwEye(5);
		proxy.doSomething(10);
	}

}
