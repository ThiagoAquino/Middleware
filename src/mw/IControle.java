package mw;

public interface IControle {
	
//	public int up(int vol);
//	public int down(int vol);
//	public int nextChannel(int channel);
//	public int previousChannel(int channel);
//	public int changeChannel(int channel);
	
	public String changeChannel(int channel) throws Throwable;
	public String changeLevel(int level)throws Throwable;
}
