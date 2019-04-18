package run;

import java.util.List;

import bean.filelist.EachFile;
import util.NetdiskHandler;

/**
 * 遍历
 * 
 * @author Administrator
 *
 */
public class Traverse {

	public static void handleFolder(String path) {
		// 拿到文件列表
		List<EachFile> fileList = NetdiskHandler.getFileList(path);
		// 遍历所有文件
		for (EachFile eachFile : fileList) {
			// 统计现在是几级目录
			int level = 0;
			for (int i = 0; i < path.length(); i++) {
				char c = path.charAt(i);
				if (c == '/') {
					level++;
				}
			}
			// 打印缩进
			for (int i = 0; i < level - 1; i++) {
				System.out.print("  ");
			}
			String filename = eachFile.getServer_filename();
			// 如果是文件夹
			if (eachFile.getIsdir() == 1) {
				System.out.println("/ " + filename);
				if (path.equals("/")) {
					handleFolder(path + filename);
				} else {
					handleFolder(path + "/" + filename);
				}
			} else {
				// 如果是文件
				System.out.println("- " + filename);
			}
		}
	}

	public static void main(String[] args) {
		handleFolder("/QB");
	}

}
