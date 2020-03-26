package com.demo.sp.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "alias")
public class AliasEntity
{
    private HashMap<String, String> aliasMap;

    public HashMap<String, String> getAliasMap()
    {
        return aliasMap;
    }

    public void setAliasMap(HashMap<String, String> aliasMap)
    {
        this.aliasMap = aliasMap;
    }

    /**
     * 根据描述获取该会员对应的别名
     * @param desc
     * @return
     */
    public String getEntity(String desc)
    {
        return aliasMap.get(desc);
    }
}
