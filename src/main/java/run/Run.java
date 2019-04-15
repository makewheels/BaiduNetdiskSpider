package run;

import java.util.List;

import org.junit.Test;

import bean.filelist.EachFile;
import bean.rename.RenameInfo;
import bean.rename.response.Info;
import bean.rename.response.RenameResponse;
import util.NetdiskHandler;
import util.RenameUtil;

public class Run {
	// bdstoken
	public static String bdstoken = "b87dfb127ada05e71b91016127111242";
	// 浏览器地址栏的网址
	private String browserPath = "https://pan.baidu.com/disk/home?#/all?vmode=list&path=%2FPostgradute%2FTest";
	// 要删除文件的，文件名的内容
	private String[] contentArray = { "新建文本文档" };
	// 要删除文件的拓展名
	private String[] extensionArray = null;

	/**
	 * 重命名：批量重命名该页所有文件
	 */
	@Test
	public void rename() {
		String dir = browserPath.substring(browserPath.indexOf("path=") + 5);
		List<EachFile> fileList = NetdiskHandler.getFileList(dir);
		RenameInfo[] renameInfos = new RenameInfo[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			EachFile eachFile = fileList.get(i);
			RenameInfo renameInfo = new RenameInfo();
			renameInfo.setPath(eachFile.getPath());
			String oldName = eachFile.getServer_filename();
			String newName = RenameUtil.getNewName(oldName, contentArray, extensionArray);
			if (newName == null) {
				continue;
			}
			renameInfo.setNewname(newName);
			renameInfos[i] = renameInfo;
		}
		RenameResponse renameResponse = NetdiskHandler.rename(renameInfos);
		System.out.println("root Errno:" + renameResponse.getErrno());
		List<Info> info = renameResponse.getInfo();
		for (Info each : info) {
			System.out.println(each);
		}
	}

}
