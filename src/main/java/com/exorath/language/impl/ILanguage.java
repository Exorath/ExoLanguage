package com.exorath.language.impl;

import com.exorath.language.api.Language;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ILanguage implements Language{
    private String languageId;

    public ILanguage(String languageId){
        this.languageId = languageId;
    }

    @Override
    public String getLanguageId() {
        return languageId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Language))
            return false;
        return this.getLanguageId().equals(((Language) obj).getLanguageId());
    }

    @Override
    public int hashCode() {
        return languageId.hashCode();
    }
}
