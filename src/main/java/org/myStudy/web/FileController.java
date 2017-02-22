package org.myStudy.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myStudy.utility.FileUtility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import flexjson.JSONSerializer;

/**
 * @author WZY 文件上传控制器
 */
@Controller
@RequestMapping("/file")
public class FileController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws IOException {
		Iterator<String> fileNames = multipartRequest.getFileNames();
		if(!fileNames.hasNext()){
			return jsonResult(false, 0, "no file selected");
		}
		while (fileNames.hasNext()) {
			MultipartFile multipartFile = multipartRequest.getFile(fileNames.next());
			String name = multipartFile.getOriginalFilename();
			//String filePath = multipartRequest.getSession().getServletContext().getRealPath("/") + "upload/" + name;
			try {
				/*File file = new File(filePath);
				// 判断文件路径是否存在，不存在时，创建保存文件所需要的路径
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}*/
				FileUtility.uploadFile("upload", name, multipartFile.getInputStream());
				//multipartFile.transferTo(file);
			} catch (IOException e) {
				return jsonResult(false, 0, e.getMessage());
			}
		}
		// TODO:返回附件ID
		Long attachmentId = 1L;
		return jsonResult(true, attachmentId, "");
	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request) {
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				// 保存文件
				try {
					// 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中)
					String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();
					File saveDir = new File(filePath);
					if (!saveDir.getParentFile().exists())
						saveDir.getParentFile().mkdirs();
					// 转存文件
					file.transferTo(saveDir);
				} catch (Exception e) {
					return jsonResult(false, 0, e.getMessage());
				}
			}
			// TODO:返回附件ID
			Long attachmentId = 1L;
			return jsonResult(true, attachmentId, "");
		} else {
			return jsonResult(false, 0, "no file selected");
		}
	}
	
	/**
	 * 序列化json返回结果
	 * @param result
	 * @param value
	 * @param descriptoin
	 * @return
	 */
	private String jsonResult(boolean result, Object value, String descriptoin) {
		JSONSerializer serializer = new JSONSerializer();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("value", value);
		map.put("des", descriptoin);
		return serializer.serialize(map);
	}
}
