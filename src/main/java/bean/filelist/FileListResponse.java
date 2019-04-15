/**
  * Copyright 2019 bejson.com 
  */
package bean.filelist;

import java.util.List;

/**
 * Auto-generated: 2019-04-15 18:23:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class FileListResponse {

	private int errno;
	private String guid_info;
	private List<EachFile> list;
	private long request_id;
	private int guid;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getGuid_info() {
		return guid_info;
	}

	public void setGuid_info(String guid_info) {
		this.guid_info = guid_info;
	}

	public List<EachFile> getList() {
		return list;
	}

	public void setList(List<EachFile> list) {
		this.list = list;
	}

	public long getRequest_id() {
		return request_id;
	}

	public void setRequest_id(long request_id) {
		this.request_id = request_id;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "FileListResponse [errno=" + errno + ", guid_info=" + guid_info + ", list=" + list + ", request_id="
				+ request_id + ", guid=" + guid + "]";
	}

}