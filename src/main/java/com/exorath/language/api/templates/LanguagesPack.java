package com.exorath.language.api.templates;


import com.exorath.language.api.Language;

import java.util.HashMap;

/**
 * Created by toonsev on 8/26/2016.
 */
public interface LanguagesPack {
    /**
     * Gets the registered templates by their key id. These templates should already be in memory.
     * @return the registered templates by their key id.
     */
    HashMap<Language, LanguagePack> getTemplatePacks();
}
