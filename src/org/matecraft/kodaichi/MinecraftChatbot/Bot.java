package org.matecraft.kodaichi.MinecraftChatbot;

public class Bot {
	private String name;
	private Brain brain;
	private long lastMessage;
	
	public Bot(String name, long lastMessage) {
		this.name = new String(name);
		this.brain = new Brain();
		this.lastMessage = lastMessage;
	}
	
	//Returns a copy of the bot's name.
	public String getName() {
		return new String(name);
	}
}
