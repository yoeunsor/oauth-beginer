/**
 * 
 */
package com.sokkheang.huo.common.config.oauth2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Sokkheang Huo
 * @version Id: 
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "com.sokkheang.huo.common.api.*" })
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {

}
