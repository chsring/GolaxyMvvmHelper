package plugin.ui;

import plugin.action.ConfigReadyListener;
import plugin.action.TypeContant;

import javax.annotation.Nonnull;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingDialog extends JFrame {

    private JPanel contentPane;
    private JButton cancelButton;
    private JButton okButton;
    private JRadioButton javaRB;
    private JRadioButton kotlinRB;
    private JRadioButton normalRB;
    private JRadioButton listRB;
    private JRadioButton pagingRB;
    private JTextField packNameField;
    private JTextField classPrefixField;
    private JRadioButton activityRB;
    private JRadioButton fragmentRB;


    public SettingDialog(@Nonnull ConfigReadyListener listener) {
        setContentPane(contentPane);
        setSize(450, 390);
        setResizable(false);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(okButton);
        setTitle("FY Setting");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        okButton.addActionListener(e -> {
            int type = 0;
            if (javaRB.isSelected()) {
                if (normalRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.JAVA_NORMAL_ACTIVITY;
                    } else {
                        type = TypeContant.JAVA_NORMAL_FRAGMENT;
                    }
                } else if (listRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.JAVA_LIST_ACTIVITY;
                    } else {
                        type = TypeContant.JAVA_LIST_FRAGMENT;
                    }
                } else if (pagingRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.JAVA_PAGING_ACTIVITY;
                    } else {
                        type = TypeContant.JAVA_PAGING_FRAGMENT;
                    }
                }
            } else {
                if (normalRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.KOTLIN_NORMAL_ACTIVITY;
                    } else {
                        type = TypeContant.KOTLIN_NORMAL_FRAGMENT;
                    }
                } else if (listRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.KOTLIN_LIST_ACTIVITY;
                    } else {
                        type = TypeContant.KOTLIN_LIST_FRAGMENT;
                    }
                } else if (pagingRB.isSelected()) {
                    if (activityRB.isSelected()) {
                        type = TypeContant.KOTLIN_PAGING_ACTIVITY;
                    } else {
                        type = TypeContant.KOTLIN_PAGING_FRAGMENT;
                    }
                }
            }
            String createPackName = packNameField.getText();
            if (createPackName == null || createPackName.trim().equals("")) {
                return;
            }
            String classPrefix = classPrefixField.getText();
            if (classPrefix == null || classPrefix.trim().equals("")) {
                return;
            }
            dispose();
            listener.onConfig(createPackName, classPrefix, type);

        });
        cancelButton.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SettingDialog settingDialog = new SettingDialog(null);
        settingDialog.setVisible(true);
    }


}
