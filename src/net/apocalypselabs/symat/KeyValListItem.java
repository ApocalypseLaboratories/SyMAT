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

/**
 * A simple key/value pair for lists and stuff.
 * @author Skylar
 */
public class KeyValListItem {
    // I know, not Java code standards.
    // But it's easier and cleaner this way.
    private String VAL = "";
    private String KEY = "";
    
    public KeyValListItem() {
        
    }
    
    public KeyValListItem(String key) {
        KEY = key;
    }
    
    public KeyValListItem(String key, String val) {
        KEY = key;
        VAL = val;
    }
    
    /**
     * Get the key.
     * @return the key.
     */
    @Override
    public String toString() {
        return KEY;
    }
    
    /**
     * Get the value of this pair.
     * @return duh.
     */
    public String getValue() {
        return VAL;
    }
    
    /**
     * Set the key.
     * <br>To get it back use toString().
     * @param key the key.
     */
    public void setKey(String key) {
        KEY = key;
    }
    
    /**
     * Set the value for this pair.
     * @param value 
     */
    public void setValue(String value) {
        VAL = value;
    }
    
    /**
     * Is this pair populated?
     * @return True if key and value are empty.
     */
    public boolean isEmpty() {
        return (KEY.equals("") && VAL.equals(""));
    }
}
