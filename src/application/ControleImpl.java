package application;

public class ControleImpl implements  IControle {

	public String changeChannel(int channel) {
		return "Canal alterado para o Canal " + channel;
	}

	public String changeLevel(int level) {
		return "Volume Alterado + " + level + " pontos";
	}

}
