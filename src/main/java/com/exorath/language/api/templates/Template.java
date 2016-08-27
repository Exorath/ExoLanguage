package com.exorath.language.api.templates;

import com.exorath.language.impl.templates.ITemplate;

/**
 * Created by toonsev on 8/26/2016.
 */
public interface Template {
    String getTemplateString();

    static Template create(String templateString){
        return new ITemplate(templateString);
    }
}
