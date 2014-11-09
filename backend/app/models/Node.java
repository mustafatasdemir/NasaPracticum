package models;

public class Node {
	
	private String match;
	private String name;
	private String artist;
	private String detail;
	private String id;
	private String group;
	private long playcount;

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public long getPlaycount() {
		return playcount;
	}

	public void setPlaycount(long playcount) {
		this.playcount = playcount;
	}

	public Node(String match, String name, String artist, String detail, String id, String group, long playcount) {
		this.match = match;
		this.name = name;
		this.artist = artist;
		this.detail = detail;
		this.id = id;
		this.group = group;
		this.playcount = playcount;
	}

}
