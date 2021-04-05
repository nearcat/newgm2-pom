package com.golfzon.newgm2.infra.config.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.golfzon.newgm2.infra.config.common.domain.GmWapper;
import com.golfzon.newgm2.infra.config.common.util.GmMsgUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GmCommonController {

	@Value("${spring.profiles}")
	private	String	profiles;

	@RequestMapping(value="/common/check/health"	,method={RequestMethod.GET, RequestMethod.POST})
	public GmWapper checkHealthJson(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		log.trace("####################################################################################################");
//		log.debug(LogUtil.getMethodInfo(new Throwable()));
//		log.trace("####################################################################################################");

		return GmMsgUtil.getGmWapper("OK");
	}

	@RequestMapping(value="/common/session/logout"	,method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Object testLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		log.trace("####################################################################################################");
//		log.debug(LogUtil.getMethodInfo(new Throwable()));
//		log.trace("####################################################################################################");

		request.getSession().removeAttribute("LoginVo");

		return "logout";
	}

	@RequestMapping(value="/common/check/mode"	,method={RequestMethod.GET, RequestMethod.POST})
	public GmWapper currentVersion(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		log.trace("####################################################################################################");
//		log.debug(LogUtil.getMethodInfo(new Throwable()));
//		log.trace("####################################################################################################");

		return GmMsgUtil.getGmWapper("OK", profiles);
	}
}