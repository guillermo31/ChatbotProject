package chat.model;
import java.util.ArrayList;
 

public class ChatBot
{
	//data members
	private String currentUser;
	private String joke;
	private String content;
	
	//constructors
	public ChatBot()
	{
		
	}
	
	public ChatBot(String currentUser, String joke, String content) 
	{
		this.currentUser = currentUser;
		this.joke = joke;
		this.content = content;
	}
	
	//getters
	public String getCurrentUser()
	{
		return currentUser;
	}
	public String getJoke() 
	{
		return joke;
	}
	public String getContent()
	{
		return content;
	}
	
	//setters
	public void setCurrentUser(String user)
	{
		this.currentUser = user;
	}
	public void setJoke(String joke)
	{
		this.joke = joke;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
	//methods
	public String askName()
	{
		return " ";
	}
	
	public void responses()
	{
		ArrayList<String> responseList = new ArrayList<String>();
		
	}
	
	public void spooky()
	{
		ArrayList<String> spookyList = new ArrayList<String>();
		
	}
	
	public String toString()
	{
		String description = "Your name is " + currentUser;
		
		return description;
	}
	
	
	
	
	
	
}
