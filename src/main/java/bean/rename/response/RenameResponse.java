/**
  * Copyright 2019 bejson.com 
  */
package bean.rename.response;

import java.util.List;

/**
 * Auto-generated: 2019-04-15 22:46:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RenameResponse {

	private int errno;
	private List<Info> info;
	private long request_id;

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public int getErrno() {
		return errno;
	}

	public void setInfo(List<Info> info) {
		this.info = info;
	}

	public List<Info> getInfo() {
		return info;
	}

	public void setRequest_id(long request_id) {
		this.request_id = request_id;
	}

	public long getRequest_id() {
		return request_id;
	}

	@Override
	public String toString() {
		return "RenameResponse [errno=" + errno + ", info=" + info + ", request_id=" + request_id + "]";
	}

}