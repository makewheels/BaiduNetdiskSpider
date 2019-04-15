package run;

import java.util.ArrayList;
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
	private String browserPath = "https://pan.baidu.com/disk/home?#/all?vmode=list&path=%2FPostgradute%2F%E6%95%B0%E5%AD%A6%20Math%2F%E6%B1%A4%E5%AE%B6%E5%87%A4%2F%E9%AB%98%E7%AD%89%E6%95%B0%E5%AD%A6%20%E5%9F%BA%E7%A1%80%E7%8F%AD%2F%E9%AB%98%E6%95%B0";
	// 要删除文件的，文件名的内容
	private String[] contentArray = { "【微信公众号：【考研仓库】免费分享】" };
	// 要删除文件的拓展名
	private String[] extensionArray = null;

	/**
	 * 重命名：批量重命名该页所有文件
	 */
	@Test
	public void rename() {
		// 路径
		String dir = browserPath.substring(browserPath.indexOf("path=") + 5);
		// 拿到文件列表
		List<EachFile> fileList = NetdiskHandler.getFileList(dir);
		// 重命名信息列表
		List<RenameInfo> renameInfos = new ArrayList<>();
		// 装载重命名信息
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
			renameInfos.add(renameInfo);
		}
		// 批量重命名
		for (RenameInfo renameInfo : renameInfos) {
			RenameResponse renameResponse = NetdiskHandler.rename(renameInfo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<Info> info = renameResponse.getInfo();
			for (Info each : info) {
				System.out.println(each);
			}
		}
	}

}
