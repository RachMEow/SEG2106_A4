import java.util.Queue;
import java.util.concurrent.locks.Condition;

class OpenOffice implements Office{
	
	//sets of clean, dirty desks
	Queue <Desk> cleanDesks, dirtyDesks;
	Condition clean;
	Condition dirty;
	
	//get an available, clean desk
	public Desk arrive() {
		
		//wait until a clean desk is available
		while(cleanDesks.size()==0) {
			try {
				clean.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cleanDesks.remove();
	}
	
	//leave desk 'desk'
	public void leave(Desk desk) {
		
		//give back a desk, which is now dirty
		dirtyDesks.add(desk);
		
		//signal that a dirty desk is now available
		dirty.signal();
	}
	
	//get a desk to clean
	public Desk service() {
		
		//wait until a dirty desk is available
		while(dirtyDesks.size()==0) {
			try {
				dirty.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dirtyDesks.remove();
	}
	
	//desk 'desk' is now clean
	public void cleaned(Desk desk) {
		
		//give back a desk, which is now clean
		cleanDesks.add(desk);
		
		//signal that a clean desk is available
		clean.signal();
	}
}
