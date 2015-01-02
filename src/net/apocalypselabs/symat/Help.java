/* 
 * Apocalypse Laboratories
 * Open Source License
 * 
 * Source code can be used for any purpose, as long as:
 *  - Compiled binaries are rebranded and trademarks are not
 *    visible by the end user at any time, except to give
 *    credit to Apocalypse Laboratories, such as by showing
 *    "Based on <product> by Apocalypse Laboratories" or a
 *    similar notice;
 *  - You do not use the code for evil;
 *  - Rebranded compiled applications have significant
 *    differences in functionality;
 *  - and you provide your modified source code for download,
 *    under the terms of the GNU LGPL v3 or a comparable
 *    license.
 * 
 * Compiled binaries cannot be redistributed or mirrored,
 * unless:
 *  - You have written permission from Apocalypse Laboratories;
 *  - Downloads are not available from Apocalypse Laboratories,
 *    not even behind a paywall or other blocking mechanism;
 *  - or you have received a multi-computer license, in which
 *    case you should take measures to prevent unauthorized
 *    downloads, such as preventing download access from the 
 *    Internet.
 */
package net.apocalypselabs.symat;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 *
 * @author Skylar
 */
public class Help extends javax.swing.JInternalFrame {

    // True if this is a manual, false if about window
    private boolean topicOnLoad = true;

    /**
     * Creates new form Help
     */
    public Help() {
        initComponents();
        loadTheme();
    }

    /**
     * Load the About window.
     *
     * @param about set it to whatever.
     */
    public Help(boolean about) {
        initComponents();
        setSize(450, 352);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setDividerLocation(0.0);
        jSplitPane1.setResizeWeight(0.0);
        topicOnLoad = false;
        loadTopic("about");
    }

    private void loadTheme() {
        if (PrefStorage.getSetting("theme").equals("dark")) {
            topicList.setBackground(Color.BLACK);
            topicList.setForeground(Color.WHITE);
            setBackground(Color.DARK_GRAY);
        } else {
            topicList.setBackground(Color.WHITE);
            topicList.setForeground(Color.BLACK);
            setBackground(Color.LIGHT_GRAY);
        }
    }

    public void loadTopic(String name) {
        if (name.equals("welcome")) {
            String text = "<html><head><title>About SyMAT</title></head>"
                    + "<body>"
                    + "<h1>Welcome to SyMAT!</h1>"
                    + "<p>SyMAT is a Java-based algebra and calculus system.  "
                    + "Scripts and commands can be written in "
                    + "JavaScript or Python.</p>"
                    + "<p>This is SyMAT version "
                    + MainGUI.VERSION_NAME + " (" + (int) MainGUI.APP_CODE + ")."
                    + "</p>"
                    + "<p>SyMAT is copyright &copy; "
                    + Calendar.getInstance().get(Calendar.YEAR)
                    + " Apocalypse Laboratories.  Some rights reserved."
                    + "</p>"
                    + "<p>Internal help documentation is "
                    + "licensed under the Creative Commons "
                    + "Attribution-NonCommercial 4.0 International"
                    + " license (CC-BY-NC).  "
                    + "You can use it in part or in whole "
                    + "for any purpose, excepting commercial, as long as "
                    + "you attribute Apocalypse Laboratories.  See "
                    + "http://creativecommons.org/licenses/by-nc/4.0/"
                    + " for more information.</p>";
            topicBrowser.setText(text);
            topicBrowser.setCaretPosition(0);
            setTitle("Manual");
        } else {
            try {
                String text = "";
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                CodeRunner.class
                                .getResourceAsStream("help/" + name + ".html")));
                String line;
                while ((line = reader.readLine()) != null) {
                    text += line;
                }
                topicBrowser.setText(text);
                topicBrowser.setCaretPosition(0);
                setTitle("Manual (" + topicList.getSelectedValue().toString() + ")");
            } catch (Exception e) {
                //JOptionPane.showInternalMessageDialog(MainGUI.mainPane, 
                //"Error: Cannot load help topic "+name+".\n\n"+e.getMessage());
                topicBrowser.setText("<html><head></head><body><p><b>Error:</b><br>Cannot get help topic \""
                        + name + "\".<br>(" + e.getMessage() + ")</p></body></html>");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        topicList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        topicBrowser = new javax.swing.JEditorPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Manual");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/help.png"))); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jSplitPane1.setDividerLocation(100);
        jSplitPane1.setDividerSize(3);
        jSplitPane1.setResizeWeight(0.1);

        topicList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Welcome", "Basics", "Editor", "Graphing", "Commands", "Licenses" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        topicList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        topicList.setSelectedIndex(0);
        topicList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topicListMouseClicked(evt);
            }
        });
        topicList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                topicListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(topicList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        topicBrowser.setEditable(false);
        topicBrowser.setContentType("text/html"); // NOI18N
        topicBrowser.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin-top: 0\">\r\n      \rHi there\n    </p>\r\n  </body>\r\n</html>\r\n");
        jScrollPane2.setViewportView(topicBrowser);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topicListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_topicListValueChanged
        loadTopic(topicList.getSelectedValue().toString().toLowerCase());
    }//GEN-LAST:event_topicListValueChanged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        topicList.setSelectedIndex(0);
        if (topicOnLoad) {
            loadTopic("welcome");
        }
    }//GEN-LAST:event_formComponentShown

    private void topicListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topicListMouseClicked
        loadTheme();
    }//GEN-LAST:event_topicListMouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (!topicOnLoad) {
            jSplitPane1.setDividerLocation(0.0);
            jSplitPane1.setResizeWeight(0.0);
        }
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JEditorPane topicBrowser;
    private javax.swing.JList topicList;
    // End of variables declaration//GEN-END:variables
}
