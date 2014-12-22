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

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

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
        setIconImage((new ImageIcon(getClass().getResource("icon.png"))).getImage());
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

        progBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(MainGUI.APP_NAME);
        setMaximumSize(new java.awt.Dimension(320, 260));
        setMinimumSize(new java.awt.Dimension(320, 260));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        progBar.setIndeterminate(true);
        progBar.setMaximumSize(new java.awt.Dimension(32767, 20));
        progBar.setMinimumSize(new java.awt.Dimension(10, 20));
        progBar.setPreferredSize(new java.awt.Dimension(146, 20));
        progBar.setString("");
        progBar.setStringPainted(true);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/splash.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            setProgress(10, "Starting up");
            DotThread dt = new DotThread();
            dt.start();
            if (!MainGUI.skipPython) {
                // Python laggggsss when used for first time, this fixes the wait later.
                System.out.println("Warming up Python engine, to skip run with argument 'skippython'");
                setProgress(20, "Initializing code engine");
                try {
                    CodeRunner python = new CodeRunner(true);
                } catch (Exception ex) {
                    // Ignore
                }
            }
            setProgress(70, "Loading main interface");
            new MainGUI().setVisible(true);
            dt.kill();
            setProgress(100, "Done!");
            dispose();
        }

        /**
         * Set the progress bar.
         * @param progress how full to make it (0 <= progress <= 100)
         * @param label The String to put on the label.
         */
        private void setProgress(int progress, String label) {
            final int prog = progress;
            final String lbl = label;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    progBar.setIndeterminate(false);
                    progBar.setValue(prog);
                    progBar.setString(lbl);
                }
            });
        }

        /**
         * Animate the dots on the progress bar label.
         * 
         * This way people know it's not "frozen", so they don't "let it go".
         */
        private class DotThread extends Thread {

            private boolean doRun = true;

            @Override
            public void run() {
                while (doRun) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            String val = progBar.getString();
                            if (val.endsWith("...")) {
                                progBar.setString(val.replace("...", "   "));
                            } else if (val.endsWith(".. ")) {
                                progBar.setString(val.replace(".. ", "..."));
                            } else if (val.endsWith(".  ")) {
                                progBar.setString(val.replace(".  ", ".. "));
                            } else if (!val.endsWith(" ")) {
                                progBar.setString(val+".  ");
                            }
                        }
                    });
                    Debug.println("dotsupdate");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }

            public void kill() {
                doRun = false;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar progBar;
    // End of variables declaration//GEN-END:variables
}