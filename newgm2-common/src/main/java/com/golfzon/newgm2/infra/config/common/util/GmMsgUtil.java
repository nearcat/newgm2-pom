package com.golfzon.newgm2.infra.config.common.util;

import com.golfzon.newgm2.infra.config.common.domain.GmWapper;

/**
 * 메시지 Util com.golfzon.newgm2.infra.config.common.util GmMsgUtil.java
 * 
 * @author sjisbmoc
 * @since
 * @version 1.0
 * @see
 * 
 *      <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisbmoc	최초생성
 * 
 *      </pre>
 */
public class GmMsgUtil {

	/**
	 * 메시지 정보 생성
	 * 
	 * @MethodName getGmWapper
	 * @param rltCd
	 * @return GmWapper
	 * @exception
	 */
	public static GmWapper getGmWapper(String rltCd) {
		return getGmWapper(rltCd, null, null);
	}

	/**
	 * 메시지 정보 생성
	 * 
	 * @MethodName getGmWapper
	 * @param rltCd
	 * @param rltMsg
	 * @return GmWapper
	 * @exception
	 */
	public static GmWapper getGmWapper(String rltCd, String rltMsg) {
		return getGmWapper(rltCd, rltMsg, null);
	}

	/**
	 * 메시지 정보 생성
	 * 
	 * @MethodName getGmWapper
	 * @param rltCd
	 * @param rltMsg
	 * @param rltObj
	 * @returnGmWapper
	 * @exception
	 */
	public static GmWapper getGmWapper(String rltCd, String rltMsg, Object rltObj) {
		return new GmWapper(rltCd, rltMsg, rltObj);
	}

}
