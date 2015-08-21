<<<<<<< HEAD
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
=======
/*
 * CODE LICENSE =====================
 * Copyright (c) 2015, Netsyms Technologies
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 *  are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 *  other materials provided with the distribution.
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
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * MEDIA LICENSE ====================
 * All images and other graphical files (the "graphics") included with this
 * software are copyright (c) 2015 Netsyms Technologies.  You may not distribute
 * the graphics or any program, source code repository, or other digital storage
 * media containing them without written permission from Netsyms Technologies.
>>>>>>> c1bd78b886a57d8f285747c749491ece75862a43
 * This ban on distribution only applies to publicly available systems.
 * A password-protected network file share, USB drive, or other storage scheme that
 * cannot be easily accessed by the public is generally allowed.  If in doubt,
 * contact Netsyms Technologies.  If Netsyms Technologies allows or denies
 * you permission, that decision is considered final and binding.
<<<<<<< HEAD
 * 
 * You may only use the media for personal, 
 * non-commercial, non-educational use unless: 
 * 1, You have paid for the software and media via the SyMAT website,
 * or 2, you are using it as part of the 15-day trial period.  
 * Other uses are prohibited without permission.
 * If any part of this license is deemed unenforcable, the remainder 
 * of the license remains in full effect.
=======
>>>>>>> c1bd78b886a57d8f285747c749491ece75862a43
 */
package net.apocalypselabs.symat.sync;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.apocalypselabs.symat.Debug;
import static net.apocalypselabs.symat.Main.API_URL;
import net.apocalypselabs.symat.PrefStorage;

/**
 *
 * @author Skylar
 */
public class Start extends javax.swing.JPanel {

    private String email = "";
    private String password = "";
    private JInternalFrame parentComponent;

    /**
     * Creates new form Start
     */
    public Start(JInternalFrame parent) {
        parentComponent = parent;
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        newSyncBtn = new javax.swing.JButton();
        haveSyncBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 200));

        jLabel2.setFont(net.apocalypselabs.symat.Main.ubuntuRegular.deriveFont(36.0F));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sync");

        newSyncBtn.setText("Setup a new account");
        newSyncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSyncBtnActionPerformed(evt);
            }
        });

        haveSyncBtn.setText("I already have Sync");
        haveSyncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haveSyncBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(haveSyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newSyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newSyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(haveSyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void haveSyncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haveSyncBtnActionPerformed
        getLogin(UserLogin.LOGIN_MODE);
    }//GEN-LAST:event_haveSyncBtnActionPerformed

    private void newSyncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSyncBtnActionPerformed
        getLogin(UserLogin.SIGNUP_MODE);
    }//GEN-LAST:event_newSyncBtnActionPerformed

    private void getLogin(int mode) {
        UserLogin ul = new UserLogin(mode);
        JOptionPane.showMessageDialog(this,
                ul,
                "Sync " + (mode == UserLogin.SIGNUP_MODE ? "Signup" : "Login"),
                JOptionPane.PLAIN_MESSAGE);
        email = ul.getEmail();
        password = ul.getPassword();
        try {
            Debug.println("Signing in to Sync...");
            URL url = new URL(API_URL
                    + "sync" + (mode == UserLogin.SIGNUP_MODE ? "new" : "old")
                    + ".php?"
                    + "email=" + URLEncoder.encode(email, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8"));
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = br.readLine();
            br.close();
            is.close();
            if (!line.contains("OK")) {
                JOptionPane.showMessageDialog(this,
                        line,
                        "Sync Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                PrefStorage.saveSetting("syncemail", email);
                PrefStorage.saveSetting("syncpassword", password);
                PrefStorage.save();
                new BackgroundSync().start();
                JOptionPane.showMessageDialog(this,
                        "Account setup successful.  "
                        + "Your settings and plugins "
                        + "will now sync in the background.",
                        "Sync",
                        JOptionPane.INFORMATION_MESSAGE);
                parentComponent.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "An error occurred while syncing your account.",
                    "Sync Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton haveSyncBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton newSyncBtn;
    // End of variables declaration//GEN-END:variables
}