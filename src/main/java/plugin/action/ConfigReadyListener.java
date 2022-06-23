package plugin.action;

/**
 * 配置结果
 */
public interface ConfigReadyListener {

    /**
     * 监听配置
     * @param createPackName 需要创建的文件夹名称，也叫包名
     * @param classPrefix 类前缀，会在命名类和布局文件中都会用到
     * @param type 需要生成什么样的模板代码  参考 TypeContant.class
     */
    void onConfig(String createPackName, String classPrefix, int type);
}
