
public class Clerk extends Thread{
	private Desk desk;
	private int ID;
	final int work_time_max=5000;
	
	Clerk(int ID, Desk desk){
		this.ID=ID;
		this.desk=desk;
	}
	
	public void run() {
		while(true) {
			
			System.out.println("Clerk works");
			try {	
				//work takes 5-10s
				sleep((long)(5+(Math.random()*work_time_max)));
			}catch(InterruptedException e) {
				System.out.println(e);
			}
			
			System.out.println("Clerk finished working");
			desk.setDirty();	
		}
	}
}
