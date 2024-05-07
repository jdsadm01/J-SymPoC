package jp.co.jdsnet.common.domain.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("jp.co.jdsnet.common.domain.mapper")
@ComponentScan(basePackages = "jp.co.jdsnet.common.domain.mapper")
public class TestDataSourceConfiguration {

}
