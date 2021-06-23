package com.haiya.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * WebMvcConfig
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    /**
     * 帮助配置HandlerMappings路径匹配选项，例如:
     * - 结尾斜线(/)匹配
     * - 后缀注册
     * - 路径匹配
     * - 路径助手
     * 已配置的路径匹配器和路径助手实例在下列对象中共享:
     * - RequestMappings
     * - ViewControllerMappings
     * - ResourcesMappings
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        logger.info("configurePathMatch: ----------------------------");
        WebMvcConfigurer.super.configurePathMatch(configurer);
    }

    /**
     * 配置内容协商选项
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        logger.info("configureContentNegotiation: ----------------------------");
        WebMvcConfigurer.super.configureContentNegotiation(configurer);
    }

    /**
     * 配置异步请求处理选项
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        logger.info("configureAsyncSupport: ----------------------------");
        WebMvcConfigurer.super.configureAsyncSupport(configurer);
    }

    /**
     * 配置一个委派处理器将未处理的请求转发给Serverlet容器的默认servlet。
     * 常见的用例是当DispatcherServlet映射到"/", 覆盖Servlet容器的默认静态资源处理。
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        logger.info("configureDefaultServletHandling: ----------------------------");
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
    }

    /**
     * 向默认注册的转化器和格式器重添加新的转化器和格式器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        logger.info("addFormatters: ----------------------------");
        WebMvcConfigurer.super.addFormatters(registry);
    }

    /**
     * 为控制器前置或后置处理方法调用和资源处理器请求添加Spring MVC生命周期拦截器。
     * 拦截器可以注册应用到所有请求或者仅限于某些特定URL模式的请求。
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("addInterceptors: ----------------------------");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 添加静态资源服务的处理器
     * 这些静态资源可能位于web应用根目录、classpath等下面特定位置的图片、js、css文件。
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers: ----------------------------");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * 配置跨域请求处理(CORS cross origin requests processing)
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("addCorsMappings: ----------------------------");
        WebMvcConfigurer.super.addCorsMappings(registry);
    }

    /**
     * 配置简单的自动控制器，带有预先配置的响应码和呈现响应体的视图。
     *
     * 这对于那些无需自定义控制器逻辑的场景非常有用:
     * - 呈现首页
     * - 执行简单的网站URL重定向
     * - 返回一个带有404状态的HTML页面
     * - 返回不含内容的204页面
     * - 等等......
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        logger.info("addViewControllers: ----------------------------");
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /**
     * 配置视图解析器配置，将从控制器返回的基于Spring的视图名字翻译为具体的org.springframework.web.servlet.View实现来执行呈现。
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        logger.info("configureViewResolvers: ----------------------------");
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }

    /**
     * 添加解析器以支持自定义控制器方法参数类型。
     * 该方法不会覆盖内置的解析处理器方法参数。如果需要自定义内置参数解析的支持，需要直接配置RequestMappingHandlerAdapter。
     *
     * @param resolvers 最初是一个空列表
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        logger.info("addArgumentResolvers: ----------------------------");
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    /**
     * 添加处理器以支持自定义控制器方法返回值类型。
     * 使用这个方法不会覆盖内置的处理返回值支持。要自定义内置支持处理返回值，需要直接配置RequestMappingHandlerAdapter。
     * @param handlers 最初是一个空列表
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        logger.info("addReturnValueHandlers: ----------------------------");
        WebMvcConfigurer.super.addReturnValueHandlers(handlers);
    }

    /**
     * 配置读写请求和响应体的时候使用的HttpMessageConverters。
     * 如果没有添加converters列表，会默认注册一组converters。
     * 注意这个方法会将传入的列表添加到转换器中，默认注册的转换器列表就会被关闭。
     * 如果只是简单的向默认注册器中添加一个转换器，考虑使用extendMessageConverters(List)方法。
     *
     * @param converters 最初是一个空的converters列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.info("configureMessageConverters: ----------------------------");
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }

    /**
     * 在转换器列表已经配置之后，对其进行扩展或修改。
     * 这个方法对于向默认注册的转换器列表中添加自定义转换器的场景非常有用。
     *
     * @param converters 要去扩展的配置的converters列表
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.info("extendMessageConverters: ----------------------------");
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }

    /**
     * 配置异常解析器。
     * 给定的列表开始是空的。如果保持为空，框架会配置一个默认的解析器集合，可以查看WebMvcConfigurationSupport.addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)。
     * 否则如果向列表加入了任意的异常解析器，应用程序将有效的接管，并且必须提供完全初始化的异常解析器。
     * 相应的，你可以使用extendHandlerExceptionResolvers(List)，允许你扩展或修改默认配置的异常处理器列表。
     *
     * @param resolvers 最初是一个空列表
     * 也可以参照
     * - extendHandlerExceptionResolvers(List),
     * - WebMvcConfigurationSupport.addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        logger.info("configureHandlerExceptionResolvers: ----------------------------");
        WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
    }

    /**
     * 扩展或修改默认配置的异常解析器列表。
     * 该方法对于只是向默认列表添加自定义异常处理器的情况非常有用，它不会影响默认配置的异常处理器列表。
     *
     * 也可以参照: WebMvcConfigurationSupport.addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)
     * @param resolvers 要扩展的已配置解析器列表
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        logger.info("extendHandlerExceptionResolvers: ----------------------------");
        WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
    }

    /**
     * 提供一个自定义Validator, 而不适用默认创建的那个。
     * 返回值为null, 我们就使用默认的Validator。
     * @return
     */
    @Override
    public Validator getValidator() {
        logger.info("getValidator: ----------------------------");
        return WebMvcConfigurer.super.getValidator();
    }

    /**
     * 提供一个自定义MessageCodesResolver来从数据绑定和验证错误码来构建消息码。
     * 返回值为null, 保持使用默认的MessageCodesResolver。
     * @return
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        logger.info("getMessageCodesResolver: ----------------------------");
        return WebMvcConfigurer.super.getMessageCodesResolver();
    }
}
