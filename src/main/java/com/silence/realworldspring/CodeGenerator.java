package com.silence.realworldspring;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.baomidou.mybatisplus.generator.config.TemplateType.CONTROLLER;

public class CodeGenerator {
    public static void main(String[] args) throws IOException {
        Map<String,String> map = getDatabaseSourceConfig();
        String url = map.get("url");
        String username = map.get("username");
        String password = map.get("password");
        DataSourceConfig dsc = new DataSourceConfig.Builder(url, username, password).build();

        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent("com.silence.realworldspring")
                .moduleName("persistent")
                .build();

        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .entityBuilder()
                .enableLombok()
                .enableTableFieldAnnotation()
                .enableColumnConstant()
                .enableChainModel()
                .columnNaming(NamingStrategy.underline_to_camel)
                .build();

        TemplateConfig templateConfig = new TemplateConfig
                .Builder()
                .build()
                .disable(CONTROLLER);

        AutoGenerator mpg = new AutoGenerator(dsc)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .template(templateConfig);

        String projectPath = System.getProperty("user.dir");

        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                .outputDir(projectPath + "/src/main/java")
                .author("silence_zhpf")
                .build();


        mpg.global(globalConfig);
        mpg.execute();
    }

    private static Map<String,String> getDatabaseSourceConfig() throws IOException {
        Map<String,String> map = new HashMap<>();
        Resource resource = new ClassPathResource("application.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        String url = props.getProperty("spring.datasource.url");
        String username = props.getProperty("spring.datasource.username");
        String password = props.getProperty("spring.datasource.password");
        map.put("url",url);
        map.put("username",username);
        map.put("password",password);
        return map;
    }

}
