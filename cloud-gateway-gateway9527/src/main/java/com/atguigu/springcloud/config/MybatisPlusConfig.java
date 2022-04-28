package com.atguigu.springcloud.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan("com.atguigu.springcloud.mapper")
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
	
	@Bean("mybatisSqlSession")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource,
                ResourceLoader resourceLoader,
                GlobalConfiguration globalConfiguration, ApplicationContext applicationContext) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        // 设置Mapper.xml扫描路径
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        sqlSessionFactory.setTypeAliasesPackage(
                    "com.atguigu.springcloud.entity");
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.setConfiguration(configuration);
        PaginationInterceptor pagination = new PaginationInterceptor();
        pagination.setLocalPage(true);
        OptimisticLockerInterceptor optLock = new OptimisticLockerInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{
                    pagination,
                    optLock/*,
                           new PerformanceInterceptor()*/
        });
        // globalConfiguration.setMetaObjectHandler(new H2MetaObjectHandler());
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(
                    new LogicSqlInjector());
        conf.setLogicDeleteValue("1");
        conf.setLogicNotDeleteValue("0");
        conf.setIdType(2);
        // 设置updateById的字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断
        conf.setFieldStrategy(2);
        // #刷新mapper 调试用
        conf.setRefresh(true);
        return conf;
    }

}
