package com.springboot.chapter5.main;

import com.springboot.chapter5.dao.MybatisUserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//定义springboot扫描包路径
@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5"})
//定义jpa接口扫描包路径
@EnableJpaRepositories(basePackages = "com.springboot.chapter5.dao")
//定义实体bean扫描包路径
@EntityScan(basePackages = "com.springboot.chapter5.pojo")
//定义MyBatis的扫描
@MapperScan(
        //指定扫描包
        basePackages = "com.springboot.chapter5.*",
        //指定sqlSessionFactory,如果SQLSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //指定sqlSessionTemplate,将忽略sqlSessionFactory的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //限定扫描接口
        annotationClass = Repository.class
)
public class Chapter5Application {
  /*  @Autowired
    SqlSessionFactory sqlSessionFactory=null;
    public MapperFactoryBean<MybatisUserDao> initMyBatisUserDao(){
        MapperFactoryBean<MybatisUserDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(MybatisUserDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }*/
/*  public MapperScannerConfigurer mapperScannerConfig(){
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      //加载sqlsessionFactory，spring boot会自动生产，sqlSessionFactory实例
      mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
      //定义扫描的包
      mapperScannerConfigurer.setBasePackage("com.springboot.chapter5.*");
      //限定被标注@Repository的接口才被扫描
      mapperScannerConfigurer.setAnnotationClass(Repository.class);
      return mapperScannerConfigurer;
  }*/
    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }
}
