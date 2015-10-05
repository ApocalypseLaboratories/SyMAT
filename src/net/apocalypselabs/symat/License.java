/* 
 * Copyright (c) 2015, Netsyms Technologies
 * All rights reserved.
 * 
 * 
 * CODE LICENSE ==========
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this 
 * list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its contributors 
 * may be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * 4. You adhere to the Media License detailed below.  If you do not, this license
 * is automatically revoked and you must purge all copies of the software you
 * possess, in source or binary form.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON 
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * MEDIA LICENSE ==========
 * All images and other graphical files ("media") included with this
 * software are copyright (c) 2015 Netsyms Technologies.  You may not distribute
 * the graphics or any program, source code repository, or other digital storage 
 * media containing them without permission from Netsyms Technologies.
 * This ban on distribution only applies to publicly available systems.
 * A password-protected network file share, USB drive, or other storage scheme that
 * cannot be easily accessed by the public is generally allowed.  If in doubt,
 * contact Netsyms Technologies.  If Netsyms Technologies allows or denies
 * you permission, that decision is considered final and binding.
 * 
 * You may only use the media for personal, 
 * non-commercial, non-educational use unless: 
 * 1, You have paid for the software and media via the SyMAT website,
 * or 2, you are using it as part of the 15-day trial period.  
 * Other uses are prohibited without permission.
 * If any part of this license is deemed unenforcable, the remainder 
 * of the license remains in full effect.
 */
package net.apocalypselabs.symat;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import static net.apocalypselabs.symat.Main.API_URL;

/**
 *
 * @author Skylar
 */
public class License extends javax.swing.JInternalFrame {

    /**
     * Creates new form FirstRun
     */
    public License() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        singLicSel = new javax.swing.JRadioButton();
        orgLicSel = new javax.swing.JRadioButton();
        noLicSel = new javax.swing.JRadioButton();
        emailBox = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        contBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setTitle("Welcome");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icon16.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(435, 367));
        setMinimumSize(new java.awt.Dimension(435, 367));
        setPreferredSize(new java.awt.Dimension(435, 367));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setText("<html>\n<h1>Welcome to SyMAT!</h1>\n<p>Please activate the software.  \n<br />Until you do, features will be limited.\n<br />You may be eligible for a free 15-day trial.</p>\n<br />\n<p>Do you have a license?</p>");

        grp1.add(singLicSel);
        singLicSel.setText("Yes, I have a single-user license");
        singLicSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singLicSelActionPerformed(evt);
            }
        });

        grp1.add(orgLicSel);
        orgLicSel.setText("No, but my school or work might have one");
        orgLicSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgLicSelActionPerformed(evt);
            }
        });

        grp1.add(noLicSel);
        noLicSel.setSelected(true);
        noLicSel.setText("No, I don't have a license");
        noLicSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noLicSelActionPerformed(evt);
            }
        });

        emailBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBoxActionPerformed(evt);
            }
        });
        emailBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailBoxKeyPressed(evt);
            }
        });

        emailLbl.setText("Great!  Enter your email address and we'll get things set up.");

        contBtn.setText("Continue");
        contBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noLicSel)
                    .addComponent(orgLicSel)
                    .addComponent(singLicSel)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singLicSel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orgLicSel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(noLicSel)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLbl)
                    .addComponent(exitBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contBtn))
                .addGap(40, 40, 40))
        );

        emailBox.setVisible(false);
        emailLbl.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singLicSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singLicSelActionPerformed
        emailLbl.setVisible(true);
        emailBox.setVisible(true);
        emailLbl.setText("Great!  Now just enter your email address.");
    }//GEN-LAST:event_singLicSelActionPerformed

    private void orgLicSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgLicSelActionPerformed
        emailLbl.setVisible(true);
        emailBox.setVisible(true);
        emailLbl.setText("OK, enter your school or work email address.");
    }//GEN-LAST:event_orgLicSelActionPerformed

    private void noLicSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noLicSelActionPerformed
        emailLbl.setVisible(false);
        emailBox.setVisible(false);
    }//GEN-LAST:event_noLicSelActionPerformed

    private void openShop() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(Main.API_URL + "shoplink.php"));
            } catch (IOException | URISyntaxException ex) {
                JOptionPane.showInternalMessageDialog(this, "Please go to symatapp.com to purchase a license.");
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Please go to symatapp.com to purchase a license.");
        }
    }

    private void contBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contBtnActionPerformed
        if (noLicSel.isSelected()) {
            if (PrefStorage.getSetting("licensetype").equals("demo")
                    && PrefStorage.getSetting("licensedemo").equals("used")) {
                int ans = JOptionPane.showInternalConfirmDialog(this,
                        "You have already used a trial license."
                        + "\nWould you like to go online to get a license?",
                        "Expired",
                        JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.NO_OPTION) {

                } else {
                    openShop();
                }
            } else {
                int ans = JOptionPane.showInternalConfirmDialog(this,
                        "Would you like to go online and get a license?\n"
                        + "Select no to activate a 15-day trial.",
                        "Get License",
                        JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.NO_OPTION) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.DATE, 15); // Adds 15 days

                    PrefStorage.saveSetting("licensetype", "demo");
                    PrefStorage.saveSetting("license", String.valueOf(c.getTimeInMillis()));
                    PrefStorage.saveSetting("licensedemo", "used");
                    JOptionPane.showInternalMessageDialog(this,
                            "A trial license of 15 days has been activated.",
                            "Activated",
                            JOptionPane.INFORMATION_MESSAGE);
                    exit();
                } else {
                    openShop();
                }
            }
        } else {
            if (checkRegex()) {
                new CheckThread(emailBox.getText()).start();
            }
        }
    }//GEN-LAST:event_contBtnActionPerformed

    private void emailBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBoxActionPerformed
        checkRegex();
    }//GEN-LAST:event_emailBoxActionPerformed

    private void emailBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailBoxKeyPressed
        checkRegex();
    }//GEN-LAST:event_emailBoxKeyPressed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        int result = JOptionPane.showInternalConfirmDialog(this,
                "Are you sure you want to exit SyMAT?",
                "Quit",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

    private boolean checkRegex() {
        if (checkEmail(emailBox.getText())) {
            contBtn.setEnabled(true);
            return true;
        } else {
            contBtn.setEnabled(false);
            return false;
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        return (email.matches(regex));
    }

    /**
     *
     */
    public void exit() {
        dispose();
    }

    /**
     * Check the email address for a license.
     */
    private class CheckThread extends Thread {

        private final String email;

        public CheckThread(String useremail) {
            email = useremail;
        }

        @Override
        public void run() {
            try {
                System.out.println("Checking license...");
                URL url = new URL(API_URL + "liccheck.php?email=" + email);
                String line;
                //String line2 = "";
                //boolean line2ok = false;
                try (InputStream is = url.openStream();
                        BufferedReader br
                        = new BufferedReader(new InputStreamReader(is))) {
                    line = br.readLine();
                    // line2 = br.readLine();
                    // line2ok = true;
                }

                switch (line) {
                    case "ok:single":
                        success("single");
                        break;
                    case "ok:domain":
                        success("domain");
                        break;
                    case "checkemail":
                        email();
                        break;
                    default:
                        fail();
                }
                /*if (line2ok) {
                 if (line2.equals("pro")) {
                        
                 }
                 }*/
            } catch (Exception e) {
                Debug.printerr("License check failed.");
                Debug.stacktrace(e);
                ioerror();
            }
        }

        private void success(String type) {
            PrefStorage.saveSetting("license", email);
            PrefStorage.saveSetting("licensetype", type);
            JOptionPane.showInternalMessageDialog(Main.mainPane,
                    "Thank you for activating SyMAT!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            Main.licenseRestrict(false);
            exit();
        }

        private void fail() {
            JOptionPane.showInternalMessageDialog(Main.mainPane,
                    "There is not a valid license for that email address.",
                    "Activation failure",
                    JOptionPane.ERROR_MESSAGE);
        }

        private void email() {
            try {
                String code = JOptionPane.showInternalInputDialog(Main.mainPane,
                        "A code has been emailed to you.  "
                        + "Enter it below to verify.",
                        "Almost done!",
                        JOptionPane.QUESTION_MESSAGE);
                Debug.println("Checking license code (" + code + ")...");
                URL url = new URL(API_URL + "emailverify.php?code=" + code + "&email=" + email);
                String line;
                try (InputStream is = url.openStream()) {
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(is));
                    line = br.readLine();
                    br.close();
                }
                if (code.equals(line)) {
                    success("domain");
                } else {
                    JOptionPane.showInternalMessageDialog(Main.mainPane,
                            "Code invalid.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                ioerror();
            }
        }

        private void ioerror() {
            JOptionPane.showMessageDialog(Main.mainPane,
                    "An error occured while verifying your license.  "
                    + "Ensure you have an Internet connection and "
                    + "try again later.  If the problem persists, "
                    + "contact Netsyms Technologies Licensing at "
                    + "software@netsyms.com.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contBtn;
    private javax.swing.JTextField emailBox;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JButton exitBtn;
    private javax.swing.ButtonGroup grp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton noLicSel;
    private javax.swing.JRadioButton orgLicSel;
    private javax.swing.JRadioButton singLicSel;
    // End of variables declaration//GEN-END:variables
}
