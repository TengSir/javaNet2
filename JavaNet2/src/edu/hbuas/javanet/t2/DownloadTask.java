package edu.hbuas.javanet.t2;

import java.io.Serializable;

public class DownloadTask  implements Serializable{
	private String url;
	private String name;
	private long length;
	private String time;
	@Override
	public String toString() {
		return "DownloadTask [url=" + url + ", name=" + name + ", length=" + length + ", time=" + time + ", percent="
				+ percent + "]";
	}
	public DownloadTask() {
		super();
	}
	public DownloadTask(String url, String name, long length, String time, float percent) {
		super();
		this.url = url;
		this.name = name;
		this.length = length;
		this.time = time;
		this.percent = percent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	private float percent;

}
