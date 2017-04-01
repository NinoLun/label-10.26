/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.score.api.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ccz
 * @since 2015-12-19 16:16
 */
@SuppressWarnings("ALL")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private UserSecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor).addPathPatterns("/user/**");//配置登录拦截器拦截路径
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/bak/**").addResourceLocations("classpath:/bak/");
        registry.addResourceHandler("/imagecodedir/**").addResourceLocations("/imagecodedir/");
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setSessionTimeout(1800);//单位为S
            }
        };
    }


//
//    @Bean(name = "asyncLoadTestFactoryBean")
//    public AsyncLoadFactoryBean initAsyncLoadFactoryBean(){
//        AsyncLoadFactoryBean asyncLoadFactoryBean = new AsyncLoadFactoryBean();
//        asyncLoadFactoryBean.setTargetClass(com.score.api.service.SyncProxyService.class);
//        asyncLoadFactoryBean.setTarget(com.score.api.service.SyncProxyService.class);
//        AsyncLoadExecutor asyncLoadExecutor = new AsyncLoadExecutor();
//        asyncLoadExecutor.setPoolSize(10);
//        asyncLoadExecutor.setAcceptCount(20);
//        asyncLoadExecutor.setMode("CALLSRUN");
//        asyncLoadFactoryBean.setExecutor(asyncLoadExecutor);
//
//        AsyncLoadConfig asyncLoadConfig = new AsyncLoadConfig();
//        asyncLoadConfig.setDefaultTimeout(Long.valueOf(3000));
//        asyncLoadConfig.setNeedThreadLocalSupport(false);
//        asyncLoadConfig.setNeedBarrierSupport(false);
//        Map<AsyncLoadMethodMatch,Long> map = Maps.newHashMap();
//        AsyncLoadPerl5RegexpMethodMatcher asyncLoadMethodMatch = new AsyncLoadPerl5RegexpMethodMatcher();
//        asyncLoadMethodMatch.setPattern("(.*)RemoteModel(.*)");
//        asyncLoadMethodMatch.setExcludedPattern("(.*)listRemoteModel(.*)");
//        asyncLoadMethodMatch.setExcludeOveride(false);
//        map.put(asyncLoadMethodMatch,Long.valueOf(2000));
//        asyncLoadConfig.setMatches(map);
//        asyncLoadFactoryBean.setConfig(asyncLoadConfig);
//        return asyncLoadFactoryBean;
//    }



    /**
     * 设置自定义过滤器
     *
     * @param myFilter
     * @return
     */
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean(MyFilter myFilter){
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(myFilter);
//		filterRegistrationBean.setEnabled(true);
//		filterRegistrationBean.addUrlPatterns("/*");
//		return filterRegistrationBean;
//	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.freeMarker().cache(false);
//    }

//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/");
//        return configurer;
//    }


//    @Bean
//    public ViewResolver viewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".ftl");
//        resolver.setContentType("text/html; charset=UTF-8");
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
//        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
//        factory.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
//        factory.setDefaultEncoding("UTF-8");
//        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
//        result.setConfiguration(factory.createConfiguration());
//        return result;
//    }
}
