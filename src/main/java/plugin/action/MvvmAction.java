package plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import plugin.bean.ParamBean;
import plugin.ui.SettingDialog;

public class MvvmAction extends AnAction {


    @Override
    public void actionPerformed(AnActionEvent event) {
        String baseDirPath = FileUtils.getBaseDirPath(event);
        if (baseDirPath != null) {
            SettingDialog settingDialog = new SettingDialog(new ConfigReadyListener() {
                @Override
                public void onConfig(String createPackName, String classPrefix, int type) {
                    try {
                        start(new ParamBean(event.getProject(), baseDirPath, createPackName, classPrefix, type));
                    } finally {
                        stop(event);
                    }
                }
            });
            settingDialog.setVisible(true);

        } else {
            UiUtils.showWarningDialog(UiUtils.DIALOG_TITLE,"Use FYHelper in the package directory");
        }
    }

    /**
     * 启动
     */
    private void start(ParamBean param) {
        //类前缀
        for (String templateFileName : param.tempFiles) {
            if (templateFileName.endsWith(".txt")) {
                //获取子文件夹路径
                String sonDirPath = TemplateUtils.getSonDirPath(param.baseDirPath, param.createPackName, templateFileName);
                if (sonDirPath == null) continue;
                //获取模板文件内容
                param.templateContent = FileUtils.getTemplateFileContent(this.getClass(), param.tempDir + templateFileName);
                //获取对应类的包名
                param.classPackageName = TemplateUtils.getClassPackageName(sonDirPath);
                //替换模板中约定内容
                String goodContent = TemplateUtils.dealTemplateContent(param);
                //获取对应类的后缀
                String suffix = TemplateUtils.getClassSuffix(templateFileName,param.suffix);
                //写文件
                FileUtils.writeToFile(goodContent, sonDirPath, param.classPrefix + suffix);
            } else if (templateFileName.endsWith(".xml")) {
                //获取模板文件内容
                param.templateContent = FileUtils.getTemplateFileContent(this.getClass(), param.tempDir + templateFileName);
                //替换模板中约定内容
                String goodContent = TemplateUtils.dealTemplateContent(param);
                //获取布局的后缀
                String layoutName = TemplateUtils.getLayoutName(param.moduleName, param.classPrefix, templateFileName);
                //写文件
                FileUtils.writeToFile(goodContent, param.layoutPath, layoutName);

            }
            System.out.println(param.toString());
        }
    }


    /**
     * 刷新项目
     *
     * @param e
     */
    private void stop(AnActionEvent e) {
        e.getProject().getBaseDir().refresh(false, true);
    }


}
