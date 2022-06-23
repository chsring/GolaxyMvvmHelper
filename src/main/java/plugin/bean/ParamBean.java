package plugin.bean;

import plugin.action.TemplateUtils;
import plugin.action.TypeContant;
import com.google.gson.Gson;
import com.intellij.openapi.project.Project;

public class ParamBean {


    /**
     * @param project
     * @param baseDirPath 鼠标右击的所在目录
     * @param type
     */
    public ParamBean(Project project, String baseDirPath, String createPackName, String classPrefix, int type) {
        this.baseDirPath = baseDirPath;
        this.baseDirPackName = TemplateUtils.getClassPackName(baseDirPath);
        this.packName = TemplateUtils.getPackageName(project, baseDirPath);
        this.createPackName = createPackName.toLowerCase();
        this.classPrefix = TemplateUtils.getClassPrefix(classPrefix);
        this.moduleName = TemplateUtils.getMname(baseDirPath);
        this.layoutPath = TemplateUtils.getResPath(project, baseDirPath) + "/layout";
        this.type = type;
        switch (type) {
            case TypeContant.JAVA_NORMAL_ACTIVITY:
                this.tempDir = "/template/jnormal/";
                this.tempFiles = TemplateUtils.jNormalActivityFiles;
                break;
            case TypeContant.JAVA_NORMAL_FRAGMENT:
                this.tempDir = "/template/jnormal/";
                this.tempFiles = TemplateUtils.jNormalFragmentyFiles;
                break;
            case TypeContant.JAVA_LIST_ACTIVITY:
                this.tempDir = "/template/jlist/";
                this.tempFiles = TemplateUtils.jListActivityFiles;
                break;
            case TypeContant.JAVA_LIST_FRAGMENT:
                this.tempDir = "/template/jlist/";
                this.tempFiles = TemplateUtils.jListFragmentFiles;
                break;
            case TypeContant.JAVA_PAGING_ACTIVITY:
                this.tempDir = "/template/jpaging/";
                this.tempFiles = TemplateUtils.jPagingActivityFiles;
                break;
            case TypeContant.JAVA_PAGING_FRAGMENT:
                this.tempDir = "/template/jpaging/";
                this.tempFiles = TemplateUtils.jPagingFragmentFiles;
                break;
            case TypeContant.KOTLIN_NORMAL_ACTIVITY:
                this.tempDir = "/template/knormal/";
                this.tempFiles = TemplateUtils.kNormalActivityFiles;
                break;
            case TypeContant.KOTLIN_NORMAL_FRAGMENT:
                this.tempDir = "/template/knormal/";
                this.tempFiles = TemplateUtils.kNormalFragmentyFiles;
                break;
            case TypeContant.KOTLIN_LIST_ACTIVITY:
                this.tempDir = "/template/klist/";
                this.tempFiles = TemplateUtils.kListActivityFiles;
                break;
            case TypeContant.KOTLIN_LIST_FRAGMENT:
                this.tempDir = "/template/klist/";
                this.tempFiles = TemplateUtils.kListFragmentFiles;
                break;
            case TypeContant.KOTLIN_PAGING_ACTIVITY:
                this.tempDir = "/template/kpaging/";
                this.tempFiles = TemplateUtils.kPagingActivityFiles;
                break;
            case TypeContant.KOTLIN_PAGING_FRAGMENT:
                this.tempDir = "/template/kpaging/";
                this.tempFiles = TemplateUtils.kPagingFragmentFiles;
                break;
        }
        if (tempDir.contains("/template/j")) {
            suffix = ".java";
        } else {
            suffix = ".kt";
        }
    }

    //com.foryou.driver.test   在当前目录下右击 输入：order
    public String baseDirPath; //    /模块名称/src/main/java/com/foryou/driver/test
    public String baseDirPackName;//com.foryou.driver.test
    public String createPackName;// order
    public String packName;//包名  com.foryou.driver
    public String classPrefix;//类前缀
    public String moduleName;//模块名称 b_mine
    public String layoutPath;//layout路径  res/layout
    public String classPackageName;//获取class对应的相对应的包名
    public int type;//类型
    public String suffix;//文件后缀
    public String tempDir;//临时文件夹目录
    public String templateContent;//获取模板文件内容
    public String tempFiles[];//模板文件

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
