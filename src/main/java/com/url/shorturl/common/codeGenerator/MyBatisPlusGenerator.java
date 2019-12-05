package com.url.shorturl.common.codeGenerator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguangxu
 * @date 2019-02-27 15:39:14
 * 代码生成器
 * https://mp.baomidou.com/guide/generator.html
 *
 * <p>
 * 读取控制台内容
 * </p>
 */

/**
 * 修改
 *
 * @author chenguangxu
 * @return file
 * @date 2019/9/4 15:16
 */

public class MyBatisPlusGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String projectPath = System.getProperty("user.dir");

        //1. 定义全局配置
        // 作者
        globalConfig.setAuthor("chenguangxu")
                .setDateType(DateType.TIME_PACK)
                // 生成路径
                .setOutputDir(projectPath + "/src/main/java")
                .setOpen(false)
                // 设置生成的service接口的首字母不为I
                .setServiceName("%sService");
        // 设置 Mapper 文件结尾 为 Jpa 默认为 mapper
        //.setMapperName("%sJpa");

        //2. 定义数据源配置
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/api?characterEncoding=utf8&useSSL=false")
                // dsc.setSchemaName("public");
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("chen")
                .setPassword("chen");

        //3. 定义策略配置
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                //去除表连接符 / 多个 new String[]{"nor_","dict_"}
                .setTablePrefix("_")
                // 需要生成的表可多个 "t_login_log","t_base_log"
                .setInclude(new String[]{"short_url"});
        // 继承的包路径
        //.setSuperMapperClass("org.springframework.data.jpa.repository.JpaRepository");
        // 排除生成的表
        // strategyConfig.setExclude(new String[]{"test"});
        //继承父类id
        // strategyConfig.setSuperEntityColumns("id");

        //4. 定义包名策略配置
        //设置模块名称
        packageConfig.setModuleName("url")
                //包路径
                .setParent("com.url.shorturl");
        // 设置 bean 文件夹名称
        //.setEntity("")
        // 设置 mapper 文件夹名称
        //.setMapper("");

        // 定义模版配置
        templateConfig.setXml(null);

        //自定义实现
        // mybatis
        // 生成基本的resultMap
        globalConfig.setBaseResultMap(true)
                // 生成基本的SQL片段
                .setBaseColumnList(true);
        // 用于配置模版输出 / 是否输出 mapper.xml 文件
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigs.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //自己生产代码需要修改的地方
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);

        //5. 定义整合配置
        // 放入 全局配置
        autoGenerator.setGlobalConfig(globalConfig);
        // 放入 数据源
        autoGenerator.setDataSource(dataSourceConfig);
        // 放入模版
        autoGenerator.setTemplate(templateConfig);
        // 放入策略配置
        autoGenerator.setStrategy(strategyConfig);
        // 放入策略配置
        autoGenerator.setPackageInfo(packageConfig);
        // 放入模版实例 / 不可少?
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 放入自定义配置
        autoGenerator.setCfg(injectionConfig);

        //6. 执行
        autoGenerator.execute();
    }

}
