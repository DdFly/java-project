package com.example.mediatest;

public class Music {

	private String name;
	private String url;
	private long duration;

	public Music(String name, String url, long duration) {
		this.name = name;
		this.url = url;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public long getDuration() {
		return duration;
	}

}
