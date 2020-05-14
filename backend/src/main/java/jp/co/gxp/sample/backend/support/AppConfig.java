package jp.co.gxp.sample.backend.support;

import jp.co.gxp.sample.backend.controller.Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Controller.class, Support.class})
public class AppConfig {
}
