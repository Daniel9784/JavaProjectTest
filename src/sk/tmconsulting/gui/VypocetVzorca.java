/**
 * Copyright (c) 2025 Ján Žitniak
 * Licensed under the TM Consulting
 */

package sk.tmconsulting.gui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

// Ukazka: https://github.com/janzitniak/kalkulacka/tree/main/src/main/java
public class VypocetVzorca {
    public static void main(String[] args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        String vzorec = "1+2*3";
        try {
            System.out.println(engine.eval(vzorec)); // vysledok Stringu, ktory obsahuje vzorec vypisem
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }
}