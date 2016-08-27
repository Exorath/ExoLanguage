package com.exorath.language.impl;

import com.exorath.language.api.LanguageAPI;
import com.exorath.language.api.Message;
import com.exorath.language.api.templates.LanguagePack;
import com.exorath.language.api.templates.LanguagesPack;
import com.exorath.language.api.templates.Template;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by toonsev on 8/23/2016.
 */
public class ILanguageAPI implements LanguageAPI {
    private Set<LanguagesPack> languagesPacks = new HashSet<>();
    //If necessary we can import all templates to a central HashMap for faster access.
    @Override
    public void addLanguagesPack(LanguagesPack languagesPack) {
        languagesPacks.add(languagesPack);
    }


    @Override
    public String getTranslated(Message message) {
        for(LanguagesPack languagesPack : languagesPacks){
            LanguagePack languagePack = languagesPack.getTemplatePacks().get(message.getLanguage());
            if(languagePack != null)
                if(languagePack.getTemplates().containsKey(message.getMessageKey())){
                    Template template = languagePack.getTemplates().get(message.getMessageKey());
                    return fillParameters(message, template.getTemplateString());
                }
        }
        return fillParameters(message, message.getDefaultTemplate());
    }

    protected String fillParameters(Message message, String templateString){
        for(Map.Entry<String, Object> param : message.getParameters().entrySet())
            templateString = templateString.replaceAll("<" + escapeRE(param.getKey()) + ">", param.getValue().toString());
        return templateString;
    }
    public static String escapeRE(String str) {
        Pattern escaper = Pattern.compile("([^a-zA-z0-9])");
        return escaper.matcher(str).replaceAll("\\\\$1");
    }
}
