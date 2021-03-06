package tools;

import java.io.File;

import android.os.Environment;

public class FileUtils {
	public static final String CACHE = "cache";
	public static final String ICON = "icon";
	public static final String ROOT = "GooglePlay";
	/**
	 * ��ȡͼƬ�Ļ����·��
	 * @return
	 */
	public static File getIconDir(){
		return getDir(ICON);
		
	}
	/**
	 * ��ȡ����·��
	 * @return
	 */
	public static File getCacheDir() {
		return getDir(CACHE);
	}
	public static File getDir(String cache) {
		StringBuilder path = new StringBuilder();
		if (isSDAvailable()) {
			path.append(Environment.getExternalStorageDirectory()
					.getAbsolutePath());
			path.append(File.separator);// '/'
			path.append(ROOT);// /mnt/sdcard/GooglePlay
			path.append(File.separator);
			path.append(cache);// /mnt/sdcard/GooglePlay/cache
			
		}else{
			File filesDir = UiUtils.getContext().getCacheDir();    //  cache  getFileDir file
			path.append(filesDir.getAbsolutePath());// /data/data/com.itheima.googleplay/cache
			path.append(File.separator);///data/data/com.itheima.googleplay/cache/
			path.append(cache);///data/data/com.itheima.googleplay/cache/cache
		}
		File file = new File(path.toString());
		if (!file.exists() || !file.isDirectory()) {
			file.mkdirs();// �����ļ���
		}
		return file;

	}

	private static boolean isSDAvailable() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}


}
