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

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.ImageIcon;

/**
 *
 * @author Skylar
 */
public class WebBrowser extends javax.swing.JInternalFrame {

    private WebView browser;
    private WebEngine webEngine;
    private JFXPanel jfxPanel;
    private Group root;
    private Scene scene;

    public static final int DEFAULT_LOGO = 0;
    public static final int WIKI_LOGO = 1;
    public static final int FORUM_LOGO = 2;
    public static final int PAD_LOGO = 3;

    /**
     * Creates new form WebBrowser
     */
    public WebBrowser() {
        initComponents();
        jfxPanel = new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                browser = new WebView();
                browser.setPrefSize(getWidth(), getHeight());
                root = new Group();
                scene = new Scene(root);
                ObservableList<Node> children = root.getChildren();
                children.add(browser);
                jfxPanel.setScene(scene);
                webEngine = browser.getEngine();
                webEngine.setUserAgent("SyMAT " + MainGUI.VERSION_NAME);
                webEngine.loadContent("<html><head><title></title></head><body><h3 style=\"font-family: sans-serif; text-align: center;\">Loading...</h3></body></html>");
            }
        });
        getContentPane().add(jfxPanel, BorderLayout.CENTER);
    }

    public WebBrowser(String title) {
        this();
        setTitle(title);
        loadURL("https://wiki.symatapp.com/");
    }

    public WebBrowser(String title, String url) {
        this();
        setTitle(title);
        loadURL(url);
    }

    public WebBrowser(String title, String url, int icon) {
        this(title, url);
        switch (icon) {
            case WIKI_LOGO:
                setFrameIcon(new ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/wiki.png")));
                break;
            case FORUM_LOGO:
                setFrameIcon(new ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/forum.png")));
                break;
            case PAD_LOGO:
                setFrameIcon(new ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/editor.png")));
                break;
            default:
                setFrameIcon(new ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/browser.png")));
        }

    }

    public WebBrowser(String url, boolean isurl) {
        this();
        loadURL(url);
    }

    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.load(url);
                resizeAll();
            }
        });
    }

    public void loadString(final String content) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.loadContent(content);
                resizeAll();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Browser");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/net/apocalypselabs/symat/icons/browser.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(480, 400));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
//        resizeAll();
//        // Ensure scrollbars show up correctly.
//        setSize(getWidth() + 1, getHeight());
//        setSize(getWidth() - 1, getHeight());
    }//GEN-LAST:event_formInternalFrameOpened

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        resizeAll();
    }//GEN-LAST:event_formComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        resizeAll();
    }//GEN-LAST:event_formComponentShown

    private void resizeAll() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                jfxPanel.setSize(getWidth(), getHeight());
                browser.setPrefSize(getWidth() - 12, getHeight() - 32);
                browser.resize(getWidth() - 12, getHeight() - 32);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
