package application.remotecontrol.client;

import java.util.Scanner;

import application.remotecontrol.ControleProxy;
import naming.NamingProxy;

public class ControleClient {

	private static final String HOST = "localhost";
	private static final int NAMINGPORT = 2224;
	private static final String SERVICE = "Remote Control";

	public static void main(String[] args) throws Throwable {
		
		NamingProxy namingProxy = new NamingProxy(HOST, NAMINGPORT);
		Scanner in = new Scanner(System.in);
		ControleProxy controleProxy = (ControleProxy) namingProxy.lookUp(SERVICE);

		System.out.println("channel or vol");
		
		String aux = in.nextLine();
		int channel = in.nextInt();
		
		if (aux.equals("channel")) {
			System.out.println(controleProxy.changeChannel(channel));			
		} else if (aux.equals("vol")) {
			System.out.println(controleProxy.changeLevel(channel));
		}

	}

}
