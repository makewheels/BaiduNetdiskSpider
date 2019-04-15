/**
  * Copyright 2019 bejson.com 
  */
package bean.filelist;

/**
 * Auto-generated: 2019-04-15 18:23:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class EachFile {

	private long server_mtime;
	private int category;
	private int unlist;
	private long fs_id;
	private long oper_id;
	private long server_ctime;
	private int isdir;
	private long local_mtime;
	private long size;
	private Thumbs thumbs;
	private int share;
	private String md5;
	private String path;
	private long local_ctime;
	private String server_filename;

	public void setServer_mtime(long server_mtime) {
		this.server_mtime = server_mtime;
	}

	public long getServer_mtime() {
		return server_mtime;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCategory() {
		return category;
	}

	public void setUnlist(int unlist) {
		this.unlist = unlist;
	}

	public int getUnlist() {
		return unlist;
	}

	public void setFs_id(long fs_id) {
		this.fs_id = fs_id;
	}

	public long getFs_id() {
		return fs_id;
	}

	public void setOper_id(long oper_id) {
		this.oper_id = oper_id;
	}

	public long getOper_id() {
		return oper_id;
	}

	public void setServer_ctime(long server_ctime) {
		this.server_ctime = server_ctime;
	}

	public long getServer_ctime() {
		return server_ctime;
	}

	public void setIsdir(int isdir) {
		this.isdir = isdir;
	}

	public int getIsdir() {
		return isdir;
	}

	public void setLocal_mtime(long local_mtime) {
		this.local_mtime = local_mtime;
	}

	public long getLocal_mtime() {
		return local_mtime;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	public void setThumbs(Thumbs thumbs) {
		this.thumbs = thumbs;
	}

	public Thumbs getThumbs() {
		return thumbs;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public int getShare() {
		return share;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getMd5() {
		return md5;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setLocal_ctime(long local_ctime) {
		this.local_ctime = local_ctime;
	}

	public long getLocal_ctime() {
		return local_ctime;
	}

	public void setServer_filename(String server_filename) {
		this.server_filename = server_filename;
	}

	public String getServer_filename() {
		return server_filename;
	}

	@Override
	public String toString() {
		return "EachFile [server_mtime=" + server_mtime + ", category=" + category + ", unlist=" + unlist + ", fs_id="
				+ fs_id + ", oper_id=" + oper_id + ", server_ctime=" + server_ctime + ", isdir=" + isdir
				+ ", local_mtime=" + local_mtime + ", size=" + size + ", thumbs=" + thumbs + ", share=" + share
				+ ", md5=" + md5 + ", path=" + path + ", local_ctime=" + local_ctime + ", server_filename="
				+ server_filename + "]";
	}

}