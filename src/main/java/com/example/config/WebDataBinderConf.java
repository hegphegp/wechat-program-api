package com.example.config;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NumberUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;

@Configuration
public class WebDataBinderConf {
    // 配置 @RequestParam 字段取值 转 Date
    @Bean
    public Converter<String, Date> toDate() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (NumberUtil.isLong(source)) {
                    return new Date(Convert.toLong(source));
                } else if (StringUtils.hasText(source)) {
                    Date date = Convert.convert(Date.class, source);
                    if (date==null) {
                        throw new RuntimeException("[ "+source+" ] can't convert to Date.class ");
                    }
                    return date;
                } else return null;
            }
        };
    }

    // 配置 @RequestParam 字段取值 转 Timestamp
    @Bean
    public Converter<String, Timestamp> toTimestamp() {
        return new Converter<String, Timestamp>() {
            @Override
            public Timestamp convert(String source) {
                if (NumberUtil.isLong(source)) {
                    return new Timestamp(Convert.toLong(source));
                } else {
                    return Convert.convert(Timestamp.class, source);
                }
            }
        };
    }

}