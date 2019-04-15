/**
  * Copyright 2019 bejson.com 
  */
package bean.rename.response;

/**
 * Auto-generated: 2019-04-15 22:46:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Info {

	private int errno;
	private String path;

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "Info [errno=" + errno + ", path=" + path + "]";
	}

}