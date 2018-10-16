package chat.model;
import java.util.ArrayList;
 

public class ChatBot
{
	//data members
	private String currentUser;
	private String joke;
	private String content;
	
	private ArrayList<String> responseList;
	private ArrayList<String> spookyList;
	
	//constructors
	public ChatBot()
	{
		
	}
	
	public ChatBot(String currentUser, String joke, String content) 
	{
		this.currentUser = currentUser;
		this.joke = joke;
		this.content = content;
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
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
	public ArrayList<String> getResponseList()
	{
		return responseList;
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
	public void setResponseList(ArrayList<String> responses)
	{
		this.responseList = responses;
	}
	
	//methods
	public String askName()
	{
		return " ";
	}
	
	private void buildLists()
	{
		responseList.add("hello! what's up?");
		responseList.add("See ya");
	}
	
	
	public String toString()
	{
		String description = "Your name is " + currentUser;
		
		return description;
	}
	
	
	
	
	
	
}
