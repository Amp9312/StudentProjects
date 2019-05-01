package MonGenFollower;

public class Main {
	public static void main(String[] args) throws Exception {
		GenMon NewMon = new GenMon();
		NewMon.getMonQualities();
		NewMon.generateTest();
		NewMon.obtainQualityTest();
		NewMon.runGame();

	}
}
