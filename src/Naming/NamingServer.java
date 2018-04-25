package Naming;

public class NamingServer {
	public static void main(String[] args) throws Exception {
		NamingInvoker invoker = new NamingInvoker();
		invoker.invoke(2222);
	}
}
