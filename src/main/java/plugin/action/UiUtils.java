package plugin.action;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;

/**
 * UI 管理
 */
public class UiUtils {
    public final static String DIALOG_TITLE = "FY Warning";

    /**
     * 提示框
     *
     * @param title
     * @param msg
     */
    public static void showWarningDialog(String title, String msg) {
//        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
        Notifications.Bus.notify(new Notification("FY_Notify",title,msg, NotificationType.WARNING));


    }
}
