package com.exorath.language.impl.templates;

import com.exorath.language.api.Language;
import com.exorath.language.api.templates.Template;
import com.exorath.language.impl.ILanguage;

/**
 * Created by toonsev on 8/26/2016.
 */
public class ITemplate implements Template{
    private String templateString;

    public ITemplate(String templateString){
        this.templateString = templateString;
    }

    @Override
    public String getTemplateString() {
        return templateString;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Template))
            return false;
        return this.getTemplateString().equals(((Template) obj).getTemplateString());
    }

    @Override
    public int hashCode() {
        return templateString.hashCode();
    }
}
