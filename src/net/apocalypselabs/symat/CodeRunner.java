/* 
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
 */
package net.apocalypselabs.symat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

/**
 *
 * @author Skylar
 */
public class CodeRunner {

    private ScriptEngine se;

    // If we need to wrap code around input to make everything nice.
    private boolean wrapRequired = false;
    // What codez are we speaking?
    private String scriptLang = "";

    private boolean isShell = false;

    public CodeRunner() {
        this("javascript");
    }

    public CodeRunner(String lang) {
        scriptLang = lang;
        switch (lang) {
            case "javascript":
                se = new ScriptEngineManager().getEngineByName("rhino");
                wrapRequired = true;
                try {
                    // Add custom functions.
                    se.eval("importClass(net.apocalypselabs.symat.Functions);"
                            + "SyMAT_Functions = new net.apocalypselabs.symat.Functions();"
                            + jsFunctions());
                } catch (Exception ex) {
                    initError(ex);
                }
                break;
            case "python":
                se = new ScriptEngineManager().getEngineByName("python");
                try {
                    se.eval("from math import *\nfrom net.apocalypselabs.symat import Functions\n_=Functions()\n");
                } catch (Exception ex) {
                    initError(ex);
                }
                break;
            default:
                throw new UnsupportedOperationException("Script language " + lang + " not supported.");
        }
    }

    public CodeRunner(String lang, boolean shell) {
        this(lang);
        isShell = shell;
    }
    
    /**
     * Inits the Python engine.
     * @param fakeInit Set it to true.
     */
    public CodeRunner(boolean fakeInit) {
        if (fakeInit) {
            se = new ScriptEngineManager().getEngineByName("python");
        }
    }

    private void initError(Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: "
                + "Could not properly initialize " + scriptLang + " scripting engine."
                + "\n\nSome functions may not work.\n\n"
                + "(" + ex.getMessage() + ")");
    }

    /**
     * Parse a String of JavaScript.
     *
     * @param eval A String of JavaScript to evaluate.
     * @return the result.
     */
    public Object evalString(String eval) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            se.getContext().setWriter(pw);
            Object res = se.eval(wrapMath(eval));
            if (res == null) {
                res = "";
            }
            String result = res + sw.getBuffer().toString().trim();
            return result;
        } catch (ScriptException ex) {
            return formatEx(ex);
        }
    }

    private String formatEx(ScriptException ex) {
        String err = ex.getMessage();
        //err = err.replace("sun.org.mozilla.javascript.internal.EcmaError: ReferenceError: ", "");
        //err = err.replace("<Unknown source>", "file");
        //err = err.replace("sun.org.mozilla.javascript.internal.EvaluatorException: ", "");
        return "Error: " + err;
    }

    /**
     * Allows use of Math.blah() as just blah(). Also gives access to SyMAT Java
     * functions.
     *
     * @param eval input string
     * @return wrapped input
     */
    private String wrapMath(String eval) {
        if (wrapRequired) {
            String with = "with(SyMAT_Functions){with(Math){" + eval + "}}";
            return with;
        }
        return eval;
    }

    public void setVar(String var, Object val) {
        se.put(var, val);
    }

    public Object getVar(String var) {
        return se.get(var);
    }

    private String jsFunctions() {
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            CodeRunner.class
                            .getResourceAsStream("functions.js")));
            String line;
            while ((line = reader.readLine()) != null) {
                text += line;
            }
        } catch (Exception e) {
        }
        return text;
    }

    // TODO: Run Javascript in separate thread from rest of app.
    private class JsThread extends Thread {

        @Override
        public void run() {

        }
    }
}
