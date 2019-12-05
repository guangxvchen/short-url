package com.url.shorturl.common.codeGenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author chenguangxu
 * @create 2019/9/4 14:34
 */
public class MyBatisPlusGeneratorToJpa {
    /**
     * 使用前修改
     *  2 数据源
     *  3 对应数据库表
     *  4 对应的模块名称 和 包路径
     */

    public static void main(String[] args) throws SQLException {

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
        // 作者 自己全局替换 ctrl shift + r
        globalConfig.setAuthor(new Date().toString().replaceAll(" ",""))
                .setDateType(DateType.TIME_PACK)
                // 开启 swagger2 模式
                //.setSwagger2(true)
                // 生成路径
                .setOutputDir(projectPath + "/src/main/java")
                .setOpen(false)
                .setFileOverride(true)
                // 设置生成的service接口的首字母不为I
                .setServiceName("%sService")
                // 设置 Mapper 文件结尾 为 Jpa
                .setMapperName("%sJpa");

        //2. 定义数据源配置
        dataSourceConfig.setUrl("jdbc:mysql://10.1.30.188:3306/metrondb?characterEncoding=utf8&useSSL=false")
                // dsc.setSchemaName("public");
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("OneopsUser")
                .setPassword("Oneops1@#Db");

        //3. 定义策略配置
        // 数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                // 数据库表字段映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 设置为 lombok 模型
                .setEntityLombokModel(true)
                // 生成 restController 注解
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                //指定去除表连接符 / 多个 new String[]{"nor_","dict_"}
                .setTablePrefix("")
                //对应数据库表
                // 需要生成的表可多个 "t_login_log","t_base_log"
                .setInclude(new String[]{"report_cache"})
                // 设置 jpa 继承的包路径 / 代码生成器不能多继承 这里只导入包
                .setSuperMapperClass("org.springframework.data.jpa.repository.JpaSpecificationExecutor;" +
                        "\nimport org.springframework.data.repository.PagingAndSortingRepository")
                .setSuperServiceImplClass("org.apache.metron.rest.common.basecore.base.BaseService");
        // 排除生成的表
        // strategyConfig.setExclude(new String[]{"test"});
        //继承父类id
        // strategyConfig.setSuperEntityColumns("id");

        //4. 定义包名策略配置
        //设置模块名称
        packageConfig.setModuleName("test")
                //包路径
                .setParent("org.apache.metron.rest.oneops")
                // 设置 bean 文件夹名称
                .setEntity("bean")
                // 设置 mapper 文件夹名称
                .setMapper("jpa");

        // 定义模版配置
        templateConfig.setXml(null);

        //5. 定义整合配置
        // 放入 全局配置
        autoGenerator.setGlobalConfig(globalConfig);
        // 放入 数据源
        autoGenerator.setDataSource(dataSourceConfig);
        // 放入模版
        autoGenerator.setTemplate(templateConfig);
        // 放入策略配置
        autoGenerator.setStrategy(strategyConfig.setSuperServiceClass(null));
        // 放入策略配置
        autoGenerator.setPackageInfo(packageConfig);
        // 放入模版实例 / 不可少
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 放入自定义配置
        autoGenerator.setCfg(injectionConfig);

        //6. 执行
        autoGenerator.execute();
    }

}
