package com.golfzon.newgm2.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web Admin Web Configuration
 * com.golfzon.newgm2.infra.config GmWebConfig.java
 * @author	sjisbmoc
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisbmoc	최초생성
 * 
 * </pre>
 */
@Configuration
@EnableWebMvc
@EnableAsync
public class GmWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/static/webjars/", "classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/static/", "classpath:/META-INF/resources/");
	}

//	@Bean
//	public FilterRegistrationBean<RequestBodyLoggingFilter> getFilterRegistrationBean() {
//		FilterRegistrationBean<RequestBodyLoggingFilter> registrationBean = new FilterRegistrationBean<RequestBodyLoggingFilter>(new RequestBodyLoggingFilter());
//		return registrationBean;
//	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
//		return restTemplateBuilder
//			// 로깅 인터셉터에서 Stream을 소비하므로 BufferingClientHttpRequestFactory 을 꼭 써야한다.
//			.requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
//			// 타임아웃 설정 (ms 단위)
//			.setConnectTimeout(CommonConstants.CONNECT_TIMEOUT)
//			.setReadTimeout(CommonConstants.READ_TIMEOUT)
//			// UTF-8 인코딩으로 메시지 컨버터 추가
//			.additionalMessageConverters(new StringHttpMessageConverter(CommonConstants.CHARSET))
//			// 로깅 인터셉터 설정
//			.additionalInterceptors(new RestTemplateLoggingRequestInterceptor()) .build();
//	}

//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.favorPathExtension(false)
//		        .favorParameter(true)
//		        .defaultContentType(MediaType.APPLICATION_JSON)
//				.mediaType("xml"	,MediaType.APPLICATION_XML)
//				.mediaType("json"	,MediaType.APPLICATION_JSON);
//	}

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false)
				.favorParameter(true)
				.parameterName("mediaType")
				.ignoreAcceptHeader(true)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml"	,MediaType.APPLICATION_XML)
				.mediaType("json"	,MediaType.APPLICATION_XML);
	}

	/**
	 * Async Thread Pool
	 * @param
	 * @return	TaskExecutor
	 * @exception
	 */
	@Bean(name="asyncTaskExecutor")
	public TaskExecutor taskAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(100);
		taskExecutor.setQueueCapacity(600);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setThreadNamePrefix("async-task-executor-");
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(3 * 60 * 1000);	// 3 분
		configurer.registerCallableInterceptors(timeoutInterceptor());
	}

	@Bean
	public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
		return new TimeoutCallableProcessingInterceptor();
	}
}















