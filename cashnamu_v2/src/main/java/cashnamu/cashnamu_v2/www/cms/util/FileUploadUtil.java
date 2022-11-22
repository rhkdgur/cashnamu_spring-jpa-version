package cashnamu.cashnamu_v2.www.cms.util;

import java.io.File;

public class FileUploadUtil {

	//다이렉트 파일 만들기
	public static boolean  makeFile(String path) throws Exception{
		boolean flag = false;
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
			flag = true;
		}else {
			flag= false;
		}
		return flag;
	}
}
