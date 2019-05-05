package util;

/**
 * 重命名工具类
 * 
 * @author Administrator
 *
 */
public class RenameUtil {

	/**
	 * 根据指定的重命名规则，返回新的文件名
	 * 
	 * @param oldName
	 * @param contentArray   要删除的内容
	 * @param extensionArray 如果传null，则表示不要求拓展名
	 * @return 如果不符合要求，则返回null
	 */
	public static String getNewName(String oldName, String[] contentArray, String[] extensionArray) {
		// 检验拓展名
		if (extensionArray != null) {
			for (String extension : extensionArray) {
				if (oldName.endsWith(extension) == false) {
					return null;
				}
			}
		}
		// 检验文件名，是否需要重命名
		boolean needRename = false;
		for (String content : contentArray) {
			if (oldName.contains(content)) {
				needRename = true;
				break;
			}
		}
		// 如果不需要重命名
		if (needRename == false) {
			return null;
		}
		// 删除文件名中要删除的内容
		for (String content : contentArray) {
			oldName = oldName.replace(content, "");
		}
		return oldName;
	}

}
