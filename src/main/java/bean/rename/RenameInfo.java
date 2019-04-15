/**
  * Copyright 2019 bejson.com 
  */
package bean.rename;

/**
 * Auto-generated: 2019-04-15 19:28:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RenameInfo {

	private String path;
	private String newname;

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewname() {
		return newname;
	}

	@Override
	public String toString() {
		return "RenameInfo [path=" + path + ", newname=" + newname + "]";
	}

}