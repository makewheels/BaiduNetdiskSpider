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
		if (extensionArray != null) {
			for (String extension : extensionArray) {
				if (oldName.endsWith(extension) == false) {
					return null;
				}
			}
		}
		for (String content : contentArray) {
			oldName = oldName.replace(content, "");
		}
		return oldName;
	}

}
