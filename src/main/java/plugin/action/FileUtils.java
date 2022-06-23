package plugin.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;

import java.io.*;

/**
 * 文件工具
 */
public class FileUtils {

    /**
     * 获取创建文件夹的目录
     *
     * @param event
     * @return
     */
    public static String getBaseDirPath(AnActionEvent event) {
        String path = DataKeys.VIRTUAL_FILE.getData(event.getDataContext()).getPath();
        if (path != null && path.contains("/src/main/java")) {
            String baseDirPath = path;
            if (new File(path).isFile()) {
                baseDirPath = path.substring(0, path.lastIndexOf("/"));
            }
            return baseDirPath;
        }
        return null;
    }


    /**
     * 读取模板文件中内容
     *
     * @param cls
     * @param path 模板文件路径
     * @return
     */
    public static String getTemplateFileContent(Class cls,String path) {
        System.out.println(path);
        InputStream in = null;
        in = cls.getResourceAsStream(path);
        String content = "";
        try {
            content = new String(readStream(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 读取文件字节
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }

        return outputStream.toByteArray();
    }


    /**
     * 生成
     *
     * @param content   类中的内容
     * @param classPath 类文件路径
     * @param className 类文件名称
     */
    public static void writeToFile(String content, String classPath, String className) {
        try {
            File floder = new File(classPath);
            if (!floder.exists()) {
                floder.mkdirs();
            }

            File file = new File(classPath + "/" + className);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
