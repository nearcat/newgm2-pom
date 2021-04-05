package com.golfzon.newgm2.infra.config.mvc.service;

import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.golfzon.newgm2.infra.config.common.consts.InfraConsts;

/**
 * Defualt TimeZone Service
 * com.golfzon.newgm2.infra.config.mvc.service TimeZoneService.java
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
@Component
public class TimeZoneService {

	/**
	 * 타임존 서비스 생성자
	 * @param
	 * @return
	 */
	public TimeZoneService() {
		TimeZone.setDefault(TimeZone.getTimeZone(InfraConsts.INFRA_TIME_ZONE));
	}
}
