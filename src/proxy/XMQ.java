package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KindWomen kw = new PJL();
		
		//����ģʽ���ŵ�����������ԭ�ͣ����ҿ�����չһϵ�еĹ��ܣ���(double)args[0]/2������Ǯ����
		KindWomen proxy = (KindWomen) Proxy.newProxyInstance(kw.getClass().getClassLoader(), kw.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("��ǰ����");
				  Object invoke = method.invoke(kw, (double)args[0]/2);
				  System.out.println("��������");
				return invoke;
			}
		});
		//proxy.������̾ͻ��Զ����ô���ģʽ��invoke����
		proxy.throwEye(5);
		proxy.doSomething(10);
	}

}
