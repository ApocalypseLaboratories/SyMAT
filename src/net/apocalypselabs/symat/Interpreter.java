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
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Skylar
 */
public class Interpreter extends javax.swing.JInternalFrame {

    private final CodeRunner cr;
    private String[] history = new String[10]; // Command history buffer
    private int historyIndex = 0; // For going back in time and keeping things straight
    private String lang = "javascript";

    /**
     * Creates new form Interpreter
     *
     * @param useLang The script language to use. "javascript", "python", or
     * "default".
     */
    public Interpreter(String useLang) {
        initComponents();

        // Setup code runner
        lang = useLang;
        if (lang.equals("default")) {
            lang = PrefStorage.getSetting("shellLang", "javascript");
        }
        cr = new CodeRunner(lang, true);

        // Set selected lang menu
        if (lang.equals("python")) {
            javascriptMenu.setSelected(false);
            pythonMenu.setSelected(true);
        }

        // Set font
        int font_size = 12;
        try {
            font_size = Integer.valueOf(PrefStorage.getSetting("editfont"));
        } catch (Exception ex) {
        }
        mainBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, font_size));
        inputBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, font_size));

        // Set theme
        if (PrefStorage.getSetting("theme").equals("dark")) {
            mainBox.setBackground(Color.BLACK);
            mainBox.setForeground(Color.WHITE);
            inputBox.setBackground(Color.BLACK);
            inputBox.setForeground(Color.WHITE);
            setBackground(Color.DARK_GRAY);
        } else {
            mainBox.setBackground(Color.WHITE);
            mainBox.setForeground(Color.BLACK);
            inputBox.setBackground(Color.WHITE);
            inputBox.setForeground(Color.BLACK);
            setBackground(Color.LIGHT_GRAY);
        }

        // Misc. setup
        mainBox.setText(">>");
        inputBox.requestFocus();
    }

    public Interpreter() {
        this("default");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        langGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainBox = new javax.swing.JTextArea();
        inputBox = new javax.swing.JTextField();
        runBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        langMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        javascriptMenu = new javax.swing.JRadioButtonMenuItem();
        pythonMenu = new javax.swing.JRadioButtonMenuItem();
        setDefaultLang = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Shell");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/shell.png"))); // NOI18N

        mainBox.setEditable(false);
        mainBox.setColumns(20);
        mainBox.setFont(new java.awt.Font("Courier New", 0, 15)); // NOI18N
        mainBox.setLineWrap(true);
        mainBox.setRows(5);
        mainBox.setTabSize(4);
        mainBox.setToolTipText("");
        mainBox.setWrapStyleWord(true);
        DefaultCaret caret = (DefaultCaret)mainBox.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jScrollPane1.setViewportView(mainBox);

        inputBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputBoxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBoxKeyTyped(evt);
            }
        });

        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>");

        langMenu.setText("Language");

        jMenu1.setText("Switch");

        langGroup.add(javascriptMenu);
        javascriptMenu.setSelected(true);
        javascriptMenu.setText("JavaScript");
        javascriptMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javascriptMenuActionPerformed(evt);
            }
        });
        jMenu1.add(javascriptMenu);

        langGroup.add(pythonMenu);
        pythonMenu.setText("Python");
        pythonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pythonMenuActionPerformed(evt);
            }
        });
        jMenu1.add(pythonMenu);

        langMenu.add(jMenu1);

        setDefaultLang.setText("Set as default");
        setDefaultLang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDefaultLangActionPerformed(evt);
            }
        });
        langMenu.add(setDefaultLang);

        jMenuBar1.add(langMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runBtn))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputBox, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        doRunCode();
    }//GEN-LAST:event_runBtnActionPerformed

    private void inputBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxKeyTyped
        if (evt.getKeyChar() == '\n') {
            doRunCode();
        }
    }//GEN-LAST:event_inputBoxKeyTyped

    private void inputBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (historyIndex < 9) {
                    if (historyIndex < 0) {
                        historyIndex++;
                    }
                    inputBox.setText(history[historyIndex]);
                    historyIndex++;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (historyIndex >= 0) {
                    historyIndex--;
                    if (historyIndex < 0) {
                        historyIndex = 0;
                        inputBox.setText("");
                    } else {
                        inputBox.setText(history[historyIndex]);
                    }
                }
                break;
        }
    }//GEN-LAST:event_inputBoxKeyPressed

    private void setDefaultLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDefaultLangActionPerformed
        String pref = "javascript";
        if (pythonMenu.isSelected()) {
            pref = "python";
        }
        PrefStorage.saveSetting("shellLang", pref);
        PrefStorage.save();
    }//GEN-LAST:event_setDefaultLangActionPerformed

    private void javascriptMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javascriptMenuActionPerformed
        if (!lang.equals("javascript")) {
            MainGUI.loadFrame(new Interpreter("javascript"));
            dispose();
        }
    }//GEN-LAST:event_javascriptMenuActionPerformed

    private void pythonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pythonMenuActionPerformed
        if (!lang.equals("python")) {
            MainGUI.loadFrame(new Interpreter("python"));
            dispose();
        }
    }//GEN-LAST:event_pythonMenuActionPerformed

    private void doRunCode() {
        String code = inputBox.getText();
        mainBox.append(" " + code + "\n");
        try {
            mainBox.append(cr.evalString(code).toString() + "\n");
        } catch (NullPointerException ex) {

        }
        mainBox.append(">>");
        for (int i = 9; i > 0; i--) {
            history[i] = history[i - 1];
        }
        history[0] = code;
        inputBox.setText("");
        historyIndex = -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButtonMenuItem javascriptMenu;
    private javax.swing.ButtonGroup langGroup;
    private javax.swing.JMenu langMenu;
    private javax.swing.JTextArea mainBox;
    private javax.swing.JRadioButtonMenuItem pythonMenu;
    private javax.swing.JButton runBtn;
    private javax.swing.JMenuItem setDefaultLang;
    // End of variables declaration//GEN-END:variables
}
