package telran.multithreading;

public class Truck extends Thread {
	private int load;
	private static long elevator1;
	private static long elevator2;
	private int nRuns;

	@Override
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			loadElevator1();
			loadElevator2();
		}
	}

	private void loadElevator2() {
		elevator2+=load;
		
	}

	private void loadElevator1() {
		elevator1+=load;
	}
	public static long getElevator1() {
		return elevator1;
	}
	public static long getElevator2() {
		return elevator2;
	}

	public Truck(int load, int nRuns) {
		
		this.load = load;
		this.nRuns = nRuns;
	}
}
