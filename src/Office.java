
public interface Office {
	//get an available, clean desk
	public Desk arrive();
	
	//leave desk 'desk'
	public void leave(Desk desk);
	
	//get a desk to clean
	public Desk service();
	
	//desk 'desk' is now clean
	public void cleaned(Desk desk);
	
}
