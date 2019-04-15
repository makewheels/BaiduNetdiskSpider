package util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

import bean.filelist.EachFile;
import bean.filelist.FileListResponse;
import bean.rename.RenameInfo;
import bean.rename.response.RenameResponse;
import run.Run;

/**
 * 网盘工具类
 * 
 * @author Administrator
 *
 */
public class NetdiskHandler {
	private static Map<String, String> headerMap = new HashMap<>();

	static {
		// 从本地文件读headers
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File(Constants.RESOURCE_PATH, "headers"), Constants.CHARSET);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String line : lines) {
			String[] split = line.split(": ");
			String key = split[0];
			String value = split[1];
			if (key.equals("Accept-Encoding") && value.contains("gzip, ")) {
				value = value.replace("gzip, ", "");
			}
			headerMap.put(key, value);
		}
	}

	/**
	 * 返回指定路径的网盘文件列表
	 * 
	 * @param dir 经过urlEncode的dir，例如：/Postgradute/数学 Math/汤家凤/高等数学 基础班/高数
	 * @return
	 */
	public static List<EachFile> getFileList(String dir) {
		String url = "https://pan.baidu.com/api/list?dir=" + dir;
		String json = HttpUtil.get(url, headerMap);
		FileListResponse fileListResponse = JSON.parseObject(json, FileListResponse.class);
		return fileListResponse.getList();
	}

	/**
	 * 重命名文件，支持可变参数，可重命名单个或多个文件
	 * 
	 * @param renameInfos 重命名的信息：有路径，和新的文件名
	 * @return 重命名之后给的返回json
	 */
	public static RenameResponse rename(RenameInfo... renameInfos) {
		String url = "https://pan.baidu.com/api/filemanager?opera=rename&bdstoken=" + Run.bdstoken;
		String params = null;
		try {
			params = "filelist=" + URLEncoder.encode(JSON.toJSONString(renameInfos), Constants.CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String response = HttpUtil.post(url, headerMap, params);
		return JSON.parseObject(response, RenameResponse.class);
	}

}
