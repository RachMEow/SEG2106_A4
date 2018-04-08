
public class Cleaner extends Thread{
	private Desk desk;
	private int ID;
	final int work_time_max=4000;
	
	Cleaner(int ID, Desk desk){
		this.ID=ID;
		this.desk=desk;
	}
	
	public void run() {
		while(true) {
			
			System.out.println("Cleaner cleans");
			try {	
				//work takes 1-5s
				sleep((long)(1+(Math.random()*work_time_max)));
			}catch(InterruptedException e) {
				System.out.println(e);
			}
			
			System.out.println("Cleaner finished cleaning");
			desk.setDirty();	
		}
	}
}
