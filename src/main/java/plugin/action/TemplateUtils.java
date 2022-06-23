package plugin.action;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import plugin.bean.ParamBean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 模板工具
 */
public class TemplateUtils {

    public static String jNormalActivityFiles[] =
            {
                    "m_TemplateDataSource.txt",
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt"
            };
    public static String jNormalFragmentyFiles[] =
            {
                    "m_TemplateDataSource.txt",
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt"
            };
    public static String jListActivityFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateDataSource.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String jListFragmentFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateDataSource.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String jPagingActivityFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String jPagingFragmentFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String kNormalActivityFiles[] =
            {
                    "m_TemplateDataSource.txt",
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt"
            };
    public static String kNormalFragmentyFiles[] =
            {
                    "m_TemplateDataSource.txt",
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt"
            };
    public static String kListActivityFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateDataSource.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String kListFragmentFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateDataSource.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateRepository.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String kPagingActivityFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateActivityLayout.xml",
                    "v_TemplateActivity.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };
    public static String kPagingFragmentFiles[] =
            {
                    "m_TemplateEntity.txt",
                    "m_TemplateRemoteDataSource.txt",
                    "m_TemplateService.txt",
                    "vm_TemplateViewModel.txt",
                    "layout_TemplateFragmentLayout.xml",
                    "v_TemplateFragment.txt",
                    "layout_TemplateItemLayout.xml",
                    "v_TemplateAdapter.txt"
            };

    /**
     * 获取类前缀
     *
     * @param moduleName
     * @return
     */
    @NotNull
    public static String getClassPrefix(String moduleName) {
        return moduleName.substring(0, 1).toUpperCase().concat(moduleName.substring(1));
    }


    /**
     * 获取需要创建子文件夹的路径
     *
     * @param baseDirPath 容器目录
     * @param dirName     需要转换成小写
     * @param fileName    模板文件名称
     * @return
     */
    @Nullable
    public static String getSonDirPath(String baseDirPath, String dirName, String fileName) {
        String sonDirPath = null;
        if (fileName.startsWith("m_")) {
            //m
            sonDirPath = baseDirPath + "/" + dirName + "/m";
        } else if (fileName.startsWith("vm_")) {
            //vm
            sonDirPath = baseDirPath + "/" + dirName + "/vm";
        } else if (fileName.startsWith("v_")) {
            //v
            sonDirPath = baseDirPath + "/" + dirName + "/v";
        }
        return sonDirPath;
    }

    /**
     * 获取类的后缀
     *
     * @param templateFileName
     * @param suffix
     * @return
     */
    @NotNull
    public static String getClassSuffix(String templateFileName,String suffix) {
        if (templateFileName.contains("TemplateEntity")) {
            suffix = "Entity" + suffix;
        } else if (templateFileName.contains("TemplateService")) {
            suffix = "Service" + suffix;
        } else if (templateFileName.contains("TemplateDataSource")) {
            suffix = "DataSource" + suffix;
        } else if (templateFileName.contains("TemplateRemoteDataSource")) {
            suffix = "RemoteDataSource" + suffix;
        } else if (templateFileName.contains("TemplateRepository")) {
            suffix = "Repository" + suffix;
        } else if (templateFileName.contains("TemplateViewModel")) {
            suffix = "ViewModel" + suffix;
        } else if (templateFileName.contains("TemplateFragment")) {
            suffix = "Fragment" + suffix;
        } else if (templateFileName.contains("TemplateActivity")) {
            suffix = "Activity" + suffix;
        } else if (templateFileName.contains("TemplateAdapter")) {
            suffix = "Adapter" + suffix;
        }
        return suffix;
    }

    /**
     * 获取类的后缀
     *
     * @param mName            模块名称
     * @param classPrefix
     * @param templateFileName
     * @return
     */
    @NotNull
    public static String getLayoutName(String mName, String classPrefix, String templateFileName) {
        String prefix = "";
        if (!"app".equals(mName.toLowerCase())) {
            prefix = mName + "_";
        }
        String name = null;
        if (templateFileName.contains("TemplateFragmentLayout")) {
            name = prefix + "fragment_" + getSplitForClassPrefix(classPrefix).toLowerCase() + ".xml";
        } else if (templateFileName.contains("TemplateActivityLayout")) {
            name = prefix + "activity_" + getSplitForClassPrefix(classPrefix).toLowerCase() + ".xml";
        } else if (templateFileName.contains("TemplateItemLayout")) {
            name = prefix + "item_" + getSplitForClassPrefix(classPrefix).toLowerCase() + ".xml";
        }
        return name;
    }


    /**
     * 替换模板中字符
     *
     * @return
     */
    // param.templateContent, param.classPackageName, param.classPrefix, param.packName, param.baseDirPackName, param.moduleName, param.createPackName
    public static String dealTemplateContent(ParamBean param) {
        String content = param.templateContent;
        content = content.replace("$ClassPackageName", param.classPackageName);
        content = content.replace("$VM_MPackageName", param.classPackageName.replaceAll(".vm", ".m"));
        content = content.replace("$V_MPackageName", param.classPackageName.replaceAll(".v", ".m"));
        content = content.replace("$ClassPrefix", param.classPrefix);
        content = content.replace("$MethodName", param.classPrefix);
        content = content.replace("$LayoutSuffix", getSplitForClassPrefix(param.classPrefix).toLowerCase());
        content = content.replace("$V_VMPackageName", param.classPackageName.replaceAll(".v", ".vm"));
        content = content.replace("$ModulePackName", param.packName);
        content = content.replace("$BaseDirPackName", param.baseDirPackName);
        content = content.replace("$CreatePackName", param.createPackName);
        //兼容fragment  eg: BMine TruckDetailFragmentBinding
        content = content.replace("$BindingPrefix", getBindingPrefix(param.moduleName));
        content = content.replace("$BindingMiddle", getSplitForClassPrefix(param.classPrefix).replaceAll("_", ""));
        content = content.replace("$LayoutPrefix", param.moduleName);
        content = content.replace("app_", "");
        return content;
    }

    /**
     * 获取对应类的包名
     *
     * @param sonDirPath
     * @return
     */
    @NotNull
    public static String getClassPackageName(String sonDirPath) {
        String substring = sonDirPath.substring(sonDirPath.indexOf("src/main/java/") + "src/main/java/".length());
        return substring.replaceAll("/", ".");
    }


    /**
     * 获取相应类路径对应的包名
     *
     * @param path
     * @return
     */
    @NotNull
    public static String getClassPackName(String path) {
        String substring = path.substring(path.indexOf("src/main/java/") + "src/main/java/".length());
        return substring.replaceAll("/", ".");
    }

    /**
     * 获取模块名称
     *
     * @param path
     * @return
     */
    @NotNull
    public static String getMname(String path) {
        String substring = path.substring(0, path.indexOf("/src/main/java/"));
        return substring.substring(substring.lastIndexOf("/") + 1);
    }

    /**
     * 获取module的包名
     *
     * @return
     */
    public static String getPackageName(Project project, String baseDirPath) {
        String mName = TemplateUtils.getMname(baseDirPath);
        String package_name = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            String basePath =  project.getBasePath();
            String pathLocal = basePath /*+ "/" + mName*/ + "/src/main/AndroidManifest.xml";
            Document doc = db.parse(pathLocal);
            NodeList nodeList = doc.getElementsByTagName("manifest");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                package_name = element.getAttribute("package");
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return package_name;
    }

    /**
     * 获取res目录
     *
     * @param project
     * @param baseDirPath
     * @return
     */
    public static String getResPath(Project project, String baseDirPath) {
        String mName = TemplateUtils.getMname(baseDirPath);
        return project.getBasePath() + "/" + mName + "/src/main/res";
    }

    /**
     * 根据类前缀的大写进行分割 OrderNameGood  --->   Order_Name_Good
     *
     * @param classPrefix
     * @return
     */
    public static String getSplitForClassPrefix(String classPrefix) {
        StringBuffer sb = new StringBuffer(classPrefix);
        if (sb.length() > 1) {
            for (int i = 1; i < sb.length(); i++) {
                if (Character.isUpperCase(sb.charAt(i))) {
                    sb.insert(i++, "_");
                }
            }
        }
        return sb.toString();
    }


    /**
     * 根据模块名称获取binding前缀   b_mine ---> BMine   app-->""
     *
     * @param moduleName
     * @return
     */
    public static String getBindingPrefix(String moduleName) {
        String bindingPrefix = "";
        if (!"app".equals(moduleName.toLowerCase())) {
            String[] s = moduleName.split("_");
            if (s != null) {
                for (String str : s) {
                    if (str.length() == 1) {
                        bindingPrefix = bindingPrefix + str.toUpperCase();
                    } else {
                        bindingPrefix = bindingPrefix + str.substring(0, 1).toUpperCase().concat(str.substring(1));
                    }
                }
            }
        }
        return bindingPrefix;
    }

}
