package com.exorath.language.api;

import com.exorath.language.impl.ILanguage;

/**
 * Created by toonsev on 8/23/2016.
 */
public interface Language {
    String getLanguageId();

    static Language create(String languageId){
        return new ILanguage(languageId);
    }
}
