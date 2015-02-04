/* 
 * CODE LICENSE =====================
 * Copyright (c) 2015, Apocalypse Laboratories
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
 * software are copyright (c) 2015 Apocalypse Laboratories.  You may not distribute
 * the graphics or any program, source code repository, or other digital storage 
 * media containing them without written permission from Apocalypse Laboratories.
 * This ban on distribution only applies to publicly available systems.
 * A password-protected network file share, USB drive, or other storage scheme that
 * cannot be easily accessed by the public is generally allowed.  If in doubt,
 * contact Apocalypse Laboratories.  If Apocalypse Laboratories allows or denies
 * you permission, that decision is considered final and binding.
 */
package net.apocalypselabs.symat;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import static net.apocalypselabs.symat.MainGUI.API_URL;
import static net.apocalypselabs.symat.MainGUI.APP_CODE;
import static net.apocalypselabs.symat.MainGUI.VERSION_NAME;

/**
 *
 * @author Skylar
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setIconImages(MainGUI.symatlogo);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        dispLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SyMAT Starting");
        setMaximumSize(new java.awt.Dimension(702, 471));
        setMinimumSize(new java.awt.Dimension(702, 471));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(702, 471));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));

        dispLabel.setFont(MainGUI.ubuntuRegular.deriveFont(22.0F));
        dispLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dispLabel.setText("Loading...");
        dispLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        dispLabel.setMaximumSize(new java.awt.Dimension(400, 320));
        jLayeredPane1.add(dispLabel);
        dispLabel.setBounds(250, 250, 350, 80);

        jLabel1.setFont(MainGUI.ubuntuRegular.deriveFont(20.0F));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("v. "+MainGUI.VERSION_NAME);
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(520, 70, 80, 30);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/images/symat-hex-logo.png"))); // NOI18N
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 470);

        jLabel3.setFont(MainGUI.ubuntuRegular.deriveFont(12.0F));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html><div style=\"text-align: center;\">Apocalypse<br>Laboratories</div>");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(50, 420, 120, 40);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel4.setFont(MainGUI.ubuntuRegular.deriveFont(12.0F));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("symatapp.com");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(370, 430, 110, 14);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.POPUP_LAYER);

        getContentPane().add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        new Loader().start();
    }//GEN-LAST:event_formComponentShown

    /**
     * Bootstrapping everything.
     */
    private class Loader extends Thread {

        @Override
        public void run() {
            setProgress("Starting up...");
            if (!MainGUI.skipPython) {
                // Python laggggsss when used for first time, this fixes the wait later.
                System.out.println("Warming up Python engine, to skip run with argument 'skippython'");
                setProgress("Initializing code engine...");
                try {
                    CodeRunner python = new CodeRunner(true);
                } catch (Exception ex) {
                    // Ignore
                }
            }

            if (!MainGUI.skipEditor) {
                System.out.println("Preparing editor, to skip run with argument 'skipeditor'");
                setProgress("Preparing editor...");
                // Get editor going too
                CodeEditor edit = new CodeEditor();
            }
            
            setProgress("Checking for updates...");
            checkUpdates();

            setProgress("Loading main interface...");
            MainGUI main = new MainGUI();
            setProgress("Done!");
            dispose();
        }

        private void checkUpdates() {
            // Check for updates.
            try {
                Debug.println("Checking for updates...");
                URL url = new URL(API_URL + "version.php");
                InputStream is = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String line = br.readLine();
                br.close();
                is.close();
                double version = Double.parseDouble(line.split("\\|")[0]);
                if (version > APP_CODE) {
                    if (PrefStorage.getSetting("update-ignore")
                            .equals(VERSION_NAME + "|" + line.split("\\|")[1])) {
                        System.out.println("An update was found, "
                                + "but has been ignored by the user.");
                    } else {
                        Debug.println("Update available.");
                        MainGUI.updateString = line.split("\\|")[1];
                        MainGUI.updateAvailable = true;
                    }
                } else {
                    Debug.println("No updates found.");
                }
            } catch (Exception e) {
                System.err.println("Fail:  Cannot check update server.  \n"
                        + "       Assuming local copy up-to-date.");
                Debug.stacktrace(e);
            }
        }

        /**
         * Set the progress text.
         * @param label The String to put on the label.
         */
        private void setProgress(String label) {
            final String lbl = label;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    dispLabel.setText(lbl);
                }
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dispLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
