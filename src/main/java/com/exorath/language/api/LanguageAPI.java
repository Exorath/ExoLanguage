package com.exorath.language.api;

import com.exorath.language.api.templates.LanguagesPack;
import com.exorath.language.impl.ILanguageAPI;


/**
 * Created by toonsev on 8/23/2016.
 */
public interface LanguageAPI {
    void addLanguagesPack(LanguagesPack languagesPack);
    String getTranslated(Message message);

    static LanguageAPI create(){
        return new ILanguageAPI();
    }
}
