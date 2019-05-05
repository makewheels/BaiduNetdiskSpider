package run.rename;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.filelist.EachFile;
import bean.rename.RenameInfo;
import bean.rename.response.Info;
import bean.rename.response.RenameResponse;
import util.NetdiskHandler;
import util.RenameUtil;

public class Rename {

	// 浏览器地址栏的网址
	private String browserPath = "https://pan.baidu.com/disk/home#/all?vmode=list&path=%2FTemporary%2F2.%E5%A4%A7%E5%AD%A6%E5%90%8C%E6%AD%A5%E8%AF%BE%E7%A8%8B%2F%E9%AB%98%E7%AD%89%E6%95%B0%E5%AD%A6%E4%B8%8A%E5%86%8C%E3%80%90%E5%90%8C%E6%B5%8E%E4%B8%83%E7%89%88%E3%80%91%E6%B1%A4%E5%AE%B6%E5%87%A4%E7%B2%BE%E8%AE%B2";
	// 要删除文件的，文件名的内容
	private String[] contentArray = { "【认准一手课程微信号：kaoyan2021,2020备考QQ群：613823523】" };
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
		List<EachFile> fileList = NetdiskHandler.getFileListUrlEncoded(dir);
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
			List<Info> info = renameResponse.getInfo();
			for (Info each : info) {
				System.out.println(each);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
